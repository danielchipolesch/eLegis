package br.com.elegis.api.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="t_documento", schema="exemplo")

public class Documento {
	
	@Id
	@Column(name="cd_documento")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nm_documento", nullable = false)
	private String nomeDocumento;
	
	@Column(name="cd_tipo_documento", nullable = false)
	private String tipoDocumento;
	
	@Column(name="nr_tipo_documento", nullable = false)
	private Integer numeroTipoDocumento;
	

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

	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

}
