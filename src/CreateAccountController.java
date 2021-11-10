import java.sql.Connection;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateAccountController {

	
	@FXML
	private Button btnCrtAcct;
	@FXML
	private TextField txtFieldUsername;
	@FXML
	private TextField txtFieldPswrd;
	@FXML
	private TextField txtFieldPswrdConfirm;
	@FXML
	private TextField txtFieldProfileName;
	@FXML
	private TextField txtFieldAge;
	@FXML
	private TextField txtFieldCrntWeight;
	@FXML
	private TextField txtFieldGoalWeight;
	@FXML
	private TextField txtFieldHeight;
	@FXML
	private RadioButton radioKilo;
	@FXML
	private RadioButton radioPounds;

	
	//GETTERS
	public String gettxtFieldUsername()
	{
		String usr = txtFieldUsername.getText().trim();
		return usr;
	}
	
	public String gettxtFieldPswrd()
	{
		String psw = txtFieldPswrd.getText().trim();
		return psw;
	}
	
	public String gettxtFieldPswrdConfirm()
	{
		String psw = txtFieldPswrdConfirm.getText().trim();
		return psw;
	}
	
	public String gettxtFieldProfileName()
	{
		String pName = txtFieldProfileName.getText().trim();
		return pName;
	}
	
	public String gettxtFieldAge()
	{
		String age = txtFieldAge.getText().trim();
		return age;
	}
	
	public String gettxtFieldCrntWeight()
	{
		String crtWei = txtFieldCrntWeight.getText().trim();
		return crtWei;
	}
	
	public String gettxtFieldGoalWeight()
	{
		String goalWei = txtFieldGoalWeight.getText().trim();	
		return goalWei;
	}
	
	public String gettxtFieldHeight()
	{
		String height = txtFieldHeight.getText().trim();
		return height;
	}
	

	
	//Tests all different fields and if they are correct creates account 
	//if not correct 
	public void createAcctBtn(ActionEvent event)
	{
		boolean passes = true;
		boolean passesUsr = true;
		boolean passesPsw = true;
		boolean passesPname = true;
		boolean passesAge = true;
		boolean passesWei = true;
		boolean passesGoalWei = true;
		boolean passesHeight = true;
		
		//Make sure username is between 1-20 chars 
		if(!passesUsr == usernameCheck())
		{
			passesUsr = false;
			passes = false;
		}
		//Make sure password & re-enter match 
		if(!passesPsw == passwordCheck())
		{
			passesPsw = false;
			passes = false;
		}
		//Make sure it passes profile name 1-20 chars 
		if(!passesPname == profileNameCheck())
		{
			passesPname = false;
			passes = false;
		}
		//Make sure age , and both weights are nums and populated
		if(!passesAge == ageCheck())
		{
			passesAge = false;
			passes = false;
		}
		
		if(!passesWei == weightCheck())
		{
			passesWei = false;
			passes = false;
		}
		
		if(!passesGoalWei == weightGoalCheck())
		{
			passesGoalWei = false;
			passes = false;
		}
		
		if(!passesHeight == heightCheck())
		{
			passesHeight = false;
			passes = false;
		}

		
		
		//if all pass then update table with user info 
		if(passes == true)
		{	
			try(Connection conn = DriverManager.getConnection("jdbc:sqlite:USER.db");
		        Statement stmt = conn.createStatement();
				//ResultSet rs = stmt.executeQuery("SELECT * FROM USER_DATA");

			    )
				{
				conn.setAutoCommit(false);
				//update usr info into table
				
				String sql;
				sql = "INSERT INTO USER_DATA ( USERNAME, PASSWORD, PROFILE_NAME, "
				+ "AGE, HEIGHT, START_WEIGHT, GOAL_WEIGHT, CURRENT_WEIGHT, METRIC_CHECK ) "
				+ "VALUES ( '"+ gettxtFieldUsername() +"', '" + gettxtFieldPswrd() 
				+ "', '" + gettxtFieldProfileName() + "', " + gettxtFieldAge() + ", " 
				+ gettxtFieldHeight() + ", " + gettxtFieldCrntWeight() + ", " + 
				gettxtFieldGoalWeight() + ", 0, " + isSelected() + " )";
					
				stmt.executeUpdate(sql);
				
				stmt.close();
	            conn.commit();
		        conn.close();
		        
				//close this window and open main scene
		        //Close this stage
				Stage stage1 = (Stage) btnCrtAcct.getScene().getWindow();
		    	stage1.close();
		    	
		    	
		    	//Open Main stage 
				TabPane root = (TabPane)FXMLLoader.load(getClass().getResource("MainScene.fxml"));
				Scene scene = new Scene(root,1231.0,583.0);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				Stage stage = new Stage();
				stage.setTitle("MyFitness");
				stage.setScene(scene);
				stage.show();
				
				}
				catch (SQLException | IOException e) {
					e.printStackTrace();
				}
		}
		else
		{
			
			//if one or more fail highlight red failed fields
			if(passesUsr == false)
			{
				txtFieldUsername.setStyle("-fx-text-box-border: #B22222;");
			}
			else
			{
				txtFieldUsername.setStyle("-fx-text-box-border: #000000;");
			}
			if(passesPsw == false)
			{
				txtFieldPswrd.setStyle("-fx-text-box-border: #B22222;");
				txtFieldPswrdConfirm.setStyle("-fx-text-box-border: #B22222;");
			}
			else
			{
				txtFieldPswrd.setStyle("-fx-text-box-border: #000000;");
				txtFieldPswrdConfirm.setStyle("-fx-text-box-border: #000000;");
			}
			if(passesPname == false)
			{
				txtFieldProfileName.setStyle("-fx-text-box-border: #B22222;");
			}
			else
			{
				txtFieldProfileName.setStyle("-fx-text-box-border: #000000;");
			}
			if(passesAge == false)
			{
				txtFieldAge.setStyle("-fx-text-box-border: #B22222;");
			}
			else
			{
				txtFieldAge.setStyle("-fx-text-box-border: #000000;");
			}
			if(passesWei == false)
			{
				txtFieldCrntWeight.setStyle("-fx-text-box-border: #B22222;");
			}
			else
			{
				txtFieldCrntWeight.setStyle("-fx-text-box-border: #000000;");
			}
			if(passesGoalWei == false)
			{
				txtFieldGoalWeight.setStyle("-fx-text-box-border: #B22222;");
			}
			else
			{
				txtFieldGoalWeight.setStyle("-fx-text-box-border: #000000;");
			}
			if(passesHeight == false)
			{
				txtFieldHeight.setStyle("-fx-text-box-border: #B22222;");
			}
			else
			{
				txtFieldHeight.setStyle("-fx-text-box-border: #000000;");
			}
		}
	}
	
	
	//lb radio if selected kg unselect. if unselected (else) then kg selected
	public void radioPounds(ActionEvent event)
	{
		if(radioPounds.isSelected()) {
	        radioKilo.setSelected(false);    
	    }
		else
		{
			radioKilo.setSelected(true);
		}
		
	}
	
	public void radioKilo(ActionEvent event)
	{
		if(radioKilo.isSelected()) {
			radioPounds.setSelected(false);    
	    }
		else
		{
			radioPounds.setSelected(true);
		}
		
	}
	
	public int isSelected()
	{
		if(radioKilo.isSelected())
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	//username check 
	public boolean usernameCheck()
	{
		String usrN = gettxtFieldUsername();
		if(usrN.length() > 0 && usrN.length() < 21)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	//password checks
	public boolean passwordCheck()
	{	
		
		String psw = gettxtFieldPswrd();
		String rePsw = gettxtFieldPswrdConfirm();
		
		//Checking for an entry
		if(psw.isEmpty() || rePsw.isEmpty() || psw.isBlank() || rePsw.isBlank())
		{
			return false;
		}
		//Checking lengths 
		if(psw.length() < 8 || psw.length() > 15 || rePsw.length() < 8 || rePsw.length() > 15)
		{
			return false;
		}
		
		//Making sure equals 
		if(psw.equals(rePsw))
		{	//Making sure upper case 
			if(!psw.equals(psw.toLowerCase()))
			{
				//making sure num 
				boolean dig = false;
				
				for(char c : psw.toCharArray()) 
				{
					if(Character.isDigit(c))
					{
						dig = true;
					}
				}
				if(dig == true)
				{
					//All cases pass
					return dig;
				}
			}
		}
		
	//one or more case fail 
	return false;
	}
	
	
	//Profile name check
	public boolean profileNameCheck()
	{
		String usrN = gettxtFieldProfileName();
		if(usrN.length() > 0 && usrN.length() < 21)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	//age check 
	public boolean ageCheck()
	{
		String age = gettxtFieldAge();
		boolean noChar = true;
		
		if(!age.isEmpty() || !age.isBlank())
		{
			for(char c : age.toCharArray())
			{
				if(!Character.isDigit(c))
				{	
					//contains a char 
					noChar = false;
				}
			}
		}
		else
		{
			noChar = false;
		}
		
		return noChar;
		
	}
	
	
	//weight current check 
	public boolean weightCheck()
	{
		String wei = gettxtFieldCrntWeight();
		boolean noChar = true;
		
		if(!wei.isEmpty() || !wei.isBlank())
		{
			for(char c : wei.toCharArray())
			{
				if(!Character.isDigit(c))
				{	
					//contains a char 
					noChar = false;
				}
			}
		}
		else
		{
			noChar = false;
		}
		
		return noChar;
	}
	
	
	//weight goal check 
	public boolean weightGoalCheck()
	{
		String wei = gettxtFieldGoalWeight();
		boolean noChar = true;
		
		if(!wei.isEmpty() || !wei.isBlank())
		{
			for(char c : wei.toCharArray())
			{
				if(!Character.isDigit(c))
				{	
					//contains a char 
					noChar = false;
				}
			}
		}
		else
		{
			noChar = false;
		}
		
		return noChar;
	}
	
	
	public boolean heightCheck()
	{
		String hei = gettxtFieldGoalWeight();
		boolean noChar = true;
		
		if(!hei.isEmpty() || !hei.isBlank())
		{
			for(char c : hei.toCharArray())
			{
				if(!Character.isDigit(c))
				{	
					//contains a char 
					noChar = false;
				}
			}
		}
		else
		{
			noChar = false;
		}
		
		return noChar;
	}
	
	
	
}
