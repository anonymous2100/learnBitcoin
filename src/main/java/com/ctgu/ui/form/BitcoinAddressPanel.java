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
import javax.swing.JSeparator;
import javax.swing.JTextField;

import org.bitcoinj.core.Base58;

import com.ctgu.constant.Constants;
import com.ctgu.ui.dialog.ToastFrame;
import com.ctgu.util.BitcoinUtils;
import com.ctgu.util.HexUtils;
import com.ctgu.util.SystemUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BitcoinAddressPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JTextField textField0;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	private JTextField textField7;
	private JTextField textField8;
	private JTextField textField9;

	public static final int LAYOUT_WIDTH = 1000;
	public static final int LAYOUT_HEIGHT = 30;
	public static final int SEPARATOR_WIDTH = LAYOUT_WIDTH;
	public static final int SEPARATOR_HEIGHT = 10;
	public static final int COMPONENT_HEIGHT = LAYOUT_HEIGHT;
	public static final int GAP_HEIGHT = SEPARATOR_HEIGHT * 2;
	public static final int LAYOUT_MARGIN = 20;

	public BitcoinAddressPanel()
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
				String privateKey = textField0.getText();
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
		JLabel label0 = new JLabel("步骤0- 私钥（原始格式）");
		label0.setBounds(LAYOUT_MARGIN, COMPONENT_HEIGHT + GAP_HEIGHT, LAYOUT_WIDTH, LAYOUT_HEIGHT);
		add(label0);

		textField0 = new JTextField();
		textField0.setBounds(LAYOUT_MARGIN, label0.getY() + COMPONENT_HEIGHT + GAP_HEIGHT / 2, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		textField0.setColumns(10);
		add(textField0);

		JSeparator separator0 = new JSeparator();
		separator0.setBounds(LAYOUT_MARGIN, textField0.getY() + COMPONENT_HEIGHT / 2 + GAP_HEIGHT, SEPARATOR_WIDTH,
				SEPARATOR_HEIGHT);
		add(separator0);

		/**************************************** 步骤1-ECDSA公钥 ***********************************************/
		JLabel label1 = new JLabel("步骤1- ECDSA公钥（未压缩格式公钥）");
		label1.setBounds(LAYOUT_MARGIN, separator0.getY() + GAP_HEIGHT, LAYOUT_WIDTH, LAYOUT_HEIGHT);
		add(label1);

		textField1 = new JTextField();
		textField1.setBounds(LAYOUT_MARGIN, label1.getY() + COMPONENT_HEIGHT + GAP_HEIGHT / 2, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		textField1.setColumns(10);
		add(textField1);

		JSeparator separator1 = new JSeparator();
		separator1.setBounds(LAYOUT_MARGIN, textField1.getY() + COMPONENT_HEIGHT / 2 + GAP_HEIGHT, SEPARATOR_WIDTH,
				SEPARATOR_HEIGHT);
		add(separator1);

		/*************************************** 步骤2 - 1的SHA-256哈希值 ************************************************/
		JLabel label2 = new JLabel("步骤2- 计算步骤1的SHA-256哈希值");
		label2.setBounds(LAYOUT_MARGIN, separator1.getY() + GAP_HEIGHT, LAYOUT_WIDTH, LAYOUT_HEIGHT);
		add(label2);

		textField2 = new JTextField();
		textField2.setBounds(LAYOUT_MARGIN, label2.getY() + COMPONENT_HEIGHT + GAP_HEIGHT / 2, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		textField2.setColumns(10);
		add(textField2);

		JSeparator separator2 = new JSeparator();
		separator2.setBounds(LAYOUT_MARGIN, textField2.getY() + COMPONENT_HEIGHT / 2 + GAP_HEIGHT, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		add(separator2);

		/***************************************
		 * 步骤3- 步骤2的RIPEMD-160哈希值
		 ************************************************/
		JLabel label3 = new JLabel("步骤3- 步骤2的RIPEMD-160哈希值");
		label3.setBounds(LAYOUT_MARGIN, separator2.getY() + GAP_HEIGHT, LAYOUT_WIDTH, LAYOUT_HEIGHT);
		add(label3);

		textField3 = new JTextField();
		textField3.setBounds(LAYOUT_MARGIN, label3.getY() + COMPONENT_HEIGHT + GAP_HEIGHT / 2, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		textField3.setColumns(10);
		add(textField3);

		JSeparator separator3 = new JSeparator();
		separator3.setBounds(LAYOUT_MARGIN, textField3.getY() + COMPONENT_HEIGHT / 2 + GAP_HEIGHT, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		add(separator3);

		/*************************************** 步骤4- 将网络字节数添加到3 ************************************************/
		JLabel label4 = new JLabel("步骤4- 将网络字节数添加到步骤3的结果");
		label4.setBounds(LAYOUT_MARGIN, separator3.getY() + GAP_HEIGHT, LAYOUT_WIDTH, LAYOUT_HEIGHT);
		add(label4);

		textField4 = new JTextField();
		textField4.setColumns(10);
		textField4.setBounds(LAYOUT_MARGIN, label4.getY() + COMPONENT_HEIGHT + GAP_HEIGHT / 2, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		add(textField4);

		JSeparator separator4 = new JSeparator();
		separator4.setBounds(LAYOUT_MARGIN, textField4.getY() + COMPONENT_HEIGHT / 2 + GAP_HEIGHT, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		add(separator4);

		/*************************************** 步骤5：4的SHA-256哈希值 ************************************************/
		JLabel label5 = new JLabel("步骤5- 步骤4的SHA-256哈希值");
		label5.setBounds(LAYOUT_MARGIN, separator4.getY() + GAP_HEIGHT, LAYOUT_WIDTH, LAYOUT_HEIGHT);
		add(label5);

		textField5 = new JTextField();
		textField5.setColumns(10);
		textField5.setBounds(LAYOUT_MARGIN, label5.getY() + COMPONENT_HEIGHT + GAP_HEIGHT / 2, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		add(textField5);

		JSeparator separator5 = new JSeparator();
		separator5.setBounds(LAYOUT_MARGIN, textField5.getY() + COMPONENT_HEIGHT / 2 + GAP_HEIGHT, SEPARATOR_WIDTH,
				SEPARATOR_HEIGHT);
		add(separator5);

		/*************************************** 步骤6 - 5的SHA-256哈希值 ************************************************/
		JLabel label6 = new JLabel("步骤6 - 步骤5的SHA-256哈希值");
		label6.setBounds(LAYOUT_MARGIN, separator5.getY() + GAP_HEIGHT, LAYOUT_WIDTH, LAYOUT_HEIGHT);
		add(label6);

		textField6 = new JTextField();
		textField6.setColumns(10);
		textField6.setBounds(LAYOUT_MARGIN, label6.getY() + COMPONENT_HEIGHT + GAP_HEIGHT / 2, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		add(textField6);

		JSeparator separator6 = new JSeparator();
		separator6.setBounds(LAYOUT_MARGIN, textField6.getY() + COMPONENT_HEIGHT / 2 + GAP_HEIGHT, SEPARATOR_WIDTH,
				SEPARATOR_HEIGHT);
		add(separator6);

		/*************************************** 步骤7 - 6的前四个字节 ************************************************/
		JLabel label7 = new JLabel("步骤7 - 步骤6的前四个字节");
		label7.setBounds(LAYOUT_MARGIN, separator6.getY() + GAP_HEIGHT, LAYOUT_WIDTH, LAYOUT_HEIGHT);
		add(label7);

		textField7 = new JTextField();
		textField7.setColumns(10);
		textField7.setBounds(LAYOUT_MARGIN, label7.getY() + COMPONENT_HEIGHT + GAP_HEIGHT / 2, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		add(textField7);

		JSeparator separator7 = new JSeparator();
		separator7.setBounds(LAYOUT_MARGIN, textField7.getY() + COMPONENT_HEIGHT / 2 + GAP_HEIGHT, SEPARATOR_WIDTH,
				SEPARATOR_HEIGHT);
		add(separator7);

		/*************************************** 步骤8- 在4的末尾加7 ************************************************/
		JLabel label8 = new JLabel("步骤8- 在步骤4的末尾追加步骤7");
		label8.setBounds(LAYOUT_MARGIN, separator7.getY() + GAP_HEIGHT, LAYOUT_WIDTH, LAYOUT_HEIGHT);
		add(label8);

		textField8 = new JTextField();
		textField8.setColumns(10);
		textField8.setBounds(LAYOUT_MARGIN, label8.getY() + COMPONENT_HEIGHT + GAP_HEIGHT / 2, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		add(textField8);
		JSeparator separator8 = new JSeparator();
		separator8.setBounds(LAYOUT_MARGIN, textField8.getY() + COMPONENT_HEIGHT / 2 + GAP_HEIGHT, SEPARATOR_WIDTH,
				SEPARATOR_HEIGHT);
		add(separator8);

		/*************************************** 步骤9- 8的Base58编码 ************************************************/
		JLabel label9 = new JLabel("步骤9- 步骤8的Base58编码（未压缩公钥BTC地址）");
		label9.setBounds(LAYOUT_MARGIN, separator8.getY() + GAP_HEIGHT, LAYOUT_WIDTH, LAYOUT_HEIGHT);
		add(label9);
		textField9 = new JTextField();
		textField9.setColumns(10);
		textField9.setBounds(LAYOUT_MARGIN, label9.getY() + COMPONENT_HEIGHT + GAP_HEIGHT / 2, LAYOUT_WIDTH,
				LAYOUT_HEIGHT);
		add(textField9);
		JSeparator separator9 = new JSeparator();
		separator9.setBounds(LAYOUT_MARGIN, textField9.getY() + COMPONENT_HEIGHT / 2 + GAP_HEIGHT, SEPARATOR_WIDTH,
				SEPARATOR_HEIGHT);
		add(separator9);

		/*************************************** 我的信息 ************************************************/
		JLabel infoLabel = new JLabel("如果您喜欢本工具，请考虑发送一些比特币至：\r\n" + Constants.AUTHOR_BTC_ADDRESS);
		infoLabel.setBounds(LAYOUT_MARGIN, separator9.getY() + COMPONENT_HEIGHT, LAYOUT_WIDTH, LAYOUT_HEIGHT * 3);
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
		textField0.setText(privateKey);
		// step1
		String publicKey = BitcoinUtils.getPublicKey(privateKey);
		textField1.setText(publicKey);
		// step2
		String publicKeyHash256 = HexUtils.encodeHex(BitcoinUtils.getHash256(publicKey));
		textField2.setText(publicKeyHash256);
		// step3
		String ripemd160Hash = BitcoinUtils.getRipemd160Hash(BitcoinUtils.getHash256(publicKey));
		textField3.setText(ripemd160Hash);
		// step4
		String networkBytesTo3 = new StringBuilder("00").append(ripemd160Hash).toString();
		textField4.setText(networkBytesTo3);
		// step5
		String sha256Of4 = HexUtils.encodeHex(BitcoinUtils.getHash256(networkBytesTo3));
		textField5.setText(sha256Of4);
		// step6
		String sha256Of5 = HexUtils.encodeHex(BitcoinUtils.getHash256(sha256Of4));
		textField6.setText(sha256Of5);
		// step7
		String firstFourBytesOf6 = sha256Of5.substring(0, 8);
		textField7.setText(firstFourBytesOf6);
		// step8
		String add7to4 = new StringBuilder(networkBytesTo3).append(firstFourBytesOf6).toString();
		textField8.setText(add7to4);
		// step9
		String base58String = Base58.encode(HexUtils.decodeHex(add7to4));
		textField9.setText(base58String);
	}
}
