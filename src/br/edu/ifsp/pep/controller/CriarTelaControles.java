package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.view.Controles;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

public class CriarTelaControles extends JFrame{
    
    public CriarTelaControles() {
        JButton voltar = new JButton("VOLTAR");
        voltar.setBounds(10, 10, 200, 50);
        voltar.setFont(new Font("Times New Roman", Font.BOLD, 20));
        voltar.setBackground(new Color(237, 241, 238));
        
        add(voltar);
        
        
        add(new Controles());
        setTitle("IFSP Zombies");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        
        
        
        voltar.addActionListener(this::Voltar);
    }
    
    private void Voltar(ActionEvent actionEvent) { //Adiciona o evento para o botão
        new CriarTelaInicial();
        dispose();
    }


}
