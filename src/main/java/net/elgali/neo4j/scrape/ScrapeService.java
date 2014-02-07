package net.elgali.neo4j.scrape;

import net.elgali.neo4j.exception.InvalidURLException;
import net.elgali.neo4j.scrape.model.Site;
import net.elgali.neo4j.util.URLUtils;
import sun.net.util.URLUtil;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by u0173742 on 2/7/14.
 */
public interface ScrapeService {

    Site scrapeSite(String siteUrl);
}
