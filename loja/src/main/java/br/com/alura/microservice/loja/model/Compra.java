package br.com.alura.microservice.loja.model;

public class Compra {

	private Long pedidoId;
	private Integer tempoDePreparo;
	private String enderecoDeDestino;

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
