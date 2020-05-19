import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOExcetpion;

public class FileMoveThread extents Thread{
    private String originPath = "";
    private String targetPath = "";
    
    public FileMoveThread(String originPath, String targetPath){
        this.originPath = originPath;
        this.targetPath = targetPath;
    }
    
    public void run(){
        File originFile = new File(originPath);
        File copyFile = new File(targetPath);
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try{
            fis = new FileInputStream(originFile);
            fos = new FileOutputStream(copyFile);
            
            int fileByte = 0;
            while((fileByte = fis.read()) != -1){
                fos.write(fileByte);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            FileTransfer.threadCount--;
            try{
                if(fis != null){
                    fis.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
            try{
                if(fos != null){
                    fos.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}