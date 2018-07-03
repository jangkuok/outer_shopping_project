package com.outer_shopping.project.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class OuterSizeVo implements Serializable {
	
	private static final long serialVersionUID = -6587408206518661042L;
	
	@Id
	private int sizeNo; 	//사이즈 번호
	
	@NotNull
	private String type;	//사이즈 타입
	
	@NotNull
	private int chest;		//가슴
	
	@NotNull
	private int sleeve;		//소매
	
	@NotNull
	private int shoulder;	//어깨
	
	@NotNull
	private int whole;		//총길이
	
	@NotNull
	private int amount;		//수량
	
	@NotNull
	private String color; 	//색상
	
	@NotNull
	private int outerNo;	//아웃터 번호

	private OuterVo outer;  //아웃터
	
	public OuterSizeVo() {}

	public OuterSizeVo(int sizeNo, @NotNull String type, @NotNull int chest, @NotNull int sleeve, @NotNull int shoulder,
			@NotNull int whole, @NotNull int amount, @NotNull String color, @NotNull int outerNo) {
		this.sizeNo = sizeNo;
		this.type = type;
		this.chest = chest;
		this.sleeve = sleeve;
		this.shoulder = shoulder;
		this.whole = whole;
		this.amount = amount;
		this.color = color;
		this.outerNo = outerNo;
	}

	public OuterSizeVo(int sizeNo, @NotNull String type, @NotNull int chest, @NotNull int sleeve, @NotNull int shoulder,
			@NotNull int whole, @NotNull int amount, @NotNull String color, @NotNull int outerNo, OuterVo outer) {
		this.sizeNo = sizeNo;
		this.type = type;
		this.chest = chest;
		this.sleeve = sleeve;
		this.shoulder = shoulder;
		this.whole = whole;
		this.amount = amount;
		this.color = color;
		this.outerNo = outerNo;
		this.outer = outer;
	}

	@Override
	public String toString() {
		return "OuterSizeVo [sizeNo=" + sizeNo + ", type=" + type + ", chest=" + chest + ", sleeve=" + sleeve
				+ ", shoulder=" + shoulder + ", whole=" + whole + ", amount=" + amount + ", color=" + color
				+ ", outerNo=" + outerNo + ", outer=" + outer + "]";
	}

	public int getSizeNo() {
		return sizeNo;
	}

	public void setSizeNo(int sizeNo) {
		this.sizeNo = sizeNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getChest() {
		return chest;
	}

	public void setChest(int chest) {
		this.chest = chest;
	}

	public int getSleeve() {
		return sleeve;
	}

	public void setSleeve(int sleeve) {
		this.sleeve = sleeve;
	}

	public int getShoulder() {
		return shoulder;
	}

	public void setShoulder(int shoulder) {
		this.shoulder = shoulder;
	}

	public int getWhole() {
		return whole;
	}

	public void setWhole(int whole) {
		this.whole = whole;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getOuterNo() {
		return outerNo;
	}

	public void setOuterNo(int outerNo) {
		this.outerNo = outerNo;
	}

	public OuterVo getOuter() {
		return outer;
	}

	public void setOuter(OuterVo outer) {
		this.outer = outer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + chest;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((outer == null) ? 0 : outer.hashCode());
		result = prime * result + outerNo;
		result = prime * result + shoulder;
		result = prime * result + sizeNo;
		result = prime * result + sleeve;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + whole;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof OuterSizeVo)) {
			return false;
		}
		OuterSizeVo other = (OuterSizeVo) obj;
		if (amount != other.amount) {
			return false;
		}
		if (chest != other.chest) {
			return false;
		}
		if (color == null) {
			if (other.color != null) {
				return false;
			}
		} else if (!color.equals(other.color)) {
			return false;
		}
		if (outer == null) {
			if (other.outer != null) {
				return false;
			}
		} else if (!outer.equals(other.outer)) {
			return false;
		}
		if (outerNo != other.outerNo) {
			return false;
		}
		if (shoulder != other.shoulder) {
			return false;
		}
		if (sizeNo != other.sizeNo) {
			return false;
		}
		if (sleeve != other.sleeve) {
			return false;
		}
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		if (whole != other.whole) {
			return false;
		}
		return true;
	}

	
	
}
