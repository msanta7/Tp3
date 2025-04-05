package Tp3exo2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class View extends JFrame {
    JTextField textField;
    JLabel jLabel1;
    JButton Ajouter;
    JButton Supprimer;
    JButton Marquer;
    DefaultTableModel model;
    JTable jTable;
    JScrollPane jScrollPane;

    public View() {
        setTitle("liste de tâches");

       
        setLayout(null); 
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        
        textField = new JTextField();
        Ajouter = new JButton("ajouter");
        Supprimer = new JButton("supprimer");
        Marquer = new JButton("marquer");
        Ajouter.setBounds(30, 160, 145, 50); 
        Supprimer.setBounds(210, 160, 145, 50); 
        Marquer.setBounds(400, 160, 145, 50);
        
        jLabel1 = new JLabel("tache a faire:");
        jLabel1.setBounds(10, 30, 100, 60); 
        
        textField.setBounds(10, 90, 700, 40); 
        

        model = new DefaultTableModel(new Object[]{"La tache", "Etat"}, 0);
        jTable = new JTable(model);
        jScrollPane = new JScrollPane(jTable);

        jScrollPane.setBounds(10, 270, 780, 400);

        add(jLabel1);
        add(textField);
        add(Ajouter);
        add(Supprimer);
        add(Marquer);
        add(jScrollPane);
    }

    
}
