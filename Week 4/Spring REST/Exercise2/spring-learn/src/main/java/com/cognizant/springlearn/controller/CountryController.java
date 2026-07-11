package com.cognizant.springlearn.controller;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.cognizant.springlearn.model.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.springlearn.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@RestController
public class CountryController {
    @Autowired
    private CountryService countryService;
    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {

        return countryService.getCountry(code);

    }
    @GetMapping("/countries")
    public List<Country> getAllCountries() {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        return context.getBean("countryList", List.class);
    }
    @RequestMapping("/country")
    public Country getCountryIndia() {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        Country country = context.getBean("country", Country.class);

        return country;
    }
}