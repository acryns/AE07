package Backend;
import com.j256.ormlite.table.*;
import com.j256.ormlite.field.*;

@DatabaseTable(tableName = "people")
public class Person {

	public Person(){
		
	}
	@DatabaseField
	private String firstname;
	@DatabaseField
	private String lastname;
	@DatabaseField
	private int age;
	//@DatabaseField
	//private String birthday;
	@DatabaseField
	private String street;
	@DatabaseField
	private String city;
	@DatabaseField
	private int zip;
//	@DatabaseField
//	private String photo;
	@DatabaseField
	private String gender;
//	@DatabaseField
//	private String picture;
	@DatabaseField
	private String info;
	@DatabaseField
	private String note;
//	@DatabaseField
//	private String phone;
	@DatabaseField
	private String mail;
	@DatabaseField(generatedId=true)
	private int person_id;
	
	
	public int getPerson_Id() {
		return person_id;
	}
	public void setPerson_Id(int id) {
		this.person_id = id;
	}
	public String getName() {
		return firstname;
	}
	public void setName(String name) {
		this.firstname = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
//	public String getBirthday() {
//		return birthday;
//	}
//	public void setBirthday(String birthday) {
//		this.birthday = birthday;
//	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
//	public String getPicture() {
//		return picture;
//	}
//	public void setPicture(String picture) {
//		this.picture = picture;
//	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String addInfo) {
		this.info = addInfo;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
//	public String getPhone() {
//		return phone;
//	}
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
//	public String getPhoto() {
//		return photo;
//	}
//	public void setPhoto(String photo) {
//		this.photo = photo;
//	}	

}
