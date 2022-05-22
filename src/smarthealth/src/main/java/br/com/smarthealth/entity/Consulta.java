package br.com.smarthealth.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "R09_HT02_HT04")
@IdClass(ConsultaId.class)
public class Consulta extends BaseEntity<Integer> implements Serializable {
	
	@Id
	@JoinColumn(name = "familia_fm_id")
	@ManyToOne(optional = false)
	private Familia familia;
	
	@Id
	@JoinColumn(name = "medico_md_id")
	@ManyToOne(optional = false)
	private Medico medico;	
	
	public Consulta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Consulta(Familia familia, Medico medico, boolean realizada, LocalDate dtNascimento) {
		super();
		this.familia = familia;
		this.medico = medico;
		this.realizada = realizada;
		this.dtNascimento = dtNascimento;
	}

	@Column(name = "tc_realizada")
	private boolean realizada;
	
	@Column(name = "tc_data")
	private LocalDate dtNascimento;
	
	public Integer getId() {
		return familia.getId();
	}
}
