package br.com.smarthealth.test;

import br.com.smarthealth.entity.PostoSaude;
import br.com.smarthealth.service.PostoSaudeService;

public class PostoSaudeTest {
	
	public static void main(String[] args) {
		
		var postoSaudeService = PostoSaudeService.factory();
		
		// INSERT
		var postoSaudeId = postoSaudeService.create(new PostoSaude(
				"Posto de Saude - Vila Nevoa", 
				"61682983000188", 
				"09721458",
				"Rua Posto de Saude 1",
				"145",
				"Bairro Posto de Saude 1",
				"41258965",
				"email@postosaude1.com",
				"08:00 as 19:00"));
		
		// READ
		var postoSaude = postoSaudeService.read(postoSaudeId);
		
		System.out.println("===================================");
		System.out.println(postoSaude.toString());
		System.out.println("===================================");
		
		// UPDATE
		postoSaude.setNome("Posto de Saude - Vila Som");
		postoSaude.setBairro("Bairro Posto de Saude 2");
		
		var postoSaudeAtualizado = postoSaudeService.update(postoSaude);
		
		System.out.println("===================================");
		System.out.println(postoSaudeAtualizado.toString());
		System.out.println("===================================");
		
		// DELETE
		postoSaudeService.delete(postoSaudeId);
		
		var postoSaudeRemovido = postoSaudeService.read(postoSaudeId);
		
		if (postoSaudeRemovido == null) {
			System.out.println("Posto de Saude Removido com sucesso!");
		}
	}
}
