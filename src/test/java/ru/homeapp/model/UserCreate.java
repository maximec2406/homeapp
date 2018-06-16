package ru.homeapp.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import conf.TestConf;
import ru.homeapp.dao.UserDAO;

import javax.persistence.EntityManager;


@RunWith(SpringJUnit4ClassRunner.class) // сообщаем junit, что этот класс используется со spring
@ContextConfiguration(classes = TestConf.class) // указываем, какую конфигурацию юзать
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD) //жизненный цикл контекста, указывает, пересоздавать ли контекст при/до/после вызова метода
// здесь задано пересоздавать контекст при вызове каждого нового теста
public class UserCreate {

    @Autowired
    private EntityManager em;

    @Autowired
    private UserDAO dao;

//    private static final Logger log = Logger.getLogger(PartTest.class);

    @Test
    public void testCreateUser() throws Throwable {

        User user = dao.createUser("Фродо", "Бэггинс", "frodo");
        System.out.print(dao.findByLogin("frodo"));


    }

//    @Test
//    public void testCreatePart() throws Throwable {
//
//        Supplier supplier = dao.createSupplier("производитель");
//        Part part = dao.createPart("0001", "деталь", supplier);
//        em.getTransaction().begin();
//        try {
//            em.getTransaction().commit();
//        } catch (Throwable t) {
//            em.getTransaction().rollback();
//            log.error("исключение в testCreatePart");
//            throw t;
//        }
//        Part found = em.find(Part.class, part.getId());
//        assertNotNull(found);
//        assertNotNull(found.getSupplier());
//    }

//    @Test
//    public  void testQuery() throws Throwable {
//        testCreatePart();
//        String searchString = "0001";
//
//        @SuppressWarnings("unchecked") // игнорируем вариниг
//                List<Part> parts = dao.findById(searchString);
//
//        assertEquals(1, parts.size()); // найдена только одна деталь
//        Part found = parts.get(0);
//        assertEquals(searchString, found.getPartId()); // найдена именна деталь с нужным id
//
//    }
}


