package com.domain.user;

import com.domain.ration.Ration;

import java.io.*;
import java.util.Date;

/**
 * Created by Nick on 15.11.2015.
 */
public class User implements Serializable{
    private String name = "";
    private Date birthDate;
    private short tall = 0;
    private float weight = 0f;
    private WeightStatistics weightStatistic;
    private Ration dailyRation;
    private File profile;

    public User(String name) {
        this.name = name;
    }

    public Ration getDailyRation() {
        return dailyRation;
    }

    public void setDailyRation(Ration dailyRation) {
        this.dailyRation = dailyRation;
    }

    public User() {
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public User(String name, Date birthDate, short tall, float weight, Ration ration) {
        this.name = name;
        this.birthDate = birthDate;

        this.tall = tall;
        this.weight = weight;
        profile = new File("com/res/" + getName() + getBirthDate());
        dailyRation = ration;
//        writeToFile(profile);
    }

    public String getName() throws UserDataException {
        if(name != null)
            return name;
        else throw new UserDataException("Empty name field");
    }

    public void setName(String name) {
        this.name = name;
    }



    public short getTall() throws UserDataException {
        if (tall > 0)
            return tall;
        else throw new UserDataException("Empty tall field");
    }

    public void setTall(short tall) {
        this.tall = tall;
    }


    public int getWeight() throws UserDataException {
        if (weight != 0)
            return Float.floatToIntBits(weight);
        else throw new UserDataException("Empty weight field");
    }

    public void setWeight(float weight) {
        this.weight = weight;
        weightStatistic.addData(weight);
    }

    private boolean writeToFile(File file) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(this.toString());
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public WeightStatistics getWeightStatistic() {
        return weightStatistic;
    }

    public void setWeightStatistic(WeightStatistics weightStatistic) {
        this.weightStatistic = weightStatistic;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Name: ")
                .append(getName()).append("//n//r")
                .append("Birthed: ").append(getBirthDate()).append("//r//n")
                .append("Tall: ").append(getTall()).append("//r//n")
                .append("Current weight: ").append(getWeight()).append("//r//n")
                .append("Daily ration: ").append(getDailyRation());
        return builder.toString();
    }
}