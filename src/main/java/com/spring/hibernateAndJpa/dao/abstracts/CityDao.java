package com.spring.hibernateAndJpa.dao.abstracts;

import com.spring.hibernateAndJpa.entities.concretes.City;

import java.util.List;


public interface CityDao {

    List<City> getAllCities();
    void add(City city);
    void update(City city);
    void delete(City city);
    City getById(int id);
    List<City> getAllTurkCities();
}