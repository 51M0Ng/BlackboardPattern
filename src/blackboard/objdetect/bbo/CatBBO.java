package blackboard.objdetect.bbo;

public class CatBBO extends AbstractObjectBBO {
    
    public CatBBO(){
        setName("Cat");
        prop.add(ObjectProp.MOVEABLE);
        prop.add(ObjectProp.BREATHING);
        prop.add(ObjectProp.CARNIVORA);
    }
}
