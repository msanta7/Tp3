package tp3exo3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;

public class View extends JFrame {
    private JButton browseButton;
    private JButton deleteButton;
    private JButton moveButton;
    private JButton exitButton;
    private JButton chooseFolderButton;
    private JButton confirmMoveButton;

    private JLabel folderLabel;
    private JTable fileTable;
    private DefaultTableModel tableModel;
    private JFileChooser fileChooser;
    private JFileChooser dirChooser;

    public View() {
        setTitle("Gestionnaire de fichiers");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        browseButton = new JButton("Naviguer");
        deleteButton = new JButton("Supprimer");
        moveButton = new JButton("Dzplacer");
        exitButton = new JButton("Quitter");

        browseButton.setBounds(30, 20, 120, 30);
        deleteButton.setBounds(170, 20, 120, 30);
        moveButton.setBounds(310, 20, 120, 30);
        exitButton.setBounds(450, 20, 120, 30);

        add(browseButton);
        add(deleteButton);
        add(moveButton);
        add(exitButton);

        folderLabel = new JLabel("Choisir dossier de destination :");
        folderLabel.setBounds(30, 70, 250, 25);
        add(folderLabel);
        folderLabel.setVisible(false);

        chooseFolderButton = new JButton("Choisir dossier");
        chooseFolderButton.setBounds(30, 100, 150, 25);
        add(chooseFolderButton);
        chooseFolderButton.setVisible(false);

        confirmMoveButton = new JButton("Confirmer deplacement");
        confirmMoveButton.setBounds(200, 100, 180, 25);
        add(confirmMoveButton);
        confirmMoveButton.setVisible(false);

        tableModel = new DefaultTableModel(new String[]{"Nom de fichier"}, 0);
        fileTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(fileTable);
        scrollPane.setBounds(30, 150, 800, 280);
        add(scrollPane);

        fileChooser = new JFileChooser(new File("C:/Users"));
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        dirChooser = new JFileChooser(new File("C:/Users"));
        dirChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    }

    // Getters
    public JButton getBrowseButton() { return browseButton; }
    public JButton getDeleteButton() { return deleteButton; }
    public JButton getMoveButton() { return moveButton; }
    public JButton getExitButton() { return exitButton; }
    public JButton getChooseFolderButton() { return chooseFolderButton; }
    public JButton getConfirmMoveButton() { return confirmMoveButton; }
    public JLabel getFolderLabel() { return folderLabel; }

    public JTable getFileTable() { return fileTable; }
    public DefaultTableModel getTableModel() { return tableModel; }

    public JFileChooser getFileChooser() { return fileChooser; }
    public JFileChooser getDirChooser() { return dirChooser; }
}
