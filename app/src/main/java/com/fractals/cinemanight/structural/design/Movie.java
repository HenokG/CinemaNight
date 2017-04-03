package com.fractals.cinemanight.structural.design;

public class Movie {

	private String id;
	private String title;
	private String posterUrl;
	private String description;
	private String[] genres;
	private String internationalOpeningDate;
	// Optional fields
	private String budget;
	private String cinemaOpeningDate;
	private String removalDate;
	private String playingDates;
	private long ticketPrice;

    public Movie(String id, String title, String posterUrl, String description, String[] genres, String internationalOpeningDate) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public String getInternationalOpeningDate() {
        return internationalOpeningDate;
    }

    public void setInternationalOpeningDate(String internationalOpeningDate) {
        this.internationalOpeningDate = internationalOpeningDate;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getCinemaOpeningDate() {
        return cinemaOpeningDate;
    }

    public void setCinemaOpeningDate(String cinemaOpeningDate) {
        this.cinemaOpeningDate = cinemaOpeningDate;
    }

    public String getRemovalDate() {
        return removalDate;
    }

    public void setRemovalDate(String removalDate) {
        this.removalDate = removalDate;
    }

    public String getPlayingDates() {
        return playingDates;
    }

    public void setPlayingDates(String playingDates) {
        this.playingDates = playingDates;
    }

    public long getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(long ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}