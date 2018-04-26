import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;


import java.net.MalformedURLException;

public class HTML {
    public String txt = null;
    public String body = null;
    public URL address;
    public Document doc;
    public ArrayList<Element> links = new ArrayList<>();
    public ArrayList<String> urls = new ArrayList<>();
    public ArrayList<String> addresses = new ArrayList<>();

    public HTML(String url) throws MalformedURLException, Exception {
        this.address = new URL(url);
        this.mkTxt();
        doc = Jsoup.parse(txt);
        for (Element link : doc.getElementsByTag("a")) {
            links.add(link);
            urls.add(link.attr("href"));
        }
        for (String i : urls) {
            URL x = new URL(address, i);
            addresses.add((x).getAuthority() + x.getPath());
        }
        body = doc.body().text();
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
}