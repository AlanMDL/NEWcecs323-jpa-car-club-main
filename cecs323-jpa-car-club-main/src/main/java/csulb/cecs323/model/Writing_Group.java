package csulb.cecs323.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Writing_Group extends Authoring_Entities{
    @Id
    @Column(nullable = false, length = 80)
    private String name;

    @Column(nullable = false, length = 80)
    private String head_writer;

    private int year_formed;

    public Writing_Group() {
    }

    public Writing_Group(String email, String authoring_entity_type, String name, String head_writer, int year_formed) {
        super(email, authoring_entity_type, name, head_writer, year_formed);
        this.name = name;
        this.head_writer = head_writer;
        this.year_formed = year_formed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getHead_writer() {
        return head_writer;
    }

    @Override
    public void setHead_writer(String head_writer) {
        this.head_writer = head_writer;
    }

    @Override
    public int getYear_formed() {
        return year_formed;
    }

    @Override
    public void setYear_formed(int year_formed) {
        this.year_formed = year_formed;
    }
}
