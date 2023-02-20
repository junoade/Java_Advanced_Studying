package oop.basic.staticVsInstance;

public class CardTest {
    public static void main(String[] args) {
        System.out.println("Card.width = " + Card.width);
        System.out.println("Card.height = " + Card.height);

        Card c1 = new Card("Heart", 7);
        Card c2 = new Card("Spade", 4);

        System.out.println(c1);
        System.out.println(c2);


        System.out.println(" -- c1의 width와  height를 각각 50, 80으로 변경 -- ");
        c1.width = 50; // 권장되는 코드 스타일은 Card.width로 모든 Card 객체가 공유하는 static 변수임을 명시적으로 나타내기
        c1.height = 80;

        System.out.println(c1);
        System.out.println(c2);
    }
}

class Card {
    static int width = 100;
    static int height = 250;

    String kind;
    int number;

    Card() {
        this("Spade", 1);
    }

    Card(String kind, int number) {
        this.kind = kind;
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("{static %d, static %d, %s, %d}", width, height, kind, number);
    }
}
