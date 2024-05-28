package version1;

import java.util.ArrayList;
import java.util.List;

public class Ferme {
    // Déclaration d'une liste d'animaux
    private List<Animal> animals;

    // Constructeur de la classe Ferme
    public Ferme() {
        // Initialisation de la liste d'animaux en tant qu'une ArrayList vide
        animals = new ArrayList<>();
    }

    // Méthode pour ajouter un animal à la liste de la ferme
    public void addAnimal(Animal animal) {
        // Ajoute l'animal à la liste
        animals.add(animal);
    }

    // Méthode pour obtenir la liste des animaux de la ferme
    public List<Animal> getAnimals() {
        // Retourne la liste d'animaux
        return animals;
    }
}