import java.util.List;
/**
 * Employee Interface
 * defines the methods to be implemented
 * by the Employee DAO concrete class
 *
 */

public interface DAOEmployeeInterface {

    //	CRUD operations
//	CREATE operations
    public boolean addEmployee(Employee employee);

    //	READ operations
    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(int id);

//	UPDATE operations
//	public boolean updateEmployee(int id);

    //	DELETE operations
    public boolean deleteEmployee(int id);
}
