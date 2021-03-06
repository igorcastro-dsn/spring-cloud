package br.com.alura.microservice.fornecedor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.fornecedor.model.InfoFornecedor;
import br.com.alura.microservice.fornecedor.service.InfoService;

@RestController
@RequestMapping("/infos")
public class InfoController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(InfoController.class);
	
	@Autowired
	private InfoService infoService;
	
	@GetMapping("/{estado}")
	public InfoFornecedor getInfoPorEstado(@PathVariable String estado) {
		LOGGER.info("Recebido o pedido do fornecedor de {}", estado);
		return infoService.getInfoPorEstado(estado);
	}
}
