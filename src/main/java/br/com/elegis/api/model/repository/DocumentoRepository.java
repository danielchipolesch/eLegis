package br.com.elegis.api.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.elegis.api.model.entity.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Integer>{

}
