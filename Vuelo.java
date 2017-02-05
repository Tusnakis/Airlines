import java.io.Serializable;
import java.util.ArrayList;

public class Vuelo implements Serializable {
	private int id;
	private Aeropuerto origen;
	private Aeropuerto destino;
	public static int maxNumPasajeros;
	private ArrayList<Pasajero> listaPasajeros = new ArrayList<Pasajero>();
	private boolean escala;
	
	public Vuelo() {
		origen = null;
		destino = null;
		escala = false;
	}
	public Vuelo(int i,Aeropuerto o,Aeropuerto d,int np, ArrayList<Pasajero> pasaj,boolean e) {
		this();
		setId(i);
		setOrigen(o);
		setDestino(d);
		setMaxNumPasajeros(np);
		setListaPasajeros(pasaj);
		setEscala(e);
	}
	public ArrayList<Pasajero> getListaPasajeros() {
		return listaPasajeros;
	}
	public void setListaPasajeros(ArrayList<Pasajero> pasaj) {
		this.listaPasajeros = pasaj;
	}
	public int getId() {
		return id;
	}
	public void setId(int i) {
		this.id = i;
	}
	public Aeropuerto getOrigen() {
		return origen;
	}
	public void setOrigen(Aeropuerto o) {
		this.origen = o;
	}
	public Aeropuerto getDestino() {
		return destino;
	}
	public void setDestino(Aeropuerto d) {
		this.destino = d;
	}
	public void setMaxNumPasajeros(int np) {
		if(np >= 1 && np <= 200) {
		maxNumPasajeros = np;
		}
	}
	public int getMaxNumPasajeros() {
		return maxNumPasajeros;
	}
	public boolean isEscala() {
		return escala;
	}
	public void setEscala(boolean e) {
		this.escala = e;
	}
	public String toString() {
		String esc = null;
		if(escala) {
			esc = "Con escala";
		} else {
			esc = "Sin escala";
		}
		String cadena = getId() + "-" + origen.getAbreviatura() + "-" + destino.getAbreviatura() + "-" + listaPasajeros.size() + "-" + getMaxNumPasajeros() + "-" + esc;
		return cadena;
	}
}
