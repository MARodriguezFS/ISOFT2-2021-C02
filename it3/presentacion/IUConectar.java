package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IUConectar {

	private JFrame frame;
	private JButton btnJefeSala;
	private JButton btnCamarero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IUConectar window = new IUConectar();
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
	public IUConectar() {
		initialize();
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
		
		btnJefeSala = new JButton("Jefe de Sala");
		btnJefeSala.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					IUJefeDeSala iu_jefe_sala = new IUJefeDeSala();
					iu_jefe_sala.set_visible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				frame.setVisible(false);
			}
		});
		btnJefeSala.setFont(new Font("Tahoma", Font.PLAIN, 37));
		btnJefeSala.setBounds(137, 102, 303, 272);
		frame.getContentPane().add(btnJefeSala);
		
		btnCamarero = new JButton("Camarero");
		btnCamarero.setFont(new Font("Tahoma", Font.PLAIN, 37));
		btnCamarero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					IU_Camarero iu_camarero = new IU_Camarero();
					iu_camarero.set_visible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				frame.setVisible(false);
			}
		});
		btnCamarero.setBounds(577, 102, 303, 272);
		frame.getContentPane().add(btnCamarero);
	}
}
