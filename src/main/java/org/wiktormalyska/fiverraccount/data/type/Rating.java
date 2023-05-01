package org.wiktormalyska.fiverraccount.data.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Rating {
    private double overallRatingScore;
    private double sellerCommunication;
    private double recommendedToAFriend;
    private double serviceAsDescribed;

    private int fiveStarReviews;
    private int fourStarReviews;
    private int threeStarReviews;
    private int twoStarReviews;
    private int oneStarReviews;


}
