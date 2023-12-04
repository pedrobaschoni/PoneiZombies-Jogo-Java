package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.controller.CriarTelaGameOver;
import br.edu.ifsp.pep.controller.CriarTelaInicial;
import br.edu.ifsp.pep.controller.CriarTelaVitoria;
import br.edu.ifsp.pep.model.Inimigo;
import br.edu.ifsp.pep.model.LittlePonei;
import br.edu.ifsp.pep.model.Personagem;
import br.edu.ifsp.pep.model.Tiro;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Jogo extends JPanel implements ActionListener {

    private Image PlanoDeFundo;
    private Personagem personagem;
    private Timer tempo;
    private List<Inimigo> inimigos = new ArrayList<>();
    private List<Inimigo> inimigosRemover = new ArrayList<>();
    private boolean isFimDeJogo = false;
    private LittlePonei littlePonei;
    private boolean telaInicialCriada = false;
    private boolean telaVitoriaCriada = false;

    public Jogo() {

        setFocusable(true);
        setDoubleBuffered(true);
        PlanoDeFundo = new ImageIcon(getClass()
                .getResource("/br/edu/ifsp/pep/imagem/TelaDeFundo.png"))
                .getImage(); //Cria um objeto da imagem e seta o caminho para o local que a imagem esta salva

        personagem = new Personagem(40, 300, 1, true, "/br/edu/ifsp/pep/imagem/Soldado.png");
        littlePonei = new LittlePonei(5, 250, 1, true, "/br/edu/ifsp/pep/imagem/littleponei.gif");
        tempo = new Timer(5, this); //Velocidade do jogo
        tempo.start();
        addKeyListener(new teclado());

        int x, y;
        Random gerador = new Random();
        for (int i = 0; i < 30; i++) {
            x = gerador.nextInt(1000) + 800;
            y = gerador.nextInt(180) + 180;
            Inimigo inimigo = new Inimigo(x, y, 1, true, "/br/edu/ifsp/pep/imagem/zumbi(2).gif");
            inimigos.add(inimigo);
            Thread inimigoThread = new Thread(inimigo);
            inimigoThread.start();
        }
    }

    @Override
    public void paint(Graphics graficos) { //Serve para ficar pintando a tela
        Graphics2D grafico2D = (Graphics2D) graficos; //Cria um objeto de imagem 2D
        grafico2D.drawImage(PlanoDeFundo, 0, 0, null); //Pinta o painel com a imagem setada no public Jogo()

        if (personagem.isVisivel()) {
            grafico2D.drawImage(personagem.getImagem(), personagem.getX(), personagem.getY(), this);
        } else {
            graficos.dispose();
            eventoOcorreu();
        }

        if (this.littlePonei.isVisivel()) {
            grafico2D.drawImage(littlePonei.getImagem(), littlePonei.getX(), littlePonei.getY(), this);

        } else {
            graficos.dispose();
            eventoOcorreu();
        }

        if (!personagem.getTiro().isEmpty()) {
            for (int i = 0; i < personagem.getTiro().size(); i++) {
                Tiro tiro = personagem.getTiro().get(i);
                if (tiro.isVisivel()) {
                    grafico2D.drawImage(tiro.getImagem(), tiro.getX(), tiro.getY(), this);
                }
            }
        }
        
        if (!inimigos.isEmpty()) {
            for (Inimigo inimigo : inimigos) {
                if (inimigo.isVisivel()) {
                    grafico2D.drawImage(inimigo.getImagem(), inimigo.getX(), inimigo.getY(), this);
                    if (!personagem.getTiro().isEmpty()) {
                        for (int i = 0; i < personagem.getTiro().size(); i++) {
                            Tiro tiro = personagem.getTiro().get(i);
                            if (tiro.isVisivel()) {
                                boolean verifica = false;
                                verifica = inimigo.verificaTiro(tiro);
                                if (verifica) {
                                    inimigosRemover.add(inimigo);
                                }
                            }

                        }
                    }
                    if (littlePonei.isVisivel()) {

                        inimigo.verificaColisao(littlePonei);

                    }
                    if (personagem.isVisivel()) {

                        inimigo.verificaMorte(personagem);

                    }
                }
            }
            
        }
        grafico2D.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!isFimDeJogo) {
            personagem.atualizarPersonagem();
            repaint(); // Serve para ficar pintando todas as vezes a tela

            if(!inimigosRemover.isEmpty()){
                for(Inimigo inimigo : inimigosRemover){
                    inimigos.remove(inimigo);
                }
                inimigosRemover.clear();
            }
            
            
            if (this.inimigos.size() <= 0) {
                isFimDeJogo = true;
            }
        } else {
            if (!telaVitoriaCriada) {
                new CriarTelaVitoria();
                telaVitoriaCriada = true;
            }
        }
    }

    public class teclado extends KeyAdapter implements ActionListener { //Evento das ações do Personagem

        private Timer tempo;

        @Override
        public void actionPerformed(ActionEvent e) {
            personagem.Atirar(true);

        }

        @Override
        public void keyPressed(KeyEvent evento) {
            personagem.PressAndar(evento);
        }

        @Override
        public void keyReleased(KeyEvent evento) {
            personagem.SoltarAndar(evento);
        }

        public teclado() {
            tempo = new Timer(100, this);
            tempo.start();
        }

    }

    public void eventoOcorreu() {
        if (!telaInicialCriada) {
            new CriarTelaGameOver();
            telaInicialCriada = true;
        }
    }

}
