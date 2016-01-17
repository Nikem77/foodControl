package com.cotroller;

import com.domain.model.Model;
import com.domain.user.UserDataException;

import java.util.Date;

/**
 * Created by Nick on 24.11.2015.
 */
public class Controller {
    private static Controller ourInstance = new Controller();
    private static Model model;
    static {
        model = Model.getModel();
    }

    public static Controller getInstance() {
        return ourInstance;
    }

    private Controller() {
    }

    public void newUser(String name, Date date) {
        try {
            model.createNewUser(name, date);
        } catch (Exception e) {
            System.err.println("Controller error: " + e.getMessage());
        }
    }

    public void setTall(short tall) {
        model.getCurrentUser().setTall(tall);
    }

    public short getTall() {
        try {
            return model.getCurrentUser().getTall();
        } catch (UserDataException e) {
            System.err.println("Controller error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("model is null");
        }
        return 0;
    }

    public void setWeight(float weight) {
        model.getCurrentUser().setWeight(weight);
    }

    public int getWeight() {
        try {
            return model.getCurrentUser().getWeight();
        } catch (UserDataException e) {
            System.err.println("Controller error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("model is null");
        }
        return 0;
    }
}
