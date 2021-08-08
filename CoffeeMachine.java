
import java.util.*;
public class CoffeeMachine {
    public static int coffeeCups;
    public static final int milk = 50;
    public static final int water = 200;
    public static final int coffeeBeans = 15;
    public static int CMAmount = 550;
    public static int CMWater = 400;
    public static int CMMilk = 540;
    public static int CMBeans = 120;
    public static int CMCups = 9;


    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

         Menu();
    }
    public static void claculateCoffee(){

        System.out.println("Write how many cups of coffee you will need:");
        Scanner sc = new Scanner(System.in);
        coffeeCups = sc.nextInt();
        System.out.println("For "+coffeeCups+" cups of coffee you will need:");
        System.out.println(water*coffeeCups+" ml of water");
        System.out.println(milk*coffeeCups+" ml of milk");
        System.out.println(coffeeBeans*coffeeCups+" g of coffee beans");
    }
    public static void coffeeSufficient(){
        int count = 0;
        System.out.println("Write how many ml of water the coffee machine has:");
        int waterInCM = sc.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milkInCM = sc.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int BeansInCM = sc.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cups = sc.nextInt();
        while(waterInCM >= water && milkInCM >= milk && BeansInCM >= coffeeBeans) {
            count++;
            waterInCM=waterInCM-water;
            milkInCM=milkInCM-milk;
            BeansInCM=BeansInCM-coffeeBeans;
        }
        if (cups <= count && cups+cups <= count) {
            System.out.println("Yes, I can make that amount of coffee (and even "+(count-cups)+" more than that)");
        } else if (cups <= count) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (cups > count) {
            System.out.println("No, I can make only "+count+" cup(s) of coffee");
        }
    }
    public static void Menu(){
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String choice = sc.next();


             switch (choice) {
                 case "buy":
                     Buy();
                     Menu();
                     break;
                 case "fill":
                     Fill();
                     Menu();
                     break;
                 case "take":
                     Take();
                     Menu();
                     break;
                 case "remaining" :
                     Remaining();
                     Menu();
                     break;
                 case "exit" :break;
                 default:
                     System.out.println("Enter valid choice");
             }



    }
    public static void Buy(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String choice = sc.next();
        if(choice == "back"){
            Menu();
            return;
        }

        switch (choice) {
            case "back" : break;
            case "1" : espresso();
            break;
            case "2" : latte();
            break;
            case "3" : cappuccino();
            break;
            default :
                System.out.println("Enter valid choice");
        }


    }
    public static void espresso() {
        int ewater = 250;
        int ebeans = 16;
        int ecost = 4;

        if (ewater > CMWater) {
            System.out.println("Sorry, not enough water!");
        }else if (ebeans > CMBeans) {
            System.out.println("Sorry, not enough CoffeeBeans!");
        }else {
            CMWater = CMWater - ewater;
            CMBeans = CMBeans - ebeans;
            CMAmount = CMAmount + ecost;
            CMCups--;
            System.out.println("I have enough resources, making you a coffee!");
        }

    }
    public static void latte() {
        int lwater = 350;
        int lbeans = 20;
        int lcost = 7;
        int lMilk= 75;
        if (lwater > CMWater) {
            System.out.println("Sorry, not enough water!");
        } else if (lbeans > CMBeans) {
            System.out.println("Sorry, not enough CoffeeBeans!");
        } else if (lMilk > CMMilk) {
            System.out.println("Sorry, not enough Milk!");
        } else {
            CMWater = CMWater - lwater;
            CMMilk = CMMilk - lMilk;
            CMBeans = CMBeans - lbeans;
            CMAmount = CMAmount + lcost;
            CMCups--;
            System.out.println("I have enough resources, making you a coffee!");
        }


    }
    public static void cappuccino() {
        int cwater = 200;
        int cbeans = 12;
        int ccost = 6;
        int cMilk= 100;
        if (cwater > CMWater) {
            System.out.println("Sorry, not enough water!");
        } else if (cbeans > CMBeans) {
            System.out.println("Sorry, not enough CoffeeBeans!");
        } else if (cMilk > CMMilk) {
            System.out.println("Sorry, not enough Milk!");
        } else {
            CMWater = CMWater - cwater;
            CMMilk = CMMilk - cMilk;
            CMBeans = CMBeans - cbeans;
            CMAmount = CMAmount + ccost;
            CMCups--;
            System.out.println("I have enough resources, making you a coffee!");
        }


    }
    public static void Fill(){
        System.out.println("Write how many ml of water you want to add:");
        int FillWater = sc.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        int FillMilk = sc.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        int FillBeans = sc.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        int Fillcups = sc.nextInt();

        CMWater = CMWater + FillWater;
        CMMilk = CMMilk + FillMilk;
        CMBeans = CMBeans + FillBeans;
        CMCups = CMCups + Fillcups;


    }
    public static void Take(){
        System.out.println("I gave you $"+CMAmount);
        CMAmount=0;


    }
    public static void Remaining(){

        CMHas();

    }
    public static void CMHas() {
        System.out.println("The coffee machine has:");
        System.out.println(CMWater+" ml of water");
        System.out.println(CMMilk+" ml of milk");
        System.out.println(CMBeans+" g of coffee beans");
        System.out.println(CMCups+" disposable cups");
        System.out.println("$"+CMAmount+" of money");
    }

}
