package com.sgi.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import com.sgi.entities.Note;
import com.sgi.utils.Utilitaire;

public class UIDetailIncident extends JDialog {
	private static final long serialVersionUID = 1L;
	
	private JButton buttonAjouter;
	
	private JComboBox<String> cBDeveloppeurs;
	private JButton buttonAssigner;
	private JButton buttonCloturer;
	
	private JTextArea tANotes;
	private JTextArea tADescription;
	private JTextArea tANouvelleNote;
	
	private JTextField tFIdentifiant;
	private JTextField tFApplication;
	private JTextField tFStatut;
	private JTextField tFGravite;
	
	private int idIncident;
		
	public UIDetailIncident(int idIncident) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(new Dimension(700, 600));
		setModal(true);
		setResizable(false);
		
		this.idIncident = idIncident;
		
		setTitle("D\u00E9tails de l'incident <" + idIncident + ">");				
				
		JPanel panelNotes = new JPanel();
		getContentPane().add(panelNotes, BorderLayout.SOUTH);
		panelNotes.setLayout(new BorderLayout(0, 0));
		
		JPanel panelAjouterNote = new JPanel();
		panelNotes.add(panelAjouterNote, BorderLayout.SOUTH);
		panelAjouterNote.setLayout(new BorderLayout(0, 0));
		
		JPanel panelButtonAjouter = new JPanel();
		panelAjouterNote.add(panelButtonAjouter, BorderLayout.EAST);
		
		buttonAjouter = new JButton("Ajouter");
		panelButtonAjouter.add(buttonAjouter);
		
		JPanel paneltFNote = new JPanel();
		paneltFNote.setBorder(new TitledBorder(null, "Ajouter une note ...", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelAjouterNote.add(paneltFNote, BorderLayout.CENTER);
		paneltFNote.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneNouvelleNote = new JScrollPane();
		scrollPaneNouvelleNote.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneNouvelleNote.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		paneltFNote.add(scrollPaneNouvelleNote, BorderLayout.CENTER);
		
		tANouvelleNote = new JTextArea();
		tANouvelleNote.setFont(new Font("Arial", Font.PLAIN, 12));
		tANouvelleNote.setRows(3);
		scrollPaneNouvelleNote.setViewportView(tANouvelleNote);
		
		JPanel panelFluxEchanges = new JPanel();
		panelFluxEchanges.setBorder(new TitledBorder(null, "Flux d'\u00E9changes ...", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelNotes.add(panelFluxEchanges);
		panelFluxEchanges.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneFluxEchanges = new JScrollPane();
		scrollPaneFluxEchanges.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneFluxEchanges.setPreferredSize(new Dimension(2, 190));
		panelFluxEchanges.add(scrollPaneFluxEchanges, BorderLayout.CENTER);
		
		tANotes = new JTextArea();
		tANotes.setEditable(false);
		tANotes.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPaneFluxEchanges.setViewportView(tANotes);
		
		JPanel panelDetailIncident = new JPanel();
		panelDetailIncident.setBorder(new TitledBorder(null, "D\u00E9tails de l'incident ...", TitledBorder.LEADING, TitledBorder.TOP, null, null));		
		panelDetailIncident.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.PREF_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel labelId = new JLabel("Id :");
		panelDetailIncident.add(labelId, "2, 2, right, default");
		
		tFIdentifiant = new JTextField();
		tFIdentifiant.setEnabled(false);
		tFIdentifiant.setEditable(false);
		panelDetailIncident.add(tFIdentifiant, "4, 2, fill, default");
		tFIdentifiant.setColumns(20);
		
		JLabel labelApplication = new JLabel("Application :");
		panelDetailIncident.add(labelApplication, "2, 4, right, default");
		
		tFApplication = new JTextField();
		tFApplication.setEnabled(false);
		tFApplication.setEditable(false);
		panelDetailIncident.add(tFApplication, "4, 4, fill, default");
		tFApplication.setColumns(10);
		
		JLabel labelDescription = new JLabel("Description :");
		labelDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		panelDetailIncident.add(labelDescription, "2, 6");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(2, 80));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelDetailIncident.add(scrollPane, "4, 6, fill, top");
		
		tADescription = new JTextArea();
		tADescription.setFont(new Font("Arial", Font.PLAIN, 11));
		tADescription.setRows(3);
		tADescription.setEditable(false);
		tADescription.setEnabled(false);
		scrollPane.setViewportView(tADescription);
		
		JLabel labelStatut = new JLabel("Statut :");
		panelDetailIncident.add(labelStatut, "2, 8, right, default");
		
		tFStatut = new JTextField();
		tFStatut.setEnabled(false);
		tFStatut.setEditable(false);
		panelDetailIncident.add(tFStatut, "4, 8, fill, default");
		tFStatut.setColumns(10);
		
		JLabel labelGravite = new JLabel("Niveau de gravit\u00E9 :");
		panelDetailIncident.add(labelGravite, "2, 10, right, default");
		
		tFGravite = new JTextField();
		tFGravite.setEnabled(false);
		tFGravite.setEditable(false);
		panelDetailIncident.add(tFGravite, "4, 10, fill, default");
		tFGravite.setColumns(10);
		
		getContentPane().add(panelDetailIncident, BorderLayout.WEST);
		
		JPanel panelChangementEtat = new JPanel();
		panelChangementEtat.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Autres actions ...", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(panelChangementEtat, BorderLayout.CENTER);
		panelChangementEtat.setLayout(new BorderLayout(0, 0));
		
		JPanel panelAssigner = new JPanel();
		panelChangementEtat.add(panelAssigner, BorderLayout.NORTH);
		
		JLabel labelAssigner = new JLabel("Assign\u00E9 \u00E0 :");
		panelAssigner.add(labelAssigner);
		
		cBDeveloppeurs = new JComboBox<>();
		cBDeveloppeurs.setPreferredSize(new Dimension(150, 22));
		panelAssigner.add(cBDeveloppeurs);
		
		buttonAssigner = new JButton("Assigner");
		panelAssigner.add(buttonAssigner);
		
		JPanel panelCloturer = new JPanel();
		FlowLayout fl_panelCloturer = (FlowLayout) panelCloturer.getLayout();
		fl_panelCloturer.setAlignment(FlowLayout.RIGHT);
		panelChangementEtat.add(panelCloturer, BorderLayout.SOUTH);
		
		buttonCloturer = new JButton("Cl\u00F4turer");
		buttonCloturer.setToolTipText("Cl\u00F4turer le ticket incident ...");
		buttonCloturer.setPreferredSize(new Dimension(80, 25));
		panelCloturer.add(buttonCloturer);
		
		JButton buttonOuvrir = new JButton("Ouvrir");
		buttonOuvrir.setToolTipText("Ouvrir \u00E0 nouveau le ticket incident ...");
		buttonOuvrir.setPreferredSize(new Dimension(80, 25));
		buttonOuvrir.setSize(new Dimension(80, 25));
		panelCloturer.add(buttonOuvrir);
		
		
		Utilitaire.setLookAndFeel(this);
		Utilitaire.center(this, this.getSize());
	}
	
	public int getIdIncident() {
		return idIncident;
	}

	public void addAjouterNouvelleNoteListener(ActionListener actionListener) {
		buttonAjouter.addActionListener(actionListener);
	}
	
	public void addCloturerListener(ActionListener actionListener) {
		buttonCloturer.addActionListener(actionListener);
	}
	
	public void addAssignerListener(ActionListener actionListener) {
		buttonAssigner.addActionListener(actionListener);
	}

	public void afficherLesNotes(List<Note> notes) {
		
		String fluxEchanges = "";
		
		for (Note note : notes) {
			fluxEchanges += note.getDateCreation() + ":" + note.getIdCreateur() + "\n";
			fluxEchanges += note.getMessage() + "\n\n";
		}
		
		this.tANotes.setText(fluxEchanges);
	}

	public String getNouvelleNote() {
		return this.tANouvelleNote.getText();
	}

	public void effacerLeChampNouvelleNote() {
		this.tANouvelleNote.setText(null);
	}	
}
