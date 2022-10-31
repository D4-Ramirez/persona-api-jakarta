/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.javeriana.as.payara.jakarta.personapp;

import co.edu.javeriana.as.payara.jakarta.personapp.ejb.action.PersonaEJB;
import co.edu.javeriana.as.payara.jakarta.personapp.ejb.entity.Persona;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author davis
 */
@ManagedBean(name = "myPersonaController")
@RequestScoped
public class PersonaController {
    
    // ======================================
    // =             Attributes             =
    // ======================================

    @EJB
    private PersonaEJB personaEJB;

    private Persona persona = new Persona();
    private List<Persona> personaList = new ArrayList<Persona>();

    // ======================================
    // =           Public Methods           =
    // ======================================

    public String regresar() {
        return "regresar";
    }
    
    public String doNewPersonaForm() {
        return "newPersona.xhtml";
    }

    public String doCreatePersona() {
        System.out.println("persona:" + persona);
        persona = personaEJB.crearPersona(persona);
        personaList = personaEJB.findPersona();
        return "newPersonaxhtml";
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

}
