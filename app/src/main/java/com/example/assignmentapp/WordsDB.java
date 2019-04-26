package com.example.assignmentapp;

import java.util.Random;

public class WordsDB {

    static String getWord() {
        String[] words = {"ADORN\n\n Definition: To add beauty and decorate",
                "UBIQUITOUS\n\n Definition: Present everywhere",
                "IMMINENT\n\n Definition: Likely to come or happen soon",
                "TAUNT\n\n Definition: A remark made in order to anger, wound, or provoke someone",
                "BENIGN\n\n Definition: Gentle and kind",
                "COMBAT\n\n Definition: Fighting between armed forces",
                "PROTOCOL\n\n Definition: Official procedure or system or rules",
                "ENTRANCE\n\n Definition: An opening, such as a door or gate that allows access to a place",
                "EXPLODE\n\n Definition: Burst or shatter violently and noisily as a result of pressure",
                "NOTIFY\n\n Definition: To inform (someone) of something, typically in a formal or official manner",
                "ENQUIRY\n\n Definition: An act of asking for information",
                "PETRIFIED\n\n Definition: So frightened that one is unable to move",
                "FORESHADOW\n\n Definition: A warning or indication of a future event",
                "MINUSCULE\n\n Definition: Extremely small",
                "WHARF\n\n Definition: A level quayside area to which a ship may be moored to load and unload",
                "HYGIENE\n\n Definition: Conditions or practices conducive to maintaining health and preventing disease",
        };

        Random r = new Random();
        int num = r.nextInt(words.length);
        return words[num]; //returns random fact to WOTD activity

    }
}
