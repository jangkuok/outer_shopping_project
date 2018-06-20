package com.outer_shopping.project.jpa.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="OUTER_TB")
@SequenceGenerator(name = "OUTER_TB SEQ GENERATOR", sequenceName = "OUTER_TB_SEQ", initialValue = 1, allocationSize = 1)
@Data
public class OuterVo implements Serializable {
	
	private static final long serialVersionUID = -6587408206518661042L;

	@Id
	@Column(name="OUTER_NO", nullable=false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OUTER_TB SEQ GENERATOR")
	private int outerNo; 	// 번호

	@Column(name="OUTER_TYPE", nullable=false, length=100)
	private String type;	//종류

	
	@Column(name="OUTER_NAME", nullable=false, length=100)
	private String name;	//이름
	
	@Column(name="OUTER_SIZE", nullable=false, length=10)
	private String size;	//사이즈
	
	@Column(name="OUTER_CONTENT", nullable=false, length=1000)
	private String content;	//내용

	@Column(name="OUTER_PRICE", nullable=false)
	private int price;		//가격

	@Column(name="OUTER_COLOR", nullable=false, length=100)
	private String color;	//색상
	
	@Column(name="OUTER_AMOUNT", nullable=false)
	private int amount;		//수량
	
	//
	public OuterVo() {}

	
	/**
	 * @param outerNo 	번호
	 * @param type 		종류
	 * @param name		이름
	 * @param size		사이즈
	 * @param content	내용
	 * @param price		가격
	 * @param color		색상
	 * @param amount	수량
	 */
	public OuterVo(OuterDTO outer) {
		this.outerNo = outer.getOuterNo();
		this.type = outer.getType();
		this.name = outer.getName();
		this.size = outer.getSize();
		this.content = outer.getContent();
		this.price = outer.getPrice();
		this.color = outer.getColor();
		this.amount = outer.getAmount();
	}

}
