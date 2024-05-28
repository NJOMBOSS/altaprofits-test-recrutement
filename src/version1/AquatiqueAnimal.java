package version1;

import java.util.UUID;

public class AquatiqueAnimal implements Animal{
    private final String id;

    public AquatiqueAnimal() {
        this.id = UUID.randomUUID().toString();
    }
    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getType() {
        return  "AquatiqueAnimal";
    }

    @Override
    public void deplace() {
        System.out.println("L’animal aquatique nage.");
    }
}

