package com.sgi.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sgi.entities.TypeOperation;
import com.sgi.ui.UIAuthentification;
import com.sgi.ui.UICreerIncident;
import com.sgi.ui.UISelectionOperation;
import com.sgi.ui.UIVisualiserIncident;

public class SelectionOperationController {
	private UISelectionOperation uiSelectionOperation;
	private UIAuthentification uIAuthentification;

	public SelectionOperationController(UISelectionOperation uiSelectionOperation,
			UIAuthentification uIAuthentification) {
		this.uiSelectionOperation = uiSelectionOperation;
		this.uIAuthentification = uIAuthentification;
		
		addListeners();
	}
	
	private void addListeners () {
		uiSelectionOperation.addValiderlistener ( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				TypeOperation operation = uiSelectionOperation.getTypeOperation ();
				switch (operation)
				{
					case CREER_INCIDENT:
						
						UICreerIncident uiCreerIncident = new UICreerIncident();
						CreerIncidentController creerIncidentController = new CreerIncidentController (uiCreerIncident);
		
						creerIncidentController.run ();
						
						break;
						
					case VISUALISER_INCIDENT:
						
						UIVisualiserIncident uiVisualiserIncident = new UIVisualiserIncident();
						VisualiserIncidentController visualiserIncidentController = new 
								VisualiserIncidentController (uiVisualiserIncident);
						
						visualiserIncidentController.run();
						
						break;
				}
			}
		});
		
		uiSelectionOperation.addQuitterlistener ( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				uiSelectionOperation.dispose();
				uIAuthentification.clear();
				uIAuthentification.montrer ();
				
			}
		});
		
	}

	public void run() {
		uiSelectionOperation.setVisible(true);
	}
}
