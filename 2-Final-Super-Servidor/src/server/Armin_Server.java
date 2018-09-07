package server;
// Solo para publicar Clases
import java.rmi.*;
import java.rmi.registry.LocateRegistry;

import app.MainSistemaSupermercado;
import interfaz.*;


public class Armin_Server {
    
	TDAManejoDatos objetoRemoto;
	
	public static void main(String[] args)
	{
		new Armin_Server();
	}
	
	public Armin_Server() {
		iniciar();
	}
	
    public void iniciar() {
    	try {
    		LocateRegistry.createRegistry(1099);	
    		
            TDAManejoDatos gestionDatos = new MainSistemaSupermercado();
            Naming.rebind ("//localhost/GestionDatos", gestionDatos);
            System.out.println("------------------------------------");
            System.out.println("Fijado en //localhost/GestionDatos");
            System.out.println("------------------------------------");
            
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
