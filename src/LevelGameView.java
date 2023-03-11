import PlayerClasses.Player;
import PlayerClasses.PlayerCollisionListener;
import PlayerClasses.PlayerController;
import PlayerClasses.Weapon;
import city.cs.engine.*;

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;

public class LevelGameView extends UserView implements StepListener{
    private final Image background = new ImageIcon("Sprites/BackgroundLevel1.png").getImage();
    private Player p;
    public LevelGameView(GamePlayground w, int width, int height) {
        super(w, width, height);
        this.p = new Player("StandardPlayerSkin",10, 1, w);
        this.p.SetWeapon("BaseSwordAttack");
        this.p.setPosition(w.getPlayerSpawnPosition());
        this.p.addCollisionListener(new PlayerCollisionListener(this.p));
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
    protected void paintForeground(Graphics2D g) {
        g.setFont(new Font("Default", Font.BOLD, 20));
        g.setColor(new Color(255, 0, 0));
        g.drawString(("Health left: "+ this.p.health), 20, 20);
    }

    @Override
    public void preStep(StepEvent stepEvent) {

    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
