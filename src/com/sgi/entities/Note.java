package com.sgi.entities;

public class Note {
	private int id;
	private int idIncident;
	
	// Identifiant de celui qui a créé la note
	private int idCreateur;
	
	private String message;

	private String dateCreation;
	
	public Note(int id, int idIncident, int idCreateur, String message, String dateCreation) {
		this(idIncident, idCreateur, message, dateCreation);
		this.id = id;		
	}
	
	public Note(int idIncident, int idCreateur, String message, String dateCreation) {		
		this.idIncident = idIncident;
		this.idCreateur = idCreateur;
		this.message = message;
		this.dateCreation = dateCreation;
	}
	
	public int getId() {
		return id;
	}
	
	public int getIdCreateur() {
		return idCreateur;
	}
	
	public int getIdIncident() {
		return idIncident;
	}
	
	public String getMessage() {
		return message;
	}
	
	public String getDateCreation() {
		return dateCreation;
	}
}
