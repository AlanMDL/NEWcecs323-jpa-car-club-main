package csulb.cecs323.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//done
@Entity
public class Individual_Author extends Authoring_Entities {
    @Id
    @Column(nullable = false, length = 80)
    private String email;



    public Individual_Author() {
    }

    public Individual_Author(String email, String authoring_entity_type, String name, String head_writer, int year_formed) {
        super(email, authoring_entity_type, name, head_writer, year_formed);
        this.email = email;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }
}
