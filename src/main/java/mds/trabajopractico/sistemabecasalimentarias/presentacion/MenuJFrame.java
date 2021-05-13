package mds.trabajopractico.sistemabecasalimentarias.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mds.trabajopractico.sistemabecasalimentarias.domain.Escuela;

import javax.swing.JButton;
import javax.swing.JLabel;

public class MenuJFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuJFrame frame = new MenuJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public MenuJFrame(Escuela escuela) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAlumno = new JButton("Alumno");
		btnAlumno.setBounds(134, 57, 157, 23);
		contentPane.add(btnAlumno);
		
		JButton btnSolicitudes = new JButton("Solicitudes");
		btnSolicitudes.setBounds(134, 120, 157, 23);
		contentPane.add(btnSolicitudes);
		
		JLabel lblNewLabel = new JLabel("MENU");
		lblNewLabel.setBounds(192, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblEscuela = new JLabel(escuela.getNombre());
		lblEscuela.setBounds(192, 32, 46, 14);
		contentPane.add(lblEscuela);
		
	}

}
