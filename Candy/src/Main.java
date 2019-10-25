import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int totMon = 6000;
		int adMon = 0; //Money spent on advertising
		int trainMon = 0; //Money spent on training
		int prMon = 0; //Money spent on PR
		int adTot = 50; //Sponsor Happiness
		int prTot = 50; //PR Status
		double winLossRatio = 1; //Win Loss Ratio (Out of 16)
		int season = 1; //Current Season
		boolean redo = false;
		String temp;
		System.out.println("Welcome to your first season as financial manager of the Colorado Hailstorms. We might not be as 'official' as the other teams,");
		System.out.println("but with our new sponsor, we might just be able to make it big! Just make sure our players are advertising thier many delicious");
		System.out.println("chocolate products, and that they're ready to play some football! PR events are also key to making sure everyone loves us! Though");
		System.out.println("if you run us into the ground or they pull their support, you're fired. And if half the rumors I've heard about the Nougat family");
		System.out.println("are true, being out of a job'll be the least of your concerns!");
		System.out.println();
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		while((totMon >= 0 && adTot > 0)||redo) {
			redo = false;
		    System.out.println("You have $"+(totMon)+" at your disposal. How much would you like to spend on advertising your sponsor? (This will increase your Sponsor's Happiness)");
            adMon = myObj.nextInt(); 
            System.out.println("You have $"+(totMon-adMon)+" at your disposal. How much would you like to spend on training your Team? (This will increase the odds of Winning Games throughout the season)");
            trainMon = myObj.nextInt(); 
            System.out.println("You have $"+(totMon-adMon-trainMon)+" at your disposal. How much would you like to spend on advertising your sponsor? (This increases your team's Standing in the eyes of the fans)");
            prMon = myObj.nextInt(); 
            System.out.println("You have spent $"+adMon+" on Advertising, $"+trainMon+" on Training, and $"+prMon+" on PR Campaigns, with a total of $"+(totMon-adMon-trainMon-prMon)+" left over. Input Y if you are sure, and anything else if you'd like to redo your finance allocations.");
            temp = myObj.next();
            
            
            if(temp.equals("Y")||temp.equals("y")) {
            	double training = trainMon/season;
            	winLossRatio = (int)(16*((5000*Math.random()) + (training/1000*season))/5000);
            	if(winLossRatio > 16) {
            		winLossRatio = 16;
            	}
            	
            	prTot += (adMon/(500*season) + (2*winLossRatio-5));
            	
            	adTot += (adMon/(50*season)-(25*season)) + (10*(winLossRatio-8)) + (prTot/4);
            	
            	totMon += totMon - prMon - adMon - trainMon + (100*adTot);
            	
            	System.out.println("Season "+season+" results:");
            	System.out.println("Games Won: "+winLossRatio+ " out of 16");
            	if(winLossRatio == 16) {
            		System.out.println(" Wow!, a perfect season!");
            	} else if(winLossRatio > 7) {
            		System.out.println(" A decent enough season.");
            	} else if(winLossRatio == 0) {
            		System.out.println("...I don't even have words.");
            	} else if(winLossRatio < 8) {
            		System.out.println(" Hopefully you can turn it around next time.");
            	}
            	
            	System.out.println("Overall PR: "+prTot);
            	if(prTot < 25) {
            		System.out.println(" Things aren't looking to good for your team...");
            	}else{
            		System.out.println();
            	}
            	
            	System.out.println("Sponsor Happiness: "+adTot);
            	if(adTot <= 0) {
            		System.out.println("You've failed to live up to your side of the bargain, dear manager. Knuckles'll be around");
            		System.out.println("shortly to show you what happens to those that cross the Nougat family.");
            		break;
            	}else {
            		System.out.println();
            	}
            	
            	System.out.println("Total Finances: "+totMon);
            	if(totMon <= 0) {
            		System.out.println(" Looks like you've run out of funds. Good luck paying off the mob now.");
            		System.out.println("Prepare for RESTART");
            		break;
            	}else {
            		System.out.println();
            	}
            	season++;
            	System.out.println();
            	
            }else{
            	redo = true;
            }
		}
		myObj.close();
	}

}
