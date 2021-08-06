package com.sgi.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import com.sgi.utils.Utilitaire;

public class UICreerIncident extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField tFApplication;
	private JButton buttonEffacer;
	private JButton buttonValider;
	private JButton buttonQuitter;
	private JTextArea tADescription;
	private JComboBox<String> cBGravite;
	
	public UICreerIncident() {
		setModal(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(new Dimension(400, 250));
		setResizable(false);
		setTitle("Cr\u00E9er un incident");
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "D\u00E9tails de l'incident ...", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel labelApplication = new JLabel("Application :");
		labelApplication.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(labelApplication, "2, 2, right, default");
		
		tFApplication = new JTextField();
		panel.add(tFApplication, "4, 2, fill, default");
		tFApplication.setColumns(10);
		
		JLabel labelDescription = new JLabel("Description :");
		labelDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(labelDescription, "2, 4");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane, "4, 4, fill, fill");
		
		tADescription = new JTextArea();
		scrollPane.setViewportView(tADescription);
		
		JLabel labelGravite = new JLabel("Niveau de gravit\u00E9 :");
		labelGravite.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(labelGravite, "2, 6, right, default");
		
		cBGravite = new JComboBox<>();
		cBGravite.addItem("LOW");
		cBGravite.addItem("HIGH");
		cBGravite.addItem("CRITICAL");		
		panel.add(cBGravite, "4, 6, fill, default");
		
		JPanel panelButtons = new JPanel();
		panelButtons.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		FlowLayout flowLayout = (FlowLayout) panelButtons.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(panelButtons, BorderLayout.SOUTH);
		
		buttonEffacer = new JButton("Effacer");
		panelButtons.add(buttonEffacer);
		
		buttonValider = new JButton("Valider");
		panelButtons.add(buttonValider);
		
		buttonQuitter = new JButton("Quitter");
		panelButtons.add(buttonQuitter);
		
		Utilitaire.setLookAndFeel(this);
		Utilitaire.center(this, this.getSize());
	}

	public void addEffacerListener(ActionListener actionListener) {
		this.buttonEffacer.addActionListener(actionListener);
	}

	public void addValiderListener(ActionListener actionListener) {
		this.buttonValider.addActionListener(actionListener);
	}
	
	public void addQuitterListener(ActionListener actionListener) {
		this.buttonQuitter.addActionListener(actionListener);
	}

	public String getDescription() {
		return tADescription.getText();
	}

	public String getApplication() {
		return this.tFApplication.getText();
	}

	public String getGravite() {
		return (String) cBGravite.getSelectedItem();
	}
}
