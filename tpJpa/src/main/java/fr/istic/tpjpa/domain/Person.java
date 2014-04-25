package fr.istic.tpjpa.domain;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries({@NamedQuery(name="La liste de personne présente dans ma base de données",
query= "select p from Person p where p.nom=:Nom and p.prenom=:Prenom")})
@Entity
public class Person {
	private String nom;
	private String prenom;
	private String mail;
	private String genre;
	private Date dateNaissance;
	private String profilFcbk;
	private Long id;
	private boolean valeur;
	private List<Person> friends;
	private List<Home> homes;
	private List<ElectroniqueDevice> devices;
public Person(){
	homes = new ArrayList<Home>();
	friends = new ArrayList<Person>();
	devices = new ArrayList<ElectroniqueDevice>();
	
}
public Person(String nom, String prenom, String mail, String profilFcbk){
	this.nom= nom;
	this.prenom = prenom;
	this.mail = mail;
	this.profilFcbk=profilFcbk;
	
	homes = new ArrayList<Home>();
	friends = new ArrayList<Person>();
	devices = new ArrayList<ElectroniqueDevice>();
	
}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getProfilFcbk() {
		return profilFcbk;
	}
	public void setProfilFcbk(String profilFcbk) {
		this.profilFcbk = profilFcbk;
	}
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToMany
	public List<Person> getFriends() {
		return friends;
	}
	public void setFriends(List<Person> friends) {
		this.friends = friends;
	}
	
	@OneToMany(mappedBy="person", cascade= CascadeType.PERSIST)
	public List<Home> getHomes() {
		return homes;
	}
	public void setHomes(List<Home> homes) {
		this.homes = homes;
	}
	@OneToMany(mappedBy="person", cascade= CascadeType.PERSIST)
	public List<ElectroniqueDevice> getDevices() {
		return devices;
	}
	public void setDevices(List<ElectroniqueDevice> devices) {
		this.devices = devices;
	}
	@Override
	public String toString() {
		return "nom= " + nom + ", prenom= " + prenom + ", mail= " + mail
				+ ", profilFcbk= " + profilFcbk + " ";
	}



}
