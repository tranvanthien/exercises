import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class AddOrderForm extends JFrame {
    private JComboBox<String> customerCombo;
    private JTable productTable;
    private JButton addButton;
    private JButton viewHistoryButton;
    private JButton totalAmountButton;
    private JButton addCustomerButton;
    private JButton addProductButton;
    private DefaultComboBoxModel<String> customerComboModel;
    private DefaultTableModel productTableModel;

    private CustomerDAO customerDAO;
    private ProductDAO productDAO;
    private OrderDAO orderDAO;

    public AddOrderForm() {
        // Khởi tạo DAO
        customerDAO = new CustomerDAO();
        productDAO = new ProductDAO();
        orderDAO = new OrderDAO();

        setTitle("Quản Lý Đơn Hàng");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Sidebar menu bên trái
        JPanel sideMenu = new JPanel();
        sideMenu.setLayout(new BoxLayout(sideMenu, BoxLayout.Y_AXIS));
        sideMenu.setBackground(new Color(33, 33, 33));
        sideMenu.setPreferredSize(new Dimension(200, getHeight()));
        sideMenu.setBorder(new EmptyBorder(20, 10, 20, 10));

        JLabel titleLabel = new JLabel("Menu");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        addButton = createMenuButton("Tạo đơn hàng");
        viewHistoryButton = createMenuButton("Xem lịch sử");
        totalAmountButton = createMenuButton("Tính tổng tiền");
        addProductButton = createMenuButton("Thêm sản phẩm"); // Đã sửa thành cùng style

        sideMenu.add(titleLabel);
        sideMenu.add(Box.createVerticalStrut(30));
        sideMenu.add(addButton);
        sideMenu.add(Box.createVerticalStrut(10));
        sideMenu.add(viewHistoryButton);
        sideMenu.add(Box.createVerticalStrut(10));
        sideMenu.add(totalAmountButton);
        sideMenu.add(Box.createVerticalStrut(10));
        sideMenu.add(addProductButton);

        // Panel chính bên phải
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Top panel chọn khách hàng
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel customerLabel = new JLabel("Khách hàng:");
        customerLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        customerComboModel = new DefaultComboBoxModel<>();
        loadCustomers();
        customerCombo = new JComboBox<>(customerComboModel);
        addCustomerButton = new JButton("Thêm khách hàng");

        topPanel.add(customerLabel);
        topPanel.add(customerCombo);
        topPanel.add(addCustomerButton);

        // Bảng sản phẩm
        String[] columns = {"ID sản phẩm", "Tên sản phẩm", "Giá", "Số lượng"};
        productTableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3; // Chỉ cho phép chỉnh sửa cột số lượng
            }
        };
        loadProducts();

        productTable = new JTable(productTableModel);
        productTable.setRowHeight(28);
        productTable.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        productTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));

        JScrollPane scrollPane = new JScrollPane(productTable);

        // Thêm vào main panel
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Gắn sự kiện cho các nút
        addButton.addActionListener(this::handleAddOrder);
        viewHistoryButton.addActionListener(this::handleViewHistory);
        totalAmountButton.addActionListener(this::handleTotalAmount);
        addCustomerButton.addActionListener(this::handleAddCustomer);
        addProductButton.addActionListener(this::handleAddProduct);

        add(sideMenu, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void loadCustomers() {
        customerComboModel.removeAllElements();
        List<String> customers = customerDAO.getAllCustomers();
        for (String customer : customers) {
            customerComboModel.addElement(customer);
        }
    }

    private void loadProducts() {
        productTableModel.setRowCount(0);
        List<Object[]> products = productDAO.getAllProducts();
        for (Object[] product : products) {
            productTableModel.addRow(new Object[]{
                    product[0], // ID
                    product[1], // Tên
                    product[2], // Giá
                    0 // Số lượng mặc định là 0
            });
        }
    }

    private JButton createMenuButton(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(180, 40));
        button.setBackground(new Color(55, 71, 79));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        return button;
    }

    private void handleAddOrder(ActionEvent e) {
        String selectedCustomer = (String) customerCombo.getSelectedItem();
        if (selectedCustomer == null || selectedCustomer.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int customerId = Integer.parseInt(selectedCustomer.split(" - ")[0]);
        List<Object[]> orderItems = new ArrayList<>();
        StringBuilder message = new StringBuilder("Đơn hàng đã tạo:\n");
        double total = 0;

        for (int i = 0; i < productTableModel.getRowCount(); i++) {
            int quantity = Integer.parseInt(productTableModel.getValueAt(i, 3).toString());
            if (quantity > 0) {
                int productId = Integer.parseInt(productTableModel.getValueAt(i, 0).toString());
                String name = productTableModel.getValueAt(i, 1).toString();
                double price = Double.parseDouble(productTableModel.getValueAt(i, 2).toString());
                double itemTotal = price * quantity;
                total += itemTotal;

                orderItems.add(new Object[]{productId, name, price, quantity});
                message.append("- ").append(name).append(" x ").append(quantity)
                        .append(" = ").append(itemTotal).append(" đ\n");
            }
        }

        if (orderItems.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ít nhất một sản phẩm", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        message.append("Tổng tiền: ").append(total).append(" đ");

        if (orderDAO.addOrder(customerId, orderItems)) {
            JOptionPane.showMessageDialog(this, message.toString(), "Xác nhận đơn hàng", JOptionPane.INFORMATION_MESSAGE);
            // Reset số lượng về 0 sau khi tạo đơn hàng thành công
            for (int i = 0; i < productTableModel.getRowCount(); i++) {
                productTableModel.setValueAt(0, i, 3);
            }
        }
    }

    private void handleViewHistory(ActionEvent e) {
        String selectedCustomer = (String) customerCombo.getSelectedItem();
        if (selectedCustomer == null || selectedCustomer.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int customerId = Integer.parseInt(selectedCustomer.split(" - ")[0]);
        String customerName = selectedCustomer.split(" - ")[1];

        List<String> history = orderDAO.getOrderHistory(customerId);
        if (history.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không có lịch sử đơn hàng cho " + customerName,
                    "Lịch sử đơn hàng", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder historyText = new StringBuilder("Lịch sử đơn hàng của " + customerName + ":\n");
        for (String item : history) {
            historyText.append("- ").append(item).append("\n");
        }

        JOptionPane.showMessageDialog(this, historyText.toString(), "Lịch sử đơn hàng", JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleTotalAmount(ActionEvent e) {
        double total = 0;

        for (int i = 0; i < productTableModel.getRowCount(); i++) {
            int quantity = Integer.parseInt(productTableModel.getValueAt(i, 3).toString());
            if (quantity > 0) {
                double price = Double.parseDouble(productTableModel.getValueAt(i, 2).toString());
                total += quantity * price;
            }
        }

        JOptionPane.showMessageDialog(this, "Tổng tiền tạm tính: " + total + " đ", "Tổng tiền", JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleAddCustomer(ActionEvent e) {
        String customerName = JOptionPane.showInputDialog(this, "Nhập tên khách hàng:");
        if (customerName != null && !customerName.trim().isEmpty()) {
            if (customerDAO.addCustomer(customerName)) {
                loadCustomers();
                JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private void handleAddProduct(ActionEvent e) {
        String productName = JOptionPane.showInputDialog(this, "Nhập tên sản phẩm:");
        if (productName != null && !productName.trim().isEmpty()) {
            String productPriceStr = JOptionPane.showInputDialog(this, "Nhập giá sản phẩm:");
            String productQuantityStr = JOptionPane.showInputDialog(this, "Nhập số lượng tồn kho:");

            try {
                double price = Double.parseDouble(productPriceStr);
                int quantity = Integer.parseInt(productQuantityStr);

                if (productDAO.addProduct(productName, price, quantity)) {
                    loadProducts();
                    JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ cho giá và số lượng", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AddOrderForm::new);
    }
}