package stockcafe;

import java.util.Collections;

/**
 *
 * @author CuCbKu
 */
public class InfoOutThread extends Thread {

    @Override
    public void run() {
        Collections.sort(StockCafe.menuPositions, new MenuPositionComparator());
        
        for (int i = 0; i < 5; i++) {
            System.out.println(StockCafe.menuPositions.get(i).getName() + " " + 
                    StockCafe.menuPositions.get(i).getCurrentCost());
        }
    }
    
}
