package com.example.memeBlog.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
public class User {


    @Id
    @GeneratedValue
    private int id;

    //@NotNull
    @Size(min=1, max=30, message = "Please enter your first name")
    private String firstName;

    //@NotNull
    @Size(min=1, max=30, message = "Please enter your last name")
    private String lastName;

    @NotNull
    @Size(min=7, max=30, message = "Username must be 7 to 30 characters")
    private String username;

    @NotNull
    @Size(min=7, max=70, message = "Password must be 7 to 30 characters")
    private String password;

    private String role;

    @ManyToMany(mappedBy = "favGang")
    private List<Meme> favs = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Meme> userMemes = new ArrayList<>();


    @ManyToMany(mappedBy = "following")
    private List<User> followers = new ArrayList<>();

    @ManyToMany
    private List<User> following = new ArrayList<>();

    //Constructors

    public User(@NotNull String firstName, @NotNull String lastName,
                @NotNull String username, @NotNull String password,
                String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

//Getters and Setters


    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Meme> getFavs() {
        return favs;
    }

    public void addFav(Meme meme) {
        favs.add(meme);
    }

    public List<Meme> getUserMemes() {
        return userMemes;
    }

    public void addUserMeme(Meme userMeme) {
        userMemes.add(userMeme);
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void addFollower(User follower) {
        followers.add(follower);
    }

    public void removeFollower(User follower) {
        followers.remove(follower);
    }

    public List<User> getFollowing() {
        return following;
    }

    public void addFollowing(User follow) {
        following.add(follow);
    }

    public void removeFollowing(User follow) {
        following.remove(follow);
    }
}
