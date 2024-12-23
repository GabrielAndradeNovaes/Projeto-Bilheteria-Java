package br.com.bilheteria.model;

import org.mindrot.jbcrypt.BCrypt;

public class UsuarioService {

    public String gerarHashSenha(String senha) {
        return BCrypt.hashpw(senha, BCrypt.gensalt());
    }

    public boolean verificarSenha(String senhaDigitada, String senhaHashBanco) {
        return BCrypt.checkpw(senhaDigitada, senhaHashBanco);
    }
}
