function alterarTema(tema) {
    if (tema === 'claro') {
        document.body.classList.remove('tema-escuro');
        document.body.classList.add('tema-claro');
    } else if (tema === 'escuro') {
        document.body.classList.remove('tema-claro');
        document.body.classList.add('tema-escuro');
    }
    document.cookie = "tema=" + tema + "; path=/; max-age=" + (7 * 24 * 60 * 60);
}

// Função para carregar o tema do cookie ao carregar a página
function carregarTema() {
    var tema = getCookie("tema");
    if (tema === "escuro") {
        document.body.classList.add('tema-escuro');
    } else {
        document.body.classList.add('tema-claro');
    }
}

// Função para obter o valor de um cookie
function getCookie(nome) {
    var nomeCookie = nome + "=";
    var decodificado = decodeURIComponent(document.cookie);
    var cookies = decodificado.split(';');
    for (var i = 0; i < cookies.length; i++) {
        var cookie = cookies[i].trim();
        if (cookie.indexOf(nomeCookie) === 0) {
            return cookie.substring(nomeCookie.length, cookie.length);
        }
    }
    return "";
}

// Carregar o tema ao carregar a página
window.onload = carregarTema;
