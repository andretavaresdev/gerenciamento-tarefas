package com.tavares.gerenciamentotarefas.controllers;

import com.tavares.gerenciamentotarefas.models.Tarefa;
import com.tavares.gerenciamentotarefas.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    @Autowired
    private TarefaService service;

    @PostMapping
    public ResponseEntity<Tarefa> salvar(@RequestBody Tarefa tarefa){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(tarefa));
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTodos(){
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public ResponseEntity<Tarefa> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
