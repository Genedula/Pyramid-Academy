import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * The DAO concrete class for Department,
 * which implements methods to access and
 * manipulate the table departments in database company
 */
public class DAODepartmentClass implements DAODepartmentInterface {

    private Connection conn = ConnectionManager.getConnection();

    /* adds a new record to table department based on a Department object,
     * returns boolean indicating whether or not addition was successful
     */
    @Override
    public boolean addDepartment(Department department) {

        try (Statement stmt = conn.createStatement()) {
            boolean b = stmt.execute("INSERT INTO departments(dept_id, dept_name)"
                    + "					VALUES(" + department.getId() + ", '" + department.getName() + "'");
            if (b) {
                System.out.println("Department successfully inserted");
                return b;
            } else {
                System.out.println("Failed to insert department");
                return b;
            }
        } catch (SQLException e) {
            System.out.println("Failed to insert department");
            return false;
        }
    }

    /* returns all records in table departments in a List,
     * or null if no records exist
     */
    @Override
    public List<Department> getAllDepartments() {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from departments");  )

        {
            List<Department> deptList = new ArrayList<>();

            while (rs.next()) {

                Department dept = new Department(rs.getInt(1), rs.getString(2));
                deptList.add(dept);
            }
            rs.close();
            return deptList;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /* Returns an Department object by accessing the record in table departments
     * which corresponds to the given id, or null if no such department exists
     */
    @Override
    public Department getDepartmentById(int id) {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from departments where dept_id = " + id);  )

        {
            rs.next();
            Department dept = new Department(rs.getInt(1), rs.getString(2));

            rs.close();
            return dept;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//	@Override
//	public boolean updateDepartment(int id) {
//		// TODO Auto-generated method stub
//		return false;
//	}

    /* deletes a record from table departments based on the id given,
     * and returns a boolean indicating whether or not deletion was successful
     */
    @Override
    public boolean deleteDepartment(int id) {
        try (Statement stmt = conn.createStatement()) {
            //update the employee table by setting every foreign key column with department id
            //to null before executing statement
            stmt.executeUpdate("UPDATE employees SET dept_id = NULL WHERE dept_id = " + id);
            int removed = stmt.executeUpdate("DELETE FROM departments WHERE dept_id = " + id);
            if (removed > 0) {
                System.out.println("Department deleted successfully");
                return true;
            } else {
                System.out.println("Department failed to delete");
                return false;
            }
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Department failed to delete");
            return false;
        }
    }

}
