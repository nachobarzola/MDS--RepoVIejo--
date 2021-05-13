package mds.trabajopractico.sistemabecasalimentarias;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import mds.trabajopractico.sistemabecasalimentarias.services.interfaces.*;
import mds.trabajopractico.sistemabecasalimentarias.presentacion.*;

@SpringBootApplication
public class SistemabecasalimentariasApplication implements CommandLineRunner {

	public static void main(String[] args) {
		new SpringApplicationBuilder (SistemabecasalimentariasApplication.class).headless(false).run(args);
	}
	
	@Override
    public void run(String... args) { 
		//Login login = new Login();
		
	}
}

