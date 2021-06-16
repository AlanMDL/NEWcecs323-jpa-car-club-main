package csulb.cecs323.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Publishers")
public class Publishers {

    @Id
    @Column(nullable = false, length = 80)
    private String name;

    @Column(nullable = false, length = 80)
    private String email;

    @Column(nullable = false, length = 24)
    private String phone;


    public Publishers() {
    }

    public Publishers(String name, String email, String phone)
    {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }



    public String getName()
    {
        return name;
    }


    public void setName(String name)
    {
        this.name = name;
    }


    public String getEmail()
    {
        return email;
    }


    public void setEmail(String email)
    {
        this.email = email;
    }


    public String getPhone()
    {
        return phone;
    }


    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    @Override
    public String toString ()
    {
        return "Publishers - Name: " + this.name + " Email: " + this.email +
                " Phone Number: " + this.phone;
    }
}

