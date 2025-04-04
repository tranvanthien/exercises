package bai4;

import java.io.*;

public class bai4 {
    public static void main(String[] args) {
        String filePath = "D://week5//src//bai4//numbers.dat";
        int[] numbers = {10, 20, 30, 40, 50};


        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            for (int num : numbers) {
                dos.writeInt(num);
            }
            System.out.println("Ghi dữ liệu vào file thành công.");
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file: " + e.getMessage());
        }


        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            System.out.println("Các số đọc từ file:");
            while (dis.available() > 0) {
                System.out.println(dis.readInt());
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}
