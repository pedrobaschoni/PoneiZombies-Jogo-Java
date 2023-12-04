package br.edu.ifsp.pep.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class TelaInicialJogo extends JPanel implements ActionListener{
    private Image PlanoDeFundo;

    public TelaInicialJogo() {
        setFocusable(true);
        setDoubleBuffered(true);
        PlanoDeFundo = new ImageIcon(getClass()
                .getResource("/br/edu/ifsp/pep/imagem/TelaInicial.jpg"))
                .getImage(); //Cria um objeto da imagem e seta o caminho para o local que a imagem esta salva
    }
    
    @Override
    public void paint(Graphics graficos) { //Serve para ficar pintando a tela
        Graphics2D grafico2D = (Graphics2D) graficos; //Cria um objeto de imagem 2D
        graficos.drawImage(PlanoDeFundo, 0, 0, null); //Pinta o painel com a imagem setada no public Jogo()
        graficos.dispose();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint(); // Serve para ficar pintando todas as vezes a tela
    }
}
