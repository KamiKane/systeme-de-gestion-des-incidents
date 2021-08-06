package com.sgi.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

import com.sgi.entities.Incident;
import com.sgi.tablemodels.IncidentModel;
import com.sgi.utils.Utilitaire;

public class UIVisualiserIncident extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTable tableIncidents;
	private JButton buttonOuvrir;
	private JButton buttonFermer;
	private IncidentModel incidentModel;
	
	public UIVisualiserIncident() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(new Dimension(600, 300));
		setResizable(false);
		setTitle("Visualiser les incidents");
		
		JPanel panelListeIncidents = new JPanel();
		panelListeIncidents.setBorder(new TitledBorder(null, "Liste des incidents ...", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panelListeIncidents, BorderLayout.CENTER);
		panelListeIncidents.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelListeIncidents.add(scrollPane, BorderLayout.CENTER);
		
		tableIncidents = new JTable();
		
		incidentModel = new IncidentModel();
		tableIncidents.setModel(incidentModel);
		scrollPane.setViewportView(tableIncidents);
		
		JPanel panelButtons = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelButtons.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(panelButtons, BorderLayout.SOUTH);
		
		buttonOuvrir = new JButton("Ouvrir");
		panelButtons.add(buttonOuvrir);
		
		buttonFermer = new JButton("Fermer");
		panelButtons.add(buttonFermer);	
		
		Utilitaire.setLookAndFeel(this);
		Utilitaire.center(this, this.getSize());
	}

	public void AddOuvrirListener(ActionListener actionListener) {
		buttonOuvrir.addActionListener(actionListener);
	}
	
	public void AddFermerListener(ActionListener actionListener) {
		buttonFermer.addActionListener(actionListener);
	}

	public int getSelectedIncidentId() {		
		int idRow = tableIncidents.getSelectedRow();
		
		if (idRow == -1) return idRow;
		else {
			return (int) incidentModel.getValueAt(idRow, 0);
		}		
	}
	
	public void loadIncident (List<Incident> incidents) {
		incidentModel.setIncidents(incidents);
	}
}
