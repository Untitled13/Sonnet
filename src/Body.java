import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;

public class Body {
    public final String[] punc = new String[] {".", ":", "!", "?", ";"};

    public String txt = null;
    public URL address;
    public Document doc;
    public String body = null;
    public ArrayList<String> sentances = new ArrayList<>();
    public ArrayList<Integer> puncLoc = new ArrayList<>();

    public Body(String url) throws MalformedURLException, Exception{
        this.address = new URL(url);
        this.mkTxt();
        doc = Jsoup.parse(txt);
        body = doc.body().text();
        div();
    }
    public void mkTxt() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(this.address.openStream()));
        String input = in.readLine();
        while(input != null) {
            this.txt += (input + "\n");
            input = in.readLine();
        }
        in.close();
    }
    public void div() {
        puncLoc.add(0);
        for(int i = 0; i < this.body.length()-1; i++) {
            if(punctuation(body.substring(i,i+1))) {
                puncLoc.add(i);
            }
        }
        puncLoc.add(body.length());
        for (int i = 0; i < puncLoc.size()-1; i++) {
            sentances.add(body.substring(puncLoc.get(i)+1, puncLoc.get(i+1)));
        }
    }
    public boolean punctuation(String x) {
        for(String i: punc) {
            if(i.equals(x)) {
                return true;
            }
        }
        return false;
    }
    public void printSent() {
        for (String i: sentances) {
            System.out.println(i);
        }
    }
}
