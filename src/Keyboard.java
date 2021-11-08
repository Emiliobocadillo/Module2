import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
public class Keyboard {

    //Data member also called attribute
    private Scanner input;

    //Constructor
    public Keyboard(){
        input = new Scanner(System.in);
    }

    // Date
    public Date watched() {
        // https://www.youtube.com/watch?v=A-1VXYkXOUY
        Date date = new Date();

        return date;
    }

    // Method 1 to read integer values with inclusive range
    public int readInteger(String errorMsg, ArrayList<MenuItem>items, String menuName){
        int num = 0;
        String strInput;
        boolean valid = false;
        int low = 1;
        int high = items.size();

        //Keep looping until valid input
        while(valid == false){
            // prompt user
            displayMenu(items, menuName);
            System.out.print("Enter here: ");
            //Grab input from keyboard
            strInput = input.nextLine();
            //try to convert String to int
            try {
                num = Integer.parseInt(strInput);
                if (num >= low && num <= high){
                    valid = true;
                }
                else {
                    System.out.println(errorMsg);
                }
            }
            catch (NumberFormatException e){
                System.out.println(errorMsg);
            }
        }
        return num;
    }

    // Method 2 to read integer values without display menu items
    public int readInteger(String errorMsg, ArrayList<Movie> movies, int low, int high){
        int num = 0;
        String strInput;
        boolean valid = false;


        //Keep looping until valid input
        while(valid == false){
            // prompt user
            Fletnix.displayMovieLibrary(movies);
            System.out.print("Enter here: ");
            //Grab input from keyboard
            strInput = input.nextLine();
            //try to convert String to int
            try {
                num = Integer.parseInt(strInput);
                if (num >= low && num <= high){
                    valid = true;
                }
                else {
                    System.out.println(errorMsg);
                }
            }
            catch (NumberFormatException e){
                System.out.println(errorMsg);
            }
        }
        return num;
    }

    // Method 3 to read integer values without display menu items, used in addToFavorites()
    public int readInteger(String errorMsg, int low, int high){
        int num = 0;
        String strInput;
        boolean valid = false;


        //Keep looping until valid input
        while(valid == false){
            // prompt user
            System.out.println("Press [1] and then [Enter] to add to favorites");
            System.out.println("Press [2] and then [Enter] to go Back to user menu");
            System.out.println("=====================================================================================================================================================================================================================================================");
            System.out.print("Enter here: ");
            //Grab input from keyboard
            strInput = input.nextLine();
            //try to convert String to int
            try {
                num = Integer.parseInt(strInput);
                if (num >= low && num <= high){
                    valid = true;
                }
                else {
                    System.out.println(errorMsg);
                }
            }
            catch (NumberFormatException e){
                System.out.println(errorMsg);
            }
        }
        return num;
    }

    // Method 4 to get back to user menu from watched movies
    public void readInteger(User currentUser) {
        int num;
        String strInput;
        boolean valid = false;

        while(valid == false){
            //Prompt user
            currentUser.displayWatchedMoviesMenu();
            System.out.print("Enter here: ");
            //Grab input from keyboard
            strInput = input.nextLine();
            //try to convert String to int
            try {
                num = Integer.parseInt(strInput);
                if (num ==1){
                    deleteHistory(currentUser);
                    valid = true;
                    System.out.println("Flexnix bot: Your history of watched movies has been deleted succesfully!");
                }
                else if (num ==2){
                    valid = true;
                }
                else{
                    System.out.println("Flexnix bot: You did not enter a valid menu option, try again");
                }
            }
            catch (NumberFormatException e){
            }
        }
    }

    private void deleteHistory(User currentUser) {
        currentUser.getWatchedMovies().clear();
    }

    // Method 4 to get back to user menu from favorites movies if contains Movies
    public void readIntegerFavorites(User currentUser, ArrayList<Movie> movies) {
        int num;
        String strInput;
        boolean valid = false;

        while(valid == false){
            //Prompt user
            currentUser.displayFavoriteMoviesMenu();
            System.out.print("Enter here: ");
            //Grab input from keyboard
            strInput = input.nextLine();
            //try to convert String to int
            try {
                num = Integer.parseInt(strInput);
                if (num >0 && num <= currentUser.getFavoriteMovies().size()){
                    LibraryChoice lc = new LibraryChoice();
                    String title = currentUser.getFavoriteMovies().get(num-1).getTitle();
                    int index = titleInArrayToIndexInOtherArray(movies, title);
                    lc.completeMovieLibraryChoice(index+1);
                    currentUser.getWatchedMovies().add(movies.get(index));
                    valid = true;
                }
                else if (num == currentUser.getFavoriteMovies().size()+1){
                    valid = true;
                    // Goes back to user menu
                }
                else {
                    System.out.println("Fletnix bot: You did not enter a valid menu option, try again");
                }
            }
            catch (NumberFormatException e){
                System.out.println("Fletnix bot: You did not enter a valid menu option, try again");
            }
        }
    }
    public int titleInArrayToIndexInOtherArray(ArrayList<Movie> movies, String title){
        for (int i = 0; i < movies.size(); i++){
            if (movies.get(i).getTitle().equals(title)){
                return  movies.indexOf(movies.get(i));
            }
        }
        return -1;
    }

    public void readInteger_BackToUserMenuFromEmptyFavoritesAndWatched(String favoritesMenu, String endOfMenu, String empty) {
        int num;
        String strInput;
        boolean valid = false;

        while(valid == false){
            //Prompt user
            System.out.println(favoritesMenu);
            System.out.println(empty);
            System.out.println("Press [1] and then [Enter] to go back to user menu");
            System.out.println(endOfMenu);
            System.out.print("Enter here: ");
            //Grab input from keyboard
            strInput = input.nextLine();
            //try to convert String to int
            try {
                num = Integer.parseInt(strInput);
                if (num ==1){
                    valid = true;
                }
            }
            catch (NumberFormatException e){
            }
        }
    }
    public void readInteger_BackToUserMenuFromSearchTitle(ArrayList<Movie> moviesBasedOnSearch, String userSearch, ArrayList<Movie> movies, User currentUser ) {
        int num;
        String strInput;
        boolean valid = false;

        while(valid == false){
            //Prompt user
            System.out.println("====== F L E T N I X  -  S E A R C H ===========================================================================================================================================================================================\n");
            if (moviesBasedOnSearch.size()==0){
                System.out.println("Fletnix bot: No movies has \""+ userSearch +"\" in the title\n");
            }
            else if (moviesBasedOnSearch.size()==1){
                System.out.println("Fletnix bot: Following movie has \""+ userSearch +"\" in the title\n");
                for (int i = 0; i<moviesBasedOnSearch.size(); i++){
                    System.out.println("Press " + "["+ (i+1) +"]" + " and then [Enter] to play:  " + moviesBasedOnSearch.get(i).getTitle());
                }
            }
            else {
                System.out.println("Fletnix bot: Following movies has \""+ userSearch +"\" in the title\n");
                for (int i = 0; i<moviesBasedOnSearch.size(); i++){
                    System.out.println("Press " + "["+ (i+1) +"]" + " and then [Enter] to play:  " + moviesBasedOnSearch.get(i).getTitle());
                }
            }
            System.out.println("Press [" + (moviesBasedOnSearch.size()+1) + "] and then [Enter] to go back to user menu\n");
            System.out.println("=================================================================================================================================================================================================");
            System.out.print("Enter here: ");
            //Grab input from keyboard
            strInput = input.nextLine();
            //try to convert String to int
            try {
                num = Integer.parseInt(strInput);

                if (num >0 && num <=moviesBasedOnSearch.size()){
                    LibraryChoice lc = new LibraryChoice();
                    String title = moviesBasedOnSearch.get(num-1).getTitle();
                    int index = titleInArrayToIndexInOtherArray(movies, title);
                    lc.completeMovieLibraryChoice(index+1);
                    currentUser.getWatchedMovies().add(movies.get(index));

                    currentUser.getFavoriteMovies().add(movies.get(index));
                    valid = true;
                }
                else if (num ==moviesBasedOnSearch.size()+1){
                    valid = true;
                }
                else{
                    System.out.println("Invalid input in readInteger_BackToUserMenuFromSearchTitle");
                }
            }
            catch (NumberFormatException e){
                System.out.println("Invalid input in readInteger_BackToUserMenuFromSearchTitle");
            }
        }
    }


    // For loop to Display menu items from arraylist
    public static void displayMenu(ArrayList<MenuItem> items, String menuName){
        // Display Menu
        System.out.println(menuName);
        for (int i = 0; i < items.size(); i++){
            System.out.println("Press " + "["+ (i+1) +"]" + " and then [Enter] to " + items.get(i).getName());
        }
        System.out.println("\n==================================================================================================================================================================================================================================");
    }

    // Method to check if username is available
    public static boolean usernameAvailable(String username){
        Scanner x;
        boolean available = true;
        String tempUsername = "";
        String tempPassword = "";
        String filepath = "Users.txt";

        try{
            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            while(x.hasNext() && available==true){
                tempUsername = x.next();
                tempPassword = x.next();

                if(tempUsername.trim().equals(username.trim())){
                    available=false;
                }
            }
            x.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return available;
    }

    // Method to get username
    public String getUsername(String promptMsg) {
        System.out.print(promptMsg);
        String inputToUsername = input.nextLine();

        while(!usernameAvailable(inputToUsername)){
            System.out.println("Fletnix bot: Username taken, try another");
            System.out.print(promptMsg);
            inputToUsername = input.nextLine();
        }
        while(inputToUsername.length() < 1){
            System.out.println("Fletnix bot: The username must be at least 3 characters long, try again");
            System.out.print(promptMsg);
            inputToUsername = input.nextLine();
        }
        return inputToUsername;
    }

    //Method to get password
    public String getPassword(String promptMsg) {
        System.out.print(promptMsg);
        String inputToPassword = input.nextLine();
        while(inputToPassword.length() < 1){
            System.out.println("Fletnix bot: The password must be at least 8 characters long, try again");
            System.out.print(promptMsg);
            inputToPassword = input.nextLine();
        }
        return inputToPassword;
    }
}
