import org.json.JSONException;
import java.io.IOException;
import java.util.Map;

public class testingClass {
    public static void main(String[] args) throws IOException, JSONException {
        //System.out.println("hello it works 1111");

        riotAPI summonerSearch = new riotAPI("TheCookie", "na1");

        //System.out.println("hello it works 2222");

//        System.out.println(summonerSearch.GetSummonerLevel());
//
//        ///System.out.println("hello it works 3333");
//
//        System.out.println(summonerSearch.GetProfileIconID());
//        System.out.println(summonerSearch.GetSummonerName());
//        System.out.println(summonerSearch.GetAccountID());
//        System.out.println(summonerSearch.GetID());
//
//        System.out.println(summonerSearch.GetTotalGames());
//
//        Map<CharSequence, Integer> championCounter = summonerSearch.GamesPerChampion();
//
//        // how to print out map
//        for (CharSequence champion : championCounter.keySet()){
//            System.out.println(champion + ": " + Integer.toString(championCounter.get(champion)));
//        }

        summonerSearch.AvgGameLengthBy_Queue_Season(420, 13);
    }
}
