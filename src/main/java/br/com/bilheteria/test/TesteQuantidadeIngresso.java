package br.com.bilheteria.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import br.com.bilheteria.model.Cliente;
import br.com.bilheteria.model.Compra;
import br.com.bilheteria.model.Evento;

class TesteQuantidadeIngresso {

	@Test
	public void testIncrementarIngressosVendidos() {
	    // Criar evento
	    Evento evento = new Evento(1, "Show de Rock", "Grande show de rock", "Música", 100.0f, 500, "Estádio XYZ", 
	                                "Rua das Estrelas, 123", LocalDateTime.now());

	    // Verificar ingressos vendidos inicialmente
	    assertEquals(0, evento.getQuantidadeIngressosVendidos());

	    // Criar uma compra para o evento
	    Compra compra1 = new Compra(1, new Cliente(), evento, 2, 100.0f, "Cartão");

	    // Verificar que a quantidade de ingressos vendidos aumentou
	    assertEquals(2, evento.getQuantidadeIngressosVendidos());

	    // Criar outra compra para o mesmo evento
	    Compra compra2 = new Compra(2, new Cliente(), evento, 3, 100.0f, "Cartão");

	    // Verificar que a quantidade de ingressos vendidos foi incrementada
	    assertEquals(5, evento.getQuantidadeIngressosVendidos());
	}

}
