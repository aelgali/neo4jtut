package net.elgali.neo4j.graph;

import org.neo4j.graphdb.RelationshipType;

/**
 * Created by u0173742 on 2/7/14.
 */
public enum RelTypes implements RelationshipType {
    REFERENCES, REFERENCED_BY
}
