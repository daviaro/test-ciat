package com.daviaro.test.ciat.services;

import com.daviaro.test.ciat.implement.FilePartner;
import com.daviaro.test.ciat.model.Country;
import java.io.File;
import java.util.List;
import org.apache.struts2.ServletActionContext;

/**
 * Singlenton del servicio de Paises.
 * @author David Aroca. Created on 15/06/2017.
 */
public class CountryService {

    private static CountryService countryService;
    private List<Country> countries;

    /**
     * Construtor.
     * 
     */
    public CountryService() {
        String path = ServletActionContext.getServletContext().getRealPath(File.separator);
        System.out.println("PRUEBAS " + path);
        FilePartner storPart = new FilePartner();
        countries = storPart.getListCountries(path);
        System.out.println(" Pais " + countries.size());

    }

    private static class SingletonHelper {
        private static final CountryService countryService = new CountryService();
    }

    /**
     * Obtener una instancia de la clase.
     * @return retorna uninstancia clase CountryService.
     */
    public static CountryService getCountryService() {
        
        return SingletonHelper.countryService;
    }

    /**
     * metodo para obtener los paises.
     * @return the countries
     */
    public List<Country> getCountries() {
        return countries;
    }

    /**
     * actualizar listado de paises.
     * @param countries the countries to set
     */
    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
    
    

}
