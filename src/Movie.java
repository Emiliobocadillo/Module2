import java.util.ArrayList;
import java.util.Date;


public class Movie {
    private String title;
    private int yearOfRelease;
    private ArrayList<Actor> listOfActors;
    private Date watched;

    public Movie(String title, int yearOfRelease, ArrayList<Actor> listOfActors) {
        this.title = title;
        this.yearOfRelease = yearOfRelease;
        this.listOfActors = listOfActors;
    }

    @Override
    public String toString() {
        return title;
    }
    public String toString2() {
        return watched + "  -  " + title;
    }

    public ArrayList<Actor> getListOfActors() {
        return listOfActors;
    }

     public void printActors(){
        for (Actor currentActor: listOfActors){
            System.out.println(currentActor.getFullName() + " as " + currentActor.getRole());
        }
    }

    public String getTitle() {
        return title;
    }

    public Date getWatched() {
        return watched;
    }

    public void setWatched(Date watched) {
        this.watched = watched;
    }
}
