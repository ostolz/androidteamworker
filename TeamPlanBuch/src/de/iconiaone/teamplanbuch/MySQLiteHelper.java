package de.iconiaone.teamplanbuch;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {
	
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "IconiaDB";
    private static final String TABLENAME_USER = "usertable";
    private static final String TABLENAME_TEAMS = "teamtable";
    private static final String TABLENAME_APPOINTMENTS = "appointmenttable";
    private static final String TABLENAME_ROLES = "roletable";
    
    
    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  
    }

	public MySQLiteHelper(Context context, String name, CursorFactory factory,
			int version, DatabaseErrorHandler errorHandler) {
		super(context, name, factory, version, errorHandler);
	}

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + TABLENAME_USER + " ( " +
                "userid INTEGER PRIMARY KEY AUTOINCREMENT, "
        		+ "username TEXT,"
                + "password TEXT,"
                + "surname TEXT,"
                + "lastname TEXT,"
                + "dateregistered NUMERIC,"
                + "teampreferred INTEGER,"
                + "teamid INTEGER,"
                + "roleid INTEGER,"
                + "email TEXT,"
                + "address TEXT,"
                + "plz TEXT,"
                + "wohnort TEXT" 
                + ")";
        
        String CREATE_TEAM_TABLE = "CREATE TABLE " + TABLENAME_TEAMS + " ( " +
                "teamid INTEGER PRIMARY KEY AUTOINCREMENT, "
        		+ "teamname TEXT,"
                + ")";
        
        String CREATE_APPOINTMENT_TABLE = "CREATE TABLE " + TABLENAME_APPOINTMENTS + " ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, "
        		+ "name TEXT,"
                + "text TEXT,"
                + "startdatetime NUMERIC,"
                + "enddatetime NUMERIC,"
                + ")";

        String CREATE_ROLE_TABLE = "CREATE TABLE " + TABLENAME_ROLES + " ( " +
                "roleid INTEGER PRIMARY KEY AUTOINCREMENT, "
        		+ "rolename TEXT,"
                + "righttomake BOOLEAN,"
                + ")";

        String FILL_TEAM_TABLE = "INSERT INTO "+ TABLENAME_TEAMS +" VALUES(Herren 1)";
        
        String FILL_ROLE_TABLE1 = "INSERT INTO "+ TABLENAME_ROLES +" VALUES(Spieler, false)";
        String FILL_ROLE_TABLE2 = "INSERT INTO "+ TABLENAME_ROLES +" VALUES(Trainer, true)";
        
        String FILL_APPOINTMENT_TABLE1 = "INSERT INTO "+ TABLENAME_APPOINTMENTS +" VALUES(Training, Trainingseinheit Vorbereitung, 12.06.2014 19:30, 12.06.2014 21:00)";
        String FILL_APPOINTMENT_TABLE2 = "INSERT INTO "+ TABLENAME_APPOINTMENTS +" VALUES(Training, Trainingseinheit Vorbereitung, 19.06.2014 19:30, 19.06.2014 21:00)";
        String FILL_APPOINTMENT_TABLE3 = "INSERT INTO "+ TABLENAME_APPOINTMENTS +" VALUES(Mannschaftsausflug, Mannschaftsausflug Männer bringt Hartstoff, 20.06.2014 16:30, 22.06.2014 13:00)";
        String FILL_APPOINTMENT_TABLE4 = "INSERT INTO "+ TABLENAME_APPOINTMENTS +" VALUES(Training, Ausnüchtern vom Mannschaftsausflug, 26.06.2014 19:30, 26.06.2014 21:00)";
        
        String FILL_USER_TABLE1 = "INSERT INTO "+ TABLENAME_USER +" VALUES(spieler, iconia, Franz, Iskaner, 05.05.2014, 1, 1, 0, paulaner@weissbier.de, Hofbräuhausstraße 5, 0815, Hefedorf)";
        String FILL_USER_TABLE2 = "INSERT INTO "+ TABLENAME_USER +" VALUES(trainer, iconia, Sehrgay, Fehrlich, 05.05.2014, 1, 1, 1, jack@daniels.de, Kentuckystraße 4, 0815, Freibier)";
        
        try {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_TEAM_TABLE);
        db.execSQL(CREATE_ROLE_TABLE);
        db.execSQL(CREATE_APPOINTMENT_TABLE);
        db.execSQL(FILL_USER_TABLE1);
        db.execSQL(FILL_USER_TABLE2);
        db.execSQL(FILL_TEAM_TABLE);
        db.execSQL(FILL_ROLE_TABLE1);
        db.execSQL(FILL_ROLE_TABLE2);
        db.execSQL(FILL_APPOINTMENT_TABLE1);
        db.execSQL(FILL_APPOINTMENT_TABLE2);
        db.execSQL(FILL_APPOINTMENT_TABLE3);
        db.execSQL(FILL_APPOINTMENT_TABLE4);
        System.out.println("DB erstellt und gefüllt");
        }
        catch(Exception e)
        {
        	System.out.print(e);
        }
    }

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS books");
        this.onCreate(db);
	}

}
