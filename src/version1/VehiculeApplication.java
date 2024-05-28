package version1;

import java.util.ArrayList;
import java.util.List;

public class VehiculeApplication {
    public static void main(String[] args) {
        Hangar hangar = Hangar.getInstance();

        hangar.addVehicule(VehiculeFactory.createVehicule("Avion"));
        hangar.addVehicule(VehiculeFactory.createVehicule("Helicopter"));
        hangar.addVehicule(VehiculeFactory.createVehicule("Bateau"));
        hangar.addVehicule(VehiculeFactory.createVehicule("JetSki"));
        hangar.addVehicule(VehiculeFactory.createVehicule("Voiture"));
        hangar.addVehicule(VehiculeFactory.createVehicule("Moto"));

        // Affichages des informations requises en console
        System.out.println("Total véhicule: " + hangar.getTotalVehicules());
        System.out.println("Nombre de sections d’aéroport: " + hangar.getAirportSectionCount());
        System.out.println("Nombre de sections de port: " + hangar.getPortSectionCount());
        System.out.println("Nombre de sections de garage " + hangar.getGarageSectionCount());

        System.out.println("--------------------------------------------------------");
        hangar.printVehicules();

        // Save the vehicle list to a file
        hangar.saveVehiculesToFile("vehicules.txt");


        Ferme ferme = new Ferme();
        ferme.addAnimal(new Oiseau());
        ferme.addAnimal(new AquatiqueAnimal());

        System.out.println("--------------------------------------------------------");
        // Recenser les entités capables de voler
        List<Deplacer> voles = new ArrayList<>();
        voles.addAll(hangar.getFlyables());
        voles.addAll(ferme.getAnimals().stream().filter(a -> a instanceof Oiseau).toList());

        System.out.println("Entités capables de voler:");
        voles.forEach(f -> {
            System.out.println(f.getClass().getSimpleName() + " with ID: " + ((f instanceof Vehicule) ? ((Vehicule) f).getId() : ((Animal) f).getId()));
            f.deplace();
        });

        System.out.println("--------------------------------------------------------");
        // Recenser les entités capables de rouler
        List<Deplacer> roules = hangar.getDrivables();

        System.out.println("Entités capables de conduire:");
        roules.forEach(d -> {
            System.out.println(d.getClass().getSimpleName() + " with ID: " + ((Vehicule) d).getId());
            d.deplace();
        });

        System.out.println("--------------------------------------------------------");
        // Recenser les entités capables de naviguer
        List<Deplacer> flottes = new ArrayList<>();
        flottes.addAll(hangar.getNavigables());
        flottes.addAll(ferme.getAnimals().stream().filter(a -> a instanceof AquatiqueAnimal).toList());

        System.out.println("Entities capable de navigating:");
        flottes.forEach(n -> {
            System.out.println(n.getClass().getSimpleName() + " with ID: " + ((n instanceof Vehicule) ? ((Vehicule) n).getId() : ((Animal) n).getId()));
            n.deplace();
        });
    }
}
