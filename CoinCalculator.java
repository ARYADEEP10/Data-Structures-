//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.sql.SQLOutput;
import java.util.Scanner;
public class CoinCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Getting the input from the user
        System.out.print("Enter the amount in dollars and cents");
        double amount= scanner.nextDouble();

        //We convert the amount in cents for easier calculations
        int totalCents = (int)(amount*100);

        //Now we calculate the quarters
        int totalQuarters = totalCents/25;
        int remainingCentsAfterQuarters = totalCents%25;

        //Next is dimes
        int totalDimes = remainingCentsAfterQuarters/10;
        int remainingCentsAfterDimes = remainingCentsAfterQuarters%10;

        //Now we calculate the rest of nickels
        int totalNickels = remainingCentsAfterDimes/5;

        //New feature - Calculates the total pennies
        int totalPennies = remainingCentsAfterDimes%5;

        System.out.println(totalQuarters+" Quarters " + totalDimes+" Dimes " + totalNickels+" Nickels " + totalPennies+" Pennies ");

        scanner.close();







        }
    }
