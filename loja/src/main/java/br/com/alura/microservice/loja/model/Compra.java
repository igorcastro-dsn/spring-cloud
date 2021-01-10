package br.com.alura.microservice.loja.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Compra {

	@Id
	private Long pedidoId;
	private Integer tempoDePreparo;
	private String enderecoDeDestino;

	public Compra() {}
	
	public Compra(Long pedidoId, Integer tempoDePreparo, String enderecoDeDestino) {
		this.pedidoId = pedidoId;
		this.tempoDePreparo = tempoDePreparo;
		this.enderecoDeDestino = enderecoDeDestino;
	}

	public Long getPedidoId() {
		return pedidoId;
	}

	public Integer getTempoDePreparo() {
		return tempoDePreparo;
	}

	public String getEnderecoDeDestino() {
		return enderecoDeDestino;
	}

}
