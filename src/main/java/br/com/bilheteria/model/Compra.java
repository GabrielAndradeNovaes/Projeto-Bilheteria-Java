package br.com.bilheteria.model;

import java.time.LocalDate;

public class Compra {
	private int id;
    private Cliente cliente;
    private Evento evento;
    private int quantidade;
    private float valor;
    private LocalDate data;
    private String formaPagamento;
    private String status;
    
    public Compra() {
    	
    }
    
    public Compra(int id, Cliente cliente, Evento evento, int quantidade, float valor, String formaPagamento) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.evento = evento;
		this.quantidade = quantidade;
		this.valor = valor;
		this.formaPagamento = formaPagamento;
		this.status = "Ativo";
		
		 if (evento != null) {
	            evento.incrementarIngressosVendidos(quantidade);
	        }
	}

	public float calcularValorTotal() {
        return (quantidade * valor);
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
    
    

}
