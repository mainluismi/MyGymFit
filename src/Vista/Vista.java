package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;

public class Vista {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista window = new Vista();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Vista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JTextPane txtpnBienvenidoAMygymfit = new JTextPane();
		txtpnBienvenidoAMygymfit.setBackground(new Color(255, 255, 255));
		txtpnBienvenidoAMygymfit.setText("Bienvenido a MyGymFit");
		panel.add(txtpnBienvenidoAMygymfit, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton_1 = new JButton("Ver clientes");
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Nuevo cliente");
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Eliminar cliente");
		btnNewButton.setBackground(new Color(0, 0, 0));
		panel_1.add(btnNewButton);
	}

}
