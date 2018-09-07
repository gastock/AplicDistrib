package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.*;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import app.*;
public class AltaVentaView extends JFrame {

	private JPanel contentPane;
	private JTextField cliente;
	private JTextField producto;
	private JTextField cantidad;
	private Supermercado instancia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaVentaView frame = new AltaVentaView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AltaVentaView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cliente = new JTextField();
		cliente.setBounds(219, 33, 170, 20);
		contentPane.add(cliente);
		cliente.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ingresar dni cliente");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(39, 34, 126, 14);
		contentPane.add(lblNewLabel);
		
		producto = new JTextField();
		producto.setColumns(10);
		producto.setBounds(219, 87, 170, 20);
		contentPane.add(producto);
		
		JLabel lblA = new JLabel("Ingresar código de Producto");
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblA.setBounds(39, 88, 200, 14);
		contentPane.add(lblA);
		
		cantidad = new JTextField();
		cantidad.setColumns(10);
		cantidad.setBounds(219, 146, 170, 20);
		contentPane.add(cantidad);
		
		JLabel lblMes = new JLabel("Ingresar cantidad");
		lblMes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMes.setBounds(39, 147, 200, 14);
		contentPane.add(lblMes);
		
		
				
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaInicial menu = new VentanaInicial();
				menu.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(39, 306, 150, 38);
		contentPane.add(btnNewButton);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				instancia.agregarItem(nroVenta, cod, cant);
			   	
				VentanaInicial menu = new VentanaInicial();
				menu.setVisible(true);
				dispose();
			}
		});
		
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAceptar.setBounds(239, 306, 150, 38);
		contentPane.add(btnAceptar);
		
	}
         
}
