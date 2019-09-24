import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
// import org.json.simple.JSONObject;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONException;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class riotAPI {
    static final String apiKey = "RGAPI-52710572-6a4d-463a-b219-b115d165f908";
    static final String INVALID = "INVALID";

    // default values for summoner "The Cookie" aka me
    static String summonerName = "The Cookie";
    static String id = "d76UQLIqu29Dtttzb2pok2AvuCwlW-c9MItnJIXmB9y10NA";
    static String accountId = "QmoykMWsH81Q3lASwZKS2N8HnN_pDCrVWvk0zxOex3cbug";
    static String server = "na1";
    static int profileIconId = 4225;
    static int summonerLevel = 179;

    // constructor
    // pre: receives a String (summoner name)
    //      receives a String (server, see https://developer.riotgames.com/regional-endpoints.html)
    public riotAPI(String name, String paramServer) throws IOException, JSONException{
        String urlHttp = "https://";
        String urlBody = ".api.riotgames.com/lol/summoner/v4/summoners/by-name/";
        String urlApiKey = "?api_key=";

        // removes all whitespace in summoner name before adding it to apiURL
        String summName = name.replaceAll("\\s","");

        // final URL
        String apiURL = urlHttp + paramServer + urlBody + summName + urlApiKey + apiKey;

        JSONObject jsonInfo = readJsonFromUrl(apiURL);

        // prints out entire JSON
        // System.out.println(jsonInfo.toString());

        summonerName = name;
        id = jsonInfo.get("id").toString();
        accountId = jsonInfo.get("accountId").toString();
        profileIconId = (int) jsonInfo.get("profileIconId");
        summonerLevel = (int) jsonInfo.get("summonerLevel");
        server = paramServer;
    }

    // Public method
    // pre: receives an int (champion id)
    // post: returns a string (champion name or INVALID if not found)
    public static String getChampionFromID(int id){
        String champName;

        switch (id) {
            case 1: champName = "Annie";
                break;
            case 2: champName = "Olaf";
                break;
            case 3: champName = "Galio";
                break;
            case 4: champName ="TwistedFate";
                break;
            case 5: champName = "XinZhao";
                break;
            case 6: champName = "Urgot";
                break;
            case 7: champName = "LeBlanc";
                break;
            case 8: champName = "Vladimir";
                break;
            case 9: champName = "Fiddlesticks";
                break;
            case 10: champName = "Kayle";
                break;
            case 11: champName = "Master Yi";
                break;
            case 12: champName = "Alistar";
                break;
            case 13: champName = "Ryze";
                break;
            case 14: champName = "Sion";
                break;
            case 15: champName = "Sivir";
                break;
            case 16: champName = "Soraka";
                break;
            case 17: champName = "Teemo";
                break;
            case 18: champName = "Tristana";
                break;
            case 19: champName = "Warwick";
                break;
            case 20: champName = "Nunu";
                break;
            case 21: champName = "MissFortune";
                break;
            case 22: champName = "Ashe";
                break;
            case 23: champName = "Tryndamere";
                break;
            case 24: champName = "Jax";
                break;
            case 25: champName = "Morgana";
                break;
            case 26: champName = "Zilean";
                break;
            case 27: champName = "Singed";
                break;
            case 28: champName = "Evelynn";
                break;
            case 29: champName = "Twitch";
                break;
            case 30: champName = "Karthus";
                break;
            case 31: champName = "Cho'Gath";
                break;
            case 32: champName = "Amumu";
                break;
            case 33: champName = "Rammus";
                break;
            case 34: champName = "Anivia";
                break;
            case 35: champName = "Shaco";
                break;
            case 36: champName = "Dr.Mundo";
                break;
            case 37: champName = "Sona";
                break;
            case 38: champName = "Kassadin";
                break;
            case 39: champName = "Irelia";
                break;
            case 40: champName = "Janna";
                break;
            case 41: champName = "Gangplank";
                break;
            case 42: champName = "Corki";
                break;
            case 43: champName = "Karma";
                break;
            case 44: champName = "Taric";
                break;
            case 45: champName = "Veigar";
                break;
            case 48: champName = "Trundle";
                break;
            case 50: champName = "Swain";
                break;
            case 51: champName = "Caitlyn";
                break;
            case 53: champName = "Blitzcrank";
                break;
            case 54: champName = "Malphite";
                break;
            case 55: champName = "Katarina";
                break;
            case 56: champName = "Nocturne";
                break;
            case 57: champName = "Maokai";
                break;
            case 58: champName = "Renekton";
                break;
            case 59: champName = "JarvanIV";
                break;
            case 60: champName = "Elise";
                break;
            case 61: champName = "Orianna";
                break;
            case 62: champName = "Wukong";
                break;
            case 63: champName = "Brand";
                break;
            case 64: champName = "LeeSin";
                break;
            case 67: champName = "Vayne";
                break;
            case 68: champName = "Rumble";
                break;
            case 69: champName = "Cassiopeia";
                break;
            case 72: champName = "Skarner";
                break;
            case 74: champName = "Heimerdinger";
                break;
            case 75: champName = "Nasus";
                break;
            case 76: champName = "Nidalee";
                break;
            case 77: champName = "Udyr";
                break;
            case 78: champName = "Poppy";
                break;
            case 79: champName = "Gragas";
                break;
            case 80: champName = "Pantheon";
                break;
            case 81: champName = "Ezreal";
                break;
            case 82: champName = "Mordekaiser";
                break;
            case 83: champName = "Yorick";
                break;
            case 84: champName = "Akali";
                break;
            case 85: champName = "Kennen";
                break;
            case 86: champName = "Garen";
                break;
            case 89: champName = "Leona";
                break;
            case 90: champName = "Malzahar";
                break;
            case 91: champName = "Talon";
                break;
            case 92: champName = "Riven";
                break;
            case 96: champName = "Kog'Maw";
                break;
            case 98: champName = "Shen";
                break;
            case 99: champName = "Lux";
                break;
            case 101: champName = "Xerath";
                break;
            case 102: champName = "Shyvana";
                break;
            case 103: champName = "Ahri";
                break;
            case 104: champName = "Graves";
                break;
            case 105: champName = "Fizz";
                break;
            case 106: champName = "Volibear";
                break;
            case 107: champName = "Rengar";
                break;
            case 110: champName = "Varus";
                break;
            case 111: champName = "Nautilus";
                break;
            case 112: champName = "Viktor";
                break;
            case 113: champName = "Sejuani";
                break;
            case 114: champName = "Fiora";
                break;
            case 115: champName = "Ziggs";
                break;
            case 117: champName = "Lulu";
                break;
            case 119: champName = "Draven";
                break;
            case 120: champName = "Hecarim";
                break;
            case 121: champName = "Kha'Zix";
                break;
            case 122: champName = "Darius";
                break;
            case 126: champName = "Jayce";
                break;
            case 127: champName = "Lissandra";
                break;
            case 131: champName = "Diana";
                break;
            case 133: champName = "Quinn";
                break;
            case 134: champName = "Syndra";
                break;
            case 136: champName = "AurelionSol";
                break;
            case 141: champName = "Kayn";
                break;
            case 142: champName = "Zoe";
                break;
            case 143: champName = "Zyra";
                break;
            case 145: champName = "Kai'sa";
                break;
            case 150: champName = "Gnar";
                break;
            case 154: champName = "Zac";
                break;
            case 157: champName = "Yasuo";
                break;
            case 161: champName = "Vel'Koz";
                break;
            case 163: champName = "Taliyah";
                break;
            case 164: champName = "Camille";
                break;
            case 201: champName = "Braum";
                break;
            case 202: champName = "Jhin";
                break;
            case 203: champName = "Kindred";
                break;
            case 222: champName = "Jinx";
                break;
            case 223: champName = "TahmKench";
                break;
            case 236: champName = "Lucian";
                break;
            case 238: champName = "Zed";
                break;
            case 240: champName = "Kled";
                break;
            case 245: champName = "Ekko";
                break;
            case 246: champName = "Qiyana";
                break;
            case 254: champName = "Vi";
                break;
            case 266: champName = "Aatrox";
                break;
            case 267: champName = "Nami";
                break;
            case 268: champName = "Azir";
                break;
            case 350: champName = "Yuumi";
                break;
            case 412: champName = "Thresh";
                break;
            case 420: champName = "Illaoi";
                break;
            case 421: champName = "Rek'Sai";
                break;
            case 427: champName = "Ivern";
                break;
            case 429: champName = "Kalista";
                break;
            case 432: champName = "Bard";
                break;
            case 497: champName = "Rakan";
                break;
            case 498: champName = "Xayah";
                break;
            case 516: champName = "Ornn";
                break;
            case 517: champName = "Sylas";
                break;
            case 518: champName = "Neeko";
                break;
            case 555: champName = "Pyke";
                break;
            default: champName = INVALID;
                break;
        }

        return champName;
    }

    // Private method - used to obtain JSON from URL object
    // source - https://stackoverflow.com/questions/4308554/simplest-way-to-read-json-from-a-url-in-java
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    // Public method - used to obtain JSON from URL object
    // source - https://stackoverflow.com/questions/4308554/simplest-way-to-read-json-from-a-url-in-java
    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    // Public method
    // pre: receives a string (summoner name)
    // post: returns int (summoner level)
    public static int ObtainSummonerLevel(String summonerName) throws IOException, JSONException{
        String url = "https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
        String url2 = "?api_key=";

        // removes all whitespace in summoner name before adding it to apiURL
        summonerName = summonerName.replaceAll("\\s","");

        // final URL
        String apiURL = url + summonerName + url2 + apiKey;

        JSONObject jsonInfo = readJsonFromUrl(apiURL);

        // prints out entire JSON
        // System.out.println(jsonInfo.toString());

        return (int) jsonInfo.get("summonerLevel");
    }

    // public GetTotalGames()
    // pre: none
    // post: returns an int (total # of games played)
    public static int GetTotalGames() throws IOException, JSONException{
        String urlHttp = "https://";
        String urlBody = ".api.riotgames.com/lol/match/v4/matchlists/by-account/"; // followed by {encryptedAccountId}
        String urlApiKey = "?beginIndex=9999999&api_key=";
        String summName = summonerName.replaceAll("\\s","");

        String apiURL = urlHttp + server + urlBody + accountId + urlApiKey + apiKey;

        JSONObject totalGames = readJsonFromUrl(apiURL);

        return (int) totalGames.get("totalGames");
    }

    // Map<CharSequence, Integer>
    public static void GamesPerChampion() throws IOException, JSONException{
        int totalGames = GetTotalGames();

        // index of games to be access during each api call
        int beginIndex = 0;
        int endIndex = 100;

        String urlHttp = "https://";
        String urlBody = ".api.riotgames.com/lol/match/v4/matchlists/by-account/";
        String urlEndInd = "?endIndex=";
        String urlBegInd = "&beginIndex=";
        String urlApiKey = "&api_key=";

        // this for loop determines the # of times we iterate through match history (each time checks 100 games)
        // ex. if playerA has played 2402 games, then it will run 25 times (last iteration will get the last 2 matches)

        // TODO: Convert championID to the champion String,
        //       append champion String to an array,
        //       then after both loops are done, use Counter.of(array) to get a dictionary of values.
        //       Make sure to uncomment out the for loop.
        // for (int iteration = 0; iteration < (int) (totalGames / 100) + 1; ++iteration) {
            String apiURL = urlHttp + server + urlBody + accountId + urlEndInd + Integer.toString(endIndex) + urlBegInd
                            + Integer.toString(beginIndex) + urlApiKey + apiKey;

            JSONObject oneHundredGamesJSON = readJsonFromUrl(apiURL);

            org.json.JSONArray oneHundredGamesMatches = (org.json.JSONArray) oneHundredGamesJSON.get("matches");

            for (int match = 0; match < 100; ++match){
                // figured this line using: https://www.programcreek.com/java-api-examples/org.json.JSONArray
                // found in ex. 20
                JSONObject oneMatchJSON = oneHundredGamesMatches.getJSONObject(match);
                int championID = (int) oneMatchJSON.get("champion");

                System.out.println(championID);
            }

            // System.out.println(oneHundredGamesMatches);

//            System.out.println(oneHundredGamesJSON);
//            System.out.println(totalGames);
        //}

    }

    public static void TestCounter() throws IOException, JSONException{
        Map<CharSequence, Integer> count;
        String[] array1 = new String[]{"d", "sfds", "sfds", "s", "s", "q"};

        count = Counter.of(array1);

        System.out.println(count);
    }


    public static void main(String[] args) throws IOException, JSONException{
        System.out.println("updated 2!");

        String url = "https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/TheCookie?api_key=";
        String apiKey = "RGAPI-d93e18d1-f6bd-4da9-a327-1ed0c4accb72";
        String apiURL = url + apiKey;

//        try {
//            URL riotURL = new URL(apiURL);
//        } catch (java.net.MalformedURLException error) {
//            System.out.println("Error with " + apiURL);
//        }
//
//        JSONObject summonerJSON = new JSONObject(apiURL.getJSONObject("id").toString());


//        JSONObject json = readJsonFromUrl(apiURL);
//
//        System.out.println(json.toString());
//        System.out.println(json.get("summonerLevel"));

        System.out.println("Printing from ObtainSummonerLevel(String)...");
        System.out.println(ObtainSummonerLevel("The Cookie"));



        }
    }




