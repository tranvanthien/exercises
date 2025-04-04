import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    public List<String> getAllCustomers() {
        List<String> customers = new ArrayList<>();
        String sql = "SELECT customer_id, name FROM customers";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                customers.add(rs.getInt("customer_id") + " - " + rs.getString("name"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi tải danh sách khách hàng: " + e.getMessage(),
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        return customers;
    }

    public boolean addCustomer(String name) {
        String sql = "INSERT INTO customers (name) VALUES (?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi thêm khách hàng: " + e.getMessage(),
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}