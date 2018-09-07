package bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Column (name = "nombre", nullable = false, length = 50)
	private String nombre;
	@Id 
	@Column (name = "dnicliente")
	private String dni;
	@Column (name = "telefono", nullable = false, length = 20)
	private int telefono;
	@Column (name = "domicilio", nullable = false, length = 80)
	private String domicilio;


	public void setDatos(String dni, String domicilio, String nombre, int telefono) 
	{
		this.dni = dni;
		this.domicilio = domicilio;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}


	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public ClienteView getView()
	{
		return new ClienteView( dni,domicilio,nombre,telefono);

	}


	@Override
	public String toString() {
		return dni + " - " +nombre;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if ( !(obj instanceof Cliente) ) return false;

		final Cliente cli = (Cliente) obj;
		return ( cli.getDni().equals( getDni() ) );

	}

	@Override
	public int hashCode() {
		int hc = dni.hashCode();
		hc = dni.length()*2*hc;
		return hc;
	}



}
