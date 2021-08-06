package com.sgi.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sgi.entities.Incident;
import com.sgi.service.Service;
import com.sgi.ui.UICreerIncident;
import com.sgi.utils.Utilitaire;

public class CreerIncidentController {
	private UICreerIncident uiCreerIncident;

	public CreerIncidentController(UICreerIncident uiCreerIncident) {
		this.uiCreerIncident = uiCreerIncident;
		
		addListeners ();
	}
	
	private void addListeners () {
		
		uiCreerIncident.addEffacerListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
			
		uiCreerIncident.addValiderListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				String description = uiCreerIncident.getDescription ();
				String application = uiCreerIncident.getApplication ();
				String gravite = uiCreerIncident.getGravite ();
				
				Incident incident = new Incident (description, application, gravite);
				
				try {
					Service.creerIncident (incident);
					
					Utilitaire.displayNotification("Incident créé avec succès !");
				} catch (Exception e1) {
					Utilitaire.displayErrorMessage("Error : " + e1.getMessage());
				}								
			}
		});
		
		uiCreerIncident.addQuitterListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				uiCreerIncident.dispose();				
			}
		});
	}

	public void run() {
		uiCreerIncident.setVisible(true);
	}
}
