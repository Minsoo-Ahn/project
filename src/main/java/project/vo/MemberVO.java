package project.vo;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Alias("MemberVO")
public class MemberVO {
	@Length(min=6, max=12, message="ID should be 6 ~ 12 character")
	private String id;
	@Length(min=6, max=12, message="Password should be 6 ~ 12 character")
	private String password;
	@NotEmpty(message="Enter the Name")
	private String name;
	@Email(message="Invalid Email form")
	@Size(min=6, message="Invaild Email form")
	private String email;
	@Pattern(regexp="^\\d{3}-\\d{3,4}-\\d{4}$",message="010-1234-5678")
	private String phone;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
