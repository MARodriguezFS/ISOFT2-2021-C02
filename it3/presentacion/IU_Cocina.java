package presentacion;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import dominio.GestorComanda;
import persistencia.Comanda;

import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class IU_Cocina {

	private JFrame frame;
	private JTextField txtAvisoComanda;
	private JList listComanda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Cocina window = new IU_Cocina();
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
	public IU_Cocina() {
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
		frame.setBounds(100, 100, 921, 611);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtAvisoComanda = new JTextField();
		txtAvisoComanda.setBounds(659, 227, 147, 31);
		frame.getContentPane().add(txtAvisoComanda);
		txtAvisoComanda.setColumns(10);
		
		JRadioButton rdbnComidaLista = new JRadioButton("COMANDA PREPARADA");
		rdbnComidaLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frame, "El camarero ha sido avisado de que la comanda está lista", "¡Comanda lista!",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		rdbnComidaLista.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbnComidaLista.setBounds(659, 294, 229, 64);
		frame.getContentPane().add(rdbnComidaLista);
		
		JLabel lblAvisoComanda = new JLabel("AVISO COMANDA");
		lblAvisoComanda.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAvisoComanda.setBounds(659, 184, 180, 32);
		frame.getContentPane().add(lblAvisoComanda);
		
		JLabel lblComandaActual = new JLabel("COMANDAS ACTUALES:");
		lblComandaActual.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblComandaActual.setBounds(200, 11, 202, 32);
		frame.getContentPane().add(lblComandaActual);
		
		listComanda = new JList();
		listComanda.setBounds(0, 54, 627, 520);
		final DefaultListModel modelo = new DefaultListModel();
		listComanda.setModel(modelo);
		listComanda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		frame.getContentPane().add(listComanda);
		GestorComanda gestor_comanda = new GestorComanda();
		try {
			LinkedList<Comanda> listaComandasBD = gestor_comanda.getListaComandas();
			modelo.addAll(listaComandasBD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void mostrarAviso(String arg) {
		txtAvisoComanda.setText(arg);
	}
}
