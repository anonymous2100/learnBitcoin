package com.ctgu.ui.dialog;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;

import com.ctgu.App;
import com.ctgu.constant.Constants;
import com.ctgu.util.ComponentUtil;
import com.ctgu.util.ScrollUtil;
import com.ctgu.util.UpgradeUtil;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import cn.hutool.core.thread.ThreadUtil;

public class AboutDialog extends JDialog
{
	private static final long serialVersionUID = 6892126810516733539L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JLabel versionLabel;
	private JLabel codeGitHubLabel;
	private JLabel issueLabel;
	private JLabel authorLabel;
	private JLabel logoLabel;

	{
		setupUI();
	}

	public AboutDialog()
	{
		super(App.mainFrame, "关于");
		ComponentUtil.setPreferSizeAndLocateToCenter(this, 0.5, 0.64);
		setContentPane(contentPane);
		setModal(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				onOK();
			}
		});
		// call onCancel() on ESCAPE
		contentPane.registerKeyboardAction(e -> onOK(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
				JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		logoLabel.setIcon(new FlatSVGIcon("icons/bitcoin.svg"));
		versionLabel.setText(Constants.APP_VERSION);
		ScrollUtil.smoothPane(scrollPane);
		contentPane.updateUI();
		logoLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				super.mouseClicked(e);
				Desktop desktop = Desktop.getDesktop();
				try
				{
					desktop.browse(new URI(Constants.APP_RESPOSITORY_URL));
				}
				catch (IOException | URISyntaxException e1)
				{
					e1.printStackTrace();
				}
			}

			@Override
			public void mousePressed(MouseEvent e)
			{
				super.mousePressed(e);
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				super.mouseEntered(e);
				e.getComponent().setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		authorLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				super.mouseClicked(e);
				Desktop desktop = Desktop.getDesktop();
				try
				{
					desktop.browse(new URI(Constants.APP_RESPOSITORY_HOME));
				}
				catch (IOException | URISyntaxException e1)
				{
					e1.printStackTrace();
				}
			}

			@Override
			public void mousePressed(MouseEvent e)
			{
				super.mousePressed(e);
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				super.mouseEntered(e);
				e.getComponent().setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		codeGitHubLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				super.mouseClicked(e);
				Desktop desktop = Desktop.getDesktop();
				try
				{
					desktop.browse(new URI(Constants.APP_RESPOSITORY_URL));
				}
				catch (IOException | URISyntaxException e1)
				{
					e1.printStackTrace();
				}
			}

			@Override
			public void mousePressed(MouseEvent e)
			{
				super.mousePressed(e);
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				super.mouseEntered(e);
				e.getComponent().setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		issueLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				super.mouseClicked(e);
				Desktop desktop = Desktop.getDesktop();
				try
				{
					desktop.browse(new URI(Constants.APP_RESPOSITORY_ISSUE_URL));
				}
				catch (IOException | URISyntaxException e1)
				{
					e1.printStackTrace();
				}
			}

			@Override
			public void mousePressed(MouseEvent e)
			{
				super.mousePressed(e);
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				super.mouseEntered(e);
				e.getComponent().setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		// Check for updates
		versionLabel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				super.mousePressed(e);
				ThreadUtil.execute(() -> UpgradeUtil.checkUpdate(false));
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				super.mouseEntered(e);
				e.getComponent().setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
	}

	private void onOK()
	{
		dispose();
	}

	private void setupUI()
	{
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayoutManager(1, 1, new Insets(20, 20, 20, 20), -1, -1));
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane,
				new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
						GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW,
						GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null,
						0, false));
		scrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), null,
				TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

		final JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayoutManager(9, 2, new Insets(10, 10, 0, 0), -1, -1));
		scrollPane.setViewportView(panel1);

		panel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), null,
				TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
		logoLabel = new JLabel();
		logoLabel.setIcon(new ImageIcon(getClass().getResource("/icons/logo-128.png")));
		logoLabel.setText("");
		panel1.add(logoLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
				GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

		final Spacer spacer1 = new Spacer();
		panel1.add(spacer1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER,
				GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));

		final Spacer spacer2 = new Spacer();
		panel1.add(spacer2, new GridConstraints(8, 0, 1, 1, GridConstraints.ANCHOR_CENTER,
				GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
		final JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayoutManager(3, 1, new Insets(5, 3, 20, 0), -1, -1));
		panel1.add(panel2,
				new GridConstraints(1, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
						GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
						GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null,
						0, false));

		panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), "LearnBitcoin",
				TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
				this.getFont(null, Font.BOLD, 20, panel2.getFont()), new Color(-4425028)));

		final JLabel label1 = new JLabel();
		label1.setText("比特币地址生成工具");
		panel2.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
				GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		authorLabel = new JLabel();
		authorLabel.setText("李华辉");
		panel2.add(authorLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
				GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		versionLabel = new JLabel();
		Font versionLabelFont = this.getFont(null, Font.BOLD, -1, versionLabel.getFont());
		if (versionLabelFont != null)
		{
			versionLabel.setFont(versionLabelFont);
		}
		versionLabel.setText("v0.0.3");
		versionLabel.setToolTipText("检查更新");
		panel2.add(versionLabel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
				GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

		final JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayoutManager(4, 1, new Insets(5, 3, 20, 0), -1, -1));
		panel1.add(panel3,
				new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
						GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
						GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null,
						0, false));
		panel3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), "关于",
				TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
				this.getFont(null, Font.BOLD, -1, panel3.getFont()), null));
		final JLabel label2 = new JLabel();
		label2.setText("感谢您使用LearnBitcoin工具，希望大家都能成为比特币的长期持有者");
		panel3.add(label2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
				GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

		final JPanel panel4 = new JPanel();
		panel4.setLayout(new GridLayoutManager(2, 1, new Insets(5, 3, 20, 0), -1, -1));
		panel1.add(panel4,
				new GridConstraints(3, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
						GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
						GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null,
						0, false));
		panel4.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), "代码",
				TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
				this.getFont(null, Font.BOLD, -1, panel4.getFont()), null));
		codeGitHubLabel = new JLabel();
		codeGitHubLabel.setText("<html>GitHub：<a href=\"" + Constants.APP_RESPOSITORY_URL + "\">"
				+ Constants.APP_RESPOSITORY_URL + "</a></html>");
		panel4.add(codeGitHubLabel,
				new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
						GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0,
						false));

		final JPanel panel5 = new JPanel();
		panel5.setLayout(new GridLayoutManager(1, 1, new Insets(5, 3, 20, 0), -1, -1));
		panel1.add(panel5,
				new GridConstraints(4, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
						GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
						GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null,
						0, false));
		panel5.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), "帮助项目变得更好",
				TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
				this.getFont(null, Font.BOLD, -1, panel5.getFont()), null));
		issueLabel = new JLabel();
		issueLabel.setText("<html><a href=\"" + Constants.APP_RESPOSITORY_ISSUE_URL + "\">"
				+ Constants.APP_RESPOSITORY_ISSUE_URL + "</a></html>");
		panel5.add(issueLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
				GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
	}

	private Font getFont(String fontName, int style, int size, Font currentFont)
	{
		if (currentFont == null)
			return null;
		String resultName;
		if (fontName == null)
		{
			resultName = currentFont.getName();
		}
		else
		{
			Font testFont = new Font(fontName, Font.PLAIN, 10);
			if (testFont.canDisplay('a') && testFont.canDisplay('1'))
			{
				resultName = fontName;
			}
			else
			{
				resultName = currentFont.getName();
			}
		}
		Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(),
				size >= 0 ? size : currentFont.getSize());
		boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
		Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize())
				: new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
		return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
	}

	public JComponent getRootComponent()
	{
		return contentPane;
	}
}
