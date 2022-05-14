package br.unicamp.prefeitura.estoquepreco.consumer.rabbitmqconsumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.unicamp.prefeitura.estoquepreco.constants.RabbitMqConstants;
import br.unicamp.prefeitura.estoquepreco.dto.PrecoDto;

@Component
public class PrecoConsumer {

	@Autowired
	private ObjectMapper objectMapper;

	@RabbitListener(queues = RabbitMqConstants.FILA_PRECO)
	private void consumidor(String precoMensagem) {

		PrecoDto precoDto;

		try {

			precoDto = this.objectMapper.readValue(precoMensagem, PrecoDto.class);

			System.out.println("Codigo: " + precoDto.codigoProduto);
			System.out.println("Preço: " + precoDto.preco);
			System.out.println(" - - - - - - - - - - ");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
