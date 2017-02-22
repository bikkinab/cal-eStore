package com.hpe.calEStore.dao.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name = "product", catalog = "eshop")
public class Product implements java.io.Serializable {

	private Integer productId;
	private Category category;
	private Brand brand;
	private String productName;
	private String productDesc;
	private String productType;
	private String imgPath;
	private float msrpPerUnit;
	private Float discPercent;
	private float pricePerUnit;
	private Integer rating;
	private String isPublishedInd;
	private Date publishedDate;
	private Set<ProductOrder> productOrders = new HashSet<ProductOrder>(0);
	private Set<ProductAspect> productAspects = new HashSet<ProductAspect>(0);

	public Product() {
		// Do nothing... Hibernate needs this mandatory
	}

	public Product(Category category, Brand brand, String productName,
			String productDesc, String productType, float msrpPerUnit,
			float pricePerUnit, String isPublishedInd, Date publishedDate) {
		this.category = category;
		this.brand = brand;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productType = productType;
		this.msrpPerUnit = msrpPerUnit;
		this.pricePerUnit = pricePerUnit;
		this.isPublishedInd = isPublishedInd;
		this.publishedDate = publishedDate;
	}

	public Product(Category category, Brand brand, String productName,
			String productDesc, String productType, String imgPath,
			float msrpPerUnit, Float discPercent, float pricePerUnit,
			Integer rating, String isPublishedInd, Date publishedDate,
			Set<ProductOrder> productOrders, Set<ProductAspect> productAspects) {
		this.category = category;
		this.brand = brand;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productType = productType;
		this.imgPath = imgPath;
		this.msrpPerUnit = msrpPerUnit;
		this.discPercent = discPercent;
		this.pricePerUnit = pricePerUnit;
		this.rating = rating;
		this.isPublishedInd = isPublishedInd;
		this.publishedDate = publishedDate;
		this.productOrders = productOrders;
		this.productAspects = productAspects;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "PRODUCT_ID", unique = true, nullable = false)
	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CATEGORY_ID", nullable = false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BRAND_ID", nullable = false)
	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@Column(name = "PRODUCT_NAME", nullable = false, length = 50)
	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "PRODUCT_DESC", nullable = false, length = 1000)
	public String getProductDesc() {
		return this.productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	@Column(name = "PRODUCT_TYPE", nullable = false, length = 3)
	public String getProductType() {
		return this.productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	@Column(name = "IMG_PATH", length = 100)
	public String getImgPath() {
		return this.imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	@Column(name = "MSRP_PER_UNIT", nullable = false, precision = 8)
	public float getMsrpPerUnit() {
		return this.msrpPerUnit;
	}

	public void setMsrpPerUnit(float msrpPerUnit) {
		this.msrpPerUnit = msrpPerUnit;
	}

	@Column(name = "DISC_PERCENT", precision = 4)
	public Float getDiscPercent() {
		return this.discPercent;
	}

	public void setDiscPercent(Float discPercent) {
		this.discPercent = discPercent;
	}

	@Column(name = "PRICE_PER_UNIT", nullable = false, precision = 8)
	public float getPricePerUnit() {
		return this.pricePerUnit;
	}

	public void setPricePerUnit(float pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	@Column(name = "RATING")
	public Integer getRating() {
		return this.rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Column(name = "IS_PUBLISHED_IND", nullable = false, length = 2)
	public String getIsPublishedInd() {
		return this.isPublishedInd;
	}

	public void setIsPublishedInd(String isPublishedInd) {
		this.isPublishedInd = isPublishedInd;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PUBLISHED_DATE", nullable = false, length = 19)
	public Date getPublishedDate() {
		return this.publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public Set<ProductOrder> getProductOrders() {
		return this.productOrders;
	}

	public void setProductOrders(Set<ProductOrder> productOrders) {
		this.productOrders = productOrders;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public Set<ProductAspect> getProductAspects() {
		return this.productAspects;
	}

	public void setProductAspects(Set<ProductAspect> productAspects) {
		this.productAspects = productAspects;
	}

}
