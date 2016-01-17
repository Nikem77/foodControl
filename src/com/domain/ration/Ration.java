package com.domain.ration;

/**
 * Created by Nick on 17.11.2015.
 */
public class Ration {
    /**
     * Food energy of main types of nutrients
     */
    public static final float       CARBOHYDRATES_FOODENERGY = 4.1f,
                                    FATS_FOODENERGY = 9.3f,
                                    PROTEINS_FOODENERGY = 3.8f,
                                    ALCOHOL_FOODENERGY = 7.1f,
                                    FIBER_FOODENERGY = 2,
                                    ASJOULE = 4.1868f;
    /**
     *  Ration norm in dependency of weight(kg, lb.)
     *
     */
    public static final Ration LOSEWEIGHT = new Ration(1, 2, 1),
                                    GETWEIGHT = new Ration(10, 20 ,30),
                                    NORMALWEIGHT = new Ration(1, 1, 1);

    private float carbohydrates,
                  fats,
                  proteins;

    public Ration(float carbohydrates, float fats, float proteins) {
        this.carbohydrates = carbohydrates;
        this.fats = fats;
        this.proteins = proteins;
    }

    @Override
    public String toString() {
        return "Ration{" +
                "carbohydrates=" + carbohydrates +
                ", fats=" + fats +
                ", proteins=" + proteins +
                '}';
    }
}

