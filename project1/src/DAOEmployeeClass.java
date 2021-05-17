import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * The DAO concrete class for Employee,
 * which implements methods to access and
 * manipulate the table employees in database company
 */
public class DAOEmployeeClass implements DAOEmployeeInterface {

    private Connection conn = ConnectionManager.getConnection();

    /* adds a new record to table employees based on an Employee object,
     * returns boolean indicating whether or not addition was successful
     */
    @Override
    public boolean addEmployee(Employee employee) {

        try (Statement stmt = conn.createStatement()) {
            boolean b = stmt.execute("INSERT INTO employees(employee_fname, employee_lname, employee_id, "
                    + "employee_age, employee_gender, job_title, dept_id  )"
                    + "					VALUES('" + employee.getFirstName() + "', '" + employee.getLastName() + "', "
                    + employee.getId() + ", " + employee.getAge() + ", '" + employee.getGender() + ", '" +
                    employee.getJobTitle() +"', " +
                    employee.getDepartment().getId() + "'");
//	                    employee.getAddress().getId() + "'");
            if (b) {
                System.out.println("Employee successfully inserted");
                return b;
            } else {
                System.out.println("Failed to insert employee");
                return b;
            }
        } catch (SQLException e) {
            System.out.println("Failed to insert employee");
            return false;
        }
    }

    /* returns all records in table employees in a List,
     * or null if no records exist
     */
    @Override
    public List<Employee> getAllEmployees() {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from employees");  )

        {


            List<Employee> empList = new ArrayList<>();

            while (rs.next()) {

                DAODepartmentClass dao = new DAODepartmentClass();

                Employee emp = new Employee(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        dao.getDepartmentById(rs.getInt(7))
//						rs.getInt(8)
                );
                empList.add(emp);
            }
            rs.close();
            return empList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /* Returns an Employee object by accessing the record in table employee
     * which corresponds to the given id, or null if no such employee exists
     */
    @Override
    public Employee getEmployeeById(int id) {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from employees where employee_id = " + id);  )

        {
            rs.next();
            DAODepartmentClass dao = new DAODepartmentClass();
            Employee emp = new Employee(rs.getString(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getString(6),
                    dao.getDepartmentById(rs.getInt(7))
            );

            rs.close();
            return emp;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//	@Override
//	public boolean updateEmployee(int id) {
//		// TODO Auto-generated method stub
//		return false;
//	}

    /* deletes a record from table employees based on the id given,
     * and returns a boolean indicating whether or not deletion was successful
     */
    @Override
    public boolean deleteEmployee(int id) {
        try (Statement stmt = conn.createStatement()) {
            int removed = stmt.executeUpdate("DELETE from employees WHERE employee_id = " + id);
            if (removed > 0) {
                System.out.println("Employee deleted successfully");
                return true;
            } else {
                System.out.println("Employee failed to delete");
                return false;
            }
        }catch (SQLException e) {
            System.out.println("Employee failed to delete");
            return false;
        }
    }



}
