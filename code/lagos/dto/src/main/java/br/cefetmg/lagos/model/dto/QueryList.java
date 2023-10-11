package br.cefetmg.lagos.model.dto;

import java.util.List;

public class QueryList<E> {
    private final List<E> list;
    private final Double sum;

    public QueryList(List<E> list) {
        this.list = list;
        sum = null;
    }

    public QueryList(List<E> set, Double sum) {
        this.list = set;
        this.sum = sum;
    }

    public Double getSum() {
        return sum;
    }

    public int getCount() {
        return list.size();
    }

    public List<E> getList() {
        return list;
    }
}
