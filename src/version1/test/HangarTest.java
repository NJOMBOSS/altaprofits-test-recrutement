package version1.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import version1.*;

import java.io.ByteArrayOutputStream;

import java.io.PrintStream;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HangarTest {
    private Hangar hangar;

    // Capturer la sortie standard pour les tests
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        // Réinitialiser l'instance avant chaque test
        Hangar.resetInstance();
        // Rediriger System.out vers outputStreamCaptor
        System.setOut(new PrintStream(outputStreamCaptor));
    }


    // Test pour la méthode getInstance()
    @Test
    void testGetInstance() {
        Hangar instance1 = Hangar.getInstance();
        Hangar instance2 = Hangar.getInstance();
        assertSame(instance1, instance2, "getInstance doit renvoyer la même instance");
    }

    // Test pour la méthode addVehicle()
    @Test
    void testAddVehicule() {
        Hangar hangar = Hangar.getInstance();
        Vehicule vehicule = new Voiture();

        hangar.addVehicule(vehicule);
        List<Vehicule> vehicules = hangar.getVehicules();

        assertTrue(vehicules.contains(vehicule), "Le véhicule doit être ajouté au hangar");
    }

    // Test pour la méthode getTotalVehicules()
    @Test
    void testGetTotalVehicules() {
        Hangar hangar = Hangar.getInstance();

        assertEquals(0, hangar.getTotalVehicules(), "Total vehicles should be 0 initially");

        Vehicule vehicule1 = new Voiture();
        Vehicule vehicule2 = new Voiture();
        Vehicule vehicule3 = new Bateau();

        hangar.addVehicule(vehicule1);
        hangar.addVehicule(vehicule2);
        hangar.addVehicule(vehicule3);

        assertEquals(3, hangar.getTotalVehicules(), "Le nombre total de véhicules devrait être de 3 après avoir ajouté trois véhicules");
    }

    // Test pour la méthode getAirportSectionCount()
    @Test
    void testGetAirportSectionCount() {
        Hangar hangar = Hangar.getInstance();

        assertEquals(0, hangar.getAirportSectionCount(), "Le nombre de sections de l’aéroport doit être de 0 au départ");

        Vehicule voiture = new Voiture();
        Vehicule avion = new Avion();
        Vehicule helicoptere = new Helicoptere();

        hangar.addVehicule(voiture);
        hangar.addVehicule(avion);
        hangar.addVehicule(helicoptere);

        assertEquals(2, hangar.getAirportSectionCount(), "Le nombre de sections d’aéroport doit être de 2 après l’ajout d’un avion et d’un hélicoptère");
    }

    // Test pour la méthode getPortSectionCount()
    @Test
    void testGetPortSectionCount() {
        Hangar hangar = Hangar.getInstance();

        assertEquals(0, hangar.getPortSectionCount(), "Le nombre de sections de port doit être de 0 initialement");

        Vehicule voiture = new Voiture();
        Vehicule bateau = new Bateau();
        Vehicule jetSki = new JetSki();

        hangar.addVehicule(voiture);
        hangar.addVehicule(bateau);
        hangar.addVehicule(jetSki);

        assertEquals(2, hangar.getPortSectionCount(), "Le nombre de sections bateau doit être de 2 après l’ajout d’un bateau et d’un jetSki");
    }

    // Test pour la méthode getGarageSectionCount()
    @Test
    void testGetGarageSectionCount() {
        Hangar hangar = Hangar.getInstance();

        assertEquals(0, hangar.getGarageSectionCount(), "Le nombre de sections de garage doit être de 0 au départ");

        Vehicule voiture = new Voiture();
        Vehicule moto = new Moto();

        hangar.addVehicule(voiture);
        hangar.addVehicule(moto);

        assertEquals(2, hangar.getGarageSectionCount(), "Le nombre de sections de garage doit être de 2 après l’ajout d’une voiture et d’une moto");
    }

    // Test pour la méthode printVehicules()
    @Test
    void testPrintVehicules() {
        Hangar hangar = Hangar.getInstance();

        Vehicule voiture = new Voiture();
        Vehicule moto = new Moto();
        Vehicule avion = new Avion();

        hangar.addVehicule(voiture);
        hangar.addVehicule(moto);
        hangar.addVehicule(avion);

        hangar.printVehicules();

        String expectedOutput = String.join(System.lineSeparator(), "Voiture", "Moto", "Avion");
        String actualOutput = outputStreamCaptor.toString().trim();

        assertEquals(expectedOutput, actualOutput, "La sortie doit lister les types de tous les véhicules dans le hangar");
    }

}