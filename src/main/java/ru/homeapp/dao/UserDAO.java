package ru.homeapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.homeapp.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Component
public class UserDAO {

    @Autowired
    @PersistenceContext
    private EntityManager em;

    public UserDAO (EntityManager em) { // указываем спрингу, что хотим получить параметр снаружи
        this.em = em;
    }

    @Transactional // генерирует кучу кода, связанного с транзакциями, типа бегин, блоки трай и катч, в трай комитит
    // транзакцию, в катч ролбэк делает
    public User createUser(String firstName, String lastName, String login){
        return new User(firstName, lastName, login);
    }


    public User findByLogin (String login) {
        return (User) em.createQuery("from User where login = :login").setParameter("login", login).getResultList().get(0);
    }

    @Transactional
    public void createInitialData() {
        createUser("Фродо", "Бэггинс", "Frodo");
    }

    public List<User> getUserList(){
        return em.createQuery("from User").getResultList();
    }
}
