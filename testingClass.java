import org.json.JSONException;
import java.io.IOException;
import java.util.Map;

public class testingClass {
    public static void main(String[] args) throws IOException, JSONException {

        riotAPI summonerSearch = new riotAPI("The Cookie", "na1");

        System.out.println(summonerSearch.GetSummonerLevel());
        System.out.println(summonerSearch.GetProfileIconID());
        System.out.println(summonerSearch.GetSummonerName());
        System.out.println(summonerSearch.GetAccountID());
        System.out.println(summonerSearch.GetID());

        System.out.println(summonerSearch.GetTotalGames());

        Map<CharSequence, Integer> championCounter = summonerSearch.GamesPerChampion();

        // how to print out map
        for (CharSequence champion : championCounter.keySet()){
            System.out.println(champion + ": " + Integer.toString(championCounter.get(champion)));
        }
    }
}
