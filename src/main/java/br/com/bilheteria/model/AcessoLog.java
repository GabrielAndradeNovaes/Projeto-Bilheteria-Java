package br.com.bilheteria.model;

import java.time.LocalDateTime;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;

public class AcessoLog {
    private Long id;
    private String ip;
    private LocalDateTime dataHora;
    private String paginaAcessada;
    private Cliente cliente;
    
    
    public AcessoLog(String ip, String paginaAcessada, Cliente cliente) {
    	this.ip = ip;
    	this.paginaAcessada = paginaAcessada;
    	this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
    	return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getPaginaAcessada(ServletRequest request) {
    	HttpServletRequest req = (HttpServletRequest) request;
    	String url = req.getRequestURI();
    	paginaAcessada = url;
        return paginaAcessada;
    }

    public void setPaginaAcessada(String paginaAcessada) {
        this.paginaAcessada = paginaAcessada;
    }

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

    
}
