import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Customer extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public Customer(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        setLayout(new BorderLayout());
        setBackground(Color.DARK_GRAY);

        // Add header
        add(createHeaderPanel("Lancaster Music Hall"), BorderLayout.NORTH);

        // Content panel
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(Color.DARK_GRAY);

        // Title label
        JLabel titleLabel = new JLabel("Customer Data", JLabel.CENTER);
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        contentPanel.add(titleLabel, BorderLayout.NORTH);

        // Top panel for filters
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1, 6, 10, 10));
        topPanel.setBackground(Color.DARK_GRAY);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        JTextField nameField = new JTextField();
        nameField.setFont(new Font("Verdana", Font.PLAIN, 14));
        nameField.setPreferredSize(new Dimension(200, 30));

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setForeground(Color.WHITE);
        phoneLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        JTextField phoneField = new JTextField();
        phoneField.setFont(new Font("Verdana", Font.PLAIN, 14));
        phoneField.setPreferredSize(new Dimension(200, 30));

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        JTextField emailField = new JTextField();
        emailField.setFont(new Font("Verdana", Font.PLAIN, 14));
        emailField.setPreferredSize(new Dimension(200, 30));

        topPanel.add(nameLabel);
        topPanel.add(nameField);
        topPanel.add(phoneLabel);
        topPanel.add(phoneField);
        topPanel.add(emailLabel);
        topPanel.add(emailField);

        // Table for customer data
        String[] columnNames = {"Event Name", "Age", "Gender", "Phone", "Email", "Information"};
        Object[][] data = {};
        JTable salesTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(salesTable);
        salesTable.setFillsViewportHeight(true);

        // Bottom panel with Cancel button
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setBackground(Color.DARK_GRAY);
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Verdana", Font.PLAIN, 14));
        cancelButton.setPreferredSize(new Dimension(100, 40));
        addHoverEffect(cancelButton);
        cancelButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));
        bottomPanel.add(cancelButton);

        // Add components to content panel
        contentPanel.add(topPanel, BorderLayout.NORTH);
        contentPanel.add(scrollPane, BorderLayout.CENTER);
        contentPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Add content panel to this Customer panel
        add(contentPanel, BorderLayout.CENTER);
        add(createFooterPanel(), BorderLayout.SOUTH);
    }

    // hover effect method
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

    // Header panel
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

    // Footer panel
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