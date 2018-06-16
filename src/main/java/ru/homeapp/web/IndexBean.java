package ru.homeapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.homeapp.dao.BookDAO;
import ru.homeapp.model.Book;
import ru.homeapp.model.User;



import javax.persistence.EntityManager;
import java.util.List;

@Component
public class IndexBean {
    private final EntityManager em;
    private BookDAO dao;

    public IndexBean(@Autowired EntityManager em, @Autowired BookDAO dao) {
        this.em = em;
        this.dao = dao;
    }

    public List<Book> getUsers() {
        return dao.getBookList();
    }
}
