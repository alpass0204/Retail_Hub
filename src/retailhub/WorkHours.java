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

    //getters/setters
    public LocalDate getDate() {
        return date;
    }


    public void setDate(LocalDate date) {
        this.date = date;
    }


    public LocalTime getArrivalTime() {
        return arrivalTime;
    }


    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }


    public LocalTime getDepartureTime() {
        return departureTime;
    }


    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    //duration between arrival and departure
    public Duration getDuration() {
        return Duration.between(arrivalTime,departureTime);
    }


}