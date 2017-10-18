/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pract1_is2;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author alumno
 */
public class Miembro {
    
    private int idmiembro = 0;
    private String nombremiembro;
    private int numeromotos = 0;
    private float importemotostotal = 0;
    ArrayList <Miembro> ListaMiembros = new ArrayList<Miembro>();
    
    public Miembro(int miembro, String nombremiembro, int numeromotos, float importemotostotal){
        
        this.idmiembro = miembro;
        this.nombremiembro = nombremiembro;
        this.numeromotos = numeromotos;
        this.importemotostotal = importemotostotal;
    }

    Miembro() {
    }
    
    public String getNombreMiembro (){
        return nombremiembro;
    }
    
    public int getNumeroMotos (){
        return numeromotos;
    }
    
    public int getIdmiembro(){
        return idmiembro;
    }
    
    public float getImporteMotosTotal(){
       return importemotostotal;
    } 
    
    public void setNombreMiembro(String nombremiembro){
        this.nombremiembro = nombremiembro;
    }
    
    public void setIdMiembro(int idmiembro){
        this.idmiembro = idmiembro;
    }
    
    public void setNumeromotos(int numeromotos){
        this.numeromotos = numeromotos;
    }
    
    public void setImporteMotosTotal(float importemotostotal){
        this.importemotostotal = importemotostotal;
    }
    
    public Miembro addMiembro(){
        idmiembro++;
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserta el nombre del Cliente: ");
        nombremiembro = sc.nextLine();        
        
        Miembro mi = new Miembro(idmiembro, nombremiembro, numeromotos, importemotostotal);
        this.ListaMiembros.add(mi);
        
        return mi;
    }
    
    public void MostrarMiembros(){
        
        for(int i=0; i<ListaMiembros.size(); i++){
            System.out.println(toString(ListaMiembros.get(i)));
        }
    }
    
    public String toString(Miembro mi){
        return "ID Miembro: " + mi.getIdmiembro() + "\tNombre Miembro: " + mi.getNombreMiembro() + "\tNumero Motos: " + mi.getNumeroMotos() +
               "\tImporte Total Motos: " + mi.getImporteMotosTotal() + "\n";
    }
    
    public ArrayList getArrayMiembros(){
        return ListaMiembros;
    }
}
