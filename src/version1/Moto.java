package version1;

import java.util.UUID;

public class Moto implements Vehicule{
    private final String id;

    public Moto(){
        this.id= UUID.randomUUID().toString();
    }
    @Override
    public String getType() {
        return "Moto";
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void deplace() {
        System.out.println("La moto roule");
    }
}
