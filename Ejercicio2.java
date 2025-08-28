/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio2;

import java.util.Scanner;

    public class Ejercicio2 { 
        public static void imprimirSerie(){
        int fin;
        int a = 0;
        int b = 1;
        int siguiente;
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Ingresa el numero de términos que deseas imprimir: ");
        fin = entrada.nextInt();
        
        if (fin >= 1) System.out.println(a);
        if (fin >= 2) System.out.println(b);
        
            for(int i=3; i<=fin; i++ ){
                siguiente = a + b;
                System.out.println(siguiente);
                a= b;
                b= siguiente;               
            }
    }    
     
        public static int fibonacci(int n) {   
        
        if(n <=1){
        return n; 
        }  
         
        int a = 0;
        int b = 1;
        int siguiente;
        
            for(int i=2; i<=n; i++ ){
                siguiente = a + b;
                a= b;
                b= siguiente;               
            } return b;                
    }

    public static void main(String[] args) {
            int opcion;
            
            Scanner entrada2 = new Scanner(System.in);
            
            System.out.println("Selecciona 1 para imprimir la secuencia completa de la serie ");
            System.out.println("Selecciona 2 para que muestre el término que tu le indiques ");
            opcion = entrada2.nextInt();
            
            switch(opcion){
            
            case 1:    
            imprimirSerie();
            break;
            
            case 2:
                
            Scanner entrada = new Scanner(System.in);
            System.out.print("Ingresa el numero de término que deseas imprimir: ");
            int n = entrada.nextInt();
            int resultado = fibonacci(n); 
            System.out.println("El término numero " + n + " de la serie Fibonacci es: " + resultado);
            
            break;
            
            default:
            System.out.println("Opcion no valida");
            }           
            entrada2.close();
        }        
      
    }
   
