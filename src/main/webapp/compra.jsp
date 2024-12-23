<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Realizar Compra</title>
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
    
    
    
    <div class="container">
        <h2>Realizar Compra</h2>
        <form action="/sisbilheteria/CompraRealizar" method="post">
            <div class="form-group">
                <label for="cliente">Cliente:</label>      
                <input type="text" class="form-control" value="${cliente.nome}" readonly>
                <input type="hidden" name="cliente_id" value="${cliente.id}">

            </div>

            <div class="form-group">
                <label for="evento">Evento:</label>
                <input type="text" class="form-control" value="${evento.nome}" readonly>
                <input type="hidden" name="evento_id" value="${evento.id}">
            </div>

            <div class="form-group">
                <label for="valor">Valor:</label>
                <input type="text" name="valor" class="form-control" id="valor" value="${evento.valor}" readonly>
                
            </div>

            <div class="form-group">
                <label for="quantidade">Quantidade:</label>
                <input type="number" name="quantidade" class="form-control" min="1" required id="quantidade">
            </div>

            <div class="form-group">
                <label for="forma_pagamento">Forma de Pagamento:</label>
                <select name="forma_pagamento" class="form-control" required>
                    <option value="Cartão">Cartão</option>
                    <option value="Boleto">Boleto</option>
                    <option value="Pix">Pix</option>
                </select>
            </div>

            <button type="submit" class="btn btn-primary">Comprar</button>
        </form>
    </div>

    
</body>
</html>
