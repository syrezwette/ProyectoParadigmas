package co.poli.edu.sistemaGestionTareas.servicios;

import java.io.*;
import java.util.*;

import co.poli.edu.sistemaGestionTareas.modelo.Usuario;

/**
 * 
 */
public class ImplementacionOperacion implements OperacionArchivo {

    /**
     * Default constructor
     */
    public ImplementacionOperacion() {
    }

	@Override
	public void serializar(Usuario[] Usuario, String path, String name) {
  // TODO implement OperacionArchivo.serializar() here
    	
    	try {
    		
    		FileOutputStream fos = new FileOutputStream(path + name);
    		ObjectOutputStream oos = new ObjectOutputStream(fos);
    		oos.writeObject(Usuario);
    		oos.close();
    		fos.close();
    	}catch (IOException ioe) {
    		ioe.printStackTrace();
    	}
   
    
	}

	@Override
	public Usuario[] Deserializar(String path, String name) {
		Usuario[]a=null;
    	try {
    		FileInputStream fis = new FileInputStream(path + name);
    		ObjectInputStream ois = new ObjectInputStream(fis);
    		
    		a = (Usuario[]) ois.readObject();
    		
    		ois.close();
    		fis.close();
    		
    	} catch (IOException ioe ) {
    		ioe.printStackTrace();
    		
    	}catch (ClassNotFoundException c) {
    		System.out.println("Class not found");
    		c.printStackTrace();
    		
    	}
    	return a;
    }

	

}