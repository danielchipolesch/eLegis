package br.com.elegis.api.dto;

public class DocumentoDTO {

	private Integer id;
	
	private String nomeDocumento;
	
	private String tipoDocumento;
	
	private Integer numeroTipoDocumento;
	
	
	public DocumentoDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNomeDocumento() {
		return nomeDocumento;
	}
	
	public void setNomeDocumento(String nomeDocumento) {
		this.nomeDocumento = nomeDocumento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Integer getNumeroTipoDocumento() {
		return numeroTipoDocumento;
	}

	public void setNumeroTipoDocumento(Integer numeroTipoDocumento) {
		this.numeroTipoDocumento = numeroTipoDocumento;
	}

			
}
