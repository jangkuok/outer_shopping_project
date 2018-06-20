package com.outer_shopping.project.vo;

import java.io.Serializable;

import javax.persistence.Entity;


@Entity
public class AdminVo implements Serializable{
 
	private String adminId; 						//관리자 아이디
	private String pw; 								//비밀번호
	private String name; 							//이름
	private String adminAuthority = "ROLE_ADMIN"; 	//권한(default=ROLE_ADMIN)
	
	public AdminVo() {}

	/**
	 * @param adminId 관리자 아이디
	 * @param pw 비밀번호
	 * @param name 이름
	 * @param adminAuthority 권한
	 */
	public AdminVo(String adminId, String pw, String name, String adminAuthority) {
		this.adminId = adminId;
		this.pw = pw;
		this.name = name;
		this.adminAuthority = adminAuthority;
	}

	
	/**
	 * 권한제외
	 * @param adminId
	 * @param pw
	 * @param name
	 */
	public AdminVo(String adminId, String pw, String name) {
		this.adminId = adminId;
		this.pw = pw;
		this.name = name;
	}

	//toString
	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AdminVo [adminId=" + adminId + ", pw=" + pw + ", name=" + name + ", adminAuthority=" + adminAuthority
				+ "]";
	}

	//setter/getter
	/**
	 * @return the adminId
	 */
	public String getAdminId() {
		return adminId;
	}

	/**
	 * @param adminId the adminId to set
	 */
	public void setAdminId(String adminId) {
		this.adminId = adminId;
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
	 * @return the adminAuthority
	 */
	public String getAdminAuthority() {
		return adminAuthority;
	}

	/**
	 * @param adminAuthority the adminAuthority to set
	 */
	public void setAdminAuthority(String adminAuthority) {
		this.adminAuthority = adminAuthority;
	}

	
	/** (non-Javadoc)
	 * hashCode
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adminAuthority == null) ? 0 : adminAuthority.hashCode());
		result = prime * result + ((adminId == null) ? 0 : adminId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
		return result;
	}

	/** (non-Javadoc)
	 * equals
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
		if (!(obj instanceof AdminVo)) {
			return false;
		}
		AdminVo other = (AdminVo) obj;
		if (adminAuthority == null) {
			if (other.adminAuthority != null) {
				return false;
			}
		} else if (!adminAuthority.equals(other.adminAuthority)) {
			return false;
		}
		if (adminId == null) {
			if (other.adminId != null) {
				return false;
			}
		} else if (!adminId.equals(other.adminId)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (pw == null) {
			if (other.pw != null) {
				return false;
			}
		} else if (!pw.equals(other.pw)) {
			return false;
		}
		return true;
	}
	
	
	
}
