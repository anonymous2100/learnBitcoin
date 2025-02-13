package com.ctgu;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import com.ctgu.ui.Init;
import com.ctgu.ui.form.LoadingForm;
import com.ctgu.ui.frame.MainFrame;
import com.ctgu.util.ConfigUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App
{
	public static ConfigUtil config = ConfigUtil.getInstance();
	public static MainFrame mainFrame;

	/**
	 * 统一设置字体，父界面设置之后，所有由父界面进入的子界面都不需要再次设置字体
	 */
	private static void initGlobalFont(Font font)
	{
		FontUIResource fontRes = new FontUIResource(font);
		for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements();)
		{
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof FontUIResource)
			{
				UIManager.put(key, fontRes);
			}
		}
	}

	public static void main(String[] args)
	{
		Init.initTheme();
		initGlobalFont(new Font("微软雅黑", Font.PLAIN, 16));
		mainFrame = new MainFrame();
		JPanel loadingPanel = new LoadingForm().getLoadingPanel();
		mainFrame.add(loadingPanel);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		if (config.isDefaultMaxWindow() || screenSize.getWidth() <= 1366)
		{
			mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		}
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.remove(loadingPanel);
		mainFrame.setVisible(true);
	}
}
