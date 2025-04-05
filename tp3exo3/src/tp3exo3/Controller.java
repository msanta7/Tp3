package tp3exo3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;

public class Controller {
    private final Model model;
    private final View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        view.getBrowseButton().addActionListener(e -> browseFiles());
        view.getDeleteButton().addActionListener(e -> deleteFiles());
        view.getMoveButton().addActionListener(e -> MoveOptions());
        view.getChooseFolderButton().addActionListener(e -> chooseTargetFolder());
        view.getConfirmMoveButton().addActionListener(e -> moveFiles());
        view.getExitButton().addActionListener(e -> System.exit(0));
    }

    private void browseFiles() {
        resetMoveSection();

        int result = view.getFileChooser().showOpenDialog(view);
        if (result == JFileChooser.APPROVE_OPTION) {
            File[] files = view.getFileChooser().getSelectedFiles();
            ArrayList<File> list = new ArrayList<>(Arrays.asList(files));
            model.setSelectedFiles(list);
            model.setSourceDir(files[0].getParentFile());

            DefaultTableModel table = view.getTableModel();
            table.setRowCount(0);
            for (File file : list) {
                table.addRow(new Object[]{file.getName()});
            }
        }
    }

    private void deleteFiles() {
        resetMoveSection();

        ArrayList<File> files = new ArrayList<>(model.getSelectedFiles());
        for (File file : files) {
            if (file.delete()) {
                System.out.println("Supprime: " + file.getName());
            } else {
                System.out.println("error: " + file.getName());
            }
        }
        model.setSelectedFiles(new ArrayList<>());
        view.getTableModel().setRowCount(0);
    }

    private void MoveOptions() {
        view.getFolderLabel().setVisible(true);
        view.getChooseFolderButton().setVisible(true);
    }

    private void chooseTargetFolder() {
        int result = view.getDirChooser().showOpenDialog(view);
        if (result == JFileChooser.APPROVE_OPTION) {
            File dir = view.getDirChooser().getSelectedFile();
            model.setTargetDir(dir);
            view.getConfirmMoveButton().setVisible(true);
        }
    }

    private void moveFiles() {
        ArrayList<File> files = new ArrayList<>(model.getSelectedFiles());
        File destination = model.getTargetDir();

        if (destination != null && !files.isEmpty()) {
            for (File file : files) {
                try {
                    Path sourcePath = file.toPath();
                    Path destPath = new File(destination, file.getName()).toPath();
                    Files.move(sourcePath, destPath, StandardCopyOption.REPLACE_EXISTING);
                } catch (Exception ex) {
                    System.out.println("Erreur déplacement: " + ex.getMessage());
                }
            }
            model.setSelectedFiles(new ArrayList<>());
            view.getTableModel().setRowCount(0);
            resetMoveSection();
        }
    }

    private void resetMoveSection() {
        view.getFolderLabel().setVisible(false);
        view.getChooseFolderButton().setVisible(false);
        view.getConfirmMoveButton().setVisible(false);
    }

    public static void main(String[] args) {
        Model m = new Model();
        View v = new View();
        Controller c = new Controller(m, v);
        v.setVisible(true);
    }
}
