package net.elgali.neo4j.scrape;

import net.elgali.neo4j.exception.InvalidURLException;
import net.elgali.neo4j.scrape.model.Site;
import net.elgali.neo4j.util.URLUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Iterator;

/**
 * Created by u0173742 on 2/7/14.
 */
public class ScrapServiceImpl implements ScrapeService {

    @Override
    public Site scrapeSite(String siteUrl) {
        try {
            String normalizedUrl = URLUtils.normalizeUrl(siteUrl);
            Site site = new Site(normalizedUrl);
            Connection connection = Jsoup.connect(normalizedUrl);
            Document document = connection.get();
            String title = document.title();
            site.setTitle(title);

            Elements elements = document.select("a");
            Iterator<Element> linksIt = elements.iterator();

            while(linksIt.hasNext()) {
                Element link = linksIt.next();
                Site tmpSite = new Site(link.attr("abs:href"));


            }



        } catch (InvalidURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
