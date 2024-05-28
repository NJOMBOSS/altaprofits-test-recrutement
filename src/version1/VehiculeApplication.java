package version1;

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


    }
}
