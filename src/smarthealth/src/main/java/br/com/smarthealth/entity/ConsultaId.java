package br.com.smarthealth.entity;

import java.io.Serializable;
import java.util.Objects;

public class ConsultaId implements Serializable {
		
	private int familia;
	
	private int medico;

	public int getFamilia() {
		return familia;
	}
		
	public ConsultaId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConsultaId(int familia, int medico) {
		super();
		this.familia = familia;
		this.medico = medico;
	}

	public void setFamilia(int familia) {
		this.familia = familia;
	}

	public int getMedico() {
		return medico;
	}

	public void setMedico(int medico) {
		this.medico = medico;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(familia, medico);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsultaId other = (ConsultaId) obj;
		return familia == other.familia && medico == other.medico;
	}
}