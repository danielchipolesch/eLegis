package br.com.elegis.api.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name="t_documento", schema="documento")

public class Documento {
	
	@Id
	@Column(name="cd_documento")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nm_orgao", nullable = false)
	private String nomeOrgao;

	@OneToMany(mappedBy = "cd_especie")
	private Long especieDocumento;

	@OneToMany(mappedBy = "cd_assunto_basico")
	private Long assuntoBasico;

	@Column(name="nm_titulo_documento", nullable = false)
	private String nomeTituloDocumento;

	@Column(name = "nr_secundario_assunto")
	private String numeroSecundarioAssunto;

}
