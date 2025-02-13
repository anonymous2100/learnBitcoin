package com.ctgu.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.bitcoinj.core.Base58;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.params.MainNetParams;
import org.bouncycastle.crypto.digests.RIPEMD160Digest;
import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.math.ec.ECPoint;

import lombok.extern.slf4j.Slf4j;

/**
 * bitcoin地址工具类
 */
@Slf4j
public class BitcoinUtils
{
	/**
	 * 获取私钥
	 * 
	 * @return
	 */
	public static String getRandomPrivateKey()
	{
		SecureRandom secureRandom = new SecureRandom();
		byte[] seed = new byte[32];
		secureRandom.nextBytes(seed);
		String privateECDSAKey = HexUtils.encodeHex(seed);
		log.info("get random Private ECDSA Key=" + privateECDSAKey);
		return privateECDSAKey;
	}

	/**
	 * 获取公钥
	 * 
	 * @return
	 */
	public static String getPublicKey(String privateECDSAKey)
	{
		byte[] privateKeyBytes = HexUtils.decodeHex(privateECDSAKey);
		ECNamedCurveParameterSpec spec = ECNamedCurveTable.getParameterSpec("secp256k1");
		ECPoint pointQ = spec.getG().multiply(new BigInteger(1, privateKeyBytes));
		byte[] publicKeyBytes = pointQ.getEncoded(false);
		String publicECDSAKey = HexUtils.encodeHex(publicKeyBytes);
		log.info("get Public ECDSA Key=" + publicECDSAKey);
		return publicECDSAKey;
	}

	/**
	 * 根据非压缩公钥获取压缩公钥
	 * 
	 * @param userPublicKey
	 *            非压缩公钥
	 * @return
	 */
	public static String getCompressedPublicKey(String userPublicKey)
	{
		String publicKey = null;
		// 非压缩公钥(130位十六进制 2+64+64), 前缀04+x坐标+y坐标
		if (userPublicKey.length() == 130)
		{
			publicKey = userPublicKey.substring(2, userPublicKey.length());
		}
		// 压缩公钥（66位十六进制 2+64） 前缀03+x(如果y是奇数)，前缀02+x(如果y是偶数)
		else if (userPublicKey.length() == 128)
		{
			publicKey = userPublicKey;
		}
		else
		{
			throw new RuntimeException("public key is invalid");
		}
		// 获得x坐标
		String keyX = publicKey.substring(0, publicKey.length() / 2);
		// 获得y坐标
		String keyY = publicKey.substring(publicKey.length() / 2, publicKey.length());
		// 判断y的奇偶
		String keyYtoIntString = keyY.substring(keyY.length() - 1);
		String header;
		if ((Integer.parseInt(keyYtoIntString, 16) & 1) == 0)
		{
			header = "02";
		}
		else
		{
			header = "03";
		}
		// 得到压缩公钥: 前缀03+x(如果y是奇数)，前缀02+x(如果y是偶数)
		return header + keyX;
	}

	/**
	 * 计算给定字符串的SHA-256
	 * 
	 * @return
	 */
	public static byte[] getHash256(String publicECDSAKey)
	{
		byte[] publicKeyBytes2 = HexUtils.decodeHex(publicECDSAKey);
		byte[] step1Sha256 = null;
		try
		{
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			step1Sha256 = digest.digest(publicKeyBytes2);
			String publicKeyHash = HexUtils.encodeHex(step1Sha256);
			log.info("get {} SHA-256 :{} ", publicECDSAKey, publicKeyHash);
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		return step1Sha256;
	}

	/**
	 * 计算给定字符数组的RIPEMD160哈希值
	 * 
	 * @return
	 */
	public static String getRipemd160Hash(byte[] publicKeyHashBytes)
	{
		RIPEMD160Digest d = new RIPEMD160Digest();
		d.update(publicKeyHashBytes, 0, publicKeyHashBytes.length);
		byte[] bytesAddr = new byte[d.getDigestSize()];
		d.doFinal(bytesAddr, 0);
		String ripemd160Hash = HexUtils.encodeHex(bytesAddr);
		log.info("get {} RIPEMD-160 Hash : {}", publicKeyHashBytes, ripemd160Hash);
		return ripemd160Hash;
	}

	/**
	 * 获取可以导入到钱包格式的私钥（WIF格式）
	 * 
	 * @param privateKey
	 *            非压缩格式私钥
	 * @return
	 */
	public static String getWIFPrivateKey(String privateKey)
	{
		log.info("1-私钥：" + privateKey);

		String addVersionString = new StringBuffer("80").append(privateKey).toString();
		log.info("2-增加0x80版本号：" + addVersionString);

		byte[] hash256OfAddVersion2 = getHash256(addVersionString);
		log.info("3-对2得到的结果进行sha-256哈希运算：" + HexUtils.encodeHex(hash256OfAddVersion2));

		byte[] hash256OfAddVersion3 = getHash256(HexUtils.encodeHex(hash256OfAddVersion2));
		log.info("4-再次对3得到的结果进行sha-256哈希运算：" + HexUtils.encodeHex(hash256OfAddVersion3));

		String first4bytes = HexUtils.encodeHex(hash256OfAddVersion3).substring(0, 8);
		log.info("5-取4得到的结果的前四个字节作为效验位：" + first4bytes);

		String addResult = addVersionString + first4bytes;
		log.info("6-将5得到的效验位加在2的结果的后面：" + addResult);

		String base58Result = Base58.encode(HexUtils.decodeHex(addResult));
		log.info("7-使用base58对6的结果进行编码：" + base58Result);

		return base58Result;
	}

	/**
	 * @Description: 随机生成一个比特币地址
	 * @return String 生成的比特币地址
	 * @throws NoSuchAlgorithmException
	 */
	public static String getRandomBTCAddress() throws NoSuchAlgorithmException
	{
		/**
		 * 第一步（获取私钥），随机选取一个32字节的数、大小介于1 ~ 0xFFFF FFFF FFFF FFFF FFFF FFFF FFFF FFFE BAAE DCE6 AF48 A03B BFD2 5E8C D036
		 * 4141之间，作为私钥。
		 */
		SecureRandom secureRandom = new SecureRandom();
		byte[] seed = new byte[32];
		secureRandom.nextBytes(seed);
		String privateECDSAKey = HexUtils.encodeHex(seed);
		log.info("Step1-Private ECDSA Key=" + privateECDSAKey);

		/**
		 * 第二步（获取公钥），使用椭圆曲线加密算法（ECDSA-secp256k1）计算私钥所对应的非压缩公钥。 (共65字节， 1字节 0x04, 32字节为x坐标，32字节为y坐标）
		 */
		byte[] privateKeyBytes = HexUtils.decodeHex(privateECDSAKey);
		ECNamedCurveParameterSpec spec = ECNamedCurveTable.getParameterSpec("secp256k1");
		ECPoint pointQ = spec.getG().multiply(new BigInteger(1, privateKeyBytes));
		byte[] publicKeyBytes = pointQ.getEncoded(false);
		String publicECDSAKey = HexUtils.encodeHex(publicKeyBytes);
		log.info("Step2-Public ECDSA Key=" + publicECDSAKey);

		/**
		 * 第三步，计算公钥的 SHA-256 哈希值
		 */
		byte[] publicKeyBytes2 = HexUtils.decodeHex(publicECDSAKey);
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] step1Sha256 = digest.digest(publicKeyBytes2);
		String step2String = HexUtils.encodeHex(step1Sha256);
		log.info("Step3 - SHA-256 hash of 1=" + step2String);

		/**
		 * 第四步，取第三步结果，计算 RIPEMD-160 哈希值
		 */
		RIPEMD160Digest d = new RIPEMD160Digest();
		d.update(step1Sha256, 0, step1Sha256.length);
		byte[] bytesAddr = new byte[d.getDigestSize()];
		d.doFinal(bytesAddr, 0);
		String step2Ripemd160Hash = HexUtils.encodeHex(bytesAddr);
		log.info("Step4 - RIPEMD-160 Hash of 2=" + step2Ripemd160Hash);

		/**
		 * 第五步，取第四步结果，前面加入地址版本号（比特币主网版本号“0x00”）
		 */
		String networkBytesTo3 = "00" + step2Ripemd160Hash;
		String step4String = networkBytesTo3;
		log.info("Step5 - Adding network bytes to 3=" + step4String);

		/**
		 * 第六步，取第五步结果，计算 SHA-256 哈希值
		 */
		byte[] sha256HashOf4 = digest.digest(HexUtils.decodeHex(networkBytesTo3));
		String step5String = HexUtils.encodeHex(sha256HashOf4);
		log.info("Step6 - SHA-256 hash of 4=" + step5String);

		/**
		 * 第七步，取第六步结果，再计算一下 SHA-256 哈希值
		 */
		byte[] sha256HashOf5 = digest.digest(sha256HashOf4);
		String step6String = HexUtils.encodeHex(sha256HashOf5);
		log.info("Step7 - SHA-256 hash of 5=" + step6String);

		/**
		 * 第八步，取第七步结果的前4个字节（8位十六进制）
		 */
		String firstFourBytesOf6 = step6String.substring(0, 8);
		String step7String = firstFourBytesOf6;
		log.info("Step8 - First four bytes of 6=" + step7String);

		/**
		 * 第九步，把这4个字节加在第五步的结果后面，作为校验（这就是比特币地址的16进制形态）
		 */
		String step8String = networkBytesTo3 + firstFourBytesOf6;
		log.info("Step9 - Adding 7 at the end of 4=" + step8String);

		/**
		 * 第十步（获取地址），用base58表示法变换一下地址（这就是最常见的比特币地址形态）
		 */
		String step9String = Base58.encode(HexUtils.decodeHex(step8String));
		log.info("Step10 - Base58 encoding of 8=" + step9String);
		return step9String;
	}

	public static void demoBTC()
	{
		NetworkParameters params = MainNetParams.get();// 生成正式链地址用这个
		// NetworkParameters params = TestNet2Params.get();//test2
		// NetworkParameters params = TestNet3Params.get();//test3
		// 生成地址
		ECKey key = new ECKey();
		log.info("地址：" + key.toAddress(params).toString());
		log.info("公钥：" + key.getPublicKeyAsHex());
		log.info("私钥（非压缩，不可导入钱包）：" + key.getPrivateKeyAsHex());
		log.info("私钥（压缩格式，可导入钱包）：" + key.getPrivateKeyAsWiF(params));

		// 根据上面不能导进IMtoken的私钥获得可以导进IMtoken的私钥：
		String privateKey = key.getPrivateKeyAsHex();
		log.info("原始格式私钥：" + privateKey);
		BigInteger priKey = new BigInteger(privateKey, 16);
		key = ECKey.fromPrivate(priKey);
		log.info("WIF私钥：" + key.getPrivateKeyAsWiF(params));
		log.info("地址：" + key.toAddress(params));
	}

	public static void main(String[] args) throws NoSuchAlgorithmException
	{
		getRandomBTCAddress();
		// demoBTC();
		// getWIFPrivateKey("0C28FCA386C7A227600B2FE50B7CAE11EC86D3BF1FBE471BE89827E19D72AA1D");
	}
}
