package presentacion;

import javax.swing.JFrame;
import presentacion.HorasTurnos;
import java.awt.Rectangle;
import javax.swing.JList;
import javax.swing.JButton;

import javax.swing.ListSelectionModel;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import java.awt.Font;
import java.util.LinkedList;

import dominio.GestorMesa;
import dominio.GestorReservas;
import dominio.EstadosMesas;
import dominio.GestorCamarero;
import persistencia.Mesa;
import persistencia.Camarero;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class IUJefeDeSala implements HorasTurnos, EstadosMesas{

	private JFrame frame;
	private JList lista_mesas;
	private JButton btnReservarMesa;
	private JButton btnCancelarReserva;
	private JButton btnAsignarCamarero;
	private JComboBox comboBox_camareros;
	private JTextField txtNombreCliente;
	private JComboBox comboBoxTurnos;
	private JComboBox cbDia;
	private JComboBox cbMes;
	private JComboBox cbAno;


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
		final DefaultListModel modelo = new DefaultListModel();
		lista_mesas.setModel(modelo);
		lista_mesas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lista_mesas.setBounds(0, 0, 341, 739);
		frame.getContentPane().add(lista_mesas);
		GestorMesa gestor_mesa = new GestorMesa();
		try {
			LinkedList<Mesa> lista_mesas_BD = gestor_mesa.getListaMesas();
			//modelo.addAll(lista_mesas_BD);
		} catch (Exception e) {
			e.printStackTrace();
		}

		cbDia = new JComboBox();
		cbDia.setBounds(927, 117, 81, 22);
		frame.getContentPane().add(cbDia);
		for(int i =1;i<32;i++) {
			String aux = Integer.toString(i);
			if(aux.length()<2) {
				aux = "0"+Integer.toString(i);
			}
			cbDia.addItem(aux);
		}

		cbMes = new JComboBox();
		cbMes.setBounds(839, 117, 86, 22);
		frame.getContentPane().add(cbMes);
		for(int i =1;i<13;i++) {
			String aux = Integer.toString(i);
			if(aux.length()<2) {
				aux = "0"+Integer.toString(i);
			}
			cbMes.addItem(aux);
		}

		cbAno = new JComboBox();
		cbAno.setBounds(767, 117, 71, 22);
		frame.getContentPane().add(cbAno);
		for(int i =2020;i<2040;i++) {
			cbAno.addItem(i);
		}

		comboBoxTurnos = new JComboBox();
		comboBoxTurnos.setBounds(767, 182, 240, 22);
		frame.getContentPane().add(comboBoxTurnos);

		comboBoxTurnos.addItem(TURNO1);
		comboBoxTurnos.addItem(TURNO2);
		comboBoxTurnos.addItem(TURNO3);
		comboBoxTurnos.addItem(TURNO4);
		comboBoxTurnos.addItem(TURNO5);
		comboBoxTurnos.addItem(TURNO6);

		txtNombreCliente = new JTextField();
		txtNombreCliente.setBounds(766, 47, 241, 20);
		frame.getContentPane().add(txtNombreCliente);
		txtNombreCliente.setColumns(10);

		btnReservarMesa = new JButton("Reservar mesa");
		btnReservarMesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
				Mesa mesaAux;
				String fechaAux;
				/*Date fecha = null;
				SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				 */
				GestorMesa gm = new GestorMesa();
				GestorReservas gr = new GestorReservas();
				mesaAux = (Mesa)lista_mesas.getSelectedValue();
				fechaAux =cbAno.getSelectedItem()+"-"+cbMes.getSelectedItem()+"-"+cbDia.getSelectedItem()+" "+comboBoxTurnos.getSelectedItem();
				DateTime fecha = null;

				fecha = formatter.parseDateTime(fechaAux);

				try {
					gr.nuevaReserva(mesaAux.getmId(), comboBoxTurnos.getSelectedIndex(), fecha, txtNombreCliente.getText());
					gm.cambiarEstado(RESERVADA, mesaAux.getmId());
					LinkedList<Mesa> lista_mesas_BD = gm.getListaMesas();
					modelo.clear();
					//modelo.addAll(lista_mesas_BD);
				} catch (Exception e) {
					e.printStackTrace();
				}


			}
		});
		btnReservarMesa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnReservarMesa.setBounds(351, 47, 175, 157);
		frame.getContentPane().add(btnReservarMesa);

		btnCancelarReserva = new JButton("Cancelar reserva");
		btnCancelarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					IUCancelarReserva iuCancelarReserva = new IUCancelarReserva();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnCancelarReserva.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancelarReserva.setBounds(351, 276, 175, 157);
		frame.getContentPane().add(btnCancelarReserva);

		btnAsignarCamarero = new JButton("Asignar camarero");
		btnAsignarCamarero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Mesa mesaAux;
				GestorMesa gm = new GestorMesa();
				mesaAux = (Mesa)lista_mesas.getSelectedValue();

				try {
					gm.asignarCamarero((Integer)comboBox_camareros.getSelectedItem(),mesaAux.getmId());
					LinkedList<Mesa> lista_mesas_BD = gm.getListaMesas();
					modelo.clear();
					//modelo.addAll(lista_mesas_BD);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnAsignarCamarero.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAsignarCamarero.setBounds(351, 510, 175, 157);
		frame.getContentPane().add(btnAsignarCamarero);

		comboBox_camareros = new JComboBox();
		comboBox_camareros.setBounds(740, 510, 175, 32);
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
