package br.com.elegis.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.elegis.api.dto.DocumentoDTO;
import br.com.elegis.api.ExceptionHandler.RegraNegocioException;
import br.com.elegis.api.model.entity.Documento;
import br.com.elegis.api.service.DocumentoService;

@RestController
@RequestMapping("/api/v1/documentos")
public class DocumentoController {
	
	DocumentoService service;
	
	public DocumentoController(DocumentoService service) {
		this.service = service;
	}
	
	/**
	 * Método auxiliar para converter ObjetoDTO em uma entidade
	 * @param dto
	 * @return
	 */
	private Documento converter(DocumentoDTO dto) {
		Documento documento = new Documento();
		
		documento.setNomeDocumento(dto.getNomeDocumento());
		documento.setTipoDocumento(dto.getTipoDocumento());
		documento.setNumeroTipoDocumento(dto.getNumeroTipoDocumento());
		
		return documento;
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<Object> buscar(
			@RequestParam(value="nomeDocumento", required=false) String nomeDocumento,
			@RequestParam(value="tipoDocumento", required=false) String tipoDocumento,
			@RequestParam(value="numeroTipoDocumento", required=false) Integer numeroTipoDocumento
			) {
		Documento documentoFiltro = new Documento();
		documentoFiltro.setNomeDocumento(nomeDocumento);
		documentoFiltro.setTipoDocumento(tipoDocumento);
		documentoFiltro.setNumeroTipoDocumento(numeroTipoDocumento);
		List<Documento> documentos = service.obterTodos(documentoFiltro);
		return ResponseEntity.ok(documentos);
	}

	@PostMapping("/salvar")
	public ResponseEntity<Object> salvar(@RequestBody DocumentoDTO dto) {
		
		try {
			Documento entidadeDocumento = converter(dto);
			
			entidadeDocumento = service.salvar(entidadeDocumento);
			return ResponseEntity.ok(entidadeDocumento);
			
		} catch (RegraNegocioException regraNegocioException) {
			return ResponseEntity.badRequest().body(regraNegocioException.getMessage());
		}
		
	}
	

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<? extends Object> atualizar(@PathVariable("id") Integer id, @RequestBody DocumentoDTO dto) {
		return service.obterPorId(id).map(entity -> {
			try {
				Documento documento = converter(dto);
				documento.setId(entity.getId());
				service.atualizar(documento);
				return ResponseEntity.ok(documento);
			} catch (RegraNegocioException regraNegocioException) {
				return ResponseEntity.badRequest().body(regraNegocioException.getMessage());
			}
		}).orElseGet(() -> ResponseEntity.badRequest().body("O documento não foi encontrado na base de dados"));
	}
	
	@DeleteMapping("/deletar/{id}")
	public Optional<Object> deletar(@PathVariable("id") Integer id) {
		return service.obterPorId(id).map(entity -> {
			service.deletar(entity);
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		});
	}
}
