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
    private float gastos;
    ArrayList <Moto> ListaMotos = new ArrayList<Moto> ();
    
    public Moto (int moto, String modelomoto, int cilindradamoto, float preciomoto, int miembro, float gastos){
    
        this.idmoto = moto;
        this.modelomoto = modelomoto;
        this.cilindradamoto = cilindradamoto;
        this.preciomoto = preciomoto;
        this.miembro = miembro;
        this.gastos = gastos;
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
    
    public float getGastos(){
        return gastos;
    }
    
    public void setGastos(float gastos){
        this.gastos = gastos;
    }
    
    public ArrayList getArrayMotos(){
        return ListaMotos;
    }
    
    public void addMoto(ArrayList miembros, float importemaximo){
        boolean posible;
        
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
        System.out.println("Precio de los gastos: ");
        gastos = sc.nextFloat();
        
        Cesion ce = new Cesion();
        posible = ce.anyadirMoto(miembro, preciomoto, miembros, ListaMotos, importemaximo);
        Moto m = new Moto( idmoto, modelomoto, cilindradamoto, preciomoto, miembro, gastos);
        
        if (posible == true)
            this.ListaMotos.add(m);
        
        //return m;
    }
    
    public void MostrarMotos(){
        
        for(int i=0; i<ListaMotos.size(); i++){
            System.out.println(toString(ListaMotos.get(i)));
        }
    }
    
    public String toString(Moto m){
        return "ID Moto: " + m.getIdMoto() + "\tMoto: " + m.getModeloMoto() + "\tCilindrada: " + m.getCilindradaMoto() + "\tPrecio:"
                + m.getPrecioMoto() + "\tPropietario Actual: " + m.getMiembro() + "\tGastos Adicionales: " + m.getGastos() + "\n";
    }
    
    public void AumentarGastos(){
        int moto;
        float aungastos, gastos_aux;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("ID de la moto: ");
        moto = sc.nextInt();
        System.out.println("Cual es el aumento de los gastos: ");
        aungastos = sc.nextFloat();
        
        Moto mo = new Moto();
        mo = (ListaMotos.get(moto-1));
        
        gastos_aux = mo.getGastos();
        gastos_aux += aungastos;
        
        mo.setGastos(gastos_aux);
    }
    
    public void cambiarMiembroMoto(int idmiembro, ArrayList miembros, float importemaximo){
        Moto mo = new Moto();
        Cesion ce = new Cesion();
        Scanner sc = new Scanner(System.in);
        int aux, id = 0;
        float preciomoto;
        boolean posible = false;
        for(int i = 0; i < ListaMotos.size(); i++){
            mo = ListaMotos.get(i);
            aux = mo.getMiembro();
            if(aux == idmiembro){
                do{
                    System.out.println("Dime a quien cedo esta moto: ");
                    id = sc.nextInt();
                    preciomoto = mo.getPrecioMoto();
                    posible = ce.anyadirMoto(id, preciomoto, miembros, ListaMotos, importemaximo);
                    
                    if (posible == true){
                        mo.setMiembro(id);
                    }
                }while (posible == false);
                
            }
        }
    }
}
