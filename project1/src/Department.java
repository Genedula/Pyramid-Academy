/**
 * Department
 * Model Object for the attributes of
 * table departments in company database
 *
 */
public class Department {

    //	attributes
    private int id;
    private String name;

    //	constructor
    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //	getter/setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //	toString method
    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + "]";
    }




}
