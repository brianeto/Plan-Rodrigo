/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.plan.frontend.controllers;

import co.plan.backend.persistence.entities.Vehiculo;
import co.plan.backend.persistence.facades.VehiculoFacadeLocal;
import co.plan.frontend.logic.IManagedBean;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Brayan
 */
@Named(value = "vehiculoManagedBean")
@ViewScoped
public class VehiculoManagedBean implements Serializable, IManagedBean<Vehiculo>{
    
    @EJB private VehiculoFacadeLocal vehiculoFacadeLocal;
    private Vehiculo vehiculo;
    
    public VehiculoManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        vehiculo = null;
    } 

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    

    public List<Vehiculo> listarVehiculo() {
        return vehiculoFacadeLocal.findAll();
    }
    
    public void registrar(){
        vehiculoFacadeLocal.create(vehiculo);
    }

    @Override
    public Vehiculo getObjectByKey(Integer key) {
        return vehiculoFacadeLocal.find(key);
    }
}