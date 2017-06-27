package com.daviaro.test.ciat.actions.data;

import com.daviaro.test.ciat.model.Partner;
import com.daviaro.test.ciat.services.PartnerService;
import com.opensymphony.xwork2.ModelDriven;
import java.util.Collection;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import org.apache.struts2.rest.RestActionSupport;

/**
 * Servicio en rest para listar las instituciones
 * @author David Aroca.
 *         Created on 23/06/2017.
 */
public class PartnerController extends RestActionSupport implements ModelDriven<Object> {

    private Partner model = new Partner();
    private String id;
    private Collection<Partner> list = null;
    private PartnerService partnerService;

    // GET /data/partner/1
    public HttpHeaders show() {
        return new DefaultHttpHeaders("show");
    }

    
    /**
     * metodo index retorna la lista de partners.
     * @return httpheaders.
     */
    // GET /data/partner
    @Override
    public HttpHeaders index() {
        partnerService = PartnerService.getPartnerService();
        list = partnerService.getPartners();
        return new DefaultHttpHeaders("index")
            .disableCaching();
    }

    
    /**
     * Elimina un registo de la lista.
     * @return string.
     */
    // DELETE /data/partner/1
    public String destroy() {
        //log.debug("Delete order with id: {}", id);

        // To demonstrate exception handling we throw an exception when someone tries to delete an order
        if ( id != null ) {
            throw new RuntimeException(getText("exception.operation.not.supported"));
        }
        

        //ordersService.remove(id);
        return "success";
    }

    /**
     * Crear un nuevo partner.
     * @return  httpHeadders.
     */
    // POST /data/partner
    public HttpHeaders create() {
        //log.debug("Create new order: {}", model);
        //ordersService.save(model);
        return new DefaultHttpHeaders("success")
            .setLocationId(model.getAcronym());
    }

    /**
     * Actualiza un registro en el archivo.
     * @return string.
     */
    // PUT /data/order/1
    public String update() {
        //log.debug("Update order: {}", model);
        //ordersService.save(model);
        return "success";
    }

    /**
     * obtener partner por id.
     * @param id del partner. 
     */
     
    public void setId(String id) {
        if ( id != null ) {
          //  this.model = ordersService.get(id);
        }
        this.id = id;
    }
    
   
    
    
    @Override
    public Object getModel() {
        if ( list != null ) {
            return list;
        } else {
            if ( model == null ) {
                model = new Partner();
            }
            return model;
        }
    }
    
}
