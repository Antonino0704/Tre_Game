package tre.game;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import suono.Play;

public class Gui {
	private JFrame win;
	private JButton button1, button2, button3;
	private JLabel lab, imageGirl;
	private JPanel panel1;
	private int numeroTentativi;
	private Play play;
	
	public Gui() {
		win = new JFrame("Tre Game");
		
		numeroTentativi = 0;
		
		addImageGirl();
		addLab();
		addPanel1();
		keyGui();
		
		win.setIconImage(new ImageIcon("images/normal.jpg").getImage());
		win.getContentPane().setBackground(Color.black);
		win.setSize(600, 600);
		win.setResizable(false);
		win.setLocationRelativeTo(null);
		
		win.setVisible(true);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private void keyGui() {
		win.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.isControlDown() && e.getKeyCode() == e.VK_D) {
					secret();
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			
		});
	}
	
	private void addImageGirl() {
		imageGirl = new JLabel();
		imageGirl.setIcon(new ImageIcon("images/normal.jpg"));
		win.add(imageGirl, BorderLayout.CENTER);
	}
	
	private void addLab() {
		lab = new JLabel("indovina il numero");
		lab.setForeground(Color.white);
		lab.setFont(new Font(lab.getFont().getName(), lab.getFont().getStyle(), 33));
		win.add(lab, BorderLayout.BEFORE_FIRST_LINE);
	}
	
	private void addPanel1() {
		panel1 = new JPanel();
		panel1.setBackground(Color.black);
		
		addButton1();
		panel1.add(Box.createRigidArea(new Dimension(150, 0)));
		addButton2();
		panel1.add(Box.createRigidArea(new Dimension(150, 0)));
		addButton3();
		
		win.add(panel1, BorderLayout.AFTER_LAST_LINE);
	}
	
	private void addButton1() {
		button1 = new JButton("1");
		button1.setForeground(Color.red);
		button1.setFocusable(false);
		button1.setBorder(null);
		button1.setFont(new Font(button1.getFont().getName(), button1.getFont().getStyle(), 33));
		panel1.add(button1);
	}
	
	private void addButton2() {
		button2 = new JButton("2");
		button2.setForeground(Color.red);
		button2.setFocusable(false);
		button2.setBorder(null);
		button2.setFont(new Font(button2.getFont().getName(), button2.getFont().getStyle(), 33));
		panel1.add(button2);
	}
	
	private void addButton3() {
		button3 = new JButton("3");
		button3.setForeground(Color.red);
		button3.setFocusable(false);
		button3.setBorder(null);
		button3.setFont(new Font(button3.getFont().getName(), button3.getFont().getStyle(), 33));
		panel1.add(button3);
	}
	
	public void actionButton1(Random random) {
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				imageGirl.setIcon(new ImageIcon("images/normal.jpg"));
				
				if(random.verify(1)) {
					indovinato(random);
				}
				
				else if(random.verify(1) == false && numeroTentativi == 2) {
					limit(random);
				}

				else {
					notIndovinato();
				}
			}
		});
	}
	
	public void actionButton2(Random random) {
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				imageGirl.setIcon(new ImageIcon("images/normal.jpg"));
				
				if(random.verify(2)) {
					indovinato(random);
				}
				
				else if(random.verify(2) == false && numeroTentativi == 2) {
					limit(random);
				}

				else {
					notIndovinato();
				}
			}
		});
	}
	
	public void actionButton3(Random random) {
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				imageGirl.setIcon(new ImageIcon("images/normal.jpg"));
				
				if(random.verify(3)) {
					indovinato(random);
				}
				
				else if(random.verify(3) == false && numeroTentativi == 2) {
					limit(random);
				}

				else {
					notIndovinato();
				}
			}
		});
	}
	
	private void indovinato(Random random) {
		lab.setText("bravo hai indovinato");
		random.randomNum();
	}
	
	private void notIndovinato() {
		lab.setText("non hai indovinato riprova");
		numeroTentativi++;
	}
	
	private void limit(Random random) {
		lab.setText("cog...cambio numero c***r***t***D");
		ImageIcon icon = new ImageIcon("images/tre.jpg");
		Image img = icon.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
		imageGirl.setIcon(new ImageIcon(img));
		
		random.randomNum();
		numeroTentativi = 0;
	}
	
	private void secret() {
		imageGirl.setIcon(new ImageIcon("images/r.gif"));
		
		lab.setForeground(Color.red);
		lab.setText("<html> MI SONO ROTTA IL CAZZO PER VOI INCAPACI<br>"
				+ "CAPRE IGNORANTI CHE NON SAPETE NEACHE INDOVINARE I NUMERI <br>"
				+ "ANDATEVENE A FANCULO TU E STO GIOCO ME NE VADO </html>");
		
		play = new Play("suono/horror.wav");
		play.startSuono();
		play.setVolume().setValue(-15.5f);
		
		Timer timer = new Timer(10000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				play.closeSuono();
				win.dispose();
			}
			
		});
		
		timer.start();
		
		win.remove(panel1);
		win.setExtendedState(JFrame.MAXIMIZED_BOTH);
		win.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

}
