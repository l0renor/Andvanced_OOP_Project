package bunny_hop.logic;

import framework.data.AccessoryType;
import framework.data.BasicAccessoryType;

public enum BunnyHopAccessoryType implements AccessoryType {
    BUNNY("BUNNY"),
    FIELD("FIELD"),
    CARROT("CARROT");

    private String accessoryTypeName;

    BunnyHopAccessoryType(String accessoryTypeName) {
        this.accessoryTypeName = accessoryTypeName;
        BasicAccessoryType.addNewAccessoryType(this);
    }

    @Override
    public String getAccessoryTypeName() {
        return accessoryTypeName;
    }

}
