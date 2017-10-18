/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pract1_is2;


import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author alumno
 */
public class Cesion {
    private int idcesion = 0;
    private int idmoto, cliente1, cliente2;
    private Date fecha;
    ArrayList <Cesion> ListaCesion = new ArrayList<Cesion> ();
    private int num_motos_aux;
    private float imp_motos_aux;

    public Cesion(int cesion, int idmoto, int cliente1, int cliente2, Date fecha) {
        this.idcesion = cesion;
        this.idmoto = idmoto;
        this.cliente1 = cliente1;
        this.cliente2 = cliente2;
        this.fecha = fecha;
    }

    Cesion() {
    }
    
    public int getIdCesion (){
        return idcesion;
    }
    
    public void setIdCesion (int idcesion){
        this.idcesion = idcesion;
    }
    
    public int getIdMoto (int idmoto){
        return idmoto;
    }
    
    public void setIdMoto (int idmoto){
        this.idmoto = idmoto;
    }
    
    public int getIdCliente1 (int idcliente1){
        return cliente1;
    }
    
    public void setIdCliente1 (int idcliente1){
        this.cliente1 = cliente1;
    }
    
    public int getIdCliente2 (int idcliente2){
        return cliente2;
    }
    
    public void setIdCliente2 (int idcliente2){
        this.cliente2 = cliente2;
    }
    
    public Date getFecha(Date fecha){
        return fecha;
    }
    
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }
    
    public Cesion addCesion(ArrayList miembros, ArrayList motos, float importemaximo){
        idcesion++;
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserta el ID de la moto a ceder: ");
        idmoto = sc.nextInt();
        System.out.println("Inserta el ID del Cliente que cede la moto: ");
        cliente1 = sc.nextInt();
        System.out.println("Inserta el ID del Cliente que recibe la moto: ");
        cliente2 = sc.nextInt();
        
        Cesion ce = new Cesion(idcesion, idmoto, cliente1, cliente2, fecha);
        
        Moto moto;
        moto = ((Moto) motos.get(idmoto-1));
        Miembro clie1, cli2;
        cli2 = ((Miembro) miembros.get(cliente2-1));
        
        float importemoto = moto.getPrecioMoto();
        float importetotalcliente2 = cli2.getImporteMotosTotal();        
                
        if(importemoto + importetotalcliente2 <= importemaximo){
            
            this.ListaCesion.add(ce);
            anyadirMoto(cliente2, importemoto, miembros, motos, importemaximo);
            quitarMoto(cliente1, importemoto, miembros, motos);
            cambiarPropietario(motos, idmoto, cliente2);
        }
        
        else
            System.out.println("No se puede realizar la cesión.");
        
        return ce;
    }
    
    public void MostrarCesion(){
        
        for(int i=0; i<ListaCesion.size(); i++){
            System.out.println(toString(ListaCesion.get(i)));
        }
    }
    
    public String toString(Cesion ce){
        return "ID Cesion: " + ce.getIdCesion() + "\tID Moto Cedida: " + ce.getIdMoto(idmoto) + "\tID Cliente que cede la moto: " 
                + ce.getIdCliente1(cliente1) + "\tID Cliente que recibe la moto: " + ce.getIdCliente2(cliente2) + "\tFecha: " + ce.getFecha(fecha) + "\n";
    }
    
    public ArrayList getArrayCesion(){
        return ListaCesion;
    }
    
    public boolean anyadirMoto(int idcliente, float preciomoto, ArrayList miembros, ArrayList motos, float importemaximo){
        boolean posible;
        
        Miembro mi = new Miembro();
        mi = ((Miembro) miembros.get(idcliente - 1));        
        imp_motos_aux = mi.getImporteMotosTotal();
        imp_motos_aux += preciomoto;
        if (imp_motos_aux <= importemaximo){
            num_motos_aux = mi.getNumeroMotos();
            num_motos_aux++;
            mi.setNumeromotos(num_motos_aux);
            posible = true;
            mi.setImporteMotosTotal(imp_motos_aux);
        }
        else{
            System.out.println("No se ha podido anyadir la moto porque sobrepasa el importe maximo por cliente.");
            posible = false;
        }
            
        return posible;
    }
    
    public void quitarMoto(int idcliente, float preciomoto, ArrayList miembros, ArrayList motos){
        Miembro mi = new Miembro();
        mi = ((Miembro) miembros.get(idcliente-1));
        num_motos_aux = mi.getNumeroMotos();
        num_motos_aux--;
        mi.setNumeromotos(num_motos_aux);
        imp_motos_aux = mi.getImporteMotosTotal();
        imp_motos_aux -= preciomoto;
        mi.setImporteMotosTotal(imp_motos_aux);
    }
    
    public void cambiarPropietario(ArrayList motos, int moto, int idcliente){
        Moto mo = new Moto();
        mo = ((Moto) motos.get(moto-1));
        mo.setMiembro(idcliente);
    }
}
