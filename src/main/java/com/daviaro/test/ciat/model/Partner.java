package com.daviaro.test.ciat.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author David Aroca. 
 *         Created on 23/06/2017
 */
public class Partner implements Serializable {

    private String headQuarter;
    private String acronym;
    private String name;
    private Type type;
    private Country country;
    private String city;

    public Partner() {
    }

    /**
     * Constructor con parametros.
     * @param headQuarter codigo headQuarter. Si el campo es vacio es un headquarter,
     *        sino es un branch.
     * @param acronym almacena el acronym.
     * @param name almacena el nombre
     * @param type almacena el tipo de institucion
     * @param country almacena el pais.
     * @param city almacena la ciudad.
     */
    public Partner(String headQuarter, String acronym,
            String name, Type type, Country country,
            String city) {

        this.headQuarter = headQuarter;
        this.acronym = acronym;
        this.name = name;
        this.type = type;
        this.country = country;
        this.city = city;

    }

    /**
     * Este metodo retorna el HeadQuarter.
     * @return the headQuarter.
     */
    public String getHeadQuarter() {
        return headQuarter;
    }

    /**
     * Actualiza el campo si o no es HeadQuarter.
     * @param headQuarter the isHeadQuarter to set.
     */
    public void setHeadQuarter(String headQuarter) {
        this.headQuarter = headQuarter;
    }

    /**
     * Retorna el acronimo de la headquater.
     * @return the acronym.
     */
    public String getAcronym() {
        return acronym;
    }

    /**
     * Actualiza el acronimo de la headquarter.
     * @param acronym the acronym to set.
     */
    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    /**
     * Este metodo retorna el nombre de la headquarter.
     * @return the name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * este metodo retonar el tipo de institucion.
     * @return the typeInst.
     */
    public Type getType() {
        return type;
    }

    /**
     * @param type the typeInst to set.
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * Este metodo retonar el pais.
     * @return the country.
     */
    public Country getCountry() {
        return country;
    }

    /**
     * @param country the country to set.
     */
    public void setCountry(Country country) {
        this.country = country;
    }

    /**
     * este metodo retonar la ciudad.
     * @return the city.
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Recorta el hashcode.
     * @return int hascode. 
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.acronym);
        return hash;
    }

    /**
     * Compara dos objetos de tipo Partner. true or false.
     * @param obj recibe como parametro un objeto partner.
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Partner other = (Partner) obj;
        return Objects.equals(this.acronym, other.acronym);
    }
    
    
}
