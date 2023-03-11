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
        g.setColor(new Color(255, 155, 197));
        g.drawString(("Health left: "+ this.p.health), 20, 20);
        g.drawString(("LV: "+ this.p.level), 220, 20);
        g.drawString(("Weapon damage: " + this.p.weapon.damage), 320, 20);
        g.setFont(new Font("Default", Font.PLAIN, 20));
        g.setColor(new Color(0, 0, 0));
        g.drawString(("Controls: A/D - Right/left SPACE - Jump F - Attack"),200, 40);
    }

    @Override
    public void preStep(StepEvent stepEvent) {

    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
