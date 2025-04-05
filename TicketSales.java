import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.YearMonth;

public class TicketSales extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private CardLayout ticketSaleLayout;
    private JPanel ticketSalePanel;
    private JLabel monthLabel;
    private JTable calendarTable;
    private DefaultTableModel calendarModel;
    private JTable eventsTable;
    private DefaultTableModel eventsModel;
    private LocalDate currentDate;

    public TicketSales(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        setLayout(new BorderLayout());
        setBackground(Color.DARK_GRAY);
        setPreferredSize(new Dimension(800, 600)); // Set a reasonable size
        System.out.println("TicketSales: Constructor started");

        currentDate = LocalDate.now(); // April 1, 2025
        System.out.println("TicketSales: Current date set to " + currentDate);

        // Add header
        add(createHeaderPanel("Lancaster Music Hall"), BorderLayout.NORTH);
        System.out.println("TicketSales: Header added");

        // Ticket sale panel with CardLayout for two steps
        ticketSaleLayout = new CardLayout();
        ticketSalePanel = new JPanel(ticketSaleLayout);
        ticketSalePanel.setBackground(Color.DARK_GRAY);
        ticketSalePanel.setPreferredSize(new Dimension(800, 500)); // Ensure the panel has a size
        System.out.println("TicketSales: ticketSalePanel created");

        monthLabel = new JLabel(currentDate.getMonth().toString() + " " + currentDate.getYear(), JLabel.CENTER);
        monthLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        monthLabel.setForeground(Color.WHITE);
        System.out.println("TicketSales: monthLabel created");

        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        calendarModel = new DefaultTableModel(6, 7) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        calendarTable = new JTable(calendarModel);
        calendarTable.setRowHeight(50);
        calendarTable.setFont(new Font("Verdana", Font.PLAIN, 14));
        calendarTable.setGridColor(Color.LIGHT_GRAY);
        calendarTable.setShowGrid(true);
        calendarTable.getTableHeader().setReorderingAllowed(false);
        calendarTable.getTableHeader().setResizingAllowed(false);
        calendarTable.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 14));
        calendarTable.setDefaultRenderer(Object.class, new CalendarCellRenderer());
        for (int i = 0; i < days.length; i++) {
            calendarTable.getColumnModel().getColumn(i).setHeaderValue(days[i]);
        }

        calendarTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = calendarTable.getSelectedRow();
                int col = calendarTable.getSelectedColumn();
                Object value = calendarTable.getValueAt(row, col);
                if (value != null && !value.toString().isEmpty()) {
                    int day = Integer.parseInt(value.toString().split(" ")[0]); // Extract the day number
                    LocalDate selectedDate = LocalDate.of(currentDate.getYear(), currentDate.getMonth(), day);
                    updateEventsTable(selectedDate);
                    ticketSaleLayout.show(ticketSalePanel, "EventView");
                }
            }
        });
        System.out.println("TicketSales: calendarTable created");

        String[] eventColumns = {"Name", "Venue", "Time", "Information", "Seats Left"};
        eventsModel = new DefaultTableModel(eventColumns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        eventsTable = new JTable(eventsModel);
        eventsTable.setRowHeight(30);
        eventsTable.setFont(new Font("Verdana", Font.PLAIN, 14));
        eventsTable.setGridColor(Color.LIGHT_GRAY);
        eventsTable.setShowGrid(true);
        eventsTable.getTableHeader().setReorderingAllowed(false);
        eventsTable.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 14));
        eventsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = eventsTable.getSelectedRow();
                if (row >= 0) {
                    String eventName = (String) eventsTable.getValueAt(row, 0);
                    System.out.println("Selected Event: " + eventName);
                    // Add navigation to a ticket purchase form here if needed
                }
            }
        });
        System.out.println("TicketSales: eventsTable created");

        // Step 1: Calendar view
        JPanel calendarView = createCalendarView();
        ticketSalePanel.add(calendarView, "CalendarView");
        System.out.println("TicketSales: CalendarView added");

        // Step 2: Event selection view
        JPanel eventView = createEventView();
        ticketSalePanel.add(eventView, "EventView");
        System.out.println("TicketSales: EventView added");

        add(ticketSalePanel, BorderLayout.CENTER);
        System.out.println("TicketSales: ticketSalePanel added to CENTER");

        add(createFooterPanel(), BorderLayout.SOUTH);
        System.out.println("TicketSales: Footer added");

        updateCalendar();
        System.out.println("TicketSales: Calendar updated");

        ticketSaleLayout.show(ticketSalePanel, "CalendarView");
        ticketSalePanel.revalidate();
        ticketSalePanel.repaint();
        System.out.println("TicketSales: Showing CalendarView");

        revalidate();
        repaint();
        System.out.println("TicketSales: Repaint and revalidate called");
    }

    private JPanel createCalendarView() {
        System.out.println("createCalendarView: Started");
        JPanel calendarPanel = new JPanel(new BorderLayout());
        calendarPanel.setBackground(Color.DARK_GRAY);

        // Month navigation panel
        JPanel monthPanel = new JPanel(new FlowLayout());
        monthPanel.setBackground(Color.DARK_GRAY);

        JButton prevMonthButton = new JButton("<");
        prevMonthButton.setFont(new Font("Verdana", Font.PLAIN, 14));
        prevMonthButton.setPreferredSize(new Dimension(50, 30));
        addHoverEffect(prevMonthButton);
        prevMonthButton.addActionListener(e -> {
            currentDate = currentDate.minusMonths(1);
            updateCalendar();
        });

        monthPanel.add(prevMonthButton);
        monthPanel.add(monthLabel);

        JButton nextMonthButton = new JButton(">");
        nextMonthButton.setFont(new Font("Verdana", Font.PLAIN, 14));
        nextMonthButton.setPreferredSize(new Dimension(50, 30));
        addHoverEffect(nextMonthButton);
        nextMonthButton.addActionListener(e -> {
            currentDate = currentDate.plusMonths(1);
            updateCalendar();
        });

        monthPanel.add(nextMonthButton);
        System.out.println("createCalendarView: Month navigation panel created");

        JScrollPane calendarScrollPane = new JScrollPane(calendarTable);
        calendarScrollPane.setBorder(BorderFactory.createEmptyBorder());
        calendarScrollPane.setPreferredSize(new Dimension(600, 300));
        System.out.println("createCalendarView: Calendar scroll pane created");

        JScrollPane eventsScrollPane = new JScrollPane(eventsTable);
        eventsScrollPane.setBorder(BorderFactory.createTitledBorder("Events:"));
        eventsScrollPane.setPreferredSize(new Dimension(600, 150));
        System.out.println("createCalendarView: Events scroll pane created");

        // Bottom panel with Cancel button
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setBackground(Color.DARK_GRAY);
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Verdana", Font.PLAIN, 14));
        cancelButton.setPreferredSize(new Dimension(100, 40));
        addHoverEffect(cancelButton);
        cancelButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));
        bottomPanel.add(cancelButton);
        System.out.println("createCalendarView: Bottom panel created");

        calendarPanel.add(monthPanel, BorderLayout.NORTH);
        calendarPanel.add(calendarScrollPane, BorderLayout.CENTER);
        calendarPanel.add(eventsScrollPane, BorderLayout.SOUTH);
        calendarPanel.add(bottomPanel, BorderLayout.SOUTH);
        System.out.println("createCalendarView: Components added to calendarPanel");

        return calendarPanel;
    }

    private JPanel createEventView() {
        System.out.println("createEventView: Started");
        JPanel eventPanel = new JPanel(new BorderLayout());
        eventPanel.setBackground(Color.DARK_GRAY);

        // Month navigation panel
        JPanel monthPanel = new JPanel(new FlowLayout());
        monthPanel.setBackground(Color.DARK_GRAY);

        JButton prevMonthButton = new JButton("<");
        prevMonthButton.setFont(new Font("Verdana", Font.PLAIN, 14));
        prevMonthButton.setPreferredSize(new Dimension(50, 30));
        addHoverEffect(prevMonthButton);
        prevMonthButton.addActionListener(e -> {
            currentDate = currentDate.minusMonths(1);
            updateCalendar();
            ticketSaleLayout.show(ticketSalePanel, "CalendarView");
        });

        monthPanel.add(prevMonthButton);
        monthPanel.add(monthLabel);

        JButton nextMonthButton = new JButton(">");
        nextMonthButton.setFont(new Font("Verdana", Font.PLAIN, 14));
        nextMonthButton.setPreferredSize(new Dimension(50, 30));
        addHoverEffect(nextMonthButton);
        nextMonthButton.addActionListener(e -> {
            currentDate = currentDate.plusMonths(1);
            updateCalendar();
            ticketSaleLayout.show(ticketSalePanel, "CalendarView");
        });

        monthPanel.add(nextMonthButton);
        System.out.println("createEventView: Month navigation panel created");

        JScrollPane calendarScrollPane = new JScrollPane(calendarTable);
        calendarScrollPane.setBorder(BorderFactory.createEmptyBorder());
        calendarScrollPane.setPreferredSize(new Dimension(600, 300));
        System.out.println("createEventView: Calendar scroll pane created");

        JScrollPane eventsScrollPane = new JScrollPane(eventsTable);
        eventsScrollPane.setBorder(BorderFactory.createTitledBorder("Events:"));
        eventsScrollPane.setPreferredSize(new Dimension(600, 150));
        System.out.println("createEventView: Events scroll pane created");

        // Bottom panel with Cancel button
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setBackground(Color.DARK_GRAY);
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Verdana", Font.PLAIN, 14));
        cancelButton.setPreferredSize(new Dimension(100, 40));
        addHoverEffect(cancelButton);
        cancelButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));
        bottomPanel.add(cancelButton);
        System.out.println("createEventView: Bottom panel created");

        eventPanel.add(monthPanel, BorderLayout.NORTH);
        eventPanel.add(calendarScrollPane, BorderLayout.CENTER);
        eventPanel.add(eventsScrollPane, BorderLayout.SOUTH);
        // Removed the duplicate bottomPanel addition
        eventPanel.add(bottomPanel, BorderLayout.SOUTH);
        System.out.println("createEventView: Components added to eventPanel");

        return eventPanel;
    }

    private void updateCalendar() {
        System.out.println("updateCalendar: Started");
        monthLabel.setText(currentDate.getMonth().toString() + " " + currentDate.getYear());
        YearMonth yearMonth = YearMonth.of(currentDate.getYear(), currentDate.getMonth());
        int daysInMonth = yearMonth.lengthOfMonth();
        LocalDate firstOfMonth = currentDate.withDayOfMonth(1);
        int firstDayOfWeek = firstOfMonth.getDayOfWeek().getValue() % 7; // Sunday = 0, Monday = 1, ..., Saturday = 6
        System.out.println("updateCalendar: First day of week: " + firstDayOfWeek);

        // Clear the calendar
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                calendarModel.setValueAt(null, row, col);
            }
        }

        // Populate the calendar
        int day = 1;
        for (int row = 0; row < 6 && day <= daysInMonth; row++) {
            for (int col = (row == 0 ? firstDayOfWeek : 0); col < 7 && day <= daysInMonth; col++) {
                calendarModel.setValueAt(day, row, col);
                System.out.println("updateCalendar: Setting day " + day + " at row " + row + ", col " + col);
                day++;
            }
        }

        // Highlight days with events
        int[] eventDays = {1, 8, 12, 24, 30}; // Example event days
        for (int eventDay : eventDays) {
            for (int row = 0; row < 6; row++) {
                for (int col = 0; col < 7; col++) {
                    Object value = calendarModel.getValueAt(row, col);
                    if (value != null && !value.toString().isEmpty()) {
                        String valueStr = value.toString();
                        if (!valueStr.contains("Events")) {
                            int dayValue = Integer.parseInt(valueStr);
                            if (dayValue == eventDay) {
                                calendarModel.setValueAt(eventDay + " Events", row, col);
                                System.out.println("updateCalendar: Highlighted day " + eventDay + " with events");
                            }
                        }
                    }
                }
            }
        }
        System.out.println("updateCalendar: Completed");
    }

    private void updateEventsTable(LocalDate selectedDate) {
        System.out.println("updateEventsTable: Started for date " + selectedDate);
        eventsModel.setRowCount(0);

        if (selectedDate.getDayOfMonth() == 1) {
            eventsModel.addRow(new Object[]{"Example Event 1", "Small Hall", "09:00 - 10:00", "Event description", "22"});
        } else if (selectedDate.getDayOfMonth() == 8) {
            eventsModel.addRow(new Object[]{"Example Event 2", "Big Hall", "13:00 - 14:00", "Event description", "09"});
        } else if (selectedDate.getDayOfMonth() == 12) {
            eventsModel.addRow(new Object[]{"Example Event 3", "Small Hall", "14:00 - 15:00", "Event description", "08"});
            eventsModel.addRow(new Object[]{"Example Event 4", "Big Hall", "15:00 - 16:00", "Event description", "34"});
            eventsModel.addRow(new Object[]{"Example Event 5", "Small Hall", "19:00 - 20:00", "Event description", "10"});
        } else if (selectedDate.getDayOfMonth() == 24) {
            eventsModel.addRow(new Object[]{"Example Event 6", "Big Hall", "17:00 - 18:00", "Event description", "15"});
        } else if (selectedDate.getDayOfMonth() == 30) {
            eventsModel.addRow(new Object[]{"Example Event 7", "Small Hall", "20:00 - 21:00", "Event description", "05"});
        }
        System.out.println("updateEventsTable: Completed");
    }

    private class CalendarCellRenderer extends javax.swing.table.DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            c.setBackground(Color.BLACK);
            c.setForeground(Color.WHITE);
            if (value != null && value.toString().contains("Events")) {
                c.setForeground(Color.RED);
            }
            return c;
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
}