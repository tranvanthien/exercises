import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    public boolean addOrder(int customerId, List<Object[]> orderItems) {
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false);

            // Thêm đơn hàng
            String orderSql = "INSERT INTO orders (customer_id) VALUES (?)";
            int orderId;

            try (PreparedStatement pstmt = conn.prepareStatement(orderSql, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setInt(1, customerId);
                pstmt.executeUpdate();

                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        orderId = rs.getInt(1);
                    } else {
                        throw new SQLException("Không thể lấy ID đơn hàng");
                    }
                }
            }

            // Thêm các sản phẩm trong đơn hàng
            String itemSql = "INSERT INTO order_items (order_id, product_id, quantity, unit_price) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(itemSql)) {
                for (Object[] item : orderItems) {
                    int productId = (Integer) item[0];
                    int quantity = (Integer) item[3];
                    double price = (Double) item[2];

                    pstmt.setInt(1, orderId);
                    pstmt.setInt(2, productId);
                    pstmt.setInt(3, quantity);
                    pstmt.setDouble(4, price);
                    pstmt.addBatch();
                }
                pstmt.executeBatch();
            }

            conn.commit();
            return true;
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            JOptionPane.showMessageDialog(null, "Lỗi khi tạo đơn hàng: " + e.getMessage(),
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<String> getOrderHistory(int customerId) {
        List<String> history = new ArrayList<>();
        String sql = "SELECT o.order_id, o.order_date, p.name, oi.quantity " +
                "FROM orders o " +
                "JOIN order_items oi ON o.order_id = oi.order_id " +
                "JOIN products p ON oi.product_id = p.product_id " +
                "WHERE o.customer_id = ? " +
                "ORDER BY o.order_date DESC";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, customerId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    history.add(String.format("Đơn #%d (%s): %d x %s",
                            rs.getInt("order_id"),
                            rs.getDate("order_date"),
                            rs.getInt("quantity"),
                            rs.getString("name")));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi lấy lịch sử đơn hàng: " + e.getMessage(),
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        return history;
    }
}