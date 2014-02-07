package net.elgali.neo4j.scrape.model;

import org.neo4j.graphdb.Node;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by u0173742 on 2/7/14.
 */
public class Site implements Serializable {

    private Node underlyingNode;
    private String url;
    private String title;
    private List<Site> relSites = new ArrayList<Site>();

    public Site(String url, Node underlyingNode) {
        this.url = url;
        this.underlyingNode = underlyingNode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Site> getRelSites() {
        return relSites;
    }

    public void setRelSites(List<Site> relSites) {
        this.relSites = relSites;
    }

    public Node getUnderlyingNode() {
        return underlyingNode;
    }
}
