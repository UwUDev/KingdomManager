package me.uwu.kingdom.manager;

import com.google.gson.Gson;
import me.uwu.kingdom.manager.objects.Obj;
import me.uwu.kingdom.manager.save.IslandSave;

import java.io.*;
import java.nio.file.Files;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        File backup = new File("Save.json");
        decompressGzipFile(System.getenv("HOMEPATH") + "\\AppData\\LocalLow\\noio\\KingdomTwoCrowns\\Release\\island-v35-c0-l0", backup.getName());

        Gson gson = new Gson();
        String json = Files.readAllLines(backup.toPath()).get(0);
        IslandSave islandSave = gson.fromJson(json, IslandSave.class);

        //islandSave.addArchers(500);
        //islandSave.addWorkers(20);

        for (Obj object : islandSave.getObjects()) {
            if (object.getName().startsWith("Worker")) {
                object.getComponentData2()[0].setData("{\"coins\":1,\"gems\":1}");
                System.out.println("YES");
            }
        }

        saveBackup(backup.getName(), gson.toJson(islandSave));
        compressGzipFile(backup.getName(), "island-v35-c0-l0");
    }

    public static void saveBackup(String name, String json){
        try {
            FileWriter myWriter = new FileWriter(name);
            myWriter.write(json);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void decompressGzipFile(String gzipFile, String newFile) {
        try {
            FileInputStream fis = new FileInputStream(gzipFile);
            GZIPInputStream gis = new GZIPInputStream(fis);
            FileOutputStream fos = new FileOutputStream(newFile);
            byte[] buffer = new byte[1024];
            int len;
            while((len = gis.read(buffer)) != -1){
                fos.write(buffer, 0, len);
            }
            //close resources
            fos.close();
            gis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void compressGzipFile(String file, String gzipFile) {
        try {
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(gzipFile);
            GZIPOutputStream gzipOS = new GZIPOutputStream(fos);
            byte[] buffer = new byte[1024];
            int len;
            while((len=fis.read(buffer)) != -1){
                gzipOS.write(buffer, 0, len);
            }
            //close resources
            gzipOS.close();
            fos.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
