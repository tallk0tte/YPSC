package com.ypsc.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHelper {
	public static final String OBJECT = "object";
	public static final String NUMBER = "number";
	public static final String STORAGE_ID = "storage";
	public static final String TABLE_NAME = "mytable";
	public static final String DATA_BASE_NAME = "mydatabase";
	public static int DATABASE_VERSION = 1;
	public static final String TABLE_CREATE = "create table mytable(object text not null, number text not null, storage text not null);";

	DataBaseHelper dbhelper;
	Context ctx;
	SQLiteDatabase db;
	
private static class DataBaseHelper extends SQLiteOpenHelper{
	
	public DataBaseHelper(Context ctx) {
		super(ctx, DATA_BASE_NAME, null, DATABASE_VERSION);
	}//end public DataBaseHelper

	//creates the table
	public void onCreate(SQLiteDatabase db){
		try{
			db.execSQL(TABLE_CREATE);
		}catch(SQLException e){
			e.printStackTrace();}
	}//end onCreate
	
	//upgrades the table with new data
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
		db.execSQL("DROP TABLE IF EXISTS mytable");
		onCreate(db
				);
	}//end onUpgrade
	
}//end DataBaseHelper

			//open the Database
			public DataHelper open(){
				db = dbhelper.getWritableDatabase();
				return this;
			}//end open()
			
			//inserts data into the Database
			public long insertData(String object, String number, String storage){
				ContentValues content = new ContentValues();
				content.put(OBJECT, object);
				content.put(NUMBER, number);
				content.put(STORAGE_ID, storage);
				return db.insert(TABLE_NAME, null, content);
			}//end insertData
	
			//to use when to retrieve the data.
			public Cursor returnData(){
				return db.query(TABLE_NAME, new String[]{OBJECT,NUMBER, STORAGE_ID},null, null, null, null, null );
			}
	
	
}//end DataHelper
