package fr.istic.tpjpa.domain;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@NamedQueries({@NamedQuery(name="La liste de maison présente dans ma base de données",
query= "select h from Home h")})
@Entity
public class Home {
	private int tailleResid;
	private int nbrePieces;
	private String adresse;
	private String adresseIp;
	private Long id;
	private Person person;
	private List<Heater> chauffage;
	
	public Home(){
		chauffage= new ArrayList<Heater>();
		
	}
	public Home(int tailleResid, int nbrePieces, String adresse, String adresseIp){
		this.tailleResid=tailleResid;
		this.nbrePieces=nbrePieces;
		this.adresse=adresse;
		this.adresseIp=adresseIp;
		chauffage= new ArrayList<Heater>();
	}
	public int getTailleResid() {
		return tailleResid;
	}
	public void setTailleResid(int tailleResid) {
		this.tailleResid = tailleResid;
	}
	public int getNbrePieces() {
		return nbrePieces;
	}
	public void setNbrePieces(int nbrePieces) {
		this.nbrePieces = nbrePieces;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getAdresseIp() {
		return adresseIp;
	}
	public void setAdresseIp(String adresseIp) {
		this.adresseIp = adresseIp;
	}
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	@OneToMany(mappedBy="home", cascade=CascadeType.PERSIST)
	public List<Heater> getChauffage() {
		return chauffage;
	}
	public void setChauffage(List<Heater> chauffage) {
		this.chauffage = chauffage;
	}
	@Override
	public String toString() {
		return "Home [tailleResid= " + tailleResid + ", nbrePieces= "
				+ nbrePieces + ", adresse= " + adresse + ", adresseIp= "
				+ adresseIp + "]";
	}
	

}
