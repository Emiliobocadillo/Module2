import java.util.ArrayList;
import java.util.Date;


public class User {
    private String username;
    private String password;
    private ArrayList<Movie> favoriteMovies = new ArrayList<Movie>();
    private ArrayList<Movie> watchedMovies = new ArrayList<Movie>();

    public User(String username, String password) {
        this.username=username;
        this.password=password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return
                "Username = \t" + username + "\n" +
                "Password = \t" + password;
    }

    String watchedHeader =       "====== F L E T N I X  -  W A T C H E D ===========================================================================================================================================================================================\n";
    String favoritesHeader =     "====== F L E T N I X  -  F A V O R I T E S =========================================================================================================================================================================================\n";
    String endOfMenu =           "\n==================================================================================================================================================================================================================================";

    public ArrayList<Movie> getFavoriteMovies() {
        return favoriteMovies;
    }

    public ArrayList<Movie> getWatchedMovies() {
        return watchedMovies;
    }

    public void displayFavoriteMoviesMenu(){
        System.out.println(favoritesHeader);
        for (int i = 0; i<favoriteMovies.size(); i++){
            System.out.println("Press " + "["+ (i+1) +"]" + " and then [Enter] to play:  " + favoriteMovies.get(i));
        }
        System.out.println("Press " + "["+(favoriteMovies.size()+1)+"]" + " and then [Enter] to go back to user menu");
        System.out.println(endOfMenu);

    }


    public void displayWatchedMoviesMenu(){
        System.out.println(watchedHeader);
        for (int i = 0; i<watchedMovies.size(); i++){
            System.out.println(watchedMovies.get(i).toString2());
        }
        System.out.println("\nPress [1] and then [Enter] to delete history");
        System.out.println("Press [2] and then [Enter] to go back to user menu");
        System.out.println(endOfMenu);

    }
}
