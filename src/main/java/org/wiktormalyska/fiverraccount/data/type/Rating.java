package org.wiktormalyska.fiverraccount.data.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * This class represents a Rating on Fiverr.
 */
@AllArgsConstructor
@Getter
public class Rating {
    /**
     * The overall rating score.
     */
    private double overallRatingScore;
    /**
     * The rating of Seller Communication level.
     */
    private double sellerCommunication;
    /**
     * The rating of Recommended To A Friend level.
     */
    private double recommendedToAFriend;
    /**
     * The rating of Service As Described level.
     */
    private double serviceAsDescribed;

    /**
     * The number of 5-star reviews.
     */
    private int fiveStarReviews;
    /**
     * The number of 4-star reviews.
     */
    private int fourStarReviews;
    /**
     * The number of 3-star reviews.
     */
    private int threeStarReviews;
    /**
     * The number of 2-star reviews.
     */
    private int twoStarReviews;
    /**
     * The number of 1-star reviews.
     */
    private int oneStarReviews;


}
