import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {

    public static void main(String[] args) {
        SkinsClasses.Skin.DownloadSkins();
        GamePlayground world = new GamePlayground();
        Player p = new Player("StandardPlayerSkin",10, 1, world);
        //p.body.setGravityScale(0);
        p.setPosition(world.getPlayerSpawnPosition());

        PlayerController controller = new PlayerController(p);

        UserView view = new UserView(world, 800, 600);

        view.addKeyListener(controller);

        view.setGridResolution(1);

        final JFrame frame = new JFrame("City Game");
        frame.add(view);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        world.start();
        view.requestFocus();
    }
}