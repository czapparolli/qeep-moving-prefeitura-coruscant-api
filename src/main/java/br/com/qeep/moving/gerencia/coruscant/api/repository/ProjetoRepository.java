package br.com.qeep.moving.gerencia.coruscant.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.qeep.moving.gerencia.coruscant.api.entity.Projeto;

@Repository
public interface ProjetoRepository extends CrudRepository<Projeto, Long> {
	
	
	List<Projeto> findAllBySecretariaIdSecretaria(long idSecretaria);
	
	@Query("select sum(po.custo) from Projeto po where po.secretaria.idSecretaria = ?1")
	float calculaCustoPorProjeto(long idSecretaria);
	
	//@Query("UPDATE Projeto po SET po.custo = ?2 where po.secretaria.idSecretaria = ?1")
	//double aporteProjeto(long idSecretaria, double aumento);
	 
	
}
