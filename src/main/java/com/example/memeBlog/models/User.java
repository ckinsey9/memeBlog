package com.example.memeBlog.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;


@Entity
public class User {


    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String username;

    @NotNull
    private String password;

    private String role;

    @ManyToMany(mappedBy = "favGang")
    @JoinColumn(name = "user_id")
    private ArrayList<Meme> favs;

    @OneToMany
    @JoinColumn(name = "user_id")
    private ArrayList<Meme> userMemes;


    @ManyToMany(mappedBy = "friends")
    private ArrayList<User> followers;

    @ManyToMany
    private ArrayList<User> following;

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

    public ArrayList<Meme> getFavs() {
        return favs;
    }

    public void addFav(Meme meme) {
        favs.add(meme);
    }

    public ArrayList<Meme> getUserMemes() {
        return userMemes;
    }

    public void addUserMeme(Meme userMeme) {
        userMemes.add(userMeme);
    }

    public ArrayList<User> getFollowers() {
        return followers;
    }

    public void addFollower(User follower) {
        followers.add(follower);
    }

    public void removeFollower(User follower) {
        followers.remove(follower);
    }

    public ArrayList<User> getFollowing() {
        return following;
    }

    public void addFollowing(User follow) {
        following.add(follow);
    }

    public void removeFollowing(User follow) {
        following.remove(follow);
    }
}
