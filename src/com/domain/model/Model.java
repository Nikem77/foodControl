package com.domain.model;

import com.domain.ration.Ration;
import com.domain.ration.RationBuilder;
import com.domain.user.User;
import com.domain.util.Statistic;

import java.util.Date;

/**
 * Main program core. Method set create and control users data.
 */
public class Model {

    private static User currentUser;
    private Statistic weightStat;
    Ration currentUserRation = RationBuilder.buildRation(currentUser.getDailyRation());
    private static volatile Model instance;

    /**
     *
     * @return model
     * Builds with Singleton pattern optimizied for multithread usage
     */
    public static Model getModel() {
        Model localInstance = instance;
        try {
            if (localInstance == null) {
                synchronized (Model.class) {
                    localInstance = instance;
                    if (localInstance == null) {
                        instance = localInstance = new Model();
                        createNewUser();
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return localInstance;
    }

    private static void createNewUser() {
        currentUser = new User();
    }

    private Model() {
    }

    public Ration getCurrentUserRation() {
        return currentUserRation;
    }

    public void setCurrentUserRation(Ration currentUserRation) {
        this.currentUserRation = currentUserRation;
    }

    public User getCurrentUser() {
        if (currentUser == null)
            createNewUser();
            return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public Statistic getWeightStat() {
        return weightStat;
    }

    public void setWeightStat(Statistic weightStat) {
        this.weightStat = weightStat;
    }

    public void createNewUser(String name, Date date) {
        currentUser = new User(name);
        currentUser.setBirthDate(date);
    }
}
