package bean;

public class ClienteView
{
	private String dni;
	private String nombre;
	private int telefono;
	private String domicilio;

	public ClienteView(String dni, String domicilio, String nombre, int telefono) 
	{		
		this.dni = dni;
		this.domicilio = domicilio;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public String getDomicilio() {
		return domicilio;
	}

}
