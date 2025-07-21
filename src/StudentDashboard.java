import javax.swing.*;
import java.awt.*;

public class StudentDashboard extends JFrame {
	private String username;

	// Kolory dopasowane do CalendarDashboard
	private final Color lightBg = new Color(245, 245, 245);
	private final Color lightButton = new Color(70, 130, 180);
	private final Color lightText = Color.WHITE;

	public StudentDashboard(String username) {
		super("Student Dashboard");
		this.username = username;
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		initializeComponents();
		getContentPane().setBackground(lightBg); // Spójny kolor tła
		setVisible(true);
	}

	private void initializeComponents() {
		setLayout(new BorderLayout());

		JLabel titleLabel = new JLabel("Witaj, " + username, JLabel.CENTER);
		titleLabel.setFont(new Font("Roboto", Font.BOLD, 18));
		titleLabel.setForeground(new Color(60, 60, 60));
		add(titleLabel, BorderLayout.NORTH);

		JPanel buttonPanel = new JPanel(new GridLayout(3, 2, 10, 10));
		buttonPanel.setBackground(lightBg); // Jasne tło zamiast niebieskiego

		JButton viewGradesButton = new JButton("Zobacz oceny");
		JButton viewMessageButton = new JButton("Zobacz wiadomości");
		JButton calendarButton = new JButton("Kalendarz");
		JButton profileButton = new JButton("Profil");

		styleButton(viewGradesButton);
		styleButton(viewMessageButton);
		styleButton(calendarButton);
		styleButton(profileButton);

		buttonPanel.add(viewGradesButton);
		buttonPanel.add(viewMessageButton);
		buttonPanel.add(calendarButton);
		buttonPanel.add(profileButton);

		add(buttonPanel, BorderLayout.CENTER);

		viewGradesButton.addActionListener(e -> new ViewGradesScreen(username, "student"));
		viewMessageButton.addActionListener(e -> new MessageScreen(username));
		calendarButton.addActionListener(e -> new CalendarDashboard(username, "student"));
		profileButton.addActionListener(e -> new StudentProfile(username));
	}

	private void styleButton(JButton button) {
		button.setFont(new Font("Roboto", Font.BOLD, 16));
		button.setFocusPainted(false);
		button.setBackground(lightButton);   // Niebieski jak w CalendarDashboard
		button.setForeground(lightText);     // Biały tekst
		button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Padding zamiast border
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button.setOpaque(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new StudentDashboard("Student"));
	}
}
