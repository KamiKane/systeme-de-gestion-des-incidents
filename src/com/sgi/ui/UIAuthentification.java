package com.sgi.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.sgi.utils.Utilitaire;

public class UIAuthentification extends JFrame {
	private static final long serialVersionUID = 1L;

	private JTextField loginTF;
	private JPasswordField passwordPF;
	private JButton buttonValider;
	private JButton buttonQuitter;
	
	public UIAuthentification() {
		initComponents ();
	}
	
	private void initComponents () {		
		setPreferredSize(new Dimension(300, 145));
		setSize(new Dimension(300, 145));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Connexion");
		getContentPane().setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel topPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) topPanel.getLayout();
		flowLayout.setVgap(8);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(topPanel);
		
		JLabel loginLabel = new JLabel("Login :");
		topPanel.add(loginLabel);
		
		loginTF = new JTextField();
		topPanel.add(loginTF);
		loginTF.setColumns(15);
		
		JPanel middlePanel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) middlePanel.getLayout();
		flowLayout_1.setVgap(2);
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(middlePanel);
		
		JLabel passwordLabel = new JLabel("Password :");
		middlePanel.add(passwordLabel);
		
		passwordPF = new JPasswordField();
		passwordPF.setColumns(15);
		middlePanel.add(passwordPF);
		
		JPanel bottomPanel = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) bottomPanel.getLayout();
		flowLayout_2.setVgap(2);
		getContentPane().add(bottomPanel);
		
		buttonValider = new JButton("Valider");
		buttonValider.setPreferredSize(new Dimension(80, 25));
		buttonValider.setSize(new Dimension(80, 25));
		bottomPanel.add(buttonValider);
		
		buttonQuitter = new JButton("Quitter");
		buttonQuitter.setPreferredSize(new Dimension(80, 25));
		buttonQuitter.setSize(new Dimension(80, 25));
		bottomPanel.add(buttonQuitter);
		
		Utilitaire.setLookAndFeel(this);
		Utilitaire.center(this, this.getSize());
	}

	public void montrer () {
		setVisible (true);
	}
	
	public void cacher () {
		setVisible (false);
	}

	public void addValiderListener(ActionListener actionListener) {
		
		buttonValider.addActionListener(actionListener);
	}

	public void addQuitterListener(ActionListener actionListener) {
		
		buttonQuitter.addActionListener(actionListener);
	}

	public String getLogin() {		
		return loginTF.getText();		
	}

	public String getPassword() {
		return String.valueOf(this.passwordPF.getPassword());
	}

	public void clear() {
		this.loginTF.setText(null);
		this.passwordPF.setText(null);
	}
}