import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class LevelGenerator {
    public static HashMap<String, Integer> GenerationTypes = new HashMap<String, Integer>();
    /*
    * 0 empty cell
    * 1 Platform Cell
    * 2 Horizontally moving platform cell
    * 3 Vertically moving horizontal cell
    * */
    public static int[][] GenerateLevel(String type){
        DownloadLevelTypes();
        int TypeID = -1;
        try {
            TypeID = GenerationTypes.get(type);
        } catch (Exception e){
            System.out.println("Level type not found");
        }
        switch(TypeID){
            case 0:
                return baseWorldGenerate();
            case 1:
                return hellWorldGenerate();
            default:
                return new int[][] {{1,1,1,1}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        }

    }
    public static int[][] baseWorldGenerate(){
        Random random = new Random();
        int prob;
        int[][] scheme = {{1, 1, 1, 1}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        int cell1, cell2, cell3;
        for(int i = 1; i < scheme.length; i++){
            prob = random.nextInt(100);
            // static platform generating
            if(prob < 70) {
                cell1 = random.nextInt(scheme[i].length); // choose random cell
                scheme[i][cell1] = 1;
                prob = random.nextInt(100);
                if(prob < 70){
                    cell2 = random.nextInt(scheme[i].length); // choose random cell2
                    while(cell1 == cell2){
                        cell2 = random.nextInt(scheme[i].length);
                    }
                    scheme[i][cell2] = 1;
                    prob = random.nextInt(100);
                    if(prob < 50){
                        cell3 = random.nextInt(scheme[i].length); // choose random cell3
                        while(cell1 == cell3 || cell2 == cell3){
                            cell3 = random.nextInt(scheme[i].length);
                        }
                        scheme[i][cell3] = 1;
                    }
                }
            // flying platform generating
            } else {
              cell1 = random.nextInt(scheme[i].length);
              scheme[i][cell1] = 2;
              if(cell1 == 0 || cell1 == scheme[i].length - 1){
                  prob = random.nextInt(100);
                  if(prob < 30){
                      cell2 = (cell1 == 0) ? (scheme[i].length - 1) : 0;
                      scheme[i][cell2] = 2;
                  }
              }
            }
        }
        return scheme;
    }

    public static int[][] hellWorldGenerate(){
        Random random = new Random();
        int prob;
        int[][] scheme = {{1, 1, 1, 1}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        for(int i = 1; i < scheme.length; i++) {
            prob = random.nextInt(scheme.length);
            for(int j = 0; j < scheme[i].length; j++){
                if(j != prob){
                    scheme[i][j] = 1;
                }
            }
        }
        return scheme;

    }
    public static void DownloadLevelTypes(){
        GenerationTypes.put("BaseWorld", 0);
        GenerationTypes.put("HellWorld", 1);
    }
}
