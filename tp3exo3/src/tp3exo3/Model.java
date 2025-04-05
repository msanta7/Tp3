package tp3exo3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private ArrayList<File> selectedFiles;
    private File sourceDir;
    private File targetDir;

    public Model() {
        selectedFiles = new ArrayList<>();
    }

    public List<File> getSelectedFiles() {
        return selectedFiles;
    }

    public void setSelectedFiles(ArrayList<File> files) {
        this.selectedFiles = files;
    }

    public File getSourceDir() {
        return sourceDir;
    }

    public void setSourceDir(File sourceDir) {
        this.sourceDir = sourceDir;
    }

    public File getTargetDir() {
        return targetDir;
    }

    public void setTargetDir(File targetDir) {
        this.targetDir = targetDir;
    }
}
