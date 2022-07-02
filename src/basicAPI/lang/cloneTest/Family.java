package basicAPI.lang.cloneTest;

public class Family {
    String id;
    String name;

    public Family(String id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString(){
        return "id : " + id + ", name : " + name;
    }
}
