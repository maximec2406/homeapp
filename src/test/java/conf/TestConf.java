package conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//@EnableTransactionManagement //включаем транзактион манагер
@Configuration
@ComponentScan("ru.homeapp")
public class TestConf {

    @Bean
    public EntityManagerFactory getEntityMangerFactory(){
        return Persistence.createEntityManagerFactory("TestPersistenceUnit");
    }

    @Bean
    public EntityManager getEntityManager(EntityManagerFactory emf){
        return emf.createEntityManager();
    }

}
