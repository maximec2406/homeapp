package ru.homeapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.homeapp.model.Author;
import ru.homeapp.model.Book;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BookDAO {

    @Autowired
    @PersistenceContext
    private EntityManager em;

    public BookDAO (EntityManager em) { // указываем спрингу, что хотим получить параметр снаружи
        this.em = em;
    }

    @Transactional // генерирует кучу кода, связанного с транзакциями, типа бегин, блоки трай и катч, в трай комитит
    // транзакцию, в катч ролбэк делает
    public Book createBook(String name, int autorId){
        return new Book(name, autorId);
    }

    @Transactional
    public void createInitialData() {
        Author au = new Author("Бильбо", "Бэггинс");
        createBook("Хоббит", au.getId());
    }

    public List<Book> getBookList(){
        return em.createQuery("from Book").getResultList();
    }

}
