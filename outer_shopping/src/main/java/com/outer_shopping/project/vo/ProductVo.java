package com.outer_shopping.project.vo;

import java.io.Serializable;

public class ProductVo implements Serializable{
	
	private int cartNo;
	private int productNo;
	private String productName;
	private String productColor;
	private String productSize;
	private String productPrice;
	
	public ProductVo() {}

	public ProductVo(int cartNo, int productNo, String productName, String productColor, String productSize,
			String productPrice) {
		this.cartNo = cartNo;
		this.productNo = productNo;
		this.productName = productName;
		this.productColor = productColor;
		this.productSize = productSize;
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "CartVo [cartNo=" + cartNo + ", productNo=" + productNo + ", productName=" + productName
				+ ", productColor=" + productColor + ", productSize=" + productSize + ", productPrice=" + productPrice
				+ "]";
	}

	public int getCartNo() {
		return cartNo;
	}

	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
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

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cartNo;
		result = prime * result + ((productColor == null) ? 0 : productColor.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + productNo;
		result = prime * result + ((productPrice == null) ? 0 : productPrice.hashCode());
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
		if (!(obj instanceof ProductVo)) {
			return false;
		}
		ProductVo other = (ProductVo) obj;
		if (cartNo != other.cartNo) {
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
		if (productPrice == null) {
			if (other.productPrice != null) {
				return false;
			}
		} else if (!productPrice.equals(other.productPrice)) {
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
