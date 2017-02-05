import java.io.Serializable;

public class Pasajero implements Serializable {
	private String nombre;
	private String dni;
	private int edad;
	
	public Pasajero() {
		nombre = null;
		dni = null;
		edad = 0;
	}
	public Pasajero(String n,String d,int e) {
		this();
		setNombre(n);
		setDni(d);
		setEdad(e);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String n) {
		this.nombre = n;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String d) {
		this.dni = d;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int e) {
		this.edad = e;
	}
	public String toString() {
		String cadena = getDni() + "-" + getNombre() + "-" + getEdad();
		return cadena;
	}
}
