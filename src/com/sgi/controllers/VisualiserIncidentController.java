package com.sgi.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.sgi.entities.Incident;
import com.sgi.service.Service;
import com.sgi.ui.UIDetailIncident;
import com.sgi.ui.UIVisualiserIncident;

public class VisualiserIncidentController {
	private UIVisualiserIncident uiVisualiserIncident;

	public VisualiserIncidentController(UIVisualiserIncident uiVisualiserIncident) {
		this.uiVisualiserIncident = uiVisualiserIncident;
		
		List<Incident> incidents;
		try {
			incidents = Service.listerIncidents ();
			uiVisualiserIncident.loadIncident(incidents);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		addListeners();
	}
	
	private void addListeners () {
		uiVisualiserIncident.AddOuvrirListener (new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int idIncident = uiVisualiserIncident.getSelectedIncidentId ();
				
				if (idIncident != -1) {
					
					UIDetailIncident uiDetailIncident = new UIDetailIncident(idIncident);
					DetailIncidentController detailIncidentController = 
							new DetailIncidentController (uiDetailIncident);
					
					detailIncidentController.run ();
				} 
			}
		});
		
		uiVisualiserIncident.AddFermerListener (new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				uiVisualiserIncident.dispose();
			}
		});				
	}

	public void run() {
		uiVisualiserIncident.setVisible(true);
	}
}
