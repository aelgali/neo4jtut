package net.elgali.neo4j.util;

import net.elgali.neo4j.exception.InvalidURLException;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by u0173742 on 2/7/14.
 */
public class URLUtils {
    public static String normalizeUrl(String urlPath) throws InvalidURLException {
        String validatedUrl = convertToValidUrl(urlPath);
        URL url;
        try {
            URI uri = new URI(validatedUrl);
            if (!uri.isAbsolute()) {
                return null;
            }

            url = uri.normalize().toURL();
            String path = url.getPath().replace("/$", "");
            int port = url.getPort();
            return url.getProtocol() + "://" + url.getHost()
                    + (port != -1 && port != 80 ? ":" + port : "")
                    + path;
        } catch (URISyntaxException e) {
            throw new InvalidURLException(validatedUrl + " link syntax is invalid", e);
        } catch (MalformedURLException e) {
            throw new InvalidURLException(validatedUrl + " link is malformed", e);
        }
    }

    public static String convertToValidUrl(String url) {
        if (url.startsWith("http://") || url.startsWith("https://")) {
            return url;
        }
        return "http://" + url;
    }
}
