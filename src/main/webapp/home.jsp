<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Bilheteria</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilo.css">
    <script src="${pageContext.request.contextPath}/resources/js/tema.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
    
</head>
<body>
    <!-- Barra superior com pesquisa e botões -->
    <nav class="navbar navbar-expand-lg">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Bilheteria</a>
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
    <h1 class="text-center mb-4">Eventos Disponíveis</h1>

    <c:choose>
        <c:when test="${not empty eventos}">
            <div class="row row-cols-1 row-cols-md-3 g-4">
                <c:forEach var="evento" items="${eventos}">
                    <div class="col">
                        <div class="card shadow-sm h-100 border-0" style="overflow: hidden; border-radius: 15px;">
                            <!-- Cabeçalho do Card -->
                            <div class="card-header text-white" style="background-color: #198754;">
                                <h5 class="card-title mb-0">${evento.nome}</h5>
                            </div>

                            <!-- Corpo do Card -->
                            <div class="card-body p-4" style="background-color: #e6f7f8;">
                                <p class="card-text mb-2"><strong>Descrição:</strong> ${evento.descricao}</p>
                                <p class="card-text mb-2"><strong>Categoria:</strong> ${evento.categoria}</p>
                                <p class="card-text mb-2"><strong>Valor:</strong> R$ ${evento.valor}</p>
                                <p class="card-text mb-2"><strong>Capacidade:</strong> ${evento.capacidade} pessoas</p>
                                <p class="card-text mb-2"><strong>Local:</strong> ${evento.local}</p>
                                <p class="card-text"><strong>Data de Início:</strong> ${evento.dataInicio}</p>
                            </div>

                            <!-- Rodapé do Card -->
                            <div class="card-footer text-center text-muted" style="background-color: #d8f3dc;">
                                <small>${evento.endereco}</small>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:when>
        <c:otherwise>
            <p class="alert alert-warning text-center">Nenhum evento disponível no momento.</p>
        </c:otherwise>
    </c:choose>
</div>
     
    


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
