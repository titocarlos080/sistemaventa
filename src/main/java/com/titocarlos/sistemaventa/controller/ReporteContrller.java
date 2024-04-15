package com.titocarlos.sistemaventa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
 

@Controller
public class ReporteContrller {
    
    @GetMapping("/reportes/all")
    public String reportes( ) {
        return "reportes";
    }
    
}
