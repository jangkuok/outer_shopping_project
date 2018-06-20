package com.outer_shopping.project.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class WishListVo implements Serializable {
	
	private int wishNo;			//관심상품 번호
	private String memberId;	//회원 아이디
	private int outerNo;		//아웃터 번호
	
	private List<OuterVo> list;

	public WishListVo() {}

	public WishListVo(int wishNo, String memberId, int outerNo) {
		this.wishNo = wishNo;
		this.memberId = memberId;
		this.outerNo = outerNo;
	}

	public WishListVo(int wishNo, String memberId, int outerNo, List<OuterVo> list) {
		this.wishNo = wishNo;
		this.memberId = memberId;
		this.outerNo = outerNo;
		this.list = list;
	}

	@Override
	public String toString() {
		return "WishListVo [wishNo=" + wishNo + ", memberId=" + memberId + ", outerNo=" + outerNo + ", list=" + list
				+ "]";
	}

	public int getWishNo() {
		return wishNo;
	}

	public void setWishNo(int wishNo) {
		this.wishNo = wishNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getOuterNo() {
		return outerNo;
	}

	public void setOuterNo(int outerNo) {
		this.outerNo = outerNo;
	}

	public List<OuterVo> getList() {
		return list;
	}

	public void setList(List<OuterVo> list) {
		this.list = list;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + outerNo;
		result = prime * result + wishNo;
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
		if (!(obj instanceof WishListVo)) {
			return false;
		}
		WishListVo other = (WishListVo) obj;
		if (list == null) {
			if (other.list != null) {
				return false;
			}
		} else if (!list.equals(other.list)) {
			return false;
		}
		if (memberId == null) {
			if (other.memberId != null) {
				return false;
			}
		} else if (!memberId.equals(other.memberId)) {
			return false;
		}
		if (outerNo != other.outerNo) {
			return false;
		}
		if (wishNo != other.wishNo) {
			return false;
		}
		return true;
	}
	
	
}
