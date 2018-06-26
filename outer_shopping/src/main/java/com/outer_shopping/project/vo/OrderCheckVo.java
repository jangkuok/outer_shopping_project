package com.outer_shopping.project.vo;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class OrderCheckVo implements Serializable{
	
	private int orderNo;
	private int totalPrice;
	private String handing = "결제 대기중";
	private String memberId;
	private String address;
	private String phoneNum;
	private String email;
	private String message;
	private Date orderDate;
	
	private List<OrderProductVo> productList;
	
	
	public OrderCheckVo() {}


	public OrderCheckVo(int orderNo, int totalPrice, String handing, String memberId, String address, String phoneNum,
			String email, String message, Date orderDate) {
		this.orderNo = orderNo;
		this.totalPrice = totalPrice;
		this.handing = handing;
		this.memberId = memberId;
		this.address = address;
		this.phoneNum = phoneNum;
		this.email = email;
		this.message = message;
		this.orderDate = orderDate;
	}


	public OrderCheckVo(int orderNo, int totalPrice, String handing, String memberId, String address, String phoneNum,
			String email, String message, Date orderDate, List<OrderProductVo> productList) {
		this.orderNo = orderNo;
		this.totalPrice = totalPrice;
		this.handing = handing;
		this.memberId = memberId;
		this.address = address;
		this.phoneNum = phoneNum;
		this.email = email;
		this.message = message;
		this.orderDate = orderDate;
		this.productList = productList;
	}


	@Override
	public String toString() {
		return "OrderCheckVo [orderNo=" + orderNo + ", totalPrice=" + totalPrice + ", handing=" + handing
				+ ", memberId=" + memberId + ", address=" + address + ", phoneNum=" + phoneNum + ", email=" + email
				+ ", message=" + message + ", orderDate=" + orderDate + ", productList=" + productList + "]";
	}


	public int getOrderNo() {
		return orderNo;
	}


	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}


	public int getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}


	public String getHanding() {
		return handing;
	}


	public void setHanding(String handing) {
		this.handing = handing;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhoneNum() {
		return phoneNum;
	}


	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	public List<OrderProductVo> getProductList() {
		return productList;
	}


	public void setProductList(List<OrderProductVo> productList) {
		this.productList = productList;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((handing == null) ? 0 : handing.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + orderNo;
		result = prime * result + ((phoneNum == null) ? 0 : phoneNum.hashCode());
		result = prime * result + ((productList == null) ? 0 : productList.hashCode());
		result = prime * result + totalPrice;
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
		if (!(obj instanceof OrderCheckVo)) {
			return false;
		}
		OrderCheckVo other = (OrderCheckVo) obj;
		if (address == null) {
			if (other.address != null) {
				return false;
			}
		} else if (!address.equals(other.address)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (handing == null) {
			if (other.handing != null) {
				return false;
			}
		} else if (!handing.equals(other.handing)) {
			return false;
		}
		if (memberId == null) {
			if (other.memberId != null) {
				return false;
			}
		} else if (!memberId.equals(other.memberId)) {
			return false;
		}
		if (message == null) {
			if (other.message != null) {
				return false;
			}
		} else if (!message.equals(other.message)) {
			return false;
		}
		if (orderDate == null) {
			if (other.orderDate != null) {
				return false;
			}
		} else if (!orderDate.equals(other.orderDate)) {
			return false;
		}
		if (orderNo != other.orderNo) {
			return false;
		}
		if (phoneNum == null) {
			if (other.phoneNum != null) {
				return false;
			}
		} else if (!phoneNum.equals(other.phoneNum)) {
			return false;
		}
		if (productList == null) {
			if (other.productList != null) {
				return false;
			}
		} else if (!productList.equals(other.productList)) {
			return false;
		}
		if (totalPrice != other.totalPrice) {
			return false;
		}
		return true;
	}


		
}
