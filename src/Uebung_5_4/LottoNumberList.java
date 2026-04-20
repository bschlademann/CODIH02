package Uebung_5_4;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class LottoNumberList {
    private List<Integer> list;

    public LottoNumberList(int max) {
        this.list = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            list.add(i);
        }
    }

    public LottoNumberList shuffle(int n) {
        for (int i = 0; i < n; i++) {
            int a = getRandomNumber(0, this.list.size());
            int b = getRandomNumber(0, this.list.size());

            Collections.swap(list, a, b);
        }
//        returns the whole object so the result can be method-chained to .draw()
        return this;
    }

    private int getRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    public List<Integer> drawAndSort(int n) {
        List<Integer> subList = this.list.subList(0, n);
        Collections.sort(subList);
        return subList;
    }
}
