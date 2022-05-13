package br.unicamp.prefeitura.estoquepreco.consumer.rabbitmqconsumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.unicamp.prefeitura.estoquepreco.constants.RabbitMqConstants;
import br.unicamp.prefeitura.estoquepreco.dto.EstoqueDto;

@Component
public class EstoqueConsumer {

	@Autowired
	private ObjectMapper objectMapper;

	@RabbitListener(queues = RabbitMqConstants.FILA_ESTOQUE)
	private void consumidor(String estoqueMensagem) {

		EstoqueDto estoqueDto;

		try {

			estoqueDto = this.objectMapper.readValue(estoqueMensagem, EstoqueDto.class);

			System.out.println("Codigo: " + estoqueDto.codigoProduto);
			System.out.println("Qtde: " + estoqueDto.quantidade);
			System.out.println(" - - - - - - - - - - ");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
