package com.outer_shopping.project.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class OuterPictureVo {
	private int prictureNo; 	 	//사진번호
	private String prictureName;	//사진이름
	private String prictureUrl;		//사진url
	private int outerNo;			//아웃터 번호
	
	private  List<MultipartFile> imageFiles;
	
	
	public OuterPictureVo() {}


	public OuterPictureVo(int prictureNo, String prictureName, String prictureUrl, int outerNo) {
		this.prictureNo = prictureNo;
		this.prictureName = prictureName;
		this.prictureUrl = prictureUrl;
		this.outerNo = outerNo;
	}


	public OuterPictureVo(int prictureNo, String prictureName, String prictureUrl, int outerNo,
			List<MultipartFile> imageFiles) {
		this.prictureNo = prictureNo;
		this.prictureName = prictureName;
		this.prictureUrl = prictureUrl;
		this.outerNo = outerNo;
		this.imageFiles = imageFiles;
	}


	@Override
	public String toString() {
		return "OuterPictureVo [prictureNo=" + prictureNo + ", prictureName=" + prictureName + ", prictureUrl="
				+ prictureUrl + ", outerNo=" + outerNo + ", imageFiles=" + imageFiles + "]";
	}


	public int getPrictureNo() {
		return prictureNo;
	}


	public void setPrictureNo(int prictureNo) {
		this.prictureNo = prictureNo;
	}


	public String getPrictureName() {
		return prictureName;
	}


	public void setPrictureName(String prictureName) {
		this.prictureName = prictureName;
	}


	public String getPrictureUrl() {
		return prictureUrl;
	}


	public void setPrictureUrl(String prictureUrl) {
		this.prictureUrl = prictureUrl;
	}


	public int getOuterNo() {
		return outerNo;
	}


	public void setOuterNo(int outerNo) {
		this.outerNo = outerNo;
	}


	public List<MultipartFile> getImageFiles() {
		return imageFiles;
	}


	public void setImageFiles(List<MultipartFile> imageFiles) {
		this.imageFiles = imageFiles;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imageFiles == null) ? 0 : imageFiles.hashCode());
		result = prime * result + outerNo;
		result = prime * result + ((prictureName == null) ? 0 : prictureName.hashCode());
		result = prime * result + prictureNo;
		result = prime * result + ((prictureUrl == null) ? 0 : prictureUrl.hashCode());
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
		if (!(obj instanceof OuterPictureVo)) {
			return false;
		}
		OuterPictureVo other = (OuterPictureVo) obj;
		if (imageFiles == null) {
			if (other.imageFiles != null) {
				return false;
			}
		} else if (!imageFiles.equals(other.imageFiles)) {
			return false;
		}
		if (outerNo != other.outerNo) {
			return false;
		}
		if (prictureName == null) {
			if (other.prictureName != null) {
				return false;
			}
		} else if (!prictureName.equals(other.prictureName)) {
			return false;
		}
		if (prictureNo != other.prictureNo) {
			return false;
		}
		if (prictureUrl == null) {
			if (other.prictureUrl != null) {
				return false;
			}
		} else if (!prictureUrl.equals(other.prictureUrl)) {
			return false;
		}
		return true;
	}

	
	
}
