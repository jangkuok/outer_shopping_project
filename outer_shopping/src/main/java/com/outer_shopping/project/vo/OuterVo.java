package com.outer_shopping.project.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="OUTER_VIEW")
public class OuterVo implements Serializable {
	
	@Id
	@Column(name="OUTER_NO", nullable=false, length=1000)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int outerNo; 	// 번호
	
	@Column(name="type", nullable=false, length=100)
	private String type;	//종류

	@Column(name="name", nullable=false, length=100)
	private String name;	//이름
	
	@Column(name="size", nullable=false, length=10)
	private String size;	//사이즈
	
	@Column(name="content", nullable=false, length=1000)
	private String content;	//내용

	@Column(name="price")
	private int price;		//가격
	
	@Column(name="color", nullable=false, length=100)
	private String color;	//색상
	
	@Column(name="amount")
	private int amount;		//수량
	
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
