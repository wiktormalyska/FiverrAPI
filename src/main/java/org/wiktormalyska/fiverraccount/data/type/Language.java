package org.wiktormalyska.fiverraccount.data.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * This class represents a Language on Fiverr.
 */
@AllArgsConstructor
@Getter
public class Language {

    /**
     * The language name
     */
    private String language;
    /**
     * The language level
     */
    private String level;

}
