package blackboard.objdetect.bbo;

import java.util.ArrayList;
import java.util.List;

import blackboard.framework.AbstractBlackBoardObject;

public class AbstractObjectBBO extends AbstractBlackBoardObject {
    
    public enum ObjectProp {
        MOVEABLE,
        BREATHING,
        EAT_MEAT,
        EAT_VEGETABLE,
        TWO_LEG,
        FOUR_LEG,
        OMNIVORE,
        CARNIVORA,
        ;
    }

    protected List<ObjectProp> prop = new ArrayList<>();
    protected String type;
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProp(List<ObjectProp> prop) {
        this.prop = prop;
    }

    public List<ObjectProp> getProp() {
        return prop;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}