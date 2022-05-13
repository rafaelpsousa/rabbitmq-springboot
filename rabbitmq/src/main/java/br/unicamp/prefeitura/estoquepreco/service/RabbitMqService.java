package br.unicamp.prefeitura.estoquepreco.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RabbitMqService {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private ObjectMapper objectMapper;

	public void enviaMensagem(String nomeFila, Object mensagem) {
		try {
			String mensagemJson = this.objectMapper.writeValueAsString(mensagem);
			this.rabbitTemplate.convertAndSend(nomeFila, mensagemJson);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

}
