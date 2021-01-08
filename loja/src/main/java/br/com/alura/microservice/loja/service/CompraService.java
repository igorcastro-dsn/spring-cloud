package br.com.alura.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.alura.microservice.loja.controller.dto.CompraDto;
import br.com.alura.microservice.loja.controller.dto.InfoFornecedorDto;

@Service
public class CompraService {
	
	@Autowired
	private RestTemplate client;
	
	@Autowired
	private DiscoveryClient eurekaClient;

	public void realizaCompra(CompraDto compra) {
		
		ResponseEntity<InfoFornecedorDto> exchange = 
			client.exchange("http://fornecedor/infos/"+compra.getEndereco().getEstado(),
			HttpMethod.GET, null, InfoFornecedorDto.class);
		
		eurekaClient.getInstances("fornecedor").stream().forEach(fornecedor ->
			System.out.println("localhost:" + fornecedor.getPort())
		);
		
		System.out.println(exchange.getBody().getEndereco());
		
	}

}
