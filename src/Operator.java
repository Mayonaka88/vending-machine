public class Operator {

    public Operator(){
    }

    public static int[][] fillMachine(){
        int[][] refill = new int[4][4];
        for (int i = 0; i < refill.length; ++i) {
            for(int j = 0; j < refill[i].length; ++j) {
                refill[i][j] = 10;
            }
        }
        System.out.print("The Operator filled the machine!"+"\n"+"\n");
        return refill;
    }

    public static boolean fixMachine(boolean isBroken){
        if(isBroken == true){
            System.out.print("\n"+"The Operator fixed the machine!"+"\n");
            return false; 
        }
        else{
            System.out.print("\n"+"The machine isnt broken! no need for fixing!"+"\n");
            return false; 
        }
    }
}
