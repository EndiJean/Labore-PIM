package com.unifcv.labore.controller;

import com.unifcv.labore.model.Geral;
import com.unifcv.labore.service.GeralService;
import io.swagger.annotations.Api;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unifcv/Geral")
@Api(value = "Labore+ API - Geral")
@CrossOrigin(origins = "*")
public class GeralController {
    
    @Autowired
    GeralService geralService;
    
    /*
    @GetMapping("/")
    public Optional<Geral> FindAll(@PathVariable Integer id){
        return geralService.listar(id);
    }
    */
}
