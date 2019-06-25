package com.example.memeBlog.models;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;


@Entity
public class Meme {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

    @Lob
    @NotNull
    private byte[] pic;

    private ArrayList<User> likers;

    @Size(max = 50)
    private String owner_comment;

    @Size(max = 50)
    private ArrayList<String> guest_comments;

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

    public ArrayList<User> getLikers() {
        return likers;
    }

    public String getOwner_comment() {
        return owner_comment;
    }

    public ArrayList<String> getGuest_comments() {
        return guest_comments;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }

    public void setLikers(ArrayList<User> likers) {
        this.likers = likers;
    }

    public void setOwner_comment(String owner_comment) {
        this.owner_comment = owner_comment;
    }

    public void setGuest_comments(ArrayList<String> guest_comments) {
        this.guest_comments = guest_comments;
    }
}
