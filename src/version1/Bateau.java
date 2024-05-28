package version1;

import java.util.UUID;

public class Bateau implements Vehicule {
    private final String id;

    public Bateau(){
        this.id= UUID.randomUUID().toString();
    }
    @Override
    public String getType() {
        return "Bateau";
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void deplace() {
        System.out.println("Le bateau flotte");
    }
}
