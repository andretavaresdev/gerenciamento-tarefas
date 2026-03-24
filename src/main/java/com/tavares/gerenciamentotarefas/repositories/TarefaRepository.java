package com.tavares.gerenciamentotarefas.repositories;

import com.tavares.gerenciamentotarefas.models.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {}
