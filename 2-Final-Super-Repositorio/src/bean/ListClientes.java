package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import bean.srv.ClienteSRV;


public class ListClientes implements Serializable
{
	private List<Cliente> clientes;

	public ListClientes()
	{
		clientes= new ArrayList<Cliente>();
		clientes = ClienteSRV.leerClientes();
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public void addCliente(Cliente cliente){
		clientes.add(cliente);
		ClienteSRV.grabarCliente(cliente);
	}

	public boolean removeCliente(Cliente cliente) {
		ClienteSRV.grabarCliente(cliente);
		return clientes.remove(cliente);
	}

	public Cliente getClientePorId(String id){
		for(Cliente u : clientes){
			if(u.getDni().equals(id))
				return u;
		}
		return null;
	}


	public int size(){
		return clientes.size();
	}

	public void actualizarBD() 
	{
		ClienteSRV.grabarClientes(clientes);

	}
}
