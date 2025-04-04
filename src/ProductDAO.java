import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public List<Object[]> getAllProducts() {
        List<Object[]> products = new ArrayList<>();
        String sql = "SELECT product_id, name, price, stock_quantity FROM products";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Object[] row = {
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("stock_quantity")
                };
                products.add(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi tải danh sách sản phẩm: " + e.getMessage(),
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        return products;
    }

    public boolean addProduct(String name, double price, int quantity) {
        String sql = "INSERT INTO products (name, price, stock_quantity) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            pstmt.setInt(3, quantity);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi thêm sản phẩm: " + e.getMessage(),
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}