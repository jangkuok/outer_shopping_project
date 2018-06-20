
package com.outer_shopping.project.jpa.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class OuterDTO implements Serializable {
	
	private int outerNo; 	// 번호
	
	@Size(min= 1, max= 100, message="")
	private String type;	//종류

	@Size(min= 1, max= 100, message="")
	private String name;	//이름
	
	@Size(min= 1, max= 10, message="")
	private String size;	//사이즈
	
	@Size(min= 1, max= 1000, message="")
	private String content;	//내용

	private int price;		//가격
	
	@Size(min= 1, max= 100, message="")
	private String color;	//색상
	
	private int amount;		//수량

}
