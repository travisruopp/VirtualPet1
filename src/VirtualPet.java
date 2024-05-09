import java.util.*;

/**
 * A class that models how a virtual pet object will be made
 */

public class VirtualPet {
    private String petName;
    private int hungerLevel;
    private int thirstLevel;
    private int boredomLevel;
    private int currentHealthPoints;
    private int maxHealthPoints;
    private int maxLevels;

    Random random = new Random();

    /**
     * Default Constructor
     */
    protected VirtualPet() {
        this.petName = "Jax";
        this.hungerLevel = 50;
        this.thirstLevel = 50;
        this.boredomLevel = 50;
        this.currentHealthPoints = 100;
        this.maxHealthPoints = 100;
        this.maxLevels = 100;
    }

    /**
     * Parameterized Constructor
     * 
     * @param petName
     */
    protected VirtualPet(String petName) {
        this.petName = petName;
        this.hungerLevel = random.nextInt(70);
        this.thirstLevel = random.nextInt(70);
        this.boredomLevel = random.nextInt(70);
        this.currentHealthPoints = 100 - random.nextInt(50);
        this.maxHealthPoints = 100;
        this.maxLevels = 100;
    }

    /**
     * Method that returns the pet's name
     * 
     * @return string pet name
     */
    protected String getPetName() {
        return this.petName;
    }

    /**
     * Method that returns the current hunger level
     * 
     * @return number of hunger level
     */
    protected int getHungerLevel() {
        return this.hungerLevel;
    }

    /**
     * Method that returns the current thirst level
     * 
     * @return number of thirst level
     */
    protected int getThirstLevel() {
        return this.thirstLevel;
    }

    /**
     * Method that returns the current boredom level
     * 
     * @return number of boredom level
     */
    protected int getBoredomLevel() {
        return this.boredomLevel;
    }

    /**
     * Method that returns the current health points of the pet
     * 
     * @return number of health points
     */
    protected int getCurrentHealthPoints() {
        return this.currentHealthPoints;
    }

    /**
     * Method that returns the max health points of the pet
     * 
     * @return max number of health points
     */
    protected int getMaxHealthPoints() {
        return this.maxHealthPoints;
    }

    /**
     * Method that returns the max level thirst, boredom, or hunger can hit
     * 
     * @return max number of
     */
    protected int getMaxLevels() {
        return this.maxLevels;
    }

    /**
     * Method that sets the hunger level of the pet
     * 
     * @param hungerLevel number you want to set the hunger level to
     */
    protected void setHungerLevel(int hungerLevel) {
        this.hungerLevel = hungerLevel;
    }

    /**
     * Method that sets the thirst level of the pet
     * 
     * @param thirstLevel number you want to set the thirst level to
     */
    protected void setThirstLevel(int thirstLevel) {
        this.thirstLevel = thirstLevel;
    }

    /**
     * Method that sets the boredom level of the pet
     * 
     * @param boredomLevel number you want to set the boredom level to
     */
    protected void setBoredomLevel(int boredomLevel) {
        this.boredomLevel = boredomLevel;
    }

    /**
     * Method that sets the health points of the pet
     * 
     * @param currentHealthPoints number you want to set the health points to
     */
    protected void setCurrentHealthPoints(int currentHealthPoints) {
        this.currentHealthPoints = currentHealthPoints;
    }

    /**
     * Method that sets the max health points of the pet
     * 
     * @param maxHealthPoints number you want to set the max health points to
     */
    protected void setMaxHealthPoints(int maxHealthPoints) {
        this.maxHealthPoints = maxHealthPoints;
    }

    /**
     * Method that sets the max level thirst, hunger, and boredom can be at for the
     * pet
     * 
     * @param maxLevels the number you want to set the max level of thirst, hunger,
     *                  or boredom at
     */
    protected void setMaxLevels(int maxLevels) {
        this.maxLevels = maxLevels;
    }

    /**
     * Method to set the current hunger level to the max hunger level
     */
    protected void setHungerLevelToMax() {
        this.hungerLevel = this.maxLevels;
    }

    /**
     * Method to set the current thirst level to the max thirst level
     */
    protected void setThirstLevelToMax() {
        this.thirstLevel = this.maxLevels;
    }

    /**
     * Method to set the current boredom level to the max boredom level
     */
    protected void setBoredomLevelToMax() {
        this.boredomLevel = this.maxLevels;
    }

    /**
     * Method to set the current health points to the max health points
     */
    protected void setCurrentHealthToMax() {
        this.currentHealthPoints = this.maxHealthPoints;
    }

    /**
     * Method that decreases hunger level in the pet object
     */
    protected void petFeed() {
        this.hungerLevel -= 30;
        if (this.hungerLevel < 0) {
            this.hungerLevel = 0;
        }
    }

    /**
     * Method that decreases thirst level in the pet object
     */
    protected void petWater() {
        this.thirstLevel -= 30;
        if (this.thirstLevel < 0) {
            this.thirstLevel = 0;
        }
    }

    /**
     * Method that decreases boredom level in the pet object
     */
    protected void petPlay() {
        this.boredomLevel -= 30;
        if (this.boredomLevel < 0) {
            this.boredomLevel = 0;
        }
    }

    /**
     * Method that increases thirst,hunger,and boredom levels.
     * Also tracks turns as cycles, applies damage, and checks for the death
     */
    protected void tick(int multiplier) {
        this.hungerLevel += multiplier;
        if (isMaxHunger()) {
            setHungerLevelToMax();
        }
        thirstLevel += multiplier;
        if (isMaxThirst()) {
            setThirstLevelToMax();
        }
        this.boredomLevel += multiplier;
        if (isMaxBoredom()) {
            setBoredomLevelToMax();
        }
        damage();
        healCheck();
    }

    /**
     * Method to check if hunger,thirst, and boredom are in adoptable range. If so
     * the pet is healed.
     */
    protected void healCheck() {
        if (this.hungerLevel < 41 && this.thirstLevel < 41 && this.boredomLevel < 51) {
            this.currentHealthPoints += 5;
            if (isMaxHealth()) {
                setCurrentHealthToMax();
            }
        }
    }

    /**
     * Method to return if the pet has reached max hunger
     * 
     * @return true if hunger level is at or above max
     */
    protected boolean isMaxHunger() {
        if (this.hungerLevel >= this.maxLevels) {
            return true;
        }
        return false;
    }

    /**
     * Method to return if the pet has reached max thirst
     * 
     * @return true if thirst level is at or above max
     */
    protected boolean isMaxThirst() {
        if (this.thirstLevel >= this.maxLevels) {
            return true;
        }
        return false;
    }

    /**
     * Method to return if the pet has reached max boredom
     * 
     * @return true if boredom level is at or above max
     */
    protected boolean isMaxBoredom() {
        if (this.boredomLevel >= this.maxLevels) {
            return true;
        }
        return false;
    }

    /**
     * Method to return if the pet has reached max boredom
     * 
     * @return true if boredom level is at or above max
     */
    protected boolean isMaxHealth() {
        if (this.currentHealthPoints >= this.maxHealthPoints) {
            return true;
        }
        return false;
    }

    /**
     * Method to return if the pet has reached max hunger
     * 
     * @return true if hunger level is below 0
     */
    protected boolean isMinHunger() {
        if (this.hungerLevel < 0) {
            return true;
        }
        return false;
    }

    /**
     * Method to return if the pet has reached min thirst
     * 
     * @return true if thirst level is below 0
     */
    protected boolean isMinThirst() {
        if (this.thirstLevel < 0) {
            return true;
        }
        return false;
    }

    /**
     * Method to return if the pet has reached max boredom
     * 
     * @return true if boredom level is below 0
     */
    protected boolean isMinBoredom() {
        if (this.boredomLevel < 0) {
            return true;
        }
        return false;
    }

    /**
     * Method that deals 10 damage if the pet is at or above max Hunger, Thirst, or
     * Boredom
     */
    protected void damage() {
        if (isMaxHunger()) {
            this.currentHealthPoints -= 10;
        }
        if (isMaxThirst()) {
            this.currentHealthPoints -= 10;
        }
        if (isMaxBoredom()) {
            this.currentHealthPoints -= 10;
        }
    }

    /**
     * Method to return if the pet is adoptable based on health, hunger, thirst, and
     * boredom
     * 
     * @return returns true if all levels meet base requirements
     */
    protected boolean isAdoptable() {
        if (this.currentHealthPoints > 69 && this.hungerLevel < 41 && this.thirstLevel < 41 && this.boredomLevel < 51) {
            return true;
        }
        return false;
    }

    /**
     * Method to return if the pet has died based on current health points
     * 
     * @return returns true if the current health points has fallen below zero.
     */
    protected boolean isDead() {

        if (this.currentHealthPoints < 1) {
            return true;
        }
        return false;
    }

    /**
     * Override method for toString
     */
    @Override
    public String toString() {
        return "VirtualPet [petName=" + petName + ", hungerLevel=" + hungerLevel + ", thirstLevel=" + thirstLevel
                + ", boredomLevel=" + boredomLevel + ", currentHealthPoints=" + currentHealthPoints
                + ", maxHealthPoints=" + maxHealthPoints + ", maxLevels=" + maxLevels + ", random=" + random + "]";
    }
}