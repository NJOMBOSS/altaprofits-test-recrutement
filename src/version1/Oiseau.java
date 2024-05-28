package version1;

import java.util.UUID;

public class Oiseau  implements  Animal{
    private final String id;

    public Oiseau() {
        this.id = UUID.randomUUID().toString();
    }
    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getType() {
        return "Oiseaux";
    }

    @Override
    public void deplace() {
        System.out.println("L'oiseau vole.");
    }
}