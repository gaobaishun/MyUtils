package fileutils;

import fileutils.entity.PrintFile;

import java.io.File;

import java.util.LinkedList;

public class FileUtils {


    /**
     * 查找指定目录下的文件包括目录病打印出大小
     * @param url 文件路径 如 C:\Program Files (x86)
     */
    public static void printAllFilesByUrl(String url){

        File file=new File(url);
        File[] files = file.listFiles();
        LinkedList<PrintFile> fileList=new LinkedList<>();
        for (File f :
                files) {
            if(f.isHidden())
                continue;
            System.out.println("start -"+f.getName());
            long folderSize = getFolderSize(f);

                if(!fileList.isEmpty()) {
                    for (int i = 0; i < fileList.size(); i++) {
                        PrintFile printFile = fileList.get(i);

                        if (printFile.getFileSize() < folderSize) {
                            fileList.add(i, new PrintFile(f.getName(), folderSize));
                            break;
                        }else if(i==fileList.size()-1){
                            fileList.addLast(new PrintFile(f.getName(), folderSize));
                            break;
                        }
                    }
                }else{
                    fileList.add(new PrintFile(f.getName(),folderSize));
                }
        }

        for (PrintFile pf :
                fileList) {
            System.out.println(pf.getFileName()+"   "+pf.getFileSize()/1024+" kb");
        }

    }



    private static long getFolderSize(File folder) {
        long size = 0;
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    size += file.length();
                } else if (file.isDirectory()) {
                    size += getFolderSize(file);
                }
            }
        }
        return size;
    }

    public static void main(String[] args) {
        System.out.println("sss");
        //printAllFilesByUrl("C:\\Program Files (x86)");
        //System.out.println(getFolderSize(new File("C:")));
       // File file=new File("C:\\360Safe");
        //System.out.println(file.getName());
    }
}
