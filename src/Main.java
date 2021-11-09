
import javafx.application.Application;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application 
{
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{	
			//AnchorPane ap = new AnchorPane();
			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			//Scene scene = new Scene();
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());	
			primaryStage.setTitle("Login");
			primaryStage.setScene(new Scene(root, 500 , 500 ));
			primaryStage.show();
		} 
		
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		Database.getDatabase();
		launch(args);
	}
}
