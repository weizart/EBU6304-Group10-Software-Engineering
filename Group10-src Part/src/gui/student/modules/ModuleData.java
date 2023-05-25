package gui.student.modules;

import entity.Examwork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Module data.
 */
public class ModuleData {

    /**
     * Read data list.
     *
     * @param name        the name
     * @param teacherName the teacher name
     * @param termName    the term name
     * @return the list
     */
    public static List<Module> readData(String name, String teacherName, String termName) {
        try {
            File f = new File("./src/data/","Class.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            List<Module> moduleList = new ArrayList<Module>();
            String t= null;
            while((t = br.readLine())!=null) {
                System.out.println(t);
                String[] s = t.split(",");
                Module module = new Module(s[0], s[1], s[2], s[3] , Integer.parseInt(s[4]) , Float.parseFloat(s[5]) , s[6] );
                boolean findFlag = true;
                if(name.length() > 0) {
                    if(!module.getName().contains(name)){
                        findFlag = false;
                    }
                }
                if(teacherName.length() > 0) {
                    if(!module.getTeacher().contains(teacherName)){
                        findFlag = false;
                    }
                }
                if(termName.length() > 0) {
                    if(!module.getTerm().contains(termName)){
                        findFlag = false;
                    }
                }
                if(findFlag){
                    moduleList.add(module);
                }
            }
            fr.close();
            br.close();
            return moduleList;
        }catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Read file<Class.txt>fail");
        }
    }
}
