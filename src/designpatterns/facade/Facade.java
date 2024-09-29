 package src.designpatterns.facade;

class CabBooking{
    public void cabBooked(){
        System.out.println("Cab has been booked");
    }
}

class HotelBooking{
    public void hotelBooked(){
        System.out.println("Hotel has been booked");
    }
}

class FlightBooking{

    public void flightBooked(){
        System.out.println("Flight has been booked");
    }

}

class TravelFacade{

    CabBooking cabBooking;
    FlightBooking flightBooking;
    HotelBooking hotelBooking;

    public void travelFacade(){
        this.cabBooking = new CabBooking();
        this.flightBooking = new FlightBooking();
        this.hotelBooking = new HotelBooking();
    }

    public void bookCompleteTrip(){
        cabBooking.cabBooked();
        flightBooking.flightBooked();
        hotelBooking.hotelBooked();
    }


}


public class Facade {

    public static void main(String[] args){

       TravelFacade travelFacade = new TravelFacade();
       travelFacade.bookCompleteTrip();

        
    }
    
}
