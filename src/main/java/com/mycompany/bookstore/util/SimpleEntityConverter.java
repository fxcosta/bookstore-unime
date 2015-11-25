/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bookstore.util;

import com.mycompany.bookstore.entity.BaseEntity;
import com.mycompany.bookstore.entity.BaseEntity2;
import com.mycompany.bookstore.entity.Category;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author fx3costa
 */
@FacesConverter("ccno")
public class SimpleEntityConverter implements Converter {  
  
    @Override
    public Object getAsObject(FacesContext ctx, UIComponent component, String value) {  
        if (value != null) {  
            return this.getAttributesFrom(component).get(value);  
        }  
        return null;  
    }  
  
    @Override
    public String getAsString(FacesContext ctx, UIComponent component, Object value) {  
  
        if (value != null  
                && !"".equals(value)) {  
  
            BaseEntity entity = (BaseEntity) value;  
  
            // adiciona item como atributo do componente  
            this.addAttribute(component, entity);  
  
            Serializable codigo = entity.getId();  
            if (codigo != null) {  
                return String.valueOf(codigo);  
            }  
        }  
  
        return (String) value;  
    }  
  
    protected void addAttribute(UIComponent component, BaseEntity o) {  
        String key = o.getId().toString(); // codigo da empresa como chave neste caso  
        this.getAttributesFrom(component).put(key, o);  
    }  
  
    protected Map<String, Object> getAttributesFrom(UIComponent component) {  
        return component.getAttributes();  
    }  
}  
