<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Cadastre-se</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <style>
        body {
            background-color: #f7f7f7;
        }
        .form-container {
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
        }
        .form-container h2 {
            margin-bottom: 20px;
            color: #007bff;
        }
        .form-group label {
            font-weight: bold;
        }
        .btn-primary {
            width: 100%;
            padding: 12px;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-8 col-lg-6">
                <div class="form-container">
                    <h2>Cadastre-se</h2>
                    <form action="/sisbilheteria/ClienteAdd" method="post">
                        <div class="row">
                            <div class="form-group col-md-6">
                                <label for="inputName">Nome</label>
                                <input type="text" class="form-control" id="inputName" placeholder="Nome completo" name="nome" required>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="inputCpf">CPF</label>
                                <input type="text" class="form-control" id="inputCpf" placeholder="CPF" name="cpf" required>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="form-group col-md-6">
                                <label for="inputEmail">Email</label>
                                <input type="email" class="form-control" id="inputEmail" placeholder="Email" name="email" required>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="inputTelefone">Telefone</label>
                                <input type="text" class="form-control" id="inputTelefone" placeholder="Telefone" name="telefone" required>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="form-group col-md-6">
                                <label for="inputEndereco">Endereço</label>
                                <input type="text" class="form-control" id="inputEndereco" placeholder="Endereço" name="endereco" required>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="inputNumero">Número</label>
                                <input type="text" class="form-control" id="inputNumero" placeholder="Número" name="numero" required>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-6">
                                <label for="inputComplemento">Complemento</label>
                                <input type="text" class="form-control" id="inputComplemento" placeholder="Complemento" name="complemento">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="inputBairro">Bairro</label>
                                <input type="text" class="form-control" id="inputBairro" placeholder="Bairro" name="bairro" required>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-6">
                                <label for="inputCidade">Cidade</label>
                                <input type="text" class="form-control" id="inputCidade" placeholder="Cidade" name="cidade" required>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="inputUf">Estado (UF)</label>
                                <input type="text" class="form-control" id="inputUf" placeholder="Estado (UF)" name="uf" required>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-6">
                                <label for="inputCep">CEP</label>
                                <input type="text" class="form-control" id="inputCep" placeholder="CEP" name="cep" required>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="inputDataNascimento">Data de Nascimento</label>
                                <input type="date" class="form-control" id="inputDataNascimento" name="dataNascimento" required>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-6">
                                <label for="inputLogin">Login</label>
                                <input type="text" class="form-control" id="inputLogin" placeholder="Login" name="login" required>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="inputSenha">Senha</label>
                                <input type="password" class="form-control" id="inputSenha" placeholder="Senha" name="senha" required>
                            </div>
                        </div>

                        <button type="submit" class="btn btn-primary mt-3">Cadastrar</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
