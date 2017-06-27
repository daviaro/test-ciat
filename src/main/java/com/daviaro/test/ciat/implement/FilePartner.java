package com.daviaro.test.ciat.implement;

import com.daviaro.test.ciat.model.Country;
import com.daviaro.test.ciat.model.Partner;
import com.daviaro.test.ciat.model.Type;
import com.daviaro.test.ciat.services.CountryService;
import com.daviaro.test.ciat.services.TypeService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Se implementa la clase para obtener los datos de un archivo plano.
 *
 * @author David Aroca. Created on 23/07/2017
 */
public class FilePartner {

    /**
     * obtener los partners de un archivo de texto.
     *
     * @param path ruta en el contexto.
     * @return lista de partners.
     */
    public List<Partner> getListPartner(String path) {
        List<Partner> partners = new ArrayList<>();
        CountryService countryService = null;
        TypeService typeService = null;
        List<Country> countries = null;
        List<Type> types = null;
        Type type =  null;
        Partner partner = null;
        Country country = null;
        String[] datos = null;
        
        try {
            countryService = CountryService.getCountryService();
            countries = countryService.getCountries();
            typeService = TypeService.getTypeService();
            types =  typeService.getTypes();
            
            
            
            
            List<String> lineas = Files.readAllLines(Paths.get(path
                    + File.separator + "storage" + File.separator + "partners.txt"));

            for (String dato:lineas) {
                datos = dato.split("[|]");
                partner = new Partner();
                type = new Type();
                country = new Country();
                partner.setHeadQuarter(datos[0] != null && !datos[0].equals("") ? "NO" : "YES");
                partner.setAcronym(datos[1]);
                partner.setName(datos[2]);
                type.setCode(datos[3]);
                type = types.get(types.indexOf(type));
                partner.setType(type);
                country.setCode(datos[4]);
                country = countries.get(countries.indexOf(country));
                partner.setCountry(country);
                partner.setCity(datos[5]);
                partners.add(partner);
            } 
        } catch (IOException ex) {
            Logger.getLogger(FilePartner.class.getName()).log(Level.SEVERE, null, ex);
        }

        return partners;
    }

    /**
     * obtener los partners de un archivo de texto.
     *
     * @param path ruta en el contexto.
     * @return lista de paises.
     */
    public List<Country> getListCountries(String path) {
        List<Country> countries = new ArrayList<>();
        try {
            List<String> lineas = Files.readAllLines(Paths.get(path
                    + File.separator + "storage" + File.separator + "countries.txt"));

            lineas.forEach((dato) -> {
                String[] datos = dato.split("[,]");
                Country country = new Country(datos[1], datos[0]);
                countries.add(country);

            }); //To change body of generated methods, choose Tools | Templates.
        } catch (IOException ex) {
            Logger.getLogger(FilePartner.class.getName()).log(Level.SEVERE, null, ex);
        }

        return countries;
    }

    /**
     * obtener los tipos de un archivo de texto.
     *
     * @param path ruta en el contexto.
     * @return lista de tipos.
     */

    public List<Type> getListTypes(String path) {
        List<Type> types = new ArrayList<>();
        try {
            List<String> lineas = Files.readAllLines(Paths.get(path
                    + File.separator + "storage" + File.separator + "types.txt"));

            lineas.forEach((dato) -> {
                String[] datos = dato.split("[,]");
                Type type = new Type(datos[0], datos[1]);
                types.add(type);

            }); //To change body of generated methods, choose Tools | Templates.
        } catch (IOException ex) {
            Logger.getLogger(FilePartner.class.getName()).log(Level.SEVERE, null, ex);
        }

        return types;
    }

}
