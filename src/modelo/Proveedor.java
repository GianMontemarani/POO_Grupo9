package modelo;
import java.util.Date;
import java.util.Collection;

public class Proveedor {
	private int cuit;
	private String responabilidadIva;
	private String razonSocial;
	private String nombre;
	private Direccion direccion;
	private int telefono;
	private String email;
	private int ingresosBrutos;
	private Date inicioActividades;
	private Collection<Rubro> rubros;
	private Collection<Producto> productos;
	private Collection<CertificadoRetencion> certificados;
	private float maxDeuda;
	private Collection<CuentaCorriente> cuentas;
	private Collection<OrdenCompra> ordenesDeCompra;
	
	public Proveedor(int cuit, String responabilidadIva, String razonSocial, String nombre, Direccion direccion,
			int telefono, String email, int ingresosBrutos, Date inicioActividades, Collection<Rubro> rubros,
			Collection<Producto> productos, Collection<CertificadoRetencion> certificados, float maxDeuda, Collection<CuentaCorriente> cuentas, Collection<OrdenCompra> ordenesDeCompra) {
		this.cuit = cuit;
		this.responabilidadIva = responabilidadIva;
		this.razonSocial = razonSocial;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.ingresosBrutos = ingresosBrutos;
		this.inicioActividades = inicioActividades;
		this.rubros = rubros;
		this.productos = productos;
		this.certificados = certificados;
		this.maxDeuda = maxDeuda;
		this.cuentas = cuentas;
		this.ordenesDeCompra = ordenesDeCompra;
	}

	public int getCuit() {
		return cuit;
	}

	public void setCuit(int cuit) {
		this.cuit = cuit;
	}

	public String getResponabilidadIva() {
		return responabilidadIva;
	}

	public void setResponabilidadIva(String responabilidadIva) {
		this.responabilidadIva = responabilidadIva;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIngresosBrutos() {
		return ingresosBrutos;
	}

	public void setIngresosBrutos(int ingresosBrutos) {
		this.ingresosBrutos = ingresosBrutos;
	}

	public Date getInicioActividades() {
		return inicioActividades;
	}

	public void setInicioActividades(Date inicioActividades) {
		this.inicioActividades = inicioActividades;
	}

	public Collection<Rubro> getRubros() {
		return rubros;
	}

	public void setRubros(Collection<Rubro> rubros) {
		this.rubros = rubros;
	}

	public Collection<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Collection<Producto> productos) {
		this.productos = productos;
	}

	public Collection<CertificadoRetencion> getCertificados() {
		return certificados;
	}

	public void setCertificados(Collection<CertificadoRetencion> certificados) {
		this.certificados = certificados;
	}

	public float getMaxDeuda() {
		return maxDeuda;
	}

	public void setMaxDeuda(float maxDeuda) {
		this.maxDeuda = maxDeuda;
	}
	
	public Collection<CuentaCorriente> getCuentas(){
		return cuentas;
	}
	
	public void setCuentas(Collection<CuentaCorriente> cuentas) {
		this.cuentas = cuentas;
	}

	public Collection<OrdenCompra> getOrdenesDeCompra() {
		return ordenesDeCompra;
	}

	public void setOrdenesDeCompra(Collection<OrdenCompra> ordenesDeCompra) {
		this.ordenesDeCompra = ordenesDeCompra;
	}
	
	
}
