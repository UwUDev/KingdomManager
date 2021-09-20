package me.uwu.kingdom.manager.tests;

import com.google.gson.Gson;
import me.uwu.kingdom.manager.Main;
import me.uwu.kingdom.manager.save.IslandSave;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ArchersTest {
    public static void main(String[] args) throws IOException {
        String workingSave = "island-v35-c0-l2";

        File backup = new File("Save.json");
        Main.decompressGzipFile("C:" + System.getenv("HOMEPATH") + "\\AppData\\LocalLow\\noio\\KingdomTwoCrowns\\Release\\" + workingSave, backup.getName());

        Gson gson = new Gson();
        String json = Files.readAllLines(backup.toPath()).get(0);
        IslandSave islandSave = gson.fromJson(json, IslandSave.class);

        islandSave.addArchers(60);
        islandSave.removeWorkers(999);
        islandSave.addWorkers(18);

        Main.saveBackup(backup.getName(), gson.toJson(islandSave));
        Main.compressGzipFile(backup.getName(), workingSave);
    }
}
