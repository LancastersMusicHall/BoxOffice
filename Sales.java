//import com.github.lgooddatepicker.components.DatePicker;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//
//public class Sales extends JPanel {
//    private CardLayout cardLayout;
//    private JPanel mainPanel;
//
//    public Sales(CardLayout cardLayout, JPanel mainPanel) {
//        this.cardLayout = cardLayout;
//        this.mainPanel = mainPanel;
//        setLayout(new BorderLayout());
//        setBackground(Color.DARK_GRAY);
//
//        // Add header
//        add(createHeaderPanel("Lancaster Music Hall"), BorderLayout.NORTH);
//
//        // Content panel
//        JPanel contentPanel = new JPanel(new BorderLayout());
//        contentPanel.setBackground(Color.DARK_GRAY);
//
//        // Title label
//        JLabel titleLabel = new JLabel("Sales Data", JLabel.CENTER);
//        titleLabel.setFont(new Font("Verdana", Font.BOLD, 24));
//        titleLabel.setForeground(Color.WHITE);
//        contentPanel.add(titleLabel, BorderLayout.NORTH);
//
//        // Top panel for filters
//        JPanel topPanel = new JPanel();
//        topPanel.setLayout(new GridLayout(1, 4, 10, 10));
//        topPanel.setBackground(Color.DARK_GRAY);
//
//        JLabel eventLabel = new JLabel("Event Name:");
//        eventLabel.setForeground(Color.WHITE);
//        eventLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
//        JTextField eventField = new JTextField();
//        eventField.setFont(new Font("Verdana", Font.PLAIN, 14));
//        eventField.setPreferredSize(new Dimension(200, 30));
//
//        JLabel dateLabel = new JLabel("Date:");
//        dateLabel.setForeground(Color.WHITE);
//        dateLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
//        DatePicker datePicker = new DatePicker();
//        datePicker.setMinimumSize(new Dimension(200, 30));
//        datePicker.setPreferredSize(new Dimension(200, 30));
//
//        topPanel.add(eventLabel);
//        topPanel.add(eventField);
//        topPanel.add(dateLabel);
//        topPanel.add(datePicker);
//
//        // Table for sales data
//        String[] columnNames = {"Name", "Venue", "Date", "Revenue", "Expenses", "Profit"};
//        Object[][] data = {};
//        JTable salesTable = new JTable(data, columnNames);
//        JScrollPane scrollPane = new JScrollPane(salesTable);
//        salesTable.setFillsViewportHeight(true);
//
//        // Bottom panel with buttons
//        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
//        bottomPanel.setBackground(Color.DARK_GRAY);
//
//        JButton exportButton = new JButton("Export Data");
//        exportButton.setFont(new Font("Verdana", Font.PLAIN, 14));
//        exportButton.setPreferredSize(new Dimension(120, 40));
//        addHoverEffect(exportButton);
//        bottomPanel.add(exportButton);
//
//        JButton cancelButton = new JButton("Cancel");
//        cancelButton.setFont(new Font("Verdana", Font.PLAIN, 14));
//        cancelButton.setPreferredSize(new Dimension(100, 40));
//        addHoverEffect(cancelButton);
//        cancelButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));
//        bottomPanel.add(cancelButton);
//
//        // Add components to content panel
//        contentPanel.add(topPanel, BorderLayout.NORTH);
//        contentPanel.add(scrollPane, BorderLayout.CENTER);
//        contentPanel.add(bottomPanel, BorderLayout.SOUTH);
//
//        // Add content panel to this Sales panel
//        add(contentPanel, BorderLayout.CENTER);
//        add(createFooterPanel(), BorderLayout.SOUTH);
//    }
//
//    // Add hover effect method
//    private void addHoverEffect(JButton button) {
//        button.setFocusPainted(false);
//        button.setContentAreaFilled(false);
//        button.setOpaque(true);
//        button.setBackground(new Color(60, 63, 65));
//        button.setForeground(Color.WHITE);
//        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
//        button.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                button.setBackground(new Color(0, 255, 170));
//                button.setForeground(Color.BLACK);
//                button.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 170), 2));
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                button.setBackground(new Color(60, 63, 65));
//                button.setForeground(Color.WHITE);
//                button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
//            }
//        });
//    }
//
//    // Header panel
//    private JPanel createHeaderPanel(String title) {
//        JPanel headerPanel = new JPanel(new BorderLayout());
//        headerPanel.setBackground(new Color(0, 255, 170));
//        headerPanel.setPreferredSize(new Dimension(0, 55));
//        JLabel headerLabel = new JLabel(title, JLabel.CENTER);
//        headerLabel.setFont(new Font("Verdana", Font.BOLD, 24));
//        headerLabel.setForeground(Color.BLACK);
//        headerPanel.add(headerLabel, BorderLayout.CENTER);
//        return headerPanel;
//    }
//
//    // Footer panel
//    private JPanel createFooterPanel() {
//        JPanel footerPanel = new JPanel(new BorderLayout());
//        footerPanel.setBackground(new Color(0, 255, 170));
//        footerPanel.setPreferredSize(new Dimension(0, 30));
//        JLabel footerLabel = new JLabel("BoxOffice Team");
//        footerLabel.setFont(new Font("Verdana", Font.BOLD, 14));
//        footerLabel.setForeground(Color.BLACK);
//        footerLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
//        footerPanel.add(footerLabel, BorderLayout.WEST);
//        JButton signOutButton = new JButton("Sign out");
//        signOutButton.setFont(new Font("Verdana", Font.PLAIN, 12));
//        signOutButton.setForeground(Color.BLACK);
//        signOutButton.setBackground(new Color(0, 255, 170));
//        signOutButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
//        signOutButton.setFocusPainted(false);
//        signOutButton.addActionListener(e -> cardLayout.show(mainPanel, "Login"));
//        footerPanel.add(signOutButton, BorderLayout.EAST);
//        return footerPanel;
//    }
//}

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Sales extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private DefaultTableModel tableModel;
    private JLabel errorMessageLabel;


    public Sales(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        setLayout(new BorderLayout());
        setBackground(new Color(120, 135, 135));

        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createSalesTablePanel(), BorderLayout.CENTER);
        add(createSearchPanel(), BorderLayout.SOUTH);
    }

    private JPanel createHeaderPanel() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(0, 255, 170));
        header.setPreferredSize(new Dimension(0, 55));

        JLabel title = new JLabel("Lancaster Music Hall", SwingConstants.CENTER);
        title.setFont(new Font("Verdana", Font.BOLD, 24));
        title.setForeground(Color.BLACK);
        header.add(title, BorderLayout.CENTER);

        return header;
    }

    private JScrollPane createSalesTablePanel() {
        String[] columns = {"Event Name", "Venue", "Date", "Tickets Sold", "Revenue", "Expenses", "Profit"};
        tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);

        // Dummy data
        tableModel.addRow(new Object[]{"Event 1", "Big Hall", "16/03/25", 123, "£4086", "£1086", "£3000"});
        tableModel.addRow(new Object[]{"Event 2", "Small Hall", "17/03/25", 65, "£2012", "£512", "£1500"});

        table.setFont(new Font("Verdana", Font.PLAIN, 14));
        table.setRowHeight(30);
        table.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 14));
        table.getTableHeader().setBackground(new Color(0, 255, 170));
        table.getTableHeader().setForeground(Color.BLACK);
        table.setGridColor(Color.LIGHT_GRAY);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(900, 200));
        return scrollPane;
    }

    private JPanel createSearchPanel() {
        JPanel panel = new JPanel(new GridBagLayout());

        errorMessageLabel = new JLabel("");
        errorMessageLabel.setForeground(Color.WHITE);
        errorMessageLabel.setBackground(new Color(255, 80, 80)); // soft red
        errorMessageLabel.setFont(new Font("Verdana", Font.BOLD, 14));
        errorMessageLabel.setOpaque(true);
        errorMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        errorMessageLabel.setVisible(false); // hidden initially

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(errorMessageLabel, gbc);

        // Reset grid config for inputs
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridy = 1;


        panel.setBackground(Color.DARK_GRAY);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 12, 10, 12);

        JLabel eventLabel = new JLabel("Event Name:");
        JLabel dateLabel = new JLabel("Date:");
        JTextField eventField = new JTextField(10);
        JTextField dateField = new JTextField(10);

        JButton searchBtn = new JButton("Search");
        JButton clearBtn = new JButton("Clear");
        JButton cancelBtn = new JButton("Cancel");

        for (JButton btn : new JButton[]{searchBtn, clearBtn, cancelBtn}) {
            btn.setFont(new Font("Verdana", Font.PLAIN, 14));
            btn.setPreferredSize(new Dimension(100, 35));
            btn.setBackground(new Color(60, 63, 65));
            btn.setForeground(Color.WHITE);
            btn.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            addHoverEffect(btn);
        }

        eventLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        eventLabel.setForeground(Color.WHITE);
        dateLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        dateLabel.setForeground(Color.WHITE);

        gbc.gridx = 0;
        panel.add(eventLabel, gbc);
        gbc.gridx = 1;
        panel.add(eventField, gbc);
        gbc.gridx = 2;
        panel.add(dateLabel, gbc);
        gbc.gridx = 3;
        panel.add(dateField, gbc);
        gbc.gridx = 4;
        panel.add(searchBtn, gbc);
        gbc.gridx = 5;
        panel.add(clearBtn, gbc);
        gbc.gridx = 6;
        panel.add(cancelBtn, gbc);

        Object[][] allSales = {
                {"Event 1", "Big Hall", "16/03/25", 123, "£4086", "£1086", "£3000"},
                {"Event 2", "Small Hall", "17/03/25", 65, "£2012", "£512", "£1500"}
        };
        searchBtn.addActionListener(e -> {
            String nameInput = eventField.getText().trim().toLowerCase();
            String dateInput = dateField.getText().trim();

            tableModel.setRowCount(0); // Clear table
            boolean matchFound = false;

            for (Object[] row : allSales) {
                String rowName = ((String) row[0]).toLowerCase();
                String rowDate = (String) row[2];

                boolean nameMatches = nameInput.isEmpty() || rowName.contains(nameInput);
                boolean dateMatches = dateInput.isEmpty() || rowDate.equals(dateInput);

                if (nameMatches && dateMatches) {
                    tableModel.addRow(row);
                    matchFound = true;
                }
            }

            if (!matchFound) {
                errorMessageLabel.setText("Event not found, please fill in the search boxes and try again");
                errorMessageLabel.setVisible(true);
            } else {
                errorMessageLabel.setVisible(false);
            }


            for (Object[] row : allSales) {
                String rowName = ((String) row[0]).toLowerCase();
                String rowDate = (String) row[2];

                boolean nameMatches = nameInput.isEmpty() || rowName.contains(nameInput);
                boolean dateMatches = dateInput.isEmpty() || rowDate.equals(dateInput);

                if (nameMatches && dateMatches) {
                    tableModel.addRow(row);
                }
            }
        });
        clearBtn.addActionListener(e -> {
            eventField.setText("");
            dateField.setText("");
            tableModel.setRowCount(0);
            for (Object[] row : allSales) {
                tableModel.addRow(row);
            }
            errorMessageLabel.setVisible(false);
        });
        cancelBtn.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));

        return panel;
    }


    private void addHoverEffect(JButton button) {
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBackground(new Color(60, 63, 65));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(0, 255, 170));
                button.setForeground(Color.BLACK);
                button.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 170), 2));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(60, 63, 65));
                button.setForeground(Color.WHITE);
                button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            }
        });
    }
}
