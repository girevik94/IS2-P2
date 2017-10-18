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
        ArrayList <Moto> ListaMotos = new ArrayList<Moto>();
        ArrayList <Miembro> ListaMiembros = new ArrayList<Miembro>();
        ArrayList <Cesion> ListaCesion = new ArrayList<Cesion> ();
        
        int opcion = 0;
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
            System.out.println("7.Salir del programa/n");
            
            System.out.println("Elija la opcion deseada: ");
            opcion = sc.nextInt();
            
            switch(opcion){
                case 1:
                    mi.addMiembro();
                    break;
                case 2:
                    ListaMiembros = mi.getArrayMiembros();
                    mo.addMoto(ListaMiembros, importemaximo);
                    break;
                case 3:
                    ListaMiembros = mi.getArrayMiembros();
                    ListaMotos = mo.getArrayMotos();
                    ce.addCesion(ListaMiembros, ListaMotos,importemaximo);
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
                    try{
                        File archivo = new File("C:\\IS2\\archivo.txt");
                        FileWriter w = new FileWriter(archivo);
                        PrintWriter p = new PrintWriter(w);
                        for(int i=0; i < ListaMiembros.size(); i++){
                            p.println(ListaMiembros.get(i));
                        }
                        for(int i=0; i < ListaMotos.size(); i++){
                            p.println(ListaMotos.get(i));
                        }
                        for(int i=0; i < ListaCesion.size(); i++){
                            p.println(ListaCesion.get(i));
                        }
                        if(archivo.createNewFile())
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
            
        }while (opcion != 7);
    }
    
}
