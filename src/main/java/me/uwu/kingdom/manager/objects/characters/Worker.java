package me.uwu.kingdom.manager.objects.characters;

import com.google.gson.Gson;
import me.uwu.kingdom.manager.objects.Obj;
import me.uwu.kingdom.manager.objects.info.ComponentData;
import me.uwu.kingdom.manager.objects.info.ParentObject;
import me.uwu.kingdom.manager.objects.info.Position;

import java.util.Random;

public class Worker extends Obj {

    public Worker(){
        super();
        Gson gson = new Gson();
        Random random = new Random();
        int rdm = random.nextInt(9999999) + 9999;
        this.setName("Worker P" + rdm + " [A]");
        this.setParentObject(new ParentObject(""));
        this.setHierarchyPath("Level/GameLayer/");
        this.setPrefabPath("Prefabs/Characters/Worker");
        this.setUniqueID("Worker P" + rdm + " [A]--" + rdm);
        this.setMode(0);
        this.setCreateOrder(rdm);
        this.setLinkOrder(0);
        this.setDecayHint(4);
        this.setDecayResistanceDays(-1);
        this.setDecayedVersionPrefabPath("Prefabs/Characters/Peasant");
        this.setNetID(rdm);
        this.setCrpcType(1);
        this.setLocalPosition(new Position(random.nextDouble(), random.nextDouble(), random.nextDouble()));
        this.setLocalScale(new Position(-1, 1, 1));
        this.setComponentData2(gson.fromJson("[{\"name\":\"Wallet\",\"type\":\"WalletData\",\"data\":\"{\\\"coins\\\":0,\\\"gems\\\":0}\"},{\"name\":\"Character\",\"type\":\"CharacterData\",\"data\":\"{\\\"isGrabbed\\\":false,\\\"inert\\\":false}\"},{\"name\":\"Archer\",\"type\":\"ArcherData\",\"data\":\"{\\\"tower\\\":{\\\"linkedObjectID\\\":\\\"\\\"},\\\"knight\\\":{\\\"linkedObjectID\\\":\\\"\\\"},\\\"guardSide\\\":1,\\\"guardDepth\\\":0}\"},{\"name\":\"Damageable\",\"type\":\"DamageableData\",\"data\":\"{\\\"hitPoints\\\":0,\\\"invulnerable\\\":false}\"}]", ComponentData[].class));
    }

    // Position localPosition, Position localScale, ComponentData[] componentData2) {
    //

    public Worker(String name, ParentObject parentObject, String hierarchyPath, String prefabPath, String uniqueID, int mode, int createOrder, int linkOrder, int decayHint, int decayResistanceDays, String decayedVersionPrefabPath, int netID, int crpcType, Position localPosition, Position localScale, ComponentData[] componentData2) {
        super(name, parentObject, hierarchyPath, prefabPath, uniqueID, mode, createOrder, linkOrder, decayHint, decayResistanceDays, decayedVersionPrefabPath, netID, crpcType, localPosition, localScale, componentData2);
    }
}
