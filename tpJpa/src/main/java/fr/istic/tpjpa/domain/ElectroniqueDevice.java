package fr.istic.tpjpa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("ELECTRONIQUEDEVICE")
public class ElectroniqueDevice extends PeripherieInt {
	private int consommation;
	private long id;
	private Person person;
	//private List<Heater> chauffage;
	
	public ElectroniqueDevice(){
		//chauffage= new ArrayList<Heater>();
		
	}
	public ElectroniqueDevice(int consommation){
		this.consommation=consommation;
		//chauffage = new ArrayList<Heater>();
	}
	public int getConsommation() {
		return consommation;
	}
	public void setConsommation(int consommation) {
		this.consommation = consommation;
	}
//	@Id
//	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@ManyToOne
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
//@OneToMany(mappedBy="devices", cascade=CascadeType.PERSIST)
//	public List<Heater> getChauffage() {
//		return chauffage;
//	}
//	public void setChauffage(List<Heater> chauffage) {
//		this.chauffage = chauffage;
//	}
	@Override
	public String toString() {
		return "ElectroniqueDevice [consommation=" + consommation + "]";
	}
	

}
