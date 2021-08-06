package com.sgi.entities;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private int id;
	private String login;
	private String password;
	private String type;

	private List<Incident> incidents;
	
	private static Integer connectedUserId = null;
	
	public User(String login, String password, String type) {
		this.login = login;
		this.password = password;
		this.type = type;
				
		incidents = new ArrayList<Incident>();
	}

	public User(int id, String login, String password, String type) {
		this(login, password, type);
		
		connectedUserId = id;
		this.setId(id);
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + "]";
	}
	
	public List<Incident> getIncidents() {
		return incidents;
	}

	public UserType getUserType() {
		
		if (type.equals(UserType.ADMINISTRATEUR.name()))
			return UserType.ADMINISTRATEUR;
		
		else if (type.equals(UserType.RESPONSABLE.name()))
			return UserType.RESPONSABLE;
		
		else if (type.equals(UserType.RAPPORTEUR.name()))
			return UserType.RAPPORTEUR;
		
		else if (type.equals(UserType.DEVELOPPEUR.name()))
			return UserType.DEVELOPPEUR;
		
		return null;
	}
	
	public static Integer getConnectedUserId () {
		return connectedUserId;
	}
}
