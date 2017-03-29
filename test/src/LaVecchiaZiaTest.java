import org.junit.Test;
import p7.LaVecchiaZia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LaVecchiaZiaTest {

    @Test
    public void showPricing() throws Exception {
        new LaVecchiaZia().start();

        URL home = new URL("http://lavecchiazia.it:8080/");
        HttpURLConnection connection = (HttpURLConnection)home.openConnection();

        connection.setRequestMethod("GET");

        String result = new BufferedReader(new InputStreamReader(connection.getInputStream()))
                .lines().collect(Collectors.joining("\n"));

        assertThat(result, containsString("3.00€/h"));
        assertThat(result, containsString("15.00€ sopra le 5 ore"));
    }
}
