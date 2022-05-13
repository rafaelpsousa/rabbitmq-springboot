package br.unicamp.prefeitura.estoquepreco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unicamp.prefeitura.estoquepreco.constants.RabbitMqConstants;
import br.unicamp.prefeitura.estoquepreco.dto.EstoqueDto;
import br.unicamp.prefeitura.estoquepreco.service.RabbitMqService;

@RestController
@RequestMapping(value = "estoque")
public class EstoqueController {
	
	@Autowired
	private RabbitMqService rabbitMqService;
	
	@PutMapping
	private ResponseEntity alteraEstoque(@RequestBody EstoqueDto estoqueDto){
		
		System.out.println("Código do produto: " + estoqueDto.codigoProduto);
		
		this.rabbitMqService.enviaMensagem(RabbitMqConstants.FILA_ESTOQUE, estoqueDto);
		return new ResponseEntity(HttpStatus.OK);
		
	}
}
