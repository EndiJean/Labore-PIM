package com.unifcv.labore.controller;

import com.unifcv.labore.model.Geral;
import com.unifcv.labore.service.GeralService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unifcv/geral")
@Api(value = "Labore+ API - Geral")
@CrossOrigin(origins = "*")
public class GeralController {

    @Autowired
    GeralService geralService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna um Geral por ID.")
    public Geral findById(@PathVariable Integer id) {
        return geralService.ProcurarPorId(id);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Retorna uma Lista de Geral.")
    public List<Geral> findAll() {
        return geralService.listar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Salva uma Geral.")
    public Geral saveGeral(@RequestBody Geral geral) {
        return geralService.salvar(geral);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Atualiza um Geral por ID.")
    public void UpdateGeral(@PathVariable Integer id, @RequestBody Geral geral) {
        geralService.atualizar(id, geral);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Deleta um Geral por ID.")
    public void DeleteGeral(@PathVariable Integer id) {
        geralService.deletar(id);
    }
}
