package retailhub;

import java.util.ArrayList;

public class Employee {
	
	private String name;
	private String surname;
	private int employee_id;
	private double salary;
	private String email;
	private String address;
	//authentication fields...
	private String username;
	private String password;
	private Role role;
	//list for the working hours...
	private ArrayList<WorkHours> hours = new ArrayList<WorkHours>();
	
	public enum Role {
        MANAGER,
        ADMINISTRATOR,
        SALESPERSON,
        WAREHOUSE_EMPLOYEE,
        HR_EMPLOYEE,
        ACCOUNTANT
        
    }
	
	public Employee(String name, String surname, int employee_id, double salary, String email, String address, String username, String password, Role role) {
		this.name        = name;
        this.surname     = surname;
        this.employee_id  = employee_id;
        this.salary      = salary;
        this.email       = email;
        this.address     = address;
        this.username    = username;
        this.password    = password;       
        this.role        = role;
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public ArrayList<WorkHours> getHours() {
		return hours;
	}

	public void setHours(ArrayList<WorkHours> hours) {
		this.hours = hours;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", surname=" + surname + ", employee_id=" + employee_id + ", salary=" + salary
				+ ", email=" + email + ", address=" + address + ", username=" + username + ", password=" + password
				+ ", role=" + role + ", hours=" + hours + "]";
	}
	
	public void addWorkHours(WorkHours wh) {
		hours.add(wh);
	}
	
	
	
	
	
	

}