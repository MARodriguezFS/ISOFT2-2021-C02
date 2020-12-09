package presentacion;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import dominio.GestorReservas;
import persistencia.Reserva;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;

public class IUCancelarReserva {

	private JFrame frame;
	private JList listaReservas;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public IUCancelarReserva() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(240, 240, 240));
		frame.setBounds(100, 100, 1024, 768);
		frame.getContentPane().setLayout(null);
		
		listaReservas = new JList();
		final DefaultListModel modelo = new DefaultListModel();
		listaReservas.setModel(modelo);
		listaReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		frame.getContentPane().add(listaReservas);
		GestorReservas gestorReservas = new GestorReservas();
		try {
			LinkedList<Reserva> listaReservasBD = gestorReservas.getListaReservas();
			modelo.addAll(listaReservasBD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		listaReservas.setBounds(0, 0, 587, 729);
		frame.getContentPane().add(listaReservas);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GestorReservas gestorReservas = new GestorReservas();
				Reserva reservaAux;
				reservaAux = (Reserva)listaReservas.getSelectedValue();
				
				try {
					gestorReservas.eliminarReserva(reservaAux.getIdReserva());
					LinkedList<Reserva> listaReservas = gestorReservas.getListaReservas();
					modelo.clear();
					modelo.addAll(listaReservas);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnCancelar.setBounds(690, 270, 216, 170);
		frame.getContentPane().add(btnCancelar);
		frame.setVisible(true);
		
	}
}
