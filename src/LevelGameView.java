import PlayerClasses.Player;
import PlayerClasses.PlayerController;
import city.cs.engine.*;

import javax.swing.*;
import java.awt.*;

public class LevelGameView extends UserView implements StepListener{
    private final Image background = new ImageIcon("Sprites/BackgroundLevel1.png").getImage();
    private Player p;
    public LevelGameView(GamePlayground w, int width, int height) {
        super(w, width, height);
        this.p = new Player("StandardPlayerSkin",10, 1, w);
        this.p.setPosition(w.getPlayerSpawnPosition());
        PlayerController controller = new PlayerController(this.p);
        addKeyListener(controller);
        setGridResolution(1);
        w.addStepListener(this);
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(this.background, 0, 0, this);
    }

    @Override
    public void preStep(StepEvent stepEvent) {

    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
