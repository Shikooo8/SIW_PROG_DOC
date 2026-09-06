package it.uniroma3.siw_festival.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice 
public class GlobalBindingConfig {

    @InitBinder 
    public void InitBinder (WebDataBinder binder){
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

}
