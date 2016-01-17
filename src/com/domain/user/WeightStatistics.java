package com.domain.user;

import com.domain.util.Statistic;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Nick on 15.11.2015.
 */
class WeightStatistics implements Statistic {
    private static List<Float> statistics;
    static {
        statistics = new ArrayList<Float>();
    }

    @Override
    public Float[] getStatistic(int i) {
        return (Float[])statistics.subList(0, i-1).toArray();
    }

    @Override
    public void addData(Object o) {
        addData((Float)o);
    }

    public void addData(Float f) {
        statistics.add(f);
    }
}
