package com.ctgu.ui.form;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;

/**
 * @author Administrator
 */
public class HDWalletForm extends JPanel
{
	public HDWalletForm()
	{
		initComponents();
	}

	private void initComponents()
	{
		label1 = new JLabel();
		scrollPane2 = new JScrollPane();
		panel1 = new JPanel();
		label2 = new JLabel();
		textField1 = new JTextField();
		label3 = new JLabel();
		label4 = new JLabel();
		label5 = new JLabel();
		label6 = new JLabel();
		label7 = new JLabel();
		label8 = new JLabel();
		label10 = new JLabel();
		label11 = new JLabel();
		label12 = new JLabel();
		label14 = new JLabel();
		radioButton1 = new JRadioButton();
		radioButton2 = new JRadioButton();
		radioButton3 = new JRadioButton();
		radioButton4 = new JRadioButton();
		radioButton5 = new JRadioButton();
		radioButton6 = new JRadioButton();
		label15 = new JLabel();
		comboBox1 = new JComboBox();
		label16 = new JLabel();
		comboBox2 = new JComboBox();
		label17 = new JLabel();
		label9 = new JLabel();
		label13 = new JLabel();
		label18 = new JLabel();
		label19 = new JLabel();
		label20 = new JLabel();
		label21 = new JLabel();
		label38 = new JLabel();
		label39 = new JLabel();
		label40 = new JLabel();
		label41 = new JLabel();
		label42 = new JLabel();
		label43 = new JLabel();
		label44 = new JLabel();
		label45 = new JLabel();
		panel14 = new JPanel();
		panel2 = new JPanel();
		checkBox1 = new JCheckBox();
		checkBox2 = new JCheckBox();
		checkBox3 = new JCheckBox();
		panel3 = new JPanel();
		label22 = new JLabel();
		checkBox4 = new JCheckBox();
		checkBox5 = new JCheckBox();
		checkBox6 = new JCheckBox();
		label23 = new JLabel();
		textField2 = new JTextField();
		label24 = new JLabel();
		textField3 = new JTextField();
		checkBox7 = new JCheckBox();
		label25 = new JLabel();
		textField4 = new JTextField();
		label26 = new JLabel();
		textField5 = new JTextField();
		label27 = new JLabel();
		comboBox3 = new JComboBox();
		label28 = new JLabel();
		textField6 = new JTextField();
		checkBox8 = new JCheckBox();
		panel4 = new JPanel();
		label29 = new JLabel();
		label30 = new JLabel();
		label31 = new JLabel();
		label32 = new JLabel();
		label33 = new JLabel();
		textField8 = new JTextField();
		textField9 = new JTextField();
		comboBox4 = new JComboBox();
		comboBox5 = new JComboBox();
		comboBox6 = new JComboBox();
		textPane4 = new JTextPane();
		label37 = new JLabel();
		panel10 = new JPanel();
		label34 = new JLabel();
		checkBox9 = new JCheckBox();
		textField7 = new JTextField();
		label35 = new JLabel();
		checkBox10 = new JCheckBox();
		tabbedPane2 = new JTabbedPane();
		panel11 = new JPanel();
		panel12 = new JPanel();
		button1 = new JButton();
		button2 = new JButton();
		panel13 = new JPanel();
		tabbedPane1 = new JTabbedPane();
		panel5 = new JPanel();
		panel6 = new JPanel();
		panel7 = new JPanel();
		panel8 = new JPanel();
		panel9 = new JPanel();
		label36 = new JLabel();
		scrollPane1 = new JScrollPane();
		textPane2 = new JTextPane();

		// ======== this ========

		// ---- label1 ----
		label1.setText("\u52a9\u8bb0\u8bcd");

		// ======== scrollPane2 ========
		{

			// ======== panel1 ========
			{
				panel1.setLayout(null);

				// ---- label2 ----
				label2.setText("\u7834\u89e3\u65f6\u95f4");
				panel1.add(label2);
				label2.setBounds(10, 75, 80, 25);
				panel1.add(textField1);
				textField1.setBounds(90, 30, 360, 33);

				// ---- label3 ----
				label3.setText("\u71b5\u7c7b\u578b");
				panel1.add(label3);
				label3.setBounds(10, 110, 85, 20);

				// ---- label4 ----
				label4.setText("\u539f\u59cb\u71b5\u8bcd");
				panel1.add(label4);
				label4.setBounds(5, 140, 80, 25);

				// ---- label5 ----
				label5.setText("\u8fc7\u6ee4\u71b5");
				panel1.add(label5);
				label5.setBounds(10, 165, 80, 25);

				// ---- label6 ----
				label6.setText("\u539f\u59cb\u4e8c\u8fdb\u5236");
				panel1.add(label6);
				label6.setBounds(10, 195, 95, 25);

				// ---- label7 ----
				label7.setText("\u4e8c\u8fdb\u5236\u6821\u9a8c\u548c");
				panel1.add(label7);
				label7.setBounds(10, 220, 110, 25);

				// ---- label8 ----
				label8.setText("\u5355\u8bcd\u7d22\u5f15");
				panel1.add(label8);
				label8.setBounds(10, 245, 110, 25);

				// ---- label10 ----
				label10.setText("\u4e8b\u4ef6\u8ba1\u6570");
				panel1.add(label10);
				label10.setBounds(320, 70, 110, 25);

				// ---- label11 ----
				label11.setText("\u6bcf\u4e2a\u4e8b\u4ef6\u7684\u5e73\u5747\u6bd4\u7279\u6570");
				panel1.add(label11);
				label11.setBounds(320, 110, 110, 25);

				// ---- label12 ----
				label12.setText("\u603b\u6bd4\u7279\u6570");
				panel1.add(label12);
				label12.setBounds(320, 145, 110, 25);

				// ---- label14 ----
				label14.setText("\u6709\u6548\u7684\u71b5\u503c\u5305\u62ec");
				panel1.add(label14);
				label14.setBounds(475, 50, 150, 25);

				// ---- radioButton1 ----
				radioButton1.setText("\u4e8c\u8fdb\u5236[0-1]");
				panel1.add(radioButton1);
				radioButton1.setBounds(475, 80, 155, radioButton1.getPreferredSize().height);

				// ---- radioButton2 ----
				radioButton2.setText("\u57fa\u6570 6 [0-5]");
				panel1.add(radioButton2);
				radioButton2.setBounds(475, 120, 155, 30);

				// ---- radioButton3 ----
				radioButton3.setText("\u9ab0\u5b50[1-6]");
				panel1.add(radioButton3);
				radioButton3.setBounds(475, 155, 155, 30);

				// ---- radioButton4 ----
				radioButton4.setText("\u57fa\u6570 10 [0-9]");
				panel1.add(radioButton4);
				radioButton4.setBounds(475, 190, 160, 30);

				// ---- radioButton5 ----
				radioButton5.setText("\u5341\u516d\u8fdb\u5236[0-9A-F]");
				panel1.add(radioButton5);
				radioButton5.setBounds(475, 225, 170, 30);

				// ---- radioButton6 ----
				radioButton6.setText("\u5361[A2-9TJQK][CDHS]");
				panel1.add(radioButton6);
				radioButton6.setBounds(470, 265, 200, 30);

				// ---- label15 ----
				label15.setText("\u52a9\u8bb0\u8bcd\u957f\u5ea6");
				panel1.add(label15);
				label15.setBounds(10, 280, 110, 25);
				panel1.add(comboBox1);
				comboBox1.setBounds(135, 275, 120, 33);

				// ---- label16 ----
				label16.setText("PBKDF2\u8f6e");
				panel1.add(label16);
				label16.setBounds(10, 310, 100, 25);
				panel1.add(comboBox2);
				comboBox2.setBounds(135, 310, 120, 28);

				// ---- label17 ----
				label17.setText(
						"\u8b66\u544a\u71b5\u662f\u4e00\u9879\u9ad8\u7ea7\u529f\u80fd\u3002\u5982\u679c\u4f7f\u7528\u4e0d\u5f53\uff0c\u60a8\u7684\u52a9\u8bb0\u8bcd\u53ef\u80fd\u4f1a\u4e0d\u5b89\u5168\uff0c\u9605\u8bfb\u66f4\u591a");
				panel1.add(label17);
				label17.setBounds(10, 5, 495, 20);

				// ---- label9 ----
				label9.setText("101010011");
				panel1.add(label9);
				label9.setBounds(685, 85, 95, 20);

				// ---- label13 ----
				label13.setText("123434014");
				panel1.add(label13);
				label13.setBounds(new Rectangle(new Point(685, 125), label13.getPreferredSize()));

				// ---- label18 ----
				label18.setText("62535634");
				panel1.add(label18);
				label18.setBounds(new Rectangle(new Point(685, 165), label18.getPreferredSize()));

				// ---- label19 ----
				label19.setText("90834528");
				panel1.add(label19);
				label19.setBounds(new Rectangle(new Point(680, 200), label19.getPreferredSize()));

				// ---- label20 ----
				label20.setText("4187a8bfd9");
				panel1.add(label20);
				label20.setBounds(new Rectangle(new Point(680, 235), label20.getPreferredSize()));

				// ---- label21 ----
				label21.setText("ahqs9dtc");
				panel1.add(label21);
				label21.setBounds(new Rectangle(new Point(680, 265), label21.getPreferredSize()));

				// ---- label38 ----
				label38.setText("text");
				panel1.add(label38);
				label38.setBounds(100, 80, 175, label38.getPreferredSize().height);

				// ---- label39 ----
				label39.setText("text");
				panel1.add(label39);
				label39.setBounds(105, 120, 115, label39.getPreferredSize().height);

				// ---- label40 ----
				label40.setText("text");
				panel1.add(label40);
				label40.setBounds(105, 150, 90, label40.getPreferredSize().height);

				// ---- label41 ----
				label41.setText("text");
				panel1.add(label41);
				label41.setBounds(105, 175, 100, label41.getPreferredSize().height);

				// ---- label42 ----
				label42.setText("text");
				panel1.add(label42);
				label42.setBounds(110, 205, 70, label42.getPreferredSize().height);

				// ---- label43 ----
				label43.setText("text");
				panel1.add(label43);
				label43.setBounds(130, 230, 70, label43.getPreferredSize().height);

				// ---- label44 ----
				label44.setText("text");
				panel1.add(label44);
				label44.setBounds(140, 255, 85, label44.getPreferredSize().height);

				// ---- label45 ----
				label45.setText("\u71b5");
				panel1.add(label45);
				label45.setBounds(10, 35, 60, label45.getPreferredSize().height);

				// ======== panel14 ========
				{
					panel14.setLayout(null);

					{
						// compute preferred size
						Dimension preferredSize = new Dimension();
						for (int i = 0; i < panel14.getComponentCount(); i++)
						{
							Rectangle bounds = panel14.getComponent(i).getBounds();
							preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
							preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
						}
						Insets insets = panel14.getInsets();
						preferredSize.width += insets.right;
						preferredSize.height += insets.bottom;
						panel14.setMinimumSize(preferredSize);
						panel14.setPreferredSize(preferredSize);
					}
				}
				panel1.add(panel14);
				panel14.setBounds(345, 245, panel14.getPreferredSize().width, 0);

				{
					// compute preferred size
					Dimension preferredSize = new Dimension();
					for (int i = 0; i < panel1.getComponentCount(); i++)
					{
						Rectangle bounds = panel1.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = panel1.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					panel1.setMinimumSize(preferredSize);
					panel1.setPreferredSize(preferredSize);
				}
			}
			scrollPane2.setViewportView(panel1);
		}

		// ======== panel2 ========
		{
			panel2.setLayout(null);

			// ---- checkBox1 ----
			checkBox1.setText("\u663e\u793a\u71b5\u8be6\u7ec6\u4fe1\u606f");
			panel2.add(checkBox1);
			checkBox1.setBounds(5, 5, 153, checkBox1.getPreferredSize().height);

			// ---- checkBox2 ----
			checkBox2.setText("\u9690\u85cf\u6240\u6709\u79c1\u4eba\u4fe1\u606f");
			panel2.add(checkBox2);
			checkBox2.setBounds(195, 5, 157, checkBox2.getPreferredSize().height);

			// ---- checkBox3 ----
			checkBox3.setText("\u81ea\u52a8\u8ba1\u7b97");
			panel2.add(checkBox3);
			checkBox3.setBounds(415, 5, 95, checkBox3.getPreferredSize().height);

			{
				// compute preferred size
				Dimension preferredSize = new Dimension();
				for (int i = 0; i < panel2.getComponentCount(); i++)
				{
					Rectangle bounds = panel2.getComponent(i).getBounds();
					preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
					preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
				}
				Insets insets = panel2.getInsets();
				preferredSize.width += insets.right;
				preferredSize.height += insets.bottom;
				panel2.setMinimumSize(preferredSize);
				panel2.setPreferredSize(preferredSize);
			}
		}

		// ======== panel3 ========
		{
			panel3.setLayout(null);

			// ---- label22 ----
			label22.setText("\u52a9\u8bb0\u8bed\u8a00");
			panel3.add(label22);
			label22.setBounds(5, 10, 90, 25);

			// ---- checkBox4 ----
			checkBox4.setText("English");
			panel3.add(checkBox4);
			checkBox4.setBounds(115, 10, 85, checkBox4.getPreferredSize().height);

			// ---- checkBox5 ----
			checkBox5.setText("\u4e2d\u6587\uff08\u7b80\u4f53\uff09");
			panel3.add(checkBox5);
			checkBox5.setBounds(225, 10, 145, 30);

			// ---- checkBox6 ----
			checkBox6.setText("\u4e2d\u6587\uff08\u7e41\u4f53\uff09");
			panel3.add(checkBox6);
			checkBox6.setBounds(385, 10, 150, 30);

			// ---- label23 ----
			label23.setText("BIP39\u52a9\u8bb0\u8bcd");
			panel3.add(label23);
			label23.setBounds(0, 50, 90, 25);
			panel3.add(textField2);
			textField2.setBounds(115, 50, 695, textField2.getPreferredSize().height);

			// ---- label24 ----
			label24.setText("BIP39\u62c6\u5206\u52a9\u8bb0\u8bcd");
			panel3.add(label24);
			label24.setBounds(0, 95, 90, 35);
			panel3.add(textField3);
			textField3.setBounds(115, 95, 700, 43);

			// ---- checkBox7 ----
			checkBox7.setText("\u663e\u793a\u62c6\u5206\u52a9\u8bb0\u8bcd\u5361");
			panel3.add(checkBox7);
			checkBox7.setBounds(5, 140, 165, checkBox7.getPreferredSize().height);

			// ---- label25 ----
			label25.setText("BIP39\u5bc6\u7801\uff08\u53ef\u9009\uff09");
			panel3.add(label25);
			label25.setBounds(10, 175, 120, 25);
			panel3.add(textField4);
			textField4.setBounds(120, 165, 700, 43);

			// ---- label26 ----
			label26.setText("BIP39\u79cd\u5b50");
			panel3.add(label26);
			label26.setBounds(5, 215, 115, 25);
			panel3.add(textField5);
			textField5.setBounds(120, 210, 695, 43);

			// ---- label27 ----
			label27.setText("\u786c\u5e01");
			panel3.add(label27);
			label27.setBounds(10, 265, 100, 25);
			panel3.add(comboBox3);
			comboBox3.setBounds(125, 255, 120, 43);

			// ---- label28 ----
			label28.setText("BIP39\u79cd\u5b50");
			panel3.add(label28);
			label28.setBounds(5, 300, 100, 25);
			panel3.add(textField6);
			textField6.setBounds(125, 295, 680, 38);

			// ---- checkBox8 ----
			checkBox8.setText("\u663e\u793aBIP85");
			panel3.add(checkBox8);
			checkBox8.setBounds(0, 338, 125, 30);

			// ======== panel4 ========
			{
				panel4.setLayout(null);

				// ---- label29 ----
				label29.setText("BIP85\u5e94\u7528");
				panel4.add(label29);
				label29.setBounds(10, 75, 125, 25);

				// ---- label30 ----
				label30.setText("BIP85\u52a9\u8bb0\u7b26\u8bed\u8a00");
				panel4.add(label30);
				label30.setBounds(10, 105, 125, 30);

				// ---- label31 ----
				label31.setText("BIP85\u52a9\u8bb0\u8bcd\u957f\u5ea6");
				panel4.add(label31);
				label31.setBounds(10, 140, 125, 35);

				// ---- label32 ----
				label32.setText("BIP85\u6307\u6570");
				panel4.add(label32);
				label32.setBounds(5, 180, 115, 19);

				// ---- label33 ----
				label33.setText("BIP85\u5b50\u5bc6\u94a5");
				panel4.add(label33);
				label33.setBounds(5, 210, 95, 24);
				panel4.add(textField8);
				textField8.setBounds(135, 210, 520, 35);
				panel4.add(textField9);
				textField9.setBounds(135, 170, 535, 35);
				panel4.add(comboBox4);
				comboBox4.setBounds(170, 140, comboBox4.getPreferredSize().width, 28);
				panel4.add(comboBox5);
				comboBox5.setBounds(170, 110, comboBox5.getPreferredSize().width, 28);
				panel4.add(comboBox6);
				comboBox6.setBounds(170, 75, comboBox6.getPreferredSize().width, 33);

				// ---- textPane4 ----
				textPane4.setText(
						"\u8fd9\u662f\u4e00\u4e2a\u9ad8\u7ea7\u529f\u80fd\uff0c\u53ea\u6709\u4e86\u89e3\u5176\u4f5c\u7528\u624d\u53ef\u4f7f\u7528\u3002 \u4e0b\u9762\u663e\u793a\u7684\u201cBIP85 \u5b50\u5bc6\u94a5\u201d\u5b57\u6bb5\u7684\u503c\u672a\u5728\u672c\u9875\u9762\u7684\u5176\u4ed6\u5730\u65b9\u4f7f\u7528\u3002\u5b83\u53ef\u4ee5\u7528\u4f5c\u65b0\u5bc6\u94a5\u3002  \u5bf9\u4e8eBIP39\u7533\u8bf7\uff0c\u60a8\u53ef\u4ee5\u5c06\u5176\u7c98\u8d34\u5230\u201cBIP39\u52a9\u8bb0\u8bcd\u201d\u5b57\u6bb5\u4e2d\u4f5c\u4e3a\u65b0\u7684\u52a9\u8bb0\u8bcd\u4f7f\u7528\u3002  \u8bf7\u9605\u8bfb BIP85 \u89c4\u8303 \u4ee5\u83b7\u53d6\u66f4\u591a\u4fe1\u606f\u3002");
				panel4.add(textPane4);
				textPane4.setBounds(115, 0, 685, 65);

				// ---- label37 ----
				label37.setText("\u8b66\u544a");
				panel4.add(label37);
				label37.setBounds(5, 15, 90, 30);

				{
					// compute preferred size
					Dimension preferredSize = new Dimension();
					for (int i = 0; i < panel4.getComponentCount(); i++)
					{
						Rectangle bounds = panel4.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = panel4.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					panel4.setMinimumSize(preferredSize);
					panel4.setPreferredSize(preferredSize);
				}
			}
			panel3.add(panel4);
			panel4.setBounds(5, 370, 810, 255);

			{
				// compute preferred size
				Dimension preferredSize = new Dimension();
				for (int i = 0; i < panel3.getComponentCount(); i++)
				{
					Rectangle bounds = panel3.getComponent(i).getBounds();
					preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
					preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
				}
				Insets insets = panel3.getInsets();
				preferredSize.width += insets.right;
				preferredSize.height += insets.bottom;
				panel3.setMinimumSize(preferredSize);
				panel3.setPreferredSize(preferredSize);
			}
		}

		// ======== panel10 ========
		{
			panel10.setLayout(null);

			// ---- label34 ----
			label34.setText("\u6d3e\u751f\u5730\u5740");
			panel10.add(label34);
			label34.setBounds(5, 5, 650, label34.getPreferredSize().height);

			// ---- checkBox9 ----
			checkBox9.setText("\u4f7f\u7528BIP38\u548c\u6b64\u5bc6\u7801\u52a0\u5bc6\u79c1\u94a5");
			panel10.add(checkBox9);
			checkBox9.setBounds(10, 35, 235, 20);
			panel10.add(textField7);
			textField7.setBounds(230, 30, 295, 30);

			// ---- label35 ----
			label35.setText(
					"\u542f\u7528 BIP38 \u610f\u5473\u7740\u6bcf\u4e2a\u5bc6\u94a5\u5c06\u9700\u8981\u51e0\u5206\u949f\u624d\u80fd\u751f\u6210");
			panel10.add(label35);
			label35.setBounds(540, 15, 290, 50);

			// ---- checkBox10 ----
			checkBox10.setText("\u4f7f\u7528\u5f3a\u5316\u5730\u5740");
			panel10.add(checkBox10);
			checkBox10.setBounds(10, 60, 200, checkBox10.getPreferredSize().height);

			// ======== tabbedPane2 ========
			{

				// ======== panel11 ========
				{
					panel11.setLayout(null);

					{
						// compute preferred size
						Dimension preferredSize = new Dimension();
						for (int i = 0; i < panel11.getComponentCount(); i++)
						{
							Rectangle bounds = panel11.getComponent(i).getBounds();
							preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
							preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
						}
						Insets insets = panel11.getInsets();
						preferredSize.width += insets.right;
						preferredSize.height += insets.bottom;
						panel11.setMinimumSize(preferredSize);
						panel11.setPreferredSize(preferredSize);
					}
				}
				tabbedPane2.addTab("\u8868\u683c", panel11);

				// ======== panel12 ========
				{
					panel12.setLayout(null);

					{
						// compute preferred size
						Dimension preferredSize = new Dimension();
						for (int i = 0; i < panel12.getComponentCount(); i++)
						{
							Rectangle bounds = panel12.getComponent(i).getBounds();
							preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
							preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
						}
						Insets insets = panel12.getInsets();
						preferredSize.width += insets.right;
						preferredSize.height += insets.bottom;
						panel12.setMinimumSize(preferredSize);
						panel12.setPreferredSize(preferredSize);
					}
				}
				tabbedPane2.addTab("CSV", panel12);
			}
			panel10.add(tabbedPane2);
			tabbedPane2.setBounds(20, 95, 630, 130);

			// ---- button1 ----
			button1.setText("\u5bfc\u51fa\u524d1000\u6761\u5b8c\u6574\u8bb0\u5f55");
			panel10.add(button1);
			button1.setBounds(225, 65, button1.getPreferredSize().width, 25);

			// ---- button2 ----
			button2.setText("\u5bfc\u51fa\u524d1000\u6761\u8bb0\u5f55\uff08\u4ec5\u5730\u5740\uff09");
			panel10.add(button2);
			button2.setBounds(435, 65, 220, 20);

			{
				// compute preferred size
				Dimension preferredSize = new Dimension();
				for (int i = 0; i < panel10.getComponentCount(); i++)
				{
					Rectangle bounds = panel10.getComponent(i).getBounds();
					preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
					preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
				}
				Insets insets = panel10.getInsets();
				preferredSize.width += insets.right;
				preferredSize.height += insets.bottom;
				panel10.setMinimumSize(preferredSize);
				panel10.setPreferredSize(preferredSize);
			}
		}

		// ======== panel13 ========
		{
			panel13.setLayout(null);

			// ======== tabbedPane1 ========
			{

				// ======== panel5 ========
				{
					panel5.setLayout(null);

					{
						// compute preferred size
						Dimension preferredSize = new Dimension();
						for (int i = 0; i < panel5.getComponentCount(); i++)
						{
							Rectangle bounds = panel5.getComponent(i).getBounds();
							preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
							preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
						}
						Insets insets = panel5.getInsets();
						preferredSize.width += insets.right;
						preferredSize.height += insets.bottom;
						panel5.setMinimumSize(preferredSize);
						panel5.setPreferredSize(preferredSize);
					}
				}
				tabbedPane1.addTab("BIP32", panel5);

				// ======== panel6 ========
				{
					panel6.setLayout(null);

					{
						// compute preferred size
						Dimension preferredSize = new Dimension();
						for (int i = 0; i < panel6.getComponentCount(); i++)
						{
							Rectangle bounds = panel6.getComponent(i).getBounds();
							preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
							preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
						}
						Insets insets = panel6.getInsets();
						preferredSize.width += insets.right;
						preferredSize.height += insets.bottom;
						panel6.setMinimumSize(preferredSize);
						panel6.setPreferredSize(preferredSize);
					}
				}
				tabbedPane1.addTab("BIP84", panel6);

				// ======== panel7 ========
				{
					panel7.setLayout(null);

					{
						// compute preferred size
						Dimension preferredSize = new Dimension();
						for (int i = 0; i < panel7.getComponentCount(); i++)
						{
							Rectangle bounds = panel7.getComponent(i).getBounds();
							preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
							preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
						}
						Insets insets = panel7.getInsets();
						preferredSize.width += insets.right;
						preferredSize.height += insets.bottom;
						panel7.setMinimumSize(preferredSize);
						panel7.setPreferredSize(preferredSize);
					}
				}
				tabbedPane1.addTab("BIP49", panel7);

				// ======== panel8 ========
				{
					panel8.setLayout(null);

					{
						// compute preferred size
						Dimension preferredSize = new Dimension();
						for (int i = 0; i < panel8.getComponentCount(); i++)
						{
							Rectangle bounds = panel8.getComponent(i).getBounds();
							preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
							preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
						}
						Insets insets = panel8.getInsets();
						preferredSize.width += insets.right;
						preferredSize.height += insets.bottom;
						panel8.setMinimumSize(preferredSize);
						panel8.setPreferredSize(preferredSize);
					}
				}
				tabbedPane1.addTab("BIP84", panel8);

				// ======== panel9 ========
				{
					panel9.setLayout(null);

					{
						// compute preferred size
						Dimension preferredSize = new Dimension();
						for (int i = 0; i < panel9.getComponentCount(); i++)
						{
							Rectangle bounds = panel9.getComponent(i).getBounds();
							preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
							preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
						}
						Insets insets = panel9.getInsets();
						preferredSize.width += insets.right;
						preferredSize.height += insets.bottom;
						panel9.setMinimumSize(preferredSize);
						panel9.setPreferredSize(preferredSize);
					}
				}
				tabbedPane1.addTab("BIP141", panel9);
			}
			panel13.add(tabbedPane1);
			tabbedPane1.setBounds(5, 35, 853, 173);

			// ---- label36 ----
			label36.setText("\u6d3e\u751f\u8def\u5f84");
			panel13.add(label36);
			label36.setBounds(10, 5, 75, 25);

			{
				// compute preferred size
				Dimension preferredSize = new Dimension();
				for (int i = 0; i < panel13.getComponentCount(); i++)
				{
					Rectangle bounds = panel13.getComponent(i).getBounds();
					preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
					preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
				}
				Insets insets = panel13.getInsets();
				preferredSize.width += insets.right;
				preferredSize.height += insets.bottom;
				panel13.setMinimumSize(preferredSize);
				panel13.setPreferredSize(preferredSize);
			}
		}

		// ======== scrollPane1 ========
		{

			// ---- textPane2 ----
			textPane2.setText(
					"\u60a8\u53ef\u4ee5\u8f93\u5165\u73b0\u6709\u7684 BIP39 \u52a9\u8bb0\u7b26\uff0c\u4e5f\u53ef\u4ee5\u751f\u6210\u65b0\u7684\u968f\u673a\u52a9\u8bb0\u7b26\u3002\u8f93\u5165\u60a8\u81ea\u5df1\u7684\u5341\u4e8c\u4e2a\u5355\u8bcd\u53ef\u80fd\u4e0d\u4f1a\u50cf\u60a8\u9884\u671f\u7684\u90a3\u6837\u6709\u6548\uff0c\u56e0\u4e3a\u8fd9\u4e9b\u5355\u8bcd\u9700\u8981\u7279\u5b9a\u7684\u7ed3\u6784\uff08\u6700\u540e\u4e00\u4e2a\u5355\u8bcd\u5305\u542b\u6821\u9a8c\u548c\uff09\u3002  \u6709\u5173\u66f4\u591a\u4fe1\u606f\uff0c\u8bf7\u53c2\u9605 BIP39 \u89c4\u8303\u3002  \u5982\u679c\u60a8\u5c06\u6b64\u9875\u9762\u751f\u6210\u7684\u4fe1\u606f\u5206\u4eab\u7ed9\u4efb\u4f55\u4eba\uff0c\u4ed6\u4eec\u53ef\u80fd\u4f1a\u7a83\u53d6\u60a8\u7684\u8d44\u4ea7\u3002\u4efb\u4f55\u8981\u6c42\u60a8\u5206\u4eab\u60a8\u7684\u79d8\u5bc6\u6062\u590d\u77ed\u8bed\u6216 BIP 32 \u6839\u5bc6\u94a5\u7684\u4eba\u90fd\u662f\u9a97\u5b50\u3002\u8bf7\u52ff\u590d\u5236\u548c\u7c98\u8d34\u6b64\u9875\u9762\u4e0a\u7684\u4fe1\u606f\uff0c\u6216\u5c06\u5176\u53d1\u9001\u7ed9\u4efb\u4f55\u5728 Twitter\u3001Discord\u3001Telegram\u3001Etherscan \u6216 Line \u4e0a\u613f\u610f\u5e2e\u52a9\u60a8\u7684\u4eba\u3002 \u4ed6\u4eec\u4f1a\u7a83\u53d6\u60a8\u7684\u786c\u5e01\u3002");
			scrollPane1.setViewportView(textPane2);
		}

		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup().addGroup(
				layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup().addComponent(
						panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(
								layout.createSequentialGroup().addGroup(layout.createParallelGroup().addComponent(
										panel10, GroupLayout.PREFERRED_SIZE, 844,
										GroupLayout.PREFERRED_SIZE).addComponent(label1, GroupLayout.PREFERRED_SIZE,
												110, GroupLayout.PREFERRED_SIZE)).addGap(0, 305,
														Short.MAX_VALUE)))).addGroup(
																layout.createSequentialGroup().addGap(112, 112,
																		112).addGroup(
																				layout.createParallelGroup().addComponent(
																						panel2,
																						GroupLayout.PREFERRED_SIZE, 825,
																						GroupLayout.PREFERRED_SIZE).addComponent(
																								scrollPane1,
																								GroupLayout.PREFERRED_SIZE,
																								813,
																								GroupLayout.PREFERRED_SIZE).addComponent(
																										scrollPane2,
																										GroupLayout.PREFERRED_SIZE,
																										831,
																										GroupLayout.PREFERRED_SIZE)).addGap(
																												0, 212,
																												Short.MAX_VALUE)).addGroup(
																														GroupLayout.Alignment.TRAILING,
																														layout.createSequentialGroup().addContainerGap().addComponent(
																																panel13,
																																GroupLayout.DEFAULT_SIZE,
																																0,
																																Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup().addGroup(
				layout.createSequentialGroup().addContainerGap().addComponent(label1, GroupLayout.PREFERRED_SIZE, 35,
						GroupLayout.PREFERRED_SIZE).addPreferredGap(
								LayoutStyle.ComponentPlacement.UNRELATED).addComponent(
										scrollPane1, GroupLayout.PREFERRED_SIZE, 107,
										GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(panel2,
												GroupLayout.PREFERRED_SIZE, 38,
												GroupLayout.PREFERRED_SIZE).addPreferredGap(
														LayoutStyle.ComponentPlacement.RELATED).addComponent(
																scrollPane2, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE).addGap(18, 18,
																		18).addComponent(panel3,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE).addPreferredGap(
																						LayoutStyle.ComponentPlacement.UNRELATED).addComponent(
																								panel13,
																								GroupLayout.PREFERRED_SIZE,
																								170,
																								GroupLayout.PREFERRED_SIZE).addPreferredGap(
																										LayoutStyle.ComponentPlacement.RELATED).addComponent(
																												panel10,
																												GroupLayout.PREFERRED_SIZE,
																												234,
																												GroupLayout.PREFERRED_SIZE).addContainerGap(
																														248,
																														Short.MAX_VALUE)));
		// JFormDesigner - End of component initialization //GEN-END:initComponents @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY //GEN-BEGIN:variables @formatter:off
	private JLabel label1;
	private JScrollPane scrollPane2;
	private JPanel panel1;
	private JLabel label2;
	private JTextField textField1;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JLabel label8;
	private JLabel label10;
	private JLabel label11;
	private JLabel label12;
	private JLabel label14;
	private JRadioButton radioButton1;
	private JRadioButton radioButton2;
	private JRadioButton radioButton3;
	private JRadioButton radioButton4;
	private JRadioButton radioButton5;
	private JRadioButton radioButton6;
	private JLabel label15;
	private JComboBox comboBox1;
	private JLabel label16;
	private JComboBox comboBox2;
	private JLabel label17;
	private JLabel label9;
	private JLabel label13;
	private JLabel label18;
	private JLabel label19;
	private JLabel label20;
	private JLabel label21;
	private JLabel label38;
	private JLabel label39;
	private JLabel label40;
	private JLabel label41;
	private JLabel label42;
	private JLabel label43;
	private JLabel label44;
	private JLabel label45;
	private JPanel panel14;
	private JPanel panel2;
	private JCheckBox checkBox1;
	private JCheckBox checkBox2;
	private JCheckBox checkBox3;
	private JPanel panel3;
	private JLabel label22;
	private JCheckBox checkBox4;
	private JCheckBox checkBox5;
	private JCheckBox checkBox6;
	private JLabel label23;
	private JTextField textField2;
	private JLabel label24;
	private JTextField textField3;
	private JCheckBox checkBox7;
	private JLabel label25;
	private JTextField textField4;
	private JLabel label26;
	private JTextField textField5;
	private JLabel label27;
	private JComboBox comboBox3;
	private JLabel label28;
	private JTextField textField6;
	private JCheckBox checkBox8;
	private JPanel panel4;
	private JLabel label29;
	private JLabel label30;
	private JLabel label31;
	private JLabel label32;
	private JLabel label33;
	private JTextField textField8;
	private JTextField textField9;
	private JComboBox comboBox4;
	private JComboBox comboBox5;
	private JComboBox comboBox6;
	private JTextPane textPane4;
	private JLabel label37;
	private JPanel panel10;
	private JLabel label34;
	private JCheckBox checkBox9;
	private JTextField textField7;
	private JLabel label35;
	private JCheckBox checkBox10;
	private JTabbedPane tabbedPane2;
	private JPanel panel11;
	private JPanel panel12;
	private JButton button1;
	private JButton button2;
	private JPanel panel13;
	private JTabbedPane tabbedPane1;
	private JPanel panel5;
	private JPanel panel6;
	private JPanel panel7;
	private JPanel panel8;
	private JPanel panel9;
	private JLabel label36;
	private JScrollPane scrollPane1;
	private JTextPane textPane2;
	// JFormDesigner - End of variables declaration //GEN-END:variables @formatter:on
}
