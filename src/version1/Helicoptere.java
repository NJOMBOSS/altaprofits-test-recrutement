package version1;

import java.util.UUID;

public class Helicoptere implements Vehicule {
    private final String id;

    public Helicoptere(){
        this.id= UUID.randomUUID().toString();
    }
    @Override
    public String getType() {
        return "Helicoptere";
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void deplace() {
        System.out.println("L'hélicoptère vole");
    }
}
