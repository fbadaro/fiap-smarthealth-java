package br.com.smarthealth.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "HT04_FAMILIA")
public class Familia extends BaseEntity<Integer> {
	
	@Id
	@SequenceGenerator(name = "familia_seq", sequenceName = "familia_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "familia_seq")
	@Column(name = "fm_id", nullable = false)
	private Integer id;
	
	@Column(name = "fm_sobrenome", length = 150, nullable = false)
	private String sobrenome;
	
	@Column(name = "fm_cns", length = 15, nullable = false)
	private String cns;
	
	@Column(name = "fm_cep", length = 9, nullable = false)
	private String cep;
	
	@Column(name = "fm_endereco", length = 150, nullable = false)
	private String endereco;
	
	@Column(name = "fm_complemento", length = 30)
	private String complemento;
	
	@Column(name = "fm_bairro", length = 150, nullable = false)
	private String bairro;
	
	@Column(name = "fm_telefone", length = 14, nullable = false)
	private String telefone;
	
	@Column(name = "fm_email", length = 30, nullable = false)
	private String email;
	
	@OneToMany(mappedBy = "familia")
	private List<Membro> membros;
	
	@ManyToOne
	@JoinColumn(name = "ps_id", nullable = false)
	private PostoSaude postoSaude;
	
	@ManyToMany(mappedBy = "familias")
	private List<AgenteSaude> agentes;	

	public Familia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Familia(int id, String sobrenome, String cns, String cep, String endereco, String complemento, String bairro,
			String telefone, String email, List<Membro> membros, PostoSaude postoSaude, List<AgenteSaude> agentes) {
		super();
		this.id = id;
		this.sobrenome = sobrenome;
		this.cns = cns;
		this.cep = cep;
		this.endereco = endereco;
		this.complemento = complemento;
		this.bairro = bairro;
		this.telefone = telefone;
		this.email = email;
		this.membros = membros;
		this.postoSaude = postoSaude;
		this.agentes = agentes;
	}
	
	public Familia(String sobrenome, String cns, String cep, String endereco, String complemento, String bairro,
			String telefone, String email, List<Membro> membros, PostoSaude postoSaude, List<AgenteSaude> agentes) {
		super();		
		this.sobrenome = sobrenome;
		this.cns = cns;
		this.cep = cep;
		this.endereco = endereco;
		this.complemento = complemento;
		this.bairro = bairro;
		this.telefone = telefone;
		this.email = email;
		this.membros = membros;
		this.postoSaude = postoSaude;
		this.agentes = agentes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCns() {
		return cns;
	}

	public void setCns(String cns) {
		this.cns = cns;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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

	public List<Membro> getMembros() {
		return membros;
	}

	public void setMembros(List<Membro> membros) {
		this.membros = membros;
	}

	public PostoSaude getPostoSaude() {
		return postoSaude;
	}

	public void setPostoSaude(PostoSaude postoSaude) {
		this.postoSaude = postoSaude;
	}

	public List<AgenteSaude> getAgentes() {
		return agentes;
	}

	public void setAgentes(List<AgenteSaude> agentes) {
		this.agentes = agentes;
	}

	@Override
	public String toString() {
		return "Familia [id=" + id + ", sobrenome=" + sobrenome + ", cns=" + cns + ", cep=" + cep + ", endereco="
				+ endereco + ", complemento=" + complemento + ", bairro=" + bairro + ", telefone=" + telefone
				+ ", email=" + email + "]";
	}
}
