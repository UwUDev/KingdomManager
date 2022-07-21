package me.uwu.kingdom.manager.save;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import me.uwu.kingdom.manager.objects.Obj;
import me.uwu.kingdom.manager.objects.characters.Archer;
import me.uwu.kingdom.manager.objects.characters.Character;
import me.uwu.kingdom.manager.objects.characters.Worker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class IslandSave {
    final static String[] treesNames = new String[]{"oakTree", "birchTree", "Tree", "Hint Cut Tree"};

    private double playTimeDays;
    private double lastPlayedTimeDays;
    private boolean repopGrassHack;
    private int biome;
    private int[] savedWithRevisions;
    private int land;
    private List<Obj> objects;
    private int lastPlayedReign;

    public void addObject(Obj object){
        objects.add(object);
    }

    public void addArchers(int quantity){
        for (int i = 0; i < quantity; i++) {
            objects.add(new Archer(getNextLetterId(), getNextArcherPid(), getNextUid()));
        }
    }

    public void removeArchers(int quantity){
        List<Obj> objs = new ArrayList<>();
        List<Obj> tempArchers = new ArrayList<>();
        for (Obj object : objects) {
            if (!object.isCharacters()) {
                if (new Character(object.getData()).isArcher())
                    objs.add(object);
            } else tempArchers.add(object);
        }

        for (int i = 0; i < getArchersQuantity() - quantity; i++) {
            objs.add(tempArchers.get(0));
        }
        objects = objs;
    }

    public int getCharactersQuantity(){
        int quantity = 0;
        for (Obj object : objects)
            if (object.isCharacters())
                quantity++;
        return quantity;
    }

    public int getArchersQuantity(){
        int quantity = 0;
        for (Obj object : objects)
            if (object.isCharacters())
                if (new Character(object.getData()).isArcher())
                    quantity++;
        return quantity;
    }

    public void addWorkers(int quantity){
        for (int i = 0; i < quantity; i++) {
            addObject(new Worker(getNextLetterId(), getNextWorkerPid(), getNextUid()));
        }
    }

    public void removeWorkers(int quantity){
        List<Obj> objs = new ArrayList<>();
        List<Obj> tempWorkers = new ArrayList<>();
        for (Obj object : objects) {
            if (!object.isCharacters()) {
                if (new Character(object.getData()).isWorker())
                    objs.add(object);
            } else tempWorkers.add(object);
        }

        for (int i = 0; i < getWorkersQuantity() - quantity; i++) {
            objs.add(tempWorkers.get(0));
        }
        objects = objs;
    }

    public int getWorkersQuantity(){
        int quantity = 0;
        for (Obj object : objects)
            if (object.isCharacters())
                if (new Character(object.getData()).isWorker())
                    quantity++;
        return quantity;
    }

    public int getNextArcherPid() {
        int pid = 0;
        for (Obj object : objects) {
            if (object.isCharacters()) {
                Character character = new Character(object.getData());
                if (character.isArcher()) {
                    if (character.getIntPid() > pid)
                        pid = character.getIntPid();
                }
            }
        }
        return pid+1;
    }

    public int getNextWorkerPid() {
        int pid = 0;
        for (Obj object : objects) {
            if (object.isCharacters()) {
                Character character = new Character(object.getData());
                if (character.isWorker()) {
                    if (character.getIntPid() > pid)
                        pid = character.getIntPid();
                }
            }
        }
        return pid+1;
    }

    public int getNextUid() {
        int uid = 0;
        for (Obj object : objects) {
            if (object.getData().get("uniqueID") != null) {
                try {
                    if (Integer.parseInt(object.getData().get("uniqueID").getAsString().split("--")[1]) > uid)
                        uid = Integer.parseInt(object.getData().get("uniqueID").getAsString().split("--")[1]);
                } catch (ArrayIndexOutOfBoundsException ignored) {
                }
            }
        }
        return uid;
    }

    public String getNextLetterId() {
        return toAlphabetic(getCharactersQuantity());
    }

    private String toAlphabetic(int i) {
        if( i<0 ) {
            return "-"+toAlphabetic(-i-1);
        }

        int quot = i/26;
        int rem = i%26;
        char letter = (char)((int)'A' + rem);
        if( quot == 0 ) {
            return ""+letter;
        } else {
            return toAlphabetic(quot-1) + letter;
        }
    }

    public void moneyRain() {
        objects.forEach(obj -> {
            if (obj.isCharacters()){
                Character character = new Character(obj.getData());
                character.setWalletMoney(20);
                obj.setData(character.getData());
            }
        });
    }

    public void wipeTrees() {
        List<Obj> toDelete = new ArrayList<>();
        objects.forEach(obj -> {
            for (String treeName : treesNames) {
                if (obj.getData().get("name").getAsString().startsWith(treeName))
                    toDelete.add(obj);
            }
        });
        objects.removeAll(toDelete);
    }
}
