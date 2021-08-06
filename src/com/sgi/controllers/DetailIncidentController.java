package com.sgi.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.sgi.entities.Note;
import com.sgi.entities.User;
import com.sgi.service.Service;
import com.sgi.ui.UIDetailIncident;
import com.sgi.utils.Utilitaire;

public class DetailIncidentController {
	
	private UIDetailIncident uiDetailIncident;

	public DetailIncidentController(UIDetailIncident uiDetailIncident) {
		this.uiDetailIncident = uiDetailIncident;
		
		int idIncident = uiDetailIncident.getIdIncident();
		List<Note> notes;
		try {
			notes = Service.listerNotes (idIncident);
			uiDetailIncident.afficherLesNotes (notes);
		} catch (Exception e) {
			Utilitaire.displayErrorMessage("Erreur au chargement des notes : " + e.getMessage());
		}				
		
		addListeners ();
	}
	
	private void addListeners () {
		
		uiDetailIncident.addAjouterNouvelleNoteListener (new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String message = uiDetailIncident.getNouvelleNote();								
				
				if (message.equals("")) return;
				
				try {
					
					Note note = new Note (uiDetailIncident.getIdIncident(), 
								User.getConnectedUserId(),
								message, 
								Utilitaire.getCurrentTime());
					
					Service.creerNote (note);
					uiDetailIncident.effacerLeChampNouvelleNote();
					Utilitaire.displayNotification("Note ajoutée avec succès !");
					
				} catch (Exception e1) {
					Utilitaire.displayErrorMessage("Error " + e1.getMessage());
				}
				
			}
		});
		
		uiDetailIncident.addAssignerListener (new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		uiDetailIncident.addCloturerListener (new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	public void run() {
		uiDetailIncident.setVisible(true);
	}
}
