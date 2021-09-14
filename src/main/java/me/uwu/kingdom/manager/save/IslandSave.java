package me.uwu.kingdom.manager.save;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import me.uwu.kingdom.manager.objects.Obj;
import me.uwu.kingdom.manager.objects.characters.Archer;
import me.uwu.kingdom.manager.objects.characters.Worker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class IslandSave {
    private double playTimeDays;
    private double lastPlayedTimeDays;
    private boolean repopGrassHack;
    private int biome;
    private int[] savedWithRevisions;
    private int land;
    private Obj[] objects;
    private int lastPlayedReign;

    public void addObject(Obj object){
        List<Obj> objs = new ArrayList<>(Arrays.asList(objects));
        objs.add(object);
        objects= objs.toArray(new Obj[0]);
    }

    public void addArchers(int quantity){
        for (int i = 0; i < quantity; i++) {
            addObject(new Archer());
        }
    }

    public void removeArchers(int quantity){
        List<Obj> objs = new ArrayList<>();
        List<Obj> tempArchers = new ArrayList<>();
        for (Obj object : objects) {
            if (!object.getName().startsWith("Archer"))
                objs.add(object);
            else tempArchers.add(object);
        }

        for (int i = 0; i < getArchersQuantity() - quantity; i++) {
            objs.add(tempArchers.get(0));
        }
        objects= objs.toArray(new Obj[0]);
    }

    public int getArchersQuantity(){
        int quantity = 0;
        for (Obj object : objects)
            if (object.getName().startsWith("Archer")) quantity++;
        return quantity;
    }

    public void addWorkers(int quantity){
        for (int i = 0; i < quantity; i++) {
            addObject(new Worker());
        }
    }

    public void removeWorkers(int quantity){
        List<Obj> objs = new ArrayList<>();
        List<Obj> tempWorkers = new ArrayList<>();
        for (Obj object : objects) {
            if (!object.getName().startsWith("Worker"))
                objs.add(object);
            else tempWorkers.add(object);
        }

        for (int i = 0; i < getWorkersQuantity() - quantity; i++) {
            objs.add(tempWorkers.get(0));
        }
        objects= objs.toArray(new Obj[0]);
    }

    public int getWorkersQuantity(){
        int quantity = 0;
        for (Obj object : objects)
            if (object.getName().startsWith("Worker")) quantity++;
        return quantity;
    }
}
