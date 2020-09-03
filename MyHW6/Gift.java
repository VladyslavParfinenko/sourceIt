package MyHW6;

import java.util.Arrays;
import java.util.Objects;

public class Gift {
    private static final int GIFT_CAPASITY = 5;
    private double weight;
    Sweet [] sweets;
    private int index;

    public void addSweet(Sweet sweet) {
        if (sweet == null) {
            return;
        }
        if (sweets == null) {
            sweets = new Sweet[GIFT_CAPASITY];
        }
        if (sweets.length < index + 1) {
            sweets = Arrays.copyOf(sweets, sweets.length * 2);
        }
        sweets[index++] = sweet;
    }

    public double weightCount(){
        return Arrays.stream(sweets)
                .mapToDouble(sweet -> sweet.getWeight())
                .sum();
    }

    public Sweet[] filterSugar(double minSugar, double maxSugar) {
        return Arrays.stream(sweets)
                .filter(Objects::nonNull)
                .filter( (sweet) -> {
                    if (sweet.getSugarWeight() >= minSugar &&
                            sweet.getSugarWeight() <= maxSugar) {
                        return true;
                    } else {
                        return false;
                    }
                })
                .toArray(MyHW6.Sweet[]::new);
    }

}
