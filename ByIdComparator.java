package stockcafe;

import java.util.Comparator;

/**
 *
 * @author CuCbKu
 * 
 * This Comparator sorts menu positions in list by food_id.
 * Is needed for correct work of DataBaseCompareThread
 *  after MenuPositionComparator is used.
 */
 
public class ByIdComparator implements Comparator<MenuPosition> {

    @Override
    public int compare(MenuPosition mp1, MenuPosition mp2) {
        if (mp1.getFOOD_ID() < mp2.getFOOD_ID())
            return -1;
        else if (mp1.getFOOD_ID() == mp2.getFOOD_ID())
            return 0;
        else
            return 1;
    }
    
}
