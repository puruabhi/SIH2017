package com.example.abhisheikh.sihapp.database;

import android.provider.BaseColumns;

/**
 * Created by abhisheikh on 1/4/17.
 */

public class TableData {
    public TableData(){

    }

    public static abstract class LoginStatus implements BaseColumns{
        public static final String TABLE_NAME = "login_status";
        public static final String STATUS = "status";
        public static final String MEMBER_ID = "member_id";
        public static final String DATABASE_NAME = "user_info";
    }

    public static abstract class AnnouncementsTable implements BaseColumns{
        public static final String TABLE_NAME = "announcements_info";
        public static final String DATE = "date";
        public static final String DESCRIPTION = "description";
    }

    public static abstract class ContactTable implements BaseColumns{
        public static final String TABLE_NAME = "contacts_info";
        public static final String NAME = "name";
        public static final String POSITION = "position";
        public static final String MOBILE_NUMBER = "mobile_number";
    }

    public static abstract class FundsTable implements BaseColumns{
        public static final String TABLE_NAME = "funds_info";
        public static final String DATE = "date";
        public static final String USED = "used";
        public static final String SOUGHT = "sought";
        public static final String RECEIVED = "received";
    }

    public static abstract class MeetingsTable implements BaseColumns{
        public static final String TABLE_NAME = "meetings_info";
        public static final String DATE = "date";
        public static final String DEVELOPEMENT_PLAN = "developement_plan";
        public static final String DECISION = "decision";
    }

    public static abstract class TasksTable implements BaseColumns{
        public static final String TABLE_NAME = "tasks_info";
        public static final String NAME = "name";
        public static final String DETAIL= "detail";
    }
}
