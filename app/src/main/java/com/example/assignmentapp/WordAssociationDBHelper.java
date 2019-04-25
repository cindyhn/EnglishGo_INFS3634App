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
                QuestionsTable.COLUMN_ANSWER_NO + " INTEGER" +
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
        WordAssociationQandA q1 = new WordAssociationQandA("Legacy, Family, Ethnic", "Gather", "Heritage", 2);
        addQuestion(q1);
        WordAssociationQandA q2 = new WordAssociationQandA("Small, Decrease, Reduction", "Minimise", "Convince", 1);
        addQuestion(q2);
        WordAssociationQandA q3 = new WordAssociationQandA("Fast, Quick, Prompt", "Swift", "Command", 1);
        addQuestion(q3);
        WordAssociationQandA q4 = new WordAssociationQandA("Make, Create, Factory", "Productive", "Rehabilitation", 1);
        addQuestion(q4);
        WordAssociationQandA q5 = new WordAssociationQandA("Unfamiliar, Peculiar, Strange", "Unique", "Weird", 2);
        addQuestion(q5);
    }

    //To insert the question into the database using ContentValues class
    //Passes column name and then the value for each column - ie; question, options and column answer no
    private void addQuestion(WordAssociationQandA wordassociationqanda) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, wordassociationqanda.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, wordassociationqanda.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, wordassociationqanda.getOption2());
        cv.put(QuestionsTable.COLUMN_ANSWER_NO, wordassociationqanda.getAnswerNo());
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

                //Pass question through the list
                questionList.add(wordassociationqanda);

            } while (c.moveToNext());
        }

        //Close cursor and return the question list
        c.close();
        return questionList;


    }
}