public class ChngStr {
    public static String fx(String x, int a, int b) {
        String stor = x.substring(0,a).concat(x.substring(b,x.length()));
        return stor;
    }
}