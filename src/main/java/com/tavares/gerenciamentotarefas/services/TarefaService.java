package com.tavares.gerenciamentotarefas.services;

import com.tavares.gerenciamentotarefas.models.Tarefa;
import com.tavares.gerenciamentotarefas.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
    @Autowired
    private TarefaRepository repository;

    public Tarefa salvar(Tarefa tarefa){
        return repository.save(tarefa);
    }

    public List<Tarefa> listarTodos(){
        return repository.findAll();
    }

    public Optional<Tarefa> buscarPorId(Long id){
        return repository.findById(id);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
