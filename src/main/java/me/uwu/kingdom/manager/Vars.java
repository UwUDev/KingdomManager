package me.uwu.kingdom.manager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Vars {
    public static final List<File> savesFiles = new ArrayList<>();
    public static File globalSaveFile;
    private static final String globalFileRegex = "global-v[0-9][0-9]";
    private static final String saveFileRegex = "island-v[0-9][0-9]-c[0-9]-l[0-9]";

    public static void initialize(){
        Pattern p = Pattern.compile(saveFileRegex);
        Pattern p2 = Pattern.compile(globalFileRegex);
        for (File file : new File(System.getenv("HOMEPATH") + "\\AppData\\LocalLow\\noio\\KingdomTwoCrowns\\Release\\").listFiles()) {
            if (p.matcher(file.getName()).matches()){
                savesFiles.add(file);
                System.out.println("Save file found !");
            }
            if (p2.matcher(file.getName()).matches()){
                globalSaveFile = file;
                System.out.println("Global save file found !");
            }
        }
    }
}
