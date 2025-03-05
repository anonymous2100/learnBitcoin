package com.ctgu.ui.form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

import com.ctgu.constant.Constants;

/**
 * @author Administrator
 */
public class HDWalletPanel extends JPanel
{
	private static final long serialVersionUID = 3544134574506367694L;
	private JScrollPane scrollPane;
	private JPanel mainPanel;
	private JPanel panel0;
	private JPanel panel1;
	private JTextField textField1;
	private JRadioButton radioButton1;
	private JRadioButton radioButton2;
	private JRadioButton radioButton3;
	private JRadioButton radioButton4;
	private JRadioButton radioButton5;
	private JRadioButton radioButton6;
	private JComboBox<String> comboBox1;
	private JComboBox<String> comboBox2;
	private JPanel panel2;
	private JCheckBox checkBox1;
	private JCheckBox checkBox2;
	private JCheckBox checkBox3;
	private JPanel panel3;
	private JCheckBox checkBox4;
	private JCheckBox checkBox5;
	private JCheckBox checkBox6;
	private JTextField textField2;
	private JTextField textField3;
	private JCheckBox checkBox7;
	private JTextField textField4;
	private JTextField textField5;
	private JComboBox<String> comboBox3;
	private JTextField textField6;
	private JCheckBox checkBox8;
	private JPanel panel4;
	private JTextField textField8;
	private JTextField textField9;
	private JComboBox<String> comboBox4;
	private JComboBox<String> comboBox5;
	private JComboBox<String> comboBox6;
	private JTextPane textPane4;
	private JPanel panel10;
	private JCheckBox checkBox9;
	private JTextField textField7;
	private JCheckBox checkBox10;
	private JTabbedPane tabbedPane2;
	private JPanel panel13;
	private JTabbedPane tabbedPane1;

	public HDWalletPanel()
	{
		initComponents();
	}

	private void initComponents()
	{
		this.setLayout(null);

		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.LIGHT_GRAY);
		mainPanel.setPreferredSize(new Dimension(Constants.INNER_PANEL_WIDTH, 2000));

		initPanel0();
		initPanel1();
		initPanel2();
		initPanel3();
		initPanel13();
		initPanel10();

		scrollPane = new JScrollPane(mainPanel);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(Constants.GAP_WIDTH, Constants.GAP_WIDTH, 1200, 1100);
		scrollPane.getHorizontalScrollBar().setAutoscrolls(false);
		scrollPane.getVerticalScrollBar().setAutoscrolls(true);
		scrollPane.setViewportView(mainPanel);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.RED));
		scrollPane.getVerticalScrollBar().setUI(new MyScrollBarUI());
		this.add(scrollPane);
	}

	private void initPanel10()
	{
		// ---------------------------------- 派生地址------------------------------------
		panel10 = new JPanel();
		panel10.setLayout(null);
		panel10.setBounds(Constants.GAP_WIDTH, panel13.getY() + panel13.getHeight(), Constants.INNER_PANEL_WIDTH, 400);

		JLabel label34 = new JLabel();
		label34.setText("派生地址");
		label34.setBounds(Constants.GAP_WIDTH, Constants.GAP_WIDTH, Constants.PANEL_WIDTH, Constants.COMPONENT_HEIGHT);
		panel10.add(label34);

		JLabel label345 = new JLabel();
		label345.setText("请注意，这些地址来自 BIP32 扩展密钥");
		label345.setBounds(Constants.GAP_WIDTH, label34.getY() + label34.getHeight(), Constants.PANEL_COMPONENT_WIDTH,
				Constants.COMPONENT_HEIGHT);
		panel10.add(label345);

		checkBox9 = new JCheckBox();
		checkBox9.setText("使用 BIP38 和此密码加密私钥：");
		checkBox9.setBounds(Constants.GAP_WIDTH, label345.getY() + label345.getHeight(),
				(int) (Constants.PANEL_COMPONENT_WIDTH * 1.5), Constants.COMPONENT_HEIGHT);
		panel10.add(checkBox9);

		textField7 = new JTextField();
		textField7.setBounds(checkBox9.getX() + checkBox9.getWidth() + Constants.GAP_WIDTH,
				label345.getY() + label345.getHeight(), Constants.PANEL_COMPONENT_WIDTH * 2,
				Constants.COMPONENT_HEIGHT);
		panel10.add(textField7);

		JLabel label35 = new JLabel();
		label35.setText("启用 BIP38 意味着每个密钥将需要几分钟才能生成。");
		label35.setBounds(textField7.getX() + textField7.getWidth() + Constants.GAP_WIDTH,
				label345.getY() + label345.getHeight(), Constants.PANEL_COMPONENT_WIDTH * 2,
				Constants.COMPONENT_HEIGHT);
		panel10.add(label35);

		checkBox10 = new JCheckBox();
		checkBox10.setText("使用强化地址");
		checkBox10.setBounds(Constants.GAP_WIDTH, label35.getY() + label35.getHeight(), Constants.COMPONENT_WIDTH,
				Constants.COMPONENT_HEIGHT);
		panel10.add(checkBox10);

		tabbedPane2 = new JTabbedPane();
		tabbedPane2.setBounds(Constants.GAP_WIDTH, checkBox10.getY() + checkBox10.getHeight(), Constants.PANEL_WIDTH,
				300);
		tabbedPane2.addTab("表格", new JPanel());
		tabbedPane2.addTab("CSV", new JPanel());
		panel10.add(tabbedPane2);
		mainPanel.add(panel10);
	}

	private void initPanel13()
	{
		// ----------------------------------派生路径 ------------------------------------
		panel13 = new JPanel();
		panel13.setLayout(null);
		panel13.setBounds(Constants.GAP_WIDTH, panel3.getY() + panel3.getHeight(), Constants.INNER_PANEL_WIDTH, 350);
		// panel13.setPreferredSize(new Dimension(Constants.PANEL_WIDTH, 300));

		JLabel label234 = new JLabel();
		label234.setText("派生路径");
		label234.setBounds(Constants.GAP_WIDTH, Constants.GAP_WIDTH, Constants.PANEL_COMPONENT_WIDTH,
				Constants.COMPONENT_HEIGHT);
		panel13.add(label234);

		tabbedPane1 = new JTabbedPane();
		tabbedPane1.setBounds(Constants.GAP_WIDTH, label234.getY() + label234.getHeight(), Constants.PANEL_WIDTH, 300);
		tabbedPane1.addTab("BIP32", new JPanel());
		tabbedPane1.addTab("BIP84", new JPanel());
		tabbedPane1.addTab("BIP49", new JPanel());
		tabbedPane1.addTab("BIP84", new JPanel());
		tabbedPane1.addTab("BIP141", new JPanel());
		panel13.add(tabbedPane1);
		mainPanel.add(panel13);
	}

	private void initPanel3()
	{
		// ---------------------------------- ------------------------------------
		panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setBounds(Constants.GAP_WIDTH, panel2.getY() + panel2.getHeight() + Constants.GAP_WIDTH,
				Constants.INNER_PANEL_WIDTH, 656);

		JLabel label22 = new JLabel();
		label22.setText("助记语言");
		label22.setBounds(Constants.GAP_WIDTH, Constants.GAP_WIDTH, Constants.PANEL_COMPONENT_WIDTH,
				Constants.COMPONENT_HEIGHT);
		panel3.add(label22);

		checkBox4 = new JCheckBox();
		checkBox4.setText("English");
		checkBox4.setBounds(Constants.GAP_WIDTH * 2 + Constants.PANEL_COMPONENT_WIDTH, Constants.GAP_WIDTH,
				Constants.PANEL_COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		panel3.add(checkBox4);

		checkBox5 = new JCheckBox();
		checkBox5.setText("简体中文");
		checkBox5.setBounds(checkBox4.getX() + checkBox4.getWidth() + Constants.GAP_WIDTH * 2, Constants.GAP_WIDTH,
				Constants.PANEL_COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		panel3.add(checkBox5);

		checkBox6 = new JCheckBox();
		checkBox6.setText("繁体中文");
		checkBox6.setBounds(checkBox5.getX() + checkBox5.getWidth() + Constants.GAP_WIDTH * 2, Constants.GAP_WIDTH,
				Constants.PANEL_COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		panel3.add(checkBox6);

		JLabel label23 = new JLabel();
		label23.setText("BIP39助记词");
		label23.setBounds(Constants.GAP_WIDTH, label22.getY() + label22.getHeight() + Constants.GAP_WIDTH,
				Constants.PANEL_COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		panel3.add(label23);

		textField2 = new JTextField();
		textField2.setBounds(label23.getX() + label23.getWidth() + Constants.GAP_WIDTH,
				label22.getY() + label22.getHeight() + Constants.GAP_WIDTH,
				panel3.getWidth() - Constants.PANEL_COMPONENT_WIDTH - 2 * Constants.GAP_WIDTH,
				Constants.COMPONENT_HEIGHT * 2);
		panel3.add(textField2);

		JPanel panel33 = new JPanel();
		panel33.setLayout(null);
		panel33.setBounds(0, textField2.getY() + textField2.getHeight() + Constants.GAP_WIDTH, 800,
				Constants.COMPONENT_HEIGHT * 3);
		panel33.setVisible(true);

		JLabel label24 = new JLabel();
		label24.setText("BIP39拆分助记词");
		label24.setBounds(Constants.GAP_WIDTH, Constants.GAP_WIDTH, Constants.PANEL_COMPONENT_WIDTH,
				Constants.COMPONENT_HEIGHT);
		panel33.add(label24);

		textField3 = new JTextField();
		textField3.setBounds(label24.getX() + label24.getWidth() + Constants.GAP_WIDTH, Constants.GAP_WIDTH,
				panel3.getWidth() - Constants.PANEL_COMPONENT_WIDTH - Constants.GAP_WIDTH,
				Constants.COMPONENT_HEIGHT * 3);
		panel33.add(textField3);

		checkBox7 = new JCheckBox();
		checkBox7.setText("显示分割助记卡");
		checkBox7.setBounds(label24.getX() + label24.getWidth() + Constants.GAP_WIDTH,
				panel33.getY() + panel33.getHeight() + Constants.GAP_WIDTH, Constants.PANEL_COMPONENT_WIDTH,
				Constants.COMPONENT_HEIGHT);
		checkBox7.addItemListener(new ItemListener()
		{
			@Override
			public void itemStateChanged(ItemEvent e)
			{
				if (e.getStateChange() == ItemEvent.SELECTED)
				{
					panel33.setVisible(true);
				}
				else
				{
					panel33.setVisible(false);
				}
			}
		});
		panel3.add(checkBox7);
		panel3.add(panel33);

		JLabel label25 = new JLabel();
		label25.setText("BIP39密码(可选)");
		label25.setBounds(Constants.GAP_WIDTH, checkBox7.getY() + checkBox7.getHeight() + Constants.GAP_WIDTH,
				Constants.PANEL_COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		panel3.add(label25);
		textField4 = new JTextField();
		textField4.setBounds(label25.getX() + label25.getWidth() + Constants.GAP_WIDTH,
				checkBox7.getY() + checkBox7.getHeight() + Constants.GAP_WIDTH,
				panel3.getWidth() - Constants.PANEL_COMPONENT_WIDTH - 2 * Constants.GAP_WIDTH,
				Constants.COMPONENT_HEIGHT);
		panel3.add(textField4);

		JLabel label26 = new JLabel();
		label26.setText("BIP39种子");
		label26.setBounds(Constants.GAP_WIDTH, textField4.getY() + textField4.getHeight() + Constants.GAP_WIDTH,
				Constants.PANEL_COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		panel3.add(label26);

		textField5 = new JTextField();
		textField5.setBounds(label26.getX() + label26.getWidth() + Constants.GAP_WIDTH,
				textField4.getY() + textField4.getHeight() + Constants.GAP_WIDTH,
				panel3.getWidth() - Constants.PANEL_COMPONENT_WIDTH - 2 * Constants.GAP_WIDTH,
				Constants.COMPONENT_HEIGHT);
		panel3.add(textField5);

		JLabel label27 = new JLabel();
		label27.setText("硬币");
		label27.setBounds(Constants.GAP_WIDTH, textField5.getY() + textField5.getHeight() + Constants.GAP_WIDTH,
				Constants.PANEL_COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		panel3.add(label27);
		comboBox3 = new JComboBox<String>();
		comboBox3.setBounds(label27.getX() + label27.getWidth() + Constants.GAP_WIDTH,
				textField5.getY() + textField5.getHeight() + Constants.GAP_WIDTH, Constants.PANEL_COMPONENT_WIDTH,
				Constants.COMPONENT_HEIGHT);
		comboBox3.addItem("BTC");
		comboBox3.addItem("BCH");
		comboBox3.addItem("BTG");
		comboBox3.addItem("BSV");
		comboBox3.addItem("BSV");
		comboBox3.addItem("ETC");
		comboBox3.addItem("ETH");
		comboBox3.addItem("SOL");
		comboBox3.setSelectedIndex(0);
		panel3.add(comboBox3);

		JLabel label28 = new JLabel();
		label28.setText("BIP39根秘钥");
		label28.setBounds(Constants.GAP_WIDTH, label27.getY() + label27.getHeight() + Constants.GAP_WIDTH,
				Constants.PANEL_COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		panel3.add(label28);
		textField6 = new JTextField();
		textField6.setBounds(label28.getX() + label28.getWidth() + Constants.GAP_WIDTH,
				comboBox3.getY() + comboBox3.getHeight() + Constants.GAP_WIDTH,
				panel3.getWidth() - Constants.PANEL_COMPONENT_WIDTH - 2 * Constants.GAP_WIDTH,
				Constants.COMPONENT_HEIGHT);
		panel3.add(textField6);

		checkBox8 = new JCheckBox();
		checkBox8.setText("显示BIP85");
		checkBox8.setBounds(label28.getX() + label28.getWidth() + Constants.GAP_WIDTH,
				textField6.getY() + textField6.getHeight() + Constants.GAP_WIDTH, Constants.PANEL_COMPONENT_WIDTH,
				Constants.COMPONENT_HEIGHT);
		checkBox8.addItemListener(new ItemListener()
		{
			@Override
			public void itemStateChanged(ItemEvent e)
			{
				if (e.getStateChange() == ItemEvent.SELECTED)
				{
					panel4.setVisible(true);
				}
				else
				{
					panel4.setVisible(false);
				}
			}
		});
		panel3.add(checkBox8);

		initPanel4();

		mainPanel.add(panel3);
	}

	private void initPanel4()
	{
		// ----------------------------------------------显示BIP85面板----------------------------------------
		panel4 = new JPanel();
		panel4.setLayout(null);
		panel4.setBounds(Constants.GAP_WIDTH, checkBox8.getY() + checkBox8.getHeight() + Constants.GAP_WIDTH,
				panel3.getWidth(), 300);
		panel4.setVisible(true);

		JLabel label37 = new JLabel();
		label37.setText("警告");
		label37.setBounds(Constants.GAP_WIDTH, Constants.GAP_WIDTH, Constants.PANEL_COMPONENT_WIDTH,
				Constants.COMPONENT_HEIGHT);
		panel4.add(label37);

		textPane4 = new JTextPane();
		textPane4.setText("这是一个高级功能，只有了解其作用才可使用。下面显示的“BIP85 子密钥”字段的值未在本页面的其他地方使用。它可以用作新密钥。"
				+ "对于BIP39申请，您可以将其粘贴到“BIP39助记词”字段中作为新的助记词使用。请阅读 BIP85规范 以获取更多信息。");
		textPane4.setBounds(label37.getX() + label37.getWidth() + Constants.GAP_WIDTH, Constants.GAP_WIDTH,
				panel4.getWidth() - Constants.PANEL_COMPONENT_WIDTH - 3 * Constants.GAP_WIDTH,
				Constants.COMPONENT_HEIGHT * 3);
		panel4.add(textPane4);

		JLabel label29 = new JLabel();
		label29.setText("BIP85应用");
		label29.setBounds(Constants.GAP_WIDTH, textPane4.getY() + textPane4.getHeight() + Constants.GAP_WIDTH,
				Constants.PANEL_COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		panel4.add(label29);
		comboBox6 = new JComboBox<String>();
		comboBox6.setBounds(label29.getX() + label29.getWidth() + Constants.GAP_WIDTH,
				textPane4.getY() + textPane4.getHeight() + Constants.GAP_WIDTH,
				panel4.getWidth() - Constants.PANEL_COMPONENT_WIDTH - 2 * Constants.GAP_WIDTH,
				Constants.COMPONENT_HEIGHT);
		comboBox6.addItem("BIP39");
		comboBox6.addItem("WIF");
		comboBox6.addItem("Xprv");
		comboBox6.addItem("Hex");
		comboBox6.setSelectedIndex(0);
		panel4.add(comboBox6);

		JLabel label30 = new JLabel();
		label30.setText("BIP85 助记符语言");
		label30.setBounds(Constants.GAP_WIDTH, label29.getY() + label29.getHeight() + Constants.GAP_WIDTH,
				Constants.PANEL_COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		panel4.add(label30);
		comboBox5 = new JComboBox<String>();
		comboBox5.setBounds(label30.getX() + label30.getWidth() + Constants.GAP_WIDTH,
				comboBox6.getY() + comboBox6.getHeight() + Constants.GAP_WIDTH,
				panel4.getWidth() - Constants.PANEL_COMPONENT_WIDTH - 3 * Constants.GAP_WIDTH,
				Constants.COMPONENT_HEIGHT);
		comboBox5.addItem("英语");
		panel4.add(comboBox5);

		JLabel label31 = new JLabel();
		label31.setText("BIP85 助记词长度");
		label31.setBounds(Constants.GAP_WIDTH, label30.getY() + label30.getHeight() + Constants.GAP_WIDTH,
				Constants.PANEL_COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		panel4.add(label31);
		comboBox4 = new JComboBox<String>();
		comboBox4.setBounds(label31.getX() + label31.getWidth() + Constants.GAP_WIDTH,
				comboBox5.getY() + comboBox5.getHeight() + Constants.GAP_WIDTH,
				panel4.getWidth() - Constants.PANEL_COMPONENT_WIDTH - 3 * Constants.GAP_WIDTH,
				Constants.COMPONENT_HEIGHT);
		comboBox4.addItem("12");
		comboBox4.addItem("18");
		comboBox4.addItem("24");
		comboBox4.setSelectedIndex(0);
		panel4.add(comboBox4);

		JLabel label32 = new JLabel();
		label32.setText("BIP85指数");
		label32.setBounds(Constants.GAP_WIDTH, label31.getY() + label31.getHeight() + Constants.GAP_WIDTH,
				Constants.PANEL_COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		panel4.add(label32);
		textField9 = new JTextField();
		textField9.setBounds(label32.getX() + label32.getWidth() + Constants.GAP_WIDTH,
				comboBox4.getY() + comboBox4.getHeight() + Constants.GAP_WIDTH,
				panel4.getWidth() - Constants.PANEL_COMPONENT_WIDTH - 3 * Constants.GAP_WIDTH,
				Constants.COMPONENT_HEIGHT);
		panel4.add(textField9);

		JLabel label33 = new JLabel();
		label33.setText("BIP85子密钥");
		label33.setBounds(Constants.GAP_WIDTH, label32.getY() + label32.getHeight() + Constants.GAP_WIDTH,
				Constants.PANEL_COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		panel4.add(label33);
		textField8 = new JTextField();
		textField8.setBounds(label33.getX() + label33.getWidth() + Constants.GAP_WIDTH,
				textField9.getY() + textField9.getHeight() + Constants.GAP_WIDTH,
				panel4.getWidth() - Constants.PANEL_COMPONENT_WIDTH - 3 * Constants.GAP_WIDTH,
				Constants.COMPONENT_HEIGHT * 2);
		panel4.add(textField8);
		panel3.add(panel4);
	}

	private void initPanel2()
	{
		// ----------------------------------自定义熵------------------------------------
		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(Constants.GAP_WIDTH, panel1.getY() + panel1.getHeight() + Constants.GAP_WIDTH,
				Constants.INNER_PANEL_WIDTH, Constants.COMPONENT_HEIGHT);
		// panel2.setPreferredSize(new Dimension(Constants.PANEL_WIDTH, Constants.COMPONENT_HEIGHT));

		checkBox1 = new JCheckBox();
		checkBox1.setText("显示熵详细信息");
		checkBox1.setBounds(Constants.GAP_WIDTH * 2 + Constants.PANEL_COMPONENT_WIDTH, Constants.GAP_WIDTH,
				Constants.PANEL_COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		checkBox1.addItemListener(new ItemListener()
		{
			@Override
			public void itemStateChanged(ItemEvent e)
			{
				if (e.getStateChange() == ItemEvent.SELECTED)
				{
					panel1.setVisible(true);
				}
				else
				{
					panel1.setVisible(false);
				}
			}
		});
		panel2.add(checkBox1);

		checkBox2 = new JCheckBox();
		checkBox2.setText("隐藏所有私人信息");
		checkBox2.setBounds(checkBox1.getX() + checkBox1.getWidth() + Constants.GAP_WIDTH * 2, Constants.GAP_WIDTH,
				Constants.PANEL_COMPONENT_WIDTH * 4 / 3, Constants.COMPONENT_HEIGHT);
		panel2.add(checkBox2);

		checkBox3 = new JCheckBox();
		checkBox3.setText("自动计算");
		checkBox3.setBounds(checkBox2.getX() + checkBox2.getWidth() + Constants.GAP_WIDTH * 2, Constants.GAP_WIDTH,
				Constants.PANEL_COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		panel2.add(checkBox3);
		mainPanel.add(panel2);
	}

	private void initPanel1()
	{
		// ----------------------------------助记词------------------------------------
		panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(Constants.GAP_WIDTH, panel0.getY() + panel0.getHeight() + Constants.GAP_WIDTH,
				Constants.INNER_PANEL_WIDTH, 330);
		panel1.setVisible(true);
		JLabel warningLabel = new JLabel("警告");
		warningLabel.setBounds(Constants.GAP_WIDTH, 0, Constants.PANEL_COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		panel1.add(warningLabel);
		JLabel label17 = new JLabel();
		label17.setText("熵是一项高级功能。如果使用不当，您的助记词可能会不安全");
		label17.setBounds(Constants.GAP_WIDTH * 2 + warningLabel.getWidth(), 0, 400, Constants.COMPONENT_HEIGHT);
		panel1.add(label17);
		JLabel label45 = new JLabel();
		label45.setText("熵");
		label45.setBounds(Constants.GAP_WIDTH, warningLabel.getY() + warningLabel.getHeight(),
				Constants.PANEL_COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		panel1.add(label45);
		textField1 = new JTextField();
		panel1.add(textField1);
		textField1.setBounds(Constants.GAP_WIDTH * 2 + warningLabel.getWidth(),
				warningLabel.getY() + warningLabel.getHeight(),
				panel1.getWidth() - label45.getWidth() - Constants.GAP_WIDTH * 3, Constants.COMPONENT_HEIGHT);
		JLabel label2 = new JLabel();
		label2.setText("破解时间");
		label2.setBounds(textField1.getX(), textField1.getY() + textField1.getHeight() + Constants.GAP_WIDTH,
				Constants.PANEL_COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		panel1.add(label2);

		JLabel label38 = new JLabel();
		label38.setText("text");
		label38.setBounds(textField1.getX() + label2.getWidth(),
				textField1.getY() + textField1.getHeight() + Constants.GAP_WIDTH, Constants.PANEL_COMPONENT_WIDTH,
				Constants.COMPONENT_HEIGHT);
		panel1.add(label38);

		JLabel label3 = new JLabel();
		label3.setText("熵类型");
		label3.setBounds(textField1.getX(), label2.getY() + label2.getHeight(), Constants.PANEL_COMPONENT_WIDTH,
				Constants.COMPONENT_HEIGHT);
		panel1.add(label3);

		JLabel label39 = new JLabel();
		label39.setText("text");
		label39.setBounds(textField1.getX() + label3.getWidth(), label2.getY() + label2.getHeight(),
				Constants.PANEL_COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		panel1.add(label39);

		JLabel label4 = new JLabel();
		label4.setText("原始熵词");
		label4.setBounds(textField1.getX(), label3.getY() + label3.getHeight(), Constants.PANEL_COMPONENT_WIDTH,
				Constants.COMPONENT_HEIGHT);
		panel1.add(label4);

		JLabel label40 = new JLabel();
		label40.setText("text");
		label40.setBounds(textField1.getX() + label4.getWidth(), label3.getY() + label3.getHeight(),
				Constants.PANEL_COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		panel1.add(label40);

		JLabel label5 = new JLabel();
		label5.setText("过滤熵");
		label5.setBounds(textField1.getX(), label4.getY() + label4.getHeight(), Constants.PANEL_COMPONENT_WIDTH,
				Constants.COMPONENT_HEIGHT);
		panel1.add(label5);

		JLabel label41 = new JLabel();
		label41.setText("text");
		label41.setBounds(textField1.getX() + label5.getWidth(), label4.getY() + label4.getHeight(),
				Constants.PANEL_COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		panel1.add(label41);

		JLabel label6 = new JLabel();
		label6.setText("原始二进制");
		label6.setBounds(textField1.getX(), label5.getY() + label5.getHeight(), Constants.PANEL_COMPONENT_WIDTH,
				Constants.COMPONENT_HEIGHT);
		panel1.add(label6);

		JLabel label42 = new JLabel();
		label42.setText("text");
		label42.setBounds(textField1.getX() + label6.getWidth(), label5.getY() + label5.getHeight(),
				Constants.PANEL_COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		panel1.add(label42);

		JLabel label7 = new JLabel();
		label7.setText("二进制校验和");
		label7.setBounds(textField1.getX(), label6.getY() + label6.getHeight(), Constants.PANEL_COMPONENT_WIDTH,
				Constants.COMPONENT_HEIGHT);
		panel1.add(label7);

		JLabel label43 = new JLabel();
		label43.setText("text");
		label43.setBounds(textField1.getX() + label7.getWidth(), label6.getY() + label6.getHeight(),
				Constants.PANEL_COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		panel1.add(label43);

		JLabel label8 = new JLabel();
		label8.setText("单词索引");
		label8.setBounds(textField1.getX(), label7.getY() + label7.getHeight(), Constants.PANEL_COMPONENT_WIDTH,
				Constants.COMPONENT_HEIGHT);
		panel1.add(label8);

		JLabel label44 = new JLabel();
		label44.setText("text");
		label44.setBounds(textField1.getX() + label8.getWidth(), label7.getY() + label7.getHeight(),
				Constants.PANEL_COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		panel1.add(label44);

		JLabel label15 = new JLabel();
		label15.setText("助记词长度");
		label15.setBounds(textField1.getX(), label8.getY() + label8.getHeight(), Constants.PANEL_COMPONENT_WIDTH,
				Constants.COMPONENT_HEIGHT);
		panel1.add(label15);
		comboBox1 = new JComboBox<String>();
		comboBox1.setBounds(textField1.getX() + label15.getWidth(), label8.getY() + label8.getHeight(),
				Constants.PANEL_COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		panel1.add(comboBox1);

		JLabel label16 = new JLabel();
		label16.setText("PBKDF2轮");
		label16.setBounds(textField1.getX(), label15.getY() + label15.getHeight(), Constants.PANEL_COMPONENT_WIDTH,
				Constants.COMPONENT_HEIGHT);
		panel1.add(label16);
		comboBox2 = new JComboBox<String>();
		comboBox2.setBounds(textField1.getX() + label16.getWidth(), label15.getY() + label15.getHeight(),
				Constants.PANEL_COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		panel1.add(comboBox2);

		JLabel label10 = new JLabel();
		label10.setText("事件计数");
		label10.setBounds(label38.getX() + label2.getWidth() + Constants.GAP_WIDTH,
				textField1.getY() + textField1.getHeight() + Constants.GAP_WIDTH, Constants.PANEL_COMPONENT_WIDTH,
				Constants.COMPONENT_HEIGHT);
		panel1.add(label10);
		JLabel label138 = new JLabel();
		label138.setText("text");
		label138.setBounds(label10.getX() + label10.getWidth(),
				textField1.getY() + textField1.getHeight() + Constants.GAP_WIDTH, Constants.PANEL_COMPONENT_WIDTH,
				Constants.COMPONENT_HEIGHT);
		panel1.add(label138);

		JLabel label11 = new JLabel();
		label11.setText("事件平均比特数");
		label11.setBounds(label38.getX() + label2.getWidth() + Constants.GAP_WIDTH,
				label10.getY() + label10.getHeight(), Constants.PANEL_COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		panel1.add(label11);
		JLabel label139 = new JLabel();
		label139.setText("text");
		label139.setBounds(label10.getX() + label10.getWidth(),
				label138.getY() + label138.getHeight() + Constants.GAP_WIDTH, Constants.PANEL_COMPONENT_WIDTH,
				Constants.COMPONENT_HEIGHT);
		panel1.add(label139);

		JLabel label12 = new JLabel();
		label12.setText("总比特数");
		label12.setBounds(label38.getX() + label2.getWidth() + Constants.GAP_WIDTH,
				label11.getY() + label11.getHeight(), Constants.PANEL_COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		panel1.add(label12);
		JLabel label140 = new JLabel();
		label140.setText("text");
		label140.setBounds(label10.getX() + label10.getWidth(),
				label139.getY() + label139.getHeight() + Constants.GAP_WIDTH, Constants.PANEL_COMPONENT_WIDTH,
				Constants.COMPONENT_HEIGHT);
		panel1.add(label140);

		JLabel label14 = new JLabel();
		label14.setText("有效的熵值包括");
		label14.setBounds(label138.getX() + label138.getWidth() + Constants.GAP_WIDTH,
				textField1.getY() + textField1.getHeight() + Constants.GAP_WIDTH, Constants.PANEL_COMPONENT_WIDTH,
				Constants.COMPONENT_HEIGHT);
		panel1.add(label14);

		radioButton1 = new JRadioButton();
		radioButton1.setText("二进制[0-1]");
		radioButton1.setBounds(label138.getX() + label138.getWidth() + Constants.GAP_WIDTH,
				label14.getY() + label14.getHeight() + Constants.GAP_WIDTH,
				(int) (Constants.PANEL_COMPONENT_WIDTH * 1.2f), Constants.COMPONENT_HEIGHT);
		panel1.add(radioButton1);
		JLabel label9 = new JLabel();
		label9.setText("101010011");
		label9.setBounds(radioButton1.getX() + radioButton1.getWidth(),
				label14.getY() + label14.getHeight() + Constants.GAP_WIDTH,
				(int) (Constants.PANEL_COMPONENT_WIDTH * 1.2f), Constants.COMPONENT_HEIGHT);
		panel1.add(label9);

		radioButton2 = new JRadioButton();
		radioButton2.setText("基数[0-5]");
		radioButton2.setBounds(label138.getX() + label138.getWidth() + Constants.GAP_WIDTH,
				radioButton1.getY() + radioButton1.getHeight() + Constants.GAP_WIDTH,
				(int) (Constants.PANEL_COMPONENT_WIDTH * 1.2f), Constants.COMPONENT_HEIGHT);
		panel1.add(radioButton2);
		JLabel label13 = new JLabel();
		label13.setText("123434014");
		label13.setBounds(radioButton2.getX() + radioButton2.getWidth(),
				radioButton1.getY() + radioButton1.getHeight() + Constants.GAP_WIDTH,
				(int) (Constants.PANEL_COMPONENT_WIDTH * 1.2f), Constants.COMPONENT_HEIGHT);
		panel1.add(label13);

		radioButton3 = new JRadioButton();
		radioButton3.setText("骰子[1-6]");
		radioButton3.setBounds(label138.getX() + label138.getWidth() + Constants.GAP_WIDTH,
				radioButton2.getY() + radioButton2.getHeight() + Constants.GAP_WIDTH,
				(int) (Constants.PANEL_COMPONENT_WIDTH * 1.2f), Constants.COMPONENT_HEIGHT);
		panel1.add(radioButton3);
		JLabel label18 = new JLabel();
		label18.setText("62535634");
		label18.setBounds(radioButton3.getX() + radioButton3.getWidth(),
				radioButton2.getY() + radioButton2.getHeight() + Constants.GAP_WIDTH,
				(int) (Constants.PANEL_COMPONENT_WIDTH * 1.2f), Constants.COMPONENT_HEIGHT);
		panel1.add(label18);

		radioButton4 = new JRadioButton();
		radioButton4.setText("基数10 [0-9]");
		radioButton4.setBounds(label138.getX() + label138.getWidth() + Constants.GAP_WIDTH,
				radioButton3.getY() + radioButton3.getHeight() + Constants.GAP_WIDTH,
				(int) (Constants.PANEL_COMPONENT_WIDTH * 1.2f), Constants.COMPONENT_HEIGHT);
		panel1.add(radioButton4);
		JLabel label19 = new JLabel();
		label19.setText("90834528");
		label19.setBounds(radioButton4.getX() + radioButton4.getWidth(),
				radioButton3.getY() + radioButton3.getHeight() + Constants.GAP_WIDTH,
				(int) (Constants.PANEL_COMPONENT_WIDTH * 1.2f), Constants.COMPONENT_HEIGHT);
		panel1.add(label19);

		radioButton5 = new JRadioButton();
		radioButton5.setText("16进制[0-9A-F]");
		radioButton5.setBounds(label138.getX() + label138.getWidth() + Constants.GAP_WIDTH,
				radioButton4.getY() + radioButton4.getHeight() + Constants.GAP_WIDTH,
				(int) (Constants.PANEL_COMPONENT_WIDTH * 1.2f), Constants.COMPONENT_HEIGHT);
		panel1.add(radioButton5);
		JLabel label20 = new JLabel();
		label20.setText("4187a8bfd9");
		label20.setBounds(radioButton5.getX() + radioButton5.getWidth(),
				radioButton4.getY() + radioButton4.getHeight() + Constants.GAP_WIDTH,
				(int) (Constants.PANEL_COMPONENT_WIDTH * 1.2f), Constants.COMPONENT_HEIGHT);
		panel1.add(label20);

		radioButton6 = new JRadioButton();
		radioButton6.setText("卡[A2-9TJQK][CDHS]");
		radioButton6.setBounds(label138.getX() + label138.getWidth() + Constants.GAP_WIDTH,
				radioButton5.getY() + radioButton5.getHeight() + Constants.GAP_WIDTH,
				(int) (Constants.PANEL_COMPONENT_WIDTH * 1.2f), Constants.COMPONENT_HEIGHT);
		panel1.add(radioButton6);
		JLabel label21 = new JLabel();
		label21.setText("ahqs9dtc");
		label21.setBounds(radioButton6.getX() + radioButton6.getWidth(),
				radioButton5.getY() + radioButton5.getHeight() + Constants.GAP_WIDTH,
				(int) (Constants.PANEL_COMPONENT_WIDTH * 1.2f), Constants.COMPONENT_HEIGHT);
		panel1.add(label21);
		mainPanel.add(panel1);
	}

	private void initPanel0()
	{
		panel0 = new JPanel();
		panel0.setLayout(null);
		panel0.setBounds(Constants.GAP_WIDTH, Constants.GAP_WIDTH, Constants.INNER_PANEL_WIDTH, 160);
		panel0.setVisible(true);

		JLabel label1 = new JLabel();
		label1.setBounds(Constants.GAP_WIDTH, Constants.GAP_WIDTH, Constants.PANEL_COMPONENT_WIDTH,
				Constants.COMPONENT_HEIGHT);
		label1.setText("助记词");
		panel0.add(label1);

		JLabel label5698 = new JLabel();
		label5698.setText("您可以输入现有的 BIP39 助记符，也可以生成新的随机助记符。输入您自己的十二个单词可能不会像您预期的那样有效，因为这些单词需要特定的结构（最后一个单词包含校验和）。\r\n"
				+ "有关更多信息，请参阅 BIP39 规范。如果您将此页面生成的信息分享给任何人，他们可能会窃取您的资产。任何要求您分享您的秘密恢复短语或 BIP 32 根密钥的人都是骗子。\r\n"
				+ "请勿复制和粘贴此页面上的信息，或将其发送给任何在 Twitter、Discord、Telegram、Etherscan 或 Line 上愿意帮助您的人。 他们会窃取您的硬币。");
		label5698.setBounds(label1.getX() + label1.getWidth() + Constants.GAP_WIDTH, Constants.GAP_WIDTH,
				panel0.getWidth() - Constants.PANEL_COMPONENT_WIDTH - 3 * Constants.GAP_WIDTH,
				Constants.COMPONENT_HEIGHT * 3);
		panel0.add(label5698);

		JLabel label111 = new JLabel();
		label111.setText("生成随机助记词：");
		label111.setBounds(Constants.GAP_WIDTH, label5698.getY() + label5698.getHeight() + Constants.GAP_WIDTH,
				Constants.PANEL_COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		panel0.add(label111);

		JButton generateBtn = new JButton("生成");
		generateBtn.setBounds(label111.getX() + label111.getWidth() + Constants.GAP_WIDTH,
				label5698.getY() + label5698.getHeight() + Constants.GAP_WIDTH, Constants.PANEL_COMPONENT_WIDTH / 2,
				Constants.COMPONENT_HEIGHT);
		panel0.add(generateBtn);

		JComboBox<String> comboBox111 = new JComboBox<>();
		comboBox111.setBounds(generateBtn.getX() + generateBtn.getWidth() + Constants.GAP_WIDTH,
				label5698.getY() + label5698.getHeight() + Constants.GAP_WIDTH, Constants.PANEL_COMPONENT_WIDTH / 2,
				Constants.COMPONENT_HEIGHT);
		comboBox111.addItem("3");
		comboBox111.addItem("6");
		comboBox111.addItem("9");
		comboBox111.addItem("12");
		comboBox111.addItem("15");
		comboBox111.addItem("18");
		comboBox111.addItem("21");
		comboBox111.addItem("24");
		comboBox111.setSelectedIndex(3);
		panel0.add(comboBox111);

		JLabel label112 = new JLabel();
		label112.setText("个单词，或者在下面输入您自己的单词。");
		label112.setBounds(comboBox111.getX() + comboBox111.getWidth() + Constants.GAP_WIDTH,
				label5698.getY() + label5698.getHeight() + Constants.GAP_WIDTH, Constants.PANEL_COMPONENT_WIDTH * 3,
				Constants.COMPONENT_HEIGHT);
		panel0.add(label112);
		mainPanel.add(panel0);
	}
}
