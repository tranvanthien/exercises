import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLApp extends JFrame {

    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> xmlList = new JList<>(listModel);
    private JTextField nameField = new JTextField(20);
    private JTextArea contentArea = new JTextArea(5, 20);
    private List<Element> xmlElements = new ArrayList<>();
    private Document document;
    private Element rootElement;
    private File outputFile = new File("output.xml");
    private JTree xmlTree = new JTree();

    public XMLApp() {
        setTitle("XML CRUD App");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Tên thẻ:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Nội dung:"));
        inputPanel.add(contentArea);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Thêm");
        JButton updateButton = new JButton("Sửa");
        JButton deleteButton = new JButton("Xóa");
        JButton saveButton = new JButton("Lưu XML");
        JButton loadButton = new JButton("Đọc XML");
        JButton mergeButton = new JButton("Ghép XML");

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        buttonPanel.add(mergeButton);

        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.add(new JScrollPane(xmlList), BorderLayout.WEST);
        listPanel.add(new JScrollPane(xmlTree), BorderLayout.CENTER);

        add(inputPanel, BorderLayout.NORTH);
        add(listPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> addElement());
        updateButton.addActionListener(e -> updateElement());
        deleteButton.addActionListener(e -> deleteElement());
        saveButton.addActionListener(e -> saveXML());
        loadButton.addActionListener(e -> loadXML());
        mergeButton.addActionListener(e -> mergeXML());

        xmlList.addListSelectionListener(e -> showElementDetails());

        initXML();
    }

    private void initXML() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.newDocument();
            rootElement = document.createElement("root");
            document.appendChild(rootElement);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    private void addElement() {
        String name = nameField.getText().trim().replaceAll("[^a-zA-Z0-9]", "_");
        String content = contentArea.getText().trim();
        if (name.isEmpty()) return;
        Element element = document.createElement(name);
        element.setTextContent(content);
        rootElement.appendChild(element);
        xmlElements.add(element);
        listModel.addElement(name);
        updateTree();
        clearFields();
    }

    private void updateElement() {
        int selectedIndex = xmlList.getSelectedIndex();
        if (selectedIndex >= 0) {
            Element selectedElement = xmlElements.get(selectedIndex);
            String newName = nameField.getText().trim().replaceAll("[^a-zA-Z0-9]", "_");
            String newContent = contentArea.getText().trim();
            Element newElement = document.createElement(newName);
            newElement.setTextContent(newContent);
            rootElement.replaceChild(newElement, selectedElement);
            xmlElements.set(selectedIndex, newElement);
            listModel.set(selectedIndex, newName);
            updateTree();
            clearFields();
        }
    }

    private void deleteElement() {
        int selectedIndex = xmlList.getSelectedIndex();
        if (selectedIndex >= 0) {
            Element selectedElement = xmlElements.get(selectedIndex);
            rootElement.removeChild(selectedElement);
            xmlElements.remove(selectedIndex);
            listModel.remove(selectedIndex);
            updateTree();
            clearFields();
        }
    }

    private void saveXML() {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(outputFile);
            transformer.transform(source, result);
            JOptionPane.showMessageDialog(this, "XML đã lưu vào " + outputFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadXML() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(outputFile);
            rootElement = document.getDocumentElement();
            xmlElements.clear();
            listModel.clear();
            NodeList nodeList = rootElement.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodeList.item(i);
                    xmlElements.add(element);
                    listModel.addElement(element.getTagName());
                }
            }
            updateTree();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void mergeXML() {
        // Tính năng ghép XML (tùy vào yêu cầu có thể lồng nhau hoặc ngang cấp)
    }

    private void updateTree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("root");
        for (Element element : xmlElements) {
            root.add(new DefaultMutableTreeNode(element.getTagName()));
        }
        xmlTree.setModel(new DefaultTreeModel(root));
    }

    private void showElementDetails() {
        int selectedIndex = xmlList.getSelectedIndex();
        if (selectedIndex >= 0) {
            Element selectedElement = xmlElements.get(selectedIndex);
            nameField.setText(selectedElement.getTagName());
            contentArea.setText(selectedElement.getTextContent());
        }
    }

    private void clearFields() {
        nameField.setText("");
        contentArea.setText("");
    }
}
