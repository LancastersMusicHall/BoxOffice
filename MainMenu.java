import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenu extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public MainMenu(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        setLayout(new BorderLayout());
        setBackground(Color.DARK_GRAY);

        // Add header
        add(createHeaderPanel("Lancaster Music Hall"), BorderLayout.NORTH);

        // Content panel with GridBagLayout
        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(Color.DARK_GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 10, 15, 10); // Add spacing between components
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title label
        JLabel titleLabel = new JLabel("Main Menu", JLabel.CENTER);
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 33)); // Larger font
        titleLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        contentPanel.add(titleLabel, gbc);

        //Issue refund button
        JButton refundButton = new JButton("Issue Refund");
        refundButton.setFont(new Font("Verdana", Font.PLAIN, 18)); // Larger font
        refundButton.setPreferredSize(new Dimension(200, 50)); // Larger size
        refundButton.addActionListener(e -> cardLayout.show(mainPanel, "Issue Refund"));
        addHoverEffect(refundButton);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        contentPanel.add(refundButton, gbc);

        // Make a Sale button
        JButton ticketButton = new JButton("Make a Sale");
        ticketButton.setFont(new Font("Verdana", Font.PLAIN, 18)); // Larger font
        ticketButton.setPreferredSize(new Dimension(200, 50)); // Larger size
        ticketButton.addActionListener(e -> cardLayout.show(mainPanel, "TicketSale"));
        addHoverEffect(ticketButton);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        contentPanel.add(ticketButton, gbc);

        // Manage Calendar button
        JButton calendarButton = new JButton("Manage Calendar");
        calendarButton.setFont(new Font("Verdana", Font.PLAIN, 18)); // Larger font
        calendarButton.setPreferredSize(new Dimension(200, 50)); // Larger size
        calendarButton.addActionListener(e -> cardLayout.show(mainPanel, "Calendar"));
        addHoverEffect(calendarButton);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        contentPanel.add(calendarButton, gbc);

        // Manage Website button
        JButton websiteButton = new JButton("Manage Website");
        websiteButton.setFont(new Font("Verdana", Font.PLAIN, 18)); // Larger font
        websiteButton.setPreferredSize(new Dimension(200, 50)); // Larger size
        websiteButton.addActionListener(e -> cardLayout.show(mainPanel, "Website"));
        addHoverEffect(websiteButton);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        contentPanel.add(websiteButton, gbc);

        // Manage Data label
        JLabel dataLabel = new JLabel("Manage Data", JLabel.CENTER);
        dataLabel.setFont(new Font("Verdana", Font.BOLD, 32)); // Larger font
        dataLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        contentPanel.add(dataLabel, gbc);

        // Sales button
        JButton salesButton = new JButton("Sales");
        salesButton.setFont(new Font("Verdana", Font.PLAIN, 18)); // Larger font
        salesButton.setPreferredSize(new Dimension(150, 50)); // Larger size
        salesButton.addActionListener(e -> cardLayout.show(mainPanel, "Sales"));
        addHoverEffect(salesButton);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.EAST;
        contentPanel.add(salesButton, gbc);

        // Customer button
        JButton customerButton = new JButton("Customer");
        customerButton.setFont(new Font("Verdana", Font.PLAIN, 18)); // Larger font
        customerButton.setPreferredSize(new Dimension(150, 50)); // Larger size
        customerButton.addActionListener(e -> cardLayout.show(mainPanel, "Customer"));
        addHoverEffect(customerButton);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        contentPanel.add(customerButton, gbc);

        // View Guide button
        JButton guideButton = new JButton("View Guide");
        guideButton.setFont(new Font("Verdana", Font.PLAIN, 18)); // Larger font
        guideButton.setPreferredSize(new Dimension(150, 50)); // Larger size
        guideButton.addActionListener(e -> cardLayout.show(mainPanel, "Guide"));
        addHoverEffect(guideButton);
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        contentPanel.add(guideButton, gbc);

        // Exit button
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Verdana", Font.PLAIN, 18)); // Larger font
        exitButton.setPreferredSize(new Dimension(150, 50)); // Larger size
        exitButton.addActionListener(e -> System.exit(0));
        addHoverEffect(exitButton);
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        contentPanel.add(exitButton, gbc);

        add(contentPanel, BorderLayout.CENTER);
        add(createFooterPanel(), BorderLayout.SOUTH);
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