package es.leanmind.boilerplate.config;

import es.leanmind.boilerplate.app.search.HibernateSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class HibernateSearchConfig {

    @Autowired
    private EntityManager entityManager;

    public HibernateSearchService hibernateSearchService() {
        return new HibernateSearchService(entityManager);
    }

}