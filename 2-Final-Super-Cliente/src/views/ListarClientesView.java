package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Cliente;
import interfaz.TDAManejoDatos;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.List;
import java.rmi.RemoteException;

public class ListarClientesView extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 * @throws RemoteException 
	 */
	public ListarClientesView(TDAManejoDatos manejoDatos) throws RemoteException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListadoDeClientes = new JLabel("Listado de Clientes");
		lblListadoDeClientes.setBounds(15, 16, 221, 20);
		contentPane.add(lblListadoDeClientes);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(298, 210, 115, 29);
		contentPane.add(btnVolver);
		
		List list = new List();
		list.setBounds(15, 42, 398, 162);
		for(Cliente c: manejoDatos.getClientes()){
		list.add(c.toString());
		}
		contentPane.add(list);
	}
}
