<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Compras</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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
    <h2>Lista de Compras</h2>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>ID</th>
                <th>Cliente</th>
                <th>Evento</th>
                <th>Quantidade</th>
                <th>Valor Unitário</th>
                <th>Valor Total</th>
                <th>Forma de Pagamento</th>
                <th>Data</th>
            </tr>
        </thead>
        <tbody>
            <!-- A lista de compras será iterada aqui -->
            <c:forEach var="compra" items="${compras}">
                <tr>
                    <td>${compra.id}</td>
                    <td>${compra.cliente.nome}</td>
                    <td>${compra.evento.nome}</td>
                    <td>${compra.quantidade}</td>
                    <td>${compra.valor}</td>
                    <td>${compra.calcularValorTotal()}</td>
                    <td>${compra.formaPagamento}</td>
                    <td>${compra.data}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<div class="d-flex justify-content-center mt-4">
    <a href="AlterarCompra.jsp" class="btn btn-primary me-3">Atualizar Status</a>
    <a href="ExcluirCompra.jsp" class="btn btn-danger">Excluir Compra</a>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
