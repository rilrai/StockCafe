package stockcafe;

/**
 *
 * @author CuCbKu
 * 
 * The class needed for creating a list of menu positions. Method Ordered 
 * starts the NorOrdered methods in all OTHER MenuPositions from the list.
 * 
 * The math logic of this project is just an exapmle - 
 * for real Cafe it should be reviewed.
 * 
 */
public class MenuPosition {

    private String name;
    private String kind;
    private final int FOOD_ID;
    private int baseCost;
    private int count;
    private int currentCost;
    private int i = 0;

    public MenuPosition(String name, String type, int baseCost, int food_id) {
        this.name = name;
        this.kind = type;
        this.baseCost = baseCost;
        this.FOOD_ID = food_id;
    }

    public void NotOrdered(){
        this.count++;
        this.currentCost = baseCost/count;
    }
    
    public void Ordered(int k){
        if (this.count > 0) {
            this.count = 0;
            this.currentCost = this.baseCost;
        } else {
            this.count-=3;
            this.currentCost = this.baseCost * (this.count/-2);
        }
        
        for (int i = 0; i<StockCafe.menuPositions.size(); i++) {
            if (i!=k) {
                StockCafe.menuPositions.get(i).NotOrdered();
            }
        }
    }

    public int getFOOD_ID() {
        return FOOD_ID;
    }
        
    public String getName() {
        return name;
    }

    public String getKind() {
        return kind;
    }

    public int getBaseCost() {
        return baseCost;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCurrentCost() {
        return currentCost;
    }

    public void setCurrentCost(int currentCost) {
        this.currentCost = currentCost;
    }

    @Override
    public String toString() {
        return this.FOOD_ID + " " + this.name + " " + this.kind + " " + this.baseCost;
    }
}
