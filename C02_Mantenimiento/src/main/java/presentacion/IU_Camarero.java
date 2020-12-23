package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IU_Camarero {

	private JFrame frame;

	/**
	 * Launch the application.
	 * @Param el unico parametro es un string
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 327, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAvisarCocina = new JButton("Avisar Cocina");
		btnAvisarCocina.setBounds(84, 174, 135, 23);
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
		btnCrearComanda.setBounds(84, 82, 135, 23);
		frame.getContentPane().add(btnCrearComanda);
		
		JButton btnAvisarBarra = new JButton("Avisar Barra");
		btnAvisarBarra.setBounds(84, 275, 135, 23);
		frame.getContentPane().add(btnAvisarBarra);
		
		JButton btnActualizarEstado = new JButton("Actualizar estado");
		btnActualizarEstado.setBounds(84, 372, 135, 23);
		frame.getContentPane().add(btnActualizarEstado);
	}
}
