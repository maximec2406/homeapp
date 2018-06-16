package ru.homeapp.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column (name = "first_name", nullable = false)
    private String firstName;

    @Column (name = "last_name", nullable = false)
    private String lastName;

    @Column
    private String patronymic;

    @Column
    private LocalDate birthday;

    @Column
    private LocalDate deathday;

    @Column
    private String biography;

    @Column
    private String photo;

    @Column (name = "create_date")
    private LocalDate createDate;

    @Column
    private String country;

    @OneToMany( mappedBy = "authorId", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY) // при вызове supplier не будет подгружаться весь сприсок parts
    private List<Book> books = new ArrayList<Book>();

    public Author () {};

    // короткая форма для тестов
    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author (String firstName, String lastName, String patronymic, LocalDate birthday, LocalDate deathday,
                   String biography, String photo, String country){
        if (firstName == null) throw new IllegalArgumentException ("Имя не должно быть пустым");
        if (lastName == null) throw new IllegalArgumentException ("Фамилия не должна быть пустой");
        if (patronymic == null) throw new IllegalArgumentException ("Отчество не должно быть пустым");
        if (birthday == null) throw new IllegalArgumentException ("Дата рождения не должна быть пустой");

        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.deathday = deathday;
        this.biography = biography;
        this.photo = photo;
        this.country = country;
        this.createDate = LocalDate.now();
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

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getDeathday() {
        return deathday;
    }

    public void setDeathday(LocalDate deathday) {
        this.deathday = deathday;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
