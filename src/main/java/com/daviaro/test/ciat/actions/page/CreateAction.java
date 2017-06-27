package com.daviaro.test.ciat.actions.page;

import com.daviaro.test.ciat.model.Country;
import com.daviaro.test.ciat.model.Partner;
import com.daviaro.test.ciat.model.Type;
import com.daviaro.test.ciat.services.CountryService;
import com.daviaro.test.ciat.services.PartnerService;
import com.daviaro.test.ciat.services.TypeService;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 * Clase para manejar la creacion de instituciones.
 *
 * @author David Aroca. create on 24/06/2017.
 *
 */
public class CreateAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    private List<Country> countries;
    private Partner partner;
    private CountryService countryService;
    private PartnerService partnerService;
    private TypeService typeService;

    /**
     * Obtener el listado de paises.
     *
     * @return List Country.
     */
    public List<Country> getCountries() {
        countryService = CountryService.getCountryService();
        return countryService.getCountries();
    }
    
    /**
     * obtener lista de Headquarters.
     * @return listado de partner.
     */
    public List<Partner> getHeadquarters() {
        partnerService = PartnerService.getPartnerService();
        return partnerService.getHeadquarters();
    }
    
    /**
     * obtener lista de Headquarters.
     * @return listado de partner.
     */
    public List<Type> getTypes() {
        typeService = TypeService.getTypeService();
        return typeService.getTypes();
    }

    /**
     * actualizar el bean de persona.
     * @return String.
     * @throws Exception captura excepcion que suceda generando la informacion para la pagina.
     */
    @Override
    public String input() throws Exception {
        setPartner(new Partner());
        return INPUT;
    }
    
    /**
     * metodo index.
     * @return una cadena.
     */
    public String index() {
        return SUCCESS;
    }

    /**
     * obtener el partner.
     * @return the partner
     */
    public Partner getPartner() {
        return partner;
    }

    /**
     * actualizar el partner.
     * @param partner the partner to set
     */
    public void setPartner(Partner partner) {
        this.partner = partner;
    }

}
