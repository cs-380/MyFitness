
public class Food 
{
    public static String addFood (String name, int cal)
    {
        String str = "INSERT INTO TABLE_NAME " + "VALUES ('" + name + "', " + cal + ")";
        return str;
    }
}
