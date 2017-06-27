package com.daviaro.test.ciat.services;

import com.daviaro.test.ciat.implement.FilePartner;
import com.daviaro.test.ciat.model.Type;
import java.io.File;
import java.util.List;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author David Aroca. 
 *         Created on 24/06/2017.
 */
public class TypeService {

    private List<Type> types;

    /**
     * Constructor.
     */
    public TypeService() {
        String path = ServletActionContext.getServletContext().getRealPath(File.separator);
        FilePartner storPart = new FilePartner();
        types = storPart.getListTypes(path);
    }

    private static class SingletonHelper {

        private static final TypeService typeService = new TypeService();

    }

    /**
     * Obtener una instancia de la clase.
     *
     * @return retorna uninstancia clase TypeService.
     */
    public static TypeService getTypeService() {

        return SingletonHelper.typeService;
    }

    /**
     * Obtener partners.
     *
     * @return the partners
     */
    public List<Type> getTypes() {
        return types;
    }

    /**
     * Actualizar las lista de types.
     *
     * @param types the types to set
     */
    public void setTypes(List<Type> types) {
        this.types = types;
    }
}
