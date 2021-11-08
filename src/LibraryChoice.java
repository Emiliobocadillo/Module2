import java.util.ArrayList;

public class LibraryChoice {




    // Method to complete choice in Movie Library Menu
    public void completeMovieLibraryChoice(int choice) {

        switch(choice){
            case 1:
                System.out.println(
                        "  ______________________________________________  \n" +
                                " /____________________________________________ /|\n" +
                                "|  _________________________________________  | |\n" +
                                "| |                                         | | |\n" +
                                "| |             Fletnix Presents:           | | |\n" +
                                "| |               -Forrest Gump             | | |\n" +
                                "| |                                         | | |\n" +
                                "| |                 Starring:               | | |\n" +
                                "| |        -Tom Hanks as Forrest Gump       | | |\n" +
                                "| |        -Robin Wright as Jenny Curran    | | |\n" +
                                "| |                                         | | |\n" +
                                "| |_________________________________________| | |\n" +
                                "|      :::::      S A M S U N G     :::::     | |\n" +
                                "|      :::::            ¤           :::::     | |\n" +
                                "|_____________________________________________|/\n");


                break;

            case 2:
                System.out.println(
                        "  ______________________________________________  \n" +
                                " /____________________________________________ /|\n" +
                                "|  _________________________________________  | |\n" +
                                "| |                                         | | |\n" +
                                "| |             Fletnix Presents:           | | |\n" +
                                "| |                 -Titanic                | | |\n" +
                                "| |                                         | | |\n" +
                                "| |                 Starring:               | | |\n" +
                                "| |   -Leonardo DiCaprio as Jack Dawson     | | |\n" +
                                "| |   -Kate Winslet as Rose DeWitt Bukater  | | |\n" +
                                "| |                                         | | |\n" +
                                "| |_________________________________________| | |\n" +
                                "|      :::::      S A M S U N G     :::::     | |\n" +
                                "|      :::::            ¤           :::::     | |\n" +
                                "|_____________________________________________|/\n");



                break;
            case 3:
                System.out.println(
                        "  ______________________________________________  \n" +
                                " /____________________________________________ /|\n" +
                                "|  _________________________________________  | |\n" +
                                "| |                                         | | |\n" +
                                "| |             Fletnix Presents:           | | |\n" +
                                "| |       -E.T. the Extra-Terrestrial       | | |\n" +
                                "| |                                         | | |\n" +
                                "| |                 Starring:               | | |\n" +
                                "| |         -Henry Thomas as Elliott        | | |\n" +
                                "| |         -Drew Barrymore as Gertie       | | |\n" +
                                "| |                                         | | |\n" +
                                "| |_________________________________________| | |\n" +
                                "|      :::::      S A M S U N G     :::::     | |\n" +
                                "|      :::::            ¤           :::::     | |\n" +
                                "|_____________________________________________|/\n");




                break;
            case 4:
                System.out.println(
                        "  ______________________________________________  \n" +
                                " /____________________________________________ /|\n" +
                                "|  _________________________________________  | |\n" +
                                "| |                                         | | |\n" +
                                "| |             Fletnix Presents:           | | |\n" +
                                "| |               -The Godfather            | | |\n" +
                                "| |                                         | | |\n" +
                                "| |                 Starring:               | | |\n" +
                                "| |      -Al Pacino as Michael Corleone     | | |\n" +
                                "| |   -Marlon Brando as Don Vito Corleone   | | |\n" +
                                "| |                                         | | |\n" +
                                "| |_________________________________________| | |\n" +
                                "|      :::::      S A M S U N G     :::::     | |\n" +
                                "|      :::::            ¤           :::::     | |\n" +
                                "|_____________________________________________|/\n");

                break;
            case 5:
                System.out.println(
                        "  ______________________________________________  \n" +
                                " /____________________________________________ /|\n" +
                                "|  _________________________________________  | |\n" +
                                "| |                                         | | |\n" +
                                "| |             Fletnix Presents:           | | |\n" +
                                "| |        -Terminator 2: Judgment Day      | | |\n" +
                                "| |                                         | | |\n" +
                                "| |                 Starring:               | | |\n" +
                                "| |   -Arnold Schwarzenegger as Terminator  | | |\n" +
                                "| |      -Linda Hamilton as Sarah Connor    | | |\n" +
                                "| |                                         | | |\n" +
                                "| |_________________________________________| | |\n" +
                                "|      :::::      S A M S U N G     :::::     | |\n" +
                                "|      :::::            ¤           :::::     | |\n" +
                                "|_____________________________________________|/\n");
                break;
            case 6:
                // Goes back to user menu
                break;
            default:
                System.out.println("HERE WE ARE Invalid input");
        }
    }
}
