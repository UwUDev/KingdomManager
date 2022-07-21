package me.uwu.kingdom.manager.objects.characters;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import me.uwu.kingdom.manager.objects.Obj;

import java.util.regex.Pattern;

public class Character extends Obj {
    public Character() {
        super();
    }

    public Character(JsonObject data) {
        super(data);
    }

    public boolean isArcher() {
        try {
            return this.getData().get("name").getAsString().startsWith("Archer");
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public boolean isWorker() {
        try {
            return this.getData().get("name").getAsString().startsWith("Worker");
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public int getIntUid() {
        return Integer.parseInt(this.getData().get("uniqueID").getAsString().split("--")[1]);
    }

    public int getIntPid() {
        return Integer.parseInt(this.getData().get("name").getAsString().split(" P")[1].split(" ")[0]);
    }

    public String getLetterId() {
        return this.getData().get("name").getAsString().split(Pattern.quote("["))[1].split(Pattern.quote("]"))[0];
    }

    public void setWalletMoney(int money) {
        for (JsonElement componentData : this.getData().get("componentData2").getAsJsonArray()) {
            if (componentData.getAsJsonObject().get("name").getAsString().equals("Wallet")) {
                componentData.getAsJsonObject().addProperty("data", "{\"coins\":" + money + ",\"gems\":0}");
                return;
            }
        }
    }
}
