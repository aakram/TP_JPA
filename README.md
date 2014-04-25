TP_JPA
======
Le TP a pour but la mise en place d’une application de type réseau social permettant de comparer 

sa consommation électrique avec ses amis, ses voisins.

Transformation de classe en entité

Une Personne est définie par son nom, prénom, son genre, son mail, sa date de naissance et son 

profil facebook, une liste de maison, une liste devices, une liste d’amis. 

Une maison est définie par une adresse, une superficie, une adresse IP, une liste de chauffage.

Les metiers Personne et maison seront construites en utilisant la convention du javaBean, c'est-à-

dire en mettant en place des getters, setters des différentes variable présentent et un constructeur 

vide.

Vu que nos classes métiers sont transformées en entité on va appliquer le principe de mapping sur 

ces différentes classes. Chaque classe possède un identifiant. 

Exemple de classe metier Personne. 

Les autres métiers seront transformés selon même principe que la classe Personne.

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

public String getNom() {

}

public void setNom(String nom) {

}

public String getPrenom() {

}

public void setPrenom(String prenom) {

}

public String getMail() {

}

public void setMail(String mail) {

}

public String getGenre() {

return nom;

this.nom = nom;

return prenom;

this.prenom = prenom;

return mail;

this.mail = mail;

}

public void setGenre(String genre) {

}

public Date getDateNaissance() {

}

public void setDateNaissance(Date dateNaissance) {

}

public String getProfilFcbk() {

}

public void setProfilFcbk(String profilFcbk) {

}

@Id

@GeneratedValue

public Long getId() {

}

public void setId(Long id) {

}

@ManyToMany

public List<Person> getFriends() {

}

public void setFriends(List<Person> friends) {

}

@OneToMany(mappedBy="person", cascade= CascadeType.PERSIST)

public List<Home> getHomes() {

}

public void setHomes(List<Home> homes) {

}

@OneToMany(mappedBy="person", cascade= CascadeType.PERSIST)

public List<ElectroniqueDevice> getDevices() {

}

public void setDevices(List<ElectroniqueDevice> devices) {

}

return genre;

this.genre = genre;

return dateNaissance;

this.dateNaissance = dateNaissance;

return profilFcbk;

this.profilFcbk = profilFcbk;

return id;

this.id = id;

return friends;

this.friends = friends;

return homes;

this.homes = homes;

return devices;

this.devices = devices;

Les Mapping :

La personne peux posséder plusieurs amis et chacune de ses amis possède aussi plusieurs amis. 

D’où le mapping @ManyToMany.

Une personne possède plusieurs maisons et une maison est affecté à une seule personne à la fois.

Une personne possède plusieurs électronique devices et un électronique device est affecté à une 

seule personne à la fois.

La classe maison :

@Id

@GeneratedValue

public Long getId() {

}

public void setId(Long id) {

}

@ManyToOne

public Person getPerson() {

}

public void setPerson(Person person) {

}

@OneToMany(mappedBy="home", cascade=CascadeType.PERSIST)

public List<Heater> getChauffage() {

}

public void setChauffage(List<Heater> chauffage) {

}

Identifiant de la classe maison.

Le mapping :

La maison possède un seul propriétaire, et chaque propriétaire à une liste de maison. D’où le 

@ManyToOne.

Chaque maison se constitue de plusieurs chauffages. D’où le @OneToMany.

Peupler la base de données. Avec des Personnes, des maison, et des électronique devices

public static void main(String[] args) {

return id;

this.id = id;

return person;

this.person = person;

return chauffage;

this.chauffage = chauffage;

EntityManagerFactory factory = Persistence

EntityManager manager = factory.createEntityManager();

JpaTest test = new JpaTest(manager);

EntityTransaction tx = manager.getTransaction();

tx.begin();

// TODO create entity

PeripherieInt p = new PeripherieInt();

// TODO persist entity

test.createPerson();

test.createElectronique();

test.Person();

tx.commit();

test.listPerson();

test.listHome();

test.listeElectroniques();

test.listeHeater();

// TODO run request

manager.close();

System.out.println(".. done");

.createEntityManagerFactory("example");

}

private void createPerson() {

int numOfPersonnes = manager

if (numOfPersonnes == 0) {

Person personne1 = new Person("balde", "kadiatou",

Person personneB = new Person("balde", "kadjatouBW",

Person personneW = new Person("balde", "kadjatouB",

Person personne2 = new Person("dupond", "durand",

Person personne3 = new Person("lucia", "marie",

Home maison1 = new Home(20, 1, "52 avenue de la replubique",

Home maison2 = new Home(30, 2,

Home maison3 = new Home(55, 3,

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

.createQuery("Select person From Person person", Person.class)

.getResultList().size();

"balde.kadjatou@gmail.com", "kadjatou");

"balde.kadjatouW@gmail.com", "kadjatouB");

"balde.kadjatouW@gmail.com", "kadjatouB");

"dupond.durand@gmail.com", "dupon");

"lucia.marie@gmail.com", "lucie");

"192.01.123");

"33,Avenue du général leclerc 37200 Tours", "140.01.123");

"58,Rue olivier de serres 35000 Rennes", "130.08.97");

}

}

 Nous avons crées une méthode createPerson dans laquelle nous avons ajoutes des personnes, 

des maisons et des électroniques devices. Nous avons récupérés l’identifiant de la personne qui 

sera une clé étrangère pour la classe maison et électronique device. Ensuite nous avons reliés 

les maisons et électroniques devices à une personne, et enfin nous avons rendu persistant les 

personnes. On appellera cette méthode plus haut dans la méthode main.

Vu qu’on niveau du mapping nous avons utilises du persisteType.Cascade, donc cette dernière va 

rendre automatique maison et electronique device persistants.

Connexion à la base de données MySQL de l’istic. 

<?xml version="1.0" encoding="UTF-8" ?>

<persistence xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"

xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd"

version="2.0" xmlns="http://java.sun.com/xml/ns/persistence">

 <persistence-unit name="example" transaction-type="RESOURCE_LOCAL">

 <properties>

 

 <property name="hibernate.hbm2ddl.auto" value="create" />

<property name="hibernate.archive.autodetection" value="class, hbm" />

<property name="toplink.target-database" value="MySQL"/>

<property name="hibernate.show_sql" value="true" />

<property name="hibernate.connection.driver_class" value="com.mysql.jdbc.Driver" />

<property name="hibernate.connection.password" value="miage" />

<property name="hibernate.connection.url"

value="jdbc:mysql://mysql.istic.univ-rennes1.fr/base_12012310" />

<property name="hibernate.connection.username" value="user_12012310" />

<property name="hibernate.dialect" value="org.hibernate.dialect.MySQLDialect" />

<property name="hibernate.max_fetch_depth" value="3" />

 <property name="hibernate.c3p0.min_size" value="5"/>

 <property name="hibernate.c3p0.max_size" value="20"/>

 <property name="hibernate.c3p0.timeout" value="5000"/>

 <property name="hibernate.c3p0.max_statements" value="50"/>

 <property name="hibernate.c3p0.idle_test_period" value="3000"/>

 </properties>

 </persistence-unit>

</persistence> 

Notion d’héritage : 

Les chauffages et électroniques devices sont des périphéries Intelligents.

Mise en place de la classe mère qui est périphérie Intelligent qui contiendra l’identifiant.

@Entity

@Inheritance(strategy=InheritanceType.JOINED)

public class PeripherieInt {

private long idPeri;

public PeripherieInt(){

}

@Id

@GeneratedValue

public long getIdPeri() {

}

public void setIdPeri(long idPeri) {

}

}

Mise en place de la notion d’héritage dans les classes enfants chauffage et électronique device.

@Entity

@DiscriminatorValue("HEATER")

return idPeri;

this.idPeri = idPeri;

public class Heater extends PeripherieInt {

private int consomation;

private long id;

private Home home;

private ElectroniqueDevice devices;

public Heater(){

}

public Heater(int consomation){

}

public int getConsomation() {

}

public void setConsomation(int consomation) {

}

@ManyToOne

public Home getHome() {

}

public void setHome(Home home) {

}

}

this.consomation=consomation;

return consomation;

this.consomation = consomation;

return home;

this.home = home;

@Entity

@DiscriminatorValue("ELECTRONIQUEDEVICE")

public class ElectroniqueDevice extends PeripherieInt {

private int consommation;

private long id;

private Person person;

public ElectroniqueDevice(){

}

public ElectroniqueDevice(int consommation){

public int getConsommation() {

}

public void setConsommation(int consommation) {

}

@ManyToOne

public Person getPerson() {

}

public void setPerson(Person person) {

}

}

Example de requête Paramétrée: La liste des personnes ayant le même nom dans notre base de 

données. 

private void Person() {

this.consommation=consommation;

}

return consommation;

this.consommation = consommation;

return person;

this.person = person;

List<Person> Persons = manager.createQuery(

System.out.println("num of Person:" + Persons.size());

for (Person per : Persons) {

System.out.println("next person: " + per.toString());

}

"select distinct p from Person p, Person p2 where p.id != p2.id and p.nom = p2.nom", Person.class)

.getResultList();

}

Les requêtes Nommée :

@NamedQueries({@NamedQuery(name="La liste de personne présente dans ma base de 

données",

query= "select p from Person p where p.nom=:Nom and p.prenom=:Prenom")})

@Entity

public class Person {

Rapport Gae

Nous avons décidé d’adapter le projet de JPA. 4

Nous avons trois packages qui sont les suivants le package client, le server et le shared.

Le package client contient le service synchrone et asynchrone, ainsi que le point d’entré.

Le package server contient service d’implémentation ou autrement dit la définition de la servlet.

Le package shared contient toutes les classes métiers.

Dans le package client, nous avons crée un service synchrone (création d’une personne, et celle 

d’une liste de personne) à l’aide d’une classe.

@RemoteServiceRelativePath("greet")

public interface GreetingService extends RemoteService {

Person createPerson(String name, String firstName, String profilFbk);

 List<Person> listAllPerson();

 Home createHome(int tailleResid, int nbrePieces, String adresse);

 

}

 Dans le package client, nous avons crée un service asynchrone (création d’une personne, et celle 

d’une liste de personne) à l’aide d’une classe.

public interface GreetingServiceAsync {

void createPerson(String name, String firstName,String profilFbk,

void listAllPerson(AsyncCallback<List<Person>> callback);

void createHome(int tailleResid, int nbrePieces, String adresse, AsyncCallback<Home> callback);

}

Dans ce projet nous avons mis en place la création d’une personne, ainsi que les différents 

champs à saisir.

Dans le package server, nous avons crée un service d’implémentation, avec la création d’une 

classe contenant les méthodes de création d’une personne et celle d’une liste de personne.

public Person createPerson(String name, String firstName,String profilFbk) {

AsyncCallback<Person> callback);

Person p = new Person(name, firstName);

EntityTransaction t = manager.getTransaction();

if (!t.isActive())

t.begin();

manager.persist(p);

t.commit();

return p;

}

public List<Person> listAllPerson(){

List<Person> res = new ArrayList<>();

res.addAll(manager.createQuery("select p from Person as p",Person.class).getResultList());

return res;

}

Par contre nous n’avons pas pue mettre en place la liste de home à l’intérieur d’une personne.
