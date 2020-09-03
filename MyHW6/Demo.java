package MyHW6;

import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
        Sweet candy = new Candy();
        candy.setName("Чупик");
        candy.setSugarWeight(0.25);
        candy.setWeight(1);

        Sweet chokolateCandy = new ChocolateCandy();
        chokolateCandy.setName("Ромашка");
        chokolateCandy.setWeight(1);
        chokolateCandy.setSugarWeight(0.35);

        Sweet chocolate = new Chocolate();
        chocolate.setName("Корона");
        chocolate.setSugarWeight(0.70);
        chocolate.setWeight(4);

        Gift podarok = new Gift();
        podarok.addSweet(candy);
        podarok.addSweet(chokolateCandy);
        podarok.addSweet(chocolate);

        Sweet [] filteredSweets = podarok.filterSugar(0.2,0.4);
        System.out.println(Arrays.toString(filteredSweets));

        podarok.weightCount();

    }
}
