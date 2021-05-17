import java.util.List;
/**
 * Department Interface
 * defines the methods to be implemented by the
 * Department DAO concrete class
 */
public interface DAODepartmentInterface {

    //	CRUD operations
    //	CREATE operations
    public boolean addDepartment(Department department);

    //	READ operations
    public List<Department> getAllDepartments();

    public Department getDepartmentById(int id);

    //	UPDATE operations
//		public boolean updateDepartment(int id);

    //	DELETE operations
    public boolean deleteDepartment(int id);
}
