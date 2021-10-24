
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
	private TextArea MLInfo;
	@FXML
	private TextField foodSearchField;
	
	//Meal list tab
	public void GenerateMeal(ActionEvent event) throws IOException // what happens when click generate meal
	{
		MLInfo.setText("ok we did it");	// place holder
	}
	
	public void AddFood() throws IOException    // insert a specific food to DB ( maybe a meal? )
	{
		
	}
	
	public void SearchTable()  // for getting nutrition from food name
	{
		String input = foodSearchField.getText();
		
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
        		 MLInfo.setText("Fat: " + rs.getInt("Fat"));
        	 }

         }
      } 
      catch (SQLException e) 
      {
         e.printStackTrace();
      } 
      
	}
	
	public void FoodSearch(ActionEvent event) throws IOException
	{
		SearchTable();
	}
}
