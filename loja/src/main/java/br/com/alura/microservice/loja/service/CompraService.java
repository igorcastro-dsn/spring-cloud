package br.com.alura.microservice.loja.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.alura.microservice.loja.client.FornecedorClient;
import br.com.alura.microservice.loja.controller.dto.CompraDto;
import br.com.alura.microservice.loja.controller.dto.InfoFornecedorDto;
import br.com.alura.microservice.loja.controller.dto.InfoPedidoDto;
import br.com.alura.microservice.loja.model.Compra;

@Service
public class CompraService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CompraService.class);
	
	@Autowired
	private FornecedorClient fornecedorClient;

	@HystrixCommand(fallbackMethod = "realizaCompraFallback")
	public Compra realizaCompra(CompraDto compra) {
		InfoFornecedorDto fornecedor = fornecedorClient.obterInfoPorEstado(compra.getEndereco().getEstado());
		LOGGER.info("Obtendo informações do fornecedor - Endereço: {}", fornecedor.getEndereco());

		LOGGER.info("Realizando um pedido com {} itens", compra.getItens().size());
		InfoPedidoDto pedido = fornecedorClient.realizarPedido(compra.getItens());
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return new Compra(pedido.getId(), pedido.getTempoDePreparo(), compra.getEndereco().toString());
	}

	public Compra realizaCompraFallback(CompraDto compra) {
		return new Compra(null, null, "Gerado pelo fallback");
	}
}
