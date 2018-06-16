package ru.homeapp.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne (cascade = CascadeType.PERSIST)
    private int bookId;

    @ManyToOne (cascade = CascadeType.PERSIST)
    private int creatorId;

    @Column (name = "create_date", nullable = false)
    private LocalDate createDate;

    @Column (name = "change_date")
    private LocalDate changeDate;

    @Column (name = "review_text", nullable = false)
    private String reviewText;

    @Column (nullable = false)
    private String visibility;

    public Review () {};

    public Review (int bookId, int creatorId, LocalDate changeDate, String reviewText, String visibility) {

        if (bookId == 0) throw new IllegalArgumentException ("Не указана книга");
        if (creatorId == 0) throw new IllegalArgumentException ("Не указан создатель");
        if (reviewText == null) throw new IllegalArgumentException ("Не указан текст рецензии");
        if (visibility == null) throw new IllegalArgumentException ("Не указана область видимости");

        this.bookId = bookId;
        this.creatorId = creatorId;
        this.createDate = LocalDate.now();
        this.changeDate = changeDate;
        this.reviewText = reviewText;
        this.visibility = visibility;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public LocalDate getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(LocalDate changeDate) {
        this.changeDate = changeDate;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }
}
