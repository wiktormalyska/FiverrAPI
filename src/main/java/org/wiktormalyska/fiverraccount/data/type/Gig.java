package org.wiktormalyska.fiverraccount.data.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Gig {
    private String title;
    private double ratingScore;
    private int numberOfReviews;
    private double startingPrice;
    private char currency;
    private String thumbnail;
}
