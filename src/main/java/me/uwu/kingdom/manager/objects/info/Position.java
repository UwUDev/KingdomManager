package me.uwu.kingdom.manager.objects.info;

import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Position {
    private double x, y, z;

    public JsonObject toJsonObject() {
        JsonObject json = new JsonObject();
        json.addProperty("x", x);
        json.addProperty("y", y);
        json.addProperty("z", z);
        return json;
    }
}
