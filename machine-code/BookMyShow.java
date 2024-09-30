import java.util.*;

// User class to represent a user of the booking system
class User {
    private String name;
    private String email;
    private String phone;
    private String password;
    private List<Booking> bookings;

    public User(String name, String email, String phone, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.bookings = new ArrayList<>();
    }

    public boolean login(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    public void viewBookingHistory() {
        for (Booking booking : bookings) {
            System.out.println("Booking: " + booking.getShow().getMovie().getTitle() +
                    ", Seats: " + booking.getSeats().size() + ", Paid: " + booking.isPaid());
        }
    }

    public void makeBooking(Booking booking) {
        bookings.add(booking);
    }
}

// Movie class to represent movies
class Movie {
    private String title;
    private String genre;
    private String language;
    private int duration;
    private List<Show> shows;

    public Movie(String title, String genre, String language, int duration) {
        this.title = title;
        this.genre = genre;
        this.language = language;
        this.duration = duration;
        this.shows = new ArrayList<>();
    }

    public void addShow(Show show) {
        this.shows.add(show);
    }

    public String getTitle() {
        return title;
    }

    public List<Show> getShows() {
        return shows;
    }
}

// Theater class to represent theaters
class Theater {
    private String name;
    private String location;
    private List<Screen> screens;

    public Theater(String name, String location) {
        this.name = name;
        this.location = location;
        this.screens = new ArrayList<>();
    }

    public void addScreen(Screen screen) {
        this.screens.add(screen);
    }

    public List<Screen> getScreens() {
        return screens;
    }
}

// Screen class to represent screens in a theater
class Screen {
    private int screenNumber;
    private int totalSeats;
    private List<Show> shows;

    public Screen(int screenNumber, int totalSeats) {
        this.screenNumber = screenNumber;
        this.totalSeats = totalSeats;
        this.shows = new ArrayList<>();
    }

    public void addShow(Show show) {
        shows.add(show);
    }

    public List<Show> getShows() {
        return shows;
    }
}

// Show class representing a specific movie at a certain time on a screen
class Show {
    private Movie movie;
    private Screen screen;
    private String showTime;
    private int availableSeats;
    private List<Seat> bookedSeats;

    public Show(Movie movie, Screen screen, String showTime, int availableSeats) {
        this.movie = movie;
        this.screen = screen;
        this.showTime = showTime;
        this.availableSeats = availableSeats;
        this.bookedSeats = new ArrayList<>();
    }

    public Movie getMovie() {
        return movie;
    }

    public String getShowTime() {
        return showTime;
    }

    public boolean bookSeats(List<Seat> seats) {
        if (seats.size() <= availableSeats) {
            availableSeats -= seats.size();
            bookedSeats.addAll(seats);
            return true;
        }
        return false;
    }
}

// Seat class representing individual seats
class Seat {
    private int seatNumber;
    private boolean isBooked;

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.isBooked = false;
    }

    public void book() {
        this.isBooked = true;
    }

    public boolean isBooked() {
        return isBooked;
    }
}

// Booking class handling seat booking for a specific show
class Booking {
    private User user;
    private Show show;
    private List<Seat> seats;
    private double totalPrice;
    private boolean isPaid;

    public Booking(User user, Show show, List<Seat> seats) {
        this.user = user;
        this.show = show;
        this.seats = seats;
        this.totalPrice = seats.size() * 200;
        this.isPaid = false;
    }

    public boolean makePayment(Payment payment) {
        if (payment.processPayment(totalPrice)) {
            this.isPaid = true;
            show.bookSeats(seats);
            user.makeBooking(this);
            return true;
        }
        return false;
    }

    public Show getShow() {
        return show;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public boolean isPaid() {
        return isPaid;
    }
}

// Payment class handling the payment process
class Payment {
    private String paymentMethod;

    public Payment(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " via " + paymentMethod);
        return true; // Simulating successful payment
    }
}

// Main BookMyShow class containing the application logic
public class BookMyShow {

    private static Map<String, User> users = new HashMap<>();
    private static List<Movie> movies = new ArrayList<>();
    private static List<Theater> theaters = new ArrayList<>();

    public static void main(String[] args) {
        // Add some users
        users.put("user1", new User("User One", "user1@example.com", "1234567890", "password1"));
        users.put("user2", new User("User Two", "user2@example.com", "0987654321", "password2"));

        // Add some movies
        Movie movie1 = new Movie("Inception", "Sci-Fi", "English", 120);
        Movie movie2 = new Movie("Interstellar", "Sci-Fi", "English", 150);
        movies.add(movie1);
        movies.add(movie2);

        // Add a theater and screens
        Theater theater1 = new Theater("PVR Cinemas", "Location 1");
        Screen screen1 = new Screen(1, 100);
        Screen screen2 = new Screen(2, 80);
        theater1.addScreen(screen1);
        theater1.addScreen(screen2);
        theaters.add(theater1);

        // Add shows to screens
        Show show1 = new Show(movie1, screen1, "6:30 PM", 100);
        Show show2 = new Show(movie2, screen2, "8:30 PM", 80);
        screen1.addShow(show1);
        screen2.addShow(show2);
        movie1.addShow(show1);
        movie2.addShow(show2);

        // User login
        User loggedInUser = users.get("user1");
        if (loggedInUser.login("user1@example.com", "password1")) {
            System.out.println("Login successful!");

            // Booking a show
            List<Seat> selectedSeats = new ArrayList<>();
            selectedSeats.add(new Seat(1));
            selectedSeats.add(new Seat(2));

            Booking booking = new Booking(loggedInUser, show1, selectedSeats);
            Payment payment = new Payment("Credit Card");
            if (booking.makePayment(payment)) {
                System.out.println("Booking successful!");
            }

            // View booking history
            loggedInUser.viewBookingHistory();
        } else {
            System.out.println("Invalid login credentials!");
        }
    }
}
