package net.elgali.neo4j.scrape;

import net.elgali.neo4j.scrape.model.Site;
import org.junit.Test;
import sun.print.resources.serviceui_sv;

/**
 * Created by u0173742 on 2/7/14.
 */
public class ScrapeServiceTest {
    private ScrapeService scrapeService;

    public ScrapeServiceTest() {
        scrapeService = new ScrapServiceImpl();
    }
    @Test
    public void scrapeSite () {
        String siteUrl = "hirealawyer.findlaw.com/attorney-fees-and-agreements/reducing-your-legal-costs-and-expenses.html";
        Site scrapedSite = scrapeService.scrapeSite(siteUrl);

    }
}
