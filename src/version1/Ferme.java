package version1;

import java.util.ArrayList;
import java.util.List;

public class Ferme {
    private List<Animal> animals;

    public Ferme() {
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}

