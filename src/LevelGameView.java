import PlayerClasses.Player;
import PlayerClasses.PlayerCollisionListener;
import PlayerClasses.PlayerController;
import PlayerClasses.Weapon;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;

public class LevelGameView extends UserView{
    private final Image background = new ImageIcon("Sprites/BackgroundLevel1.png").getImage();
    private Player p;
    public LevelGameView(Level w, int width, int height) {
        super(w, width, height);
        this.p = new Player("StandardPlayerSkin",10, 1, w);
        this.p.SetWeapon("BaseSwordAttack");
        this.p.setPosition(new Vec2(10, 10));
        this.p.addCollisionListener(new PlayerCollisionListener(this.p));
        PlayerController controller = new PlayerController(this.p);
        addKeyListener(controller);
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(this.background, 0, 0, this);
        g.setFont(new Font("Default", Font.PLAIN, 20));
        g.setColor(new Color(7, 7, 7));
        g.drawString(("Controls: A/D - Right/left"),200, 120);
        g.drawString(("SPACE - Jump"),200, 140);
        g.drawString(("F - Attack"),200, 160);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        g.setFont(new Font("Default", Font.BOLD, 20));
        g.setColor(new Color(255, 155, 197));
        g.drawString(("Health left: "+ this.p.health), 20, 20);
        g.drawString(("LV: "+ this.p.level), 220, 20);
        g.drawString(("Weapon damage: " + this.p.weapon.damage), 320, 20);
    }
}
