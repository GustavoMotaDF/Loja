/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavajato.lojadompedroprimeiro.BO;

import com.lavajato.lojadompedroprimeiro.Entidades.Menu;
import com.lavajato.lojadompedroprimeiro.Entidades.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author gustavo
 */
public class MenuBO {
    private static final EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("lojadompedro");
    public List<Menu> getMenus() throws Exception{
        List<Menu>menu;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        menu = em.createQuery("from Menu").getResultList();
        em.getTransaction().commit();
        em.clear();
        em.close();
        
        if(menu==null || menu.isEmpty() || menu.equals("") ){
            throw new Exception("Sem Usuários cadastrados!");            
        }
        
        return menu;
    }
    public List<Menu> getMenus(String login){
        
            List<Menu>Menu;

            EntityManager en = emf.createEntityManager();
            en.getTransaction().begin();
            if(login == null || login.isEmpty()){
               Menu = en.createQuery("select menu.link, menu.menu, u.nome from Menu menu join Usuario u on u.grau >= menu.nivelacesso where u.login =:login").setParameter("login", "Default").getResultList();

            }else{
               Menu = en.createQuery("select menu.link, menu.menu, u.nome, u.grau from Menu menu join Usuario u on u.grau >= menu.nivelacesso where u.login =:login").setParameter("login", login).getResultList();
            }
            en.getTransaction().commit();
            en.clear();
            en.close();
             
            
            
           return Menu;
        
    }
}
