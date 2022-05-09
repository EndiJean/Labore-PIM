package com.unifcv.labore.controller;

import com.unifcv.labore.model.Paciente;
import com.unifcv.labore.service.PacienteService;
import io.swagger.annotations.Api;
import java.util.List;
import java.util.Optional;
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
@RequestMapping("/unifcv/paciente")
@Api(value = "Labore+ API - Paciente")
@CrossOrigin(origins = "*")
public class PacienteController {
    
    @Autowired
    PacienteService pacienteService;
    
    @GetMapping("/id/{id}")
    public Paciente findById(@PathVariable Integer id){
        return pacienteService.procurarPorId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID Não Encontrado."));
    }
    
    @GetMapping("/nome/{nome}")
    public Paciente findByNome(@PathVariable String nome){
        return pacienteService.procurarPorNome(nome).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nome Não Encontrado."));
    }
    
    @GetMapping("/")
    public List<Paciente> findAll(){
        return pacienteService.listar();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente savePaciente (@RequestBody Paciente paciente){
        return pacienteService.salvar(paciente);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePaciente(@PathVariable Integer id, @RequestBody Paciente paciente){
        pacienteService.atualizar(id, paciente);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePaciente(@PathVariable Integer id){
        pacienteService.deletar(id);
    }
    
}
