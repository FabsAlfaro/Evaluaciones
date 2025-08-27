/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebaproductos;

/**
 *
 * @author Programador
 */
public class Producto {
    
    int id;
    String nombre;
    String descripcion;
    double precio;
    
    public Producto(int id, String nombre, String descripcion, double precio ){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getDescripcion(){
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }
    
    public void setID(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
     public String toString() {
        return "\n ID: "+ id +"\n Nombre: "+ nombre +"\n Descripcion: "+ descripcion+ "\n Precio: $"+ precio;}   
    
}
