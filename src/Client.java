public class Client {
    public int balance;
    public boolean isAngry;
    public Client(int money, boolean angry){
        balance = money;
        isAngry = angry;
    }
    public static boolean kickMachine(){
        System.out.print("\n"+"You kicked the machine!"+"\n");
        return true;
    }
    public void subtractMoney(int amount){
        balance = balance - amount;
    }
}
