package com.ctgu.ui.form;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.bitcoinj.core.Base58;

import com.ctgu.constant.Constants;
import com.ctgu.ui.dialog.ToastFrame;
import com.ctgu.util.BitcoinUtils;
import com.ctgu.util.HexUtils;
import com.ctgu.util.SystemUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BitcoinAddressPanel2 extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JTextField textField00;
	private JTextField textField01;
	private JTextField textField10;
	private JTextField textField11;
	private JTextField textField20;
	private JTextField textField21;
	private JTextField textField30;
	private JTextField textField31;
	private JTextField textField40;
	private JTextField textField41;
	private JTextField textField50;
	private JTextField textField51;
	private JTextField textField60;
	private JTextField textField61;
	private JTextField textField70;
	private JTextField textField71;
	private JTextField textField80;
	private JTextField textField81;
	private JTextField textField90;
	private JTextField textField91;

	public static final int LAYOUT_WIDTH = 1000;
	public static final int LAYOUT_HEIGHT = 30;
	public static final int SEPARATOR_WIDTH = LAYOUT_WIDTH;
	public static final int SEPARATOR_HEIGHT = 10;
	public static final int COMPONENT_HEIGHT = LAYOUT_HEIGHT;
	public static final int GAP_HEIGHT = SEPARATOR_HEIGHT / 2;
	public static final int LAYOUT_MARGIN = 20;

	public BitcoinAddressPanel2()
	{
		this.setLayout(null);

		JButton btnRandomNew = new JButton("随机生成");
		btnRandomNew.setBounds(LAYOUT_MARGIN, 10, 160, COMPONENT_HEIGHT);
		btnRandomNew.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				initUIComponent(BitcoinUtils.getRandomPrivateKey());
			}
		});
		add(btnRandomNew);

		JButton btnCalculate = new JButton("根据私钥计算地址");
		btnCalculate.setBounds(LAYOUT_MARGIN * 2 + btnRandomNew.getWidth(), 10, 260, COMPONENT_HEIGHT);
		btnCalculate.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String privateKey = textField00.getText();
				if (privateKey == null || privateKey.length() != 64)
				{
					new ToastFrame("请输入正确的私钥！");
					return;
				}
				initUIComponent(privateKey);
			}
		});
		add(btnCalculate);

		/****************************************** 步骤0-私钥 *********************************************/
		JLabel label0 = new JLabel("步骤0- 私钥（依次为原始格式和钱包导入格式：）");
		label0.setBounds(LAYOUT_MARGIN, COMPONENT_HEIGHT + GAP_HEIGHT, LAYOUT_WIDTH, LAYOUT_HEIGHT);
		add(label0);

		textField00 = new JTextField();
		textField00.setBounds(LAYOUT_MARGIN, label0.getY() + COMPONENT_HEIGHT + GAP_HEIGHT, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		textField00.setColumns(10);
		add(textField00);

		textField01 = new JTextField();
		textField01.setBounds(LAYOUT_MARGIN, textField00.getY() + COMPONENT_HEIGHT + GAP_HEIGHT, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		textField01.setColumns(10);
		textField01.setBackground(Color.LIGHT_GRAY);
		textField01.setEditable(false);
		add(textField01);

		/**************************************** 步骤1-ECDSA公钥 ***********************************************/
		JLabel label1 = new JLabel("步骤1- ECDSA公钥（依次为未压缩格式和压缩格式）");
		label1.setBounds(LAYOUT_MARGIN, textField01.getY() + COMPONENT_HEIGHT + GAP_HEIGHT, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		add(label1);

		textField10 = new JTextField();
		textField10.setBounds(LAYOUT_MARGIN, label1.getY() + COMPONENT_HEIGHT + GAP_HEIGHT, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		textField10.setColumns(10);
		add(textField10);

		textField11 = new JTextField();
		textField11.setBounds(LAYOUT_MARGIN, textField10.getY() + COMPONENT_HEIGHT + GAP_HEIGHT, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		textField11.setColumns(11);
		textField11.setBackground(Color.LIGHT_GRAY);
		textField11.setEditable(false);
		add(textField11);

		/*************************************** 步骤2 - 1的SHA-256哈希值 ************************************************/
		JLabel label2 = new JLabel("步骤2- 计算步骤1的SHA-256哈希值");
		label2.setBounds(LAYOUT_MARGIN, textField11.getY() + COMPONENT_HEIGHT + GAP_HEIGHT, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		add(label2);

		textField20 = new JTextField();
		textField20.setBounds(LAYOUT_MARGIN, label2.getY() + COMPONENT_HEIGHT + GAP_HEIGHT, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		textField20.setColumns(10);
		add(textField20);
		textField21 = new JTextField();
		textField21.setBounds(LAYOUT_MARGIN, textField20.getY() + COMPONENT_HEIGHT + GAP_HEIGHT, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		textField21.setColumns(10);
		textField21.setBackground(Color.LIGHT_GRAY);
		textField21.setEditable(false);
		add(textField21);

		/*************************************** 步骤3- 步骤2的RIPEMD160哈希值 ********************************************/
		JLabel label3 = new JLabel("步骤3- 步骤2的RIPEMD-160哈希值");
		label3.setBounds(LAYOUT_MARGIN, textField21.getY() + COMPONENT_HEIGHT + GAP_HEIGHT, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		add(label3);

		textField30 = new JTextField();
		textField30.setBounds(LAYOUT_MARGIN, label3.getY() + COMPONENT_HEIGHT + GAP_HEIGHT, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		textField30.setColumns(10);
		add(textField30);
		textField31 = new JTextField();
		textField31.setBounds(LAYOUT_MARGIN, textField30.getY() + COMPONENT_HEIGHT + GAP_HEIGHT, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		textField31.setColumns(10);
		textField31.setBackground(Color.LIGHT_GRAY);
		textField31.setEditable(false);
		add(textField31);

		/*************************************** 步骤4- 将网络字节数添加到3 ************************************************/
		JLabel label4 = new JLabel("步骤4- 将网络字节数添加到步骤3的结果");
		label4.setBounds(LAYOUT_MARGIN, textField31.getY() + COMPONENT_HEIGHT + GAP_HEIGHT, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		add(label4);

		textField40 = new JTextField();
		textField40.setColumns(10);
		textField40.setBounds(LAYOUT_MARGIN, label4.getY() + COMPONENT_HEIGHT + GAP_HEIGHT, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		add(textField40);
		textField41 = new JTextField();
		textField41.setColumns(10);
		textField41.setBounds(LAYOUT_MARGIN, textField40.getY() + COMPONENT_HEIGHT + GAP_HEIGHT, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		textField41.setBackground(Color.LIGHT_GRAY);
		textField41.setEditable(false);
		add(textField41);

		/*************************************** 步骤5：4的SHA-256哈希值 ************************************************/
		JLabel label5 = new JLabel("步骤5- 步骤4的SHA-256哈希值");
		label5.setBounds(LAYOUT_MARGIN, textField41.getY() + COMPONENT_HEIGHT + GAP_HEIGHT, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		add(label5);

		textField50 = new JTextField();
		textField50.setColumns(10);
		textField50.setBounds(LAYOUT_MARGIN, label5.getY() + COMPONENT_HEIGHT + GAP_HEIGHT, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		add(textField50);
		textField51 = new JTextField();
		textField51.setColumns(10);
		textField51.setBounds(LAYOUT_MARGIN, textField50.getY() + COMPONENT_HEIGHT + GAP_HEIGHT, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		textField51.setBackground(Color.LIGHT_GRAY);
		textField51.setEditable(false);
		add(textField51);

		/*************************************** 步骤6 - 5的SHA-256哈希值 ************************************************/
		JLabel label6 = new JLabel("步骤6 - 步骤5的SHA-256哈希值");
		label6.setBounds(LAYOUT_MARGIN, textField51.getY() + COMPONENT_HEIGHT + GAP_HEIGHT, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		add(label6);

		textField60 = new JTextField();
		textField60.setColumns(10);
		textField60.setBounds(LAYOUT_MARGIN, label6.getY() + COMPONENT_HEIGHT + GAP_HEIGHT, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		add(textField60);
		textField61 = new JTextField();
		textField61.setColumns(10);
		textField61.setBounds(LAYOUT_MARGIN, textField60.getY() + COMPONENT_HEIGHT + GAP_HEIGHT, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		textField61.setBackground(Color.LIGHT_GRAY);
		textField61.setEditable(false);
		add(textField61);

		/*************************************** 步骤7 - 6的前四个字节 ************************************************/
		JLabel label7 = new JLabel("步骤7 - 步骤6的前四个字节");
		label7.setBounds(LAYOUT_MARGIN, textField61.getY() + COMPONENT_HEIGHT + GAP_HEIGHT, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		add(label7);

		textField70 = new JTextField();
		textField70.setColumns(10);
		textField70.setBounds(LAYOUT_MARGIN, label7.getY() + COMPONENT_HEIGHT + GAP_HEIGHT, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		add(textField70);
		textField71 = new JTextField();
		textField71.setColumns(10);
		textField71.setBounds(LAYOUT_MARGIN, textField70.getY() + COMPONENT_HEIGHT + GAP_HEIGHT, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		textField71.setBackground(Color.LIGHT_GRAY);
		textField71.setEditable(false);
		add(textField71);

		/*************************************** 步骤8- 在4的末尾加7 ************************************************/
		JLabel label8 = new JLabel("步骤8- 在步骤4的末尾追加步骤7");
		label8.setBounds(LAYOUT_MARGIN, textField71.getY() + COMPONENT_HEIGHT + GAP_HEIGHT, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		add(label8);

		textField80 = new JTextField();
		textField80.setColumns(10);
		textField80.setBounds(LAYOUT_MARGIN, label8.getY() + COMPONENT_HEIGHT + GAP_HEIGHT, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		add(textField80);
		textField81 = new JTextField();
		textField81.setColumns(10);
		textField81.setBounds(LAYOUT_MARGIN, textField80.getY() + COMPONENT_HEIGHT + GAP_HEIGHT, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		textField81.setBackground(Color.LIGHT_GRAY);
		textField81.setEditable(false);
		add(textField81);

		/*************************************** 步骤9- 8的Base58编码 ************************************************/
		JLabel label9 = new JLabel("步骤9- 步骤8的Base58编码（根据未压缩格式公钥计算出的BTC地址）");
		label9.setBounds(LAYOUT_MARGIN, textField81.getY() + COMPONENT_HEIGHT + GAP_HEIGHT, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		add(label9);
		textField90 = new JTextField();
		textField90.setColumns(10);
		textField90.setBounds(LAYOUT_MARGIN, label9.getY() + COMPONENT_HEIGHT + GAP_HEIGHT, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		add(textField90);
		textField91 = new JTextField();
		textField91.setColumns(10);
		textField91.setBounds(LAYOUT_MARGIN, textField90.getY() + COMPONENT_HEIGHT + GAP_HEIGHT, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		textField91.setBackground(Color.LIGHT_GRAY);
		textField91.setEditable(false);
		add(textField91);

		/*************************************** 我的信息 ************************************************/
		JLabel infoLabel = new JLabel("如果您喜欢本工具，请考虑发送一些比特币至：\r\n" + Constants.AUTHOR_BTC_ADDRESS);
		infoLabel.setBounds(LAYOUT_MARGIN, textField91.getY() + COMPONENT_HEIGHT + GAP_HEIGHT, LAYOUT_WIDTH,
				LAYOUT_HEIGHT * 2);
		infoLabel.setFont(new Font("微软雅黑", Font.BOLD, LAYOUT_MARGIN));
		infoLabel.setForeground(Color.red);
		infoLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				log.info(Constants.AUTHOR_BTC_ADDRESS);
				SystemUtil.setSysClipboardText(Constants.AUTHOR_BTC_ADDRESS);
			}
		});
		add(infoLabel);
	}

	protected void initUIComponent(String privateKey)
	{
		// step0
		textField00.setText(privateKey);
		textField01.setText("WIF格式私钥：" + BitcoinUtils.getWIFPrivateKey(privateKey));
		textField01.setForeground(Color.RED);

		// step1
		String publicKey = BitcoinUtils.getPublicKey(privateKey);
		String compressedpublicKey = BitcoinUtils.getCompressedPublicKey(publicKey);
		textField10.setText(publicKey);
		textField11.setText("压缩格式：" + compressedpublicKey);
		textField11.setForeground(Color.RED);

		// step2
		String publicKeyHash256 = HexUtils.encodeHex(BitcoinUtils.getHash256(publicKey));
		textField20.setText(publicKeyHash256);
		String compressedPublicKeyHash256 = HexUtils.encodeHex(BitcoinUtils.getHash256(compressedpublicKey));
		textField21.setText("压缩格式：" + compressedPublicKeyHash256);
		textField21.setForeground(Color.RED);

		// step3
		String ripemd160Hash = BitcoinUtils.getRipemd160Hash(BitcoinUtils.getHash256(publicKey));
		textField30.setText(ripemd160Hash);
		String compressedRipemd160Hash = BitcoinUtils.getRipemd160Hash(BitcoinUtils.getHash256(compressedpublicKey));
		textField31.setText("压缩公钥hash160 ：" + compressedRipemd160Hash);
		textField31.setForeground(Color.RED);

		// step4
		String networkBytesTo3 = new StringBuilder("00").append(ripemd160Hash).toString();
		textField40.setText(networkBytesTo3);
		String compressedNetworkBytesTo3 = new StringBuilder("00").append(compressedRipemd160Hash).toString();
		textField41.setText("压缩格式：" + compressedNetworkBytesTo3);
		textField41.setForeground(Color.RED);

		// step5
		String sha256Of4 = HexUtils.encodeHex(BitcoinUtils.getHash256(networkBytesTo3));
		textField50.setText(sha256Of4);
		String compressedSha256Of4 = HexUtils.encodeHex(BitcoinUtils.getHash256(compressedNetworkBytesTo3));
		textField51.setText("压缩格式：" + compressedSha256Of4);
		textField51.setForeground(Color.RED);

		// step6
		String sha256Of5 = HexUtils.encodeHex(BitcoinUtils.getHash256(sha256Of4));
		textField60.setText(sha256Of5);
		String compressedSha256Of5 = HexUtils.encodeHex(BitcoinUtils.getHash256(compressedSha256Of4));
		textField61.setText("压缩格式：" + compressedSha256Of5);
		textField61.setForeground(Color.RED);

		// step7
		String firstFourBytesOf6 = sha256Of5.substring(0, 8);
		textField70.setText(firstFourBytesOf6);
		String compressedFirstFourBytesOf6 = compressedSha256Of5.substring(0, 8);
		textField71.setText("压缩格式：" + compressedFirstFourBytesOf6);
		textField71.setForeground(Color.RED);

		// step8
		String add7to4 = new StringBuilder(networkBytesTo3).append(firstFourBytesOf6).toString();
		textField80.setText(add7to4);
		String compressedAdd7to4 = new StringBuilder(compressedNetworkBytesTo3).append(
				compressedFirstFourBytesOf6).toString();
		textField81.setText("压缩格式：" + compressedAdd7to4);
		textField81.setForeground(Color.RED);

		// step9
		String base58String = Base58.encode(HexUtils.decodeHex(add7to4));
		textField90.setText("未压缩公钥BTC地址: " + base58String);
		String compressedBase58String = Base58.encode(HexUtils.decodeHex(compressedAdd7to4));
		textField91.setText("压缩公钥BTC地址：" + compressedBase58String);
		textField91.setForeground(Color.RED);
	}
}
