package br.com.qeep.moving.gerencia.coruscant.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.qeep.moving.gerencia.coruscant.api.entity.*;


@Repository
public interface ServidorRepository extends CrudRepository<Servidor, Long> {

	//List<Servidor> findAllById(long idSecretaria);
	
	//List<Servidor> findAllByIdServidor(long idSecretaria);
	
	List<Servidor> findAllBySecretariaIdSecretaria(Long idSecretaria);

	@Query("select s from Servidor s where s.secretaria.idSecretaria = ?1")
	List<Servidor> findDoJoao(Long idSecretaria);
	
	Optional<Servidor> findByIdServidorAndSecretariaIdSecretaria(long idServidor, long idSecretaria);
	
	@Query("select sum(s.salario) from Servidor s where s.secretaria.idSecretaria = ?1")
	Double calculaFolhaPagamento(Long idSecretaria);
}
	

	