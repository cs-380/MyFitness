import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Table {
	private String defaults = "Database_Defaults";
	private String tableName;
	private boolean table_state = false;
    private SQL_QUERY command = new SQL_QUERY();
	private static Scanner scan;
    public Table(String name) {
    	tableName = name;
    	check_n_initialize();
    }
	//String name, int cal , int pro , int carb , int fat
    public void addFood (){
        scan = new Scanner(System.in);
        System.out.println("What is the name of your food?");
        String name = scan.nextLine();
        System.out.println("How many calories are in " + name +"?");
        int cal = scan.nextInt();
        System.out.println("How many grams of protein are in " + name +"?");
        int pro = scan.nextInt();
        System.out.println("How many grams of carbs are in " + name +"?");
        int carb = scan.nextInt();
        System.out.println("How many grams of fats are in " + name +"?");
        int fat = scan.nextInt();
        scan.nextLine();
        
        //Creating SQL string to add to table
        String sql = "INSERT INTO " 
        			+ tableName
        			+" (Name , Calories , Protein , Carbs , Fat) "
        			+ "VALUES ('" + name + "', " + cal + ", " + pro + ", " + carb + ", " + fat + " );";
        //Usr rechecks values
        System.out.println("Does this look correct?");
        System.out.println(name);
        System.out.println("Total calories " + cal);
        System.out.println("Total protein " + pro);
        System.out.println("Total carbs " + carb);
        System.out.println("Total fats " + fat);
        
        //Deciding if it looks correct to pass through
        System.out.println("If it looks correct type Y/y. If something needs to be changed type N/n");
        String usr = scan.nextLine();
        
        if(usr.equals("N") || usr.equals("n"))
        {
            //Not correct retry
            System.out.println("No worries. Lets try that again.");
            addFood();
            return;
        }
        command.Query(sql);
        System.out.println(name + " Successfully added.");  
    }
    public void addNew_Food(int ID) {
    	String[] columns_name = getArrayCollumns();
        String sql = "INSERT INTO " 
    			+ tableName
    			+" (";
        		for(int i = 0; i < columns_name.length-1; i++) {
        			sql +="\""+ columns_name[i] + "\"" + ", ";
        		}
        	   sql += "\"" + columns_name[columns_name.length-1] + "\"";
    		   sql +=") "
				+ "VALUES ( "
				+ ID
				+ ", " + "\"\"" 
				+ ", " + "\"\"";
			   for(int i = 0; i < columns_name.length-3; i++) {
				   sql += ", " + 0;
			   }
    		   sql += " );";
        command.Query(sql);
    }
    public void addNew_Link(int ID) {
        String sql = "INSERT INTO " 
    			+ tableName
    			+" ("
        	    + "\""+ "Description" + "\"" + ", "
        	    + "\""+ "ID" + "\"" + ", "
        	    + "\""+ "ID_1" + "\"" + ", "
        	    + "\""+ "ID_2" + "\"" + ", "
        	    + "\"" + "Portion (g)" + "\""
    		    + ") "
				+ "VALUES ( "

				+ "\"\"" 
				+ ", " + ID
				+ ", " + 0
        		+ ", " + 0
        		+ ", " + 0
    		    + " );";
        command.Query(sql);
    }
    public String[] getArrayCollumns() {
		try {
			return  Files.lines(Paths.get(defaults + "\\column_name.txt"))
					.map(l -> l).toArray(String[]::new);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
    public void check_n_initialize() {
    	if(table_state == false) {
    		create_table();
    	}
    }
    private void create_table() {
    	if(!command.tableExists(tableName)) {
    		if(tableName.contains("LINK")) {
        		String sql = "CREATE TABLE "
    					+ "\"" + tableName + "\"" 
        				+ " (\r\n"
    					+ " \"Description\" NVARCHAR(100),"
        				+ " \"ID\"	INTEGER,\r\n" 
        				+ " \"ID_1\"	INTEGER,\r\n"
        				+ " \"ID_2\"	INTEGER,\r\n"
        				+ " \"Portion (g)\"	FLOAT,\r\n"
        				+ " FOREIGN KEY(\"ID_2\") REFERENCES \"FOOD_DATA\"(\"ID\"),\r\n" 
        				+ " FOREIGN KEY(\"ID_1\") REFERENCES \"MEAL_DATA\"(\"ID\"),\r\n" 
        				+ " PRIMARY KEY(\"ID\")"
        				+ ");" ;
    			command.Query(sql);
        		close();
            	table_state = true;
        		return;
    		}
    		if(tableName.contains("_DATA")) {
        		String sql = "CREATE TABLE "
    					+ "\"" + tableName + "\"" 
        				+ " (\r\n"
        				+ "	\"ID\"	INTEGER NOT NULL UNIQUE,\r\n"
        				+ "	\"Name\"	NVARCHAR(100),\r\n"
        				+ "	\"Description\"	NVARCHAR(1000),\r\n"
        				+ "	\"Calories\"	FLOAT,\r\n"
        				+ "	\"Protein\"	FLOAT,\r\n"
        				+ "	\"Carbs\"	FLOAT,\r\n"
        				+ "	\"Sugars\"	FLOAT,\r\n"
        				+ "	\"Fiber\"	FLOAT,\r\n"
        				+ "	\"Fat\"	FLOAT,\r\n"
        				+ "	\"Fatty acids, saturated\"	FLOAT,\r\n"
        				+ "	\"Fatty acids, monounsaturated\"	FLOAT,\r\n"
        				+ "	\"Fatty acids, polyunsaturated\"	FLOAT,\r\n"
        				+ "	\"Cholesterol (mg)\"	FLOAT,\r\n"
        				+ "	\"Retinol (mcg)\"	FLOAT,\r\n"
        				+ "	\"Vitamin A, RAE (mcg_RAE)\"	FLOAT,\r\n"
        				+ "	\"Carotene, alpha (mcg)\"	FLOAT,\r\n"
        				+ "	\"Carotene, beta (mcg)\"	FLOAT,\r\n"
        				+ "	\"Cryptoxanthin, beta (mcg)\"	FLOAT,\r\n"
        				+ "	\"Lycopene (mcg)\"	FLOAT,\r\n"
        				+ "	\"Lutein + zeaxanthin (mcg)\"	FLOAT,\r\n"
        				+ "	\"Thiamin (mg)\"	FLOAT,\r\n"
        				+ "	\"Riboflavin (mg)\"	FLOAT,\r\n"
        				+ "	\"Niacin (mg)\"	FLOAT,\r\n"
        				+ "	\"Vitamin B-6 (mg)\"	FLOAT,\r\n"
        				+ "	\"Folic acid (mcg)\"	FLOAT,\r\n"
        				+ "	\"Folate, food (mcg)\"	FLOAT,\r\n"
        				+ "	\"Folate, DFE (mcg_DFE)\"	FLOAT,\r\n"
        				+ "	\"Folate, total (mcg)\"	FLOAT,\r\n"
        				+ "	\"Choline (mg)\"	FLOAT,\r\n"
        				+ "	\"Vitamin B-12 (mcg)\"	FLOAT,\r\n"
        				+ "	\"Vitamin B-12, added (mcg)\"	FLOAT,\r\n"
        				+ "	\"Vitamin C (mg)\"	FLOAT,\r\n"
        				+ "	\"Vitamin D (D2 + D3) (mcg)\"	FLOAT,\r\n"
        				+ "	\"Vitamin E (alpha-tocopherol) (mg)\"	FLOAT,\r\n"
        				+ "	\"Vitamin E, added (mg)\"	FLOAT,\r\n"
        				+ "	\"Vitamin K (phylloquinone) (mcg)\"	FLOAT,\r\n"
        				+ "	\"Calcium (mg)\"	FLOAT,\r\n"
        				+ "	\"Phosphorus (mg)\"	FLOAT,\r\n"
        				+ "	\"Magnesium (mg)\"	FLOAT,\r\n"
        				+ "	\"Iron (mg)\"	FLOAT,\r\n"
        				+ "	\"Zinc (mg)\"	FLOAT,\r\n"
        				+ "	\"Copper (mg)\"	FLOAT,\r\n"
        				+ "	\"Selenium (mcg)\"	FLOAT,\r\n"
        				+ "	\"Potassium (mg)\"	FLOAT,\r\n"
        				+ "	\"Sodium (mg)\"	FLOAT,\r\n"
        				+ "	\"Caffeine (mg)\"	FLOAT,\r\n"
        				+ "	\"Theobromine (mg)\"	FLOAT,\r\n"
        				+ "	\"Alcohol (g)\"	FLOAT,\r\n"
        				+ "	\"Water (g)\"	FLOAT,\r\n"
        				+ "	PRIMARY KEY(\"ID\")\r\n"
        				+ ");" ;
    			command.Query(sql);
        		close();
        		if(tableName.equals("FOOD_DATA")) {
        			for(int i = 1; i <= 4; i++) {
        				try {
        					sql = new String (Files.readAllBytes(Paths.get(defaults + "\\food"+i+".txt")));
        					command.Query(sql);
        				} catch (IOException e) {
        					// TODO Auto-generated catch block
        					e.printStackTrace();
        				}
        			}
        		}
            	table_state = true;
        		return;
    		}
    	}
    }
	public void set_value_by_ID(int iD, String column_name, Object value) {
		command.Query("UPDATE "
						+ "\"" + tableName + "\"" 
						+ " SET " 
						+ "\"" 
						+ column_name
						+ "\""
						+ " = "
						+ "\"" 
						+ value
						+ "\""
						+ " WHERE ID = " + iD +";");
	}
    public void search_for_food() {
        scan = new Scanner(System.in);
        System.out.println("Type in search: ");
        String input = scan.nextLine();
        Food[] test_search = new Food[0];
		if(tableName.equals("FOOD_DATA"))test_search = FOOD_DATA.searching(input);
		if(tableName.equals("MEAL_DATA"))test_search = MEAL_DATA.searching(input);
        System.out.println("Here is your search results: ");
		for(int i =0; i < test_search.length; i++) {
			System.out.println(test_search[i]);
		}
    }
    public void close()
    {
        command.SQL_close();
    }
}  

