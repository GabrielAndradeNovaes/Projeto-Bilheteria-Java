<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar Evento</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilo.css">
<script src="${pageContext.request.contextPath}/resources/js/tema.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-expand-lg">
        <div class="container-fluid">
            <a class="navbar-brand" href="EventoListar?next=home.jsp">Bilheteria</a>
            <form class="d-flex mx-auto" style="width: 50%;" action="EventoListar" method="get">
                <input class="form-control me-2" type="search" placeholder="Pesquisar eventos, shows, etc..." aria-label="Search">
                <button class="btn btn-outline-primary" type="submit">Buscar</button>
            </form>
            <div>
                <a href="EventoListar?next=eventolistar.jsp" class="btn btn-primary me-2">Listar evento</a>
                <a href="CadastrarEvento.jsp" class="btn btn-success">Cadastrar Evento</a>
                <a href="CompraListar?next=CompraListar.jsp" class="btn btn-success">Listar Compras</a>
                <button onclick="alterarTema('claro')" class="btn btn-success"><i class="bi bi-cloud-sun"></i></button>
        		<button onclick="alterarTema('escuro')" class="btn btn-success"><i class="bi bi-cloud-rain-heavy-fill"></i></button>
            </div>
        </div>
    </nav>


<div class="container mt-5">
    <h2>Cadastrar Evento</h2>
    <form action="/sisbilheteria/EventoAdd" method="post">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputName">Nome</label>
                <input type="text" class="form-control" id="inputName" placeholder="Nome do evento" name="nome" required>
            </div>
            <div class="form-group col-md-6">
                <label for="inputDescricao">Descrição</label>
                <textarea class="form-control" id="inputDescricao" placeholder="Descrição do evento" name="descricao" rows="3" required></textarea>
            </div>
        </div>
        <div class="form-group col-md-6 mt-3">
            <label for="inputCategoria">Categoria</label>
            <input type="text" class="form-control" id="inputCategoria" placeholder="Categoria do evento" name="categoria" required>
        </div>
        <div class="form-group col-md-6 mt-3">
            <label for="inputValor">Valor</label>
            <input type="number" step="0.01" class="form-control" id="inputValor" placeholder="Valor do ingresso" name="valor" required>
        </div>
        <div class="form-group col-md-6 mt-3">
            <label for="inputCapacidade">Capacidade</label>
            <input type="number" class="form-control" id="inputCapacidade" placeholder="Capacidade máxima" name="capacidade" required>
        </div>
        <div class="form-group col-md-6 mt-3">
            <label for="inputLocal">Local</label>
            <input type="text" class="form-control" id="inputLocal" placeholder="Local do evento" name="local" required>
        </div>
        <div class="form-group col-md-6 mt-3">
            <label for="inputEndereco">Endereço</label>
            <input type="text" class="form-control" id="inputEndereco" placeholder="Endereço do evento" name="endereco" required>
        </div>
        <div class="form-group col-md-6 mt-3">
            <label for="inputDataInicio">Data e Hora de Início</label>
            <input type="datetime-local" class="form-control" id="inputDataInicio" name="dataInicio" required>
        </div>
        <button type="submit" class="btn btn-primary mt-4">Cadastrar</button>
    </form>
</div>
</body>
</html>
