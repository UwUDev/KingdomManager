package me.uwu.kingdom.manager.objects;

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
    private String name;
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
    private ComponentData[] componentData2;
}
