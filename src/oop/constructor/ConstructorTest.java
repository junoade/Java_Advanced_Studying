package oop.constructor;

public class ConstructorTest {
    public static void main(String[] args){
        DefaultConstructor dcs = new DefaultConstructor();
        ArgsConstructor acs = new ArgsConstructor();
        ArgsConstructor acs2 = new ArgsConstructor(97);
        UsingThis uth = new UsingThis();

        InitializedBlock blockTest = new InitializedBlock();

    }
}
