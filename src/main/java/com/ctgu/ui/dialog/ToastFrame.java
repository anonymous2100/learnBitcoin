package com.ctgu.ui.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class ToastFrame extends JFrame
{
	private static final long serialVersionUID = -1072559780508199525L;

	private ImageIcon background;
	private JLabel text;
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screensize = tk.getScreenSize();
	int height = screensize.height;
	int width = screensize.width;
	private String str = null;

	public ToastFrame(String str)
	{
		this.str = str;
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				initGUI(null);
			}
		}).start();
	}

	public ToastFrame(String str, final Integer time)
	{
		this.str = str;
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				initGUI(time);
			}
		}).start();
	}

	public static String getBasePath()
	{
		String basePath = ToastFrame.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		try
		{
			basePath = URLDecoder.decode(basePath, StandardCharsets.UTF_8.name());
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		basePath = basePath.replace('/', System.getProperty("file.separator").charAt(0));

		int firstIndex = basePath.indexOf(System.getProperty("file.separator")) + 1;
		int lastIndex = basePath.lastIndexOf(System.getProperty("file.separator")) + 1;
		basePath = basePath.substring(firstIndex, lastIndex);

		basePath = basePath + "config" + System.getProperty("file.separator");
		return basePath;
	}

	private void initGUI(Integer time)
	{
		if (time == null)
		{
			time = 2500;
		}
		try
		{
			background = new ImageIcon(ToastFrame.getBasePath() + "boards/canvas.png");
			background.setImage(background.getImage().getScaledInstance(background.getIconWidth(),
					background.getIconHeight(), Image.SCALE_DEFAULT));

			setUndecorated(true);
			setLocationRelativeTo(null);
			setVisible(true);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				text = new JLabel("<html>" + str + "</html>", JLabel.CENTER);
				text.setIcon(background);
				text.setFont(new Font("微软雅黑", Font.PLAIN, 24));
				text.setBackground(new java.awt.Color(255, 251, 240));
				text.setHorizontalTextPosition(JLabel.CENTER);
				text.setVerticalTextPosition(JLabel.CENTER);
				getContentPane().add(text, BorderLayout.CENTER);
			}
			pack();
			setBounds(width / 2 - 180, height / 2, 360, 120);
			try
			{
				Thread.sleep(time);
			}
			catch (InterruptedException e1)
			{
				e1.printStackTrace();
			}
			dispose();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}