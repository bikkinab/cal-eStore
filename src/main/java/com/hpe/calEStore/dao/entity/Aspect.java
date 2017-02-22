package com.hpe.calEStore.dao.entity;

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

/**
 * Aspect generated by hbm2java
 */
@Entity
@Table(name = "aspect", catalog = "eshop")
public class Aspect implements java.io.Serializable {

	private Integer aspectId;
	private Category category;
	private String aspectName;
	private Set<ProductAspect> productAspects = new HashSet<ProductAspect>(0);

	public Aspect() {
		// Do nothing... Hibernate needs this mandatory
	}

	public Aspect(Category category, String aspectName) {
		this.category = category;
		this.aspectName = aspectName;
	}

	public Aspect(Category category, String aspectName,
			Set<ProductAspect> productAspects) {
		this.category = category;
		this.aspectName = aspectName;
		this.productAspects = productAspects;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ASPECT_ID", unique = true, nullable = false)
	public Integer getAspectId() {
		return this.aspectId;
	}

	public void setAspectId(Integer aspectId) {
		this.aspectId = aspectId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CATEGORY_ID", nullable = false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "ASPECT_NAME", nullable = false, length = 20)
	public String getAspectName() {
		return this.aspectName;
	}

	public void setAspectName(String aspectName) {
		this.aspectName = aspectName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "aspect")
	public Set<ProductAspect> getProductAspects() {
		return this.productAspects;
	}

	public void setProductAspects(Set<ProductAspect> productAspects) {
		this.productAspects = productAspects;
	}

}
