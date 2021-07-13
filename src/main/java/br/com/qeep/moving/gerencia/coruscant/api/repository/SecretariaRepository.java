package br.com.qeep.moving.gerencia.coruscant.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.qeep.moving.gerencia.coruscant.api.entity.Secretaria;


@Repository
public interface SecretariaRepository extends CrudRepository<Secretaria, Long> {
	
}
