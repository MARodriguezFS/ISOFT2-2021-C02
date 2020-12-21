package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dominio.GestorEstadisticas;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;

public class IU_Supervisor {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Supervisor window = new IU_Supervisor();
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
	public IU_Supervisor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 819, 547);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Tiempo Toma Comanda");
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GestorEstadisticas ge = new GestorEstadisticas();
				try {
					double tiempo = ge.tiempoComandas();
					JOptionPane.showMessageDialog(frame, "Ha tardado "+tiempo+" tiempo en tomar la comanda", "Tiempo Comanda",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(287, 77, 247, 64);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Tiempo preparacion Mesa");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GestorEstadisticas ge = new GestorEstadisticas();
				try {
					double tiempo = ge.tiempoMesa();
					JOptionPane.showMessageDialog(frame, "Ha tardado "+tiempo+" tiempo en preparar la mesa", "Tiempo Mesa",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnNewButton_1.setBounds(287, 370, 247, 64);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Tiempo Preparacion Comida");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GestorEstadisticas ge = new GestorEstadisticas();
				try {
					double tiempo = ge.tiempoComida();
					JOptionPane.showMessageDialog(frame, "Ha tardado "+tiempo+" tiempo en preparar comida", "Tiempo Comida",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnNewButton_1_1.setBounds(287, 172, 247, 64);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Tiempo de espera Cuenta");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GestorEstadisticas ge = new GestorEstadisticas();
				try {
					double tiempo = ge.tiempoCuenta();
					JOptionPane.showMessageDialog(frame, "Ha tardado "+tiempo+" tiempo en esperar cuenta", "Tiempo Cuenta",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1_2.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnNewButton_1_2.setBounds(287, 268, 247, 64);
		frame.getContentPane().add(btnNewButton_1_2);
		
		JLabel lblNewLabel = new JLabel("Consulta de Estadisticas");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 23));
		lblNewLabel.setBounds(272, 10, 369, 46);
		frame.getContentPane().add(lblNewLabel);
	}
}
