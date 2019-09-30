package com.company;

import java.util.Scanner;
import java.util.Scanner;

public class Machine {

    int totalMoney;
    int totalCoffee;
    int totalMilk;
    int totalCups;
    int totalWater;

    public Machine(int totalWater, int totalMilk, int totalCoffee, int totalCups, int totalMoney){
        this.totalWater= totalWater;
        this.totalCoffee = totalCoffee;
        this.totalMilk = totalMilk;
        this.totalCups = totalCups;
        this.totalMoney = totalMoney;
    }

    private void machineState(){
        System.out.println("The coffee machine has:");
        System.out.println( totalWater + " of water");
        System.out.println(totalMilk + " of milk");
        System.out.println( totalCoffee + " of coffee beans");
        System.out.println( totalCups + " of disposable cups");
        System.out.println(totalMoney + " of money");
    }
    private void take(){
        System.out.println("I gave you $" + totalMoney);
        totalMoney = 0;
    }

    private void fillWater(int plusWater){
        totalWater = totalWater + plusWater;
    }

    private void fillMilk(int plusMilk){
        totalMilk = totalMilk + plusMilk;
    }
 private void fillCoffee(int plusCoffee){
        totalCoffee = totalCoffee + plusCoffee;
    }

    private void fillCups(int plusCup){
        totalCups = totalCups + plusCup;
    }

    private void buy(String typeCoffee) {
        boolean latte;
        boolean cappuccino;
        boolean espresso;

        espresso = totalWater >= 250 && totalCoffee >= 16 && totalCups >= 1 && typeCoffee.equals("1");
        latte = totalWater >= 350 && totalCoffee >= 20 && totalMilk >= 75 && totalCups >= 1 && typeCoffee.equals("2");
        cappuccino = totalWater >= 200 && totalCoffee >= 12 && totalMilk >= 100 && totalCups >= 1 && typeCoffee.equals("3");

        if (typeCoffee.equals("1") && totalWater < 250 || typeCoffee.equals("2") && totalWater < 350 || typeCoffee.equals("3") && totalWater < 200) {
            System.out.println("Sorry, not enough water!");
        }
        else if (typeCoffee.equals("1") && totalCoffee < 16 || typeCoffee.equals("2")  && totalCoffee < 20 || typeCoffee.equals("3") && totalCoffee < 12) {
            System.out.println("Sorry, not enough coffee beans");
        }
        else if(typeCoffee.equals("1") || typeCoffee.equals("2") || typeCoffee.equals("3")  && totalCups < 1){
            System.out.println("Sorry, not enough coffee cups");
        }

        if (cappuccino || latte || espresso) {
            System.out.println("I have enough resources, making you a coffee!");
        }

        if (espresso) {
            totalWater = totalWater - 250;
            totalCoffee = totalCoffee - 16;
            totalMoney = totalMoney + 4;
            totalCups = totalCups - 1;
        }

        else if (latte){
            totalWater = totalWater - 350;
            totalMilk = totalMilk - 75;
            totalCoffee = totalCoffee - 20;
            totalMoney = totalMoney + 7;
            totalCups = totalCups - 1;

        }
        else if(cappuccino) {
            totalWater = totalWater - 200;
            totalMilk = totalMilk - 100;
            totalCoffee = totalCoffee - 12;
            totalMoney = totalMoney + 6;
            totalCups = totalCups - 1;
        }
    }
    /*
        initial values
        int totalMoney = 550;
        int totalCoffee = 120;
        int totalMilk = 540;
        int totalCups = 9;
        int totalWater = 400;
     */
    public  static void main(String[] args) {
        String typeCoffee;
        String action;
        int plusWater;
        int plusMilk;
        int plusCoffee;
        int plusCups;
        Scanner s = new Scanner(System.in);

        Machine c = new Machine(400, 540, 120, 9, 550);

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            action = s.nextLine();

            if(action.equals("remaining")){
                c.machineState();
            }
            
            if(action.equals("exit")){
                break;
            }
            if (action.equals("buy")){
                System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                typeCoffee = s.nextLine();
                c.buy(typeCoffee);
            }
            if (action.equals("fill")) {
                System.out.print("Write how many ml of water do you want to add:");
                plusWater = s.nextInt();
                c.fillWater(plusWater);
                System.out.print("Write how many ml of milk do you want to add: ");
                plusMilk = s.nextInt();
                c.fillMilk(plusMilk);
                System.out.print("Write how many grams of coffee beans do you want to add: ");
                plusCoffee = s.nextInt();
                c.fillCoffee(plusCoffee);
                System.out.print("Write how many disposable cups of coffee do you want to add: ");
                plusCups = s.nextInt();
                c.fillCups(plusCups);
            }
            if (action.equals("take")){
                c.take();
            }
        }
    }
}
