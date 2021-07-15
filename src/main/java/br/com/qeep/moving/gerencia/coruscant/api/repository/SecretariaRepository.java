package br.com.qeep.moving.gerencia.coruscant.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.qeep.moving.gerencia.coruscant.api.entity.Secretaria;

@Repository
public interface SecretariaRepository extends CrudRepository<Secretaria, Long> {
	
	@Query("select sum (se.salario) from Servidor se ")
	float calculaSalario();
	
	
	 
}

