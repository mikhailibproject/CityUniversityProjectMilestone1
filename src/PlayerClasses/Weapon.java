package PlayerClasses;
import SkinsClasses.Skin;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Weapon extends StaticBody implements ActionListener {
    protected Player p;
    protected Skin weaponSkin; // Will be added in future
    public final int damage = 2; // can be changed in future
    protected Skin attackSkin;
    private int cooldown = 1000;
    public Timer startCooldown;
    protected boolean weaponIsReady = true;

    public Weapon(World w, String AttackSkinName, Player weaponHolder) {
        super(w);
        this.attackSkin = Skin.skinCollection.get(AttackSkinName);
        this.p = weaponHolder;
        this.startCooldown = new Timer(this.cooldown, this);
        this.startCooldown.setRepeats(false);
    }
    public void Attack() {
        if(!weaponIsReady){
            return;
        }
        this.weaponIsReady = false;
        this.startCooldown.start();
        if(p.currentSpeed > 0){ // right attack
            Vec2 SpawnPos = new Vec2(p.getPosition().x + 1f, p.getPosition().y);
            Attack action = new Attack(p.getWorld(), this.attackSkin, true ,SpawnPos);
            action.addCollisionListener(new WeaponCollisionListener(this));
        } else if(p.currentSpeed < 0){ // left attack
            Vec2 SpawnPos = new Vec2(p.getPosition().x - 1f, p.getPosition().y);
            Attack action = new Attack(p.getWorld(), this.attackSkin, false, SpawnPos);
            action.addCollisionListener(new WeaponCollisionListener(this));
        } else { // both side attack
            Vec2 SpawnPos1 = new Vec2(p.getPosition().x + 1f, p.getPosition().y);
            Vec2 SpawnPos2 = new Vec2(p.getPosition().x - 1f, p.getPosition().y);
            Attack action1 = new Attack(p.getWorld(), this.attackSkin, true, SpawnPos1);
            Attack action2 = new Attack(p.getWorld(), this.attackSkin,false, SpawnPos2);
            action1.addCollisionListener(new WeaponCollisionListener(this));
            action2.addCollisionListener(new WeaponCollisionListener(this));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.weaponIsReady = true;
    }
}
