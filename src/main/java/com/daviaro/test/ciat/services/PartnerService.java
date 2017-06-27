package com.daviaro.test.ciat.services;

import com.daviaro.test.ciat.implement.FilePartner;
import com.daviaro.test.ciat.model.Country;
import com.daviaro.test.ciat.model.Partner;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author David Aroca. Created on 24/06/2017.
 */
public class PartnerService {

    private List<Partner> partners;

    /**
     * Constructor.
     */
    public PartnerService() {
        String path = ServletActionContext.getServletContext().getRealPath(File.separator);
        FilePartner storPart = new FilePartner();
        partners = storPart.getListPartner(path);
    }

    private static class SingletonHelper {

        private static final PartnerService partnerService = new PartnerService();

    }

    /**
     * Obtener una instancia de la clase.
     *
     * @return retorna uninstancia clase PartnerService.
     */
    public static PartnerService getPartnerService() {

        return SingletonHelper.partnerService;
    }

    /**
     * Obtener partners.
     *
     * @return the partners
     */
    public List<Partner> getPartners() {
        return partners;
    }

    /**
     * Actualizar las lista de partners.
     *
     * @param partners the partners to set
     */
    public void setPartners(List<Partner> partners) {
        this.partners = partners;
    }
    
    public List<Partner> getHeadquarters() {
        return this.partners.stream().filter(p ->  p.getHeadQuarter().equals("YES")).collect(Collectors.toList()); 
    }

}
