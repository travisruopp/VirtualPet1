import java.util.*;

/**
 * A class that models how the game will start, continue running, and end
 */
public class GameLoop {
    GameUI newUI = new GameUI();
    Keyboard keys = new Keyboard();
    VirtualPetShelter petShelter = new VirtualPetShelter();

    /**
     * Method that starts the game and keeps the user in the game loop until they
     * quit or lose.
     */
    protected void startGame() {
        System.out.println("Welcome to Pet Shelter the Game!");
        newUI.wait(1000);
        startTutorial();
        System.out.println("Your shelter will have 3 pets to start with.");
        petShelter.addPetPrompt("What would you like to name your first pet? ");
        petShelter.addPetPrompt("What would you like to name your second pet? ");
        petShelter.addPetPrompt("What would you like to name your third pet? ");
        boolean quit = false;
        while (!quit && !petShelter.isGameOver()) { // As long as the pet is alive and the user hasn't quit the loop
                                                    // continues
            newUI.statsDisplay(petShelter);
            newUI.livesRemainingDisplay(VirtualPetShelter.getPetDeath());
            newUI.petsSavedDisplay(VirtualPetShelter.getPetsAdopted());
            newUI.wait(1000);
            newUI.userMainMenu();
            int number = keys.getInteger("Please enter a number input from the following options: ", "123456");
            switch (number) {
                case 1: // Feed the virtual pet
                    feedPetsCase();
                    break;
                case 2: // Give the virtual pet water
                    waterPetsCase();
                    break;
                case 3: // Play with your virtual pet
                    playPetsCase();
                    break;
                case 4: // adopt a pet away
                    if (petShelter.getNumberOfAdoptablePets() <= 0) {
                        System.out.println("********No adoptable pets at this time********");
                        newUI.wait(1000);
                        break;
                    }
                    adoptPetCase();
                    break;
                case 5: // add a new pet
                    addPetCase();
                    break;
                case 6: // Quit the game
                    quit = true;
                    break;
                default:
                    break;
            }
        }
        if (quit == true) {
            newUI.quit();
        } else {
            GameUI.gameOverDisplay();
        }
    }

    /**
     * Method to start the tutorial if the user wants to
     */
    private void startTutorial() {
        String tutorial = keys.getString("Would you like to view the tutorial? Y/N ", "yn");
        if (tutorial.equalsIgnoreCase("y")) {
            newUI.playerTutorial();
            keys.getString("Type Y when done with tutorial ", "y");
        }
    }

    /**
     * Method to give feed pet options
     */
    private void feedPetsCase() {
        newUI.userPetSelectMenuWithAll(petShelter);
        int tempCountFeed = (petShelter.getShelterArray().size()) + 2; // +1 added to move index 1 up and +1 more for
                                                                       // all option
        int tempNumberFeed = keys.getIntegerIntValidation(
                "Which pet would you like to feed? Or select 1 to feed all pets ", tempCountFeed);
        if (tempNumberFeed == 1) {
            petShelter.tickAllPets(9, petShelter);
            petShelter.feedAllPets();
        } else {
            VirtualPet tempPet = petShelter.getShelterArray().get(tempNumberFeed - 2);
            petShelter.tickAllPets(4, petShelter);
            tempPet.petFeed();
        }
        newUI.wait(1000);
    }

    /**
     * Method to give water pet options
     */
    private void waterPetsCase() {
        newUI.userPetSelectMenuWithAll(petShelter);
        int tempCountWater = petShelter.getShelterArray().size() + 2; // +1 added to move index 1 up and +1 more for all
                                                                      // option
        int tempNumberWater = keys.getIntegerIntValidation(
                "Which pet would you like to give water? Or select 1 to give water all pets ", tempCountWater);
        if (tempNumberWater == 1) {
            petShelter.tickAllPets(9, petShelter);
            petShelter.waterAllPets();
        } else {
            VirtualPet tempPet = petShelter.getShelterArray().get(tempNumberWater - 2);
            petShelter.tickAllPets(4, petShelter);
            tempPet.petWater();
        }
        newUI.wait(1000);
    }

    /**
     * Method to play with pet options
     */
    private void playPetsCase() {
        newUI.userPetSelectMenuWithAll(petShelter);
        int tempCountPlay = petShelter.getShelterArray().size() + 2; // +1 added to move index 1 up and +1 more for all
                                                                     // option
        int tempNumberPlay = keys.getIntegerIntValidation(
                "Which pet would you like to play with? Or select 1 to play with all pets ", tempCountPlay);
        if (tempNumberPlay == 1) {
            petShelter.tickAllPets(9, petShelter);
            petShelter.playAllPets();
        } else {
            VirtualPet tempPet = petShelter.getShelterArray().get(tempNumberPlay - 2);
            petShelter.tickAllPets(4, petShelter);
            tempPet.petPlay();
        }
        newUI.wait(1000);
    }

    /**
     * Method to adopt out a pet
     */
    private void adoptPetCase() {
        Map<Integer, VirtualPet> tempAdoptMap = newUI.adoptablePetSelectMenu(petShelter);
        int tempNumberAdopt = keys.getIntegerIntValidation("Which pet would you like to adopt away to a good home? ",
            petShelter.getNumberOfAdoptablePets());
        VirtualPetShelter.addPetAdopted();
        petShelter.removePet(tempAdoptMap.get(tempNumberAdopt));
        petShelter.tickAllPets(7, petShelter);
    }

    /**
     * Method to add a pet to the shelter
     */
    private void addPetCase() {
        petShelter.addPetPrompt("What would you like to name your pet? ");
        for (VirtualPet petHeal : petShelter.getShelterArray()) {
            petHeal.setCurrentHealthPoints(petHeal.getCurrentHealthPoints() + 5);
            if (petHeal.isMaxHealth()) {
                petHeal.setCurrentHealthToMax();
            }
        }
    }

    /**
     * Override method for toString
     */
    @Override
    public String toString() {
        return "GameLoop [newUI=" + newUI + ", keys=" + keys + ", petShelter=" + petShelter + "]";
    }
}