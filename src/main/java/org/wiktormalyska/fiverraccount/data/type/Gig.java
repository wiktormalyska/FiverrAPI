package org.wiktormalyska.fiverraccount.data.type;

import org.jsoup.nodes.Document;
import org.wiktormalyska.fiverraccount.FiverrConnection;

import java.awt.*;

public class Gig {
    private FiverrConnection connection;
    private Document website;

    public Gig(FiverrConnection connection, Document website) {
        this.connection = connection;
        this.website = website;
    }
    private String title;
    private double ratingScore;
    private int numberOfReviews;
    private double startingPrice;
    private char currency;
    private Image thumbnail;
}
