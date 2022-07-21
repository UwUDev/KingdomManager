package me.uwu.kingdom.manager.tests;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import me.uwu.kingdom.manager.Main;
import me.uwu.kingdom.manager.objects.Obj;
import me.uwu.kingdom.manager.objects.characters.Character;
import me.uwu.kingdom.manager.objects.characters.Worker;
import me.uwu.kingdom.manager.save.IslandSave;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Tester {
    static final byte saveSlot = 2, land = 1;
    static final Gson gson = new Gson();

    public static void main(String[] args) throws IOException {
        String workingSave = "island-v35-c" + saveSlot + "-l" + land;

        File backup = new File("Save.json");
        Main.decompressGzipFile("C:" + System.getenv("HOMEPATH") + "\\AppData\\LocalLow\\noio\\KingdomTwoCrowns\\Release\\" + workingSave, backup.getName());


        JsonObject json = gson.fromJson(Files.readAllLines(backup.toPath()).get(0), JsonObject.class);
        IslandSave islandSave = gson.fromJson(json, IslandSave.class);
        islandSave.getObjects().clear();
        json.get("objects").getAsJsonArray().forEach(obj -> {
            Obj o = new Obj();
            o.setData(obj.getAsJsonObject());
            islandSave.getObjects().add(o);
        });


        /*for (Obj object : islandSave.getObjects()) {
            if (object.isCharacters()){
                System.out.println(object);
                Character character = new Character(object.getData());
                System.out.println("P" + character.getIntPid() + "  |  UID: " + character.getIntUid() + "  |  Letter: " + character.getLetterId());
            }
        }

        System.out.println(islandSave.getCharactersQuantity() + " characters found");
        System.out.println(islandSave.getArchersQuantity() + " archers found");
        System.out.println(islandSave.getWorkersQuantity() + " workers found");
        System.out.println("next letter id is " + islandSave.getNextLetterId());
        System.out.println("Next archer PID is: " + islandSave.getNextArcherPid());
        System.out.println("Next worker PID is: " + islandSave.getNextWorkerPid());
        System.out.println("Next UID is: " + islandSave.getNextUid());

        System.out.println("Adding archers...\n\n");
        Worker worker = new Worker(islandSave.getNextLetterId(), islandSave.getNextWorkerPid(), islandSave.getNextUid());
        worker.setWalletMoney(10);
        islandSave.addObject(worker);
        System.out.println(islandSave.getCharactersQuantity() + " characters found");
        System.out.println(islandSave.getArchersQuantity() + " archers found");
        System.out.println("next letter id is " + islandSave.getNextLetterId());
        System.out.println("Next archer PID is: " + islandSave.getNextArcherPid());*/

        islandSave.moneyRain();
        //islandSave.wipeTrees();
        islandSave.addArchers(50);
        islandSave.addWorkers(8);

        json = gson.fromJson(gson.toJson(islandSave), JsonObject.class);
        json.remove("objects");
        JsonArray objects = new JsonArray();
        islandSave.getObjects().forEach(obj -> objects.add(obj.getData()));
        System.out.println(objects.get(5));
        json.add("objects", objects);
        /*islandSave.addArchers(60);
        islandSave.removeWorkers(999);
        islandSave.addWorkers(18);*/

        Main.saveBackup(backup.getName(), json.toString());
        Main.compressGzipFile(backup.getName(), workingSave);
    }
}
