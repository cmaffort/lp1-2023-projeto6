package br.cefetmg.lagos.util;

public class Pair<F, S> {
    private F first;
    private S second;

    public Pair(F f, S s) {
        first(f);
        second(s);
    }

    public void first(F f) {
        first = f;
    }

    public F first() {
        return first;
    }

    public void second(S s) {
        second = s;
    }

    public S second() {
        return second;
    }
}
