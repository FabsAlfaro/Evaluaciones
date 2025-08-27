/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pruebaproductos;

import java.util.*;

/**
 *
 * @author Programador
 */
public class PruebaProductos {

    
    private static final List<Producto> productos = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("  Sistema de Productos ");

        int opcion;
        do {
            System.out.println("\n Elige una opción: ");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            
            switch (opcion) {
                case 1: 
                    agregarProductos();
                    break;
                    
                case 2:
                    mostrarProductos();
                    break;
                    
                case 3:
                    eliminarProducto();
                    break;
                    
                case 4: 
                    System.out.println("\nFinalizar");
                    break;
                default:
                    System.out.println("\nOpción no válida.");
            }
            System.out.println();
        } while (opcion != 4);    
    }

    private static void agregarProductos(){
        
                System.out.print("\nIngrese ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                
                System.out.print("Ingrese nombre: ");
                String nombre = sc.nextLine();
                
                System.out.print("Ingrese descripcion: ");
                String descripcion = sc.nextLine();
                
                System.out.print("Ingrese precio sin símbolo de pesos: ");
                double precio = sc.nextDouble();

                
                Producto p = new Producto(id, nombre, descripcion, precio);
                productos.add(p);
                System.out.println("Producto agregado con éxito.");
                 
    }
    
        private static void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("\nNo hay productos registrados.");
        } else {
            System.out.println("\nLista de Productos ");
            for (Producto p : productos) {
                System.out.println(p);
            }
        }
    }

    private static void eliminarProducto() {
        System.out.print("\nIngrese el ID a eliminar: ");
        int id = sc.nextInt();
        sc.nextLine();

        Producto encontrado = null;
        for (Producto p : productos) {
            if (p.getId() == id) {
                encontrado = p;
            }
        }

        if (encontrado != null) {
            productos.remove(encontrado);
            System.out.println("Producto eliminado.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    
    }




}