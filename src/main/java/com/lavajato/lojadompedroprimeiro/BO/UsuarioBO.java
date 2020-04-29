/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavajato.lojadompedroprimeiro.BO;

import com.lavajato.lojadompedroprimeiro.Entidades.Usuario;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author gustavo
 */
public class UsuarioBO {
    private static final EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("lojadompedro");
    
    public List<Usuario> getCaixa() throws Exception{
        List<Usuario>usuario;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        usuario = em.createQuery("from Usuario where ativo= 1 and login != 'Admin' ").getResultList();
        em.getTransaction().commit();
        em.clear();
        em.close();
        
        if(usuario==null || usuario.isEmpty() || usuario.equals("") ){
            throw new Exception("Sem Usuários cadastrados!");            
        }
        
        return usuario;
    }
    public void cadastrarUsuário (String nome, String login, String senha, String grau ) throws Exception{ 
        EntityManager em = emf.createEntityManager();
        if(nome==null || nome.isEmpty() || nome.equals("") ){
            throw new Exception ("Não foi informado o nome do Usuário!"); 
            
        }
        if(login==null || login.isEmpty() || login.equals("") ){
            throw new Exception("Não foi informado o login do Usuário!");            
        }
        if(senha==null || senha.isEmpty() || senha.equals("") ){
            throw new Exception("Não foi informado a senha do Usuário!");            
        }
        if(grau==null || grau.isEmpty() || grau.equals("") ){
            throw new Exception("Não foi informado o grau do Usuário!");            
        }
        
        em.getTransaction().begin();
        
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setLogin(login);
        usuario.setSenha(senha);
        usuario.setGrau(grau);
        usuario.setAtivo(Boolean.TRUE);
       
        em.persist(usuario);
        em.getTransaction().commit();
        
        em.clear();
        em.close();              
        
    }
    public void editarUsuario (String idusuario, String nome, String login, String senha, String grau) throws Exception{
        EntityManager em = emf.createEntityManager(); 
         
        if(nome==null || nome.isEmpty() || nome.equals("") ){
            throw new Exception ("Não foi informado o nome do Usuário!");             
        }
        if(login==null || login.isEmpty() || login.equals("") ){
            throw new Exception("Não foi informado o login do Usuário!");            
        }
        if(senha==null || senha.isEmpty() || senha.equals("") ){
            throw new Exception("Não foi informado a senha do Usuário!");            
        }
        if(grau==null || grau.isEmpty() || grau.equals("") ){
            throw new Exception("Não foi informado o grau do Usuário!");            
        }
        
        em.getTransaction().begin();
        
        Usuario usuario = em.find(Usuario.class, Long.valueOf(idusuario));
        usuario.setNome(nome);
        usuario.setLogin(login);
        usuario.setSenha(senha);
        usuario.setGrau(grau);
        
        em.merge(usuario);
        
        em.getTransaction().commit();        
        em.clear();
        em.close();
    }
    public Boolean excluirUsuario(String idusuario)throws Exception{
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        if(idusuario==null || idusuario.isEmpty() || idusuario.equals("") ){
            throw new Exception("Erro ao desativar Usuário, id não foi informado");            
        }
        
        Usuario usuario = em.getReference(Usuario.class, Long.valueOf(idusuario));
        em.remove(usuario);
        
        em.getTransaction().commit();
        em.clear();
        em.close();
         
        return true;
        
    }
    public Usuario getUsuario(String idusuario)throws Exception{
        Usuario usuario;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        usuario = em.find(Usuario.class,Long.valueOf(idusuario));
        em.getTransaction().commit();
        em.clear();
        em.close();
        
        if(usuario==null   || usuario.equals("") ){
            throw new Exception("Erro ao carregar Usuário, id não foi informado");            
        }        
        return usuario;
    }
    public List<Usuario> getLogin(String login, String senha) throws Exception {
        List<Usuario> Login;
        EntityManager em = emf.createEntityManager(); 
        em.getTransaction().begin();
         
        Login = em.createQuery("SELECT u.nome, u.grau FROM Usuario u where u.login=:login and u.senha=:senha")
                                .setParameter("login", login)
                                .setParameter("senha", senha)
                                .getResultList();

        em.getTransaction().commit();
        em.clear();
        em.close();
        
        if(Login == null || Login.isEmpty()){
          throw new Exception("Login ou senha incorreta!");
                    
         } 
        return Login; 
    }
    public List<Usuario> getPermissao1(String login) throws Exception {
        List<Usuario> Login;
        EntityManager em = emf.createEntityManager(); 
        em.getTransaction().begin();
         
        Login = em.createQuery("SELECT u.nome, u.grau FROM Usuario u where u.login=:login and u.grau >= '1'")
                                .setParameter("login", login)
                                .getResultList();

        em.getTransaction().commit();
        em.clear();
        em.close();
        
        if(Login == null || Login.isEmpty()){
          throw new Exception("Irmão, você não tem permissão para acessar esta pagina!<br> Se acha que não deveria ver essa mensagem, entre em contato com seu superior!");                    
         } 
        return Login; 
    }
    public List<Usuario> getPermissao2(String login) throws Exception {
        List<Usuario> Login;
        EntityManager em = emf.createEntityManager(); 
        em.getTransaction().begin();
         
        Login = em.createQuery("SELECT u.nome, u.grau FROM Usuario u where u.login=:login and u.grau >= '2'")
                                .setParameter("login", login)
                                .getResultList();

        em.getTransaction().commit();
        em.clear();
        em.close();
        
        if(Login == null || Login.isEmpty()){
          throw new Exception("Irmão, você não tem permissão para acessar esta pagina!<br> Se acha que não deveria ver essa mensagem, entre em contato com seu superior!");                    
         } 
        return Login; 
    }
    public List<Usuario> getPermissao3(String login) throws Exception {
        List<Usuario> Login;
        EntityManager em = emf.createEntityManager(); 
        em.getTransaction().begin();
         
        Login = em.createQuery("SELECT u.nome, u.grau FROM Usuario u where u.login=:login and u.grau >= '3'")
                                .setParameter("login", login)
                                .getResultList();

        em.getTransaction().commit();
        em.clear();
        em.close();
        
        if(Login == null || Login.isEmpty()){
          throw new Exception("Irmão, você não tem permissão para acessar esta pagina!<br> Se acha que não deveria ver essa mensagem, entre em contato com seu superior!");                    
         } 
        return Login; 
    }
    public List<Usuario> getPermissao4(String login) throws Exception {
        List<Usuario> Login;
        EntityManager em = emf.createEntityManager(); 
        em.getTransaction().begin();
         
        Login = em.createQuery("SELECT u.nome, u.grau FROM Usuario u where u.login=:login and u.grau >= '4'")
                                .setParameter("login", login)
                                .getResultList();
        

        em.getTransaction().commit();
        em.clear();
        em.close();
        
        if(Login == null || Login.isEmpty()){ 
          throw new Exception("Irmão, você não tem permissão para acessar esta pagina!<br> Se acha que não deveria ver essa mensagem, entre em contato com seu superior!");                    
        }
              
        return Login; 
    }
     
}
