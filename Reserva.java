import java.io.Serializable;
import java.util.ArrayList;

public class Reserva implements Serializable {
	private String nombre;
	private ArrayList<Vuelo> listaVuelos = new ArrayList<Vuelo>();
	
	public Reserva() {
		nombre = null;
	}
	public Reserva(String n) {
		this();
		setNombre(n);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
