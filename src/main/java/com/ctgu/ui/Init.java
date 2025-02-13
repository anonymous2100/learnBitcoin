package com.ctgu.ui;

import java.awt.Font;
import java.awt.Frame;
import java.util.Enumeration;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import org.apache.commons.lang3.StringUtils;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatVuesionIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatXcodeDarkIJTheme;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.ctgu.App;
import com.ctgu.ui.component.TopMenuBar;
import com.ctgu.util.SystemUtil;
import com.ctgu.util.UIUtil;
import com.ctgu.util.UpgradeUtil;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

/**
 * The init Class
 */
public class Init
{
	private static final Log logger = LogFactory.get();

	/**
	 * font size inti KEY
	 */
	private static final String FONT_SIZE_INIT_PROP = "fontSizeInit";

	/**
	 * set font for global
	 */
	public static void initGlobalFont()
	{
		if (StringUtils.isEmpty(App.config.getProps(FONT_SIZE_INIT_PROP)))
		{
			int fontSize = 14;
			if (SystemUtil.isMacOs())
			{
				fontSize = 13;
			}
			else
			{
				fontSize = 16;
			}
			App.config.setFontSize(fontSize);
			App.config.setProps(FONT_SIZE_INIT_PROP, "true");
			App.config.save();
			TopMenuBar.getInstance().initFontSizeMenu();
		}
		Font font = new Font(App.config.getFont(), Font.PLAIN, App.config.getFontSize());
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

	/**
	 * Other initialization
	 */
	public static void initOthers()
	{
	}

	/**
	 * init look and feel
	 */
	public static void initTheme()
	{
		try
		{
			switch (App.config.getTheme())
			{
				case "System Default":
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					break;
				case "Flat Light":
					FlatLightLaf.setup();
					break;
				case "Flat IntelliJ":
					FlatIntelliJLaf.setup();
					break;
				case "Flat Dark":
					FlatDarkLaf.setup();
					break;
				case "Dark purple":
					FlatDarkPurpleIJTheme.setup();
					break;
				case "IntelliJ Cyan":
					FlatCyanLightIJTheme.setup();
					break;
				case "IntelliJ Light":
					FlatLightFlatIJTheme.setup();
					break;
				case "Xcode-Dark":
					FlatXcodeDarkIJTheme.setup();
					break;
				case "Vuesion":
					FlatVuesionIJTheme.setup();
					break;
				case "Flat macOS Light":
					FlatMacLightLaf.setup();
					break;
				case "Flat macOS Dark":
					FlatMacDarkLaf.setup();
					break;
				default:
					FlatDarculaLaf.setup();
			}
			if (UIUtil.isDarkLaf())
			{
				// FlatSVGIcon.ColorFilter.getInstance().setMapper(color -> color.brighter().brighter());
			}
			else
			{
				FlatSVGIcon.ColorFilter.getInstance().setMapper(color -> color.darker().darker());
				// SwingUtilities.windowForComponent(App.mainFrame).repaint();
			}
			if (App.config.isUnifiedBackground())
			{
				UIManager.put("TitlePane.unifiedBackground", true);
			}
			// top menubar background
			UIManager.put("PopupMenu.background", UIManager.getColor("Panel.background"));
			// arrow type
			UIManager.put("Component.arrowType", "chevron");
		}
		catch (Exception e)
		{
			logger.error(e);
		}
	}

	/**
	 * init all tab
	 */
	public static void initAllTab()
	{
		// Check the new version
		if (App.config.isAutoCheckUpdate())
		{
			ScheduledThreadPoolExecutor threadPoolExecutor = new ScheduledThreadPoolExecutor(1);
			threadPoolExecutor.scheduleAtFixedRate(() -> UpgradeUtil.checkUpdate(true), 0, 24, TimeUnit.HOURS);
		}
	}

	public static void showMainFrame()
	{
		App.mainFrame.setVisible(true);
		if (App.mainFrame.getExtendedState() == Frame.ICONIFIED)
		{
			App.mainFrame.setExtendedState(Frame.NORMAL);
		}
		else if (App.mainFrame.getExtendedState() == 7)
		{
			App.mainFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
		}
		App.mainFrame.requestFocus();
	}

	public static void shutdown()
	{
		App.mainFrame.dispose();
		System.exit(0);
	}
}
