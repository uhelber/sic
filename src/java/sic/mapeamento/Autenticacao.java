/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sic.mapeamento;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author UhelberC
 */
@Entity
@Table
public class Autenticacao implements Serializable{
    @Id
    @GeneratedValue
    private Integer idAutenticacao;
    private String login;
    private String senha;
    private Date ultimo_acesso;

    public Integer getIdAutenticacao() {
        return idAutenticacao;
    }

    public void setIdAutenticacao(Integer idAutenticacao) {
        this.idAutenticacao = idAutenticacao;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getUltimo_acesso() {
        return ultimo_acesso;
    }

    public void setUltimo_acesso(Date ultimo_acesso) {
        this.ultimo_acesso = ultimo_acesso;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.idAutenticacao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Autenticacao other = (Autenticacao) obj;
        if (!Objects.equals(this.idAutenticacao, other.idAutenticacao)) {
            return false;
        }
        return true;
    }
    
}
