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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "HT02_MEDICO")
public class Medico extends BaseEntity<Integer> {
	
	@Id
	@SequenceGenerator(name = "medico_seq", sequenceName = "medico_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medico_seq")
	@Column(name = "md_id", nullable = false)
	private Integer id;
	
	@Column(name = "md_nome", length = 150, nullable = false)
	private String nome;
	
	@Column(name = "md_cpf", length = 11, nullable = false)
	private String cpf;
	
	@Column(name = "md_cpf_emissor", length = 5)
	private String cpfEmissor;
	
	@Column(name = "md_cpf_uf", length = 2, nullable = false)
	private String cpfUf;
	
	@Column(name = "md_cpnj", length = 14, nullable = false)
	private String cpnj;
	
	@Column(name = "md_crm", length = 10, nullable = false)
	private String crm;
	
	@Column(name = "md_crm_uf", length = 2, nullable = false)
	private String crmUf;
	
	@Column(name = "md_telefone", length = 14, nullable = false)
	private String telefone;
	
	@Column(name = "md_nascimento", nullable = false)
	private LocalDate dtNascimento;	
	
	@ManyToMany(mappedBy = "medicos")
	private List<PostoSaude> postosSaude;
	
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "medico_md_id"),
	inverseJoinColumns = @JoinColumn(name = "especiali_es_id"), name = "R08_HT02_HT09")
	private List<Especialidade> especialidades;
	
	public Medico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Medico(int id, String nome, String cpf, String cpfEmissor, String cpfUf, String cpnj, String crm,
			String crmUf, String telefone, LocalDate dtNascimento, List<PostoSaude> postosSaude, List<Especialidade> especialidades) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.cpfEmissor = cpfEmissor;
		this.cpfUf = cpfUf;
		this.cpnj = cpnj;
		this.crm = crm;
		this.crmUf = crmUf;
		this.telefone = telefone;
		this.dtNascimento = dtNascimento;
		this.postosSaude = postosSaude;
		this.especialidades = especialidades;
	}
	
	public Medico(String nome, String cpf, String cpfEmissor, String cpfUf, String cpnj, String crm,
			String crmUf, String telefone, LocalDate dtNascimento, List<PostoSaude> postosSaude, List<Especialidade> especialidades) {
		super();		
		this.nome = nome;
		this.cpf = cpf;
		this.cpfEmissor = cpfEmissor;
		this.cpfUf = cpfUf;
		this.cpnj = cpnj;
		this.crm = crm;
		this.crmUf = crmUf;
		this.telefone = telefone;
		this.dtNascimento = dtNascimento;
		this.postosSaude = postosSaude;
		this.especialidades = especialidades;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getCpnj() {
		return cpnj;
	}

	public void setCpnj(String cpnj) {
		this.cpnj = cpnj;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getCrmUf() {
		return crmUf;
	}

	public void setCrmUf(String crmUf) {
		this.crmUf = crmUf;
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

	public List<PostoSaude> getPostosSaude() {
		return postosSaude;
	}

	public void setPostosSaude(List<PostoSaude> postosSaude) {
		this.postosSaude = postosSaude;
	}

	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}	
	
	@Override
	public String toString() {
		return "Medico [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", cpfEmissor=" + cpfEmissor + ", cpfUf="
				+ cpfUf + ", cpnj=" + cpnj + ", crm=" + crm + ", crmUf=" + crmUf + ", telefone=" + telefone
				+ ", dtNascimento=" + dtNascimento + "]";
	}
}
