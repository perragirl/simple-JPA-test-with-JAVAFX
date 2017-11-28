  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db;

import com.entity.Login;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author perra
 */
public class LoginQuery {
    EntityManager em;
    EntityManagerFactory emf;

    public LoginQuery() {
        emf = Persistence.createEntityManagerFactory("Login_Example-JPAPU");
        em = emf.createEntityManager();
        em.getTransaction();
    }
    
    public List<Login> listLogin(){
        return em.createNamedQuery("Login.findAll").getResultList();
    }
    
}
