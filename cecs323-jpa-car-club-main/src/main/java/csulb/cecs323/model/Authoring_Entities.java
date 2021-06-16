package csulb.cecs323.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "AUTHORING_ENTITY_TYPE")
public abstract class Authoring_Entities {

    @Id
    @Column(nullable = false, length = 30)
    private String email;

    @Column(nullable = true, length = 31)
    private String authoring_entity_type;

    @Column(nullable = false, length = 80)
    private String name;

    @Column(nullable = true, length = 80)
    private String head_writer;

    @Column(nullable = true)
    private int year_formed;



    public Authoring_Entities() {
    }

    public Authoring_Entities(String email, String authoring_entity_type, String name, String head_writer, int year_formed) {
        this.email = email;
        this.authoring_entity_type = authoring_entity_type;
        this.name = name;
        this.head_writer = head_writer;
        this.year_formed = year_formed;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuthoring_entity_type() {
        return authoring_entity_type;
    }

    public void setAuthoring_entity_type(String authoring_entity_type) {
        this.authoring_entity_type = authoring_entity_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHead_writer() {
        return head_writer;
    }

    public void setHead_writer(String head_writer) {
        this.head_writer = head_writer;
    }

    public int getYear_formed() {
        return year_formed;
    }

    public void setYear_formed(int year_formed) {
        this.year_formed = year_formed;
    }

    @Override
    public String toString ()
    {
        return "Authoring Entities - Email: " + this.email + " Authoring Entity Type: " + this.authoring_entity_type +
                " Name: " + this.name + " Head Writer: " + this.head_writer +
                " Year Formed: " + this.year_formed;
    }
}

/*
    ****DATABASE METHODS****

    ADDED
    Adding an object in the database

    public void saveAuthoringEntity(){
        //start a transaction
        try {
            transaction.begin();
            Authoring_Entity ae = new Authoring_Entity(name, email, head_writer, year_formed);
            em.persist(ae);
            //commit  a transaction
            transaction.commit();
        }
        finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
            em.close();
            emf.close();
        }
    }
    //ADDED
    //Retrieving an object from the database
    public Authoring_Entity getAuthoringEntity(String email){
        Authoring_Entity ae = em.find(Authoring_Entity.class, email);
        return ae;

    }
    //ADDED
    // Removing an object from the database
    public void removeAuthoringEntity(String email){
        try{
            em.getTransaction().begin();
            Authoring_Entity ae = em.find(Authoring_Entity.class, email);
            em.remove(ae);
            transaction.commit();
        }
        finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            em.close();
            emf.close();
        }
    }
    **/


