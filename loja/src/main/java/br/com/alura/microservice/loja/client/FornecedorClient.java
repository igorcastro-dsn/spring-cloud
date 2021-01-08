package br.com.alura.microservice.loja.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.alura.microservice.loja.controller.dto.InfoFornecedorDto;
import br.com.alura.microservice.loja.controller.dto.InfoPedidoDto;
import br.com.alura.microservice.loja.controller.dto.ItemDaCompraDto;


@FeignClient("fornecedor")
public interface FornecedorClient {

	@GetMapping("/infos/{estado}")
	InfoFornecedorDto obterInfoPorEstado(@PathVariable String estado);

	@PostMapping("/pedidos")
	InfoPedidoDto realizarPedido(List<ItemDaCompraDto> itens);
	
}
