package DesktopRunnable;

import java.io.File;

public class FolderCreation {

    String name;
    String folderPath;

    public void setName(String name){
        this.name=name;

    }
    public void setPath(String folderPath){
        this.folderPath=folderPath;
    }

    public boolean newDirect(){
        File file = new File(folderPath);
        boolean bool = file.mkdir();
        return bool;
    }
    public String getName(){
        return name;
    }

    public String getFolderPath(){
        return folderPath;
    }
}
