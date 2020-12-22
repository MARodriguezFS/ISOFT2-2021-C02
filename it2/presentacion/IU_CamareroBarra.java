package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class IU_CamareroBarra {

	private JFrame frame;
	private JTextField txtComanda;
	private JTextField txtEstadoComanda;

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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 523, 394);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblComandas = new JLabel("COMANDAS:");
		lblComandas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblComandas.setBounds(50, 50, 180, 32);
		frame.getContentPane().add(lblComandas);
		
		txtComanda = new JTextField();
		txtComanda.setColumns(10);
		txtComanda.setBounds(50, 93, 156, 131);
		frame.getContentPane().add(txtComanda);
		
		JLabel lblEstadoComanda = new JLabel("ESTADO COMANDA:");
		lblEstadoComanda.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEstadoComanda.setBounds(283, 50, 180, 32);
		frame.getContentPane().add(lblEstadoComanda);
		
		txtEstadoComanda = new JTextField();
		txtEstadoComanda.setColumns(10);
		txtEstadoComanda.setBounds(301, 93, 129, 31);
		frame.getContentPane().add(txtEstadoComanda);
		
		JRadioButton rdbtnAvisarACamarero = new JRadioButton("Avisar Camarero");
		rdbtnAvisarACamarero.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnAvisarACamarero.setBounds(180, 239, 250, 64);
		frame.getContentPane().add(rdbtnAvisarACamarero);
	}

}
