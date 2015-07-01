package stockcafe;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CuCbKu
 * 
 * This thread reads changes from database every 5 minutes and when the amount
 * of changes reaches 5 starts InfoOutThread.
 */
public class DatabaseCompareThread extends Thread {
    private int k = 0;
    private int count = 0;

    @Override
    public void run() {
        while (true) {
            String query = "SELECT food_id FROM orders WHERE ordered > NOW()-300";
            
            Collections.sort(StockCafe.menuPositions, new ByIdComparator());

            try {
                Class.forName("com.mysql.jdbc.Driver");

                Connection connection = (Connection) DriverManager.getConnection
                        (Constants.URL, Constants.USERNAME, Constants.PASSWORD);
                Statement statement = (Statement) connection.createStatement();
                ResultSet rs = statement.executeQuery(query);

                while (rs.next()) {
                    k = rs.getInt("food_id")-1;
                    StockCafe.menuPositions.get(k).Ordered(k);
                    count ++;
                    
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            
            if (count > 5) {
                StockCafe.infoOut.start();
                count = 0;
            }
            
            try {
                Thread.sleep(600000);
            } catch (InterruptedException ex) {
                Logger.getLogger(DatabaseCompareThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
        
}
