package br.com.smarthealth.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "HT05_MEMBRO")
public class Membro extends BaseEntity<Integer> {
	
	@Id
	@SequenceGenerator(name = "membro_seq", sequenceName = "membro_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "membro_seq")
	@Column(name = "mb_id", nullable = false)
	private Integer id;
	
	@Column(name = "mb_nome", length = 150, nullable = false)
	private String nome;
	
	@Column(name = "mb_nome_social", length = 150)
	private String nomeSocial;
	
	@Column(name = "mb_cpf", length = 11, nullable = false)
	private String cpf;
	
	@Column(name = "mb_cpf_emissor", length = 5, nullable = false)
	private String cpfEmissor;
	
	@Column(name = "mb_cpf_uf", length = 2, nullable = false)
	private String cpfUf;
	
	@Column(name = "mb_rg", length = 15, nullable = false)
	private String rg;
	
	@Column(name = "mb_nascimento", nullable = false)
	private LocalDate dtNascimento;
	
	@Column(name = "mb_responsavel", nullable = false)
	private char responsavel;
	
	@ManyToOne
	@JoinColumn(name = "fm_id", nullable = false)
	private Familia familia;
	
	@ManyToOne
	@JoinColumn(name = "sx_id", nullable = false)
	private Sexo sexo;
	
	@OneToMany(mappedBy = "membro")
	private List<RegistroVacina> vacinas;
	
	public Membro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Membro(int id, String nome, String nomeSocial, String cpf, String cpfEmissor, String cpfUf, String rg,
			LocalDate dtNascimento, char responsavel, Familia familia, Sexo sexo) {
		super();
		this.id = id;
		this.nome = nome;
		this.nomeSocial = nomeSocial;
		this.cpf = cpf;
		this.cpfEmissor = cpfEmissor;
		this.cpfUf = cpfUf;
		this.rg = rg;
		this.dtNascimento = dtNascimento;
		this.responsavel = responsavel;
		this.familia = familia;
		this.sexo = sexo;
	}
	
	public Membro(String nome, String nomeSocial, String cpf, String cpfEmissor, String cpfUf, String rg,
			LocalDate dtNascimento, char responsavel, Familia familia, Sexo sexo) {
		super();		
		this.nome = nome;
		this.nomeSocial = nomeSocial;
		this.cpf = cpf;
		this.cpfEmissor = cpfEmissor;
		this.cpfUf = cpfUf;
		this.rg = rg;
		this.dtNascimento = dtNascimento;
		this.responsavel = responsavel;
		this.familia = familia;
		this.sexo = sexo;
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

	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public LocalDate getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public char getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(char responsavel) {
		this.responsavel = responsavel;
	}

	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public List<RegistroVacina> getVacinas() {
		return vacinas;
	}

	public void setVacinas(List<RegistroVacina> vacinas) {
		this.vacinas = vacinas;
	}

	@Override
	public String toString() {
		return "Membro [id=" + id + ", nome=" + nome + ", nomeSocial=" + nomeSocial + ", cpf=" + cpf + ", cpfEmissor="
				+ cpfEmissor + ", cpfUf=" + cpfUf + ", rg=" + rg + ", dtNascimento=" + dtNascimento + ", responsavel="
				+ responsavel + "]";
	}	
}
