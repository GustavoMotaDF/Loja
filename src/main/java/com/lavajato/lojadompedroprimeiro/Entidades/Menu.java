/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavajato.lojadompedroprimeiro.Entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author gustavo
 */
@Entity
public class Menu implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idmenu;
    private String menu;
    private String link;
    private Integer nivelacesso;

    public Long getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(Long idmenu) {
        this.idmenu = idmenu;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getNivelacesso() {
        return nivelacesso;
    }

    public void setNivelacesso(Integer nivelacesso) {
        this.nivelacesso = nivelacesso;
    }

    public Menu(Long idmenu, String menu, String link, Integer nivelacesso) {
        this.idmenu = idmenu;
        this.menu = menu;
        this.link = link;
        this.nivelacesso = nivelacesso;
    }

    public Menu() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.idmenu);
        return hash;
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
        final Menu other = (Menu) obj;
        if (!Objects.equals(this.idmenu, other.idmenu)) {
            return false;
        }
        return true;
    }
    
    
    
}
