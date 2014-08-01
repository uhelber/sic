/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sic.DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import sic.mapeamento.Autenticacao;
import sic.mapeamento.Usuario;

/**
 *
 * @author UhelberC
 */
public class UsuarioDAO {
    private Session sessao;

    public UsuarioDAO(Session sessao) {
        this.sessao = sessao;
    }
    
    public List<Usuario> todos() {
        List<Usuario> usuarios = this.sessao.createCriteria(Usuario.class)
                .addOrder(Order.asc("nome"))
                .list();
        return usuarios;
    }
    
    public Usuario porId(Integer id) {
        Usuario usuario = (Usuario) this.sessao.get(Usuario.class, id);
        return usuario;
    }

    public Usuario validar(Autenticacao autenticacao) {
        Usuario usuario = (Usuario) this.sessao.createQuery("SELECT usuario FROM Usuario usuario WHERE USUARIO.autenticacao.login = :login AND USUARIO.autenticacao.senha = :senha")
                .setString("login", autenticacao.getLogin())
                .setString("senha", autenticacao.getSenha())
                .uniqueResult();
        return usuario;
    }

}
