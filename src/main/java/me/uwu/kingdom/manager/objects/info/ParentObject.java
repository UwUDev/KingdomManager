package me.uwu.kingdom.manager.objects.info;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ParentObject {
    private String linkedObjectID;

    public JsonElement toJsonObject() {
        JsonObject json = new JsonObject();
        json.addProperty("linkedObjectID", linkedObjectID);
        return json;
    }
}
