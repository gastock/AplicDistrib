package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import bean.Cliente;
import bean.ProductoComp;
import bean.ProductoSimple;
import interfaz.TDAManejoDatos;

public class ListarProductosView extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 * @throws RemoteException 
	 */
	public ListarProductosView(TDAManejoDatos manejoDatos) throws RemoteException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblListadoDeClientes = new JLabel("Listado de Productos");
		lblListadoDeClientes.setBounds(15, 16, 221, 20);
		contentPane.add(lblListadoDeClientes);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(298, 210, 115, 29);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnVolver);

		List list = new List();
		list.setBounds(15, 42, 398, 162);
		for(ProductoSimple ps: manejoDatos.getProductosSimple().getProductosSimple()){
			list.add(ps.toString());
		}
		for(ProductoComp pc: manejoDatos.getProductosComp().getProductosComp()){
			list.add(pc.toString());
		}
		contentPane.add(list);
	}
}
