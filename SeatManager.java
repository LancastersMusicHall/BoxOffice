import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;

public class SeatManager extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private DefaultTableModel seatTableModel;
    private JTable seatTable;
    private JLabel successMessageLabel;
    private JLabel statusMessageLabel;



    public SeatManager(CardLayout cardLayout, JPanel mainPanel, WebsiteCalendar.Event selectedEvent) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        setLayout(new BorderLayout());
        setBackground(new Color(120, 135, 135));

        //add(createHeaderPanel(), BorderLayout.NORTH);
        add(createSeatTablePanel(), BorderLayout.CENTER);
        add(createControlSection(), BorderLayout.SOUTH);
        add(createHeaderPanel("Lancaster Music Hall"), BorderLayout.NORTH);

    }
    private JPanel createHeaderPanel(String title) {
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(0, 255, 170));
        headerPanel.setPreferredSize(new Dimension(0, 55));
        JLabel headerLabel = new JLabel(title, JLabel.CENTER);
        headerLabel.setFont(new Font("Verdana", Font.BOLD, 24));
        headerLabel.setForeground(Color.BLACK);
        headerPanel.add(headerLabel, BorderLayout.CENTER);


        successMessageLabel = new JLabel("");
        successMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        successMessageLabel.setFont(new Font("Verdana", Font.BOLD, 14));
        successMessageLabel.setForeground(Color.WHITE);
        successMessageLabel.setBackground(new Color(0, 180, 100)); // Greenish tone
        successMessageLabel.setOpaque(true);
        successMessageLabel.setVisible(false); // Initially hidden

        headerPanel.add(successMessageLabel, BorderLayout.SOUTH);

        statusMessageLabel = new JLabel("", SwingConstants.CENTER);
        statusMessageLabel.setFont(new Font("Verdana", Font.BOLD, 14));
        statusMessageLabel.setOpaque(true);
        statusMessageLabel.setVisible(false); // hidden by default

        headerPanel.add(statusMessageLabel, BorderLayout.SOUTH);

        return headerPanel;
    }
    private void addHoverEffect(JButton button) {
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBackground(new Color(60, 63, 65));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(0, 255, 170));
                button.setForeground(Color.BLACK);
                button.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 170), 2));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(60, 63, 65));
                button.setForeground(Color.WHITE);
                button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            }
        });
    }

    private void showStatusMessage(String message, Color background) {
        statusMessageLabel.setText(message);
        statusMessageLabel.setBackground(background);
        statusMessageLabel.setForeground(Color.WHITE);
        statusMessageLabel.setVisible(true);

        new javax.swing.Timer(3000, e -> statusMessageLabel.setVisible(false)).start();
    }


    private JScrollPane createSeatTablePanel() {
        String[] columns = {"Number", "Status", "Type", "Accessible", "Price"};
        seatTableModel = new DefaultTableModel(columns, 0);
        seatTable = new JTable(seatTableModel);
        seatTable.setFont(new Font("Verdana", Font.PLAIN, 14));
        seatTable.setRowHeight(30);

        JTableHeader tableHeader = seatTable.getTableHeader();
        tableHeader.setFont(new Font("Verdana", Font.BOLD, 14));
        tableHeader.setBackground(new Color(0, 255, 170));
        tableHeader.setForeground(Color.BLACK);

        seatTable.setGridColor(Color.LIGHT_GRAY);
        seatTable.setShowGrid(true);
        seatTable.setBackground(Color.WHITE);
        seatTable.setForeground(Color.BLACK);

        seatTableModel.addRow(new Object[]{"1N", "Not listed", "Stall", "Yes", "£25"});
        seatTableModel.addRow(new Object[]{"20AA", "Not listed", "Balcony", "No", "£40"});
        seatTableModel.addRow(new Object[]{"10B", "Not listed", "Stall", "No", "£20"});
        seatTableModel.addRow(new Object[]{"14E", "Listed", "Stall", "No", "£20"});
        seatTableModel.addRow(new Object[]{"13C", "Listed", "Stall", "No", "£20"});

        JScrollPane scrollPane = new JScrollPane(seatTable);
        scrollPane.setPreferredSize(new Dimension(900, 220));
        return scrollPane;
    }


    private JPanel createControlSection() {
        JPanel controlSection = new JPanel(new BorderLayout());
        controlSection.setBackground(new Color(120, 135, 135));

        JSeparator separator = new JSeparator();
        separator.setForeground(Color.BLACK);
        controlSection.add(separator, BorderLayout.NORTH);
        controlSection.add(createControlsPanel(), BorderLayout.CENTER);

        return controlSection;
    }

    private JPanel createControlsPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.DARK_GRAY);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 12, 10, 12);

        JLabel numberLabel = new JLabel("Number:");
        JLabel statusLabel = new JLabel("Status:");
        numberLabel.setForeground(Color.WHITE);
        statusLabel.setForeground(Color.WHITE);
        numberLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        statusLabel.setFont(new Font("Verdana", Font.PLAIN, 14));

        JComboBox<String> numberDropdown = new JComboBox<>(new String[]{"1N", "20AA", "10B", "14E", "13C"});
        JComboBox<String> statusDropdown = new JComboBox<>(new String[]{"Listed", "Not listed"});

        JButton saveBtn = new JButton("Save");
        JButton clearBtn = new JButton("Clear");
        JButton cancelBtn = new JButton("Cancel");
        JButton mapBtn = new JButton("View Map");

        // Add hover effect to all buttons
        for (JButton btn : new JButton[]{saveBtn, clearBtn, cancelBtn, mapBtn}) {
            addHoverEffect(btn);
            btn.setFont(new Font("Verdana", Font.PLAIN, 14));
            btn.setPreferredSize(new Dimension(100, 35));
            btn.setBackground(new Color(60, 63, 65));
            btn.setForeground(Color.WHITE);
            btn.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        }
        cancelBtn.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));

        saveBtn.addActionListener(e -> {
            int selectedRow = seatTable.getSelectedRow();

            if (selectedRow == -1) {
                // No row selected, show error
                successMessageLabel.setText("Unsuccessfully saved, please check all details and try again");
                successMessageLabel.setBackground(Color.RED);
                successMessageLabel.setForeground(Color.WHITE);
                successMessageLabel.setVisible(true);

                new Timer(3000, evt -> successMessageLabel.setVisible(false)).start();
                return;
            }

            String selectedStatus = (String) statusDropdown.getSelectedItem();
            if (selectedStatus == null || selectedStatus.isEmpty()) {
                successMessageLabel.setText("Unsuccessfully saved, please check all details and try again");
                successMessageLabel.setBackground(Color.RED);
                successMessageLabel.setForeground(Color.WHITE);
                successMessageLabel.setVisible(true);

                new Timer(3000, evt -> successMessageLabel.setVisible(false)).start();
                return;
            }

            // Update only the selected row's status
            seatTableModel.setValueAt(selectedStatus, selectedRow, 1); // column 1 = Status

            successMessageLabel.setText("Seat added to the website successfully");
            successMessageLabel.setBackground(new Color(0, 180, 100)); // Green
            successMessageLabel.setForeground(Color.WHITE);
            successMessageLabel.setVisible(true);

            new Timer(3000, evt -> successMessageLabel.setVisible(false)).start();
        });
        seatTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = seatTable.getSelectedRow();
                if (row != -1) {
                    numberDropdown.setSelectedItem(seatTableModel.getValueAt(row, 0)); // Number
                    statusDropdown.setSelectedItem(seatTableModel.getValueAt(row, 1)); // Status
                }
            }
        });


        saveBtn.addActionListener(e -> {
            String number = (String) numberDropdown.getSelectedItem();
            String status = (String) statusDropdown.getSelectedItem();

            if (number == null || number.isEmpty() || status == null || status.isEmpty()) {
                showStatusMessage("Unsuccessfully saved, please check all details and try again", Color.RED);
            } else {
                // Add to table (or update logic as needed)
                seatTableModel.addRow(new Object[]{number, status, "Stall", "No", "£20"});

                showStatusMessage("Seat added to the website successfully", new Color(0, 180, 100));
            }
        });


        mapBtn.addActionListener(e -> {
            Object[] options = {"Main Hall", "Small Venue"};
            String choice = (String) JOptionPane.showInputDialog(
                    this,
                    "Select Venue:",
                    "Venue Map",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]
            );
            if (choice != null) {
                VenueMapPanel mapPanel = new VenueMapPanel(cardLayout, mainPanel, choice);
                mainPanel.add(mapPanel, "VenueMap");
                cardLayout.show(mainPanel, "VenueMap");
            }
        });
        gbc.gridx = 0; panel.add(numberLabel, gbc);
        gbc.gridx = 1; panel.add(numberDropdown, gbc);
        gbc.gridx = 2; panel.add(statusLabel, gbc);
        gbc.gridx = 3; panel.add(statusDropdown, gbc);
        gbc.gridx = 10; panel.add(cancelBtn, gbc);
        gbc.gridx = 9; panel.add(clearBtn, gbc);
        gbc.gridx = 8; panel.add(saveBtn, gbc);
        gbc.gridx = 7; panel.add(mapBtn, gbc);

        return panel;
    }
}
