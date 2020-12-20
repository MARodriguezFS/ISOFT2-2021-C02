package presentacion;

import dominio.GestorComanda;
import dominio.GestorCamarero;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class VentanaCuenta {

	private JFrame frame;
	private JTextField txtIDComanda;
	private JTextField txtPrecio;
	private JTextField txtIDMesa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCuenta window = new VentanaCuenta();
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
	public VentanaCuenta() {
		initialize();
	}
	
	public void set_visible(boolean b) {
		frame.setVisible(b);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 625, 299);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblIDComanda = new JLabel("Introduzca el ID de la comanda:");
		lblIDComanda.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIDComanda.setBounds(10, 38, 266, 33);
		frame.getContentPane().add(lblIDComanda);
		
		txtIDComanda = new JTextField();
		txtIDComanda.setBounds(286, 47, 96, 20);
		frame.getContentPane().add(txtIDComanda);
		txtIDComanda.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio de la comanda:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrecio.setBounds(10, 225, 179, 27);
		frame.getContentPane().add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(199, 231, 131, 20);
		frame.getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JButton btnCalcularPrecio = new JButton("Calacular Precio");
		btnCalcularPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GestorComanda gestor_comanda = new GestorComanda();
				try {
					GestorCamarero.cambiarEstado("Esperando la cuenta", Integer.parseInt(txtIDMesa.getText()));
					double cuenta = 0;
					cuenta = gestor_comanda.prepararCuenta(Integer.parseInt(txtIDComanda.getText()));
					txtPrecio.setText(String.valueOf(cuenta));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnCalcularPrecio.setBounds(253, 164, 111, 23);
		frame.getContentPane().add(btnCalcularPrecio);
		
		JLabel lblIDMesa = new JLabel("Introduzca el ID de la mesa que ha realizado el pago:");
		lblIDMesa.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIDMesa.setBounds(10, 92, 415, 32);
		frame.getContentPane().add(lblIDMesa);
		
		txtIDMesa = new JTextField();
		txtIDMesa.setBounds(435, 101, 96, 20);
		frame.getContentPane().add(txtIDMesa);
		txtIDMesa.setColumns(10);
		
		JButton btnConfirmarPago = new JButton("Confirmar Pago");
		btnConfirmarPago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					GestorCamarero.prepararMesa(Integer.parseInt(txtIDMesa.getText()));
					JOptionPane.showMessageDialog(frame, "Confirmado pago de la cuenta, cambiando el estado de la mesa...", "Cuenta Pagada",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnConfirmarPago.setBounds(340, 230, 111, 23);
		frame.getContentPane().add(btnConfirmarPago);
		
		JButton btnLiberarMesa = new JButton("Liberar Mesa");
		btnLiberarMesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				GestorCamarero.cambiarEstado("LIBRE", Integer.parseInt(txtIDMesa.getText()));
				JOptionPane.showMessageDialog(frame, "Mesa preparada, cambiando el estado de la mesa...", "Liberar Mesa",
						+ JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnLiberarMesa.setBounds(461, 230, 101, 23);
		frame.getContentPane().add(btnLiberarMesa);
	}
}