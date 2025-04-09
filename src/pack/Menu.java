package pack;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Menu() {
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);

		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(10, 10));
		contentPane.setBackground(new Color(230, 230, 250));
		setContentPane(contentPane);


		JLabel titleLabel = new JLabel("CALCULATOR");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
		titleLabel.setForeground(new Color(60, 60, 60));
		contentPane.add(titleLabel, BorderLayout.NORTH);

	
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));
		buttonPanel.setLayout(new GridLayout(4, 1, 15, 15)); 
		buttonPanel.setBackground(new Color(230, 230, 250)); 
		contentPane.add(buttonPanel, BorderLayout.CENTER);


		String[] buttonLabels = { "Addition", "Subtraction", "Multiplication", "Division" };
		for (String label : buttonLabels) {
			JButton button = new JButton(label);
			button.setFont(new Font("Segoe UI", Font.BOLD, 16));
			button.setBackground(new Color(100, 149, 237));
			button.setForeground(Color.WHITE);
			button.setFocusPainted(false);
			button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

	
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					button.setBackground(new Color(70, 130, 180)); 
				}
				@Override
				public void mouseExited(MouseEvent e) {
					button.setBackground(new Color(100, 149, 237));
				}
			});


			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					openNewForm(label); 
				}
			});

			buttonPanel.add(button);
		}
	}

	private void openNewForm(String operation) {
		JFrame newFrame = null;
		switch (operation) {
			case "Addition":
				newFrame = new Addition();
				break;
//			case "Subtraction":
//				newFrame = new Subtraction();
//				break;
//			case "Multiplication":
//				newFrame = new Multiplication();
//				break;
			case "Division":
				newFrame = new Division();
				break;
		}
		if (newFrame != null) {
			newFrame.setSize(550, 350);
			newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			newFrame.setLocationRelativeTo(this);
			newFrame.setVisible(true);
		}
	}
}
