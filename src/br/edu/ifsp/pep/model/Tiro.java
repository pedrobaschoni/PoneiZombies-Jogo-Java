/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.model;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abipeh
 */
public class Tiro extends Geral implements Runnable{

    public Tiro() {
    }

    public Tiro(int x, int y, int vidaDano, boolean visivel, String caminhoImagem){
        super(x, y, vidaDano, visivel, caminhoImagem);
    }
    
    public void MoverBala(){
        x+=3;
        try {
            Thread.sleep(2);
        } catch (InterruptedException ex) {
            Logger.getLogger(Tiro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
        while(vidaDano!=0){    
            MoverBala();
            
        }
        visivel=false;
      
    }
   
    
}
