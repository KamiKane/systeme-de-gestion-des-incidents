package com.sgi.entities;

import java.util.List;

public class Incident {
	
	private int id;
	private int idRapporteur;
	private int idDeveloppeur;
	
	private String description;
	private String application;
	private String gravite;
	
	private Statut statut;
	
	List<Note> notes;
	
	public Incident(String description, String application, String gravite) {
		this.description = description;
		this.application = application;
		this.gravite = gravite;
		
		this.statut = Statut.NOUVEAU;
	}
	
	public Incident(int id, String description, String application, String gravite) {
		this(description, application, gravite);
		this.id = id;
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getApplication() {
		return application;
	}
	
	public String getGravite() {
		return gravite;
	}
	
	public void setIdDeveloppeur(int idDeveloppeur) {
		this.idDeveloppeur = idDeveloppeur;
	}
	
	public void setIdRapporteur(int idRapporteur) {
		this.idRapporteur = idRapporteur;
	}
	
	public int getIdDeveloppeur() {
		return idDeveloppeur;
	}
	
	public int getIdRapporteur() {
		return idRapporteur;
	}

	public String getStatut() {
		return statut.name();
	}
}
