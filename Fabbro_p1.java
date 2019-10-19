import java.util.Scanner;
import java.security.SecureRandom;

public class Fabbro_p1 {
    //We use a void since we aren't returning any value(s)
    public static void negativeResponses(int negCase){
        String negative;
        switch (negCase) {
            case 1:
                negative = "No. Please try again.";
                break;
            case 2:
                negative = "Wrong. Try once more.";
                break;
            case 3:
                negative = "Don’t give up!";
                break;
            case 4:
                negative = "No. Keep trying.";
                break;
            default:
                negative = "Incorrect";
                break;
        }
        System.out.println(negative);
    }

    //We use a void since we aren't returning any value(s)
    public static void positiveResponses(int posCase){
        String positive;
        switch (posCase) {
            case 1:
                positive = "Very good!";
                break;
            case 2:
                positive = "Excellent!";
                break;
            case 3:
                positive = "Nice work!";
                break;
            case 4:
                positive = "Keep up the good work!";
                break;
            default:
                positive = "Correct";
                break;
        }
        System.out.println(positive);
    }

    //We use a return type here so that we can return the random number
    public static int randomNumbers(int level){
        //Create a scanner
        SecureRandom rand = new SecureRandom();

        //Declare variables
        int randomNum;

        //The level determines how many digits will be in the random number
        if (level == 1){
            randomNum = rand.nextInt(10);
        }
        else if (level==2){
            randomNum = rand.nextInt(90)+10;
        }
        else if (level==3){
            randomNum = rand.nextInt(900)+100;
        }
        else {
            randomNum = rand.nextInt(9000)+1000;
        }
        return randomNum;
    }

    //We use a return type here so we can add up the number of correct answers
    public static int question(double num1, double num2, int type){
        //Create a scanner and random number generator
        Scanner scn = new Scanner(System.in);
        SecureRandom rnd = new SecureRandom();

        //Declare variables
        int neg;
        int pos;
        double answer;
        double userAnswer;

        //The type decides what kind of math question will be asked
        if (type == 1){
            System.out.println("How much is " + num1 + " plus " + num2 + "?");
            answer = num1 + num2;
        }
        else if (type == 2){
            System.out.println("How much is " + num1 + " times " + num2 + "?");
            answer = num1 * num2;
        }
        else if (type == 3){
            System.out.println("How much is " + num1 + " minus " + num2 + "?");
            answer = num1 - num2;
        }
        else {
            System.out.println("How much is " + num1 + " divided by " + num2 + "?");
            if (num1 == 0||num2 == 0){
                System.out.println("Cannot divide by zero");
                answer = 0;
                userAnswer = 0;
            }
            answer = num1 / num2;
        }

        //Depending on whether or not the answer is correct, there will be a positive or negative response
        userAnswer = scn.nextInt();
        if (answer!=userAnswer) {
            neg = rnd.nextInt(4) + 1;
            negativeResponses(neg);
            return 0;
        }
        else {
            pos = rnd.nextInt(4) + 1;
            positiveResponses(pos);
            return 1;
        }
    }

    public static void main(String[] args){
        char response = 'y';
        while (response =='y') {
            //Create a scanner for main
            Scanner scn = new Scanner(System.in);

            //Declare variables
            int difficulty;
            int questionType;
            int i;
            int randInt1;
            int randInt2;
            int numCorrect = 0;
            int percent = numCorrect * 10;

            //Ask the user what level of difficulty they would like
            System.out.println("What level of difficulty would you like? (Please select a level 1-4)");
            difficulty = scn.nextInt();
            while (difficulty>4||difficulty<1){
                System.out.println("What level of difficulty would you like? (Please select a level 1-4)");
                difficulty = scn.nextInt();
            }

            //Ask the user what types of questions they would like
            System.out.println("What types of problems would you like? (Please select level 1-5)");
            questionType = scn.nextInt();
            while (questionType>5||questionType<1){
                System.out.println("What types of problems would you like? (Please select level 1-5)");
                questionType = scn.nextInt();
            }

            //Get the initial random numbers
            randInt1 = randomNumbers(difficulty);
            randInt2 = randomNumbers(difficulty);


            //For loop to run the program 10 times
            for (i = 0; i < 10; i++) {
                if (questionType != 5) {
                    if (question(randInt1, randInt2, questionType) == 1) {
                        numCorrect++;
                    }
                }
                else {
                    //Since 5 is any of the previous types, we will get a random number for which type of problem
                    SecureRandom rand = new SecureRandom();
                    int randomType = rand.nextInt(3)+1;
                    if (question(randInt1, randInt2, randomType) == 1) {
                        numCorrect++;
                    }
                }
                //Assign new random numbers for the next problem
                randInt1 = randomNumbers(difficulty);
                randInt2 = randomNumbers(difficulty);
            }
            System.out.println("");

            //Print the number of correct and incorrect responses
            System.out.println("You got " + numCorrect + " questions correct.");
            System.out.println("You got " + (10 - numCorrect) + " questions incorrect.");
            System.out.println("");

            //Calculate the percentage correct
            if (percent < 75) {
                System.out.println("Please ask your teacher for extra help.");
            } else {
                System.out.println("Congratulations, you are ready to go to the next level!");
            }

            //Ask user if they would like to start a new session
            System.out.println("");
            System.out.println("Would you like to start a new session? (Type \'y\' for yes and \'n\' for no.)");
            response = scn.next().charAt(0);
        }
    }
}
