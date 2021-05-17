import java.util.Scanner;
public class Address
{
    private String city;
    private String state;
    private int zipCode;

    public Address(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter any number : ");
        String number = in.next();
    }
    {
        city = "?";
        state = "?";
    }

    public String getCity()
    {
        return city;
    }

    public String getState()
    {
        return state;
    }
    public int getZipCode()
    {
        return zipCode;
    }

    public void setCity(String theCity)
    {
        city = theCity;
    }

    public void setState(String theState)
    {
        state = theState;
    }
    public void setZipCode(int theZipCode)
    {
        zipCode = theZipCode;
    }

    public String toString()
    {
        return city + "," + state + "," + zipCode;
    }

}