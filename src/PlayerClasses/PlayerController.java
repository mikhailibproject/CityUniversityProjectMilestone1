package PlayerClasses;

import PlayerClasses.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerController implements KeyListener {
    private final Player p;

    public PlayerController(Player p) {
        this.p = p;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) { // Moving Left
            p.currentSpeed = p.walkSpeed * -1;
            p.startWalking(p.currentSpeed);
            p.removeAllImages();
            p.addImage(p.skin.getOrientationLeft());
        } else if (code == KeyEvent.VK_D) { // moving right
            p.currentSpeed = p.walkSpeed;
            p.startWalking(p.currentSpeed);
            p.removeAllImages();
            p.addImage(p.skin.getOrientationRight());
        } else if (code == KeyEvent.VK_SPACE) { // jump
            p.jump(p.jumHeight);
        } else if (code == KeyEvent.VK_F){
            p.weapon.Attack();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code != KeyEvent.VK_SPACE){
            p.currentSpeed = 0;
            p.startWalking(p.currentSpeed);
            p.removeAllImages();
            p.addImage(p.skin.getOrientationBasic());
            //p.stopWalking();
        }
    }
}
