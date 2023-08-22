import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try {
            JSONParser parser = new JSONParser();

            JSONObject object = (JSONObject) parser.parse(getDataFromFile("data/objectStuff.json"));
            System.out.println(object);
            System.out.println();


            JSONArray array = (JSONArray) parser.parse(getDataFromFile("data/arrayStuff.json"));
            for (Object item : array) {
                JSONObject jsonObject = (JSONObject) item;
                System.out.println(jsonObject.get("id") + "\t" + jsonObject.get("name") + "\t" + jsonObject.get("password"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getDataFromFile(String path) {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(builder::append);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
/*
<dependencies>
        <dependency>
            <groupId>com.googlecode.json-simple</groupId>
            <artifactId>json-simple</artifactId>
            <version>1.1.1</version>
        </dependency>
    </dependencies>
 */