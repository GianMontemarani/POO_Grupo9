package dto;

import java.util.ArrayList;
import java.util.List;

import modelo.Documento;

public class CuentaCorrienteProveedorDto {
	int cuit;
	int deuda;
	List<Documento> documentos;
	List<Documento> documentosImpagos;
	List<Documento> pagosRealizados;
	
	public CuentaCorrienteProveedorDto(int cuit, int deuda, List<Documento> documentos,
			List<Documento> documentosImpagos, List<Documento> pagosRealizados) {
		this.cuit = cuit;
		this.deuda = deuda;
		this.documentos = documentos;
		this.documentosImpagos = documentosImpagos;
		this.pagosRealizados = pagosRealizados;
	}

	public CuentaCorrienteProveedorDto(int cuit) {
		this.cuit = cuit;
		this.deuda = 0;
		this.documentos = new ArrayList<Documento>();
		this.documentosImpagos = new ArrayList<Documento>();
		this.pagosRealizados = new ArrayList<Documento>();
	}

	public int getCuit() {
		return cuit;
	}

	public void setCuit(int cuit) {
		this.cuit = cuit;
	}

	public int getDeuda() {
		return deuda;
	}

	public void setDeuda(int deuda) {
		this.deuda = deuda;
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	public List<Documento> getDocumentosImpagos() {
		return documentosImpagos;
	}

	public void setDocumentosImpagos(List<Documento> documentosImpagos) {
		this.documentosImpagos = documentosImpagos;
	}

	public List<Documento> getPagosRealizados() {
		return pagosRealizados;
	}

	public void setPagosRealizados(List<Documento> pagosRealizados) {
		this.pagosRealizados = pagosRealizados;
	}
	
	public void sumDeuda(float deuda) {
		this.deuda += this.deuda;
	}
	
	public void addDocumentoImpago(Documento d) {
		this.documentosImpagos.add(d);
	}
}
