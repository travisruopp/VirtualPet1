import java.util.*;

/**
 * A class that models how and what the games user interface will appear
 */
public class GameUI {

    /**
     * Method to display a basic tutorial to the player
     */
    protected void playerTutorial() {
        System.out.println("");
        System.out.println("This guide will assist you in playing the game.");
        System.out.println("");
        wait(1000);
        System.out.println("Here are the important stats you will need to know");
        System.out.println("");
        wait(2000);
        System.out
                .println("If a pet's health reaches zero it will die. You can only have 3 pets die before game over!");
        System.out.println("");
        wait(2500);
        System.out.println(
                "A pets Hunger, Thirst, and Boredom level will increase at steady intervals. To combat this\r\n" + //
                        "you will need to feed, give water, and play with your pets.\r\n" + //
                        "When you do one of the above actions you will be allowed to pick one pet or all of them.\r\n" + //
                        "It is important to note that picking one or all pets will differently effect how much the hunger, thirst, and boredom increase.");
        System.out.println("");
        wait(4500);
        System.out.println("There will be random events that occur that effect pets in positive and negative ways");
        System.out.println("");
        wait(2000);
        System.out.println("The goal is to adopt out as many pets as you can before you lose!");
        System.out.println("");
        wait(2000);
        System.out.println(
                "You can add another pet to the shelter at anytime without any negative effects. There might even be a positive effect to added a pet.");
        System.out.println("");
        wait(2500);
        System.out.println("I hope you enjoy playing and good luck!");
        System.out.println("");
        wait(2000);
    }

    /**
     * A method to display the pet statistic
     */
    protected void statsDisplay(VirtualPetShelter petShelter) {

        System.out.printf("------------------------------------------------------------%n");
        System.out.printf("|                   Pets in the Shelter                    |%n");
        System.out.printf("------------------------------------------------------------%n");
        System.out.printf("| %-10s | %6s | %6s | %6s | %6s | %7s |%n", "Name", "Health", "MaxHP", "Hunger", "Thirst",
                "Boredom");
        System.out.printf("------------------------------------------------------------%n");
        for (VirtualPet pet : petShelter.getShelterArray()) {
            System.out.printf("| %-10s | %6d | %6d | %6d | %6d | %7d |%n", pet.getPetName(),
                    pet.getCurrentHealthPoints(), pet.getMaxHealthPoints(), pet.getHungerLevel(), pet.getThirstLevel(),
                    pet.getBoredomLevel());
        }
        System.out.printf("------------------------------------------------------------%n");

    }

    /**
     * A method to display the options for the user to select to interact with the
     * pet
     */
    protected void userMainMenu() {

        System.out.println(" ");
        System.out.println("  1. Feed pets");
        System.out.println("  2. Give pets Water");
        System.out.println("  3. Play with pets");
        System.out.println("  4. Adopt a pet away");
        System.out.println("  5. Add a new pet");
        System.out.println("  6. I GIVE UP!!!");
    }

    /**
     * Method to display pets to be chosen from and includes a selection option for
     * all pets
     * 
     * @param petShelter All the pets in the shelter
     */
    protected void userPetSelectMenuWithAll(VirtualPetShelter petShelter) {
        System.out.println("  1. All Pets");
        for (int i = 0; i < petShelter.getShelterArray().size(); i++) {
            System.out.println("  " + (i + 2) + ". " + petShelter.getShelterArray().get(i).getPetName());
        }
    }

    /**
     * Method to display pets to be chosen from
     * 
     * @param petShelter All the pets in the shelter
     */
    protected void userPetSelectMenu(VirtualPetShelter petShelter) {
        for (int i = 0; i < petShelter.getShelterArray().size(); i++) {
            System.out.println("  " + (i + 1) + ". " + petShelter.getShelterArray().get(i).getPetName());
        }
    }

    /**
     * Method to display pets to be chosen from to adopt out if they are adoptable
     * 
     * @param petShelter All the pets in the shelter
     */
    protected Map<Integer, VirtualPet> adoptablePetSelectMenu(VirtualPetShelter petShelter) {
        Map<Integer, VirtualPet> adoptMap = new HashMap<>();
        int listCount = 1;
        for (int i = 0; i < petShelter.getShelterArray().size(); i++) {
            if (petShelter.getShelterArray().get(i).isAdoptable()) {
                System.out.println("  " + listCount + ". " + petShelter.getShelterArray().get(i).getPetName());
                adoptMap.put(listCount, petShelter.getShelterArray().get(i));
                listCount++;
            }
        }
        return adoptMap;
    }

    /**
     * Method to display the lives the player has remaining based on pets lost
     * 
     * @param petDeath number of pets killed
     */
    protected void livesRemainingDisplay(int petDeath) {
        System.out.printf("|                    Lives Remaining: %d                    |%n", (3 - petDeath));
        System.out.printf("------------------------------------------------------------%n");
    }

    /**
     * Method to display the number of pets a player has adopted out
     * 
     * @param petsSaved
     */
    protected void petsSavedDisplay(int petsAdopted) {
        System.out.printf("|                    Pets Adopted Out: %d                   |%n", (petsAdopted));
        System.out.printf("------------------------------------------------------------%n");
    }

    /**
     * Method to display the quit screen message
     */
    protected void quit() {
        System.out.println("YOU ABANDONED ALL THOSE FAKE PETS!!!");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("For shame!");
    }

    /**
     * Method to display the death screen
     * 
     * @param pet input of the object pet to allow for a name print out and cycle
     *            print out.
     */
    protected static void petDeath(VirtualPet pet) {
        System.out.println("           ______\r\n" + //
                "        .-\"      \"-.\r\n" + //
                "       /            \\\r\n" + //
                "      |              |\r\n" + //
                "      |,  .-.  .-.  ,|\r\n" + //
                "      | )(__/  \\__)( |\r\n" + //
                "      |/     /\\     \\|\r\n" + //
                "      (_     ^^     _)\r\n" + //
                "       \\__|IIIIII|__/\r\n" + //
                "        | \\IIIIII/ |\r\n" + //
                "        \\          /\r\n" + //
                "         `--------`");
        System.out.println(
                pet.getPetName() + " has died. You have " + (3 - VirtualPetShelter.getPetDeath()) + " lives left.");
    }

    /**
     * Method to add a delay in the system print out to allow user to read UI
     * messages.
     * 
     * @param ms integer to dictate how many milliseconds to wait.
     */
    protected void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Method to display the Game Over Screen
     */
    protected static void gameOverDisplay() {
        System.out.println("You have lost your last life!");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("You saved " + VirtualPetShelter.getPetsAdopted() + "pets!");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("Thank you for playing I hope you had fun.");
    }

    /**
     * Override method for toString
     */
    @Override
    public String toString() {
        return "GameUI []";
    }
}
