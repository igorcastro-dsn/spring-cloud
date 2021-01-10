package br.com.alura.microservice.loja.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.alura.microservice.loja.CompraRepository;
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
	
	@Autowired
	private CompraRepository compraRepository;

	@HystrixCommand(threadPoolKey = "findByIdThreadPool")
	public Compra findById(Long id) {
		return compraRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID não encontrado"));
	}
	
	@HystrixCommand(fallbackMethod = "realizaCompraFallback", threadPoolKey = "realizaCompraThreadPool")
	public Compra realizaCompra(CompraDto dto) {
		InfoFornecedorDto fornecedor = fornecedorClient.obterInfoPorEstado(dto.getEndereco().getEstado());
		LOGGER.info("Obtendo informações do fornecedor - Endereço: {}", fornecedor.getEndereco());

		LOGGER.info("Realizando um pedido com {} itens", dto.getItens().size());
		InfoPedidoDto pedido = fornecedorClient.realizarPedido(dto.getItens());
		
		Compra compra = new Compra(pedido.getId(), pedido.getTempoDePreparo(), dto.getEndereco().toString());
		compraRepository.save(compra);
		
		return compra;
	}

	public Compra realizaCompraFallback(CompraDto compra) {
		return new Compra(null, null, "Gerado pelo fallback");
	}

}
