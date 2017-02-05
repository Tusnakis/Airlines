import java.io.Serializable;

public class Aeropuerto implements Serializable{
	private String ciudad;
	private String pais;
	private String abreviatura;
	
	public Aeropuerto() {
		ciudad = null;
		pais = null;
		abreviatura = null;
	}
	public Aeropuerto(String c,String p,String a) {
		this();
		setCiudad(c);
		setPais(p);
		setAbreviatura(a);
		
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String c) {
		this.ciudad = c;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String p) {
		this.pais = p;
	}
	public String getAbreviatura() {
		return abreviatura;
	}
	public void setAbreviatura(String a) {
		this.abreviatura = a;
	}
	public String toString() {
		String cadena = getCiudad() + " " + "(" + getAbreviatura() + ")" + "," + getPais();
		return cadena;
	}
}
