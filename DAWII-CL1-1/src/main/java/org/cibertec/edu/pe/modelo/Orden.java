package org.cibertec.edu.pe.modelo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Orden {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
	private Date orderDate;
	private double productCost;
	private double deliveryCost;
	private double discount;
	private double totalAmount;
	@OneToMany(mappedBy = "order" //
            ,cascade = CascadeType.ALL) // 
    private Set<OrdenProducto> ordenProductos;

	
	public void addOrderItem(OrdenProducto ordenProducto){
        if(ordenProductos == null){
        	ordenProductos = new HashSet<>();
        }
        ordenProductos.add(ordenProducto);
        ordenProducto.setOrder(this);;
    }

	// METODOS CONSTRUCTORES
	public Orden() {
		super();
	}


	public Orden(Long orderId, Date orderDate, double productCost, double deliveryCost, double discount,
			double totalAmount, Set<OrdenProducto> ordenProductos) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.productCost = productCost;
		this.deliveryCost = deliveryCost;
		this.discount = discount;
		this.totalAmount = totalAmount;
		this.ordenProductos = ordenProductos;
	}
	
	//Metodos GET AND SET

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getProductCost() {
		return productCost;
	}

	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}

	public double getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(double deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Set<OrdenProducto> getOrdenProductos() {
		return ordenProductos;
	}

	public void setOrdenProductos(Set<OrdenProducto> ordenProductos) {
		this.ordenProductos = ordenProductos;
	}

}
