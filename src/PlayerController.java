import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerController implements KeyListener {
    private final Player p;

    PlayerController(Player p) {
        this.p = p;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) { // Moving Left
            p.startWalking(p.walkSpeed * -1);
            p.removeAllImages();
            p.addImage(p.skin.getOrientationLeft());
        } else if (code == KeyEvent.VK_D) { // moving right
            p.startWalking(p.walkSpeed);
            p.removeAllImages();
            p.addImage(p.skin.getOrientationRight());
        } else if (code == KeyEvent.VK_SPACE) { // jump
            p.jump(p.jumHeight);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code != KeyEvent.VK_SPACE){
            p.startWalking(0);
            p.removeAllImages();
            p.addImage(p.skin.getOrientationBasic());
            //p.stopWalking();
        }
    }
}
