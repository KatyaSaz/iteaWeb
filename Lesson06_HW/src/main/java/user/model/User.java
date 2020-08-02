package user.model;

public class User {
	
	private final String CHECKED = "checked";
	private final String SELECTED = "selected";
	
	private String login;
	private String password;
	private String name;
	private String gender;
	private String address;
	private String comment;
	
	private String cGenderMale = "";
	private String cGenderFemale = "";
	private String cAddrLnr = "";
	private String cAddrDnr = "";
	private String cAddrCrimea = "";
	
	public User() {
	}

	public User(String login, String password, String name, String gender, String address, String comment) {
		super();
		this.login = login;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.comment = comment;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getcGenderMale() {
		return cGenderMale;
	}

	public void setcGenderMale(String cGenderMale) {
		this.cGenderMale = cGenderMale;
	}

	public String getcGenderFemale() {
		return cGenderFemale;
	}

	public void setcGenderFemale(String cGenderFemale) {
		this.cGenderFemale = cGenderFemale;
	}

	public String getcAddrLnr() {
		return cAddrLnr;
	}

	public void setcAddrLnr(String cAddrLnr) {
		this.cAddrLnr = cAddrLnr;
	}

	public String getcAddrDnr() {
		return cAddrDnr;
	}

	public void setcAddrDnr(String cAddrDnr) {
		this.cAddrDnr = cAddrDnr;
	}

	public String getcAddrCrimea() {
		return cAddrCrimea;
	}

	public void setcAddrCrimea(String cAddrCrimea) {
		this.cAddrCrimea = cAddrCrimea;
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password + ", name=" + name + ", gender=" + gender
				+ ", address=" + address + ", comment=" + comment + "]";
	}
	
	public void chooseGender(String inputGender) {
		gender = inputGender;
		if(inputGender.equals("male")) {
			cGenderMale = CHECKED;
		}
		if(inputGender.equals("female")) {
			cGenderFemale = CHECKED;
		}
	}
	
	public void chooseAddress(String inputAddr) {
		address = inputAddr;
		if(inputAddr.equals("lnr")) {
			cAddrLnr = SELECTED;
		}
		if(inputAddr.equals("dnr")) {
			cAddrDnr = SELECTED;
		}
		if(inputAddr.equals("crimea")) {
			cAddrCrimea = SELECTED;
		}
	}
	
}
