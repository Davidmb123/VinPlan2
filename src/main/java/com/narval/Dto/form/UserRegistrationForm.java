package com.narval.Dto.form;

//import lombok.Getter;
//import lombok.Setter;


//@Getter 
//@Setter
public class UserRegistrationForm {

	private String email;
	private String name;
	private String lastname;
	private String username;
	private String gender;
	private String birthday;
	private String password;
	private String confirmationPassword;
	private String role;
	private int tipo_usuario_id;
	private int active;
	//private String role;
	
	public void setTipo_usuario_id(int tipoId) {
		this.tipo_usuario_id=tipoId;
	}
	public int getTipo_usuario_id() {
		return this.tipo_usuario_id;
	}
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setGender(String gender) {
		this.gender=gender;
	}
	public String getGender() {
		return gender;
	}
	
	public void setBirthday(String birthday) {
		this.birthday=birthday;
	}
	public String getBirthday() {
		return birthday;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirmationPassword() {
		return confirmationPassword;
	}
	
	public void setConfirmationPassword(String confirmationPassword) {
		this.confirmationPassword = confirmationPassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	public void setActive(int activo) {
		this.active=activo;
	}
	public int getActive() {
		return active;
	}
	
}
