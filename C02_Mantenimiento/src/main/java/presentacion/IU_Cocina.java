package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IU_Cocina {

	private JFrame frame;
	private JTextField txtEstadoComanda;
	private JTextField txtComandaActual;

	/**
	 * Launch the application.
	 * @Param el unico parametro es un string
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 625, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtEstadoComanda = new JTextField();
		txtEstadoComanda.setBounds(337, 147, 129, 31);
		frame.getContentPane().add(txtEstadoComanda);
		txtEstadoComanda.setColumns(10);
		
		JRadioButton rdbnComidaLista = new JRadioButton("COMANDA PREPARADA");
		rdbnComidaLista.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbnComidaLista.setBounds(216, 300, 250, 64);
		frame.getContentPane().add(rdbnComidaLista);
		
		txtComandaActual = new JTextField();
		txtComandaActual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		txtComandaActual.setColumns(10);
		txtComandaActual.setBounds(86, 154, 156, 131);
		frame.getContentPane().add(txtComandaActual);
		
		JLabel lblEstadoComanda = new JLabel("ESTADO COMANDA:");
		lblEstadoComanda.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEstadoComanda.setBounds(319, 111, 180, 32);
		frame.getContentPane().add(lblEstadoComanda);
		
		JLabel lblComandaActual = new JLabel("COMANDA ACTUAL:");
		lblComandaActual.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblComandaActual.setBounds(86, 111, 180, 32);
		frame.getContentPane().add(lblComandaActual);
	}
}
