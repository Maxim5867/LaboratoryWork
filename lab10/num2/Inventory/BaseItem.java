package lab10.num2.Inventory;

public abstract class BaseItem implements Item{
    protected int count;

    public BaseItem(int count) {
        if (count < MIN_VALUE || count > MAX_VALUE){
            throw new IllegalArgumentException("Invalid count. Try again");
        }
        this.count = count;
    }

    public int use(){
        if (isUsed()){
            return 0;
        } else {
            return count;
        }
    }

    public boolean isUsed(){
        return count < 1;
    }

    public String toString(){
        return (getClass().getSimpleName() + ", count: : " + count + ", isUsed: " + isUsed());
    }
}
