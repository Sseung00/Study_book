import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import struct.ResultType;
import struct.FileSearch;

public class FileUtils{
    private String propFile = "경로 경로";
    private String DBURL = "";
    private String USER = "";
    private String PW = "";
    
    public boolean FileUtils(){}
    
    public boolean readProperty(){
        try{
            //try get properties file
            FileInputStream fis = new FileInputStream(pripFile);
            props.load(new BufferedInputStream(fis));
            DBURL = props.getProperty("DBURL");
            USER = props.getProperty("USER");
            PW = props.getProperty("PW");
            return true;
        }catch(IOException e){
            makePropertiesFile();
            makeReadmeFile();
            return false;
        }
    }
    
    public void makePropertiesFile(){
        try{
            String saveFilePath = "./config/setting.properties";
            File file = new File(saveFilePath);
            File folder = new File("./config");
            if(!folder.exists()){
            folder.mkdir();
            }
            
            String contents = "DBURL = jdbc:postgresql://10.145.19.226:15432/pdm_op3\r\n" + "USER = postgres\r\n" + "PW = postgres\r\n";
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));
            bw.write(contents);
            bw.flush();
            bw.close();
        }catch(Exception e){
            return;
        }
    }
    
    public void makeReadmeFile(){
      try{
            String saveFilePath = "./Readme.txt";
            File file = new File(saveFilePath);
            String contents = "Readme contents";
            BufferedWriter vw = new BufferedWriter(new FileWriter(file.false));
            bw.write(contents);
            bw.flush();
            bw.close();
      }catch(Exception e){
            return;
      }
    }
    
    public ArrayList<FileSearch> scanningFileSystem(String rootPath, ArrayList<FileSearch> arr, String condition){
      try{
            File root = new File(rootPath);
            if(root.isDirectory()){
                  File[] files = root.listFiles();
                  for(int i = 0 ; i < files.length ; ++i){
                        if(files[i].isDirectory()){
                              scanningFileSystem(files[i].getPath(), arr, condition);
                        }else if{
                              scanningFileSystem(files[i].getPath(), arr, condition);
                        } else{
                              FileSearch temp = new FileSearch();
                              arr.add(temp);
                        }
                  }
            }
      }catch(Exception e){
            e.printStackTrace();
      }
      return(arr);
    }
}