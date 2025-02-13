package com.ctgu.util;

import javax.swing.*;

/**
 * some functions about scroll
 */
public class ScrollUtil
{
	public static void smoothPane(JScrollPane scrollPane)
	{
		scrollPane.getVerticalScrollBar().setUnitIncrement(14);
		scrollPane.getHorizontalScrollBar().setUnitIncrement(14);
		scrollPane.getVerticalScrollBar().setDoubleBuffered(true);
		scrollPane.getHorizontalScrollBar().setDoubleBuffered(true);
	}
}
