package com.ctgu.util;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.File;

/**
 * System util
 */
public class SystemUtil
{
	private static final String OS_NAME = System.getProperty("os.name");
	private static final String OS_ARCH = System.getProperty("os.arch");
	private static final String VM_VENDOR = System.getProperty("java.vm.vendor");
	private static final String USER_HOME = System.getProperty("user.home");
	public static final String CONFIG_HOME = USER_HOME + File.separator + ".learnBitcoin";

	/**
	 * log file dir
	 */
	public final static String LOG_DIR = USER_HOME + File.separator + ".learnBitcoin" + File.separator + "logs"
			+ File.separator;

	public static boolean isMacOs()
	{
		return OS_NAME.contains("Mac");
	}

	public static boolean isMacM1()
	{
		return OS_NAME.contains("Mac") && "aarch64".equals(OS_ARCH);
	}

	public static boolean isWindowsOs()
	{
		return OS_NAME.contains("Windows");
	}

	public static boolean isLinuxOs()
	{
		return OS_NAME.contains("Linux");
	}

	public static boolean isJBR()
	{
		return VM_VENDOR.contains("JetBrains");
	}

	/**
	 * 将字符串复制到剪切板。
	 */
	public static void setSysClipboardText(String writeMe)
	{
		Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable tText = new StringSelection(writeMe);
		clip.setContents(tText, null);
	}

	public static String toReadableTime(long seconds)
	{
		String readableTime;
		int hours = (int) (seconds / 3600);
		int minutes = (int) (seconds % 3600 / 60);
		readableTime = String.format("%dh:%02dmin", hours, minutes);
		return readableTime;
	}
}