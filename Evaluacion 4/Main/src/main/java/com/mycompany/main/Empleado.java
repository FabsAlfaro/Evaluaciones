/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.time.LocalDate;

/**
 *
 * @author Programador
 */
public class Empleado {
    
    private String nombre;
    private String apellido;
    private int numeroEmpleado;
    private TipoDeEmpleado tipo;
    private LocalDate fechaIngreso;
    private Departamento departamento;
    
    public Empleado(String nombre, String apellido, int numeroEmpleado, TipoDeEmpleado tipo, LocalDate fechaIngreso, Departamento departamento){
        
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroEmpleado = numeroEmpleado;
        this.tipo = tipo;
        this.fechaIngreso = fechaIngreso;
        this.departamento = departamento;
        
    }
    
    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public int getNumeroEmpleado(){
        return numeroEmpleado;
    }
    public TipoDeEmpleado getTipo(){
        return tipo;
    }
    public LocalDate getFechaIngreso(){
        return fechaIngreso;
    }
    public Departamento getDepartamento(){
        return departamento;
    }
     
    @Override
    public String toString(){
        return  "\nNombre: " + nombre + "\nApellido: " + apellido + "\nNumero de Empleado: " + numeroEmpleado +
                "\nTipo de Empleado: " + tipo + "\nFecha de ingreso: " + fechaIngreso + "\nDepartamento: " + departamento ;
    } 
}