package com.outer_shopping.project.vo;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class OuterVo implements Serializable {
	
	private static final long serialVersionUID = -6587408206518661042L;

	@Id
	private int outerNo; 	// 번호
	
	@NotNull
	@Size(min= 1, max= 100, message="")
	private String type;	//종류

	@NotNull
	@Size(min= 1, max= 100, message="")
	private String name;	//이름
	
	@NotNull
	@Size(min= 1, max= 1000, message="")
	private String content;	//내용

	@NotNull
	private int price;		//가격
	
	@NotNull
	private Date insertDate; //등록날짜
	
	private List<OuterSizeVo> sizeList;
	
	
	public OuterVo() {}


	/**
	 * @param outerNo 	번호
	 * @param type 		종류
	 * @param name		이름
	 * @param content	내용
	 * @param price		가격
	 * @param insertDate	등록날짜
	 */
	public OuterVo(int outerNo, String type, String name, String content, int price, Date insertDate) {
		this.outerNo = outerNo;
		this.type = type;
		this.name = name;
		this.content = content;
		this.price = price;
		this.insertDate = insertDate;
	}

	/**
	 * @param outerNo
	 * @param type
	 * @param name
	 * @param content
	 * @param price
	 * @param insertDate
	 * @param sizeList
	 */
	public OuterVo(int outerNo,String type,String name,String content,int price, Date insertDate,	
			List<OuterSizeVo> sizeList) {
		this.outerNo = outerNo;
		this.type = type;
		this.name = name;
		this.content = content;
		this.price = price;
		this.insertDate = insertDate;
		this.sizeList = sizeList;
	}


	/**
	 * 
	 * ToString
	 */
	@Override
	public String toString() {
		return "OuterVo [outerNo=" + outerNo + ", type=" + type + ", name=" + name + ", content=" + content + ", price="
				+ price + ", insertDate=" + insertDate + ", sizeList=" + sizeList + "]";
	}

	/**
	 * Setter / Getter
	 */
	/**
	/**
	 * @return the outerNo
	 */
	public int getOuterNo() {
		return outerNo;
	}


	/**
	 * @param outerNo the outerNo to set
	 */
	public void setOuterNo(int outerNo) {
		this.outerNo = outerNo;
	}


	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}


	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}


	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}


	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}


	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the insertDate
	 */
	public Date getInsertDate() {
		return insertDate;
	}


	/**
	 * @param insertDate the insertDate to set
	 */
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}


	/**
	 * @return the sizeList
	 */
	public List<OuterSizeVo> getSizeList() {
		return sizeList;
	}


	/**
	 * @param sizeList the sizeList to set
	 */
	public void setSizeList(List<OuterSizeVo> sizeList) {
		this.sizeList = sizeList;
	}


	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	/**
	 * hashCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((insertDate == null) ? 0 : insertDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + outerNo;
		result = prime * result + price;
		result = prime * result + ((sizeList == null) ? 0 : sizeList.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}



	/**
	 *	equals 
	 */
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
