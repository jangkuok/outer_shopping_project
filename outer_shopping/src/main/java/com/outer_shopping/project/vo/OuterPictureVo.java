package com.outer_shopping.project.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class OuterPictureVo {
	private int pictureNo; 	 	//사진번호
	private String pictureName = "";	//사진이름
	private String pictureUrl = "";		//사진url
	private int outerNo;			//아웃터 번호
	
	private  List<MultipartFile> imageFiles;
	
	
	public OuterPictureVo() {}


	public OuterPictureVo(int pictureNo, String pictureName, String pictureUrl, int outerNo) {
		this.pictureNo = pictureNo;
		this.pictureName = pictureName;
		this.pictureUrl = pictureUrl;
		this.outerNo = outerNo;
	}


	public OuterPictureVo(int pictureNo, String pictureName, String pictureUrl, int outerNo,
			List<MultipartFile> imageFiles) {
		this.pictureNo = pictureNo;
		this.pictureName = pictureName;
		this.pictureUrl = pictureUrl;
		this.outerNo = outerNo;
		this.imageFiles = imageFiles;
	}


	@Override
	public String toString() {
		return "OuterPictureVo [pictureNo=" + pictureNo + ", pictureName=" + pictureName + ", pictureUrl=" + pictureUrl
				+ ", outerNo=" + outerNo + ", imageFiles=" + imageFiles + "]";
	}


	public int getPictureNo() {
		return pictureNo;
	}


	public void setPictureNo(int pictureNo) {
		this.pictureNo = pictureNo;
	}


	public String getPictureName() {
		return pictureName;
	}


	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}


	public String getPictureUrl() {
		return pictureUrl;
	}


	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
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
		result = prime * result + ((pictureName == null) ? 0 : pictureName.hashCode());
		result = prime * result + pictureNo;
		result = prime * result + ((pictureUrl == null) ? 0 : pictureUrl.hashCode());
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
		if (pictureName == null) {
			if (other.pictureName != null) {
				return false;
			}
		} else if (!pictureName.equals(other.pictureName)) {
			return false;
		}
		if (pictureNo != other.pictureNo) {
			return false;
		}
		if (pictureUrl == null) {
			if (other.pictureUrl != null) {
				return false;
			}
		} else if (!pictureUrl.equals(other.pictureUrl)) {
			return false;
		}
		return true;
	}


	
	
	
}
