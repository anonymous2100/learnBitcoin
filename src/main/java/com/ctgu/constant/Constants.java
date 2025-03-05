package com.ctgu.constant;

import java.awt.Image;
import java.awt.Toolkit;

public class Constants
{
	public static final String AUTHOR_BTC_ADDRESS = "bc1qgd53szzk6x8xmr7ncglcavqqpmzdkvpxd7yvtg";

	public static final String APP_NAME = "LearnBitcoin";
	public static final String APP_VERSION = "0.0.3";
	public static final String APP_RESPOSITORY_HOME = "https://github.com/anonymous2100";
	public static final String APP_RESPOSITORY_URL = "https://github.com/anonymous2100/learnBitcoin";
	public static final String APP_RESPOSITORY_ISSUE_URL = "https://github.com/anonymous2100/learnBitcoin/issues";

	public static final int TABLE_ROW_HEIGHT = 36;

	/**
	 * Logo-1024*1024
	 */
	public static final Image IMAGE_LOGO_1024 = Toolkit.getDefaultToolkit().getImage(
			Constants.class.getResource("/icons/logo-1024.png"));

	/**
	 * Logo-512*512
	 */
	public static final Image IMAGE_LOGO_512 = Toolkit.getDefaultToolkit().getImage(
			Constants.class.getResource("/icons/logo-512.png"));

	/**
	 * Logo-256*256
	 */
	public static final Image IMAGE_LOGO_256 = Toolkit.getDefaultToolkit().getImage(
			Constants.class.getResource("/icons/logo-256.png"));

	/**
	 * Logo-128*128
	 */
	public static final Image IMAGE_LOGO_128 = Toolkit.getDefaultToolkit().getImage(
			Constants.class.getResource("/icons/logo-128.png"));

	/**
	 * Logo-64*64
	 */
	public static final Image IMAGE_LOGO_64 = Toolkit.getDefaultToolkit().getImage(
			Constants.class.getResource("/icons/logo-64.png"));

	/**
	 * Logo-48*48
	 */
	public static final Image IMAGE_LOGO_48 = Toolkit.getDefaultToolkit().getImage(
			Constants.class.getResource("/icons/logo-48.png"));

	/**
	 * Logo-32*32
	 */
	public static final Image IMAGE_LOGO_32 = Toolkit.getDefaultToolkit().getImage(
			Constants.class.getResource("/icons/logo-32.png"));

	/**
	 * Logo-24*24
	 */
	public static final Image IMAGE_LOGO_24 = Toolkit.getDefaultToolkit().getImage(
			Constants.class.getResource("/icons/logo-24.png"));

	/**
	 * Logo-16*16
	 */
	public static final Image IMAGE_LOGO_16 = Toolkit.getDefaultToolkit().getImage(
			Constants.class.getResource("/icons/logo-16.png"));

	/**
	 * update checking url
	 */
	public static final String CHECK_VERSION_URL = "https://github.com/anonymous2100/learnBitcoin/raw/master/src/main/resources/version_summary.json";

	public static final int REFRESH_FAST = 1000;
	public static final int REFRESH_SLOW = 5000;

	public static final int REFRESH_SLOWER = 15_000;
	
	
	
	public static final int PANEL_WIDTH = 1100;
	public static final int INNER_PANEL_WIDTH = 1150;
	public static final int PANEL_HEIGHT = 600;
	public static final int COMPONENT_WIDTH = 780;
	public static final int COMPONENT_HEIGHT = 28;
	public static final int BUTTON_WIDTH = 120;
	public static final int BUTTON_HEIGHT = COMPONENT_HEIGHT;
	public static final int GAP_WIDTH = 5;

	public static final int PANEL_COMPONENT_WIDTH = 150;
}