package br.com.smarthealth.test;

import java.time.LocalDate;

import br.com.smarthealth.entity.AgenteSaude;
import br.com.smarthealth.entity.PostoSaude;
import br.com.smarthealth.service.AgenteSaudeService;
import br.com.smarthealth.service.PostoSaudeService;

public class AgenteSaudeTest {
	
	public static void main(String[] args) {
				
		var agenteSaudeService = AgenteSaudeService.factory();
		var postoSaudeService = PostoSaudeService.factory();
		
		var postoSaude = new PostoSaude(
				"Posto de Saude - Vila Folha", 
				"61682983000188", 
				"09721458",
				"Rua Posto de Saude 1",
				"145",
				"Bairro Posto de Saude 1",
				"41258965",
				"email@postosaude1.com",
				"08:00 as 19:00");
		
		postoSaudeService.create(postoSaude);
		
		// INSERT
		var agenteSaudeId = agenteSaudeService.create(new AgenteSaude(
				"Fabio Badaro",
				"35894586578",
				"SSP",
				"SP",
				"945871254",
				LocalDate.now(),
				"154785469852547",
				postoSaude));	
		
		// READ
		var agenteSaude = agenteSaudeService.read(agenteSaudeId);
		
		System.out.println("===================================");
		System.out.println(agenteSaude.toString());
		System.out.println("===================================");
		
		// UPDATE
		agenteSaude.setNome("William Dias Moreira");
		agenteSaude.setCpf("99999999999");
		
		agenteSaudeService.update(agenteSaude);
		
		var agenteSaudeAtualizado = agenteSaudeService.read(agenteSaudeId);
		
		System.out.println("===================================");
		System.out.println(agenteSaudeAtualizado.toString());
		System.out.println("===================================");
		
		// DELETE
		agenteSaudeService.delete(agenteSaudeId);
		
		var agenteSaudeRemovido = agenteSaudeService.read(agenteSaudeId);
		
		if (agenteSaudeRemovido == null) {
			System.out.println("Agente de Saude Removido com sucesso!");
		}
	}
}
