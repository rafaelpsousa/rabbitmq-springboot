package br.unicamp.prefeitura.estoquepreco.consumer.rabbitmqconsumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import br.unicamp.prefeitura.estoquepreco.constants.RabbitMqConstants;
import br.unicamp.prefeitura.estoquepreco.dto.EstoqueDto;

@Component		
public class EstoqueConsumer {
	
	@RabbitListener(queues = RabbitMqConstants.FILA_ESTOQUE)
	private void consumidor(EstoqueDto estoqueDto) {
		System.out.println("Codigo: " + estoqueDto.codigoProduto);
		System.out.println("Qtde: " + estoqueDto.quantidade);
		System.out.println(" - - - - - - - - - - ");
		
	}
}
