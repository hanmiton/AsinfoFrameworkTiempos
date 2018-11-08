/*
 * Copyright (c) 2011 ASINFO (Asesores Informaticos), todos los derechos reservados. Este software es
 * confidencial y su informacion es propiedad de ASINFO (Asesores Informaticos). No  debe revelar tal 
 * informacion y debe usarla unicamente de acorde con los terminos de  uso.
 */
package com.asinfo.as2.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import com.asinfo.as2.entities.listener.EntityAuditorListenerAS2;

/**
 * Clase abstracta que permite manejar auditorias rapidas sobre todos las clases entidad
 * 
 * @author Rene Enriquez
 * @version 1.0
 */
@MappedSuperclass
@EntityListeners({ EntityAuditorListenerAS2.class })
public abstract class EntidadBase implements Serializable {

	private static final long serialVersionUID = -4493183957890075592L;

	@Column(name = "fecha_creacion", insertable = true, updatable = false, nullable = true)
	protected Date fechaCreacion;

	@Column(name = "usuario_creacion", insertable = true, updatable = false, nullable = true, length = 50)
	protected String usuarioCreacion;

	@Column(name = "fecha_modificacion", insertable = false, updatable = true, nullable = true)
	protected Date fechaModificacion;

	@Column(name = "usuario_modificacion", insertable = false, updatable = true, nullable = true, length = 50)
	protected String usuarioModificacion;

	// TODO da error al guardar en los combos, se requiere trabajar con el
	// objecto, no con el id
	// Pablo Andrade
	// @Version
	// Long version;

	@Transient
	protected int id;

	@Transient
	protected int idHashCode;

	/**
	 * Por defecto todas las endidades son auditables Para que una entidad no se auditable sobrescribir la propiedad
	 */
	@Transient
	protected boolean auditable = true;

	@Transient
	protected boolean error;

	@Transient
	protected boolean editado = false;

	@Transient
	protected boolean soloLectura = false;
	
	public static <T extends EntidadBase> void resetearAuditoria(T entidad) {
		entidad.setUsuarioCreacion(null);
		entidad.setUsuarioModificacion(null);
		entidad.setFechaCreacion(null);
		entidad.setFechaModificacion(null);
	}

	/**
	 * Bandera que indica si el registro fue eliminado
	 */
	@Transient
	protected boolean eliminado = false;

	/**
	 * Get del atributo fechaCreacion
	 * 
	 * @return el valor del atributo fechaCreacion
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * Set del atributo fechaCreacion
	 * 
	 * @param fechaCreacion
	 *            valor para asignar al atributo fechaCreacion
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * Get del atributo usuarioCreacion
	 * 
	 * @return el valor del atributo usuarioCreacion
	 */
	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	/**
	 * Set del atributo usuarioCreacion
	 * 
	 * @param usuarioCreacion
	 *            valor para asignar al atributo usuarioCreacion
	 */
	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	/**
	 * Get del atributo fechaModificacion
	 * 
	 * @return el valor del atributo fechaModificacion
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * Set del atributo fechaModificacion
	 * 
	 * @param fechaModificacion
	 *            valor para asignar al atributo fechaModificacion
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * Get del atributo usuarioModificacion
	 * 
	 * @return el valor del atributo usuarioModificacion
	 */
	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	/**
	 * Set del atributo usuarioModificacion
	 * 
	 * @param usuarioModificacion
	 *            valor para asignar al atributo usuarioModificacion
	 */
	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	/**
	 * Get del atributo serialversionuid
	 * 
	 * @return el valor del atributo serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Get del atributo id
	 * 
	 * @return el valor del atributo id
	 */
	public abstract int getId();

	/**
	 * Set del atributo id
	 * 
	 * @param id
	 *            valor para asignar al atributo id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get del atributo editado
	 * 
	 * @return el valor del atributo editado
	 */
	public boolean isEditado() {
		return editado;
	}

	/**
	 * Set del atributo editado
	 * 
	 * @param editado
	 *            valor para asignar al atributo editado
	 */
	public void setEditado(boolean editado) {
		this.editado = editado;
	}

	/**
	 * Get del atributo eliminado
	 * 
	 * @return el valor del atributo eliminado
	 */
	public boolean isEliminado() {
		return eliminado;
	}

	/**
	 * Set del atributo eliminado
	 * 
	 * @param eliminado
	 *            valor para asignar al atributo eliminado
	 */
	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}

	public boolean isAuditable() {
		return auditable;
	}

	public void setAuditable(boolean auditable) {
		this.auditable = auditable;
	}

	public String getMensageAuditoria() {
		return "";
	}

	public String getClavePrimaria() {
		return "id";
	}

	/**
	 * 
	 * Retorna un listado de las propiedades a ser auditadas de la entidad
	 * 
	 * @return
	 */
	public List<String> getCamposAuditables() {
		return new java.util.ArrayList<String>();
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	@Override
	public boolean equals(Object entidad) {

		if (this == entidad) {
			return true;

		} else {
			return (entidad instanceof EntidadBase) ? getId() == ((EntidadBase) entidad).getId() : false;
		}
	}

	@Override
	public int hashCode() {
		return getId() > 0 ? getId() : super.hashCode();
	}

	public int getIdHashCode() {
		return hashCode();
	}

	public int getRowKey() {
		return getId() == 0 ? super.hashCode() : this.getId();
	}

	public boolean isSoloLectura() {
		return soloLectura;
	}

	public void setSoloLectura(boolean soloLectura) {
		this.soloLectura = soloLectura;
	}

}