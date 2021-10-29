import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Link {
	private String TABLE_NAME ="";
	private String Description = "";
	private int ID = 0;
	private int ID_1 = 0;
	private int ID_2 = 0;
	private double Portion = 0;
    private static SQL_QUERY command = new SQL_QUERY();
    private static Table table;
    public Link(String table_name) {
    	table = new Table(table_name);
    	TABLE_NAME = table_name;
    }
    public Link(String table_name, int row_ID) {
    	table = new Table(table_name);
    	TABLE_NAME = table_name;
    	if(!command.rowExists(table_name, row_ID)) {
    		table.addNew_Link(row_ID);
    	}
    	get_table_by_ID(row_ID);
    }
    public Link(Link new_food) {
    	this(new_food.getTABLE_NAME(), new_food.getID());
    }
    public void close()
    {
        table.close();
    }
	private void get_table_by_ID(int value) {
    	ResultSet data = command.get_data_from_row(TABLE_NAME, String.valueOf(value), "ID");
    	try {
			Description = data.getString(1);
			ID = data.getInt(2);
			ID_1 = data.getInt(3);
			ID_2 = data.getInt(4);
			Portion = Double.parseDouble(Float.toString(data.getFloat(5)));
			command.SQL_close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
    }
	private int[] get_table_by_LINK(Food food_table) {
		ArrayList<Integer> IDs = new ArrayList<Integer>();
    	ResultSet temp = command.get_data_from_row(TABLE_NAME, String.valueOf(food_table.getID()), "ID_1");
    	try {
			while (temp.next()) {
			    IDs.add(temp.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		command.SQL_close();
		return IDs.stream().mapToInt(i -> i).toArray();
    }
	private int[] get_table_by_LINK_object(Food food_table) {
		ArrayList<Integer> IDs = new ArrayList<Integer>();
    	ResultSet temp = command.get_data_from_row(TABLE_NAME, String.valueOf(food_table.getID()), "ID_1");
    	try {
			while (temp.next()) {
			    IDs.add(temp.getInt(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		command.SQL_close();
		return IDs.stream().mapToInt(i -> i).toArray();
    }
	public static Food[] get_table_LINK(String TABLE_NAME, Food food_table) {
		int[] result = new Link(TABLE_NAME).get_table_by_LINK(food_table);
		Food[] result_link = new Food[result.length];
		if(food_table.getTABLE_NAME().contains("MEAL")) {
			for(int i = 0; i < result.length; i++) {
				result_link[i] = new Food("FOOD_DATA", result[i]);
			}
		}
		return result_link;
	}
	public static Link[] get_table_LINK_object(String TABLE_NAME, Food food_table) {
		int[] result = new Link("LINK_"+TABLE_NAME).get_table_by_LINK_object(food_table);
		Link[] result_link = new Link[result.length];
		if(food_table.getTABLE_NAME().contains("MEAL")) {
			for(int i = 0; i < result.length; i++) {
				result_link[i] = new Link("LINK_"+TABLE_NAME, result[i]);
			}
		}
		return result_link;
	}
	public String getDescription() {
		return Description;
	}
	public String getTABLE_NAME() {
		return TABLE_NAME;
	}
	public int getID() {
		return ID;
	}
	public int getID_1() {
		return ID_1;
	}
	public int getID_2() {
		return ID_2;
	}
	public double getPortion() {
		return Portion;
	}
	public void setDescription(String description) {
		Description = description;
		table.set_value_by_ID(ID, "Description",description);
	}
	public void set_new_ID(int ID_new) {
    	if(!command.rowExists(TABLE_NAME, ID_new) && ID != ID_new) {
    		ID = ID_new;
    		table.addNew_Link(ID_new);
    		get_table_by_ID(ID_new);
    		return;
    	}
		ID = ID_new;
    	get_table_by_ID(ID_new);
		table.set_value_by_ID(ID, "ID",ID_new);
	}
	public void set_new_ID_1(int ID_new) {
		ID_1 = ID_new;
		table.set_value_by_ID(ID, "ID_1",ID_new);
	}
	public void set_new_ID_2(int ID_new) {
		ID_2 = ID_new;
		table.set_value_by_ID(ID, "ID_2",ID_new);
	}
	public void setPortion(double portion) {
		Portion = portion;
		table.set_value_by_ID(ID, "Portion (g)",portion);
	}
}
