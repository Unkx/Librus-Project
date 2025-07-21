import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpeningScreen extends JFrame {

	// Dopasowane kolory z CalendarDashboard
	private final Color lightBg = new Color(245, 245, 245);
	private final Color lightButton = new Color(70, 130, 180);
	private final Color lightText = Color.WHITE;

	public OpeningScreen() {
		super("OpeningScreen");
		setSize(400, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		addGuiComponents();
		getContentPane().setBackground(lightBg); // Użyj tego samego tła co w CalendarDashboard
		setVisible(true);
	}

	private void addGuiComponents() {
		setLayout(null);

		JLabel helloLabel = new JLabel("Witaj w e-dzienniku", JLabel.CENTER);
		helloLabel.setBounds(50, 80, 300, 50);
		helloLabel.setFont(new Font("Roboto", Font.BOLD, 18));
		helloLabel.setForeground(new Color(60, 60, 60));
		add(helloLabel);

		JButton loginButtonTeacher = new JButton("Nauczyciel");
		styleButton(loginButtonTeacher);
		loginButtonTeacher.setBounds(100, 200, 200, 50);
		loginButtonTeacher.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginScreenTeacher();
			}
		});
		add(loginButtonTeacher);

		JButton loginButtonStudent = new JButton("Uczeń");
		styleButton(loginButtonStudent);
		loginButtonStudent.setBounds(100, 300, 200, 50);
		loginButtonStudent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginScreenStudent();
			}
		});
		add(loginButtonStudent);
	}

	private void styleButton(JButton button) {
		button.setFont(new Font("Roboto", Font.PLAIN, 18));
		button.setFocusPainted(false);
		button.setBackground(lightButton);       // Użyj tego samego koloru co CalendarDashboard
		button.setForeground(lightText);         // Biały tekst
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button.setOpaque(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new OpeningScreen());
	}
}
