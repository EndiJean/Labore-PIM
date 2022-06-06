package com.unifcv.labore.controller;

import com.unifcv.labore.model.Exame;
import com.unifcv.labore.service.ExameService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unifcv/exame")
@Api(value = "Labore+ API - Exame")
@CrossOrigin(origins = "*")
public class ExameController {

    @Autowired
    ExameService exameService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna um Exame por ID.")
    public Exame findById(@PathVariable Integer id) {
        return exameService.procurarPorId(id);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Retorna uma Lista de Exame.")
    public List<Exame> findAll() {
        return exameService.listar();
    }
    
    @GetMapping("/filter")
    @ApiOperation(value = "Retorna uma Lista de Exame com filtro em Tipo de Exame.")
    public List<Exame> findByLikeTipoExame(@RequestParam("tipoExame") String tipoExame) {
        return exameService.ListarTipoExameLike(tipoExame);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Salva um Exame.")
    public Exame SaveExame(@RequestBody Exame exame) {
        return exameService.salvar(exame);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Atualiza um Exame por ID.")
    public void UpdateExame(@PathVariable Integer id, @RequestBody Exame exame) {
        exameService.atualizar(id, exame);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Deleta um Exame por ID.")
    public void DeleteExame(@PathVariable Integer id) {
        exameService.deletar(id);
    }

}
