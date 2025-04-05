import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.YearMonth;

public class boxOfficeGUI {
    private JFrame frame;
    private CardLayout cardLayout;
    JPanel mainPanel;

    public boxOfficeGUI() {
        frame = new JFrame("Box Office System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setMinimumSize(new Dimension(600, 400));

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.add(new Login(cardLayout, mainPanel), "Login");
        mainPanel.add(new MainMenu(cardLayout, mainPanel), "MainMenu");
        mainPanel.add(new TicketSales(cardLayout, mainPanel), "TicketSale");
        mainPanel.add(new Calendar(cardLayout, mainPanel), "Calendar");
        mainPanel.add(new Website(cardLayout, mainPanel), "Website");
        mainPanel.add(new Sales(cardLayout, mainPanel), "Sales");
        mainPanel.add(new Customer(cardLayout, mainPanel), "Customer");
        mainPanel.add(new Guide(cardLayout, mainPanel), "Guide");
        mainPanel.add(new IssueRefund(cardLayout, mainPanel), "Issue Refund");

        mainPanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });

        frame.add(mainPanel);
        cardLayout.show(mainPanel, "Login"); // Start on the Login panel
        frame.setVisible(true);
    }

    // Method to create the header panel with a dynamic title
    JPanel createHeaderPanel(String title) {
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(0, 255, 170)); // background
        headerPanel.setPreferredSize(new Dimension(0, 55)); // Fixed height for header

        // Logo on the left
//        JLabel logoLabel;
//        try {
//            ImageIcon logoIcon = new ImageIcon("GUI_CODE/src/lancasters-music-hall-logo.png");
//            Image scaledImage = logoIcon.getImage().getScaledInstance(150, 47, Image.SCALE_SMOOTH);
//            logoIcon = new ImageIcon(scaledImage);
//            logoLabel = new JLabel(logoIcon);
//        } catch (Exception e) {
//            logoLabel = new JLabel("Lancaster's Music Hall");
//            logoLabel.setFont(new Font("Verdana", Font.BOLD, 16));
//            logoLabel.setForeground(Color.WHITE);
////        }
//        logoLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
//        headerPanel.add(logoLabel, BorderLayout.WEST);

        // Dynamic title in the center
        JLabel headerLabel = new JLabel(title, JLabel.CENTER);
        headerLabel.setFont(new Font("Verdana", Font.BOLD, 24));
        headerLabel.setForeground(Color.BLACK);
        headerPanel.add(headerLabel, BorderLayout.CENTER);

        return headerPanel;
    }

    // Method to create the footer panel
    JPanel createFooterPanel() {
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

    void addHoverEffect(JButton button) {
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBackground(new Color(60, 63, 65));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        // Add hover effect
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

    public static void main(String[] args) {
        new boxOfficeGUI();
    }
}