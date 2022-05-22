package com.unifcv.labore.controller;

import com.unifcv.labore.model.Paciente;
import com.unifcv.labore.service.PacienteService;
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
@RequestMapping("/unifcv/paciente")
@Api(value = "Labore+ API - Paciente")
@CrossOrigin(origins = "*")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna um Paciente por ID.")
    public Paciente findById(@PathVariable Integer id) {
        return pacienteService.procurarPorId(id);
    }

    @GetMapping("/nome/{nome}")
    @ApiOperation(value = "Retorna um Paciente por Nome.")
    public Paciente findByNome(@PathVariable String nome) {
        return pacienteService.procurarPorNome(nome);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Retorna uma Lista de Paciente.")
    public List<Paciente> findAll() {
        return pacienteService.listar();
    }

    @PostMapping
    @ApiOperation(value = "Salva um Paciente.")
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente savePaciente(@RequestBody Paciente paciente) {
        return pacienteService.salvar(paciente);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza um Paciente por ID.")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePaciente(@PathVariable Integer id, @RequestBody Paciente paciente) {
        pacienteService.atualizar(id, paciente);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta uma Paciente por ID.")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePaciente(@PathVariable Integer id) {
        pacienteService.deletar(id);
    }

}
