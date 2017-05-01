package com.fractals.cinemanight.structural.design;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

import com.fractals.cinemanight.BR;

public class Movie extends BaseObservable implements Parcelable{

	private String id;
	private String title;
	private String posterUrl;
	private String genres;
    private String internationalOpeningDate;
    // Optional fields
    private String description;
    private String budget;
    private String cinemaOpeningDate;
	private String removalDate;
	private String playingDates;
	private double ticketPrice;

    public Movie(String id, String title, String posterUrl, String description, String genres, String internationalOpeningDate) {
        this.id = id;
        this.title = title;
        this.posterUrl = posterUrl;
        this.description = description;
        this.genres = genres;
        this.internationalOpeningDate = internationalOpeningDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getInternationalOpeningDate() {
        return internationalOpeningDate;
    }

    public void setInternationalOpeningDate(String internationalOpeningDate) {
        this.internationalOpeningDate = internationalOpeningDate;
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(BR.description);
    }

    @Bindable
    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
        notifyPropertyChanged(BR.budget);
    }

    @Bindable
    public String getCinemaOpeningDate() {
        return cinemaOpeningDate;
    }

    public void setCinemaOpeningDate(String cinemaOpeningDate) {
        this.cinemaOpeningDate = cinemaOpeningDate;
        notifyPropertyChanged(BR.cinemaOpeningDate);
    }

    @Bindable
    public String getRemovalDate() {
        return removalDate;
    }

    public void setRemovalDate(String removalDate) {
        this.removalDate = removalDate;
        notifyPropertyChanged(BR.removalDate);
    }

    @Bindable
    public String getPlayingDates() {
        return playingDates;
    }

    public void setPlayingDates(String playingDates) {
        this.playingDates = playingDates;
        notifyPropertyChanged(BR.playingDates);
    }

    @Bindable
    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
        notifyPropertyChanged(BR.ticketPrice);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(title);
        parcel.writeString(posterUrl);
        parcel.writeString(genres);
        parcel.writeString(internationalOpeningDate);
        parcel.writeString(description);
        parcel.writeString(budget);
        parcel.writeString(cinemaOpeningDate);
        parcel.writeString(removalDate);
        parcel.writeString(playingDates);
        parcel.writeDouble(ticketPrice);
    }

    protected Movie(Parcel in) {
        id = in.readString();
        title = in.readString();
        posterUrl = in.readString();
        genres = in.readString();
        internationalOpeningDate = in.readString();
        description = in.readString();
        budget = in.readString();
        cinemaOpeningDate = in.readString();
        removalDate = in.readString();
        playingDates = in.readString();
        ticketPrice = in.readDouble();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

}