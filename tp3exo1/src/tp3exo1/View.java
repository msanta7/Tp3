package tp3exo1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame {

    JFrame frame;
    JTextField nomField, prenomField, numeroField, typeField;
    String [] types = {"Amis", "Famille", "Travail" ,"Collègue"};
    JComboBox comboBox;
    JLabel info, nom, prenom, numero, type;
    JButton ajouter, modifier, supprimer;
    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;

    View() {
        frame = new JFrame("Gestion de contacts");
        frame.setSize(600, 400);
        frame.setLayout(null);

        
        info = new JLabel("--- Info du Contact ---");
        info.setBounds(100, 10, 200, 30);

        
        nom = new JLabel("Nom:");
        nom.setBounds(50, 50, 100, 25);
        
        prenom = new JLabel("Prénom:");
        prenom.setBounds(50, 80, 100, 25);
        
        numero = new JLabel("Numéro:");
        numero.setBounds(50, 110, 100, 25);
        
        type = new JLabel("Type:");
        type.setBounds(50, 140, 100, 25);

        
        nomField = new JTextField();
        nomField.setBounds(150, 50, 180, 25);
        
        prenomField = new JTextField();
        prenomField.setBounds(150, 80, 180, 25);
        
        numeroField = new JTextField();
        numeroField.setBounds(150, 110, 180, 25);
        
        comboBox = new JComboBox(types);
        comboBox.setBounds(150, 140, 180, 25);
        comboBox.setEditable(true);

      
        ajouter = new JButton("Ajouter");
        ajouter.setBounds(30, 200, 80, 30);
        
        modifier = new JButton("Modifier");
        modifier.setBounds(120, 200, 80, 30);
        
        supprimer = new JButton("Supprimer");
        supprimer.setBounds(210, 200, 100, 30);
        
       
        
        String[] columns = {"Nom", "Prénom", "Numéro", "Type"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 250, 500, 100);

        
        frame.add(info);
        frame.add(nom);
        frame.add(nomField);
        frame.add(prenom);
        frame.add(prenomField);
        frame.add(numero);
        frame.add(numeroField);
        frame.add(type);
        frame.add(comboBox);
        
        frame.add(ajouter);
        frame.add(modifier);
        frame.add(supprimer);
        
        frame.add(scrollPane);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new View();
    }
    
  
   
}
