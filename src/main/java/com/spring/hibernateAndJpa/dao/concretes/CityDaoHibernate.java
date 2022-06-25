package com.spring.hibernateAndJpa.dao.concretes;

import com.spring.hibernateAndJpa.dao.abstracts.CityDao;
import com.spring.hibernateAndJpa.entities.concretes.City;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CityDaoHibernate implements CityDao {

    private EntityManager entityManager;

    @Autowired
    public CityDaoHibernate(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    @Transactional //aop yapısı
    public List<City> getAllCities() {
        Session session=this.entityManager.unwrap(Session.class);
        return session.createQuery("from City",City.class).getResultList();
    }

    @Override
    @Transactional
    public void add(City city) {
        Session session=this.entityManager.unwrap(Session.class);
        session.save(city);
    }

    @Override
    @Transactional
    public void update(City city) {
        Session session=this.entityManager.unwrap(Session.class);
        session.saveOrUpdate(city);
    }

    @Override
    @Transactional
    public void delete(City city) {
        Session session=this.entityManager.unwrap(Session.class);
        City deleteCity = session.get(City.class, city.getId());
        session.delete(deleteCity);
    }

    @Override
    public City getById(int id) {
        Session session=this.entityManager.unwrap(Session.class);
        return session.get(City.class,id);
    }

    @Override
    public List<City> getAllTurkCities() {
        Session session=this.entityManager.unwrap(Session.class);
        return session.createQuery("from City where countryCode = 'TUR'",City.class).getResultList();
    }
}
