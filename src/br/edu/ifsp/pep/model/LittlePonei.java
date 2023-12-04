/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.model;

/**
 *
 * @author Abipeh
 */
public class LittlePonei extends Geral implements Runnable {

    public LittlePonei(int x, int y, int vidaDano, boolean visivel, String caminhoImagem) {
        super(x, y, vidaDano, visivel, caminhoImagem);
    }

    @Override
    public void run() {
        while (vidaDano > 0) {
            visivel = false;
        }
    }

}
