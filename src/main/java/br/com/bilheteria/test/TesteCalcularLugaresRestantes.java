package br.com.bilheteria.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import br.com.bilheteria.model.Evento;

class TesteCalcularLugaresRestantes {

	@Test
    public void testCalcularLugaresRestantes() {
        Evento evento = new Evento(1, "Show de Rock", "Grande show de rock", "Música", 
                                    100.0f, 100, "Estádio XYZ", 
                                    "Rua das Estrelas, 123", LocalDateTime.now());

        assertEquals(100, evento.calcularLugaresRestantes(), 
                     "A quantidade inicial de lugares restantes deveria ser igual à capacidade do evento.");

        evento.incrementarIngressosVendidos(30);

        assertEquals(70, evento.calcularLugaresRestantes(), 
                     "Após vender 30 ingressos, deveriam restar 70 lugares.");

        evento.incrementarIngressosVendidos(20);

        assertEquals(50, evento.calcularLugaresRestantes(), 
                     "Após vender mais 20 ingressos, deveriam restar 50 lugares.");

        evento.incrementarIngressosVendidos(60);

        assertEquals(-10, evento.calcularLugaresRestantes(), 
                     "Deveria refletir uma quantidade negativa indicando excesso de vendas.");
    }

}
