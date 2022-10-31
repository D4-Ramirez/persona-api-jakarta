/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.javeriana.as.payara.jakarta.personapp.ejb.action;

import co.edu.javeriana.as.payara.jakarta.personapp.ejb.entity.Persona;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author davis
 */
public class PersonaEJB {
    @PersistenceContext(unitName = "Persona_PU")
    private EntityManager em;
    
    public List<Persona> findPersona() {
        Query query = em.createNamedQuery("findAllPersonas");
        return query.getResultList();
    }
    
    public Persona crearPersona(Persona persona) {
        em.persist(persona);
        return persona;
    }
}
