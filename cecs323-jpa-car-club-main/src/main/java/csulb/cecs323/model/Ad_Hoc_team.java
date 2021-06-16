package csulb.cecs323.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ad_Hoc_team extends Authoring_Entities
{
    @Id
    @Column(nullable = false, length = 30)
    private String email;

    @ManyToMany
    @JoinTable(
            name = "AD_HOC_TEAM_MEMBER",
            joinColumns = @JoinColumn(name = "AD_HOC_TEAM_EMAIL"),
            inverseJoinColumns = @JoinColumn(name = "INDIVIDUAL_AUTHORS_EMAIL"))
    List<Individual_Author> individualAuthor = new ArrayList<>();

    public Ad_Hoc_team(){
    }

    public Ad_Hoc_team(String email, String authoring_entity_type, String name, String head_writer, int year_formed) {
        super(email, authoring_entity_type, name, head_writer, year_formed);
        this.email = email;

    }

    public Ad_Hoc_team(String email, String authoring_entity_type, String name, String head_writer, int year_formed, List<Individual_Author> individualAuthor) {
        super(email, authoring_entity_type, name, head_writer, year_formed);
        this.email = email;
        this.individualAuthor = individualAuthor;
    }

    public String getAdhoc_teams_email() {
        return email;
    }

    public void setAdhoc_teams_email(String adhoc_teams_email) {
        this.email = adhoc_teams_email;
    }

    public List<Individual_Author> getindividualAuthor() {
        return individualAuthor;
    }

    public void setindividualAuthor(List<Individual_Author> individualAuthor) {
        this.individualAuthor = individualAuthor;
    }
    public void addIndividualAuthor(Individual_Author individualAuthor){
        this.individualAuthor.add(individualAuthor);
    }
    @Override
    public String toString ()
    {
        return "Ad Hoc Team - Email: " + this.email + " Authoring Entity: " + this.getAuthoring_entity_type() + "Name: " + this.getName() + "Head Writer: " + this.getHead_writer() +
                " Year formed: " + this.getYear_formed();
    }
}