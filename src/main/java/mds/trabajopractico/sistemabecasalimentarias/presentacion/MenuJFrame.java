package mds.trabajopractico.sistemabecasalimentarias.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mds.trabajopractico.sistemabecasalimentarias.domain.Escuela;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.CardLayout;

public class MenuJFrame extends JFrame {

	private JPanel contentPane;
	private AltaAlumnoJPanel panelAltaAlumno;
	private CardLayout cardLayout= new CardLayout();
	private MenuJFrame frame;

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
		this.frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		
		
		
		
	}
	
	
	public void cambiarVentanaMenu(int n) {
		switch(n) {
		case 1: //Registrar Ticket
			this.setTitle("Agregar alumno");
			panelAltaAlumno = new AltaAlumnoJPanel(this);
			contentPane.add(panelAltaAlumno,"1");
			cardLayout.show(contentPane, "1");
			break;
		
		}
	}
	

}
