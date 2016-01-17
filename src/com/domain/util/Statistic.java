package com.domain.util;

/**
 * Created by Nick on 15.11.2015.
 *
 */
public interface Statistic<T> {

    T[] getStatistic(int i);

    void addData(T t);
}
