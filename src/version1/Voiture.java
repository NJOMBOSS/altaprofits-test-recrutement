package version1;

import java.util.UUID;

public class Voiture implements Vehicule {
    private final String id;

    public Voiture(){
        this.id= UUID.randomUUID().toString();

    }
    @Override
    public String getType() {
        return "Voiture";
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void deplace() {
        System.out.println("La voiture roule");
    }
}
