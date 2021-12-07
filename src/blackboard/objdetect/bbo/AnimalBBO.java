package blackboard.objdetect.bbo;

public class AnimalBBO extends AbstractObjectBBO {
    
    public AnimalBBO() {
        setName("Animal");
        prop.add(ObjectProp.MOVEABLE);
        prop.add(ObjectProp.BREATHING);
    }
}
