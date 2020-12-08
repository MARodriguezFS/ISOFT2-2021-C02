package presentacion;

import dominio.GestorComanda;
import persistencia.Comanda;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class IU_CamareroBarra {

	private JFrame frame;
	private JTextField txtEstadoComanda;
	private JRadioButton rdbnAvisarCamarero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_CamareroBarra window = new IU_CamareroBarra();
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
	public IU_CamareroBarra() {
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
		frame.setBounds(100, 100, 956, 667);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblComandas = new JLabel("COMANDAS:");
		lblComandas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblComandas.setBounds(278, 11, 180, 32);
		frame.getContentPane().add(lblComandas);
		
		JLabel lblAvisoComanda = new JLabel("AVISO DE COMANDA");
		lblAvisoComanda.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAvisoComanda.setBounds(721, 184, 180, 32);
		frame.getContentPane().add(lblAvisoComanda);
		
		txtEstadoComanda = new JTextField();
		txtEstadoComanda.setColumns(10);
		txtEstadoComanda.setBounds(721, 227, 168, 31);
		frame.getContentPane().add(txtEstadoComanda);
		
		rdbnAvisarCamarero = new JRadioButton("AVISAR CAMARERO");
		rdbnAvisarCamarero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frame, "Se ha avisado al camarero", "Avisar Camarero",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		rdbnAvisarCamarero.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbnAvisarCamarero.setBounds(721, 307, 202, 64);
		frame.getContentPane().add(rdbnAvisarCamarero);
		
		JList listComandas = new JList();
		listComandas.setBounds(0, 43, 685, 587);
		final DefaultListModel modelo = new DefaultListModel();
		listComandas.setModel(modelo);
		listComandas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		frame.getContentPane().add(listComandas);
		GestorComanda gestor_comanda = new GestorComanda();
		try {
			LinkedList<Comanda> listaComandasBD = gestor_comanda.getListaComandas();
			modelo.addAll(listaComandasBD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void mostrarAviso(String arg) {
		txtEstadoComanda.setText(arg);
	}
}
