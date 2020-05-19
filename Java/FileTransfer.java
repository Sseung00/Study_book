import java.io.File;
import java.util.ArrayLiist;

import struct.FileSearch;

public class FileTransfer{
    static int maxThreadCount = 20;
    static int threadCount = 0;
    
    public void moveFilesThread(ArrayList<FileSearch> fileList){
        FileMoveThread[] th = new FileMoveThread[fileList.size()];
        for(int i = 0 ; i < fileList.size() ; ++i){
            if(threadCount <= maxThreadCount){
                try{
                    th[i] = new FileMoveThread(fileList.get(i).getOriginPath(), fileList.get(i).getTargetPath());
                    threadCount++;
                    th[i].start();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else{
                try{
                    Thread.sleep(5000);
                }catch(InterruptedException e){
                    e.printStachTrace();
                }
                --i;
            }
        }

        //check whether threads all stop
        boolean isEnd = false;
        while(!isEnd){
            int finishedThread = 0;
            //sleep
            try{
                Thread.sleep(30000);
            }catch(InterruptedException){
                e.printStackTrace();
            }
            //check all threads are terminated
            for(int i = 0 ; i < fileList.size() ; ++i){
                if(th[i].getState() == Thread.State.TERMINATED){
                    
                }
            }
        }
    }
}