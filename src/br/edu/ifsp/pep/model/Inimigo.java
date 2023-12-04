/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.model;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Rectangle;

/**
 *
 * @author Aluno
 */
public class Inimigo extends Geral implements Runnable {

    private int velocidade;

    public Inimigo(int x, int y, int vidaDano, boolean visivel, String caminhoImagem) {
        super(x, y, vidaDano, visivel, caminhoImagem);
        Random gerador = new Random();
        velocidade = gerador.nextInt(3) + 1;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public void mover() {
        x -= velocidade;
        try {
            Thread.sleep(25);
        } catch (InterruptedException ex) {
            Logger.getLogger(Tiro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized boolean verificaTiro(Tiro tiro) {
        Rectangle retanguloInimigo = new Rectangle(x, y, largura, altura);
        Rectangle retanguloTiro = new Rectangle(tiro.getX(), tiro.getY(), tiro.getLargura(), tiro.getAltura());

        if (retanguloInimigo.intersects(retanguloTiro)) {
            vidaDano -= 1;
            tiro.setVisivel(false);
            this.setVisivel(false);
            return true;
        }
        
        return false;
    }

    public synchronized void verificaColisao(LittlePonei ponei) {
        Rectangle retanguloInimigo = new Rectangle(x, y, largura, altura);
        Rectangle retanguloPonei = new Rectangle(ponei.getX() - 50, ponei.getY() - 50, ponei.getLargura(), ponei.getAltura());

        if (retanguloInimigo.intersects(retanguloPonei)) {
            vidaDano -= 1;
            ponei.setVisivel(false);
        }
    }

    public void verificaMorte(Personagem personagem) {
        Rectangle retanguloInimigo = new Rectangle(x, y, largura, altura);
        Rectangle retanguloPersonagem = new Rectangle(personagem.getX() - 60, personagem.getY() + 40, personagem.getLargura(), personagem.getAltura());

        if (retanguloInimigo.intersects(retanguloPersonagem)) {

            vidaDano -= 1;
            personagem.setVisivel(false);
        }
    }

    @Override
    public void run() {
        while (vidaDano > 0) {
            mover();
        }
        visivel = false;
    }
}
