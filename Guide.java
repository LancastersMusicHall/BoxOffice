import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Guide extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public Guide(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        setLayout(new BorderLayout());
        setBackground(Color.DARK_GRAY);

        // Add header
        add(createHeaderPanel("Lancaster Music Hall"), BorderLayout.NORTH);

        // Content panel with vertical BoxLayout
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.DARK_GRAY);

        // Title label
        JLabel title = new JLabel("Guide", JLabel.CENTER);
        title.setFont(new Font("Verdana", Font.BOLD, 36));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(Color.WHITE);
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        contentPanel.add(title);

        // "How to use this interface" button
        JButton howToUseBtn = new JButton("How to use this interface");
        howToUseBtn.setFont(new Font("Verdana", Font.PLAIN, 18));
        howToUseBtn.setPreferredSize(new Dimension(300, 50));
        howToUseBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        addHoverEffect(howToUseBtn);
        contentPanel.add(howToUseBtn);

        contentPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Quick Links label
        JLabel quickLinks = new JLabel("Quick Links", JLabel.CENTER);
        quickLinks.setFont(new Font("Verdana", Font.BOLD, 24));
        quickLinks.setAlignmentX(Component.CENTER_ALIGNMENT);
        quickLinks.setForeground(Color.WHITE);
        contentPanel.add(quickLinks);

        contentPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        // Quick Links buttons
        JButton loginBtn = new JButton("Login GUI");
        loginBtn.setFont(new Font("Verdana", Font.PLAIN, 18));
        loginBtn.setPreferredSize(new Dimension(250, 50));
        loginBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginBtn.addActionListener(e -> cardLayout.show(mainPanel, "Login"));
        addHoverEffect(loginBtn);

        JButton mainMenuBtn = new JButton("Main Menu GUI");
        mainMenuBtn.setFont(new Font("Verdana", Font.PLAIN, 18));
        mainMenuBtn.setPreferredSize(new Dimension(250, 50));
        mainMenuBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainMenuBtn.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));
        addHoverEffect(mainMenuBtn);

        JButton ticketBtn = new JButton("Selling a Ticket");
        ticketBtn.setFont(new Font("Verdana", Font.PLAIN, 18));
        ticketBtn.setPreferredSize(new Dimension(250, 50));
        ticketBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        ticketBtn.addActionListener(e -> cardLayout.show(mainPanel, "TicketSale"));
        addHoverEffect(ticketBtn);

        JButton calendarBtn = new JButton("Reviewing the Calendar");
        calendarBtn.setFont(new Font("Verdana", Font.PLAIN, 18));
        calendarBtn.setPreferredSize(new Dimension(250, 50));
        calendarBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        calendarBtn.addActionListener(e -> cardLayout.show(mainPanel, "Calendar"));
        addHoverEffect(calendarBtn);

        JButton websiteBtn = new JButton("Managing Online Website");
        websiteBtn.setFont(new Font("Verdana", Font.PLAIN, 18));
        websiteBtn.setPreferredSize(new Dimension(250, 50));
        websiteBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        websiteBtn.addActionListener(e -> cardLayout.show(mainPanel, "Website"));
        addHoverEffect(websiteBtn);

        JButton salesBtn = new JButton("Managing Sales Data");
        salesBtn.setFont(new Font("Verdana", Font.PLAIN, 18));
        salesBtn.setPreferredSize(new Dimension(250, 50));
        salesBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        salesBtn.addActionListener(e -> cardLayout.show(mainPanel, "Sales"));
        addHoverEffect(salesBtn);

        JButton customerBtn = new JButton("Managing Customer Data");
        customerBtn.setFont(new Font("Verdana", Font.PLAIN, 18));
        customerBtn.setPreferredSize(new Dimension(250, 50));
        customerBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        customerBtn.addActionListener(e -> cardLayout.show(mainPanel, "Customer"));
        addHoverEffect(customerBtn);

        JButton[] buttons = {loginBtn, mainMenuBtn, ticketBtn, calendarBtn, websiteBtn, salesBtn, customerBtn};
        for (JButton btn : buttons) {
            contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            contentPanel.add(btn);
        }

        contentPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Cancel button
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Verdana", Font.PLAIN, 18));
        cancelButton.setPreferredSize(new Dimension(150, 50));
        cancelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addHoverEffect(cancelButton);
        cancelButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));
        contentPanel.add(cancelButton);

        contentPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Add content panel to this Guide panel
        add(contentPanel, BorderLayout.CENTER);
        add(createFooterPanel(), BorderLayout.SOUTH);
    }

    // Add hover effect method
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