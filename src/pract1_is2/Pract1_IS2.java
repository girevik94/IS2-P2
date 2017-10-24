/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pract1_is2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Pract1_IS2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Miembro mi = new Miembro();
        Moto mo = new Moto();
        Cesion ce = new Cesion();
        int opcion;
        Scanner sc = new Scanner(System.in);
        float importemaximo;
        
        System.out.println("Introduce el importe maximo de las compras: ");
        importemaximo = sc.nextFloat();
        do{
            System.out.println("1.Registrar un nuevo miembro.");
            System.out.println("2.Registrar una nueva motocicleta");
            System.out.println("3.Registrar una cesión");
            System.out.println("4.Listar en pantalla los miembros con motos en posesion");
            System.out.println("5.Listar todas las motos");
            System.out.println("6.Mostrar las cesiones realizadas");
            System.out.println("7.Anyadir gastos a moto");
            System.out.println("8.Eliminar miembro");
            System.out.println("9.Miembros con más cesiones");
            System.out.println("10.Salir del programa\n");
            
            System.out.println("Elija la opcion deseada: ");
            opcion = sc.nextInt();
            
            switch(opcion){
                case 1:
                    mi.addMiembro();
                    break;
                case 2:
                    mi.MostrarMiembros();
                    mo.addMoto(mi.getArrayMiembros(), importemaximo);
                    break;
                case 3:
                    mi.MostrarMiembros();
                    mo.MostrarMotos();
                    ce.addCesion(mi.getArrayMiembros(), mo.getArrayMotos(), importemaximo);
                    break;
                case 4:
                    mi.MostrarMiembros();
                    break;
                case 5:
                    mo.MostrarMotos();
                    break;
                case 6:
                    ce.MostrarCesion();
                    break;
                case 7:
                    mo.AumentarGastos();
                    break;
                case 8:
                    mi.MostrarMiembros();
                    mo.MostrarMotos();
                    mi.eliminarMiembro(mi.getArrayMiembros(), importemaximo);
                    break;
                case 9:
                    ce.miembrosConMasCesiones(mi.getArrayMiembros(), mo.getArrayMotos());
                    break;
                case 10:
                    String texto = mi.toString();
                    texto += mo.toString();
                    texto += ce.toString();
                    try{
                        File archivo = new File("C:\\IS2\\archivo.txt");
                        FileWriter w = new FileWriter(archivo);
                        BufferedWriter b = new BufferedWriter(w);
                        PrintWriter p = new PrintWriter(b);
                        if(archivo.createNewFile())
                            p.write(texto);
                        System.out.println("Se ha creado el archivo");
                    }catch(IOException er){
                        System.err.println("No se puede crear el archivo"+er);
                    }
                    System.exit(0);
                    break;
                
                default:
                    System.out.println("ERROR");
                    break;
            }
            
        }while (opcion != 10);
    }
    
}
