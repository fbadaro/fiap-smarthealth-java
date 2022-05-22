package br.com.smarthealth.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "HT03_AGSAUDE")
public class AgenteSaude extends BaseEntity<Integer> {
	
	@Id
	@SequenceGenerator(name = "agente_seq", sequenceName = "agente_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agente_seq")
	@Column(name = "ag_id", nullable = false)
	private Integer id;
	
	@Column(name = "ag_nome", length = 150, nullable = false)
	private String nome;
	
	@Column(name = "ag_cpf", length = 11, nullable = false)
	private String cpf;
	
	@Column(name = "ag_cpf_emissor", length = 5, nullable = false)
	private String cpfEmissor;
	
	@Column(name = "ag_cpf_uf", length = 2, nullable = false)
	private String cpfUf;
	
	@Column(name = "ag_telefone", length = 14, nullable = false)
	private String telefone;
	
	@Column(name = "ag_nascimento",  nullable = false)
	private LocalDate dtNascimento;
	
	@Column(name = "ag_cns", length = 15, nullable = false)
	private String cns;
	
	@ManyToOne
	@JoinColumn(name = "ps_id", nullable = false)
	private PostoSaude postoSaude;
	
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "agsaude_ag_id"),
	inverseJoinColumns = @JoinColumn(name = "familia_fm_id"), name = "R03_HT03_HT04")
	private List<Familia> familias;
		
	public AgenteSaude() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AgenteSaude(int id, String nome, String cpf, String cpfEmissor, String cpfUf, String telefone, LocalDate dtNascimento, 
			String cns, PostoSaude postoSaude) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.cpfEmissor = cpfEmissor;
		this.cpfUf = cpfUf;
		this.telefone = telefone;
		this.dtNascimento = dtNascimento;
		this.cns = cns;
		this.postoSaude = postoSaude;		
	}
	
	public AgenteSaude(String nome, String cpf, String cpfEmissor, String cpfUf, String telefone, LocalDate dtNascimento, 
			String cns, PostoSaude postoSaude) {
		super();		
		this.nome = nome;
		this.cpf = cpf;
		this.cpfEmissor = cpfEmissor;
		this.cpfUf = cpfUf;
		this.telefone = telefone;
		this.dtNascimento = dtNascimento;
		this.cns = cns;
		this.postoSaude = postoSaude;		
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCpfEmissor() {
		return cpfEmissor;
	}

	public void setCpfEmissor(String cpfEmissor) {
		this.cpfEmissor = cpfEmissor;
	}

	public String getCpfUf() {
		return cpfUf;
	}

	public void setCpfUf(String cpfUf) {
		this.cpfUf = cpfUf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getCns() {
		return cns;
	}

	public void setCns(String cns) {
		this.cns = cns;
	}

	public PostoSaude getPostoSaude() {
		return postoSaude;
	}

	public void setPostoSaude(PostoSaude postoSaude) {
		this.postoSaude = postoSaude;
	}

	public List<Familia> getFamilias() {
		return familias;
	}

	public void setFamilias(List<Familia> familias) {
		this.familias = familias;
	}

	@Override
	public String toString() {
		return "AgenteSaude [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", cpfEmissor=" + cpfEmissor + ", cpfUf="
				+ cpfUf + ", telefone=" + telefone + ", dtNascimento=" + dtNascimento + ", cns=" + cns + "]";
	}
}
