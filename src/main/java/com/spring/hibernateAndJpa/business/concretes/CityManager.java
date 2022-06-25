package com.spring.hibernateAndJpa.business.concretes;

import com.spring.hibernateAndJpa.business.abstracts.CityService;
import com.spring.hibernateAndJpa.dao.abstracts.CityDao;
import com.spring.hibernateAndJpa.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {

    private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao){
        this.cityDao=cityDao;
    }

    @Override
    public List<City> getAllCities() {
       return this.cityDao.getAllCities();
    }

    @Override
    public void add(City city) {
        this.cityDao.add(city);
    }

    @Override
    public void update(City city) {
        this.cityDao.update(city);
    }

    @Override
    public void delete(City city) {
        this.cityDao.delete(city);
    }

    @Override
    public City getById(int id) {
        return this.cityDao.getById(id);
    }

    @Override
    public List<City> getAllTurkCities() {
        return this.cityDao.getAllTurkCities();
    }
}