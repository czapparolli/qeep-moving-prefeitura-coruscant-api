package br.com.qeep.moving.gerencia.coruscant.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.qeep.moving.gerencia.coruscant.api.dto.CriaSecretariaDTO;
import br.com.qeep.moving.gerencia.coruscant.api.entity.Secretaria;
import br.com.qeep.moving.gerencia.coruscant.api.enums.Pasta;

@Repository
public interface SecretariaRepository extends CrudRepository<Secretaria, Long> {
	
	@Query("select sum (se.salario) from Servidor se ")
	float calculaSalario();
	
	Secretaria findFirstByPasta(Pasta pasta);
	
	Secretaria save(CriaSecretariaDTO cria);
}
	 


