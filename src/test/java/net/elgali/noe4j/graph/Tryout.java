package net.elgali.noe4j.graph;

import net.elgali.neo4j.graph.RelTypes;
import org.junit.Test;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

/**
 * Created by u0173742 on 2/7/14.
 */
public class Tryout {

    @Test
    public void testNeo4jEmbeddedServer() {
        GraphDatabaseService graphDb = new GraphDatabaseFactory().newEmbeddedDatabase("./graph-db");
        Transaction tx = graphDb.beginTx();
        int nodeId= 0;
        Node prevNode = graphDb.createNode();
        prevNode.setProperty("title", "site " + nodeId);

        try {
            for (int i = 0; i < 100; i++) {
                Node siteNode2 = graphDb.createNode();
                siteNode2.setProperty("title", "site " + ++nodeId);
                Relationship relationship = prevNode.createRelationshipTo(siteNode2, RelTypes.REFERENCES);
                relationship.setProperty("title", "SITE " + nodeId +" IS GREAT GO AND SEE IT");
                prevNode = siteNode2;
            }


            tx.success();

        } catch (Exception e) {
            tx.failure();
            e.printStackTrace();
        }
        tx.finish();
        graphDb.shutdown();
    }
}
