import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

	
	public static String global = "";
	
	@FXML
	private Button BtnLogin;
	@FXML
	private Button btnCrtAcct;
	@FXML
	private TextField txtFieldUsr;
	@FXML
	private TextField txtFieldPswrd;
	@FXML
	private Label lblWrongCredentials;

	
	//Getters
	public String getUsr()
	{
		String usr = txtFieldUsr.getText().trim();
		return usr;
	}
	
	public String getPswrd()
	{
		String pswrd = txtFieldPswrd.getText().trim();
		return pswrd;
	}
	
	
//TODO Fix to use all usernames 	
	
	public void loginBtn(ActionEvent event)
	{
	//Gets usrname / pswrd compares with table to see if correct
	//If correct login and pop up with user pane on main UI and delete Login pane
		try(Connection conn = DriverManager.getConnection("jdbc:sqlite:USER.db");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM USER_DATA");
	    )
		{
			System.out.println("Hello????");
			String enteredUsr = getUsr();
			String enteredPswrd = getPswrd();
			
			
			while(rs.next())
			{
				
				String tblUsr = rs.getString("username");
				String tblPswrd = rs.getString("password");
				
				if(enteredUsr.equals(tblUsr) && enteredPswrd.equals(tblPswrd))
				{
					global = enteredUsr;
					//Correct login 
					//Close this stage
					Stage stage1 = (Stage) btnCrtAcct.getScene().getWindow();
			        stage1.close();
			    	
			    	
			    	//Open Main stage 
					TabPane root = (TabPane)FXMLLoader.load(getClass().getResource("MainScene.fxml"));
					Scene scene = new Scene(root,1231.0,583.0);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					stage1.setTitle("MyFitness");
					stage1.setScene(scene);
					stage1.show();
					
			    	
				}
				else
				{
					//Wrong Username or Password please retry
					lblWrongCredentials.setVisible(false);
					lblWrongCredentials.setVisible(true);
				}
			
			}
			
		 } catch (SQLException | IOException e) {
			//Auto-generated catch block
			e.printStackTrace();
		 }
		
		
	}
	
	
	public void createUsrBtn(ActionEvent event)
	{
	/*
	 * Delete login pane and pop up with create user pane 
	 */
		System.out.println("Hello?");
		try 
		{
			//Delete this stage 
		    Stage stage1 = (Stage) btnCrtAcct.getScene().getWindow();
		    stage1.close();
		    
		    
		    //Open create user stage
			/*
			 * TabPane root = (TabPane)FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
			Scene scene = new Scene(root,1231.0,583.0);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());	
			Stage stage = new Stage();
			*/
		    Parent root = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
			stage1.setTitle("Create Account");
			stage1.setScene(new Scene(root));
			stage1.show();
		} 
		
		catch(Exception e) 
		{
			e.printStackTrace();
		}    
	    
	}
}
