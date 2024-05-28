package version1;

public class VehiculeFactory {
    public static Vehicule createVehicule(String type){
        switch (type.toLowerCase()){
            case "avion":
                return new Avion();
            case "helicopter":
                return new Helicoptere();
            case "bateau":
                return new Bateau();
            case "jetski":
                return new JetSki();
            case "voiture":
                return new Voiture();
            case "moto":
                return new Moto();
            default:
                throw new IllegalArgumentException("Le véhicule de type " + type + ", est inconnu");
        }
    }
}
