<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Resultado cadastro de evento</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilo.css">
    <script src="${pageContext.request.contextPath}/resources/js/tema.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
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
        <h2>Resultado do cadastro de evento</h2>
        <p>${mensagem}</p>
        <a href="home.jsp" class="btn btn-primary">Voltar</a>
    </div>
</body>
</html>
