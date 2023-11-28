package modelo;

import java.util.Date;
import java.util.List;

public class Proveedor {
	private int cuit;
	private String razonSocial;
	private String nombre;
	private Direccion direccion;
	private int telefono;
	private String correoElectronico;
	private Date inicioActividades;
	private List<Rubro> rubros;
	private List<Producto> productos;
	private List<CertificadoRetencion> certificados;
	private float maxDeuda;
	private List<CuentaCorriente> cuentas;
	private List<Documento> documentos;

	public Proveedor(int cuit, String razonSocial, String nombre, Direccion direccion, int telefono, String correoElectronico,
			Date inicioActividades, List<Rubro> rubros, float maxDeuda) {
		this.cuit = cuit;
		this.razonSocial = razonSocial;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.inicioActividades = inicioActividades;
		this.rubros = rubros;
		this.productos = null;
		this.certificados = null;
		this.maxDeuda = maxDeuda;
		this.cuentas = null;
		this.documentos = null;
	}
	
	public int getCuit() {
		return cuit;
	}

	public void setCuit(int cuit) {
		this.cuit = cuit;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public Date getInicioActividades() {
		return inicioActividades;
	}

	public void setInicioActividades(Date inicioActividades) {
		this.inicioActividades = inicioActividades;
	}

	public List<Rubro> getRubros() {
		return rubros;
	}

	public void setRubros(List<Rubro> rubros) {
		this.rubros = rubros;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public List<CertificadoRetencion> getCertificados() {
		return certificados;
	}

	public void setCertificados(List<CertificadoRetencion> certificados) {
		this.certificados = certificados;
	}

	public float getMaxDeuda() {
		return maxDeuda;
	}

	public void setMaxDeuda(float maxDeuda) {
		this.maxDeuda = maxDeuda;
	}

	public List<CuentaCorriente> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<CuentaCorriente> cuentas) {
		this.cuentas = cuentas;
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}
}