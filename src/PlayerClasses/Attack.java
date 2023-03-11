package PlayerClasses;

import SkinsClasses.Skin;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import javax.swing.Timer;
import java.util.Vector;

public class Attack extends StaticBody implements ActionListener {
    private int AttackSpeed = 300;

    public Attack(World w, Skin Skin, boolean IsRightSide, Vec2 spawnPos) {
        super(w, Skin.GetShape());
        if(IsRightSide){
            this.addImage(Skin.getOrientationRight());
        } else {
            this.addImage(Skin.getOrientationLeft());
        }
        this.setPosition(spawnPos);
        Timer AttackPerformed = new Timer(AttackSpeed, this);
        AttackPerformed.setRepeats(false);
        AttackPerformed.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.destroy();
    }
}
