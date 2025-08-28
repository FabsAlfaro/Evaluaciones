/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ejercicio;
import java.util.Scanner;

public class Ejercicio {
   
    public static void evaluarRango(){   
        int inicio; 
        int fin;
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Ingresa el rango Inicial: ");
        inicio = entrada.nextInt();
        
        System.out.print("Ingresa el rango Final: ");
        fin = entrada.nextInt();
        
        for(int i=inicio; i<=fin; i++ ){
            double fx = evaluarFuncion(i);
            System.out.println("x= " + i + " f(x)= " + fx);
        }       
    }
     
    public static double evaluarFuncion(int x) { 
        double resultado = (x*x)- 3 * x + 2;
        return resultado;       
    }
   
    public static void main(String[] args) {

        evaluarRango();
        
    }
}
