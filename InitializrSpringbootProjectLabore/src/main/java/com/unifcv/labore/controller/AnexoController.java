package com.unifcv.labore.controller;

import com.unifcv.labore.model.Anexo;
import com.unifcv.labore.service.AnexoService;
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
@RequestMapping("/unifcv/anexo")
@Api(value = "Labore+ API - Anexo")
@CrossOrigin(origins = "*")
public class AnexoController {

    @Autowired
    private AnexoService anexoService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna um Anexo por ID.")
    public Anexo findById(@PathVariable Integer id) {
        return anexoService.procurarPorId(id);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Retorna uma Lista de Anexo.")
    public List<Anexo> findAll() {
        return anexoService.listar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Salva um Anexo.")
    public Anexo SaveClinica(@RequestBody Anexo anexo) {
        return anexoService.salvar(anexo);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza um Anexo por ID.")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAnexo(@PathVariable Integer id, @RequestBody Anexo anexo) {
        anexoService.atualizar(id, anexo);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta uma Anexo por ID.")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAnexo(@PathVariable Integer id) {
        anexoService.deletar(id);
    }

}
