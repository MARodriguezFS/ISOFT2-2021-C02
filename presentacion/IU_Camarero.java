package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;

import dominio.GestorCamarero;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class IU_Camarero {

	private JFrame frame;
	private JTextField txtIDMesa;
	private JTextField txtNuevoEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Camarero window = new IU_Camarero();
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
	public IU_Camarero() {
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
		frame.setBounds(100, 100, 305, 457);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAvisarCocina = new JButton("Avisar Cocina");
		btnAvisarCocina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IU_Cocina iu_cocina = new IU_Cocina();
				iu_cocina.mostrarAviso();
				try {
					iu_cocina.set_visible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				frame.setVisible(false);
			}
		});
		btnAvisarCocina.setBounds(79, 100, 135, 23);
		frame.getContentPane().add(btnAvisarCocina);
		
		JButton btnCrearComanda = new JButton("Crear Comanda");
		btnCrearComanda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					VentanaComanda ventana_comanda = new VentanaComanda();
					ventana_comanda.set_visible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				frame.setVisible(false);
			}
		});
		btnCrearComanda.setBounds(79, 37, 135, 23);
		frame.getContentPane().add(btnCrearComanda);
		
		JButton btnAvisarBarra = new JButton("Avisar Barra");
		btnAvisarBarra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IU_CamareroBarra iu_camarerobarra = new IU_CamareroBarra();
				//iu_camarerobarra.mostrarAviso("Comanda Realizada");
				try {
					//iu_camarerobarra.set_visible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				frame.setVisible(false);
			}
		});
		btnAvisarBarra.setBounds(79, 160, 135, 23);
		frame.getContentPane().add(btnAvisarBarra);
		
		JButton btnActualizarEstado = new JButton("Actualizar estado");
		btnActualizarEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GestorCamarero gestor_camarero = new GestorCamarero();
				try {
				gestor_camarero.cambiarEstado(txtNuevoEstado.getText(), Integer.parseInt(txtIDMesa.getText()));
				JOptionPane.showMessageDialog(frame, "Se ha acutlizado el estado de la mesa correctamente", "Actulizar estado",
						JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnActualizarEstado.setBounds(83, 386, 135, 23);
		frame.getContentPane().add(btnActualizarEstado);
		
		JLabel lblEstado = new JLabel("Nuevo Estado:");
		lblEstado.setBounds(29, 306, 76, 14);
		frame.getContentPane().add(lblEstado);
		
		txtNuevoEstado = new JTextField();
		txtNuevoEstado.setBounds(29, 331, 96, 20);
		frame.getContentPane().add(txtNuevoEstado);
		txtNuevoEstado.setColumns(10);
		
		JLabel lblIDMesa = new JLabel("ID mesa:");
		lblIDMesa.setBounds(169, 306, 49, 14);
		frame.getContentPane().add(lblIDMesa);
		
		txtIDMesa = new JTextField();
		txtIDMesa.setBounds(169, 331, 96, 20);
		frame.getContentPane().add(txtIDMesa);
		txtIDMesa.setColumns(10);
		
		JButton btnCuenta = new JButton("Generar Cuenta");
		btnCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaCuenta ventana_cuenta = new VentanaCuenta();
				try {
					ventana_cuenta.set_visible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				frame.setVisible(false);
			}
		});
		btnCuenta.setBounds(79, 225, 135, 23);
		frame.getContentPane().add(btnCuenta);
	}
}