package bai35;

public class Main {
    public static void main(String[] args) {
        // Tạo một đối tượng MyDate hợp lệ
        MyDate date1 = new MyDate(2024, 2, 28);
        System.out.println("Ngày ban đầu: " + date1);

        // Kiểm tra ngày hôm sau
        MyDate nextDay = date1.nextDay();
        System.out.println("Ngày tiếp theo: " + nextDay);

        // Kiểm tra một ngày khác
        MyDate date2 = new MyDate(2023, 12, 31);
        System.out.println("Ngày ban đầu: " + date2);
        System.out.println("Ngày tiếp theo: " + date2.nextDay());

        // Kiểm tra ngày trong tuần
        MyDate date3 = new MyDate(2025, 5, 20);
        System.out.println("Ngày cụ thể: " + date3);

        // Kiểm tra ngày không hợp lệ
        try {
            MyDate invalidDate = new MyDate(2023, 2, 29); // Không hợp lệ (2023 không phải năm nhuận)
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }

        // Thay đổi ngày bằng setter
        MyDate date4 = new MyDate(2022, 7, 15);
        System.out.println("Ngày trước khi chỉnh sửa: " + date4);
        date4.setYear(2024);
        date4.setMonth(2);
        date4.setDay(29);
        System.out.println("Ngày sau khi chỉnh sửa: " + date4);
    }
}
