package ru.homeapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.homeapp.dao.BookDAO;
import ru.homeapp.dao.UserDAO;

@Component
public class Initializator {
    @Autowired
    private UserDAO daoUser;
    @Autowired
    private BookDAO daoBook;

    @EventListener
    public void onAppStart(ContextRefreshedEvent event) {
        daoUser.createInitialData();
        daoBook.createInitialData();
    }
}
