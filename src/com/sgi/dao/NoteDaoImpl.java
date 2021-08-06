package com.sgi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sgi.entities.Note;
import com.sgi.jdbc.DBManager;

public class NoteDaoImpl implements IDao<Note> {

	@Override
	public void create(Note note) throws Exception {
		Connection connection = DBManager.getConnection() ;

		String query = "Insert Into T_notes (idIncident,idCreateur,message,dateCreation) values (?,?,?,?)";

		PreparedStatement preparedStatement = connection.prepareStatement(query);

		preparedStatement.setInt(1, note.getIdIncident());
		preparedStatement.setInt(2, note.getIdCreateur());
		preparedStatement.setString(3, note.getMessage());
		preparedStatement.setString(4, note.getDateCreation());

		preparedStatement.execute();
		
		connection.close();

	}

	@Override
	public Note read(int id) throws Exception {
		Note note = null;
		
		Connection connection = DBManager.getConnection() ;

	    String query = "Select * From T_notes Where id = ?";
	    PreparedStatement preparedStatement = connection.prepareStatement(query);
	    preparedStatement.setInt(1, id);
	    
	    ResultSet resultSet = preparedStatement.executeQuery();
	    	    	    
	    if (resultSet.next()) {
	    	note = new Note (id, 
	        		resultSet.getInt("idIncident"), 
	        		resultSet.getInt("idCreateur"), 
	        		resultSet.getString("message"),
	        		resultSet.getString("dateCreation"));
	    }

	    connection.close();
	    
		return note;
	}

	@Override
	public void update(Note note) throws Exception {
		Connection connection = DBManager.getConnection() ;

	    String query = "Update T_notes Set message=? Where id=?";

	    PreparedStatement prepareStatement = connection.prepareStatement(query);
	        
	    prepareStatement.setString(1, note.getMessage());
	    prepareStatement.setInt(2, note.getId());
	       
	    prepareStatement.execute();
	    
	    connection.close();
	}

	@Override
	public void delete(Integer id) throws Exception {
		Connection connection = DBManager.getConnection() ;

		String query = "Delete From T_notes Where id=?";
	       
		PreparedStatement preparedStatement = connection.prepareStatement(query);

		preparedStatement.setInt(1, id);
		preparedStatement.execute();
		
		connection.close();
	}

	@Override
	public List<Note> list() throws Exception {
		Connection connection = DBManager.getConnection() ;

		List<Note> notes = new ArrayList<>();
		String query = "Select * From T_notes";

		PreparedStatement prepareStatement = connection.prepareStatement(query);
		ResultSet resultSet = prepareStatement.executeQuery();

		while (resultSet.next()) {
			
			int id = resultSet.getInt("id");
			int idIncident = resultSet.getInt("idIncident");
			int idCreateur = resultSet.getInt("idCreateur");
			String message = resultSet.getString("message");
			String dateCreation = resultSet.getString("dateCreation");
			
			Note note = new Note (id, idIncident, idCreateur, message, dateCreation);
			
			notes.add(note);
		}
		
		connection.close();
		
		return notes;
	}
	
	public List<Note> list(int idIncident) throws Exception {
		Connection connection = DBManager.getConnection() ;

		List<Note> notes = new ArrayList<>();
		String query = "Select * From T_notes where idIncident = ?";

		PreparedStatement prepareStatement = connection.prepareStatement(query);
		prepareStatement.setInt(1, idIncident);
		
		ResultSet resultSet = prepareStatement.executeQuery();

		while (resultSet.next()) {
			
			int id = resultSet.getInt("id");
			int idCreateur = resultSet.getInt("idCreateur");
			String message = resultSet.getString("message");
			String dateCreation = resultSet.getString("dateCreation");
			
			Note note = new Note (id, idIncident, idCreateur, message, dateCreation);
			
			notes.add(note);
		}
		
		connection.close();
		
		return notes;
	}
	
}
