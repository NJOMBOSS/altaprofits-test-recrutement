package version1;

import java.util.UUID;

public class JetSki implements Vehicule{
    private final String id;

    public JetSki(){
        this.id= UUID.randomUUID().toString();
    }
    @Override
    public String getType() {
        return "JetSki";
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void deplace() {
        System.out.println("Le jetSki flotte");
    }
}
