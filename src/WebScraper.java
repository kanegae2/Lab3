import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
public class WebScraper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
    public static int wordCount(String url, String word) {
        String paragraph = urlToString(url);
        String newWord = word.toLowerCase();
        int count = 0;
        while (paragraph.length() >= 0) {
            int index = paragraph.indexOf(word);
            paragraph = paragraph.substring(index);
            count++;
        }
        while (paragraph.length() >= 0) {
            int index = paragraph.indexOf(newWord);
            paragraph = paragraph.substring(index);
            count++;
        }
        return count;

    }
    public static void main(String[] unused) {
        System.out.println(wordCount("http://erdani.com/tdpl/hamlet.txt", "Hamlet"));
    }
}
