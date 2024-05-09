import java.util.*;
/**
 * Class to model the shelter for all the virtual pets
 */
public class VirtualPetShelter {
    private static int petDeath = 0;
    private static int petsAdopted = 0;
    private static int specialEventCounter = 0;
    private static int addedPetTracker = 0;
    private ArrayList <VirtualPet> shelterArray = new ArrayList<>();

    Keyboard keys = new Keyboard();

    /**
     * Class Constructor
     */
    protected VirtualPetShelter(){
    }

    /**
     * Method to get the shelter (Array List of Virtual Pets)
     * 
     * @return the array of Virtual Pets
     */
    protected ArrayList<VirtualPet> getShelterArray() {
        return shelterArray;
    }

    /**
     * Method to get the number of pet deaths
     * 
     * @return number of pet deaths
     */
    protected static int getPetDeath(){
        return petDeath;
    }

    /**
     * Method to get the number of pets that have been adopted out
     * 
     * @return
     */
    protected static int getPetsAdopted(){
        return petsAdopted;
    }

    /**
     * Method to get the number that represents the special event counter 
     * 
     * @return special event counter
     */
    public static int getSpecialEventCounter() {
        return specialEventCounter;
    }

    
    public static void setSpecialEventCounter(int specialEventCounter) {
        VirtualPetShelter.specialEventCounter = specialEventCounter;
    }

    /**
     * Method that calculates the number of adoptable pets
     * 
     * @return number of adoptable pets
     */
    protected int getNumberOfAdoptablePets(){
        int number= 0;
        for (VirtualPet pet : shelterArray){
            if (pet.isAdoptable()){
                number++;
            }
        }
        return number;
    }

    /**
     * Method to add a Virtual pet to the shelter (Array of Virtual Pets)
     * 
     * @param addedPet The object(Virtual Pet) to add to the array (Shelter)
     */
    protected void addPet(VirtualPet addedPet){
        this.shelterArray.add(addedPet);
    }

    /**
     * Method to remove a Virtual pet from the shelter (Array of Virtual Pets)
     * 
     * @param removePet The object (Virtual Pet) to remove from the array (Shelter)
     */
    protected void removePet(VirtualPet removePet){
        this.shelterArray.remove(removePet);
    }

    /**
     * Method to feed all pets in the shelter(Array of Virtual pets)
     */
    protected void feedAllPets(){
        for (VirtualPet pet : shelterArray){
            pet.petFeed();
        }
    }

    /**
     * Method to water all pets in the shelter(Array of Virtual pets)
     */
    protected void waterAllPets(){
        for (VirtualPet pet : shelterArray){
            pet.petWater();
        }
    }

    /**
     * Method to play with all pets in the shelter(Array of Virtual pets)
     */
    protected void playAllPets(){
        for (VirtualPet pet : shelterArray){
            pet.petPlay();
        }
    }

    /**
     * Method to track the number of pets that are saved
     */
    protected static void addPetAdopted(){
        petsAdopted++;
    }

    /**
     * Method to check if the game should end based on pet deaths
     * 
     * @return if the game is over
     */
    protected boolean isGameOver(){
        if (petDeath >2 ) {
            return true;
        }
        return false;
    }

    /**
     * Method to apply the tick to all pets and check for death
     * 
     * @param multiplier number to increase hunger,thirst, and boredom by
     * @param petShelter array list of pets
     */
    protected void tickAllPets(int multiplier, VirtualPetShelter petShelter){
        specialEventCounter += multiplier;
        for (int i = 0; i<petShelter.getShelterArray().size(); i++){
            VirtualPet pet = petShelter.getShelterArray().get(i);
            pet.tick(multiplier);
            if (pet.isDead()){
                petDeath++;
                GameUI.petDeath(pet);
                removePet(pet);
                i--;
                if (petShelter.getShelterArray().size() <1){
                    break;
                }
            }
        }
        addPetTimer(calculatePetsToAdd());
        if(petShelter.getShelterArray().size() > 0){
            VirtualPetSpecialEvents.eventCheck(petShelter);
            for (int i = 0; i<petShelter.getShelterArray().size(); i++){
                VirtualPet pet = petShelter.getShelterArray().get(i);
                if (pet.isDead()){
                    petDeath++;
                    GameUI.petDeath(pet);
                    removePet(pet);
                    i--;
                    if (petShelter.getShelterArray().size() <1){
                        break;
                    }
                }
            }
        }
    }

    /**
     * Method to calculate how many pets to force add to the shelter
     * 
     * @return Number of pets to add
     */
    private int calculatePetsToAdd(){
        int addedPetTrackerRemainder = specialEventCounter % 15;
        int petsToAdd = (specialEventCounter - addedPetTrackerRemainder - addedPetTracker)/15;
        return petsToAdd;
    }

    /**
     * Method to add pets to the shelter.
     * 
     * @param petsToAdd number of pets to add
     */
    protected void addPetTimer(int petsToAdd){
        calculatePetsToAdd();
        addedPetTracker = addedPetTracker + (petsToAdd*15);
        for (int i =0; i<petsToAdd; i++){
            addPetPrompt("A pet appeared in your shelter. Give it a name: ");
        }
    }

    /**
     * Method to add a pet to the shelter with a prompt.
     * 
     * @param prompt String to prompt the user with
     */
    protected void addPetPrompt(String prompt){
        String name = keys.getString(prompt);
        name = name.substring(0, Math.min(name.length(), 10));
        VirtualPet userPet = new VirtualPet(name);
        addPet(userPet);
    }

    /**
     * Override method for toString 
     */
    @Override
    public String toString() {
        return "VirtualPetShelter [shelterArray=" + shelterArray + ", keys=" + keys + "]";
    }
}
