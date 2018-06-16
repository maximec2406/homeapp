package ru.homeapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.homeapp.model.Author;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class AddBookBean {
    private final EntityManager em;

    public AddBookBean(@Autowired EntityManager em) {
        this.em = em;
    }

    @SuppressWarnings("unchecked")
    public List<Author> getSuppliers() {
        return em.createQuery("from Author").getResultList();
    }

    public Author findAutorById(int id) {
        return em.find(Author.class, id);
    }
}
