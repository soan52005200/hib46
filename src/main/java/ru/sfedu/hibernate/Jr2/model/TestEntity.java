package ru.sfedu.hibernate.Jr2.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.TemporalType.TIME;

@Entity
public class TestEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Temporal(TIME)
    private Date dateCreated;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "FIRST_NAME")),
            @AttributeOverride(name = "numtest", column = @Column(name = "FIRST_NUMTEST")),
            @AttributeOverride(name = "phone_number", column = @Column(name = "FIRST_PHONENUMBER"))
    })
    private User firstUser;



    public TestEntity(){

    }

    public TestEntity(String name, String description, Date dateCreated, User firstUser) {
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.firstUser = firstUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public User getFirstUser() {
        return firstUser;
    }

    public void setFirstUser(User firstUser) {
        this.firstUser = firstUser;
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "id=" + id +
                ", dateCreated='" + dateCreated + '\'' +
                ", firstUser=" + firstUser +
                '}';
    }

}
