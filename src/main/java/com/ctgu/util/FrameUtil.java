package com.ctgu.util;

import java.awt.Image;
import java.util.List;

import javax.swing.JFrame;

import com.ctgu.constant.Constants;
import com.google.common.collect.Lists;

/**
 * <pre>
 * FrameUtil
 * </pre>
 */
public class FrameUtil
{
	public static void setFrameIcon(JFrame jFrame)
	{
		List<Image> images = Lists.newArrayList();
		images.add(Constants.IMAGE_LOGO_1024);
		images.add(Constants.IMAGE_LOGO_512);
		images.add(Constants.IMAGE_LOGO_256);
		images.add(Constants.IMAGE_LOGO_128);
		images.add(Constants.IMAGE_LOGO_64);
		images.add(Constants.IMAGE_LOGO_48);
		images.add(Constants.IMAGE_LOGO_32);
		images.add(Constants.IMAGE_LOGO_24);
		images.add(Constants.IMAGE_LOGO_16);
		jFrame.setIconImages(images);
	}
}
