package bai3;

import java.io.*;

public class bai3 {
    public static void main(String[] args) {
        String filePath = "D://week5//src//bai3//ghi.txt"; 

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int lineCount = 0;
            while (br.readLine() != null) {
                lineCount++;
            }
            System.out.println("Số dòng trong tệp: " + lineCount);
        } catch (IOException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }
}
