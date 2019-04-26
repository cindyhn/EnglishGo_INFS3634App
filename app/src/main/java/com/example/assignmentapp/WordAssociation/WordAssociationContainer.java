package com.example.assignmentapp.WordAssociation;

import android.provider.BaseColumns;

public final class WordAssociationContainer {

    //Class that defines all the columns needed for the SQLite database used for the quiz
    private WordAssociationContainer() {}

    public static class QuestionsTable implements BaseColumns {
        public static final String TABLE_NAME = "word_association_questions";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_OPTION1 = "option1";
        public static final String COLUMN_OPTION2 = "option2";
        public static final String COLUMN_ANSWER_NO = "answerno";
        public static final String COLUMN_DIFFICULTY = "difficulty";

    }
}
