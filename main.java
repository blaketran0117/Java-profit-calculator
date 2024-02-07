import java.util.Scanner;
import java.util.Random;



public class main{
	public static void main(String[] args) {
	
// 	Initializing the scanner object and random
    Scanner scnnr = new Scanner(System.in);
    Random rand = new Random();
    int option, numberOfPlant ;
    double totalCost;
    double chosenVegPrice= 0;
    double chosenVegSell= 0;
    String chosenVeg = " ";
    
// 	Creating constant variables to hold the selling price and asking price information :
    final double cornBuyPrice = 2.56 ;
    final double tomatoBuyPrice =4.0;
    final double potatoBuyPrice =2.33;
    final double brocoliBuyPrice =4.99;
    
    String space = " ";

    final double cornSellPrice = 4.56;
    final double tomatoSellPrice = 6.0;
    final double potatoSellPrice = 4.33;
    final double brocoliSellPrice = 6.99;
		

// Displaying the price and vegetables to purchase :
    System.out.println("Current Selling Prices: \n");
    System.out.printf("Corn %6s $%.2f \n",space,cornSellPrice);
    System.out.printf("Tomato %4s $%.2f \n",space,tomatoSellPrice);
    System.out.printf("Potato %4s $%.2f \n",space,potatoSellPrice);
    System.out.printf("Brocoli %3s $%.2f \n\n",space,brocoliSellPrice);
        
// Showing aunt Donna what the menu:

    System.out.println("Please choose a vegetable and note the cost to buy: \n");
    System.out.printf("1. Corn %6s $%.2f \n",space,cornBuyPrice);
    System.out.printf("2. Tomato %4s $%.2f \n",space,tomatoBuyPrice);
    System.out.printf("3. Potato %4s $%.2f \n",space,potatoBuyPrice);
    System.out.printf("4. Brocoli %3s $%.2f \n",space,brocoliBuyPrice);
    
// Asking aunt Donna what she wants to buy:
    option =scnnr.nextInt();
    
// Validate the user input to be between 1-4:
    switch(option){
        case(1):
            System.out.println("How many corn do you want to purchase ?");
            chosenVegPrice = cornBuyPrice;
            chosenVegSell= cornSellPrice;
            chosenVeg = "corn";
            break;
        case(2):
            System.out.println("How many tomato do you want to purchase ?");
            chosenVegPrice= tomatoBuyPrice;
            chosenVegSell= tomatoSellPrice;
            chosenVeg = "tomato";
            break;
        case(3):
            System.out.println("How many potato do you want to purchase ?");
            chosenVegPrice = potatoBuyPrice;
            chosenVegSell= potatoSellPrice;
            chosenVeg = "potato";
            break;
        case(4):
            System.out.println("How many brocoli do you want to purchase ?");
            chosenVegPrice= brocoliBuyPrice;
            chosenVegSell=brocoliSellPrice;
            chosenVeg = "brocoli";
            break;
        default:
            System.out.printf("%d is not a valid option, please input a valid value between 1-4",option);
            break;
    }
    numberOfPlant = scnnr.nextInt();
    if(!(numberOfPlant > 1)){
        System.out.println("You can't buy fewer than one plant.Setting your number of plant to 1");
        numberOfPlant = 1;
    } 
    totalCost = numberOfPlant * chosenVegPrice;
    System.out.printf("You spent $%.2f purchasing %d %s \n",totalCost,numberOfPlant,chosenVeg);
    
// Calculate random number and make sure the upperlimit doesn't exceed the amount of crops we purchased
    int plantDestroyed = rand.nextInt(numberOfPlant);
// Testing variable to make sure the last condition is correct
    // double plantDestroyed = numberOfPlant / 30.0 * 100.0;
    int plantSurvived = numberOfPlant - plantDestroyed;
    double profit;
    profit = (plantSurvived * chosenVegSell) - totalCost;
    String weatherCondition;
    
    if(plantSurvived == numberOfPlant){
        weatherCondition = "Perfect Weather Condition";
        System.out.printf("%s %d of your %s plants survived \n",weatherCondition,plantDestroyed,chosenVeg);
        System.out.printf("After selling your remaining %d plants for %.2f, you made a profit of $%.2f \n",plantSurvived,chosenVegSell,profit);
    }
    if(plantSurvived < plantDestroyed) {
        weatherCondition = "Extreme Weather Condition";
        
        System.out.printf("%s have destroyed %s of your %s plants \n",weatherCondition,plantDestroyed,chosenVeg);
        
        if (profit > 0){
            System.out.printf("After selling your remaining %s plants for %.2f, you made a profit $%.2f \n,",plantSurvived,chosenVegSell,profit);
        } else{
            System.out.printf("After selling your remaining %s plants for %.2f, you incur a lost of $%.2f\n",plantSurvived,chosenVegSell,Math.abs(profit));
        }
            
        }
    if(plantSurvived > plantDestroyed){
        weatherCondition ="Mediocre Weather Condition";
        System.out.printf("%s have destroyed %d of your %s plants \n",weatherCondition,plantDestroyed,chosenVeg);
        if (profit > 0){
            System.out.printf("After selling your remaining %d plants for %.2f, you made a profit of $%.2f \n",plantSurvived,chosenVegSell,profit);
        } else{
            System.out.printf("After selling your remaining %d plants for %.2f, you incur a lost of $%.2f \n",plantSurvived,chosenVegSell,Math.abs(profit));
        }
    }
    
// Define what account for 30% of the crop being destroyed 
    double thirtyPercent = numberOfPlant / 30.0 * 100.00 ;
    
// If profit is positive and the amout of plants destroyed is greater than 30% print the statement below
    if (profit > 0 && plantDestroyed >= thirtyPercent){
        System.out.println("You made a profit, but you lost a good percentage of the plants you worked hard to plant");
    }
    }
}
