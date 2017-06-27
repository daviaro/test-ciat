package com.daviaro.test.ciat.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author David Aroca.
 *         Created on 24/06/2017
 */
public class Country implements Serializable {
    
    
    private String code;
    private String descripcion;

    /**
     * Constructor.
     */
    public Country() {
        
    }
    
    /**
     * Constructor.
     * @param code codigo del  pais.
     * @param descripcion  descripicion del pais.
     */
    public Country(String code, String descripcion) {
        this.code = code;
        this.descripcion = descripcion;
    }

    /**
     * obtener codigo del pais.
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Actualizar codigo del pais.
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * obtener la descripcion del pais.
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * actualizar la descripcion del pais.
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.code);
        return hash;
    }

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
        final Country other = (Country) obj;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        return true;
    }
    
    
    
}
