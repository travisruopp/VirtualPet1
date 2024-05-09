import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class VirtualPetShelterTest {

    VirtualPetShelter testVirtualPetShelter = new VirtualPetShelter();
    VirtualPet testPet = new VirtualPet();

    @Test
    void testAddPet() {
        testVirtualPetShelter.addPet(testPet);
        int size = testVirtualPetShelter.getShelterArray().size();
        assertEquals(size,1);
    }

    @Test
    void testFeedAllPets() {
        testVirtualPetShelter.addPet(testPet);
        int initialHunger = testPet.getHungerLevel();
        testVirtualPetShelter.feedAllPets();
        assertEquals(initialHunger-30,testPet.getHungerLevel());
    }

    @Test
    void testPlayAllPets() {
        testVirtualPetShelter.addPet(testPet);
        int initialBoredom = testPet.getBoredomLevel();
        testVirtualPetShelter.playAllPets();
        assertEquals(initialBoredom-30,testPet.getBoredomLevel());
    }

    @Test
    void testRemovePet() {
        testVirtualPetShelter.addPet(testPet);
        testVirtualPetShelter.removePet(testPet);
        int size = testVirtualPetShelter.getShelterArray().size();
        assertEquals(size,0);
    }

    @Test
    void testWaterAllPets() {
        testVirtualPetShelter.addPet(testPet);
        int initialThirst = testPet.getThirstLevel();
        testVirtualPetShelter.waterAllPets();
        assertEquals(initialThirst-30,testPet.getThirstLevel());
    }
}
