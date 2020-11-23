package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import java.awt.Font;
import java.util.LinkedList;
import dominio.GestorMesa;
import dominio.GestorCamarero;
import persistencia.Mesa;
import persistencia.Camarero;

public class IUJefeDeSala{

	private JFrame frame;
	private JList lista_mesas;
	private JButton btnReservarMesa;
	private JButton btnCancelarReserva;
	private JButton btnAsignarCamarero;
	private JComboBox comboBox_camareros;


	/**
	 * Create the application.
	 */
	public IUJefeDeSala() {
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
		frame.setBounds(new Rectangle(0, 0, 1024, 768));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lista_mesas = new JList();
		DefaultListModel modelo = new DefaultListModel();
		lista_mesas.setModel(modelo);
		lista_mesas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lista_mesas.setBounds(0, 0, 241, 739);
		frame.getContentPane().add(lista_mesas);
		GestorMesa gestor_mesa = new GestorMesa();
		try {
			LinkedList<Mesa> lista_mesas_BD = gestor_mesa.getListaMesas();
			modelo.addAll(lista_mesas_BD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		btnReservarMesa = new JButton("Reservar mesa");
		btnReservarMesa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnReservarMesa.setBounds(251, 48, 175, 157);
		frame.getContentPane().add(btnReservarMesa);
		
		btnCancelarReserva = new JButton("Cancelar reserva");
		btnCancelarReserva.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancelarReserva.setBounds(251, 248, 175, 157);
		frame.getContentPane().add(btnCancelarReserva);
		
		btnAsignarCamarero = new JButton("Asignar camarero");
		btnAsignarCamarero.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAsignarCamarero.setBounds(489, 248, 175, 157);
		frame.getContentPane().add(btnAsignarCamarero);
		
		comboBox_camareros = new JComboBox();
		comboBox_camareros.setBounds(489, 173, 175, 32);
		frame.getContentPane().add(comboBox_camareros);
		GestorCamarero gestor_camarero = new GestorCamarero();
		try {
			LinkedList<Camarero> lista_camareros_BD = gestor_camarero.get_lista_camareros();
			while(!lista_camareros_BD.isEmpty()) {
				comboBox_camareros.addItem(lista_camareros_BD.poll().get_id());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
