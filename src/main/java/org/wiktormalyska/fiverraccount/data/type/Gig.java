package org.wiktormalyska.fiverraccount.data.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * This class represents a Gig on Fiverr.
 */
@AllArgsConstructor
@Getter
public class Gig {
    /**
     * The title of the Gig.
     */
    private String title;
    /**
     * The rating score of the Gig.
     */
    private double ratingScore;
    /**
     * The number of reviews of the Gig.
     */
    private int numberOfReviews;
    /**
     * The starting price of the Gig.
     */
    private double startingPrice;
    /**
     * The currency of the Gig.
     */
    private char currency;
    /**
     * The thumbnail image url of the Gig.
     */
    private String thumbnail;
}
