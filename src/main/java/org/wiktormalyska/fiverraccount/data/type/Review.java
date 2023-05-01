package org.wiktormalyska.fiverraccount.data.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * This class represents a Review on Fiverr.
 */
@AllArgsConstructor
@Getter
public class Review {
    /**
     * The username of the person who left the review.
     */
    private final String username;
    /**
     * The profile image url of the person who left the review.
     */
    private final String userProfileImage;
    /**
     * The country of the person who left the review.
     */
    private final String country;
    /**
     * The rating of the person who left the review.
     */
    private final double rating;
    /**
     * The time ago of the person who left the review.
     */
    private final String timeAgo;
    /**
     * The review itself.
     */
    private final String review;
}
