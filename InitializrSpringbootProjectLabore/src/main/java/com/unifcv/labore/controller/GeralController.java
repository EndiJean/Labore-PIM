package com.unifcv.labore.controller;

import com.unifcv.labore.model.Geral;
import com.unifcv.labore.service.GeralService;
import io.swagger.annotations.Api;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/unifcv/geral")
@Api(value = "Labore+ API - Geral")
@CrossOrigin(origins = "*")
public class GeralController {
    
    @Autowired
    GeralService geralService;
    
    @GetMapping("/{id}")
    public Geral findById(@PathVariable Integer id){
        return geralService.ProcurarPorId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID Não Encontrado."));
    }
    
    @GetMapping("")
    public List<Geral> findAll(){
        return geralService.listar();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Geral saveGeral (@RequestBody Geral geral){
        return geralService.salvar(geral);
    }
}
