package forms;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import kong.unirest.Unirest;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import static forms.NewslettersPage.getPreviewLink;

public class SletterGetReq {

    public static String getSletterUnsubLink() {
        kong.unirest.HttpResponse<String> response =
                Unirest.get(getPreviewLink()).asString();
        Document document = Jsoup.parse(response.getBody());
        Element unsubLink = document.selectFirst("a:containsOwn(clicking here)");
        if (unsubLink != null) {
            return unsubLink.attr("href");
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getSletterUnsubLink());
    }
}
