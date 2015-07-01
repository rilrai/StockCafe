package stockcafe;

import java.util.Comparator;

/**
 *
 * @author CuCbKu
 * 
 * Comparator for MenuPositions. It compares the COUNT and Difference
 * in BaseCost and CurrentCost.
 */
public class MenuPositionComparator implements Comparator<MenuPosition>  {

    @Override
    public int compare(MenuPosition mp1, MenuPosition mp2) {
        if (mp1.getCount() < mp2.getCount())
            return 1;
        else if (mp1.getCount() == mp2.getCount()) {
            if ((mp1.getBaseCost()-mp1.getCurrentCost()) > 
                    (mp2.getBaseCost()-mp2.getCurrentCost()))
                return 1;
            else if ((mp1.getBaseCost()-mp1.getCurrentCost()) == 
                    (mp2.getBaseCost()-mp2.getCurrentCost()))
                return 0;
            else
                return -1;
        } else
            return -1;
    }
    
}
