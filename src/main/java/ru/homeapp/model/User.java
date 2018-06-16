package ru.homeapp.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column (name = "email", unique = true, nullable = false)
    private String email;

    @Column (name = "login", unique = true, nullable = false)
    private String login;

    @Column
    private String password;

    @Column (name = "first_name")
    private String firstName;

    @Column (name = "last_name")
    private String lastName;

    @Column
    private LocalDate birthday;

    @Column (name = "about_self")
    private String aboutSelf;

    @Column
    private String avatar;

    @Column (name = "create_date")
    private LocalDate createDate;

    @Column
    private boolean isLocked;

    @OneToMany( mappedBy = "creatorId", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY) // при вызове supplier не будет подгружаться весь сприсок parts
    private List<Review> reviews = new ArrayList<Review>();

    public User () {}

    public User (String firstName, String lastName, String login){
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User (String email, String login, String firstName, String lastName, LocalDate birthday, String aboutSelf, String avatar){
        if (firstName == null) throw new IllegalArgumentException ("Имя не должно быть пустым");
        if (lastName == null) throw new IllegalArgumentException ("Фамилия не должна быть пустой");
        if (login == null) throw new IllegalArgumentException ("Логин не должен быть пустым");

        this.email = email;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.aboutSelf = aboutSelf;
        this.avatar = avatar;
        this.createDate = LocalDate.now();
        this.isLocked = false;

    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAboutSelf() {
        return aboutSelf;
    }

    public void setAboutSelf(String aboutSelf) {
        this.aboutSelf = aboutSelf;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
