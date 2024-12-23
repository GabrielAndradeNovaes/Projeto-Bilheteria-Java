package br.com.bilheteria.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import br.com.bilheteria.dao.EventoDao;
import br.com.bilheteria.model.Evento;

class TesteEvento {

	@Test
	void test() {
		int id = 1;
		String nome = "teste";
		String descricao = "teste";
		String categoria = "teste";
		float valor = 20.0f;
		int capacidade = 100;
		String local = "teste";
		String endereco = "teste";
		LocalDateTime dataInicio = LocalDateTime.now();
		Evento evento1 = new Evento();
		evento1.setId(id);
		evento1.setNome(nome);
        evento1.setDescricao(descricao);
        evento1.setCategoria(categoria);
        evento1.setValor(valor);
        evento1.setCapacidade(capacidade);
        evento1.setLocal(local);
        evento1.setEndereco(endereco);
        evento1.setDataInicio(dataInicio);
		
		EventoDao eveDao = new EventoDao();
		
		try {
			eveDao.inserir(evento1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Evento evento2 = new Evento();
		eveDao = new EventoDao();
		try {
			evento2 = eveDao.listarUm(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Testando EventoDao: inserir(evento) e listarUm(int)");
		assertEquals(evento1.getNome(), evento2.getNome());
		
		Evento evento3 = new Evento();
		eveDao = new EventoDao();
		evento1.setId(id);
		evento1.setNome(nome);
        evento1.setDescricao(descricao);
        evento1.setCategoria(categoria);
        evento1.setValor(valor);
        evento1.setCapacidade(capacidade);
        evento1.setLocal(local);
        evento1.setEndereco(endereco);
        evento1.setDataInicio(dataInicio);
		try {
			eveDao.alterar(evento3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		eveDao = new EventoDao();
		Evento evento4 = new Evento();
		
		try {
			evento4 = eveDao.listarUm(evento3.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals(evento3.getNome(), evento3.getNome());
		System.out.println("Testando EventoDao: alterar(evento) e buscarUm(id)");
		
		eveDao = new EventoDao();
		try {
			eveDao.apagar(evento3.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		eveDao = new EventoDao();
		Evento evento5 = null;
		try {
			evento5 = eveDao.listarUm(evento3.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals(evento5, null);
		System.out.println("Testando EventoDao: Excluir(evento)");
	}

}
