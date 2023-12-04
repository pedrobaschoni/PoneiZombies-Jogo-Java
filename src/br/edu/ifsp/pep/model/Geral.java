package br.edu.ifsp.pep.model;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public abstract class Geral {
    
    protected int x;
    protected int y;
    protected int altura;
    protected int largura;
    protected int vidaDano;
    protected Image imagem;
    protected boolean visivel;
    protected String caminhoImagem;

    public Geral() {
    }
    
    @SuppressWarnings("")
    public Geral(int x, int y, int vidaDano, boolean visivel, String caminhoImagem) {
        this.x = x;
        this.y = y;
        this.vidaDano = vidaDano;
        this.visivel = visivel;
        this.caminhoImagem = caminhoImagem;
        getCaminhoImagem();
    }
    public void setCaminhoImagem(String caminhoImagem){
        this.imagem = new ImageIcon(getClass().getResource(caminhoImagem)).getImage();
    }
    public void getCaminhoImagem() { //Serve para carregar a imagem, e pegar sua altura e largura
        this.imagem = new ImageIcon(getClass().getResource(caminhoImagem)).getImage();
        this.altura = this.imagem.getHeight(null);
        this.largura = this.imagem.getWidth(null);
    }
    
    public Rectangle getLimiteImagem() { //Ele pega a imagem e desenha um retangulo na imagem (que utilizaremos para checar a colisão)
        return new Rectangle(x, y, largura, altura);
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getVidaDano() {
        return vidaDano;
    }

    public void setVidaDano(int vidaDano) {
        this.vidaDano = vidaDano;
    }

    public Image getImagem() {
        return imagem;
    }

    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

    public boolean isVisivel() {
        return visivel;
    }

    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
    }
     
}
