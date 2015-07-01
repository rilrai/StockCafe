package stockcafe;

import com.mysql.jdbc.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CuCbKu
 * 
 * Main class of the project.
 * Starts threads, creates collection, etc.
 * 
 */
 
public class StockCafe {
    public static List<MenuPosition> menuPositions = new ArrayList<>();
    public static InfoOutThread infoOut = new InfoOutThread();
    public static DatabaseCompareThread compare = new DatabaseCompareThread();
    
    public static void main(String[] args) {
        
        String query = "SELECT position, kind, cost, food_id FROM menu";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection connection = (Connection) DriverManager.getConnection
                    (Constants.URL, Constants.USERNAME, Constants.PASSWORD);
            Statement statement = (Statement) connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                MenuPosition mp = new MenuPosition(rs.getString("position"),
                                    rs.getString("kind"), rs.getInt("cost"),
                                    rs.getInt("food_id"));
                menuPositions.add(mp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        System.out.println(menuPositions);
        
        compare.start();
        
    }
}
