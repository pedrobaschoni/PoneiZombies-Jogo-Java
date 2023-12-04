package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.view.TelaInicialJogo;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

public class CriarTelaInicial extends JFrame{
    
    public CriarTelaInicial() {
        JButton jogar = new JButton("JOGAR"); //Cria o botão referente a JOGAR
        jogar.setBounds(400, 220, 200, 50); //Define o tamnho e a posição do botão
        jogar.setFont(new Font("Times New Roman", Font.BOLD, 20));
        jogar.setBackground(new Color(237, 241, 238)); //Muda a cor do botão
        
        JButton controles = new JButton("CONTROLES");
        controles.setBounds(400, 280, 200, 50);
        controles.setFont(new Font("Times New Roman", Font.BOLD, 20));
        controles.setBackground(new Color(237, 241, 238));
        
        JButton sair = new JButton("SAIR");
        sair.setBounds(400, 340, 200, 50);
        sair.setFont(new Font("Times New Roman", Font.BOLD, 20));
        sair.setForeground(new Color(255, 0, 0)); //Muda a cor de texto do botão
        sair.setBackground(new Color(237, 241, 238));
        
        add(jogar); //Adiciona os botões
        add(controles);
        add(sair);

        add(new TelaInicialJogo());
        setTitle("IFSP Zombies");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        jogar.addActionListener(this::Jogar); //Chama o evento do botão
        controles.addActionListener(this::Controles);
        sair.addActionListener(this::Sair);
    }

    private void Jogar(ActionEvent actionEvent) { //Adiciona o evento para o botão
        new CriarTelaHistoria();
        dispose();
    }
    
     private void Controles(ActionEvent actionEvent) {
        new CriarTelaControles();
        dispose();
    }
     
      private void Sair(ActionEvent actionEvent) {
        dispose();
        System.exit(0);
    }
}
