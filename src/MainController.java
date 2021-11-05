
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MainController 
{
	@FXML
	private Button AddFoodButton;
	@FXML
	private Button AddMealButton;
	@FXML
	private Button GenerateMealButton;
	@FXML
	private TextArea tArea;
	@FXML
	private TextField foodSearchField;
	
	
	
	public TextArea gettArea()
	{
		return tArea;
	}
	public void settArea(String str)
	{
	
		tArea.appendText("\n" + str + "\n");
	}
	
	public TextField getfoodSearchField()
	{
		return getFoodSearchField();
	}
	
	
	//Meal list tab
	public void GenerateMeal(ActionEvent event) throws IOException // what happens when click generate meal
	{
		tArea.setText("ok we did it");	// place holder
	}
	
	public void AddFood() throws IOException    // insert a specific food to DB ( maybe a meal? )
	{
		
	}
	
	public void SearchTable()  // for getting nutrition from food name *obsolete*
	{
		String input = getFoodSearchField().getText();
		
      // Open a connection
      try(Connection conn = DriverManager.getConnection("jdbc:sqlite:FOOD.db");
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM FOOD_DATA");
      ) 
      {		      
         while(rs.next())
         {
        	 int tName = rs.getInt("ID");
        	 int input2 = Integer.parseInt(input);
        	 
        	 if (input2 == tName)
        	 {
        		 tArea.setText("Fat: " + rs.getInt("Fat"));
        	 }

         }
      } 
      catch (SQLException e) 
      {
         e.printStackTrace();
      } 
      
	}
    public void search_for_food() {
    	TextField inputs = getFoodSearchField();
       // scan = new Scanner(System.in);
        //System.out.println("Type in search: ");
        String input = inputs.getText();
        Food[] test_search = new Food[0];
        if (!input.equals(""))
        {
    		test_search = FOOD_DATA.searching(input);
    		//if(tableName.equals("MEAL_DATA"))test_search = MEAL_DATA.searching(input);
    		String str = "";
    		for(int i =0; i < test_search.length; i++) {
    			str = test_search[i].toString();
    			settArea(str);
    		}
        }
		
    }
	public void FoodSearch(ActionEvent event) throws IOException
	{
		tArea.clear();
		search_for_food();
	}
	public TextField getFoodSearchField() {
		return foodSearchField;
	}
	public void setFoodSearchField(TextField foodSearchField) {
		this.foodSearchField = foodSearchField;
	}
}
