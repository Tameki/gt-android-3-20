package com.geektech.boredapp_20.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "bored_action")
public class BoredAction implements Parcelable {

    @SerializedName("key")
    @ColumnInfo(name = "uuid")
    @PrimaryKey
    @NonNull
    private String key;

    @SerializedName("activity")
    @ColumnInfo(name = "activity")
    private String activity;

    @SerializedName("type")
    @ColumnInfo(name = "type")
    private String type;

    @SerializedName("participants")
    @ColumnInfo(name = "participants")
    private Integer participants;

    @SerializedName("price")
    @ColumnInfo(name = "price")
    private Float price;

    @SerializedName("link")
    @ColumnInfo(name = "link")
    private String link;

    @SerializedName("accessibility")
    @ColumnInfo(name = "accessibility")
    private Float accessibility;

    public BoredAction(String key, String activity, String type, Integer participants, Float price, String link, Float accessibility) {
        this.key = key;
        this.activity = activity;
        this.type = type;
        this.participants = participants;
        this.price = price;
        this.link = link;
        this.accessibility = accessibility;
    }

    protected BoredAction(Parcel in) {
        key = in.readString();
        activity = in.readString();
        type = in.readString();
        if (in.readByte() == 0) {
            participants = null;
        } else {
            participants = in.readInt();
        }
        if (in.readByte() == 0) {
            price = null;
        } else {
            price = in.readFloat();
        }
        link = in.readString();
        if (in.readByte() == 0) {
            accessibility = null;
        } else {
            accessibility = in.readFloat();
        }
    }

    public static final Creator<BoredAction> CREATOR = new Creator<BoredAction>() {
        @Override
        public BoredAction createFromParcel(Parcel in) {
            return new BoredAction(in);
        }

        @Override
        public BoredAction[] newArray(int size) {
            return new BoredAction[size];
        }
    };

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getParticipants() {
        return participants;
    }

    public void setParticipants(Integer participants) {
        this.participants = participants;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Float getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(Float accessibility) {
        this.accessibility = accessibility;
    }

    @Override
    public String toString() {
        return "BoredAction{" +
                "key='" + key + '\'' +
                ", activity='" + activity + '\'' +
                ", type='" + type + '\'' +
                ", participants=" + participants +
                ", price=" + price +
                ", link='" + link + '\'' +
                ", accessibility=" + accessibility +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(key);
        dest.writeString(activity);
        dest.writeString(type);
        if (participants == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(participants);
        }
        if (price == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(price);
        }
        dest.writeString(link);
        if (accessibility == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(accessibility);
        }
    }
}
