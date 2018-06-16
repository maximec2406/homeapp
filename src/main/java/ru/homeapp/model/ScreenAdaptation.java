package ru.homeapp.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class ScreenAdaptation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne (cascade = CascadeType.PERSIST)
    private int bookId;

    @Column (nullable = false)
    private LocalDate year;

    @Column (nullable = false)
    private String name;

    @Column ( name = "create_date", nullable = false)
    private LocalDate createDate;

    @Column
    private String poster;

    @Column (name = "kinopoisk_url")
    private String kinopoiskUrl;

    public ScreenAdaptation () {};

    public ScreenAdaptation (int bookId, LocalDate year, String name, String poster, String kinopoiskUrl) {
        if (bookId == 0) throw new IllegalArgumentException ("Не указана книга");
        if (year == null) throw new IllegalArgumentException ("Не указан создатель");

        this.bookId = bookId;
        this.year = year;
        this.name = name;
        this.poster = poster;
        this.kinopoiskUrl = kinopoiskUrl;
        this.createDate = LocalDate.now();

    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getKinopoiskUrl() {
        return kinopoiskUrl;
    }

    public void setKinopoiskUrl(String kinopoiskUrl) {
        this.kinopoiskUrl = kinopoiskUrl;
    }
}
