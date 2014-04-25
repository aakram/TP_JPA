package fr.istic.tpjpa.jpa;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import fr.istic.tpjpa.domain.ElectroniqueDevice;
import fr.istic.tpjpa.domain.Heater;
import fr.istic.tpjpa.domain.Home;
import fr.istic.tpjpa.domain.PeripherieInt;
import fr.istic.tpjpa.domain.Person;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("example");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		// TODO create entity
		PeripherieInt p = new PeripherieInt();
		// TODO persist entity
		test.createPerson();
		//test.createElectronique();
		test.Person();
		//test.listHome();
		test.listeElectroniques();
		test.listeHeater();
				
		tx.commit();
		
		
		// TODO run request
		manager.close();
		System.out.println(".. done");
	}

	private void createPerson() {
		int numOfPersonnes = manager
				.createQuery("Select person From Person person", Person.class)
				.getResultList().size();
		if (numOfPersonnes == 0) {
			Person personne1 = new Person("balde", "kadiatou",
					"balde.kadjatou@gmail.com", "kadjatou");
			Person personneB = new Person("balde", "kadjatouBW",
					"balde.kadjatouW@gmail.com", "kadjatouB");
			Person personneW = new Person("balde", "kadjatouB",
					"balde.kadjatouW@gmail.com", "kadjatouB");
			Person personne2 = new Person("dupond", "durand",
					"dupond.durand@gmail.com", "dupon");
			Person personne3 = new Person("lucia", "marie",
					"lucia.marie@gmail.com", "lucie");

			Home maison1 = new Home(20, 1, "52 avenue de la replubique",
					"192.01.123");
			Home maison2 = new Home(30, 2,
					"33,Avenue du général leclerc 37200 Tours", "140.01.123");
			Home maison3 = new Home(55, 3,
					"58,Rue olivier de serres 35000 Rennes", "130.08.97");
			
			ElectroniqueDevice device = new ElectroniqueDevice(30);
			
			Heater chauffage1 =new Heater(42);
			Heater chauffage2 =new Heater(25);
			
			maison3.getChauffage().add(chauffage1);
			maison2.getChauffage().add(chauffage2);
			
			chauffage1.setHome(maison3);
			chauffage2.setHome(maison2);
			
			
			personne1.getFriends().add(personne2);
			personne1.getFriends().add(personne3);
			
			personne1.getHomes().add(maison1);
			personne1.getHomes().add(maison2);
			personne1.getHomes().add(maison3);
			personne1.getDevices().add(device);
			
			
			maison1.setPerson(personne1);
			maison2.setPerson(personne1);
			maison3.setPerson(personne1);
			device.setPerson(personne1);
			
			manager.persist(personne1);
			manager.persist(personne2);
			manager.persist(personne3);
			manager.persist(personneB);
			manager.persist(personneW);
			
		

		}
	}

	private void Person() {
		List<Person> Persons = manager.createQuery(
				"select distinct p from Person p, Person p2 where p.id != p2.id and p.nom = p2.nom", Person.class)
				.getResultList();
		System.out.println("num of Person:" + Persons.size());
		for (Person per : Persons) {
			System.out.println("next person: " + per.toString());
			
		}

	}



	private void listHome() {

		List<Home> Homes = manager.createQuery(
				"Select home From Home home where home.adresse='33,Avenue du général leclerc 37200 Tours'",
				Home.class).getResultList();

		System.out.println("num of Homes:" + Homes.size());
		
		for (Home h : Homes) {
			
			System.out.println("next home: " + h.toString());

		}
	}

	private void createElectronique() {
		int numOfDevice = manager
				.createQuery("select device from ElectroniqueDevice device", ElectroniqueDevice.class)
				.getResultList().size();
		if (numOfDevice == 0) {
		ElectroniqueDevice device1 = new ElectroniqueDevice(45);
		ElectroniqueDevice device2 = new ElectroniqueDevice(25);
		Heater chauffage = new Heater(52);
		
		//device1.getChauffage().add(chauffage);
		
		//chauffage.setDevices(device1);
		
		manager.persist(device1);
		manager.persist(device2);
	}
}
	private void listeElectroniques() {
		// la liste des electroniques devices
		List<ElectroniqueDevice> ElectroniquesDevices = manager.createQuery(
				"select device from ElectroniqueDevice device",
				ElectroniqueDevice.class).getResultList();

		System.out.println("num of electronique:" + ElectroniquesDevices.size());
		
		// analyse du résultat (classique)
		for (ElectroniqueDevice e : ElectroniquesDevices) {
			System.out.println("next device: " + e.toString());
		}
	}

	

private void listeHeater() {
	// la liste des electroniques devices
	List<Heater> Heaters = manager.createQuery(
			"select heater from Heater heater",
			Heater.class).getResultList();

	System.out.println("num of heater:" + Heaters.size());
	// analyse du résultat (classique)
	for (Heater e : Heaters) {
		System.out.println("next heater: " + e.toString());
	}
}


}
