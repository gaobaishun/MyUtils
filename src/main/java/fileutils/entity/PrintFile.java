package fileutils.entity;

public class PrintFile {
        public PrintFile(String fileName,Long fileSize){
            this.fileName=fileName;
            this.fileSize=fileSize;
        }
        private Long fileSize;

        private String fileName;

        public Long getFileSize() {
            return fileSize;
        }

        public String getFileName() {
            return fileName;
        }

}
