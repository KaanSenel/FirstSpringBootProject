package com.spring.hibernateAndJpa.api;

import com.spring.hibernateAndJpa.business.abstracts.CityService;
import com.spring.hibernateAndJpa.entities.concretes.City;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CityController {

    private CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/getallcities")
    public List<City> getAll(){
        return this.cityService.getAllCities();
    }

    @PostMapping("/add")
    public void add(@RequestBody City city){
        this.cityService.add(city);
    }

    @PostMapping("/update")
    public void update(@RequestBody City city){
        this.cityService.update(city);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody City city){
        this.cityService.delete(city);
    }

    @GetMapping("/getcity/{id}")
    public City getById(@PathVariable int id){
        return this.cityService.getById(id);
    }
}