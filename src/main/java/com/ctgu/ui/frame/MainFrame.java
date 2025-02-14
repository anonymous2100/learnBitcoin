package com.ctgu.ui.frame;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.ctgu.constant.Constants;
import com.ctgu.ui.Init;
import com.ctgu.ui.component.TopMenuBar;
import com.ctgu.ui.form.AllVanityAddressPanel;
import com.ctgu.ui.form.BitcoinAddressPanel;
import com.ctgu.ui.form.BitcoinAddressPanel2;
import com.ctgu.ui.form.BrainwalletPanel;
import com.ctgu.ui.form.PrivateKeyPanel;
import com.ctgu.ui.form.VanityAddressPanel;
import com.ctgu.ui.form.VanityMultiplyAddressPanel;
import com.ctgu.ui.form.VanitySumAddressPanel;
import com.formdev.flatlaf.extras.FlatSVGUtils;

public class MainFrame extends JFrame
{
	private static final long serialVersionUID = -7360309535472857266L;

	private JTabbedPane tabbedPane;
	private JPanel mainPanel;

	private BitcoinAddressPanel botcoinAddressPanel;
	private BitcoinAddressPanel2 botcoinAddressPanel2;
	private VanityMultiplyAddressPanel vanityMultiplyAddressPanel;
	private PrivateKeyPanel privateKeyPanel;
	private BrainwalletPanel brainwalletPanel;
	private VanitySumAddressPanel vanitySumAddressPanel;
	private VanityAddressPanel vanityAddressPanel;
	private AllVanityAddressPanel allVanityAddressPanel;

	public MainFrame()
	{
		this.setName(Constants.APP_NAME);
		this.setTitle(Constants.APP_NAME);
		this.setSize(1200, 1350);
		setIconImages(FlatSVGUtils.createWindowIconImages("/icons/coin-bitcoin.svg"));

		TopMenuBar topMenuBar = TopMenuBar.getInstance();
		topMenuBar.init();
		setJMenuBar(topMenuBar);

		Init.initGlobalFont();
		setupUI();
	}

	private void setupUI()
	{
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.green);
		this.setContentPane(mainPanel);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(0, 0, 1100, 1350);

		botcoinAddressPanel = new BitcoinAddressPanel();
		tabbedPane.addTab("未压缩公钥比特币地址", botcoinAddressPanel);

		botcoinAddressPanel2 = new BitcoinAddressPanel2();
		tabbedPane.addTab("压缩公钥比特币地址", botcoinAddressPanel2);

		privateKeyPanel = new PrivateKeyPanel();
		tabbedPane.addTab("私钥格式转换", privateKeyPanel);

		vanityAddressPanel = new VanityAddressPanel();
		tabbedPane.addTab("虚荣地址", vanityAddressPanel);

		allVanityAddressPanel = new AllVanityAddressPanel();
		tabbedPane.addTab("所有虚荣地址", allVanityAddressPanel);

		vanitySumAddressPanel = new VanitySumAddressPanel();
		tabbedPane.addTab("Storage", vanitySumAddressPanel);

		vanityMultiplyAddressPanel = new VanityMultiplyAddressPanel();
		tabbedPane.addTab("Network", vanityMultiplyAddressPanel);

		brainwalletPanel = new BrainwalletPanel();
		tabbedPane.addTab("脑钱包", brainwalletPanel);

		mainPanel.add(tabbedPane);
	}
}
