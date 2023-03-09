package Surroundings;

import SkinsClasses.Skin;
import city.cs.engine.*;

public class Platform extends StaticBody {
    private Skin skin;

    public Platform(World w, Shape s) {
        super(w, s);
    }

    public void SetSkin(Skin skin) {
        this.skin = skin;
    }
}
