package com.sgi.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.sgi.entities.TypeOperation;
import com.sgi.utils.Utilitaire;

public class UISelectionOperation extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JButton buttonQuitter;
	private JButton buttonValider;
	private JRadioButton radioVisualiserIncident;
	private JRadioButton radioCreerIncident;

	public UISelectionOperation() {
		setSize(new Dimension(450, 180));
		setResizable(false);
		setTitle("S\u00E9lectionner une op\u00E9ration");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelCreerIncident = new JPanel();
		panelCreerIncident.setBorder(new TitledBorder(null, "S\u00E9lectionner une op\u00E9ration ...", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panelCreerIncident, BorderLayout.NORTH);
		
		radioCreerIncident = new JRadioButton("Cr\u00E9er un incident");
		radioCreerIncident.setSelected(true);
		panelCreerIncident.add(radioCreerIncident);
		
		ButtonGroup groupe = new ButtonGroup();
		groupe.add(radioCreerIncident);
		
		JPanel panelVisualiserIncident = new JPanel();
		panelCreerIncident.add(panelVisualiserIncident);
		FlowLayout flowLayout_1 = (FlowLayout) panelVisualiserIncident.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		
		radioVisualiserIncident = new JRadioButton("Visualiser les incidents");
		panelVisualiserIncident.add(radioVisualiserIncident);
		groupe.add(radioVisualiserIncident);
		
		JPanel panelButtons = new JPanel();
		panelButtons.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(panelButtons, BorderLayout.SOUTH);
		
		buttonValider = new JButton("Valider");
		panelButtons.add(buttonValider);
		
		buttonQuitter = new JButton("Quitter");
		panelButtons.add(buttonQuitter);
		
		Utilitaire.setLookAndFeel(this);
		Utilitaire.center(this, this.getSize());
	}

	public void addValiderlistener(ActionListener actionListener) {
		buttonValider.addActionListener(actionListener);		
	}
	
	public void addQuitterlistener(ActionListener actionListener) {
		buttonQuitter.addActionListener(actionListener);		
	}

	public TypeOperation getTypeOperation() {		
		if (radioCreerIncident.isSelected()) {
			return TypeOperation.CREER_INCIDENT;
		} else {
			return TypeOperation.VISUALISER_INCIDENT;
		}
	}
}
