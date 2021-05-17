/**
 * Employee
 * Model Object for the attributes of
 * table employees in company database
 *
 */
public class Employee {

    //	attributes
    private String firstName;
    private String lastName;
    private int id;
    private int age;
    private String gender;
    private String jobTitle;

    private Department department;
    private Address address;

    //	constructor
    public Employee(String firstName, String lastName, int id, int age, String gender, String jobTitle,
                    Department department) {
//			, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.jobTitle = jobTitle;
        this.department = department;
//		this.address = address;
    }

    //	getters/setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

//	public Address getAddress() {
//		return address;
//	}
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}

    //	toString method
    @Override
    public String toString() {
        return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", gender=" + gender
                + ", id=" + id + ", jobTitle=" + jobTitle + ", department=" + department + ", address=" + address + "]";
    }






}
