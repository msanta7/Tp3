package Tp3exo2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class Controller implements ActionListener {

    View view;
    Model model;
    DefaultTableModel tableModel;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        
        
        this.view.Ajouter.addActionListener(this);
        this.view.Supprimer.addActionListener(this);
        this.view.Marquer.addActionListener(this);
    }

    
    private void rafraichirTable() {
        DefaultTableModel tableModel = (DefaultTableModel) view.jTable.getModel();
        tableModel.setRowCount(0);
        try {
            List<Model> tasks = model.getTasks(); 
            for (Model task : tasks) {
                tableModel.addRow(new Object[]{task.getTache(),task.getEtat()
                });
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Erreur lors du rafraîchissement du tableau : " + ex.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.Ajouter) {
        	ajou();
        }

        if (e.getSource() == view.Supprimer) {
            supp();
        }

        if (e.getSource() == view.Marquer) {
        	marquer();
        }
    }

    
    public void ajou() {
        String taskText = view.textField.getText();
        if (taskText.isEmpty()) {
            JOptionPane.showMessageDialog(view, "entrez une tache.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Model newTask = new Model(taskText, "Non Accomplie");
        model.add(newTask);
        rafraichirTable();
    }

    
    public void supp() {
        int selectedRow = view.jTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(view, "selectionnez une tache a supprimer", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Model taskToDelete = model.getTasks().get(selectedRow);
            model.delete(taskToDelete);
            rafraichirTable();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Erreur suppression de la tache : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }


    public void marquer() {
        int selectedRow = view.jTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(view, "selectionner une tache a modifier", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Model task = model.getTasks().get(selectedRow);
            model.edit(task);
            rafraichirTable();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Erreur lors de la modification de la tâche : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        new Controller(view, model);
        view.setVisible(true);
    }
}
