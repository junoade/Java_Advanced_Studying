package enums.basic;

public class Card02 {
    enum Kind {CLOVER, HEART, DIAMOND, SPADE}

    enum Value {TWO, THREE, FOUR}

    final Kind kind;
    final Value value;

    Card02(Kind kind, Value value){
        this.kind = kind;
        this.value = value;
    }
}
