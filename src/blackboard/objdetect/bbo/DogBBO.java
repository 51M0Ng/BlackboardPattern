package blackboard.objdetect.bbo;

public class DogBBO extends AbstractObjectBBO {

    public DogBBO(){
        setName("Dog");
        prop.add(ObjectProp.MOVEABLE);
        prop.add(ObjectProp.BREATHING);
        prop.add(ObjectProp.OMNIVORE);
    }
}
