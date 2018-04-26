import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;

public class Dictionary {
    ArrayList<String> sentances = new ArrayList<>();
    ArrayList<String[]> words = new ArrayList<>();
    ArrayList<Integer[]> brLoc = new ArrayList<>();

    public Dictionary(ArrayList<String> x) {
        this.sentances = x;
    }
    public void div() {
        // iterates through elements in sentances
        for(int q = 0; q < sentances.size(); q++) {
            brLoc.get(q)[0] = 0;
            // iterates through string in sentances
            for(int i = 0; i < sentances.get(q).length(); i++) {
                if (sentances.get(q).substring(i, i+1).equals(" ")) {
                    brLoc.get(q)[brLoc.get(q).length] = i;
                }
            }
            brLoc.get(q)[brLoc.get(q).length] = sentances.get(q).length();
        }


    }
    public void divSentance(int x) {
        String sentance = sentances.get(x);
        String[] wordStor = new String[50];
        ArrayList<Integer> brLocation = new ArrayList<>();
        brLocation.add(0);
        for(int i = 0; i < sentance.length(); i++) {
            if(sentance.substring(i, i+1).equals(" ")) {
                brLocation.add(i);
            }
        }
        brLocation.add(brLocation.size());
        for (int i = 0; i < brLocation.size(); i++) {
            wordStor[wordStor.length] = sentance.substring(brLocation.get(i)+1, brLocation.get(i+1));
        }
    }
}
