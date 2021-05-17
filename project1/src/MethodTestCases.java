import java.util.List;

public class MethodTestCases {

    public static void main(String[] args) {

//		Have to run Department and Employee cases separate or you'll get an exception

        //Department Test Cases
        DAODepartmentClass dao = new DAODepartmentClass();
        //getAll
        List<Department> depts = dao.getAllDepartments();
        System.out.println("List of Departments: " + depts);
        //getbyId
        Department deptselection = dao.getDepartmentById(4);
        System.out.println("Just one: " + deptselection);
        //delete
        dao.deleteDepartment(1);


//		//Employee test cases
//		DAOEmployeeClass eao = new DAOEmployeeClass();
//		//getAll
//		List<Employee> emps = eao.getAllEmployees();
//		System.out.println("List of Employees: " + emps);
//		//getbyId
//		Employee empselection = eao.getEmployeeById(31202);
//		System.out.println("Just one: " + empselection);
//		//delete
//		eao.deleteEmployee(31202);
    }

}
