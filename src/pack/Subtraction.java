package pack;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Subtraction extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNum1, txtNum2;
	private JLabel lblResult;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Subtraction frame = new Subtraction();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Subtraction() {
		setTitle("Subtraction Form");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(10, 10));
		setContentPane(contentPane);

		contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 2, 15, 15));
		panel.setBackground(new Color(240, 248, 255));
		contentPane.add(panel, BorderLayout.CENTER);

		JLabel lblNum1 = new JLabel("Number 1:");
		lblNum1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNum1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNum1);

		txtNum1 = new JTextField();
		txtNum1.setFont(new Font("Arial", Font.PLAIN, 16));
		txtNum1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(txtNum1);
		txtNum1.setColumns(10);

		JLabel lblNum2 = new JLabel("Number 2:");
		lblNum2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNum2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNum2);

		txtNum2 = new JTextField();
		txtNum2.setFont(new Font("Arial", Font.PLAIN, 16));
		txtNum2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(txtNum2);
		txtNum2.setColumns(10);

		JButton btnSubtract = new JButton("Subtract");
		btnSubtract.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnSubtract.setBackground(new Color(100, 149, 237));
		btnSubtract.setForeground(Color.WHITE);
		btnSubtract.setFocusPainted(false);
		btnSubtract.setPreferredSize(new Dimension(100, 40));
		btnSubtract.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnSubtract.setBackground(new Color(70, 130, 180));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnSubtract.setBackground(new Color(100, 149, 237));
			}
		});
		panel.add(btnSubtract);

		lblResult = new JLabel("");
		lblResult.setFont(new Font("Arial", Font.BOLD, 16));
		lblResult.setForeground(new Color(34, 139, 34));
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblResult);

		btnSubtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double num1 = Double.parseDouble(txtNum1.getText());
					double num2 = Double.parseDouble(txtNum2.getText());
					double result = num1 - num2;
					lblResult.setText(num1 + " - " + num2 + " = " + result);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(Subtraction.this, "Please enter valid numbers!", 
						"Input Error", JOptionPane.ERROR_MESSAGE);
					lblResult.setText("");
				}
			}
		});
	}
}
