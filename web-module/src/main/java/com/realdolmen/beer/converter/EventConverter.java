package com.realdolmen.beer.converter;

import com.realdolmen.beer.domain.Evenement;
import com.realdolmen.beer.domain.Verkoop;
import com.realdolmen.beer.persistence.VerkoopEJB;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class EventConverter implements Converter {
    @Inject
    private VerkoopEJB verkoopEJB;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null)
            return null;

        int id = Integer.parseInt(value);
        return verkoopEJB.findEventByID(id);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null)
            return null;

        Evenement evenement = (Evenement)value;
        return String.valueOf(evenement.getId());
    }
}
