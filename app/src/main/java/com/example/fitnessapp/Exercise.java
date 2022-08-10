package com.example.fitnessapp;
import android.os.Parcel;
import android.os.Parcelable;

public class Exercise implements Parcelable{

    private String mType;
    private String mExerciseName;
    private int mImageResourceID;

    public Exercise(String vType, String vExerciseName, int vImageResourceID) {

        mType = vType;
        mExerciseName = vExerciseName;
        mImageResourceID = vImageResourceID;
    }

    public static String TYPE = "exercise";

    public Exercise(Parcel in) {
        mType = in.readString();
        mExerciseName = in.readString();
        mImageResourceID  = in.readInt();

    }

    public static final Creator<Exercise> CREATOR = new Creator<Exercise>() {
        @Override
        public Exercise createFromParcel(Parcel in) {
            return new Exercise(in);
        }

        @Override
        public Exercise[] newArray(int size) {
            return new Exercise[size];
        }
    };

    @Override
    public void writeToParcel(Parcel out, int i)
    {
        out.writeString(mType);
        out.writeString(mExerciseName);
        out.writeInt(mImageResourceID);

    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getExerciseName () {
        return mExerciseName;
    }
    public int getImageResourceID () {
        return mImageResourceID;
    }
}
