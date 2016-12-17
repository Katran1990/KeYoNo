package com.khripko.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="NOTE")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "TITLE")
    private String title;
    @Lob
    @Column(name = "TEXT")
    private String text;
    @Column(name = "CREATION_DATE")
    private Date creationDate;
    @ManyToOne
    private UserDetails user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }
}
