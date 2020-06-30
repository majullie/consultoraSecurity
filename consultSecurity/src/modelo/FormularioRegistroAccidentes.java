package modelo;

public class FormularioRegistroAccidentes {
	
	private int idAccidentes;
	private String nombre;
	private String apellido;
	private String areaAccidente;
	
	
	
	public FormularioRegistroAccidentes() {
		super();
	}



	public FormularioRegistroAccidentes(String nombre, String apellido,
			String areaAccidente) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.areaAccidente = areaAccidente;
	}



	public int getIdAccidentes() {
		return idAccidentes;
	}



	public void setIdAccidentes(int idAccidentes) {
		this.idAccidentes = idAccidentes;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getAreaAccidente() {
		return areaAccidente;
	}



	public void setAreaAccidente(String areaAccidente) {
		this.areaAccidente = areaAccidente;
	}



	@Override
	public String toString() {
		return "FormularioRegistroAccidentes [idAccidentes=" + idAccidentes
				+ ", nombre=" + nombre + ", apellido=" + apellido
				+ ", areaAccidente=" + areaAccidente + "]";
	}
	
	
	

}
