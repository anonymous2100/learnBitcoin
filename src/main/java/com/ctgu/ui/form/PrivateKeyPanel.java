package com.ctgu.ui.form;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.bitcoinj.core.Base58;

import com.ctgu.ui.dialog.ToastFrame;
import com.ctgu.util.BitcoinUtils;
import com.ctgu.util.HexUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrivateKeyPanel extends JPanel
{
	private static final long serialVersionUID = 1L;

	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JTextField subTextField1;
	private JTextField subTextField2;
	private JTextField subTextField3;
	private JTextField subTextField4;
	private JTextField textField21;
	private JTextField textField22;
	private JTextField textField23;
	private JTextField textField24;
	private JTextField textField25;
	private JTextField textField26;
	private JTextField textField27;
	private JTextField textField31;
	private JTextField textField32;
	private JTextField textField33;
	private JTextField textField34;
	private JTextField textField35;
	private JTextField textField36;
	private JTextField textField37;
	private JButton randomButton1;
	private JButton calculateButton1;
	private JButton randomButton2;
	private JButton calculateButton2;
	private JButton randomButton3;
	private JButton calculateButton3;
	private JLabel wifResultLabel;

	public static final int PANEL_WIDTH = 800;
	public static final int PANEL_HEIGHT = 700;
	public static final int COMPONENT_WIDTH = 780;
	public static final int COMPONENT_HEIGHT = 25;
	public static final int BUTTON_WIDTH = 120;
	public static final int BUTTON_HEIGHT = COMPONENT_HEIGHT;
	public static final int GAP_WIDTH = COMPONENT_HEIGHT / 8;

	/**
	 * Create the panel.
	 */
	public PrivateKeyPanel()
	{
		this.setLayout(null);

		/*********************** panel1: 钱包导入格式转换为私钥 ************************/
		panel1 = new JPanel();
		panel1.setBackground(SystemColor.info);
		panel1.setLayout(null);
		panel1.setBounds(GAP_WIDTH, GAP_WIDTH, PANEL_WIDTH, 290);
		add(panel1);

		JLabel titleLabel1 = new JLabel("钱包导入格式(WIF)转换为私钥");
		titleLabel1.setBounds(GAP_WIDTH, GAP_WIDTH, COMPONENT_WIDTH, COMPONENT_HEIGHT);
		panel1.add(titleLabel1);

		randomButton1 = new JButton("随机生成");
		randomButton1.setBounds(GAP_WIDTH, titleLabel1.getY() + COMPONENT_HEIGHT + GAP_WIDTH, BUTTON_WIDTH,
				BUTTON_HEIGHT);
		panel1.add(randomButton1);

		calculateButton1 = new JButton("根据钱包导入格式（WIF）计算私钥");
		calculateButton1.setBounds(randomButton1.getWidth() + GAP_WIDTH * 2,
				titleLabel1.getY() + COMPONENT_HEIGHT + GAP_WIDTH, (int) (BUTTON_WIDTH * 2.5), BUTTON_HEIGHT);
		panel1.add(calculateButton1);

		JLabel subLabel1 = new JLabel("1- 钱包导入格式");
		subLabel1.setBounds(GAP_WIDTH, calculateButton1.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel1.add(subLabel1);

		subTextField1 = new JTextField();
		subTextField1.setBounds(GAP_WIDTH, subLabel1.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel1.add(subTextField1);
		subTextField1.setColumns(10);

		JLabel subLabel2 = new JLabel("2- 将 WIF 作为 Base58 字符串转换为字节数组");
		subLabel2.setBounds(GAP_WIDTH, subTextField1.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel1.add(subLabel2);

		subTextField2 = new JTextField();
		subTextField2.setBounds(GAP_WIDTH, subLabel2.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel1.add(subTextField2);
		subTextField2.setColumns(10);

		JLabel subLabel3 = new JLabel("3 - 删除最后 4 个校验和字节");
		subLabel3.setBounds(GAP_WIDTH, subTextField2.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel1.add(subLabel3);

		subTextField3 = new JTextField();
		subTextField3.setBounds(GAP_WIDTH, subLabel3.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel1.add(subTextField3);
		subTextField3.setColumns(10);

		JLabel subLabel4 = new JLabel("4 - 删除第一个字节。这是私钥");
		subLabel4.setBounds(GAP_WIDTH, subTextField3.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel1.add(subLabel4);

		subTextField4 = new JTextField();
		subTextField4.setBounds(GAP_WIDTH, subLabel4.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel1.add(subTextField4);
		subTextField4.setColumns(10);

		/*********************** panel2: 私钥转换为钱包导入格式 ************************/
		panel2 = new JPanel();
		panel2.setBounds(GAP_WIDTH, panel1.getY() + panel1.getHeight(), 800, 451);
		panel2.setBackground(SystemColor.inactiveCaption);
		panel2.setLayout(null);
		add(panel2);

		JLabel label21 = new JLabel("私钥转换为钱包导入格式(WIF)");
		label21.setBounds(GAP_WIDTH, 0, COMPONENT_WIDTH, COMPONENT_HEIGHT);
		panel2.add(label21);

		randomButton2 = new JButton("随机生成");
		randomButton2.setBounds(GAP_WIDTH, label21.getY() + COMPONENT_HEIGHT + GAP_WIDTH, BUTTON_WIDTH, BUTTON_HEIGHT);
		panel2.add(randomButton2);

		calculateButton2 = new JButton("根据私钥计算钱包导入格式（WIF）");
		calculateButton2.setBounds(GAP_WIDTH + randomButton2.getWidth() + GAP_WIDTH * 2,
				label21.getY() + COMPONENT_HEIGHT + GAP_WIDTH, (int) (BUTTON_WIDTH * 2.5), BUTTON_HEIGHT);
		panel2.add(calculateButton2);

		JLabel label22 = new JLabel("1- 原始私钥");
		label22.setBounds(6, calculateButton2.getHeight() + COMPONENT_HEIGHT, COMPONENT_WIDTH, COMPONENT_HEIGHT);
		panel2.add(label22);

		textField21 = new JTextField();
		textField21.setColumns(10);
		textField21.setBounds(GAP_WIDTH, label22.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel2.add(textField21);

		JLabel label23 = new JLabel("2- 在步骤1前面添加字节0x80");
		label23.setBounds(GAP_WIDTH, textField21.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel2.add(label23);

		textField22 = new JTextField();
		textField22.setColumns(10);
		textField22.setBounds(GAP_WIDTH, label23.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel2.add(textField22);

		JLabel label24 = new JLabel("3- 计算步骤2的SHA256");
		label24.setBounds(GAP_WIDTH, textField22.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel2.add(label24);

		textField23 = new JTextField();
		textField23.setColumns(10);
		textField23.setBounds(GAP_WIDTH, label24.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel2.add(textField23);

		JLabel label25 = new JLabel("4- 计算步骤3的SHA256");
		label25.setBounds(GAP_WIDTH, textField23.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel2.add(label25);

		textField24 = new JTextField();
		textField24.setColumns(10);
		textField24.setBounds(GAP_WIDTH, label25.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel2.add(textField24);

		JLabel label26 = new JLabel("5- 取步骤4的前4个字节，这是校验和");
		label26.setBounds(GAP_WIDTH, textField24.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel2.add(label26);

		textField25 = new JTextField();
		textField25.setColumns(10);
		textField25.setBounds(GAP_WIDTH, label26.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel2.add(textField25);

		JLabel label27 = new JLabel("6- 在步骤2的末尾追加步骤5");
		label27.setBounds(GAP_WIDTH, textField25.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel2.add(label27);

		textField26 = new JTextField();
		textField26.setColumns(10);
		textField26.setBounds(GAP_WIDTH, label27.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel2.add(textField26);

		JLabel label28 = new JLabel("7- 计算步骤6的Base58编码");
		label28.setBounds(GAP_WIDTH, textField26.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel2.add(label28);

		textField27 = new JTextField();
		textField27.setColumns(10);
		textField27.setBounds(GAP_WIDTH, label28.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel2.add(textField27);

		/*********************** panel3、WIF 校验和检查 ************************/
		panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setBounds(GAP_WIDTH, panel2.getY() + panel2.getHeight(), 800, 485);
		panel3.setBackground(new Color(192, 192, 192));
		add(panel3);

		JLabel label31 = new JLabel("WIF校验和检查");
		label31.setBounds(GAP_WIDTH, 0, COMPONENT_WIDTH, COMPONENT_HEIGHT);
		label31.setBackground(Color.WHITE);
		panel3.add(label31);

		randomButton3 = new JButton("随机生成");
		randomButton3.setBounds(GAP_WIDTH, label31.getY() + COMPONENT_HEIGHT + GAP_WIDTH, BUTTON_WIDTH, BUTTON_HEIGHT);
		panel3.add(randomButton3);

		calculateButton3 = new JButton("WIF格式私钥校验");
		calculateButton3.setBounds(GAP_WIDTH + randomButton2.getWidth() + GAP_WIDTH * 2,
				label31.getY() + COMPONENT_HEIGHT + GAP_WIDTH, randomButton3.getWidth() + BUTTON_WIDTH, BUTTON_HEIGHT);
		panel3.add(calculateButton3);

		JLabel label32 = new JLabel("1- 钱包导入格式");
		label32.setBounds(GAP_WIDTH, calculateButton3.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel3.add(label32);

		textField31 = new JTextField();
		textField31.setColumns(10);
		textField31.setBounds(GAP_WIDTH, label32.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel3.add(textField31);

		JLabel label33 = new JLabel("2 - 将 WIF 作为 Base58 字符串转换为字节数组");
		label33.setBounds(GAP_WIDTH, textField31.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel3.add(label33);

		textField32 = new JTextField();
		textField32.setColumns(10);
		textField32.setBounds(GAP_WIDTH, label33.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel3.add(textField32);

		JLabel label34 = new JLabel("3 - 从 2 中删除最后 4 个校验和字节");
		label34.setBounds(GAP_WIDTH, textField32.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel3.add(label34);

		textField33 = new JTextField();
		textField33.setColumns(10);
		textField33.setBounds(GAP_WIDTH, label34.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel3.add(textField33);

		JLabel label35 = new JLabel("4 - 3 的 SHA-256 哈希值");
		label35.setBounds(GAP_WIDTH, textField33.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel3.add(label35);

		textField34 = new JTextField();
		textField34.setColumns(10);
		textField34.setBounds(GAP_WIDTH, label35.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel3.add(textField34);

		JLabel label36 = new JLabel("5 - 4 的 SHA-256 哈希值");
		label36.setBounds(GAP_WIDTH, textField34.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel3.add(label36);

		textField35 = new JTextField();
		textField35.setColumns(10);
		textField35.setBounds(GAP_WIDTH, label36.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel3.add(textField35);

		JLabel label37 = new JLabel("6 - 5 的前 4 个字节，这是计算出的校验和");
		label37.setBounds(GAP_WIDTH, textField35.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel3.add(label37);

		textField36 = new JTextField();
		textField36.setColumns(10);
		textField36.setBounds(GAP_WIDTH, label37.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel3.add(textField36);

		JLabel label38 = new JLabel("7-取2的最后4个字节，这是原始校验和");
		label38.setBounds(GAP_WIDTH, textField36.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel3.add(label38);

		textField37 = new JTextField();
		textField37.setColumns(10);
		textField37.setBounds(GAP_WIDTH, label38.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel3.add(textField37);

		wifResultLabel = new JLabel("6 和 7 是否相同？2 是否以 0x80 字节开头？如果是，则成功！");
		wifResultLabel.setBounds(GAP_WIDTH, textField37.getY() + COMPONENT_HEIGHT + GAP_WIDTH, COMPONENT_WIDTH,
				COMPONENT_HEIGHT);
		panel3.add(wifResultLabel);

		initButtonListener();
	}

	private void initButtonListener()
	{
		randomButton1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String privateKeyWIF = BitcoinUtils.getWIFPrivateKey(BitcoinUtils.getRandomPrivateKey());
				subTextField1.setText(privateKeyWIF);

				byte[] bytes = Base58.decode(privateKeyWIF);
				String hexString = HexUtils.encodeHex(bytes);
				subTextField2.setText(hexString);

				String subStringOfBase58 = hexString.substring(0, hexString.length() - 8);
				subTextField3.setText(subStringOfBase58);

				String privateKeyDecoded = subStringOfBase58.substring(2, subStringOfBase58.length());
				subTextField4.setText(privateKeyDecoded);
			}
		});
		calculateButton1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String wifPrivateKey = subTextField1.getText();
				if (wifPrivateKey == null || wifPrivateKey.length() == 0)
				{
					// 暂时不校验私钥格式是否正确
					log.error("wif格式私钥不能为空");
					return;
				}
				subTextField2.setText("");
				subTextField3.setText("");
				subTextField4.setText("");
				byte[] bytes = Base58.decode(wifPrivateKey);
				String hexString = HexUtils.encodeHex(bytes);
				subTextField2.setText(hexString);
				String subStringOfBase58 = hexString.substring(0, hexString.length() - 8);
				subTextField3.setText(subStringOfBase58);
				String privateKeyDecoded = subStringOfBase58.substring(2, subStringOfBase58.length());
				subTextField4.setText(privateKeyDecoded);
			}
		});
		randomButton2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String privateKey = BitcoinUtils.getRandomPrivateKey();
				textField21.setText(privateKey);
				String addVersionString = new StringBuffer("80").append(privateKey).toString();
				textField22.setText(addVersionString);
				byte[] hash256OfAddVersion2 = BitcoinUtils.getHash256(addVersionString);
				textField23.setText(HexUtils.encodeHex(hash256OfAddVersion2));
				byte[] hash256OfAddVersion3 = BitcoinUtils.getHash256(HexUtils.encodeHex(hash256OfAddVersion2));
				textField24.setText(HexUtils.encodeHex(hash256OfAddVersion3));
				String first4bytes = HexUtils.encodeHex(hash256OfAddVersion3).substring(0, 8);
				textField25.setText(first4bytes);
				String addResult = addVersionString + first4bytes;
				textField26.setText(addResult);
				String base58Result = Base58.encode(HexUtils.decodeHex(addResult));
				textField27.setText(base58Result);
			}
		});
		calculateButton2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String privateKey = textField21.getText();
				if (privateKey == null || privateKey.length() == 0)
				{
					// 暂时不校验私钥格式是否正确
					log.error("私钥格式不正确");
					return;
				}
				String addVersionString = new StringBuffer("80").append(privateKey).toString();
				textField22.setText(addVersionString);
				byte[] hash256OfAddVersion2 = BitcoinUtils.getHash256(addVersionString);
				textField23.setText(HexUtils.encodeHex(hash256OfAddVersion2));
				byte[] hash256OfAddVersion3 = BitcoinUtils.getHash256(HexUtils.encodeHex(hash256OfAddVersion2));
				textField24.setText(HexUtils.encodeHex(hash256OfAddVersion3));
				String first4bytes = HexUtils.encodeHex(hash256OfAddVersion3).substring(0, 8);
				textField25.setText(first4bytes);
				String addResult = addVersionString + first4bytes;
				textField26.setText(addResult);
				String base58Result = Base58.encode(HexUtils.decodeHex(addResult));
				textField27.setText(base58Result);
			}
		});
		randomButton3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String privateKeyWIF = BitcoinUtils.getWIFPrivateKey(BitcoinUtils.getRandomPrivateKey());
				textField31.setText(privateKeyWIF);
				byte[] bytes = Base58.decode(privateKeyWIF);
				String hexString = HexUtils.encodeHex(bytes);
				textField32.setText(hexString);
				String deletedString = hexString.substring(0, hexString.length() - 8);
				textField33.setText(deletedString);
				String hash256OfStep3 = HexUtils.encodeHex(BitcoinUtils.getHash256(deletedString));
				textField34.setText(hash256OfStep3);
				String hash256OfStep4 = HexUtils.encodeHex(BitcoinUtils.getHash256(hash256OfStep3));
				textField35.setText(hash256OfStep4);
				String step6String = hash256OfStep4.substring(0, 8);
				textField36.setText(step6String);
				String step7String = hexString.substring(hexString.length() - 8, hexString.length());
				textField37.setText(step7String);
				if (step6String.equals(step7String))
				{
					String result = "校验成功！  （6 和 7 是否相同？2 是否以 0x80 字节开头？如果是，则成功！）";
					wifResultLabel.setText(result);
				}
				else
				{
					String result = "校验失败~~~  （6 和 7 是否相同？2 是否以 0x80 字节开头？如果是，则成功！）";
					wifResultLabel.setText(result);
				}
			}
		});
		calculateButton3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String privateKeyWIF = textField31.getText();
				if (privateKeyWIF == null || privateKeyWIF.length() == 0)
				{
					// 暂时不校验私钥格式是否正确
					log.error("私钥格式不正确");
					return;
				}
				byte[] bytes = Base58.decode(privateKeyWIF);
				String hexString = HexUtils.encodeHex(bytes);
				textField32.setText(hexString);
				String deletedString = hexString.substring(0, hexString.length() - 8);
				textField33.setText(deletedString);
				String hash256OfStep3 = HexUtils.encodeHex(BitcoinUtils.getHash256(deletedString));
				textField34.setText(hash256OfStep3);
				String hash256OfStep4 = HexUtils.encodeHex(BitcoinUtils.getHash256(hash256OfStep3));
				textField35.setText(hash256OfStep4);
				String step6String = hash256OfStep4.substring(0, 8);
				textField36.setText(step6String);
				String step7String = hexString.substring(hexString.length() - 8, hexString.length());
				textField37.setText(step7String);
				if (step6String.equals(step7String))
				{
					new ToastFrame("校验成功！");
				}
				else
				{
					new ToastFrame("校验失败~~~ ");
				}
			}
		});
	}
}
