package bai2;

import java.io.*;

public class bai2 {
    public static void main(String[] args) {
        String destinationFile = "D://week5//src//bai2//out.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter(destinationFile)) {

            System.out.println("Nhập nội dung cần lưu vào file (Nhập 'exit' để kết thúc):");
            String line;
            while (!(line = reader.readLine()).equalsIgnoreCase("exit")) {
                writer.write(line + "\n");
            }

            System.out.println("Dữ liệu đã được ghi vào file thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}