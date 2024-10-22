package com.adrian.ej4.services;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.adrian.ej4.Country;

@Service
public class CountryServiceImpl implements CountryService {
    private HashMap<String, Country> countries = new HashMap<>();

    @Override
    public void loadCountriesFromFile() {
        try {
            List<String> countriesData = Files.readAllLines(Path.of("paises.csv"), Charset.forName("UTF-8"));
            for (String country : countriesData) {
                String[] countryData = country.split(";");
                countries.put(countryData[0], new Country(countryData[0], countryData[1], countryData[2]));
            }
        } catch (IOException ioe) {
            return;
        }
    }

    @Override
    public List<Country> getCountries() {
        return new ArrayList<Country>(countries.values());
    }

    @Override
    public Country getCountry(String name) {
        return countries.get(name);
    }    
}
