package com.unifcv.labore.controller;

import com.unifcv.labore.model.Medico;
import com.unifcv.labore.service.MedicoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
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
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/unifcv/medico")
@Api(value = "Labore+ API - Medico")
@CrossOrigin(origins = "*")
public class medicoController {
    
    @Autowired
    MedicoService medicoService;
    
    @GetMapping("/id/{id}")
    @ApiOperation(value="Retorna um Medico por ID.")
    public Medico findById(@PathVariable Integer id){
        return medicoService.procurarPorId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID Não Encontrado."));
    }
    
    @GetMapping("/nome/{nome}")
    @ApiOperation(value="Retorna um Medico por Nome.")
    public Medico findByNome(@PathVariable String nome){
        return medicoService.procurarPorNome(nome).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nome Não Encontrado."));
    }
    
    @GetMapping("/")
    @ApiOperation(value="retorna uma Lista de Medicos.")
    public List<Medico> findAll(){
        return medicoService.Listar();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value="Salva um Medico.")
    public Medico SaveMedico(@RequestBody @Valid Medico medico){
        return medicoService.salvar(medico);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Atualiza um Medico por ID.")
    public void updateMedico(@PathVariable Integer id, @RequestBody @Valid Medico medico){
        medicoService.atualizar(id, medico);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Deleta um Medico por ID.")
    public void deleteClinica(@PathVariable Integer id){
        medicoService.deletar(id);
    }
    
}