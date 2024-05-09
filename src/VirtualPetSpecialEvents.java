import java.util.Random;

/**
 * A class that models how random events will occur and what they do
 */
public class VirtualPetSpecialEvents {

    private static int[] d20 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
    private static int[] d6 = { 1, 2, 3, 4, 5, 6 };
    VirtualPetSpecialEvents specialEvents = new VirtualPetSpecialEvents();
    static Keyboard keys = new Keyboard();

    /**
     * Method that pulls a random event from an list of 20 cases. That randomizes
     * the game to allow replayability.
     * 
     * @param pet the pet object to allow the events to effect certain statistics
     * 
     * @return gives back the now modified pet object based off the special event
     */
    protected static VirtualPetShelter eventRoll(VirtualPetShelter pets) {
        VirtualPet pet = pets.getShelterArray().get(new Random().nextInt(pets.getShelterArray().size()));
        int rollValue = d20[new Random().nextInt(d20.length)];
        switch (rollValue) {
            case 1: // Makes pet run away sends program to pet escaped method
                System.out.println(pet.getPetName() + " got away from you. You begin to look for your pet. ");
                VirtualPetSpecialEvents.petEscapedEvent(pet);
                return pets;
            case 2: // pet takes 10 damage
                System.out.println(pet.getPetName() + " ran into a tree. They took 10 damage. ");
                pet.setCurrentHealthPoints(pet.getCurrentHealthPoints() - 10);
                return pets;
            case 3: // pet gains 20 thirst
                System.out.println(
                        pet.getPetName() + " knocked over their bowl before they got a drink. Gain 20 Thirst. ");
                pet.setThirstLevel(pet.getThirstLevel() + 20);
                if (pet.isMaxThirst()) {
                    pet.setThirstLevelToMax();
                }
                return pets;
            case 4: // pet gains 20 hunger
                System.out.println(pet.getPetName() + " threw up. Gain 20 Hunger. ");
                pet.setHungerLevel(pet.getHungerLevel() + 20);
                if (pet.isMaxHunger()) {
                    pet.setHungerLevelToMax();
                }
                return pets;
            case 5: // pet gains 20 boredom
                System.out.println(pet.getPetName() + " ate a bunch of candy. Gain 20 Boredom. ");
                pet.setBoredomLevel(pet.getBoredomLevel() + 20);
                if (pet.isMaxThirst()) {
                    pet.setBoredomLevelToMax();
                }
                return pets;
            case 6: // pet gains 10 thirst
                System.out.println(pet.getPetName() + " peed on the floor. Gain 10 Thirst. ");
                pet.setThirstLevel(pet.getThirstLevel() + 10);
                if (pet.isMaxThirst()) {
                    pet.setThirstLevelToMax();
                }
                return pets;
            case 7: // pet gains 10 hunger
                System.out.println(pet.getPetName() + " pooped on the floor. Gain 10 Hunger. ");
                pet.setHungerLevel(pet.getHungerLevel() + 10);
                if (pet.isMaxHunger()) {
                    pet.setHungerLevelToMax();
                }
                return pets;
            case 8: // pet gains 10 boredom
                System.out.println(pet.getPetName() + " broke a toy. Gain 10 Boredom. ");
                pet.setBoredomLevel(pet.getBoredomLevel() + 10);
                if (pet.isMaxBoredom()) {
                    pet.setBoredomLevelToMax();
                }
                return pets;
            case 9: // new pet found
                pets.addPetPrompt("A random pet wandered into your shelter. Please give it a name: ");
                return pets;
            case 10: // new pet found
               pets.addPetPrompt("A pet was dropped off at the shelter. Please give it a name: ");
                return pets;
            case 11: // pet does nothing
                System.out.println("Your pet " + pet.getPetName() + " gave you a hug. ");
                return pets;
            case 12: // pet loses 20 boredom
                System.out.println(pet.getPetName() + " is chasing their tail. Lose 20 Boredom. ");
                pet.setBoredomLevel(pet.getBoredomLevel() - 20);
                if (pet.isMinBoredom()) {
                    pet.setBoredomLevel(0);
                }
                return pets;
            case 13: // pet loses 20 hunger
                System.out.println(pet.getPetName() + " found a bug to munch on. Lose 20 Hunger. ");
                pet.setHungerLevel(pet.getHungerLevel() - 20);
                if (pet.isMinHunger()) {
                    pet.setHungerLevel(0);
                }
                return pets;
            case 14: // pet loses 20 thirst
                System.out.println(pet.getPetName() + " found a puddle of water. Lose 20 Thirst. ");
                pet.setThirstLevel(pet.getThirstLevel() - 20);
                if (pet.isMinThirst()) {
                    pet.setThirstLevel(0);
                }
                return pets;
            case 15: // pet loses 30 boredom
                System.out.println(pet.getPetName() + " found a new friend pet to play with. Lose 30 Boredom. ");
                pet.setBoredomLevel(pet.getBoredomLevel() - 30);
                if (pet.isMinBoredom()) {
                    pet.setBoredomLevel(0);
                }
                return pets;
            case 16: // pet loses 30 hunger
                System.out.println(pet.getPetName() + " got a free meal with a coupon. Lose 30 Hunger. ");
                pet.setHungerLevel(pet.getHungerLevel() - 30);
                if (pet.isMinHunger()) {
                    pet.setHungerLevel(0);
                }
                return pets;
            case 17: // pet loses 30 thirst
                System.out.println(pet.getPetName() + " found a super soda. Lose 30 Thirst. ");
                pet.setThirstLevel(pet.getThirstLevel() - 30);
                if (pet.isMinThirst()) {
                    pet.setThirstLevel(0);
                }
                return pets;
            case 18: // All pets play together
                for(VirtualPet petLoop: pets.getShelterArray()){
                    System.out.print(petLoop.getPetName() + " ");
                    petLoop.setBoredomLevel(petLoop.getBoredomLevel()-10);
                }
                System.out.println("are playing together. Lose 10 boredom each!");
                return pets;
            case 19: // pet gains 10 health
                System.out.println(pet.getPetName() + " ate a random mushroom on the ground. They gain 10 health. ");
                pet.setCurrentHealthPoints(pet.getCurrentHealthPoints() + 10);
                if (pet.isMaxHealth()) {
                    pet.setCurrentHealthToMax();
                }
                return pets;
            case 20: // pet gains 10 health and 10 max health
                System.out
                        .println(pet.getPetName() + " found a magical puddle. They gain 10 health and 10 max health. ");
                pet.setCurrentHealthPoints(pet.getCurrentHealthPoints() + 10);
                pet.setMaxHealthPoints(pet.getMaxHealthPoints() + 10);
                pet.setCurrentHealthPoints(pet.getCurrentHealthPoints() + 10);
                if (pet.isMaxHealth()) {
                    pet.setCurrentHealthToMax();
                }
                return pets;
            default:
                System.out.println(pet.getPetName() + " thanks you for keeping it alive. ");
                return pets;
        }
    }

    /**
     * Method that extends case 1 in the special event method. That allows even more
     * variability for the user.
     * 
     * @param pet the pet object to allow the events to effect certain statistics
     */
    protected static void petEscapedEvent(VirtualPet pet) {
        int rollValue = d6[new Random().nextInt(d6.length)];
        switch (rollValue) {
            case 1: // pet dies and game is over
                System.out.println(pet.getPetName() + " has been lost. ");
                pet.setCurrentHealthPoints(0);
                pet.isDead();
                break;
            case 2: // pet loses 10 from max thrist, hunger, and boredom
                System.out.println(
                    pet.getPetName() + " ate a old pill. Max hunger, thirst, and boredom level is reduced. ");
                pet.setMaxLevels(pet.getMaxLevels() - 10);
                break;
            case 3: // pet loses 10 health
                System.out.println(pet.getPetName() + " got a cut while they were lost. They lost 10 health. ");
                pet.setCurrentHealthPoints(pet.getCurrentHealthPoints() - 10);
                break;
            case 4: // pet loses 20 health
                System.out.println(pet.getPetName() + " broke a leg while they were lost. They lost 20 health. ");
                pet.setCurrentHealthPoints(pet.getCurrentHealthPoints() - 20);
                break;
            case 5: // does nothing
                System.out.println(pet.getPetName() + " came home. ");
                break;
            case 6: // pet gains 10 max health
                System.out.println(
                        pet.getPetName() + " you found your pet and it appears they have a new collar. + 10 Max HP. ");
                pet.setCurrentHealthPoints(pet.getCurrentHealthPoints() + 10);
                pet.setMaxHealthPoints(pet.getMaxHealthPoints() + 10);
                if (pet.isMaxHealth()) {
                    pet.setCurrentHealthToMax();
                }
                break;
            default:
                System.out.println(pet.getPetName() + " thanks you for keeping it alive. ");
                break;
        }
    }

    /**
     * Method that checks the cycle count to see if its a multiple of three to let
     * the game know
     * 
     * @param pet the pet object to allow cycle counting
     * 
     * @return
     */
    protected static void eventCheck(VirtualPetShelter pets) {
        int remainder = VirtualPetShelter.getSpecialEventCounter() % 13;
        int totalCount = VirtualPetShelter.getSpecialEventCounter();
        VirtualPetShelter.setSpecialEventCounter(remainder);
        int eventsToRun = ((totalCount - remainder)/13);
        for (int i = 0; i<eventsToRun; i++){
            eventRoll(pets);
        }
    }

    /**
     * Override method for toString
     */
    @Override
    public String toString() {
        return "VirtualPetSpecialEvents [specialEvents=" + specialEvents + "]";
    }
}
