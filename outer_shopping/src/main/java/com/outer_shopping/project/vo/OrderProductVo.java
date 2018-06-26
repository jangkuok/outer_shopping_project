package com.outer_shopping.project.vo;

import java.io.Serializable;

public class OrderProductVo implements Serializable {
	
	private int productNo;
	private int outerNo;
	private String productName;
	private String productColor;
	private String productSize;
	private int productPrice;
	private int orderNo;
	
	public OrderProductVo() {}

	public OrderProductVo(int productNo, int outerNo, String productName, String productColor, String productSize,
			int productPrice, int orderNo) {
		this.productNo = productNo;
		this.outerNo = outerNo;
		this.productName = productName;
		this.productColor = productColor;
		this.productSize = productSize;
		this.productPrice = productPrice;
		this.orderNo = orderNo;
	}

	@Override
	public String toString() {
		return "OrderProductVo [productNo=" + productNo + ", outerNo=" + outerNo + ", productName=" + productName
				+ ", productColor=" + productColor + ", productSize=" + productSize + ", productPrice=" + productPrice
				+ ", orderNo=" + orderNo + "]";
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public int getOuterNo() {
		return outerNo;
	}

	public void setOuterNo(int outerNo) {
		this.outerNo = outerNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductColor() {
		return productColor;
	}

	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}

	public String getProductSize() {
		return productSize;
	}

	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderNo;
		result = prime * result + outerNo;
		result = prime * result + ((productColor == null) ? 0 : productColor.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + productNo;
		result = prime * result + productPrice;
		result = prime * result + ((productSize == null) ? 0 : productSize.hashCode());
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
		if (!(obj instanceof OrderProductVo)) {
			return false;
		}
		OrderProductVo other = (OrderProductVo) obj;
		if (orderNo != other.orderNo) {
			return false;
		}
		if (outerNo != other.outerNo) {
			return false;
		}
		if (productColor == null) {
			if (other.productColor != null) {
				return false;
			}
		} else if (!productColor.equals(other.productColor)) {
			return false;
		}
		if (productName == null) {
			if (other.productName != null) {
				return false;
			}
		} else if (!productName.equals(other.productName)) {
			return false;
		}
		if (productNo != other.productNo) {
			return false;
		}
		if (productPrice != other.productPrice) {
			return false;
		}
		if (productSize == null) {
			if (other.productSize != null) {
				return false;
			}
		} else if (!productSize.equals(other.productSize)) {
			return false;
		}
		return true;
	}

		
}
