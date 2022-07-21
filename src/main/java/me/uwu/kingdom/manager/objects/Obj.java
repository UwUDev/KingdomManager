package me.uwu.kingdom.manager.objects;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.uwu.kingdom.manager.objects.info.ComponentData;
import me.uwu.kingdom.manager.objects.info.ParentObject;
import me.uwu.kingdom.manager.objects.info.Position;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Obj {
    protected static final Gson gson = new Gson();
    private JsonObject data;

    /*private String name;
    private ParentObject parentObject;
    private String hierarchyPath;
    private String prefabPath;
    private String uniqueID;
    private int mode;
    private int createOrder;
    private int linkOrder;
    private int decayHint;
    private int decayResistanceDays;
    private String decayedVersionPrefabPath;
    private int netID;
    private int crpcType;
    private Position localPosition;
    private Position localScale;
    private ComponentData[] componentData2;*/

    public boolean isCharacters() {
        try {
            if (data.get("name").getAsString().startsWith("Beggar"))
                return false;
            return data.get("componentData2").getAsJsonArray().get(1).getAsJsonObject().get("name").getAsString().equals("Character");
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return gson.toJson(this);
    }
}
