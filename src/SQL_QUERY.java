import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

public class SQL_QUERY {
	private static Connection c = null;
	public SQL_QUERY() {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:FOOD.db");
	    } catch ( Exception e ) {
	    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
	    }
		System.out.println("Opened database successfully");
		SQL_close();
	}
	public void checkConnection() {
		try {
			if(c.isClosed()) {
				c = DriverManager.getConnection("jdbc:sqlite:FOOD.db");
			}
	    } catch ( Exception e ) {
	    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
	    }
	}
	public void Query(String i) {
		  checkConnection();
	      Statement stmt = null;
	      try {
	         stmt = c.createStatement();
	         String sql = i;
	         stmt.execute(sql);
	         stmt.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	      }
	      SQL_close();
	      System.out.println("Query successfully executed");
	}
	public String toString(String TABLE_NAME, String[] temp) {
		   checkConnection();
		   Statement stmt = null;
		   String temp_r= "";
		   try {
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM " + TABLE_NAME + ";" );
		      while ( rs.next() ) {
		    	  for(int i =0; i < temp.length; i++) {
				    	 Object temp_1 = rs.getObject(temp[i]);
				         System.out.println( temp[i]+" = " + temp_1 );
				         System.out.println();
				         temp_r +=  temp[i]+" = " + temp_1 + "\n" + "\n";
				      }
		    	  }
		      rs.close();
		      stmt.close();
		      SQL_close();
		   } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		   }
		   System.out.println("Operation done successfully");
		SQL_close();
		return temp_r;
	}
	public void SQL_close() {
		try {
		c.close();
	    } catch ( Exception e ) {
	    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    System.exit(0);
		}
		System.out.println("Connection To Database Closed");
	}
    public boolean tableExists(String tableName){
    	checkConnection();
        try{
            DatabaseMetaData md = c.getMetaData();
            ResultSet rs = md.getTables(null, null, tableName, null);
            if (rs.next()) {
            	rs.close();
            	SQL_close();
                return true;
            }
            rs.close();
        }catch(SQLException ex){
            Logger.getLogger(SQLiteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        SQL_close();
        return false;
    }
    public boolean rowExists(String tableName, int ID){
    	checkConnection();
        try{
            Statement stmt = c.createStatement();            
            ResultSet rs = stmt.executeQuery("SELECT ID FROM " 
					+ "\"" + tableName + "\"" 
					+ " WHERE " 
					+ "ID" 
					+ " = "
					+ "\"" + ID + "\"" + ";");
            while (rs.next()) {
            	if(rs.getInt(1) == ID) {
            		rs.close();
            		SQL_close();
            		return true;
            	}
            }
            rs.close();
        }catch(SQLException ex){
            Logger.getLogger(SQLiteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        SQL_close();
        return false;
    }
    public ResultSet get_data_from_row(String tableName, String value_o_row, String column_name) {
    	checkConnection();
    	Statement stmt = null;
    	ResultSet rs = null;
    	try {
        	stmt = c.createStatement();
			rs = stmt.executeQuery("SELECT * FROM " 
									+ "\"" + tableName + "\"" 
									+ " WHERE " 
									+ column_name 
									+ " = "
									+ "\"" + value_o_row + "\"" + ";");
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
    	return rs;
    }
    public ResultSet search_name_n_des(String tableName, String value_o_row) {
    	checkConnection();
    	Statement stmt = null;
    	ResultSet rs = null;
    	try {
        	stmt = c.createStatement();
			rs = stmt.executeQuery("SELECT "
									+ "ID"
									+ " FROM " 
									+ "\"" + tableName + "\"" 
									+ " WHERE " 
									+ "NAME" 
									+ " LIKE "
									+ "\"%" + value_o_row
									+"%\""
									+ " OR "
									+ "Description" 
									+ " LIKE "
									+ "\"%" + value_o_row
									+"%\""
									+ ";");
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
    	return rs;
    }
}
