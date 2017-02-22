package com.hpe.calEStore.dao.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ProductOrder generated by hbm2java
 */
@Entity
@Table(name = "product_order", catalog = "eshop")
public class ProductOrder implements java.io.Serializable {

	private ProductOrderId id;
	private PurchaseOrder purchaseOrder;
	private Product product;
	private int qty;

	public ProductOrder() {
		// Do nothing... Hibernate needs this mandatory
	}

	public ProductOrder(ProductOrderId id, PurchaseOrder purchaseOrder,
			Product product, int qty) {
		this.id = id;
		this.purchaseOrder = purchaseOrder;
		this.product = product;
		this.qty = qty;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "orderId", column = @Column(name = "ORDER_ID", nullable = false)),
			@AttributeOverride(name = "productId", column = @Column(name = "PRODUCT_ID", nullable = false)) })
	public ProductOrderId getId() {
		return this.id;
	}

	public void setId(ProductOrderId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDER_ID", nullable = false, insertable = false, updatable = false)
	public PurchaseOrder getPurchaseOrder() {
		return this.purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCT_ID", nullable = false, insertable = false, updatable = false)
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "QTY", nullable = false)
	public int getQty() {
		return this.qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

}
