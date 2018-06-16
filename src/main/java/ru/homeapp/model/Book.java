package ru.homeapp.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Book {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column (nullable = false)
    private String name;

    @Column
    private String description;

    @Column
    private String year;

    @Column (name = "original_lang")
    private String originalLang;

    @Column
    private double rating;

    @Column (name = "create_date")
    private LocalDate createDate;

    @ManyToOne (cascade = CascadeType.PERSIST)
    private int authorId;

    @OneToMany( mappedBy = "bookId", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Review> reviews = new ArrayList<Review>();

    @OneToMany( mappedBy = "bookId", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<ScreenAdaptation> screenAdaptations = new ArrayList<ScreenAdaptation>();

    public Book () {};

    // короткая форма для тестов
    public Book (String name, int authorId) {
        this.name = name;
        this.authorId = authorId;
    };

    public Book (String name, String description, String year, String originalLang, double rating, int authorId){
        if (name == null) throw new IllegalArgumentException ("Наименование не должно быть пустым");
        if (description == null) throw new IllegalArgumentException ("Описание не должно быть пустым");
        if (year == null) throw new IllegalArgumentException ("Год публикации не должен быть пустым");
        if (originalLang == null) throw new IllegalArgumentException ("Язык оригинала не должен быть пустым");
        if (authorId == 0) throw new IllegalArgumentException ("Не указан автор");

        this.name = name;
        this.description = description;
        this.year = year;
        this.originalLang = originalLang;
        this.rating = 0;
        this.authorId = authorId;
        this.createDate = LocalDate.now();
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getOriginalLang() {
        return originalLang;
    }

    public void setOriginalLang(String originalLang) {
        this.originalLang = originalLang;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
