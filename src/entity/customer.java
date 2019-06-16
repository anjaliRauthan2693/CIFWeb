package entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "customer")
public class customer {
@Id
@GenericGenerator(name="kaugen" , strategy="increment")
@GeneratedValue(generator="kaugen")
@Column(name= "TransactionId")
private int TransactionId;
@Column(name= "email")
private String email;
@Column(name= "fullname")
private String fullname;
@Column(name= "Age")
private int Age;
@Column(name= "Phone")
private String Phone;
@Column(name= "House")
private String House; 
@Column(name= "City")
private String City;
@Column(name= "State")
private String State;
@Column(name= "Pin")
private int Pin;
@Column(name= "Salary")
private int Salary;	
@Column(name= "Bonus")
private int Bonus;
 
public int getTransactionId() {
	return TransactionId;
}
public void setTransactionId(int transactionId) {
	TransactionId = transactionId;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getFullname() {
	return fullname;
}
public void setFullname(String fullname) {
	this.fullname = fullname;
}
public int getAge() {
	return Age;
}
public void setAge(int age) {
	Age = age;
}
public String getPhone() {
	return Phone;
}
public void setPhone(String phone) {
	Phone = phone;
}
public String getHouse() {
	return House;
}
public void setHouse(String house) {
	House = house;
}
public String getCity() {
	return City;
}
public void setCity(String city) {
	City = city;
}
public String getState() {
	return State;
}
public void setState(String state) {
	State = state;
}
public int getPin() {
	return Pin;
}
public void setPin(int pin) {
	Pin = pin;
}
public int getSalary() {
	return Salary;
}
public void setSalary(int salary) {
	Salary = salary;
}
public int getBonus() {
	return Bonus;
}
public void setBonus(int bonus) {
	Bonus = bonus;
}


	
}
