package br.com.smarthealth.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "HT10_SEXO")
public class Sexo extends BaseEntity<Integer> {
	
	@Id
	@SequenceGenerator(name = "sexo_seq", sequenceName = "sexo_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sexo_seq")
	@Column(name = "sx_id", nullable = false)
	private Integer id;
	
	@Column(name = "sx_identificacao", length = 50, nullable = false)
	private String identificacao;
	
	@OneToMany(mappedBy = "sexo")
	private List<Membro> membros;
	
	public Sexo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sexo(int id, String identificacao) {
		super();
		this.id = id;
		this.identificacao = identificacao;
	}
	
	public Sexo(String identificacao) {
		super();		
		this.identificacao = identificacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	public List<Membro> getMembros() {
		return membros;
	}

	public void setMembros(List<Membro> membros) {
		this.membros = membros;
	}

	@Override
	public String toString() {
		return "Sexo [id=" + id + ", identificacao=" + identificacao + "]";
	}
}
