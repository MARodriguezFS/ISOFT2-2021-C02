package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class VentanaComanda {

	private JFrame frame;
	private JTextField txtPrimero;
	private JTextField txtSegundo;
	private JTextField txtPostre;
	private JTextField txtBebida;
	private JTextField txtEntrantes;
	private JTextField txtID;
	private JTextField txtIDCamarero;
	private JTextField txtIDMesa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaComanda window = new VentanaComanda();
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
	public VentanaComanda() {
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
		frame.setBounds(100, 100, 450, 548);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtPrimero = new JTextField();
		txtPrimero.setBounds(170, 11, 110, 20);
		frame.getContentPane().add(txtPrimero);
		txtPrimero.setColumns(10);
		
		JLabel lblPrimero = new JLabel("Primero:");
		lblPrimero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrimero.setBounds(76, 14, 63, 14);
		frame.getContentPane().add(lblPrimero);
		
		txtSegundo = new JTextField();
		txtSegundo.setColumns(10);
		txtSegundo.setBounds(170, 64, 110, 20);
		frame.getContentPane().add(txtSegundo);
		
		JLabel lblSegundo = new JLabel("Segundo:");
		lblSegundo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSegundo.setBounds(76, 67, 63, 14);
		frame.getContentPane().add(lblSegundo);
		
		JLabel lblPostre = new JLabel("Postre:");
		lblPostre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPostre.setBounds(76, 126, 63, 14);
		frame.getContentPane().add(lblPostre);
		
		txtPostre = new JTextField();
		txtPostre.setColumns(10);
		txtPostre.setBounds(170, 123, 110, 20);
		frame.getContentPane().add(txtPostre);
		
		txtBebida = new JTextField();
		txtBebida.setColumns(10);
		txtBebida.setBounds(170, 179, 110, 20);
		frame.getContentPane().add(txtBebida);
		
		JLabel lblBebida = new JLabel("Bebida:");
		lblBebida.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBebida.setBounds(76, 182, 63, 14);
		frame.getContentPane().add(lblBebida);
		
		JLabel lblEntrantes = new JLabel("Entrantes:");
		lblEntrantes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntrantes.setBounds(76, 240, 63, 14);
		frame.getContentPane().add(lblEntrantes);
		
		txtEntrantes = new JTextField();
		txtEntrantes.setColumns(10);
		txtEntrantes.setBounds(170, 237, 110, 20);
		frame.getContentPane().add(txtEntrantes);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setHorizontalAlignment(SwingConstants.RIGHT);
		lblID.setBounds(76, 293, 63, 14);
		frame.getContentPane().add(lblID);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(170, 290, 110, 20);
		frame.getContentPane().add(txtID);
		
		JButton btnAnotarComanda = new JButton("Anotar comanda");
		btnAnotarComanda.setBounds(166, 477, 114, 23);
		frame.getContentPane().add(btnAnotarComanda);
		
		JLabel lblIDCamarero = new JLabel("IdCamarero:");
		lblIDCamarero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIDCamarero.setBounds(76, 351, 63, 14);
		frame.getContentPane().add(lblIDCamarero);
		
		txtIDCamarero = new JTextField();
		txtIDCamarero.setBounds(170, 348, 110, 20);
		frame.getContentPane().add(txtIDCamarero);
		txtIDCamarero.setColumns(10);
		
		JLabel lblIDMesa = new JLabel("IdMesa:");
		lblIDMesa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIDMesa.setBounds(76, 407, 63, 14);
		frame.getContentPane().add(lblIDMesa);
		
		txtIDMesa = new JTextField();
		txtIDMesa.setBounds(170, 404, 110, 20);
		frame.getContentPane().add(txtIDMesa);
		txtIDMesa.setColumns(10);
	}

}
