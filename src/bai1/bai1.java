package bai1;

import java.io.*;

public class bai1 {
    public static void main(String[] args) {
        String sourceFile = "D://week5//src//bai1//ghi.txt";
        String destinationFile = "D://week5//src//bai1//doc.txt";

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("Sao chép tệp thành công!");
        } catch (IOException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }
}
