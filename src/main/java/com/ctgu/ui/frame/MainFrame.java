package com.ctgu.ui.frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.ctgu.constant.Constants;
import com.ctgu.ui.Init;
import com.ctgu.ui.component.TopMenuBar;
import com.ctgu.ui.form.BitcoinAddressPanel;
import com.ctgu.ui.form.BitcoinAddressPanel2;
import com.ctgu.ui.form.BrainwalletPanel;
import com.ctgu.ui.form.HDWalletPanel;
import com.ctgu.ui.form.PrivateKeyPanel;
import com.ctgu.ui.form.VanityAddressPanel;
import com.formdev.flatlaf.extras.FlatSVGUtils;

public class MainFrame extends JFrame
{
	private static final long serialVersionUID = -7360309535472857266L;

	private JTabbedPane tabbedPane;
	private JPanel mainPanel;

	private BitcoinAddressPanel botcoinAddressPanel;
	private BitcoinAddressPanel2 botcoinAddressPanel2;
	private PrivateKeyPanel privateKeyPanel;
	private BrainwalletPanel brainwalletPanel;
	private VanityAddressPanel vanityAddressPanel;

	private HDWalletPanel hdWalletPanel;

	public MainFrame()
	{
		this.setName(Constants.APP_NAME);
		this.setTitle(Constants.APP_NAME);
		this.setSize(1250, 1200);
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
		this.setContentPane(mainPanel);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(0, 0, 1250, 1200);

		botcoinAddressPanel = new BitcoinAddressPanel();
		tabbedPane.addTab("未压缩公钥比特币地址", botcoinAddressPanel);

		botcoinAddressPanel2 = new BitcoinAddressPanel2();
		tabbedPane.addTab("压缩公钥比特币地址", botcoinAddressPanel2);

		privateKeyPanel = new PrivateKeyPanel();
		tabbedPane.addTab("私钥格式转换", privateKeyPanel);

		hdWalletPanel = new HDWalletPanel();
		tabbedPane.addTab("身份钱包", hdWalletPanel);

		vanityAddressPanel = new VanityAddressPanel();
		tabbedPane.addTab("虚荣地址", vanityAddressPanel);

		brainwalletPanel = new BrainwalletPanel();
		tabbedPane.addTab("脑钱包", brainwalletPanel);

		tabbedPane.setSelectedIndex(3);
		mainPanel.add(tabbedPane);
	}
}
