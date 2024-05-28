package version1;

import java.util.UUID;

public class Avion implements Vehicule {
    private final String id;

    public Avion(){
        this.id= UUID.randomUUID().toString();
    }
    @Override
    public String getType() {
        return "Avion";
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void deplace() {
        System.out.println("L'avion vole");
    }
}
