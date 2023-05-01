package org.wiktormalyska.fiverraccount.data.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Review {
    private final String username;
    private final String userProfileImage;
    private final String country;
    private final double rating;
    private final String timeAgo;
    private final String review;
}
