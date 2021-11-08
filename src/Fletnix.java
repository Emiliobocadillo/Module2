import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Fletnix{
    // Instantiate String class for parameter for menu names
    String mainHeader =          "====== F L E T N I X  -  M A I N   M E N U ==============================================================================================================================================================================================\n";
    String userHeader =          "====== F L E T N I X  -  U S E R   M E N U =========================================================================================================================================================================================\n";
    String favoritesHeader =     "====== F L E T N I X  -  F A V O R I T E S =========================================================================================================================================================================================\n";
    String watchedHeader =       "====== F L E T N I X  -  W A T C H E D ===========================================================================================================================================================================================\n";
    String searchHeader =        "====== F L E T N I X  -  S E A R C H ===========================================================================================================================================================================================\n";
    String endOfMenu =           "\n==================================================================================================================================================================================================================================";
    String clear = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
    // Instantiate user class
    User currentUser;

    // Instantiate arraylist for main menu
    ArrayList<MenuItem> mainMenuItems;

    // Instantiate arraylist for user menu
    ArrayList<MenuItem> userMenuItems;

    // Instantiate arraylist for search menu
    ArrayList<MenuItem> searchMenuItems;

    // Instantiate arraylist for movies
    public ArrayList<Movie> movies;

    // Instantiate Keyboard class for input validation
    Keyboard kb = new Keyboard();
    // Library choice
    LibraryChoice lc = new LibraryChoice();


    // Clears screen
    public void clearScreen() {
        for (int i = 0; i < 50; i++)
            System.out.println();
    }


    // Method to Login
    public boolean login(){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your username and then press [Enter]: ");
        String username = input.nextLine();
        System.out.print("Enter your password and then press [Enter]: ");
        String password = input.nextLine();

        if(verifyLogin(username, password, "Users.txt")==true){
            currentUser = new User(username, password);
            System.out.println("Fletnix bot: You succesfully logged in! Welcome " + currentUser.getUsername() + "!\n");
            return true;
        }
        return false;
    }

    // Method to Verify Login credentials
    public boolean verifyLogin (String username, String password, String filepath){
        boolean found = false;
        String tempUsername= "";
        String tempPassword= "";
        Scanner x;

        try{
            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            while(x.hasNext() && !found){
                tempUsername = x.next();
                tempPassword = x.next();

                if (tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim())){
                    found =true;
                }
            }
            x.close();
            if (found==true){
            }
            else{
                System.out.println("Wrong username and/or password");
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return found;
    }

    // Method to write username and password to txt file
    public void writeUserInfoToTxtFile(String username, String password){
        try {
            FileWriter fw = new FileWriter("Users.txt", true);
            fw.write(username);
            fw.write(","+password+"\n");
            fw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to create new Account
    public void createNewAccount(){
        // methods from keyboard class
        String username = kb.getUsername("Enter desired username and press [Enter]: ");
        String password = kb.getPassword("Enter desired password and press [Enter]: ");

        //Constructor for User
        User user1 = new User(username, password);
        System.out.println("\n\nFletnix bot: You created a user with the following data ");
        System.out.println(user1+"\n");
        System.out.println("Fletnix bot: You can now log in\n");

        // Write username and password to txt file
        writeUserInfoToTxtFile(username, password);
    }

    // Method to complete user choice from main menu
    public void completeMainMenuChoice(int choice){
        switch (choice) {
            case 1:
                createNewAccount();
                break;
            case 2:
                if(login()==true){
                displayUserMenu();
                }
                break;
            case 3:
                System.out.println("See you soon (:");
                break;
            default:
                System.out.println("Invalid");
        }
    }

    // Method to display UserMenu
    public void displayUserMenu() {
        int choice;
        int back = userMenuItems.size();

        do{
            // Keeps displaying user menu until valid user input
            choice = kb.readInteger("Fletnix bot: You did not enter a valid menu option, try again", userMenuItems, userHeader);
            // pass valid user input to complete choice method which has switch statement
            completeUserMenuChoice(choice);
        }
        while(choice != back);
    }

    // Method to complete user choice from user menu
    private void completeUserMenuChoice(int choice) {
        switch (choice) {
            case 1:

                // 1. Show movie library
                choice = kb.readInteger("Fletnix bot: You did not enter a valid menu option, try again", movies, 1, movies.size()+1);
                //completeMovieLibraryChoice(choice);
                lc.completeMovieLibraryChoice(choice);
                if (choice != movies.size()+1){
                addToFavorites(movies.get(choice - 1), choice);
                movies.get(choice-1).setWatched(watched());
                currentUser.getWatchedMovies().add(movies.get(choice-1));
                }
                break;
            case 2:
                // 2. Show favorites if EMPTY
                if(currentUser.getFavoriteMovies().size()==0){
                    String emptyFavorites = "You don't have any movies added to your favorites\n";
                    kb.readInteger_BackToUserMenuFromEmptyFavoritesAndWatched(favoritesHeader, endOfMenu, emptyFavorites);

                }
                // 2. Show favorites if FULL
                else{
                    kb.readIntegerFavorites(currentUser, movies);
                }
                break;
            case 3:
                // 3. Show watched movies if EMPTY
                if(currentUser.getWatchedMovies().size()==0){
                    String emptyWatched = "You don't have any movies added to your Watched list\n";
                    kb.readInteger_BackToUserMenuFromEmptyFavoritesAndWatched(watchedHeader, endOfMenu, emptyWatched);

                }
                // 2. Show watched if FULL
                else{
                    kb.readInteger(currentUser);
                }
                break;
            case 4:
                // takes user to switch based on int choice between search for title, year, and actors
                choice = kb.readInteger("Fletnix bot: You did not enter a valid menu option, try again", searchMenuItems, searchHeader);
                completeSearchMenuChoice(choice);
                break;
            case 5:
                Random random = new Random();
                // Why not movies.size() as bound?
                int randomMovieChoice = random.nextInt(5)+1;
                lc.completeMovieLibraryChoice(randomMovieChoice);
                if (randomMovieChoice != movies.size()+1){
                    addToFavorites(movies.get(randomMovieChoice - 1), randomMovieChoice);
                    movies.get(randomMovieChoice-1).setWatched(watched());
                    currentUser.getWatchedMovies().add(movies.get(randomMovieChoice-1));
                }
                break;

            case 6:
                // Go back to main menu
                break;
            default:
                System.out.println("Invalid");
        }
    }

    private void completeSearchMenuChoice(int choice) {

        switch(choice){
            case 1:
                // Search by Title
                System.out.println("====== F L E T N I X  -  S E A R C H   B Y   T I T L E ===========================================================================================================================================================================================\n");
                System.out.print("Input keyword here and then press [Enter] to search movie Library: ");
                // Search function
                Scanner scanner = new Scanner(System.in);
                String userSearch= scanner.nextLine();
                ArrayList<Movie> moviesBasedOnSearch;
                moviesBasedOnSearch = searchByTitle(userSearch, movies);
                kb.readInteger_BackToUserMenuFromSearchTitle(moviesBasedOnSearch, userSearch, movies, currentUser);

                break;
            case 2:
                System.out.println("====== F L E T N I X  -  S E A R C H   B Y   Y E A R ===========================================================================================================================================================================================\n");

                // Search by Year
                System.out.println("\nFletnix bot: this feature comes with next update...");
                System.out.println(endOfMenu);
                break;
            case 3:
                System.out.println("====== F L E T N I X  -  S E A R C H   B Y   A C T O R S ===========================================================================================================================================================================================\n");
                // Search by actors

                System.out.println("\nFletnix bot: this feature comes with next update...");
                System.out.println(endOfMenu);

                break;
            case 4:
                // Back to user menu
                break;
            default:
                System.out.println("Invalid Input in completeSearchMenuChoice ");
        }
    }


 /*   // Martin
    public void searchByYear(int year) {
        if (year <= 1990) {
            System.out.println("\nThe movie is too old");
        } else {
            System.out.println("\nWe have the following movies from " + year);
            boolean foundMatch = false;
            for (Movie library : listOfMovies) {
                if (library.getYear() == year) {
                    System.out.println(library.getTitle());
                    foundMatch = true;
                }
            }
            if (!foundMatch) {
                System.out.println("There are no movies from that year");
            }
        }
    }*/
    // Martin
    public static ArrayList searchByTitle(String userSearch, ArrayList<Movie>movies) {
            ArrayList<Movie> moviesBasedOnSearch = new ArrayList<>();

            for (int i = 0; i < movies.size(); i++){
                String movieTitle;
                movieTitle = movies.get(i).getTitle();
                if (movieTitle.toLowerCase().contains(userSearch.toLowerCase())){
                    moviesBasedOnSearch.add(movies.get(i));
                }

            }
            return moviesBasedOnSearch;
    }

    // Method to add a movie to favorites
    public void addToFavorites (Movie movie, int choice){
        if (!currentUser.getFavoriteMovies().contains(movie)){
            int movieChoice = movies.indexOf(movies.get(choice-1));
            System.out.println("Add " + movies.get(choice-1)+ " to favorites?");
            choice = kb.readInteger("Fletnix bot: You did not enter a valid menu option, try again",1,2);
            switch (choice){
                case 1:
                    currentUser.getFavoriteMovies().add(movie);
                    System.out.println("Fletnix bot: "+movies.get(movieChoice) + " added to favorites");
                    break;
                case 2:
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    // Method to display the available movies
    public static void displayMovieLibrary(ArrayList<Movie> movies) {
        System.out.println("==== F L E T N I X  -  M O V I E  L I B R A R Y ======================================================================================================================================================================\n");
        for (int i =0; i< movies.size(); i++){
            System.out.println("Press " +  "["+ (i+1) +"]" + " and then [Enter] to play:  " + movies.get(i).toString() );
        }
        System.out.println("Press "+ "["+(movies.size()+1)+"]" + " and then [Enter] to go back to user menu");
        System.out.println("\n======================================================================================================================================================================================================================");

    }
    public Date watched() {
        // https://www.youtube.com/watch?v=A-1VXYkXOUY
        Date date = new Date();

        return date;
    }

    // Main method to run the program
    public void run() {
        // Initialize arraylist of menu items for main menu
        mainMenuItems = new ArrayList<>();
        mainMenuItems.add(new MenuItem("Create new account"));
        mainMenuItems.add(new MenuItem("Login to existing account"));
        mainMenuItems.add(new MenuItem("Exit"));

        // Initialize arraylist of menu items for user menu
        userMenuItems = new ArrayList<>();
        userMenuItems.add(new MenuItem("Show movie library"));
        userMenuItems.add(new MenuItem("Show favorites"));
        userMenuItems.add(new MenuItem("Show watched movies"));
        userMenuItems.add(new MenuItem("Search for movie"));
        userMenuItems.add(new MenuItem("Play random movie"));
        userMenuItems.add(new MenuItem("Go back to main menu"));

        // Initialize arraylist of menu for Search menu
        searchMenuItems = new ArrayList<>();
        searchMenuItems.add(new MenuItem("Search by title"));
        searchMenuItems.add(new MenuItem("Search by production year"));
        searchMenuItems.add(new MenuItem("Search by associated actors"));
        searchMenuItems.add(new MenuItem("Go Back to user menu"));

        // Initialize arraylists of actors
        ArrayList <Actor> actors1 = new ArrayList<>();
        actors1.add(new Actor("Tom Hanks", "Forrest Gump"));
        actors1.add(new Actor("Robin Wright", "Jenny Curran"));

        ArrayList <Actor> actors2 = new ArrayList<>();
        actors2.add(new Actor("Leonardo DiCaprio", "Jack Dawson"));
        actors2.add(new Actor("Kate Winslet", "Rose DeWitt Bukater"));

        ArrayList <Actor> actors3 = new ArrayList<>();
        actors3.add(new Actor("Henry Thomas", "Elliott"));
        actors3.add(new Actor("Drew Barrymore", "Gertie"));

        ArrayList <Actor> actors4 = new ArrayList<>();
        actors4.add(new Actor("Al Pacino", "Michael Corleone"));
        actors4.add(new Actor("Marlon Brando", "Don Vito Corleone"));

        ArrayList <Actor> actors5 = new ArrayList<>();
        actors5.add(new Actor("Arnold Schwarzenegger", "Terminator"));
        actors5.add(new Actor("Linda Hamilton", "Sarah Connor"));

        // Initialize arraylist of movies
        movies = new ArrayList<>();
        movies.add(new Movie("Forest Gump", 1994, actors1));
        movies.add(new Movie("Titanic", 1997, actors2));
        movies.add(new Movie("E.T. the Extra-Terrestrial", 1982, actors3));
        movies.add(new Movie("The Godfather", 1972, actors4));
        movies.add(new Movie("Terminator 2: Judgment Day", 1991, actors5));

        // User choice
        int choice;

        // Exit option
        int exit = mainMenuItems.size();

        do {
            // Keeps displaying main menu until valid user input
            choice = kb.readInteger("Fletnix bot: You did not enter a valid menu option, try again", mainMenuItems, mainHeader);
            // pass valid user input to complete choice method which has switch statement
            completeMainMenuChoice(choice);
        }
        while(choice != exit);
    }
}
