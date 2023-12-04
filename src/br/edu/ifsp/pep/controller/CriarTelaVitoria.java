package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.view.TelaGameOver;
import br.edu.ifsp.pep.view.TelaInicialJogo;
import br.edu.ifsp.pep.view.TelaVitoria;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

public class CriarTelaVitoria extends JFrame{
    
    public CriarTelaVitoria() {
        
        JButton menu = new JButton("MENU");
        menu.setBounds(220, 180, 200, 50);
        menu.setFont(new Font("Times New Roman", Font.BOLD, 20));
        menu.setBackground(new Color(237, 241, 238));
        
        JButton sair = new JButton("SAIR");
        sair.setBounds(220, 240, 200, 50);
        sair.setFont(new Font("Times New Roman", Font.BOLD, 20));
        sair.setForeground(new Color(255, 0, 0)); //Muda a cor de texto do botão
        sair.setBackground(new Color(237, 241, 238));
        
        add(menu);
        add(sair);

        add(new TelaVitoria());
        setTitle("IFSP Zombies");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        menu.addActionListener(this::Menu);
        sair.addActionListener(this::Sair);
    }

    
     private void Menu(ActionEvent actionEvent) {
        new CriarTelaInicial();
        dispose();
    }
     
      private void Sair(ActionEvent actionEvent) {
        dispose();
        System.exit(0);
    }
}
