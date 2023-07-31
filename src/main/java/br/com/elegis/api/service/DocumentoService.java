package br.com.elegis.api.service;

import java.util.List;
import java.util.Optional;

import br.com.elegis.api.model.entity.Documento;

public interface DocumentoService {
	
	
	public List<Documento> obterTodos(Documento documentoParamFiltro);
	
	public Optional<Documento> obterPorId(Integer id);
	
	public Documento salvar(Documento documento);
	
	public Documento atualizar(Documento documento);
	
	public void deletar(Documento documento);
	
}
