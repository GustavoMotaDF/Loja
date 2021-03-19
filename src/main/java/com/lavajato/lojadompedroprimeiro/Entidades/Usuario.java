/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavajato.lojadompedroprimeiro.Entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.SQLDelete;

/**
 *
 * @author gustavo
 */
@Entity
@SQLDelete(sql = "update Usuario set ativo = 0 where idusuario = ?")
public class Usuario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idusuario;
    private String nome;
    private String login;
    private String senha;
    private String grau;
    private Boolean ativo;
    

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getGrau() {
        return grau;
    }

    public void setGrau(String grau) {
        this.grau = grau;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.idusuario);
        return hash;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.idusuario, other.idusuario)) {
            return false;
        }
        return true;
    }
 
    public Usuario(Long idusuario, String nome, String login, String senha, String grau, Boolean ativo) {
        this.idusuario = idusuario;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.grau = grau;
        this.ativo = ativo;
        
    }

    public Usuario() {
    }

     

  
}
