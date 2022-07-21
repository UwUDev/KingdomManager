package me.uwu.kingdom.manager.objects.characters;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import me.uwu.kingdom.manager.objects.Obj;
import me.uwu.kingdom.manager.objects.info.ComponentData;
import me.uwu.kingdom.manager.objects.info.ParentObject;
import me.uwu.kingdom.manager.objects.info.Position;

import java.util.Random;

public class Worker extends Character {

    public Worker(String letterId, int pid, int uid){
        super(new JsonObject());
        Gson gson = new Gson();
        Random random = new Random();
        this.getData().addProperty("name", "Worker P" + pid + " [" + letterId + "]");
        this.getData().add("parentObject", new ParentObject("").toJsonObject());
        this.getData().addProperty("hierarchyPath", "Level/GameLayer/");
        this.getData().addProperty("prefabPath", "Prefabs/Characters/Worker");
        this.getData().addProperty("uniqueID", "Worker P" + pid + " [" + letterId + "]--" + uid);
        this.getData().addProperty("mode", 0);
        this.getData().addProperty("createOrder", random.nextInt(100000));
        this.getData().addProperty("linkOrder", 0);
        this.getData().addProperty("decayHint", 4);
        this.getData().addProperty("decayResistanceDays", 1);
        this.getData().addProperty("decayedVersionPrefabPath", "Prefabs/Characters/Peasant");
        this.getData().addProperty("netID", random.nextInt(10000));
        this.getData().addProperty("crpcType", 1);
        this.getData().add("localPosition", new Position(random.nextDouble(), random.nextDouble(), random.nextDouble()).toJsonObject());
        this.getData().add("localScale", new Position(1, 1, 1).toJsonObject());
        JsonArray componentData2 = new JsonArray();
        for (JsonObject jsonObject : gson.fromJson("[{\"name\":\"Wallet\",\"type\":\"WalletData\",\"data\":\"{\\\"coins\\\":0,\\\"gems\\\":0}\"},{\"name\":\"Character\",\"type\":\"CharacterData\",\"data\":\"{\\\"isGrabbed\\\":false,\\\"inert\\\":false}\"},{\"name\":\"Damageable\",\"type\":\"DamageableData\",\"data\":\"{\\\"hitPoints\\\":0,\\\"invulnerable\\\":false}\"}]", JsonObject[].class)) {
            componentData2.add(jsonObject);
        }
        this.getData().add("componentData2", componentData2);
    }

    public Worker(JsonObject data) {
        super(data);
    }
}
