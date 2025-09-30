/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Programador
 */
public class Main {

public static void main(String[] args) {
    
        Departamento departamento1 = new Departamento("Recursos Humanos");
        Departamento departamento2 = new Departamento("Desarrollo");
        Departamento departamento3 = new Departamento("Ventas");
        
        TipoDeEmpleado base = new TipoDeEmpleado("BASE");
        TipoDeEmpleado eventual = new TipoDeEmpleado("EVENTUAL");

        List<Empleado> empleados = new ArrayList<>();
      
        empleados.add(new Empleado("Luis", "Martinez", 3, base, LocalDate.of(2019, 3, 25), departamento3));
        empleados.add(new Empleado("Laura", "Lopez", 4, eventual, LocalDate.of(2022, 4, 5), departamento1));
        empleados.add(new Empleado("Carlos", "Garcia", 5,base, LocalDate.of(2018, 5, 20), departamento2));
        empleados.add(new Empleado("Maria", "Rodriguez", 6, eventual, LocalDate.of(2020, 6, 30), departamento3));
        empleados.add(new Empleado("Jose", "Fernandez", 7, base, LocalDate.of(2021, 7, 10), departamento1));
        empleados.add(new Empleado("Lucia", "Hernandez", 8, base, LocalDate.of(2022, 8, 15), departamento2));
        empleados.add(new Empleado("Pedro", "Jimenez", 9, eventual, LocalDate.of(2019, 9, 25), departamento3));
        empleados.add(new Empleado("Sara", "Ruiz", 10, eventual, LocalDate.of(2018, 10, 5), departamento1));
        empleados.add(new Empleado("Fabiola", "Alfaro", 11, base, LocalDate.of(2025, 4, 14), departamento1));
        empleados.add(new Empleado("Sofia", "Perez", 12, base, LocalDate.of(2024, 2, 18), departamento2));
        
        System.out.println("Filtrar por número de empleado: 5 ");
        empleados.stream()
                .filter(e -> e.getNumeroEmpleado() == 5)
                .forEach(System.out::println);

        System.out.println("\nFiltrar por tipo de empleado: BASE");
        empleados.stream()
                .filter(e -> e.getTipo().getNombre().equals("BASE"))
                .forEach(System.out::println);

        System.out.println("\nFiltrar nombre por primer letra: 'M' ");
        empleados.stream()
                .filter(e -> e.getNombre().startsWith("M"))
                .forEach(System.out::println);
        
                System.out.println("\nFiltrar Apellido por primer letra: 'F' ");
        empleados.stream()
                .filter(e -> e.getApellido().startsWith("F"))
                .forEach(System.out::println);
        
        
        LocalDate fechaBuscada = LocalDate.of(2019, 3, 25);
        System.out.println("\nFiltrar por fecha de ingreso: 2019-03-25");
        
        List<Empleado> resultado = empleados.stream()
                .filter(e -> e.getFechaIngreso().equals(fechaBuscada))
                .toList();

        if (resultado.isEmpty()) {
            System.out.println("No existen empleados con esa fecha de ingreso.");
        } else {
            resultado.forEach(System.out::println);
        }
        
    }
}

