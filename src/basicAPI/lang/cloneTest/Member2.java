package basicAPI.lang.cloneTest;

class Member2 implements Cloneable {
    Family family;
    String id;
    String name;
    String pwd;
    int age;
    boolean adult;

    public Member2(Family family, String id, String name, String pwd, int age, boolean adult) {
        this.family = family;
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.age = age;
        this.adult = adult;
    }

    public Member2 shallowCopy() throws CloneNotSupportedException {
        return (Member2) clone();
    }

    @Override
    public String toString(){
        return family.toString() +", id : " + id + ", name : " + name + ", pwd : " + pwd + " , age : " + age + ", adult : " + adult;
    }
}
