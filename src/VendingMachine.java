public class VendingMachine {

    public int[][] items = new int[4][4];
    public boolean isBroken;

    public VendingMachine(){
        isBroken = false;
        items = Operator.fillMachine();
    }
}
