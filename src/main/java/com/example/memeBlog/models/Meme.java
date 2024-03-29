package com.example.memeBlog.models;

import javax.persistence.*;



import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Meme {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=30, message = "Between 3 and 30 characters")
    private String name;

    @Lob
    private byte[] pic;

    @ManyToMany
    private List<User> favGang = new ArrayList<>();

    @ManyToOne
    private User user;

    @Size(max = 50)
    private String owner_comment;

    //@Size(max = 50)
    //private ArrayList<String> guest_comments;

    public Meme() {}

    public Meme(String name, byte[] pic, String owner_comment) {
        this.name = name;
        this.pic = pic;
        this.owner_comment = owner_comment;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public byte[] getPic() {
        return pic;
    }

    public List<User> getLikers() {
        return favGang;
    }

    public String getOwner_comment() {
        return owner_comment;
    }

    //public ArrayList<String> getGuest_comments() {
    //    return guest_comments;
    //}

    public void setName(String name) {
        this.name = name;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }



    public void setOwner_comment(String owner_comment) {
        this.owner_comment = owner_comment;
    }

    //public void setGuest_comments(ArrayList<String> guest_comments) {
    //    this.guest_comments = guest_comments;
    //}
}
