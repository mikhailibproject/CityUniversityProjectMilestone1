import Surroundings.MovingPlatform;
import Surroundings.Platform;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.util.ArrayList;
import java.util.List;

public class Level extends World{
    public String levelType;
    public int[][] levelStructure;
    List<Platform> platforms = new ArrayList<>();
    Level(String levelType) {
        this.levelType = levelType;
        this.levelStructure = LevelGenerator.GenerateLevel(this.levelType);
        Platform RightSide = new Platform(this, new BoxShape(1f,100));
        RightSide.setPosition(new Vec2(0, 0));
        Platform LeftSide = new Platform(this, new BoxShape(1f,100));
        LeftSide.setPosition(new Vec2(40, 0));
        Platform top = new Platform(this, new BoxShape(100,1f));
        top.setPosition(new Vec2(0, 30));
        for(int i = 0; i < levelStructure.length; i++){
            for(int j = 0; j < levelStructure[i].length; j++){
                if(levelStructure[i][j] == 1){
                    Platform p = new Platform(this, new BoxShape(5f,0.5f));
                    p.setPosition(new Vec2(j*10+5, i*10+0.5f));
                    platforms.add(p);
                }
                if(levelStructure[i][j] == 2){
                    MovingPlatform p = new MovingPlatform(this, new BoxShape(5f,0.5f),
                            true, 10, 10);
                    p.setPosition(new Vec2(j*10+5, i*10+0.5f), true);
                }
            }
        }
        PrintLevelStructure();

    }
    public void PrintLevelStructure(){
        for(int[] l : levelStructure){
            for(int c : l){
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
