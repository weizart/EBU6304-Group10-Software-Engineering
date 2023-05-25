package gui.student.analysis;

import gui.student.modules.Module;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Score data.
 */
public class ScoreData {

    /**
     * Read data list.
     *
     * @param orderBy  the order by
     * @param minScore the min score
     * @param maxScore the max score
     * @return the list
     */
    public static List<Score> readData(String orderBy, String minScore , String maxScore) {
        try {
            File f = new File("./src/data/","Grade1.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            List<Score> scoreList = new ArrayList<Score>();
            String t= null;

            Integer min = -1;
            Integer max = -1;
            if(!"".equals(minScore)){
                min = Integer.parseInt(minScore);
            }
            if(!"".equals(maxScore)){
                max = Integer.parseInt(maxScore);
            }
            while((t = br.readLine())!=null) {
                System.out.println(t);
                String[] s = t.split(",");
                Score score = new Score(s[0], Integer.parseInt(s[1]) , Integer.parseInt(s[2]) );
                System.out.println(score);
                boolean findFlag = true;
                if(min >= 0) {
                    if(score.getScore() >= min){
                        findFlag = true;
                    }else{
                        findFlag = false;
                    }
                }
                if(findFlag && max >= 0){
                    if(max >= score.getScore()){
                        findFlag = true;
                    }else{
                        findFlag = false;
                    }
                }
                if(findFlag){
                    scoreList.add(score);
                }
            }
            if("desc".equals(orderBy)){
                Collections.sort(scoreList);
            }else if("asc".equals(orderBy)){
                Collections.sort(scoreList);
                Collections.reverse(scoreList);
            }
            fr.close();
            br.close();
            System.out.println("表格1查到数量:" + scoreList.size());
            return scoreList;
        }catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Read file<Grade1.txt>fail");
        }
    }

    /**
     * Read data 2 list.
     *
     * @return the list
     */
    public static List<Score> readData2() {
        try {
            File f = new File("./src/data/","Grade2.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            List<Score> scoreList = new ArrayList<Score>();
            String t= null;

            while((t = br.readLine())!=null) {
                System.out.println(t);
                String[] s = t.split(",");
                Score score = new Score(s[0], Integer.parseInt(s[1]) , Integer.parseInt(s[2]) );
                scoreList.add(score);
            }
            fr.close();
            br.close();
            return scoreList;
        }catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Read file<Grade1.txt>fail");
        }
    }
}
