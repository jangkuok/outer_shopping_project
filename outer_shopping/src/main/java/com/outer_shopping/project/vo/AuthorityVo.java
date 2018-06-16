package com.outer_shopping.project.vo;

import java.io.Serializable;

public class AuthorityVo implements Serializable{
	
	private String loginId; //로그인 아이디
	private String loginPw; //로그인 패스워드
	private String loginAuthority; //로그인 권한
	
	public AuthorityVo(){}

	/**
	 * @param loginId 로그인 아이디 
	 * @param loginPw 로그인 패스워드
	 * @param loginAuthority 로그인 권한
	 */
	public AuthorityVo(String loginId, String loginPw, String loginAuthority) {
		this.loginId = loginId;
		this.loginPw = loginPw;
		this.loginAuthority = loginAuthority;
	}

	/** (non-Javadoc)
	 * toString
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Authority [loginId=" + loginId + ", loginPw=" + loginPw + ", loginAuthority=" + loginAuthority + "]";
	}

	
	//setter.getter
	/**
	 * @return the loginId
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * @param loginId the loginId to set
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * @return the loginPw
	 */
	public String getLoginPw() {
		return loginPw;
	}

	/**
	 * @param loginPw the loginPw to set
	 */
	public void setLoginPw(String loginPw) {
		this.loginPw = loginPw;
	}

	/**
	 * @return the loginAuthority
	 */
	public String getLoginAuthority() {
		return loginAuthority;
	}

	/**
	 * @param loginAuthority the loginAuthority to set
	 */
	public void setLoginAuthority(String loginAuthority) {
		this.loginAuthority = loginAuthority;
	}

	/** (non-Javadoc)
	 * hashCode
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loginAuthority == null) ? 0 : loginAuthority.hashCode());
		result = prime * result + ((loginId == null) ? 0 : loginId.hashCode());
		result = prime * result + ((loginPw == null) ? 0 : loginPw.hashCode());
		return result;
	}

	/**(non-Javadoc)
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
		if (!(obj instanceof AuthorityVo)) {
			return false;
		}
		AuthorityVo other = (AuthorityVo) obj;
		if (loginAuthority == null) {
			if (other.loginAuthority != null) {
				return false;
			}
		} else if (!loginAuthority.equals(other.loginAuthority)) {
			return false;
		}
		if (loginId == null) {
			if (other.loginId != null) {
				return false;
			}
		} else if (!loginId.equals(other.loginId)) {
			return false;
		}
		if (loginPw == null) {
			if (other.loginPw != null) {
				return false;
			}
		} else if (!loginPw.equals(other.loginPw)) {
			return false;
		}
		return true;
	}

	
	
}
