package generics.wildcardTest;

class Person {
    String info;

    Person(String info){
        this.info = info;
    }

    @Override
    public String toString() {
        return "Person{" +
                "info='" + info + '\'' +
                '}';
    }
}
