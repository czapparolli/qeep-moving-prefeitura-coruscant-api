package br.com.qeep.moving.gerencia.coruscant.api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.qeep.moving.gerencia.coruscant.api.entity.*;


@Repository
public interface ServidorRepository extends CrudRepository<Servidor, Long> {

	//List<Servidor> findAllById(long idSecretaria);
	
	//List<Servidor> findAllByIdServidor(long idSecretaria);
}
	