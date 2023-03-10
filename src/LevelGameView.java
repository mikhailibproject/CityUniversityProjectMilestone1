import city.cs.engine.*;

public class LevelGameView extends UserView {
    public LevelGameView(GamePlayground w, int width, int height) {
        super(w, width, height);
        Player p = new Player("StandardPlayerSkin",10, 1, w);
        p.setPosition(w.getPlayerSpawnPosition());
        PlayerController controller = new PlayerController(p);
        addKeyListener(controller);
        setGridResolution(1);
    }
}
