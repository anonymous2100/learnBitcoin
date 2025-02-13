package com.ctgu.ui;

import java.awt.Font;

import javax.swing.JComponent;

import com.ctgu.util.ConfigUtil;

/**
 * customize Swing component style
 */
public class Style
{
	/**
	 * emphatic font for title
	 *
	 * @param component
	 */
	public static void emphaticTitleFont(JComponent component)
	{
		Font font = new Font(ConfigUtil.getInstance().getFont(), Font.PLAIN, ConfigUtil.getInstance().getFontSize());
		component.setFont(new Font(font.getName(), Font.BOLD, font.getSize() + 2));
	}

	/**
	 * emphatic font for label
	 *
	 * @param component
	 */
	public static void emphaticLabelFont(JComponent component)
	{
		Font font = new Font(ConfigUtil.getInstance().getFont(), Font.PLAIN, ConfigUtil.getInstance().getFontSize());
		component.setFont(new Font(font.getName(), Font.BOLD, font.getSize()));
	}

	/**
	 * emphatic font for indicator
	 *
	 * @param component
	 */
	public static void emphaticIndicatorFont(JComponent component)
	{
		Font font = new Font(ConfigUtil.getInstance().getFont(), Font.PLAIN, ConfigUtil.getInstance().getFontSize());
		component.setFont(new Font(font.getName(), Font.BOLD, font.getSize() + 12));
	}
}
