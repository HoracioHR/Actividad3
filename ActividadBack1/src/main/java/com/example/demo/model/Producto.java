package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Producto {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long idProducto;
	private String nombre;
	private String marca;
	private String descripcion;
	public Long getIdProducto(Long idProducto){
		return idProducto;
	}
	public void setIdProducto(Long idProducto) {
		this.idProducto=idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca=marca;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion=descripcion;
	}
	
	
	
	
}
