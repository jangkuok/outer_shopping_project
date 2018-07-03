package com.outer_shopping.project.vo;

public class OuterImagesVo {
	
	private int imageNo;
	private String imageUrl;
	private int outerNo;
	
	public OuterImagesVo() {};

	public OuterImagesVo(int imageNo, String imageUrl, int outerNo) {
		this.imageNo = imageNo;
		this.imageUrl = imageUrl;
		this.outerNo = outerNo;
	}

	@Override
	public String toString() {
		return "OuterImagesVo [imageNo=" + imageNo + ", imageUrl=" + imageUrl + ", outerNo=" + outerNo + "]";
	}

	public int getImageNo() {
		return imageNo;
	}

	public void setImageNo(int imageNo) {
		this.imageNo = imageNo;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getOuterNo() {
		return outerNo;
	}

	public void setOuterNo(int outerNo) {
		this.outerNo = outerNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + imageNo;
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + outerNo;
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
		if (!(obj instanceof OuterImagesVo)) {
			return false;
		}
		OuterImagesVo other = (OuterImagesVo) obj;
		if (imageNo != other.imageNo) {
			return false;
		}
		if (imageUrl == null) {
			if (other.imageUrl != null) {
				return false;
			}
		} else if (!imageUrl.equals(other.imageUrl)) {
			return false;
		}
		if (outerNo != other.outerNo) {
			return false;
		}
		return true;
	}
	
	
}
