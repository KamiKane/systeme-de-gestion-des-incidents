package com.sgi.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sgi.entities.User;
import com.sgi.entities.UserType;
import com.sgi.service.Service;
import com.sgi.ui.UIAuthentification;
import com.sgi.ui.UISelectionOperation;

public class AuthentificationController {

	private UIAuthentification uiAuthentification;

	public AuthentificationController(UIAuthentification uiAuthentification) {
		this.uiAuthentification = uiAuthentification;
		
		addListeners();
	}
	
	private void addListeners () {
		
		uiAuthentification.addValiderListener ( new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String login = uiAuthentification.getLogin();
				String password = uiAuthentification.getPassword();
				System.out.print(login);
				System.out.print(password);
				if (login.equals("") || password.equals("")) {
					
					// afficher message d'erreur 
					System.out.print("Erreur0");
					
					return;
				}
				
				try {
					System.out.print("step1");
					User user = Service.authentifier(login, password);
					System.out.print("step2");
					if (user == null) {
						System.out.print("Erreur1");
					} else {												
						System.out.print("ok1");
						UserType userType = user.getUserType();
						System.out.print(user.toString());
						switch (userType)
						{
							case RAPPORTEUR:
								UISelectionOperation uiSelectionOperation = new UISelectionOperation();
								SelectionOperationController selectionController = new SelectionOperationController (uiSelectionOperation, uiAuthentification);
								System.out.print("ok ...!");
								selectionController.run ();
								System.out.print("RAPPORTEUR Clicked ...!");
								break;
								
							case DEVELOPPEUR:
								break;
								
							case RESPONSABLE:
								break;
								
							case ADMINISTRATEUR:
								break;
						}
						
						// cacher la fenetre d'authentification
						uiAuthentification.cacher();
					}
				} catch (Exception exception) {
					// afficher le message d'erreur ...
				}
			}
		});
		
		
		uiAuthentification.addQuitterListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				uiAuthentification.dispose();				
			}
		});
	}

	public void run() {
		uiAuthentification.montrer();
	}
}
