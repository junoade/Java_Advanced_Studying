package basicAPI.lang.cloneTest;

class Member implements Cloneable {
    String id;
    String name;
    String pwd;
    int age;
    boolean adult;

    public Member(String id, String name, String pwd, int age, boolean adult) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.age = age;
        this.adult = adult;
    }

    public Member shallowCopy() throws CloneNotSupportedException {
        return (Member) clone();
    }

    @Override
    public String toString(){
        return "id : " + id + ", name : " + name + ", pwd : " + pwd + " , age : " + age + ", adult : " + adult;
    }
}
