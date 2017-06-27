package com.daviaro.test.ciat.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author David Aroca.
 *         Created on 24/06/2017
 */

public class Type implements Serializable {
    
    private String code;
    private String descripcion;

    /**
     * Constructor sin parametros.
     */
    public Type() {
        
    }
    
    /**
     * construtor de tipos.
     * @param code codigo del tipo.
     * @param descripcion  del tipo.
     */
    public Type(String code, String descripcion) {
        this.code = code;
        this.descripcion = descripcion;
    }

    /**
     * Obtener el codigo.
     * @return the code en string.
     */
    public String getCode() {
        return code;
    }

    /**
     * Actulizar el codigo del tipo.
     * @param code the code to set.
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Obtener la descripcion.
     * @return the descripcion.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Actualizar la descripcion.
     * @param descripcion the descripcion to set.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.code);
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
        final Type other = (Type) obj;
        return Objects.equals(this.code, other.code);
    }
    
    
}