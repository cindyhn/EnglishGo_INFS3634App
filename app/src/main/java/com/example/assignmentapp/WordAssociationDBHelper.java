package com.example.assignmentapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.assignmentapp.WordAssociationContainer.*;

import java.util.ArrayList;
import java.util.List;


public class WordAssociationDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "WordAssociation.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public WordAssociationDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    //OnCreate only ever be called when first accessing the DB
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        //Creating SQLite statements
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NO + " INTEGER, " +
                QuestionsTable.COLUMN_DIFFICULTY + " TEXT" +
                ")";

        //Creating the database by executing the SQLite statements stated above
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    //Creating question objects using WordAssociationQandA class
    //addQuestion method used to insert values into database
    private void fillQuestionsTable() {
        WordAssociationQandA q1 = new WordAssociationQandA("Legacy, Family, Ethnic", "Gather", "Heritage", 2, WordAssociationQandA.DIFFICULTY_MEDIUM);
        addQuestion(q1);
        WordAssociationQandA q2 = new WordAssociationQandA("Small, Decrease, Reduction", "Minimise", "Convince", 1, WordAssociationQandA.DIFFICULTY_EASY);
        addQuestion(q2);
        WordAssociationQandA q3 = new WordAssociationQandA("Fast, Quick, Prompt", "Swift", "Command", 1, WordAssociationQandA.DIFFICULTY_EASY);
        addQuestion(q3);
        WordAssociationQandA q4 = new WordAssociationQandA("Make, Create, Factory", "Produce", "Rehabilitation", 1, WordAssociationQandA.DIFFICULTY_MEDIUM);
        addQuestion(q4);
        WordAssociationQandA q5 = new WordAssociationQandA("Prepare, Setup, Organise", "Arrange", "Readily", 2, WordAssociationQandA.DIFFICULTY_EASY);
        addQuestion(q5);
        WordAssociationQandA q6 = new WordAssociationQandA("Unfamiliar, Peculiar, Strange", "Unique", "Weird", 2, WordAssociationQandA.DIFFICULTY_EASY);
        addQuestion(q6);
        WordAssociationQandA q7 = new WordAssociationQandA("Money, Government, Hotel", "Pension", "Exposed", 2, WordAssociationQandA.DIFFICULTY_EASY);
        addQuestion(q7);
        WordAssociationQandA q8 = new WordAssociationQandA("Seller, Employee, Merchant", "Vendor", "Qualify", 2, WordAssociationQandA.DIFFICULTY_EASY);
        addQuestion(q8);
        WordAssociationQandA q9 = new WordAssociationQandA("Plan, Project, Scheme", "Arrangement", "Exclude", 2, WordAssociationQandA.DIFFICULTY_EASY);
        addQuestion(q9);
        WordAssociationQandA q10 = new WordAssociationQandA("Additional, Extra, Option", "Accessory", "Construct", 2, WordAssociationQandA.DIFFICULTY_MEDIUM);
        addQuestion(q10);
        WordAssociationQandA q11 = new WordAssociationQandA("Blood, Dose, Therapy", "Transfusion", "Cardiac", 1, WordAssociationQandA.DIFFICULTY_HARD);
        addQuestion(q11);
        WordAssociationQandA q12 = new WordAssociationQandA("Love, Attract, Charm", "Vigilance", "Tempt", 2, WordAssociationQandA.DIFFICULTY_MEDIUM);
        addQuestion(q12);
        WordAssociationQandA q13 = new WordAssociationQandA("Criticism, Explosive, Blast", "Fulminate", "Pediment", 1, WordAssociationQandA.DIFFICULTY_HARD);
        addQuestion(q13);
        WordAssociationQandA q14 = new WordAssociationQandA("Poverty, Poor, Tyrannize", "Penury", "Tyrannize", 1, WordAssociationQandA.DIFFICULTY_HARD);
        addQuestion(q14);
        WordAssociationQandA q15 = new WordAssociationQandA("Rural, Urban, Desolate", "Depopulate", "Stoicism", 1, WordAssociationQandA.DIFFICULTY_HARD);
        addQuestion(q15);
    }

    //To insert the question into the database using ContentValues class
    //Passes column name and then the value for each column - ie; question, options and column answer no
    private void addQuestion(WordAssociationQandA wordassociationqanda) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, wordassociationqanda.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, wordassociationqanda.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, wordassociationqanda.getOption2());
        cv.put(QuestionsTable.COLUMN_ANSWER_NO, wordassociationqanda.getAnswerNo());
        cv.put(QuestionsTable.COLUMN_DIFFICULTY, wordassociationqanda.getDifficulty());

        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    //To make questions retrievable from other classes
    public List<WordAssociationQandA> getAllQuestions() {
        List<WordAssociationQandA> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

        //Move cursor to the first entry
        if (c.moveToFirst()) {
            do {
                //Create question object
                WordAssociationQandA wordassociationqanda = new WordAssociationQandA();

                //Fill question object with data out of the DB using column index names rather than hardcoding numbers
                wordassociationqanda.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                wordassociationqanda.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                wordassociationqanda.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                wordassociationqanda.setAnswerNo(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NO)));
                wordassociationqanda.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));


                //Pass question through the list
                questionList.add(wordassociationqanda);

            } while (c.moveToNext());
        }

        //Close cursor and return the question list
        c.close();
        return questionList;


    }

    //To make questions retrievable from other classes according to difficulty level
    public List<WordAssociationQandA> getQuestions(String difficulty) {
        List<WordAssociationQandA> questionList = new ArrayList<>();
        db = getReadableDatabase();

        //Getting questions from DB where difficulty level matches
        String[] selectionArgs = new String[]{difficulty};
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME + " WHERE " + QuestionsTable.COLUMN_DIFFICULTY + " = ?", selectionArgs);

        //Move cursor to the first entry
        if (c.moveToFirst()) {
            do {
                //Create question object
                WordAssociationQandA wordassociationqanda = new WordAssociationQandA();

                //Fill question object with data out of the DB using column index names rather than hardcoding numbers
                wordassociationqanda.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                wordassociationqanda.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                wordassociationqanda.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                wordassociationqanda.setAnswerNo(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NO)));
                wordassociationqanda.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));


                //Pass question through the list
                questionList.add(wordassociationqanda);

            } while (c.moveToNext());
        }

        //Close cursor and return the question list
        c.close();
        return questionList;


    }


}