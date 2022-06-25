package com.spring.hibernateAndJpa.business.abstracts;

import com.spring.hibernateAndJpa.entities.concretes.City;

import java.util.List;

public interface CityService {
    List<City> getAllCities();
    void add(City city);
    void update(City city);
    void delete(City city);
    City getById(int id);
}
