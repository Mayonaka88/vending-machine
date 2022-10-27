import java.util.Scanner;

public class UseCase {
    Scanner input = new Scanner(System.in);
    VendingMachine machine = new VendingMachine();
    boolean isDone = false;
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        VendingMachine machine = new VendingMachine();
        boolean isDone = false;
        System.out.println("How much money do you have?");
        int money = input.nextInt();
        boolean anger = false;

        while(isDone == false){
            System.out.println("\n"+"Are you an angry client? (1 for yes / 0 for no)");
            int isAngry = input.nextInt();
            if(isAngry == 0){
                isDone = true;
                anger = false;
            }
            else if(isAngry == 1){
                isDone = true;
                anger = true;
            }
            else{
                System.out.println("\n"+ "Invalid Input" + "\n");
            }
        }

        Client client = new Client(money, anger);
        
        System.out.print("\n"+"Insert coins into the machine"+"\n");
        int tempCoins = input.nextInt();
        if(tempCoins > client.balance){
            System.out.print("\n"+"You dont have enough money!");
        }
        else{
            buyItem(client, tempCoins, machine, input);
        }



    }

    public static void buyItem(Client client, int tempCoins, VendingMachine machine, Scanner input){
        client.balance = client.balance - tempCoins;
        printItems(machine);
        System.out.print("Which row do you want your item from?"+"\n");
        int row = input.nextInt();
        System.out.print("\n"+"Which column do you want your item from?"+"\n");
        int column = input.nextInt();
        System.out.print("\n"+"You want item "+row+"-"+column+"\n");
        System.out.print("\n"+"Confirm? (1 to confirm / 0 to cancel)"+"\n");
        int userInput = input.nextInt();
        if(userInput == 1){
            if(tempCoins<1){
                System.out.print("\n"+"You dont have enough money!"+"\n");
            }
            else{
                tempCoins = tempCoins - 1;
                client.balance = client.balance + tempCoins;
                machine.items[row-1][column-1] = machine.items[row-1][column-1] - 1;
                if(tempCoins>=1){
                    buyItem(client, tempCoins, machine, input);
                }
            }
        }
        else{
            client.balance = client.balance + tempCoins;
        }
        printItems(machine);
        if(client.isAngry == true){
            machine.isBroken = client.kickMachine();
        }
        machine.isBroken = Operator.fixMachine(machine.isBroken);
        machine.items = Operator.fillMachine();
        printItems(machine);
        System.out.print("\n"+"Thank you for your purchase! Have a nice day!");
        System.exit(0);

    }

    public static void printItems(VendingMachine machine){
        System.out.print("\n");
        for (int i = 0; i < machine.items.length; ++i) {
            for(int j = 0; j < machine.items[i].length; ++j) {
                System.out.print(machine.items[i][j] + "   ");
            }
            System.out.print("\n");
        }

        System.out.print("\n"+"All items are 1$"+"\n");
        
    }
}
