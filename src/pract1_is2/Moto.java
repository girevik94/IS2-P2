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
public class Moto {
    
    private int idmoto = 0;
    private String modelomoto;
    private int cilindradamoto;
    private float preciomoto;
    private int miembro;
    ArrayList <Moto> ListaMotos = new ArrayList<Moto>();
    
    public Moto (int moto, String modelomoto, int cilindradamoto, float preciomoto, int miembro){
    
        this.idmoto = moto;
        this.modelomoto = modelomoto;
        this.cilindradamoto = cilindradamoto;
        this.preciomoto = preciomoto;
        this.miembro = miembro;
    }

    Moto() {
    }
    
    public int getMiembro(){
        return miembro;
    }
    
    public void setMiembro(int miembro){
        this.miembro = miembro;
    }
    
    public String getModeloMoto(){
        return modelomoto;
    }
    
    public int getCilindradaMoto(){
        return cilindradamoto;
    }
    
    public int getIdMoto(){
        return idmoto;
    }
    
    public float getPrecioMoto(){
        return preciomoto;
    }
    
    public void setModeloMoto(String modelomoto){
        this.modelomoto = modelomoto;
    }
    
    public void setIdMoto(int idmoto){
        this.idmoto = idmoto;
    }
    
    public void setCilindradaMoto(int cilindradamoto){
        this.cilindradamoto = cilindradamoto;
    }
    
    public void setPrecioMoto(float preciomoto){
        this.preciomoto = preciomoto;
    }
    
    public Moto addMoto(ArrayList miembros){
        idmoto++;
        Scanner sc = new Scanner(System.in);
        System.out.println("Modelo de la moto: ");
        modelomoto = sc.nextLine();
        System.out.println("Cilindrada de la moto: ");
        cilindradamoto = sc.nextInt();
        System.out.println("Precio de la moto: ");
        preciomoto = sc.nextFloat();
        System.out.println("Introduce el ID del propietario de la moto: ");
        miembro = sc.nextInt();
        
        Moto m = new Moto( idmoto, modelomoto, cilindradamoto, preciomoto, miembro);
        this.ListaMotos.add(m);
        
        Cesion ce = new Cesion();
        ce.anyadirMoto(miembro, preciomoto, miembros, ListaMotos);
        
        return m;
    }
    
    public void MostrarMotos(){
        
        for(int i=0; i<ListaMotos.size(); i++){
            System.out.println(toString(ListaMotos.get(i)));
        }
    }
    
    public String toString(Moto m){
        return "ID Moto: " + m.getIdMoto() + "\tMoto: " + m.getModeloMoto() + "\tCilindrada: " + m.getCilindradaMoto() + "\tPrecio:"
                + m.getPrecioMoto() + "\tPropietario Actual: " + m.getMiembro() + "\n";
    }
    
    public ArrayList getArrayMotos(){
        return ListaMotos;
    }
}
