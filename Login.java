import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Login extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public Login(CardLayout cardLayout, JPanel mainPanel) {
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
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Load and add the logo
        JLabel logoLabel = new JLabel();
        try {
            BufferedImage logoImage = ImageIO.read(new File("GUI_CODE/src/lancasters-music-hall-logo.png"));
            Image scaledImage = logoImage.getScaledInstance(350, 300, Image.SCALE_SMOOTH);
            logoLabel.setIcon(new ImageIcon(scaledImage));
            logoLabel.setHorizontalAlignment(JLabel.CENTER);
        } catch (IOException e) {
            e.printStackTrace();
            logoLabel.setText("Logo Not Found");
            logoLabel.setForeground(Color.RED);
        }
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        contentPanel.add(logoLabel, gbc);

        // Title label
        JLabel titleLabel = new JLabel("Login", JLabel.CENTER);
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 36));
        titleLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        contentPanel.add(titleLabel, gbc);

        // Username label and field
        JLabel userLabel = new JLabel("Username:");
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        contentPanel.add(userLabel, gbc);

        JTextField userField = new JTextField();
        userField.setFont(new Font("Verdana", Font.PLAIN, 18));
        userField.setPreferredSize(new Dimension(250, 40));
        gbc.gridx = 1;
        gbc.gridy = 2;
        contentPanel.add(userField, gbc);

        // Password label and field
        JLabel passLabel = new JLabel("Password:");
        passLabel.setForeground(Color.WHITE);
        passLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 3;
        contentPanel.add(passLabel, gbc);

        JPasswordField passField = new JPasswordField();
        passField.setFont(new Font("Verdana", Font.PLAIN, 18));
        passField.setPreferredSize(new Dimension(250, 40));
        gbc.gridx = 1;
        gbc.gridy = 3;
        contentPanel.add(passField, gbc);

        // Show password checkbox
        JCheckBox showPasswordCheckbox = new JCheckBox("Show password");
        showPasswordCheckbox.setForeground(Color.WHITE);
        showPasswordCheckbox.setBackground(Color.DARK_GRAY);
        showPasswordCheckbox.setFont(new Font("Verdana", Font.PLAIN, 14));
        showPasswordCheckbox.addActionListener(e -> {
            if (showPasswordCheckbox.isSelected()) {
                passField.setEchoChar((char) 0);
            } else {
                passField.setEchoChar('*');
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        contentPanel.add(showPasswordCheckbox, gbc);

        // Error label
        JLabel errorLabel = new JLabel("");
        errorLabel.setForeground(Color.RED);
        errorLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        contentPanel.add(errorLabel, gbc);

        // Login button
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Verdana", Font.PLAIN, 18));
        loginButton.setPreferredSize(new Dimension(150, 50));
        addHoverEffect(loginButton);
        loginButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());
            if (username.equals("admin") && password.equals("password")) {
                errorLabel.setText("Login successful");
                errorLabel.setForeground(Color.GREEN);
                Timer timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        cardLayout.show(mainPanel, "MainMenu");
                    }
                });
                timer.setRepeats(false);
                timer.start();
            } else {
                errorLabel.setText("Invalid username or password");
                errorLabel.setForeground(Color.RED);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        contentPanel.add(loginButton, gbc);

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