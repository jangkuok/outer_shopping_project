package com.outer_shopping.project.vo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class ColorVo implements Serializable{
	
	private static final long serialVersionUID = -6587408206518661042L;
	
	@Id
	private int colorNo;
	@NotNull
	private String colorType;
	@NotNull
	private int sizeNo;
	
	private OuterSizeVo outerSize;
	
	private ColorVo() {}
	

	public ColorVo(int colorNo, String colorType, int sizeNo) {
		this.colorNo = colorNo;
		this.colorType = colorType;
		this.sizeNo = sizeNo;
	}

	public ColorVo(int colorNo, String colorType, int sizeNo, OuterSizeVo outerSize) {
		this.colorNo = colorNo;
		this.colorType = colorType;
		this.sizeNo = sizeNo;
		this.outerSize = outerSize;
	}


	@Override
	public String toString() {
		return "OuterColorVo [colorNo=" + colorNo + ", colorType=" + colorType + ", sizeNo=" + sizeNo + ", outerSize="
				+ outerSize + "]";
	}


	public int getColorNo() {
		return colorNo;
	}


	public void setColorNo(int colorNo) {
		this.colorNo = colorNo;
	}


	public String getColorType() {
		return colorType;
	}


	public void setColorType(String colorType) {
		this.colorType = colorType;
	}


	public int getsizeNo() {
		return sizeNo;
	}


	public void setsizeNo(int sizeNo) {
		this.sizeNo = sizeNo;
	}


	public OuterSizeVo getOuterSize() {
		return outerSize;
	}


	public void setOuterSize(OuterSizeVo outerSize) {
		this.outerSize = outerSize;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + colorNo;
		result = prime * result + ((colorType == null) ? 0 : colorType.hashCode());
		result = prime * result + ((outerSize == null) ? 0 : outerSize.hashCode());
		result = prime * result + sizeNo;
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
		if (!(obj instanceof ColorVo)) {
			return false;
		}
		ColorVo other = (ColorVo) obj;
		if (colorNo != other.colorNo) {
			return false;
		}
		if (colorType == null) {
			if (other.colorType != null) {
				return false;
			}
		} else if (!colorType.equals(other.colorType)) {
			return false;
		}
		if (outerSize == null) {
			if (other.outerSize != null) {
				return false;
			}
		} else if (!outerSize.equals(other.outerSize)) {
			return false;
		}
		if (sizeNo != other.sizeNo) {
			return false;
		}
		return true;
	}

}
