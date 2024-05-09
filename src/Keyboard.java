import java.util.*;

/**
 * A class that models how to get and check a user's input
 */
public class Keyboard {
    Scanner input = new Scanner(System.in);

    /**
     * Method that takes in user input based off a prompt and checks it to make sure
     * it is valid. Then coverts it to a integer
     * 
     * @param prompt     a string that will display to the user
     * @param validation a string to check if the users input is allowed
     * 
     * @return an integer converted from a string
     */
    protected int getInteger(String prompt, String validation) {

        int result = 0;
        while (true) {
            System.out.print(prompt);
            String userInput = input.nextLine();
            if (null != userInput && validation.contains(userInput) && userInput.length() > 0) {
                result = Integer.parseInt(userInput);
                break;
            }
        }
        return result;
    }

    /**
     * Method that takes in user input based off a prompt and checks it to make sure
     * it is valid. 
     * 
     * @param prompt     a string that will display to the user
     * @param validation a string to check if the users input is allowed
     * 
     * @return a valid string
     */
    protected String getString(String prompt, String validation) {

        String result;
        while (true) {
            System.out.print(prompt);
            String userInput = input.nextLine();
            userInput = userInput.toLowerCase();
            if (null != userInput && validation.contains(userInput) && userInput.length() > 0) {
                result = userInput;
                break;
            }
        }
        return result;
    }
    /**
     * Method that takes in user input based off a prompt and checks it to make sure
     * it is valid
     * 
     * @param prompt a string that will display to the user
     * 
     * @return the users input as a valid string
     */
    protected String getString(String prompt) {
        String result;
        while (true) {
            System.out.print(prompt);
            String userInput = input.nextLine();
            if (userInput != null && userInput.length() > 0) {
                result = userInput;
                break;
            }
        }
        return result;
    }

    /**
     * Method that takes in user input (required to be a number) based off a prompt and checks to make sure it is valid via integer
     * 
     * @param prompt a string that will display to the user
     * @param count the integer to check the user input against
     * 
     * @return the user input as a valid integer
     */
    protected int getIntegerIntValidation(String prompt, int count) {

        int result = 0;
        while (true) {
            System.out.print(prompt);
            String userInput = input.nextLine();
            try {
                result = Integer.parseInt(userInput);
                if (result>count || result<0){
                    throw new Exception("Invalid Number");
                }
                break;
            } catch (Exception ex) {
                System.out.println("You have entered an invalid choice.");
            }
        }
        return result;
    }

    /**
     * Override method for toString
     */
    @Override
    public String toString() {
        return "Keyboard [input=" + input + "]";
    }

}
