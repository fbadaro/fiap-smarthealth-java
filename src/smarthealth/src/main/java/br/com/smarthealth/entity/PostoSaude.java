package br.com.smarthealth.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "HT01_SAUDE")
public class PostoSaude extends BaseEntity<Integer> {

	@Id
	@SequenceGenerator(name = "saude_seq", sequenceName = "saude_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "saude_seq")
	@Column(name = "ps_id", nullable = false)
	private Integer id;
	
	@Column(name = "ps_nome", length = 150, nullable = false)
	private String nome;
	
	@Column(name = "ps_cnpj", length = 14, nullable = false)
	private String cnpj;
	
	@Column(name = "ps_cep", length = 9, nullable = false)
	private String cep;
	
	@Column(name = "ps_endereco", length = 150, nullable = false)
	private String endereço;
	
	@Column(name = "ps_complemento", length = 30)
	private String complemento;
	
	@Column(name = "ps_bairro", length = 150, nullable = false)
	private String bairro;
	
	@Column(name = "ps_telefone", length = 14, nullable = false)
	private String telefone;
	
	@Column(name = "ps_email", length = 30, nullable = false)
	private String email;
	
	@Column(name = "ps_horario", length = 14)
	private String horario;
	
	@OneToMany(mappedBy = "postoSaude")
	private List<Familia> familias;
	
	@OneToMany(mappedBy = "postoSaude")
	private List<AgenteSaude> agentes;
	
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "saude_ps_id"),
	inverseJoinColumns = @JoinColumn(name = "medico_md_id"), name = "R01_HT01_HT02")
	private List<Medico> medicos;
	
	public PostoSaude() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostoSaude(int id, String nome, String cnpj, String cep, String endereço, String complemento, String bairro,
			String telefone, String email, String horario) {
		super();
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.cep = cep;
		this.endereço = endereço;
		this.complemento = complemento;
		this.bairro = bairro;
		this.telefone = telefone;
		this.email = email;
		this.horario = horario;
	}
	
	public PostoSaude(String nome, String cnpj, String cep, String endereço, String complemento, String bairro,
			String telefone, String email, String horario) {
		super();		
		this.nome = nome;
		this.cnpj = cnpj;
		this.cep = cep;
		this.endereço = endereço;
		this.complemento = complemento;
		this.bairro = bairro;
		this.telefone = telefone;
		this.email = email;
		this.horario = horario;
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereço() {
		return endereço;
	}

	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public List<Familia> getFamilias() {
		return familias;
	}

	public void setFamilias(List<Familia> familias) {
		this.familias = familias;
	}

	public List<AgenteSaude> getAgentes() {
		return agentes;
	}

	public void setAgentes(List<AgenteSaude> agentes) {
		this.agentes = agentes;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	@Override
	public String toString() {
		return "PostoSaude [id=" + id + ", nome=" + nome + ", cnpj=" + cnpj + ", cep=" + cep + ", endereço=" + endereço
				+ ", complemento=" + complemento + ", bairro=" + bairro + ", telefone=" + telefone + ", email=" + email
				+ ", horario=" + horario + "]";
	}	
}
