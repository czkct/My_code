import javax.swing.text.BadLocationException;

/*
 * Calcu.java
 *
 * Created on __DATE__, __TIME__
 */

/**
 *
 * @author  __USER__
 */
public class Calcu extends javax.swing.JFrame {
	//flag 是按键标志变量   str1 是第一个运算数
	int num1, num2;
	boolean hs_count = false;//等于号的标志变量
	String str1, str2;
	boolean flag = false; //按键标志变量
	String key = null;  //key是按键变量

	/** Creates new form Calcu */
	public Calcu() {
		initComponents();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();
		jButton7 = new javax.swing.JButton();
		jButton8 = new javax.swing.JButton();
		jButton9 = new javax.swing.JButton();
		jButton10 = new javax.swing.JButton();
		jButton11 = new javax.swing.JButton();
		jButton12 = new javax.swing.JButton();
		jButton13 = new javax.swing.JButton();
		jButton14 = new javax.swing.JButton();
		jButton15 = new javax.swing.JButton();
		jButton16 = new javax.swing.JButton();
		jButton17 = new javax.swing.JButton();
		jButton18 = new javax.swing.JButton();
		jButton19 = new javax.swing.JButton();
		jButton20 = new javax.swing.JButton();
		jButton1 = new javax.swing.JButton();
		jPanel3 = new javax.swing.JPanel();
		jTextField1 = new javax.swing.JTextField();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenu2 = new javax.swing.JMenu();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("\u7a7f\u7740\u88e4\u8869\u8df3\u8ba1\u7b97\u5668");
		setBackground(new java.awt.Color(255, 255, 255));
		setResizable(false);

		jPanel1.setBackground(new java.awt.Color(220, 228, 255));

		jPanel2.setBackground(new java.awt.Color(220, 228, 231));

		jButton2.setText(".");
		jButton2.setFocusPainted(false);
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 10));
		jButton3.setText("+");
		jButton3.setFocusPainted(false);
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jButton4.setText("1");
		jButton4.setFocusPainted(false);
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		jButton5.setText("2");
		jButton5.setFocusPainted(false);
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});

		jButton6.setText("3");
		jButton6.setFocusPainted(false);
		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});

		jButton7.setText("-");
		jButton7.setFocusPainted(false);
		jButton7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton7ActionPerformed(evt);
			}
		});

		jButton8.setText("4");
		jButton8.setFocusPainted(false);
		jButton8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton8ActionPerformed(evt);
			}
		});

		jButton9.setText("5");
		jButton9.setFocusPainted(false);
		jButton9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton9ActionPerformed(evt);
			}
		});

		jButton10.setText("6");
		jButton10.setFocusPainted(false);
		jButton10.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton10ActionPerformed(evt);
			}
		});

		jButton11.setText("*");
		jButton11.setFocusPainted(false);
		jButton11.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton11ActionPerformed(evt);
			}
		});

		jButton12.setText("7");
		jButton12.setFocusPainted(false);
		jButton12.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton12ActionPerformed(evt);
			}
		});

		jButton13.setText("8");
		jButton13.setFocusPainted(false);
		jButton13.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton13ActionPerformed(evt);
			}
		});

		jButton14.setText("9");
		jButton14.setFocusPainted(false);
		jButton14.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton14ActionPerformed(evt);
			}
		});

		jButton15.setText("/");
		jButton15.setFocusPainted(false);
		jButton15.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton15ActionPerformed(evt);
			}
		});

		jButton16.setText("CE");
		jButton16.setFocusPainted(false);
		jButton16.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButton16MouseClicked(evt);
			}
		});
		jButton16.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton16ActionPerformed(evt);
			}
		});

		jButton17.setText("\u2190");
		jButton17.setFocusPainted(false);
		jButton17.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton17ActionPerformed(evt);
			}
		});

		jButton18.setText("\u00f7");
		jButton18.setFocusPainted(false);
		jButton18.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton18ActionPerformed(evt);
			}
		});

		jButton19.setText("\u221a");
		jButton19.setFocusPainted(false);
		jButton19.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton19ActionPerformed(evt);
			}
		});

		jButton20.setText("=");
		jButton20.setFocusPainted(false);
		jButton20.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton20ActionPerformed(evt);
			}
		});

		jButton1.setText("0");
		jButton1.setFocusPainted(false);
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								false)
																						.addComponent(
																								jButton4,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jButton16,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jButton12,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jButton8,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addComponent(
																								jButton5,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								45,
																								Short.MAX_VALUE)
																						.addComponent(
																								jButton9,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jButton13,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jButton17,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)))
														.addComponent(
																jButton1,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																99,
																Short.MAX_VALUE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																jButton18,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jButton2,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jButton6,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jButton10,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jButton14,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																48,
																Short.MAX_VALUE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jButton3,
																0, 0,
																Short.MAX_VALUE)
														.addComponent(
																jButton7,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																40,
																Short.MAX_VALUE)
														.addComponent(
																jButton11,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																40,
																Short.MAX_VALUE)
														.addComponent(
																jButton15,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																40,
																Short.MAX_VALUE)
														.addComponent(jButton19))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jButton20)
										.addContainerGap()));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel2Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jButton20,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																157,
																Short.MAX_VALUE)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel2Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE,
																								false)
																						.addComponent(
																								jButton16)
																						.addComponent(
																								jButton18)
																						.addComponent(
																								jButton19)
																						.addComponent(
																								jButton17))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE,
																								false)
																						.addComponent(
																								jButton12)
																						.addComponent(
																								jButton14)
																						.addComponent(
																								jButton15)
																						.addComponent(
																								jButton13))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE,
																								false)
																						.addComponent(
																								jButton8)
																						.addComponent(
																								jButton10)
																						.addComponent(
																								jButton11)
																						.addComponent(
																								jButton9))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE,
																								false)
																						.addComponent(
																								jButton4)
																						.addComponent(
																								jButton6)
																						.addComponent(
																								jButton7)
																						.addComponent(
																								jButton5))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE,
																								false)
																						.addComponent(
																								jButton2)
																						.addComponent(
																								jButton3)
																						.addComponent(
																								jButton1))))
										.addContainerGap()));

		jPanel3.setBackground(new java.awt.Color(220, 228, 231));

		jTextField1.setFont(new java.awt.Font("Cambria Math", 0, 18));
		jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel3Layout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jTextField1,
								javax.swing.GroupLayout.DEFAULT_SIZE, 249,
								Short.MAX_VALUE).addContainerGap()));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel3Layout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jTextField1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 42,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jPanel3,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jPanel2,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel1Layout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel3,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jPanel2,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		jMenu1.setText("\u6587\u4ef6");
		jMenuBar1.add(jMenu1);

		jMenu2.setText("\u7f16\u8f91");
		jMenuBar1.add(jMenu2);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel1,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel1,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents
	
	//"√"
	private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {
		key = "√";
		flag = true;
	}
	
	//"÷"
	private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {
		if(jTextField1.getText()!=null){
			str1 = jTextField1.getText();
			num1 = Integer.parseInt(str1);
		}
		key = "÷";
		flag = true;
	}
	
	//"/"
	private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {
		if(jTextField1.getText()!=null){
			str1 = jTextField1.getText();
			num1 = Integer.parseInt(str1);
		}
		key = "/";
		flag = true;
	}
	
	//"+"
	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		if(jTextField1.getText()!=null){
			str1 = jTextField1.getText();
			num1 = Integer.parseInt(str1);
		}
		key = "+";
		flag = true;
	}
	
	//"-"
	private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
		if(jTextField1.getText()!=null){
			str1 = jTextField1.getText();
			num1 = Integer.parseInt(str1);
		}
		key = "-";
		flag = true;
	}
	
	//"*"
	private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {
		if(jTextField1.getText()!=null){
			str1 = jTextField1.getText();
			num1 = Integer.parseInt(str1);
		}
		key = "*";
		flag = true;
	}
	
	//"回退"
	private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			if(!flag)
			jTextField1.setText(jTextField1.getText(0, jTextField1.getText()
					.length() - 1));
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
//"."
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		if(hs_count) {
			hs_count = false; jTextField1.setText(null);
		}
		if(flag) {
			flag = false; jTextField1.setText(null);
		}
		jTextField1.setText(jTextField1.getText() + jButton2.getText());
	}

	private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {
		jTextField1.setText("");
	}
//"9"
	private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {
		if(hs_count) {
			hs_count = false; jTextField1.setText(null);
		}
		if(flag) {
			flag = false; jTextField1.setText(null);
		}
		jTextField1.setText(jTextField1.getText() + jButton14.getText());
	}
//"8"
	private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {
		if(hs_count) {
			hs_count = false; jTextField1.setText(null);
		}
		if(flag) {
			flag = false; jTextField1.setText(null);
		}
		jTextField1.setText(jTextField1.getText() + jButton13.getText());
	}
//"7"
	private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {
		if(hs_count) {
			hs_count = false; jTextField1.setText(null);
		}
		if(flag) {
			flag = false; jTextField1.setText(null);
		}
		jTextField1.setText(jTextField1.getText() + jButton12.getText());
	}
//"6"
	private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {
		if(hs_count) {
			hs_count = false; jTextField1.setText(null);
		}
		if(flag) {
			flag = false; jTextField1.setText(null);
		}
		jTextField1.setText(jTextField1.getText() + jButton10.getText());
	}
//"5"
	private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
		if(hs_count) {
			hs_count = false; jTextField1.setText(null);
		}
		if(flag) {
			flag = false; jTextField1.setText(null);
		}
		jTextField1.setText(jTextField1.getText() + jButton9.getText());
	}
//"4"
	private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
		if(hs_count) {
			hs_count = false; jTextField1.setText(null);
		}
		if(flag) {
			flag = false; jTextField1.setText(null);
		}
		jTextField1.setText(jTextField1.getText() + jButton8.getText());
	}
//"3"
	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
		if(hs_count) {
			hs_count = false; jTextField1.setText(null);
		}
		if(flag) {
			flag = false; jTextField1.setText(null);
		}
		jTextField1.setText(jTextField1.getText() + jButton6.getText());
	}
//"2"
	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
		if(hs_count) {
			hs_count = false; jTextField1.setText(null);
		}
		if(flag) {
			flag = false; jTextField1.setText(null);
		}
		jTextField1.setText(jTextField1.getText() + jButton5.getText());
	}
//"1"
	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		if(hs_count) {
			hs_count = false; jTextField1.setText(null);
		}
		if(flag) {
			flag = false; jTextField1.setText(null);
		}
		jTextField1.setText(jTextField1.getText() + jButton4.getText());
	}
//"0"
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		if(hs_count) {
			hs_count = false; jTextField1.setText(null);
		}
		if(flag) {
			flag = false; jTextField1.setText(null);
		}
		jTextField1.setText(jTextField1.getText() + jButton1.getText());
	}

	private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {
		str2 = jTextField1.getText();
		num2 = Integer.parseInt(str2);
		char[] a = key.toCharArray();
		switch (a[0]) {
		case '+':
			jTextField1.setText(String.valueOf(num1 + num2));
			break;
		case '-':
			jTextField1.setText(String.valueOf(num1 - num2));
			break;
		case '*':
			jTextField1.setText(String.valueOf(num1 * num2));
			break;
		case '/':
			jTextField1.setText(String.valueOf(num1 / num2));
			break;
		case '√':
			jTextField1.setText(String.valueOf(Math.sqrt(num2)));
			break;
		case '÷':
			jTextField1.setText(String.valueOf(num1 * 1.0 / num2));
			break;
		//case "+":jTextField1.setText(String.valueOf(num1+num2));
		default:
			jTextField1.setText("error");
		}
		hs_count = true;
		
	}


	private void jButton16MouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Calcu().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton10;
	private javax.swing.JButton jButton11;
	private javax.swing.JButton jButton12;
	private javax.swing.JButton jButton13;
	private javax.swing.JButton jButton14;
	private javax.swing.JButton jButton15;
	private javax.swing.JButton jButton16;
	private javax.swing.JButton jButton17;
	private javax.swing.JButton jButton18;
	private javax.swing.JButton jButton19;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton20;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JButton jButton7;
	private javax.swing.JButton jButton8;
	private javax.swing.JButton jButton9;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JTextField jTextField1;
	// End of variables declaration//GEN-END:variables

}