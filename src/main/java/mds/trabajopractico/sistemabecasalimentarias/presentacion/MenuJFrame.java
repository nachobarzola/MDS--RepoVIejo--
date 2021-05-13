package mds.trabajopractico.sistemabecasalimentarias.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mds.trabajopractico.sistemabecasalimentarias.domain.Escuela;
import mds.trabajopractico.sistemabecasalimentarias.services.interfaces.AlumnoService;
import mds.trabajopractico.sistemabecasalimentarias.services.interfaces.presentacion.MenuJFrameService;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.CardLayout;

@Component
public class MenuJFrame extends JFrame implements MenuJFrameService{

	private JPanel contentPane;
	private AltaAlumnoJPanel panelAltaAlumno;
	private MenuJPanel panelMenu;
	
	private CardLayout cardLayout= new CardLayout();
	private MenuJFrame frame;
	
	@Autowired
	private AlumnoService alumnoService;

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
		contentPane.setLayout(cardLayout);
		
		MenuJPanel menuJPanel= new MenuJPanel(frame, escuela);
		contentPane.add(menuJPanel, "1");
		
		
	}
	
	
	public void cambiarVentanaMenu(int n, Escuela escuela) {
		switch(n) {
		case 1:
			this.setTitle("Menu");
			panelMenu = new MenuJPanel(this,escuela);
			contentPane.add(panelMenu,"1");
			cardLayout.show(contentPane, "1");
			break;
		case 2: //Alta Alumno
			this.setTitle("Agregar alumno");
			panelAltaAlumno = new AltaAlumnoJPanel(this);
			contentPane.add(panelAltaAlumno,"2");
			cardLayout.show(contentPane, "2");
			break;
		
		}
	}
	

}
