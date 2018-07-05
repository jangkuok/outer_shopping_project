/**
 * 
 */
package com.outer_shopping.project.vo;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
/**
 * @author ss
 *
 */
@Entity
public class MemberVo implements Serializable {

	@Size(min=8, max=15, message="아이디는 8~15자입니다.")
	//@Pattern(regexp="\\w{8,20}",message="아이디 형식이 잘못되었습니다.")
	private String id;			//아이디
	
	@NotNull
	@Size(min=8, max=20, message="패스워드는 8~20자입니다.")
	private String pw;			//비밀번호
	
	@NotNull
	@Size(min=1, message="이름을 입력하시오.")
	private String name;		//이름
	
	@NotNull
	@Size(min=1, message="이메일 입력하시오.")
	private String email;		//이메일
	
	@NotNull
	@Size(min=1, max=11, message="이메일 입력하시오.")
	private String phoneNum;	//핸드폰번호
	private String zipcode;		//우편번호
	private String address;		//주소
	private String address2;	//주소2
	
	@NotNull
	@Size(min=1, message="성별을 선택하시오.")
	private String sex; 		//성별
	private String grade; 		//등급
	private int enabled;		//사용가능
	
	//default 생성자
	public MemberVo() {}

	//매개변수 있는 생성자
	/**
	 * @param id 아이디
	 * @param pw 비밀번호
	 * @param name 이름
	 * @param email 이메일
	 * @param phoneNum 핸드폰번호
	 * @param zipcode 우편번호
	 * @param address 주소
	 * @param address2 주소2
	 * @param grade 등급
	 * @param enabled 사용가능
	 */
	public MemberVo(String id, String pw, String name, String email, String phoneNum, String zipcode, String address,
			String address2, String sex, String grade, int enabled) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.phoneNum = phoneNum;
		this.zipcode = zipcode;
		this.address = address; 
		this.address2 = address2;
		this.sex = sex;
		this.grade = grade;
		this.enabled = enabled;
	}

	//toString
	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email + ", phoneNum=" + phoneNum
				+ ", zipcode=" + zipcode + ", address=" + address + ", address2=" + address2 + ", sex=" + sex
				+ ", grade=" + grade + ", enabled=" + enabled + "]";
	}

	//getter/setter
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the pw
	 */
	public String getPw() {
		return pw;
	}

	/**
	 * @param pw the pw to set
	 */
	public void setPw(String pw) {
		this.pw = pw;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phoneNum
	 */
	public String getPhoneNum() {
		return phoneNum;
	}

	/**
	 * @param phoneNum the phoneNum to set
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	/**
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * @return the enabled
	 */
	public int getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	//hashCode
	/** (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((address2 == null) ? 0 : address2.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + enabled;
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phoneNum == null) ? 0 : phoneNum.hashCode());
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
		return result;
	}

	//equals
	/** (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof MemberVo)) {
			return false;
		}
		MemberVo other = (MemberVo) obj;
		if (address == null) {
			if (other.address != null) {
				return false;
			}
		} else if (!address.equals(other.address)) {
			return false;
		}
		if (address2 == null) {
			if (other.address2 != null) {
				return false;
			}
		} else if (!address2.equals(other.address2)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (enabled != other.enabled) {
			return false;
		}
		if (grade == null) {
			if (other.grade != null) {
				return false;
			}
		} else if (!grade.equals(other.grade)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (phoneNum == null) {
			if (other.phoneNum != null) {
				return false;
			}
		} else if (!phoneNum.equals(other.phoneNum)) {
			return false;
		}
		if (pw == null) {
			if (other.pw != null) {
				return false;
			}
		} else if (!pw.equals(other.pw)) {
			return false;
		}
		if (sex == null) {
			if (other.sex != null) {
				return false;
			}
		} else if (!sex.equals(other.sex)) {
			return false;
		}
		if (zipcode == null) {
			if (other.zipcode != null) {
				return false;
			}
		} else if (!zipcode.equals(other.zipcode)) {
			return false;
		}
		return true;
	}
	

	
}

