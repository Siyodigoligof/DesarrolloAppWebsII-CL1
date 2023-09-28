package org.cibertec.edu.pe.modelo;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrdenProducto {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;
	@Embedded // 
	private Producto producto;
	private double discount;
	private double subtotal;
	@ManyToOne
	@JoinColumn(name="orderId") //
	private Orden order;
	
	
	// METODOS CONSTRUCTORES
	public OrdenProducto() {
		super();
	}



	public OrdenProducto(Long orderItemId, Producto producto, double discount, double subtotal, Orden order) {
		super();
		this.orderItemId = orderItemId;
		this.producto = producto;
		this.discount = discount;
		this.subtotal = subtotal;
		this.order = order;
	}



	//Metodos GET AND SET
	public Long getOrderItemId() {
		return orderItemId;
	}



	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}



	public Producto getProducto() {
		return producto;
	}



	public void setProducto(Producto producto) {
		this.producto = producto;
	}



	public double getDiscount() {
		return discount;
	}



	public void setDiscount(double discount) {
		this.discount = discount;
	}



	public double getSubtotal() {
		return subtotal;
	}



	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}



	public Orden getOrder() {
		return order;
	}



	public void setOrder(Orden order) {
		this.order = order;
	}
	
	
	

}
