package mvc;

public class Model extends Bean {
    boolean unsavedChanges = false;
    public String fileName = null;

    public void changed() {
        unsavedChanges = true;
        firePropertyChange(null, null, null);
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String s) {
        fileName = s;
    }
}
