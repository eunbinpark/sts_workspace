package bitedu.bipa.PEB.vo;

public class MemberVO {
	private String userId;
	private String password;
	private String phone;
	
	public MemberVO(String userId, String password, String phone) {
		super();
		this.userId = userId;
		this.password = password;
		this.phone = phone;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String phone) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", phone=" + phone + "]";
	}
	
	
	
}
