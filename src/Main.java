import java.net.URL;
import java.net.MalformedURLException;
import java.net.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Body wiki = new Body("https://en.wikipedia.org/wiki/Special:Random");
//        System.out.print(wiki.sentances);
        wiki.printSent();
    }
    public static void print(String x) {
        System.out.print(x);
    }
}

