package br.com.smarthealth.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "HT09_ESPECIALI")
public class Especialidade extends BaseEntity<Integer> {
	
	@Id
	@SequenceGenerator(name = "especialidade_seq", sequenceName = "especialidade_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "especialidade_seq")
	@Column(name = "es_id", nullable = false)
	private Integer id;
	
	@Column(name = "es_tipo", length = 150, nullable = false)
	private String tipo;
	
	public Especialidade() {
		super();
	}

	public Especialidade(Integer id, String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}
	
	public Especialidade(String tipo) {
		super();
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@ManyToMany(mappedBy = "especialidades")
	private List<Medico> medicos;

	@Override
	public String toString() {
		return "Especialidade [id=" + id + ", tipo=" + tipo + "]";
	}
}
