package com.outer_shopping.project.vo;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class OuterVo implements Serializable {

	private int outerNo; 	// 번호
	
	private String type;	//종류

	private String name;	//이름
	
	private String content;	//내용

	private int price;		//가격
	
	private Date insertDate; //등록날짜
	
	private String imageName;
	private String thumbnailName;
	
	private MultipartFile imageFile;
	
	private List<OuterSizeVo> sizeList;
	private List<OuterImagesVo> imageList;
	
	
	public OuterVo() {}

	
	public OuterVo(int outerNo, String type, String name, String content, int price, Date insertDate,
			String imageName, String thumbnailName) {
		this.outerNo = outerNo;
		this.type = type;
		this.name = name;
		this.content = content;
		this.price = price;
		this.insertDate = insertDate;
		this.imageName = imageName;
		this.thumbnailName = thumbnailName;
	}

	public OuterVo(int outerNo, String type, String name,String content, int price, Date insertDate,
			String imageName, String thumbnailName, MultipartFile imageFile, List<OuterSizeVo> sizeList,
			List<OuterImagesVo> imageList) {
		this.outerNo = outerNo;
		this.type = type;
		this.name = name;
		this.content = content;
		this.price = price;
		this.insertDate = insertDate;
		this.imageName = imageName;
		this.thumbnailName = thumbnailName;
		this.imageFile = imageFile;
		this.sizeList = sizeList;
		this.imageList = imageList;
	}

	@Override
	public String toString() {
		return "OuterVo [outerNo=" + outerNo + ", type=" + type + ", name=" + name + ", content=" + content + ", price="
				+ price + ", insertDate=" + insertDate + ", imageName=" + imageName + ", thumbnailName=" + thumbnailName
				+ ", imageFile=" + imageFile + ", sizeList=" + sizeList + ", imageList=" + imageList + "]";
	}

	public int getOuterNo() {
		return outerNo;
	}

	public void setOuterNo(int outerNo) {
		this.outerNo = outerNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getThumbnailName() {
		return thumbnailName;
	}

	public void setThumbnailName(String thumbnailName) {
		this.thumbnailName = thumbnailName;
	}

	public MultipartFile getImageFile() {
		return imageFile;
	}

	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}

	public List<OuterSizeVo> getSizeList() {
		return sizeList;
	}

	public void setSizeList(List<OuterSizeVo> sizeList) {
		this.sizeList = sizeList;
	}

	public List<OuterImagesVo> getImageList() {
		return imageList;
	}

	public void setImageList(List<OuterImagesVo> imageList) {
		this.imageList = imageList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((imageFile == null) ? 0 : imageFile.hashCode());
		result = prime * result + ((imageList == null) ? 0 : imageList.hashCode());
		result = prime * result + ((imageName == null) ? 0 : imageName.hashCode());
		result = prime * result + ((insertDate == null) ? 0 : insertDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + outerNo;
		result = prime * result + price;
		result = prime * result + ((sizeList == null) ? 0 : sizeList.hashCode());
		result = prime * result + ((thumbnailName == null) ? 0 : thumbnailName.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (!(obj instanceof OuterVo)) {
			return false;
		}
		OuterVo other = (OuterVo) obj;
		if (content == null) {
			if (other.content != null) {
				return false;
			}
		} else if (!content.equals(other.content)) {
			return false;
		}
		if (imageFile == null) {
			if (other.imageFile != null) {
				return false;
			}
		} else if (!imageFile.equals(other.imageFile)) {
			return false;
		}
		if (imageList == null) {
			if (other.imageList != null) {
				return false;
			}
		} else if (!imageList.equals(other.imageList)) {
			return false;
		}
		if (imageName == null) {
			if (other.imageName != null) {
				return false;
			}
		} else if (!imageName.equals(other.imageName)) {
			return false;
		}
		if (insertDate == null) {
			if (other.insertDate != null) {
				return false;
			}
		} else if (!insertDate.equals(other.insertDate)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (outerNo != other.outerNo) {
			return false;
		}
		if (price != other.price) {
			return false;
		}
		if (sizeList == null) {
			if (other.sizeList != null) {
				return false;
			}
		} else if (!sizeList.equals(other.sizeList)) {
			return false;
		}
		if (thumbnailName == null) {
			if (other.thumbnailName != null) {
				return false;
			}
		} else if (!thumbnailName.equals(other.thumbnailName)) {
			return false;
		}
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		return true;
	}

	
	
		
}
