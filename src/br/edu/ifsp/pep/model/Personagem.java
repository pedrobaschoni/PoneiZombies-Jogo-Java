package br.edu.ifsp.pep.model;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Personagem extends Geral {

    private int personagemX;
    private int personagemY;
    private int quantTiro = 0;
    private List<Tiro> tiros = new ArrayList<>();
    private boolean atirar = true;

    public Personagem(int x, int y, int vidaDano, boolean visivel, String caminhoImagem) {
        super(x, y, vidaDano, visivel, caminhoImagem);
    }

    public List<Tiro> getTiro() {
        return this.tiros;
    }

    public void Atirar(boolean atirar) {
        this.atirar = atirar;
    }

    public int getQuantTiro() {
        return quantTiro;
    }

    public void PressAndar(KeyEvent evento) {
        switch (evento.getKeyCode()) {
            case KeyEvent.VK_W:
                personagemY = -3;
                break;

            case KeyEvent.VK_A:
                personagemX = -3;
                break;

            case KeyEvent.VK_D:
                personagemX = 3;
                break;

            case KeyEvent.VK_S:
                personagemY = +3;
                break;

            case KeyEvent.VK_UP:
                personagemY = -3;
                break;

            case KeyEvent.VK_LEFT:
                personagemX = -3;
                break;

            case KeyEvent.VK_RIGHT:
                personagemX = 3;
                break;

            case KeyEvent.VK_DOWN:
                personagemY = +3;
                break;

            case KeyEvent.VK_R:
                if (quantTiro == 5) {
                    quantTiro = 0;
                }
                break;
            case KeyEvent.VK_SPACE:
                if (this.atirar && quantTiro < 5) {
                    Tiro tiro = new Tiro(x + largura / 2 + 80, y + 38, 1, true, "/br/edu/ifsp/pep/imagem/BalaPistola.png");
                    tiros.add(tiro);
                    Thread tiroThread = new Thread(tiro);
                    tiroThread.start();
                    quantTiro++;
                    atirar = false;
                }
                break;
        }
    }

    public void SoltarAndar(KeyEvent evento) {
        switch (evento.getKeyCode()) {
            case KeyEvent.VK_W:
                personagemY = 0;
                break;

            case KeyEvent.VK_A:
                personagemX = 0;
                break;

            case KeyEvent.VK_D:
                personagemX = 0;
                break;

            case KeyEvent.VK_S:
                personagemY = 0;
                break;

            case KeyEvent.VK_UP:
                personagemY = 0;
                break;

            case KeyEvent.VK_LEFT:
                personagemX = 0;
                break;

            case KeyEvent.VK_RIGHT:
                personagemX = 0;
                break;

            case KeyEvent.VK_DOWN:
                personagemY = 0;
                break;
        }
    }

    public void atualizarPersonagem() {
        this.x += personagemX;
        this.y += personagemY;

        if (this.y <= 160) {
            y = 160;
        }

        if (this.y >= 370) {
            y = 370;
        }

        if (this.x >= 850) {
            x = 850;
        }

        if (this.x <= 25) {
            x = 25;
        }

    }
}
