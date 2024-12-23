package br.com.bilheteria.model;

import java.time.LocalDateTime;

public class Evento {
	private int id;
    private String nome;
    private String descricao;
    private String categoria;
    private float valor;
    private int capacidade;
    private String local;
    private String endereco;
    private LocalDateTime dataInicio;
    private int quantidadeIngressosVendidos;
    
    public Evento() {
    	
    }
    
    
    public Evento(int id, String nome, String descricao, String categoria, float valor, int capacidade, String local,
			String endereco, LocalDateTime dataInicio) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.categoria = categoria;
		this.valor = valor;
		this.capacidade = capacidade;
		this.local = local;
		this.endereco = endereco;
		this.dataInicio = dataInicio;
	}
    
    public void incrementarIngressosVendidos(int quantidade) {
        this.quantidadeIngressosVendidos += quantidade;
    }

	public int calcularLugaresRestantes() {
        return capacidade - quantidadeIngressosVendidos;
    }
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public LocalDateTime getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}
	public void setQuantidadeIngressosVendidos(int quantidadeIngressosVendidos) {
		this.quantidadeIngressosVendidos = quantidadeIngressosVendidos;
	}


	public int getQuantidadeIngressosVendidos() {
		return quantidadeIngressosVendidos;
	}
    
    
}
