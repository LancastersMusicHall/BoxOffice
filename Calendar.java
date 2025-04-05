import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class Calendar extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private YearMonth currentMonth;
    private JPanel calendarGrid;
    private JLabel monthLabel;
    private DefaultTableModel tableModel;
    private List<Event> events;
    private LocalDate selectedDate;
    private JLabel[] dayLabels;

    public Calendar(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        setLayout(new BorderLayout());
        setBackground(Color.DARK_GRAY);

        // Initialize current month
        currentMonth = YearMonth.now();

        // Add header
        add(createHeaderPanel("Lancaster Music Hall"), BorderLayout.NORTH);

        // Content panel
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(Color.DARK_GRAY);

        // Calendar panel
        JPanel calendarPanel = createCalendarPanel();
        contentPanel.add(calendarPanel, BorderLayout.NORTH);

        // Table for event details
        tableModel = new DefaultTableModel(
                new String[]{"Name", "Venue", "Time", "Information", "Seats Left"},
                0
        );
        JTable table = new JTable(tableModel);
        table.setFont(new Font("Verdana", Font.PLAIN, 14));
        table.setRowHeight(30);
        table.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 14));
        table.getTableHeader().setBackground(new Color(0, 255, 170));
        table.getTableHeader().setForeground(Color.BLACK);
        table.setGridColor(Color.LIGHT_GRAY);
        table.setShowGrid(true);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        // Events label
        JPanel eventsLabelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        eventsLabelPanel.setBackground(Color.DARK_GRAY);
        JLabel eventsLabel = new JLabel("Events:");
        eventsLabel.setForeground(Color.WHITE);
        eventsLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        eventsLabelPanel.add(eventsLabel);

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
        contentPanel.add(eventsLabelPanel, BorderLayout.CENTER);
        contentPanel.add(scrollPane, BorderLayout.CENTER);
        contentPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Add content panel to this Calendar panel
        add(contentPanel, BorderLayout.CENTER);
        add(createFooterPanel(), BorderLayout.SOUTH);

        // Initialize events and populate table
        initializeEvents();
        updateCalendar();
        updateTable(null); // Initially show all events
    }

    private JPanel createCalendarPanel() {
        JPanel calendarPanel = new JPanel(new BorderLayout());
        calendarPanel.setBackground(Color.DARK_GRAY);

        // Month navigation
        JPanel monthPanel = new JPanel(new FlowLayout());
        monthPanel.setBackground(Color.DARK_GRAY);
        JButton prevButton = new JButton("<");
        prevButton.setFont(new Font("Verdana", Font.PLAIN, 14));
        addHoverEffect(prevButton);
        prevButton.addActionListener(e -> {
            currentMonth = currentMonth.minusMonths(1);
            updateCalendar();
            updateTable(null); // Reset table to show all events
        });

        monthLabel = new JLabel(currentMonth.getMonth().toString() + " " + currentMonth.getYear(), JLabel.CENTER);
        monthLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        monthLabel.setForeground(Color.WHITE);

        JButton nextButton = new JButton(">");
        nextButton.setFont(new Font("Verdana", Font.PLAIN, 14));
        addHoverEffect(nextButton);
        nextButton.addActionListener(e -> {
            currentMonth = currentMonth.plusMonths(1);
            updateCalendar();
            updateTable(null); // Reset table to show all events
        });

        monthPanel.add(prevButton);
        monthPanel.add(monthLabel);
        monthPanel.add(nextButton);

        // Calendar grid
        calendarGrid = new JPanel(new GridLayout(0, 7, 5, 5));
        calendarGrid.setBackground(Color.DARK_GRAY);

        // Add day headers
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        for (String day : days) {
            JLabel dayLabel = new JLabel(day, JLabel.CENTER);
            dayLabel.setForeground(Color.WHITE);
            dayLabel.setFont(new Font("Verdana", Font.BOLD, 14));
            calendarGrid.add(dayLabel);
        }

        calendarPanel.add(monthPanel, BorderLayout.NORTH);
        calendarPanel.add(calendarGrid, BorderLayout.CENTER);
        return calendarPanel;
    }

    private void initializeEvents() {
        events = new ArrayList<>();
        // Dummy events for March 2025
        events.add(new Event("Concert A", "Big Hall", "09:00 - 12:00", "Rock concert", 50, LocalDate.of(2025, 3, 8)));
        events.add(new Event("Play B", "Small Hall", "14:00 - 16:00", "Theater play", 30, LocalDate.of(2025, 3, 14)));
        events.add(new Event("Concert C", "Big Hall", "19:00 - 22:00", "Jazz night", 20, LocalDate.of(2025, 3, 14)));
        events.add(new Event("Event D", "Small Hall", "09:00 - 11:00", "Event description", 22, LocalDate.of(2025, 3, 24)));
        events.add(new Event("Event E", "Big Hall", "12:00 - 14:00", "Event description", 89, LocalDate.of(2025, 3, 24)));
        events.add(new Event("Event F", "Small Hall", "14:00 - 15:00", "Event description", 8, LocalDate.of(2025, 3, 24)));
        events.add(new Event("Event G", "Big Hall", "15:00 - 17:00", "Event description", 34, LocalDate.of(2025, 3, 24)));
        events.add(new Event("Event H", "Small Hall", "17:00 - 19:00", "Event description", 12, LocalDate.of(2025, 3, 24)));
        events.add(new Event("Event I", "Big Hall", "19:00 - 21:00", "Event description", 18, LocalDate.of(2025, 3, 24)));
    }

    private void updateCalendar() {
        calendarGrid.removeAll();
        calendarGrid.setLayout(new GridLayout(0, 7, 5, 5));

        // Add day headers
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        for (String day : days) {
            JLabel dayLabel = new JLabel(day, JLabel.CENTER);
            dayLabel.setForeground(Color.WHITE);
            dayLabel.setFont(new Font("Verdana", Font.BOLD, 14));
            calendarGrid.add(dayLabel);
        }

        // Update month label
        monthLabel.setText(currentMonth.getMonth().toString() + " " + currentMonth.getYear());

        // Get first day of the month and number of days
        LocalDate firstOfMonth = currentMonth.atDay(1);
        int dayOfWeek = firstOfMonth.getDayOfWeek().getValue() % 7; // Sunday = 0, Monday = 1, ..., Saturday = 6
        int daysInMonth = currentMonth.lengthOfMonth();

        // Add empty labels for days before the first day
        for (int i = 0; i < dayOfWeek; i++) {
            calendarGrid.add(new JLabel(""));
        }

        // Add day labels
        dayLabels = new JLabel[daysInMonth];
        for (int day = 1; day <= daysInMonth; day++) {
            LocalDate date = currentMonth.atDay(day);
            JLabel dayLabel = new JLabel(String.valueOf(day), JLabel.CENTER);
            dayLabel.setForeground(Color.WHITE);
            dayLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
            dayLabel.setOpaque(true);
            dayLabel.setBackground(Color.BLACK);

            // Check if there are events on this day
            long eventCount = events.stream().filter(e -> e.getDate().equals(date)).count();
            if (eventCount > 0) {
                dayLabel.setForeground(Color.RED);
                dayLabel.setText(day + "<br>" + eventCount + " Event" + (eventCount > 1 ? "s" : ""));
            }

            // Highlight selected date
            if (selectedDate != null && selectedDate.equals(date)) {
                dayLabel.setBackground(Color.ORANGE);
            }

            // Add mouse listener for clicking on a date
            dayLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    selectedDate = date;
                    updateTable(selectedDate);
                    updateCalendar(); // Refresh to highlight selected date
                }
            });

            dayLabels[day - 1] = dayLabel;
            calendarGrid.add(dayLabel);
        }

        // Add empty labels to fill the grid
        int totalCells = dayOfWeek + daysInMonth;
        int remainingCells = (7 - (totalCells % 7)) % 7;
        for (int i = 0; i < remainingCells; i++) {
            calendarGrid.add(new JLabel(""));
        }

        calendarGrid.revalidate();
        calendarGrid.repaint();
    }

    private void updateTable(LocalDate date) {
        tableModel.setRowCount(0); // Clear the table
        List<Event> eventsToShow = (date == null) ? events : events.stream()
                .filter(e -> e.getDate().equals(date))
                .toList();

        for (Event event : eventsToShow) {
            tableModel.addRow(new Object[]{
                    event.getName(),
                    event.getVenue(),
                    event.getTime(),
                    event.getInformation(),
                    event.getSeatsLeft()
            });
        }
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

    // Event class to store event details
    public static class Event {
        private String name;
        private String venue;
        private String time;
        private String information;
        private int seatsLeft;
        private LocalDate date;

        public Event(String name, String venue, String time, String information, int seatsLeft, LocalDate date) {
            this.name = name;
            this.venue = venue;
            this.time = time;
            this.information = information;
            this.seatsLeft = seatsLeft;
            this.date = date;
        }

        public String getName() { return name; }
        public String getVenue() { return venue; }
        public String getTime() { return time; }
        public String getInformation() { return information; }
        public int getSeatsLeft() { return seatsLeft; }
        public LocalDate getDate() { return date; }
    }
}