package fr.istic.tpjpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;



@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class PeripherieInt {
	private long idPeri;


	public PeripherieInt(){

	}

	@Id
	@GeneratedValue
	public long getIdPeri() {
		return idPeri;
	}

	public void setIdPeri(long idPeri) {
		this.idPeri = idPeri;
	}


}
