package com.mavixk.ds;
import java.io.File;
import java.util.*;

class FileFinder{
    public static void findFile(String fileName,String inputPath){
        File fparam = new File(inputPath);
        File[] files = fparam.listFiles();
        for(File file:files){
            if(file.isDirectory()){
                findFile(fileName,file.getAbsolutePath());
            }
            else if(fileName.equals(file.getName())){
                System.out.println(inputPath + "/" + fileName + " found");
            }
        }
    }
}

public class FileFinderDemo {
    public static void main(String[] args){
        String inputPath = System.getProperty("user.dir");
        //System.out.println(inputPath);
        FileFinder.findFile("DataStructures.iml",inputPath);
    }
}
