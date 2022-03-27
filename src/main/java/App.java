import org.example.model.TableCity;
import org.example.model.TableCountry;
import org.example.util.Database;
import org.example.model.TableMayor;

public class App {

    public static void main(String[] args) {

//        Database.connection();

        TableCity.createTable();
        TableMayor.createTableMayor();
        TableCountry.createTableCountry();

        TableCity.saveCities("Bishkek",1000,1);
        TableCity.saveCities("Moscow",2000,2);
        TableCity.saveCities("Washington",3000,3);
        TableCity.saveCities("Tokyo",4000,4);
        TableCity.saveCities("Berlin",5000,5);

        System.out.println("______________________________________________");
        TableMayor.saveMayors("Sobyanin",60,1);
        TableMayor.saveMayors("Tuleev",55,2);
        TableMayor.saveMayors("Tashiev",57,3);
        TableMayor.saveMayors("Japarob",48,4);
        TableMayor.saveMayors("Atambaev",38,5);

        System.out.println("___________________________________________________________");

        TableCountry.saveCountries("Kyrgyzstan",7000000,1);
        TableCountry.saveCountries("Russia",150000000,2);
        TableCountry.saveCountries("America",300000000,3);
        TableCountry.saveCountries("Japan",135000000,4);
        TableCountry.saveCountries("Ukrain",40000000,5);

        System.out.println("___________________________________________________________");
        TableCity.getAllCities();
        System.out.println("____________________________________________________________");
        TableMayor.getAllMayors();
        System.out.println("____________________________________________________________");
        TableCountry.getAllCountries();

    }
}
