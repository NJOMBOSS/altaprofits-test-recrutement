package version1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe Hangar gère une collection de véhicules.
 * Utilise le pattern Singleton pour garantir qu'une seule instance de Hangar existe.
 */
public class Hangar {
	// Instance unique de la classe Hangar (singleton)
	private static Hangar instance;

	// Liste des véhicules dans le hangar
	private List<Vehicule> vehicules;

	/**
	 * Initialise la liste des véhicules.
	 */
	public Hangar() {
		vehicules = new ArrayList<>();
	}

	/**
	 * Retourne l'instance unique de Hangar, la créant si nécessaire.
	 * Utilise la synchronisation pour garantir la sécurité en cas d'accès concurrents.
	 *
	 * @return L'instance unique de Hangar.
	 */
	public static synchronized Hangar getInstance() {
		if (instance == null) {
			instance = new Hangar();
		}
		return instance;
	}

	// Méthode pour réinitialiser l'instance pour les tests
	public static void resetInstance() {
		instance = null;
	}

	/**
	 * Ajoute un véhicule à la liste des véhicules du hangar.
	 *
	 * @param vehicule Le véhicule à ajouter.
	 */
	public void addVehicule(Vehicule vehicule) {
		vehicules.add(vehicule);
	}

	public List<Vehicule> getVehicules() {
		return vehicules;
	}


	/**
	 * Retourne le nombre total de véhicules dans le hangar.
	 *
	 * @return Le nombre total de véhicules.
	 */
	public int getTotalVehicules() {
		return vehicules.size();
	}

	/**
	 * Retourne le nombre de véhicules dans la section aéroportuaire.
	 * Les sections aéroportuaires comprennent les avions et les hélicoptères.
	 *
	 * @return Le nombre de véhicules dans la section aéroportuaire.
	 */
	public int getAirportSectionCount() {
		return (int) vehicules.stream()
				.filter(v -> v instanceof Avion || v instanceof Helicoptere)
				.count();
	}

	/**
	 * Retourne le nombre de véhicules dans la section portuaire.
	 * Les sections portuaires comprennent les bateaux et les jet-skis.
	 *
	 * @return Le nombre de véhicules dans la section portuaire.
	 */
	public int getPortSectionCount() {
		return (int) vehicules.stream()
				.filter(v -> v instanceof Bateau || v instanceof JetSki)
				.count();
	}

	/**
	 * Retourne le nombre de véhicules dans la section garage.
	 * Les sections garages comprennent les voitures et les motos.
	 *
	 * @return Le nombre de véhicules dans la section garage.
	 */
	public int getGarageSectionCount() {
		return (int) vehicules.stream()
				.filter(v -> v instanceof Voiture || v instanceof Moto)
				.count();
	}

	/**
	 * Affiche les types de tous les véhicules dans le hangar sur la console.
	 */
	public void printVehicules() {
		vehicules.forEach(v -> System.out.println(v.getType()));
	}

	/**
	 * Sauvegarde les informations et les types de tous les véhicules dans un fichier.
	 *
	 * @param filename Le nom du fichier où sauvegarder les informations et les types de véhicules.
	 */
	public void saveVehiculesToFile(String filename) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
			writer.println("Total véhicule: " + getTotalVehicules());
			writer.println("Nombre de sections d’aéroport: " + getAirportSectionCount());
			writer.println("Nombre de sections de port: " + getPortSectionCount());
			writer.println("Nombre de sections de garage: " + getGarageSectionCount());
			vehicules.forEach(v -> writer.println(v.getType()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
