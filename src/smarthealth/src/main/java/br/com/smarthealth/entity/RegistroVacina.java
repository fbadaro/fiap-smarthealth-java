package br.com.smarthealth.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "HT06_REGVACIN")
public class RegistroVacina extends BaseEntity<Integer> {
	
	@Id
	@SequenceGenerator(name = "vacina_seq", sequenceName = "vacina_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vacina_seq")
	@Column(name = "rv_id", nullable = false)
	private Integer id;
	
	@Column(name = "rv_nome", length = 150, nullable = false)
	private String nome;
	
	@Column(name = "rv_data", nullable = false)
	private LocalDate data;
	
	@Column(name = "rv_vencimento")
	private LocalDate vencimento;
	
	@ManyToOne
	@JoinColumn(name = "mb_id", nullable = false)
	private Membro membro;
	
	public RegistroVacina() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegistroVacina(int id, String nome, LocalDate data, LocalDate vencimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.data = data;
		this.vencimento = vencimento;
	}
	
	public RegistroVacina(String nome, LocalDate data, LocalDate vencimento) {
		super();		
		this.nome = nome;
		this.data = data;
		this.vencimento = vencimento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalDate getVencimento() {
		return vencimento;
	}

	public void setVencimento(LocalDate vencimento) {
		this.vencimento = vencimento;
	}

	public Membro getMembro() {
		return membro;
	}

	public void setMembro(Membro membro) {
		this.membro = membro;
	}

	@Override
	public String toString() {
		return "RegistroVacina [id=" + id + ", nome=" + nome + ", data=" + data + ", vencimento=" + vencimento + "]";
	}
}
