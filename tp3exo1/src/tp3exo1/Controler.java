package tp3exo1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Controler implements ActionListener{

    View view;
    Model model;
	DefaultTableModel tableModel;


    public Controler(View view, Model model) {
        this.model = model;
        this.view = view;

        this.view.ajouter.addActionListener(this);
        this.view.modifier.addActionListener(this);
        this.view.supprimer.addActionListener(this);

    }

    private void rafraichirTable() {
    	DefaultTableModel tableModel = (DefaultTableModel) view.table.getModel();
        
		tableModel.setRowCount(0);
        try {
            List<Contact> contacts = model.getContacts(); 
            for (Contact con : contacts) {
                tableModel.addRow(new Object[]{
                        con.getNom(),
                        con.getPrenom(),
                        con.getNumTel(),
                        con.getType()
                });
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erreur lors du rafraichissement du tab : " + ex.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.ajouter) {
            ajouterCon();
        }

        if (e.getSource() == view.modifier) {
        	modifierCon(); 
        }

        if (e.getSource() == view.supprimer) {
            supprimerCon();
        }
    }

    public void ajouterCon() {
        String nom = view.nomField.getText();
        String prenom = view.prenomField.getText();
        String numero = view.numeroField.getText();
        String type = (String) view.comboBox.getSelectedItem();

        if (nom.isEmpty() || prenom.isEmpty() || numero.isEmpty() || type.isEmpty()) {
            JOptionPane.showMessageDialog(view, "remplir tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Contact c = new Contact(nom, prenom, numero, type);

        model.add(c);
        rafraichirTable();
    }

    
    public void supprimerCon() {
        int selectedRow = view.table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(view, "selectioner une ligne à supprimer", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
        	Contact contactSupp = model.getContacts().get(selectedRow);
            model.delete(contactSupp);
        	rafraichirTable();
        
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Erreur ", "Erreur", JOptionPane.ERROR_MESSAGE);
        
        }
    }

    public void modifierCon() {
        int selectedRow = view.table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(view, "Sélectionnez une ligne à modifier", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nom = view.nomField.getText();
        String prenom = view.prenomField.getText();
        String numero = view.numeroField.getText();
        String type = (String) view.comboBox.getSelectedItem(); 

        if (nom.isEmpty() || prenom.isEmpty() || numero.isEmpty() || type.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Remplir tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Contact contactToEdit = model.getContacts().get(selectedRow);
            model.edit(contactToEdit, nom, prenom, numero, type);
            rafraichirTable();
        } catch (ContactNotFoundException ex) {
            JOptionPane.showMessageDialog(view, "Erreur", "Erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void main(String[] args) {
        View view =new View();
        Model model =new Model();
        new Controler(view,model);

    }

}
