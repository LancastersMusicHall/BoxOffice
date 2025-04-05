import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VenueMapPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public VenueMapPanel(CardLayout cardLayout, JPanel mainPanel, String venueName) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        setLayout(new BorderLayout());
        setBackground(Color.DARK_GRAY);

        String imagePath = "";
        if (venueName.equals("Small Venue")) {
            imagePath = "GUI_CODE/src/SmallHall-SeatingPlan.png";
        } else if (venueName.equals("Main Hall")) {
            imagePath = "GUI_CODE/src/MainHall-SeatingPlan.png";
        }
//        ImageIcon icon = new ImageIcon(imagePath);
//        JLabel imageLabel = new JLabel(icon);
        ImageIcon rawIcon = new ImageIcon(imagePath);
        Image scaledImage = rawIcon.getImage().getScaledInstance(
                Toolkit.getDefaultToolkit().getScreenSize().width - 200,
                Toolkit.getDefaultToolkit().getScreenSize().height - 200,
                Image.SCALE_SMOOTH
        );
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon);

        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        JScrollPane scrollPane = new JScrollPane(imageLabel);
        add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.DARK_GRAY);
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Verdana", Font.PLAIN, 14));
        backButton.setPreferredSize(new Dimension(100, 35));
        backButton.setBackground(new Color(60, 63, 65));
        backButton.setForeground(Color.WHITE);
        backButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        backButton.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backButton.setBackground(new Color(0, 255, 170));
                backButton.setForeground(Color.BLACK);
                backButton.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 170), 2));
                backButton.setFocusPainted(false);
                backButton.setContentAreaFilled(false);
                backButton.setOpaque(true);
                backButton.setBackground(new Color(60, 63, 65));
                backButton.setForeground(Color.WHITE);
                backButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            }


            public void mouseExited(java.awt.event.MouseEvent evt) {
                backButton.setBackground(new Color(60, 63, 65));
                backButton.setForeground(Color.WHITE);
                backButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            }
        });

        // Action: return to SeatManager
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "SeatManager");
            }
        });

        bottomPanel.add(backButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}


