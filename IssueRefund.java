import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class IssueRefund extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private CardLayout contentLayout;
    private JPanel contentPanel;
    private JTextField firstNameField;
    private JTextField surnameField;
    private JTextField emailField;
    private JTextField phoneNumberField;
    private JTextField eventNameField;
    private JTextField dateField;
    private JTextField ticketIDField;
    private JLabel errorLabel;
    private JTable resultsTable;
    private DefaultTableModel tableModel;
    private JTextField refundAmountField;
    private JTextField reasonField;
    private JLabel customerValue;
    private JLabel eventValue;
    private JLabel ticketIDValue;
    private JLabel purchaseDateValue;
    private JLabel salePriceValue;

    public IssueRefund(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        setLayout(new BorderLayout());
        setBackground(Color.DARK_GRAY);

        add(createHeaderPanel("Lancaster Music Hall"), BorderLayout.NORTH);

        contentLayout = new CardLayout();
        contentPanel = new JPanel(contentLayout);
        contentPanel.setBackground(Color.DARK_GRAY);

        contentPanel.add(createSearchView(), "SearchView");
        contentPanel.add(createNoResultsView(), "NoResultsView");
        contentPanel.add(createTicketSelectionView(), "TicketSelectionView");
        contentPanel.add(createRefundFormView(), "RefundFormView");
        contentPanel.add(createRefundSuccessView(), "RefundSuccessView");

        add(contentPanel, BorderLayout.CENTER);
        add(createFooterPanel(), BorderLayout.SOUTH);

        // Reset the view to SearchView when the panel becomes visible
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                reset();
            }
        });

        contentLayout.show(contentPanel, "SearchView");
    }

    private void reset() {
        // Reset form fields
        firstNameField.setText("");
        surnameField.setText("");
        emailField.setText("");
        phoneNumberField.setText("");
        eventNameField.setText("");
        dateField.setText("");
        ticketIDField.setText("");
        errorLabel.setText("");
        if (tableModel != null) {
            tableModel.setRowCount(0);
        }
        if (refundAmountField != null) {
            refundAmountField.setText("£");
        }
        if (reasonField != null) {
            reasonField.setText("");
        }

        // Reset the view to SearchView
        contentLayout.show(contentPanel, "SearchView");
    }

    private JPanel createSearchView() {
        JPanel searchPanel = new JPanel(new GridBagLayout());
        searchPanel.setBackground(Color.DARK_GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Issue Refund", JLabel.CENTER);
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 36));
        titleLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        searchPanel.add(titleLabel, gbc);

        JLabel firstNameLabel = new JLabel("<html><b>*</b>First name:</html>");
        firstNameLabel.setForeground(Color.WHITE);
        firstNameLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        searchPanel.add(firstNameLabel, gbc);

        firstNameField = new JTextField();
        firstNameField.setFont(new Font("Verdana", Font.PLAIN, 18));
        firstNameField.setPreferredSize(new Dimension(250, 40));
        gbc.gridx = 1;
        gbc.gridy = 1;
        searchPanel.add(firstNameField, gbc);

        JLabel surnameLabel = new JLabel("<html><b>*</b>Surname:</html>");
        surnameLabel.setForeground(Color.WHITE);
        surnameLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 2;
        searchPanel.add(surnameLabel, gbc);

        surnameField = new JTextField();
        surnameField.setFont(new Font("Verdana", Font.PLAIN, 18));
        surnameField.setPreferredSize(new Dimension(250, 40));
        gbc.gridx = 1;
        gbc.gridy = 2;
        searchPanel.add(surnameField, gbc);

        JLabel emailLabel = new JLabel("<html><b>*</b>Email:</html>");
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 3;
        searchPanel.add(emailLabel, gbc);

        emailField = new JTextField();
        emailField.setFont(new Font("Verdana", Font.PLAIN, 18));
        emailField.setPreferredSize(new Dimension(250, 40));
        gbc.gridx = 1;
        gbc.gridy = 3;
        searchPanel.add(emailField, gbc);

        JLabel phoneNumberLabel = new JLabel("Phone number:");
        phoneNumberLabel.setForeground(Color.WHITE);
        phoneNumberLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 4;
        searchPanel.add(phoneNumberLabel, gbc);

        phoneNumberField = new JTextField();
        phoneNumberField.setFont(new Font("Verdana", Font.PLAIN, 18));
        phoneNumberField.setPreferredSize(new Dimension(250, 40));
        gbc.gridx = 1;
        gbc.gridy = 4;
        searchPanel.add(phoneNumberField, gbc);

        JLabel eventNameLabel = new JLabel("<html><b>*</b>Event name:</html>");
        eventNameLabel.setForeground(Color.WHITE);
        eventNameLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 5;
        searchPanel.add(eventNameLabel, gbc);

        eventNameField = new JTextField();
        eventNameField.setFont(new Font("Verdana", Font.PLAIN, 18));
        eventNameField.setPreferredSize(new Dimension(250, 40));
        gbc.gridx = 1;
        gbc.gridy = 5;
        searchPanel.add(eventNameField, gbc);

        JLabel dateLabel = new JLabel("<html><b>*</b>Date:</html>");
        dateLabel.setForeground(Color.WHITE);
        dateLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 6;
        searchPanel.add(dateLabel, gbc);

        dateField = new JTextField();
        dateField.setFont(new Font("Verdana", Font.PLAIN, 18));
        dateField.setPreferredSize(new Dimension(250, 40));
        gbc.gridx = 1;
        gbc.gridy = 6;
        searchPanel.add(dateField, gbc);

        JLabel ticketIDLabel = new JLabel("Ticket ID:");
        ticketIDLabel.setForeground(Color.WHITE);
        ticketIDLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 7;
        searchPanel.add(ticketIDLabel, gbc);

        ticketIDField = new JTextField();
        ticketIDField.setFont(new Font("Verdana", Font.PLAIN, 18));
        ticketIDField.setPreferredSize(new Dimension(250, 40));
        gbc.gridx = 1;
        gbc.gridy = 7;
        searchPanel.add(ticketIDField, gbc);

        errorLabel = new JLabel("");
        errorLabel.setForeground(Color.RED);
        errorLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        searchPanel.add(errorLabel, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.DARK_GRAY);

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Verdana", Font.PLAIN, 18));
        backButton.setPreferredSize(new Dimension(150, 50));
        addHoverEffect(backButton);
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));
        buttonPanel.add(backButton);

        JButton searchButton = new JButton("Search");
        searchButton.setFont(new Font("Verdana", Font.PLAIN, 18));
        searchButton.setPreferredSize(new Dimension(150, 50));
        addHoverEffect(searchButton);
        searchButton.addActionListener(e -> validateAndSearch());
        buttonPanel.add(searchButton);

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        searchPanel.add(buttonPanel, gbc);

        return searchPanel;
    }

    private JPanel createNoResultsView() {
        JPanel noResultsPanel = new JPanel(new GridBagLayout());
        noResultsPanel.setBackground(Color.DARK_GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel noResultsLabel = new JLabel("No tickets found", JLabel.CENTER);
        noResultsLabel.setFont(new Font("Verdana", Font.BOLD, 24));
        noResultsLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        noResultsPanel.add(noResultsLabel, gbc);

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Verdana", Font.PLAIN, 18));
        backButton.setPreferredSize(new Dimension(150, 50));
        addHoverEffect(backButton);
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));
        gbc.gridx = 0;
        gbc.gridy = 1;
        noResultsPanel.add(backButton, gbc);

        return noResultsPanel;
    }

    private JPanel createTicketSelectionView() {
        JPanel ticketSelectionPanel = new JPanel(new BorderLayout());
        ticketSelectionPanel.setBackground(Color.DARK_GRAY);

        JLabel resultsLabel = new JLabel("Results", JLabel.CENTER);
        resultsLabel.setFont(new Font("Verdana", Font.BOLD, 24));
        resultsLabel.setForeground(Color.WHITE);
        ticketSelectionPanel.add(resultsLabel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(
                new String[]{"Customer", "Event Name", "Ticket ID", "Purchase Date", "Sale Price", "Refund Status", "Select"},
                0
        ) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 6 ? Boolean.class : String.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 6;
            }
        };
        resultsTable = new JTable(tableModel);
        resultsTable.setFont(new Font("Verdana", Font.PLAIN, 14));
        resultsTable.setRowHeight(30);
        resultsTable.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 14));
        resultsTable.getTableHeader().setBackground(new Color(0, 255, 170));
        resultsTable.getTableHeader().setForeground(Color.BLACK);
        resultsTable.setGridColor(Color.LIGHT_GRAY);
        resultsTable.setShowGrid(true);
        JScrollPane scrollPane = new JScrollPane(resultsTable);
        ticketSelectionPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.DARK_GRAY);

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Verdana", Font.PLAIN, 18));
        backButton.setPreferredSize(new Dimension(150, 50));
        addHoverEffect(backButton);
        backButton.addActionListener(e -> contentLayout.show(contentPanel, "SearchView"));
        buttonPanel.add(backButton);

        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Verdana", Font.PLAIN, 18));
        submitButton.setPreferredSize(new Dimension(150, 50));
        addHoverEffect(submitButton);
        submitButton.addActionListener(e -> showRefundForm());
        buttonPanel.add(submitButton);

        ticketSelectionPanel.add(buttonPanel, BorderLayout.SOUTH);

        return ticketSelectionPanel;
    }

    private JPanel createRefundFormView() {
        JPanel refundFormPanel = new JPanel(new GridBagLayout());
        refundFormPanel.setBackground(Color.DARK_GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Issue refund for:", JLabel.CENTER);
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        refundFormPanel.add(titleLabel, gbc);

        JLabel customerLabel = new JLabel("Customer Name:");
        customerLabel.setForeground(Color.WHITE);
        customerLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        refundFormPanel.add(customerLabel, gbc);

        customerValue = new JLabel("");
        customerValue.setForeground(Color.WHITE);
        customerValue.setFont(new Font("Verdana", Font.PLAIN, 18));
        gbc.gridx = 1;
        gbc.gridy = 1;
        refundFormPanel.add(customerValue, gbc);

        JLabel eventLabel = new JLabel("Event Name:");
        eventLabel.setForeground(Color.WHITE);
        eventLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 2;
        refundFormPanel.add(eventLabel, gbc);

        eventValue = new JLabel("");
        eventValue.setForeground(Color.WHITE);
        eventValue.setFont(new Font("Verdana", Font.PLAIN, 18));
        gbc.gridx = 1;
        gbc.gridy = 2;
        refundFormPanel.add(eventValue, gbc);

        JLabel ticketIDLabel = new JLabel("Ticket ID:");
        ticketIDLabel.setForeground(Color.WHITE);
        ticketIDLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 3;
        refundFormPanel.add(ticketIDLabel, gbc);

        ticketIDValue = new JLabel("");
        ticketIDValue.setForeground(Color.WHITE);
        ticketIDValue.setFont(new Font("Verdana", Font.PLAIN, 18));
        gbc.gridx = 1;
        gbc.gridy = 3;
        refundFormPanel.add(ticketIDValue, gbc);

        JLabel purchaseDateLabel = new JLabel("Purchase Date:");
        purchaseDateLabel.setForeground(Color.WHITE);
        purchaseDateLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 4;
        refundFormPanel.add(purchaseDateLabel, gbc);

        purchaseDateValue = new JLabel("");
        purchaseDateValue.setForeground(Color.WHITE);
        purchaseDateValue.setFont(new Font("Verdana", Font.PLAIN, 18));
        gbc.gridx = 1;
        gbc.gridy = 4;
        refundFormPanel.add(purchaseDateValue, gbc);

        JLabel salePriceLabel = new JLabel("Sale Price:");
        salePriceLabel.setForeground(Color.WHITE);
        salePriceLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 5;
        refundFormPanel.add(salePriceLabel, gbc);

        salePriceValue = new JLabel("");
        salePriceValue.setForeground(Color.WHITE);
        salePriceValue.setFont(new Font("Verdana", Font.PLAIN, 18));
        gbc.gridx = 1;
        gbc.gridy = 5;
        refundFormPanel.add(salePriceValue, gbc);

        JLabel refundAmountLabel = new JLabel("Refund amount:");
        refundAmountLabel.setForeground(Color.WHITE);
        refundAmountLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 6;
        refundFormPanel.add(refundAmountLabel, gbc);

        refundAmountField = new JTextField("£");
        refundAmountField.setFont(new Font("Verdana", Font.PLAIN, 18));
        refundAmountField.setPreferredSize(new Dimension(250, 40));
        gbc.gridx = 1;
        gbc.gridy = 6;
        refundFormPanel.add(refundAmountField, gbc);

        JLabel reasonLabel = new JLabel("Reason for refund:");
        reasonLabel.setForeground(Color.WHITE);
        reasonLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 7;
        refundFormPanel.add(reasonLabel, gbc);

        reasonField = new JTextField();
        reasonField.setFont(new Font("Verdana", Font.PLAIN, 18));
        reasonField.setPreferredSize(new Dimension(250, 40));
        gbc.gridx = 1;
        gbc.gridy = 7;
        refundFormPanel.add(reasonField, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.DARK_GRAY);

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Verdana", Font.PLAIN, 18));
        backButton.setPreferredSize(new Dimension(150, 50));
        addHoverEffect(backButton);
        backButton.addActionListener(e -> contentLayout.show(contentPanel, "TicketSelectionView"));
        buttonPanel.add(backButton);

        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Verdana", Font.PLAIN, 18));
        submitButton.setPreferredSize(new Dimension(150, 50));
        addHoverEffect(submitButton);
        submitButton.addActionListener(e -> {
            if (refundAmountField.getText().trim().isEmpty() || reasonField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int selectedRow = -1;
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                Boolean isSelected = (Boolean) tableModel.getValueAt(i, 6);
                if (isSelected != null && isSelected) {
                    selectedRow = i;
                    break;
                }
            }
            if (selectedRow != -1) {
                tableModel.setValueAt("Refunded", selectedRow, 5);
                tableModel.setValueAt(false, selectedRow, 6);
            }
            contentLayout.show(contentPanel, "RefundSuccessView");
        });
        buttonPanel.add(submitButton);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        refundFormPanel.add(buttonPanel, gbc);

        return refundFormPanel;
    }

    private JPanel createRefundSuccessView() {
        JPanel refundSuccessPanel = new JPanel(new GridBagLayout());
        refundSuccessPanel.setBackground(Color.DARK_GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel successLabel = new JLabel("Refund submitted", JLabel.CENTER);
        successLabel.setFont(new Font("Verdana", Font.BOLD, 24));
        successLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        refundSuccessPanel.add(successLabel, gbc);

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Verdana", Font.PLAIN, 18));
        backButton.setPreferredSize(new Dimension(150, 50));
        addHoverEffect(backButton);
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));
        gbc.gridx = 0;
        gbc.gridy = 1;
        refundSuccessPanel.add(backButton, gbc);

        return refundSuccessPanel;
    }

    private void validateAndSearch() {
        errorLabel.setText("");
        if (firstNameField.getText().trim().isEmpty() ||
                surnameField.getText().trim().isEmpty() ||
                emailField.getText().trim().isEmpty() ||
                eventNameField.getText().trim().isEmpty() ||
                dateField.getText().trim().isEmpty()) {
            errorLabel.setText("Please fill all fields marked with an *");
            return;
        }

        String firstName = firstNameField.getText().trim();
        String surname = surnameField.getText().trim();
        String email = emailField.getText().trim();
        String eventName = eventNameField.getText().trim();
        String date = dateField.getText().trim();
        String ticketID = ticketIDField.getText().trim();

        tableModel.setRowCount(0);

        if (firstName.equals("Max") && surname.equals("Simons") && email.equals("Max.Simons@gmail.com") &&
                eventName.equals("Lion King") && date.equals("01/04/2024") && (ticketID.isEmpty() || ticketID.equals("1305"))) {
            tableModel.addRow(new Object[]{
                    "Max Simons",
                    "Lion King",
                    "1305",
                    "01/04/2024",
                    "£50",
                    "Not Refunded",
                    false
            });
            contentLayout.show(contentPanel, "TicketSelectionView");
        } else {
            contentLayout.show(contentPanel, "NoResultsView");
        }
    }

    private void showRefundForm() {
        int selectedRow = -1;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            Boolean isSelected = (Boolean) tableModel.getValueAt(i, 6);
            if (isSelected != null && isSelected) {
                selectedRow = i;
                break;
            }
        }

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a ticket to refund", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        customerValue.setText((String) tableModel.getValueAt(selectedRow, 0));
        eventValue.setText((String) tableModel.getValueAt(selectedRow, 1));
        ticketIDValue.setText((String) tableModel.getValueAt(selectedRow, 2));
        purchaseDateValue.setText((String) tableModel.getValueAt(selectedRow, 3));
        salePriceValue.setText((String) tableModel.getValueAt(selectedRow, 4));
        refundAmountField.setText("£");
        reasonField.setText("");

        contentLayout.show(contentPanel, "RefundFormView");
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

    private JPanel createHeaderPanel(String title) {
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(0, 255, 170));
        headerPanel.setPreferredSize(new Dimension(0, 55));
        JLabel headerLabel = new JLabel(title, JLabel.CENTER);
        headerLabel.setFont(new Font("Verdana", Font.BOLD, 24));
        headerLabel.setForeground(Color.BLACK);
        headerPanel.add(headerLabel, BorderLayout.CENTER);
        return headerPanel;
    }

    private JPanel createFooterPanel() {
        JPanel footerPanel = new JPanel(new BorderLayout());
        footerPanel.setBackground(new Color(0, 255, 170));
        footerPanel.setPreferredSize(new Dimension(0, 30));
        JLabel footerLabel = new JLabel("BoxOffice Team");
        footerLabel.setFont(new Font("Verdana", Font.BOLD, 14));
        footerLabel.setForeground(Color.BLACK);
        footerLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        footerPanel.add(footerLabel, BorderLayout.WEST);
        JButton signOutButton = new JButton("Sign out");
        signOutButton.setFont(new Font("Verdana", Font.PLAIN, 12));
        signOutButton.setForeground(Color.BLACK);
        signOutButton.setBackground(new Color(0, 255, 170));
        signOutButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        signOutButton.setFocusPainted(false);
        signOutButton.addActionListener(e -> cardLayout.show(mainPanel, "Login"));
        footerPanel.add(signOutButton, BorderLayout.EAST);
        return footerPanel;
    }
}