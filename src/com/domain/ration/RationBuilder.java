package com.domain.ration;

/**
 * Created by Nick on 17.11.2015.
 */
public class RationBuilder {
    private Ration ration;

    public RationBuilder(Ration ration) {
        this.ration = ration;
    }

    public static Ration buildRation(Ration dailyRation) {
        return new Ration(1, 1, 1);
    }
}
