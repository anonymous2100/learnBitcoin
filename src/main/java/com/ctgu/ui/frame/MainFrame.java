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
		this.setSize(1100, 1250);
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
		tabbedPane.setBounds(0, 0, 1100, 1250);

		botcoinAddressPanel = new BitcoinAddressPanel();
		tabbedPane.addTab("未压缩公钥比特币地址", botcoinAddressPanel);
		botcoinAddressPanel2 = new BitcoinAddressPanel2();
		tabbedPane.addTab("压缩公钥比特币地址", botcoinAddressPanel2);

		privateKeyPanel = new PrivateKeyPanel();
		vanityAddressPanel = new VanityAddressPanel();
		allVanityAddressPanel = new AllVanityAddressPanel();
		vanitySumAddressPanel = new VanitySumAddressPanel();
		vanityMultiplyAddressPanel = new VanityMultiplyAddressPanel();
		brainwalletPanel = new BrainwalletPanel();
		tabbedPane.addTab("Detail", privateKeyPanel);
		tabbedPane.addTab("Memory", vanityAddressPanel);
		tabbedPane.addTab("CPU", allVanityAddressPanel);
		tabbedPane.addTab("Storage", vanitySumAddressPanel);
		tabbedPane.addTab("Network", vanityMultiplyAddressPanel);
		tabbedPane.addTab("Variables", brainwalletPanel);

		mainPanel.add(tabbedPane);
	}
}
