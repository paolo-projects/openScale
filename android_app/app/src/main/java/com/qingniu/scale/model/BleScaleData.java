package com.qingniu.scale.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;

public class BleScaleData implements Parcelable {
    public static final Creator<BleScaleData> CREATOR = new Creator<BleScaleData>() {
        public BleScaleData createFromParcel(Parcel parcel) {
            return new BleScaleData(parcel);
        }

        public BleScaleData[] newArray(int i) {
            return new BleScaleData[i];
        }
    };
    private double bmi;
    private int bmr;
    private int bodyAge;
    private int bodyShape;
    private double bodyfat;
    private double bone;
    private double fatLF;
    private double fatLH;
    private double fatRF;
    private double fatRH;
    private double fatT;
    private boolean hasMeasured;
    private double heartIndex;
    private int heartRate = -1;
    private double lbm;
    private double leftWeight;
    private String mac;
    private Date measureTime;
    private int method = 4;
    private double muscle;
    private double muscleLF;
    private double muscleLH;
    private double muscleMass;
    private double muscleRF;
    private double muscleRH;
    private double muscleT;
    private double paunch;
    private double protein;
    private int resistance50;
    private int resistance500;
    private int resistanceState;
    private double score;
    private double subfat;
    private int trueResistance50;
    private int trueResistance500;
    private int visfat;
    private double water;
    private double weight;

    static {
        try {
            System.loadLibrary("qnscalc");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
    }

    public BleScaleData() {
    }

    protected BleScaleData(Parcel parcel) {
        this.mac = parcel.readString();
        this.resistance50 = parcel.readInt();
        this.resistance500 = parcel.readInt();
        long readLong = parcel.readLong();
        this.measureTime = readLong == -1 ? null : new Date(readLong);
        this.hasMeasured = parcel.readByte() != 0;
        this.method = parcel.readInt();
        this.trueResistance50 = parcel.readInt();
        this.trueResistance500 = parcel.readInt();
        this.leftWeight = parcel.readDouble();
        this.resistanceState = parcel.readInt();
        this.heartRate = parcel.readInt();
        this.weight = parcel.readDouble();
        this.bodyfat = parcel.readDouble();
        this.subfat = parcel.readDouble();
        this.visfat = parcel.readInt();
        this.water = parcel.readDouble();
        this.bmr = parcel.readInt();
        this.bodyAge = parcel.readInt();
        this.muscle = parcel.readDouble();
        this.muscleMass = parcel.readDouble();
        this.bmi = parcel.readDouble();
        this.bone = parcel.readDouble();
        this.lbm = parcel.readDouble();
        this.protein = parcel.readDouble();
        this.score = parcel.readDouble();
        this.bodyShape = parcel.readInt();
        this.heartIndex = parcel.readDouble();
        this.muscleRH = parcel.readDouble();
        this.muscleLH = parcel.readDouble();
        this.muscleT = parcel.readDouble();
        this.muscleRF = parcel.readDouble();
        this.muscleLF = parcel.readDouble();
        this.fatRH = parcel.readDouble();
        this.fatLH = parcel.readDouble();
        this.fatT = parcel.readDouble();
        this.fatRF = parcel.readDouble();
        this.fatLF = parcel.readDouble();
        this.paunch = parcel.readDouble();
    }

    public native int calcBodyShape(double d, double d2, int i);

    public native double calcHeartIndex(int i, int i2, int i3, double d, int i4);

    public int describeContents() {
        return 0;
    }

    public double getBmi() {
        return this.bmi;
    }

    public int getBmr() {
        return this.bmr;
    }

    public int getBodyAge() {
        return this.bodyAge;
    }

    public int getBodyShape() {
        return this.bodyShape;
    }

    public double getBodyfat() {
        return this.bodyfat;
    }

    public double getBone() {
        return this.bone;
    }

    public double getFatLF() {
        return this.fatLF;
    }

    public double getFatLH() {
        return this.fatLH;
    }

    public double getFatRF() {
        return this.fatRF;
    }

    public double getFatRH() {
        return this.fatRH;
    }

    public double getFatT() {
        return this.fatT;
    }

    public double getHeartIndex() {
        return this.heartIndex;
    }

    public int getHeartRate() {
        return this.heartRate;
    }

    public double getLbm() {
        return this.lbm;
    }

    public double getLeftWeight() {
        return this.leftWeight;
    }

    public String getMac() {
        return this.mac;
    }

    public Date getMeasureTime() {
        return this.measureTime;
    }

    public int getMethod() {
        return this.method;
    }

    public double getMuscle() {
        return this.muscle;
    }

    public double getMuscleLF() {
        return this.muscleLF;
    }

    public double getMuscleLH() {
        return this.muscleLH;
    }

    public double getMuscleMass() {
        return this.muscleMass;
    }

    public double getMuscleRF() {
        return this.muscleRF;
    }

    public double getMuscleRH() {
        return this.muscleRH;
    }

    public double getMuscleT() {
        return this.muscleT;
    }

    public double getPaunch() {
        return this.paunch;
    }

    public double getProtein() {
        return this.protein;
    }

    public int getResistance50() {
        return this.resistance50;
    }

    public int getResistance500() {
        return this.resistance500;
    }

    public int getResistanceState() {
        return this.resistanceState;
    }

    public double getScore() {
        return this.score;
    }

    public double getSubfat() {
        return this.subfat;
    }

    public int getTrueResistance50() {
        return this.trueResistance50;
    }

    public int getTrueResistance500() {
        return this.trueResistance500;
    }

    public int getVisfat() {
        return this.visfat;
    }

    public double getWater() {
        return this.water;
    }

    public double getWeight() {
        return this.weight;
    }

    public void init(int method, int height, int age, int gender, int athleteType) {
        initWithAthlete(method, height, age, gender, athleteType);
    }

    public native void initWithAthlete(int method, int height, int age, int gender, int athleteType);

    public boolean isHasMeasured() {
        return this.hasMeasured;
    }

    public void setBodyfat(double d) {
        this.bodyfat = d;
    }

    public void setFatLF(double d) {
        this.fatLF = d;
    }

    public void setFatLH(double d) {
        this.fatLH = d;
    }

    public void setFatRF(double d) {
        this.fatRF = d;
    }

    public void setFatRH(double d) {
        this.fatRH = d;
    }

    public void setFatT(double d) {
        this.fatT = d;
    }

    public void setHasMeasured(boolean z) {
        this.hasMeasured = z;
    }

    public void setHeartIndex(double d) {
        this.heartIndex = d;
    }

    public void setHeartRate(int i) {
        this.heartRate = i;
    }

    public void setLeftWeight(double d) {
        this.leftWeight = d;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setMeasureTime(Date date) {
        this.measureTime = date;
    }

    public void setMethod(int i) {
        this.method = i;
    }

    public void setMuscleLF(double d) {
        this.muscleLF = d;
    }

    public void setMuscleLH(double d) {
        this.muscleLH = d;
    }

    public void setMuscleRF(double d) {
        this.muscleRF = d;
    }

    public void setMuscleRH(double d) {
        this.muscleRH = d;
    }

    public void setMuscleT(double d) {
        this.muscleT = d;
    }

    public void setPaunch(double d) {
        this.paunch = d;
    }

    public void setResistance50(int i) {
        this.resistance50 = i;
    }

    public void setResistance500(int i) {
        this.resistance500 = i;
    }

    public void setResistanceState(int i) {
        this.resistanceState = i;
    }

    public void setTrueResistance50(int i) {
        this.trueResistance50 = i;
    }

    public void setTrueResistance500(int i) {
        this.trueResistance500 = i;
    }

    public void setWeight(double d) {
        this.weight = d;
    }

    public String toString() {
        return "BleScaleData{mac='" + this.mac + '\'' + ", resistance50=" + this.resistance50 + ", resistance500=" + this.resistance500 + ", measureTime=" + this.measureTime + ", hasMeasured=" + this.hasMeasured + ", method=" + this.method + ", trueResistance50=" + this.trueResistance50 + ", trueResistance500=" + this.trueResistance500 + ", leftWeight=" + this.leftWeight + ", resistanceState=" + this.resistanceState + ", heartRate=" + this.heartRate + ", weight=" + this.weight + ", bodyfat=" + this.bodyfat + ", subfat=" + this.subfat + ", visfat=" + this.visfat + ", water=" + this.water + ", bmr=" + this.bmr + ", bodyAge=" + this.bodyAge + ", muscle=" + this.muscle + ", muscleMass=" + this.muscleMass + ", bmi=" + this.bmi + ", bone=" + this.bone + ", lbm=" + this.lbm + ", protein=" + this.protein + ", score=" + this.score + ", bodyShape=" + this.bodyShape + ", heartIndex=" + this.heartIndex + ", muscleRH=" + this.muscleRH + ", muscleLH=" + this.muscleLH + ", muscleT=" + this.muscleT + ", muscleRF=" + this.muscleRF + ", muscleLF=" + this.muscleLF + ", fatRH=" + this.fatRH + ", fatLH=" + this.fatLH + ", fatT=" + this.fatT + ", fatRF=" + this.fatRF + ", fatLF=" + this.fatLF + ", paunch=" + this.paunch + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mac);
        parcel.writeInt(this.resistance50);
        parcel.writeInt(this.resistance500);
        parcel.writeLong(this.measureTime != null ? this.measureTime.getTime() : -1);
        parcel.writeByte(this.hasMeasured ? (byte) 1 : 0);
        parcel.writeInt(this.method);
        parcel.writeInt(this.trueResistance50);
        parcel.writeInt(this.trueResistance500);
        parcel.writeDouble(this.leftWeight);
        parcel.writeInt(this.resistanceState);
        parcel.writeInt(this.heartRate);
        parcel.writeDouble(this.weight);
        parcel.writeDouble(this.bodyfat);
        parcel.writeDouble(this.subfat);
        parcel.writeInt(this.visfat);
        parcel.writeDouble(this.water);
        parcel.writeInt(this.bmr);
        parcel.writeInt(this.bodyAge);
        parcel.writeDouble(this.muscle);
        parcel.writeDouble(this.muscleMass);
        parcel.writeDouble(this.bmi);
        parcel.writeDouble(this.bone);
        parcel.writeDouble(this.lbm);
        parcel.writeDouble(this.protein);
        parcel.writeDouble(this.score);
        parcel.writeInt(this.bodyShape);
        parcel.writeDouble(this.heartIndex);
        parcel.writeDouble(this.muscleRH);
        parcel.writeDouble(this.muscleLH);
        parcel.writeDouble(this.muscleT);
        parcel.writeDouble(this.muscleRF);
        parcel.writeDouble(this.muscleLF);
        parcel.writeDouble(this.fatRH);
        parcel.writeDouble(this.fatLH);
        parcel.writeDouble(this.fatT);
        parcel.writeDouble(this.fatRF);
        parcel.writeDouble(this.fatLF);
        parcel.writeDouble(this.paunch);
    }
}