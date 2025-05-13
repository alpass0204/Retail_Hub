package retailhub;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;


public class WorkHours {
    //fields
    private LocalDate date;
    private LocalTime arrivalTime;
    private LocalTime departureTime;


    //constructor
    public WorkHours(LocalDate date,LocalTime arrivalTime,LocalTime departureTime) {
        this.date = date;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;

    }


    //constructor
    public WorkHours() {
        this.date = LocalDate.now();
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;

    }
    //getters/setters
    public LocalDate getDate() {
        return date;
    }


    public void setDate(LocalDate date) {
        this.date = LocalDate.now();
    }


    public LocalTime getArrivalTime() {
        return this.arrivalTime;
    }


    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = LocalTime.now();
    }


    public LocalTime getDepartureTime() {
        return this.departureTime;
    }


    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime =  LocalTime.now();
    }

    //duration between arrival and departure
    public Duration getDuration() {
        return Duration.between(getArrivalTime(),getDepartureTime());
    }


}