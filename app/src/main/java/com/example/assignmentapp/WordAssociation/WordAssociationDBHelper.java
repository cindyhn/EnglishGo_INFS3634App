package com.example.assignmentapp.WordAssociation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.assignmentapp.WordAssociation.WordAssociationContainer.*;

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
    //Question Bank of 50 questions
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
        WordAssociationQandA q5 = new WordAssociationQandA("Prepare, Setup, Organise", "Arrange", "Readily", 1, WordAssociationQandA.DIFFICULTY_EASY);
        addQuestion(q5);
        WordAssociationQandA q6 = new WordAssociationQandA("Unfamiliar, Peculiar, Strange", "Unique", "Weird", 2, WordAssociationQandA.DIFFICULTY_EASY);
        addQuestion(q6);
        WordAssociationQandA q7 = new WordAssociationQandA("Money, Government, Hotel", "Pension", "Exposed", 1, WordAssociationQandA.DIFFICULTY_EASY);
        addQuestion(q7);
        WordAssociationQandA q8 = new WordAssociationQandA("Seller, Employee, Merchant", "Vendor", "Qualify", 1, WordAssociationQandA.DIFFICULTY_EASY);
        addQuestion(q8);
        WordAssociationQandA q9 = new WordAssociationQandA("Plan, Project, Scheme", "Arrangement", "Exclude", 1, WordAssociationQandA.DIFFICULTY_EASY);
        addQuestion(q9);
        WordAssociationQandA q10 = new WordAssociationQandA("Additional, Extra, Option", "Accessory", "Construct", 1, WordAssociationQandA.DIFFICULTY_MEDIUM);
        addQuestion(q10);
        WordAssociationQandA q11 = new WordAssociationQandA("Blood, Dose, Therapy", "Transfusion", "Cardiac", 1, WordAssociationQandA.DIFFICULTY_MEDIUM);
        addQuestion(q11);
        WordAssociationQandA q12 = new WordAssociationQandA("Love, Attract, Charm", "Vigilance", "Tempt", 2, WordAssociationQandA.DIFFICULTY_MEDIUM);
        addQuestion(q12);
        WordAssociationQandA q13 = new WordAssociationQandA("Criticism, Explosive, Blast", "Protest", "Pediment", 1, WordAssociationQandA.DIFFICULTY_HARD);
        addQuestion(q13);
        WordAssociationQandA q14 = new WordAssociationQandA("Poverty, Poor, Tyrannize", "Destitution", "Tyrannize", 1, WordAssociationQandA.DIFFICULTY_HARD);
        addQuestion(q14);
        WordAssociationQandA q15 = new WordAssociationQandA("Rural, Urban, Desolate", "Barren", "Stoicism", 1, WordAssociationQandA.DIFFICULTY_HARD);
        addQuestion(q15);
        WordAssociationQandA q16 = new WordAssociationQandA("Clear, Distinct, Obvious", "Calculate", "Apparent", 2, WordAssociationQandA.DIFFICULTY_MEDIUM);
        addQuestion(q16);
        WordAssociationQandA q17 = new WordAssociationQandA("Study, Applied, Science", "Welfare", "Theoretical", 2, WordAssociationQandA.DIFFICULTY_MEDIUM);
        addQuestion(q17);
        WordAssociationQandA q18 = new WordAssociationQandA("Recognise, Feel, Sense", "Perception", "Dramatic", 1, WordAssociationQandA.DIFFICULTY_MEDIUM);
        addQuestion(q18);
        WordAssociationQandA q19 = new WordAssociationQandA("Shop, Manager, Host", "Florist", "Subsequently", 1, WordAssociationQandA.DIFFICULTY_EASY);
        addQuestion(q19);
        WordAssociationQandA q20 = new WordAssociationQandA("Famous, Important, Outstanding", "Prominent", "Overcome", 1, WordAssociationQandA.DIFFICULTY_MEDIUM);
        addQuestion(q20);
        WordAssociationQandA q21 = new WordAssociationQandA("Assume, Insight, Weather", "Forecast", "Peer", 1, WordAssociationQandA.DIFFICULTY_MEDIUM);
        addQuestion(q21);
        WordAssociationQandA q22 = new WordAssociationQandA("Progress, Stage, Level", "Procedure", "Meaning", 1, WordAssociationQandA.DIFFICULTY_EASY);
        addQuestion(q22);
        WordAssociationQandA q23 = new WordAssociationQandA("Dynamic, Shift, Change", "Variable", "Kill", 1, WordAssociationQandA.DIFFICULTY_EASY);
        addQuestion(q23);
        WordAssociationQandA q24 = new WordAssociationQandA("Drug, Health, Doctor", "Medicine", "Technique", 1, WordAssociationQandA.DIFFICULTY_EASY);
        addQuestion(q24);
        WordAssociationQandA q25 = new WordAssociationQandA("Enter, Event, Attend", "Participate", "Bug", 1, WordAssociationQandA.DIFFICULTY_EASY);
        addQuestion(q25);
        WordAssociationQandA q26 = new WordAssociationQandA("Verify, Justify, Judgement", "Ascendant", "Vindicate", 2, WordAssociationQandA.DIFFICULTY_HARD);
        addQuestion(q26);
        WordAssociationQandA q27 = new WordAssociationQandA("Rate, Spin, Orbit", "Gyrate", "Detest", 1, WordAssociationQandA.DIFFICULTY_HARD);
        addQuestion(q27);
        WordAssociationQandA q28 = new WordAssociationQandA("Mix, Company, Combine", "Amalgamate", "Uncommitted", 1, WordAssociationQandA.DIFFICULTY_HARD);
        addQuestion(q28);
        WordAssociationQandA q29 = new WordAssociationQandA("Dominate, Arbitrarily, Random", "Indiscriminately", "Complacency", 1, WordAssociationQandA.DIFFICULTY_HARD);
        addQuestion(q29);
        WordAssociationQandA q30 = new WordAssociationQandA("Cheap, Poor, Weak", "Shoddy", "Paddock", 1, WordAssociationQandA.DIFFICULTY_EASY);
        addQuestion(q30);
        WordAssociationQandA q31 = new WordAssociationQandA("Criminal, Cattle, Unlawful", "Customarily", "Bandit", 2, WordAssociationQandA.DIFFICULTY_MEDIUM);
        addQuestion(q31);
        WordAssociationQandA q32 = new WordAssociationQandA("Burn, Light, Flame", "Glow", "Enrol", 1, WordAssociationQandA.DIFFICULTY_MEDIUM);
        addQuestion(q32);
        WordAssociationQandA q33 = new WordAssociationQandA("Fine, Money, Jail", "Cube", "Bail", 2, WordAssociationQandA.DIFFICULTY_MEDIUM);
        addQuestion(q33);
        WordAssociationQandA q34 = new WordAssociationQandA("Convert, Switch, Change", "Articulate", "Diversion", 2, WordAssociationQandA.DIFFICULTY_MEDIUM);
        addQuestion(q34);
        WordAssociationQandA q35 = new WordAssociationQandA("Move, Wander, Migration", "Drift", "Descendants", 1, WordAssociationQandA.DIFFICULTY_HARD);
        addQuestion(q35);
        WordAssociationQandA q36 = new WordAssociationQandA("Even, Fair, Impartial", "Equitable", "Curse", 1, WordAssociationQandA.DIFFICULTY_MEDIUM);
        addQuestion(q36);
        WordAssociationQandA q37 = new WordAssociationQandA("Together, Integrate, United", "Conform", "Diverge", 1, WordAssociationQandA.DIFFICULTY_MEDIUM);
        addQuestion(q37);
        WordAssociationQandA q38 = new WordAssociationQandA("Agree, Correspond, Comply", "Overflow", "Conformance", 2, WordAssociationQandA.DIFFICULTY_MEDIUM);
        addQuestion(q38);
        WordAssociationQandA q39 = new WordAssociationQandA("Emergence, Appearance, Rise", "Inception", "Checklist", 1, WordAssociationQandA.DIFFICULTY_HARD);
        addQuestion(q39);
        WordAssociationQandA q40 = new WordAssociationQandA("Amiable, Friendly, Cheerful", "Menace", "Welcoming", 2, WordAssociationQandA.DIFFICULTY_EASY);
        addQuestion(q40);
        WordAssociationQandA q41 = new WordAssociationQandA("Travel, Recreation, Entertainment", "Coat", "Leisure", 2, WordAssociationQandA.DIFFICULTY_EASY);
        addQuestion(q41);
        WordAssociationQandA q42 = new WordAssociationQandA("Scope, Light, Range", "Spectrum", "Loud", 2, WordAssociationQandA.DIFFICULTY_MEDIUM);
        addQuestion(q42);
        WordAssociationQandA q43 = new WordAssociationQandA("Math, Equation, Rule", "Formula", "Prospective", 1, WordAssociationQandA.DIFFICULTY_EASY);
        addQuestion(q43);
        WordAssociationQandA q44 = new WordAssociationQandA("Instead, Substitute, Agent", "Earnings", "Proxy", 2, WordAssociationQandA.DIFFICULTY_MEDIUM);
        addQuestion(q44);
        WordAssociationQandA q45 = new WordAssociationQandA("Education, Training, Exercise", "Excellence", "Discipline", 2, WordAssociationQandA.DIFFICULTY_EASY);
        addQuestion(q45);
        WordAssociationQandA q46 = new WordAssociationQandA("Change, Conversion, Revision", "Amendment", "Unfamiliar", 1, WordAssociationQandA.DIFFICULTY_MEDIUM);
        addQuestion(q46);
        WordAssociationQandA q47 = new WordAssociationQandA("Laugh, Enjoy, Comedy", "Despair", "Amusement", 2, WordAssociationQandA.DIFFICULTY_MEDIUM);
        addQuestion(q47);
        WordAssociationQandA q48 = new WordAssociationQandA("Degrading, Humiliating, Shame", "Ignominious", "Sartorial", 1, WordAssociationQandA.DIFFICULTY_HARD);
        addQuestion(q48);
        WordAssociationQandA q49 = new WordAssociationQandA("Hatred, Loating, Abhorrence", "Odium", "Lexicography", 1, WordAssociationQandA.DIFFICULTY_HARD);
        addQuestion(q49);
        WordAssociationQandA q50 = new WordAssociationQandA("Extra, Spare, Surplus", "Exultant", "Supernumerary", 2, WordAssociationQandA.DIFFICULTY_HARD);
        addQuestion(q50);
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