package csulb.cecs323.model;
import javax.persistence.*;

//DONE
@Entity
@Table(name = "BOOKS")

public class Books
{
    @Id
    @Column(nullable = false, length = 17)
    private String isbn;

    @Column(nullable = false, length = 80)
    private String title;

    @Column(nullable = false, length = 30)

    private String authoring_entity_email;

    private int year_published;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PUBLISHER_NAME", nullable = false)
    private Publishers publishers;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "AUTHORING_ENTITY_EMAIL")
    @PrimaryKeyJoinColumn(name = "AUTHORING_ENTITY_EMAIL")
    private Authoring_Entities authoringEntity;

    public Books() {
    }

    public Books(String isbn, String title, int year_published, Publishers publishers, Authoring_Entities authoringEntity) {
        this.isbn = isbn;
        this.title = title;
        this.year_published = year_published;
        this.publishers = publishers;



        this.authoring_entity_email = authoringEntity.getEmail();

    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear_published() {
        return year_published;
    }

    public void setYear_published(int year_published) {
        this.year_published = year_published;
    }

    public Publishers getPublishers() {
        return publishers;
    }

    public String getEmail() {
        return authoring_entity_email;
    }

    public void setEmail(String email) {
        this.authoring_entity_email = email;
    }

    public void setPublishers(Publishers publishers) {
        this.publishers = publishers;
    }

    public Authoring_Entities getAuthoringEntity() {
        return authoringEntity;
    }

    public void setAuthoringEntity(Authoring_Entities authoringEntity) {
        this.authoringEntity = authoringEntity;
    }

    @Override
    public String toString ()
    {
        return "Books - ISBN: " + this.isbn + " Title: " + this.title +
                " Year Published: " + this.year_published + " Publisher: " + this.publishers.getName() +
                " Authoring Entity: " + this.authoringEntity.getName() + " Email: " + this.publishers.getEmail();
    }
}
