package fr.istic.tpjpa.domain;



import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
@DiscriminatorValue("HEATER")
public class Heater extends PeripherieInt {

	private int consomation;
	private long id;
	private Home home;
	private ElectroniqueDevice devices;
	public Heater(){
		
	}
	public Heater(int consomation){
		this.consomation=consomation;
		
	
	}
	public int getConsomation() {
		return consomation;
	}
	public void setConsomation(int consomation) {
		this.consomation = consomation;
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
	public Home getHome() {
		return home;
	}
	public void setHome(Home home) {
		this.home = home;
	}
//	@ManyToOne
//	public ElectroniqueDevice getDevices() {
//		return devices;
//	}
//	public void setDevices(ElectroniqueDevice devices) {
//		this.devices = devices;
//	}
	@Override
	public String toString() {
		return "Heater :consomation =" + consomation + "";
	}
	
	
}
