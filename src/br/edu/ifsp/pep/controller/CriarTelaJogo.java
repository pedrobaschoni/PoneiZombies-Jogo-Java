package br.edu.ifsp.pep.controller;

import javax.swing.JFrame;

public class CriarTelaJogo extends JFrame {

    public CriarTelaJogo() {

        add(new Jogo());
        setTitle("IFSP Zombies");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}
