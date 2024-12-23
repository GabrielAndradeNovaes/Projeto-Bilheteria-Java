<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Eventos Disponíveis</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
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



    <div class="container mt-4">
    <h1 class="my-4 text-center">Eventos Disponíveis</h1>

    <c:choose>
        <c:when test="${not empty eventos}">
            <table class="table table-striped table-hover table-responsive shadow-sm">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Descrição</th>
                        <th>Categoria</th>
                        <th>Valor</th>
                        <th>Capacidade</th>
                        <th>Local</th>
                        <th>Endereço</th>
                        <th>Data Início</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="evento" items="${eventos}">
                        <tr>
                            <td>${evento.id}</td>
                            <td>${evento.nome}</td>
                            <td>${evento.descricao}</td>
                            <td>${evento.categoria}</td>
                            <td>${evento.valor}</td>
                            <td>${evento.capacidade}</td>
                            <td>${evento.local}</td>
                            <td>${evento.endereco}</td>
                            <td>${evento.dataInicio}</td> 
                            <td>
                                <a href="/sisbilheteria/EventoCompra?next=compra.jsp&id=${evento.id}" class="btn btn-sm btn-outline-primary">Comprar</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <p class="alert alert-warning text-center">Nenhum evento disponível no momento.</p>
        </c:otherwise>
    </c:choose>
</div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
