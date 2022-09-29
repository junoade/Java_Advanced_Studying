package enums.basic;

public class CardTest {
    public static void main(String[] args){
        Card card = new Card(0, 1);
        Card02 card2 = new Card02(Card02.Kind.CLOVER, Card02.Value.TWO);
        testTypesafeEnum();
        testPrintAll();
    }

    public static void testTypesafeEnum(){
        if (Card.HEART == Card.THREE) {
            System.out.println("단순히 값이 같아 true 반환 하는 경우");
        }

        if(Card02.Kind.HEART.equals(Card02.Value.THREE)){
            System.out.println("true");
        }else{
            System.out.println("typesafe enum이라, false를 반환한다.");
        }
    }

    public static void testPrintAll(){
        Card02.Kind[] values = Card02.Kind.values();
        for(Card02.Kind v : values){
            System.out.printf("%s = %d \n", v.name(), v.ordinal());
        }
    }


}
