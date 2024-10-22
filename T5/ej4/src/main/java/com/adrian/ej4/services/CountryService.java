package com.adrian.ej4.services;

import java.util.List;

import com.adrian.ej4.Country;

public interface CountryService {
    void loadCountriesFromFile();
    List<Country> getCountries();
    Country getCountry(String name);
}
