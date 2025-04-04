package bai5;

import java.io.File;

public class bai5 {
    public static void main(String[] args) {
        String directoryPath = "D://week5//src";

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null && files.length > 0) {
                System.out.println("Danh sách tệp trong thư mục: " + directoryPath);
                for (File file : files) {
                    System.out.println(file.getName());
                }
            } else {
                System.out.println("Thư mục rỗng hoặc không có tệp nào.");
            }
        } else {
            System.out.println("Đường dẫn không hợp lệ hoặc không phải thư mục.");
        }
    }
}
