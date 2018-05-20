package mimiz.week6;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class SQLiteFriendsData extends Activity {

    private final String dbName = "kakao";
    private final String tableName = "person";

    private final String[] name = new String[]{"이보영", "정연주", "김진경", "차학연","안소희", "최진리", "배수지", "주우재", "서예지", "남윤수"};

    private final String[] message = new String[]{"instagram", "#", "model", "N", "actor", "설리가 진리", "숮", "라디오 들어주세요!", "^^", "♬"};

    ArrayList<HashMap<String, String>> personList;
    ListView list;
    private static final String TAG_NAME = "name";
    private static final String TAG_MESSAGE ="message";

    SQLiteDatabase sampleDB = null;
    ListAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_first);

        list = (ListView) findViewById(R.id.friends);
        personList = new ArrayList<HashMap<String,String>>();


        try {
            sampleDB = this.openOrCreateDatabase(dbName, MODE_PRIVATE, null);

            sampleDB.execSQL("CREATE TABLE IF NOT EXISTS " + tableName
                    + " (name VARCHAR(20), message VARCHAR(20) );");

            sampleDB.execSQL("DELETE FROM " + tableName  );

            for (int i=0; i<name.length; i++ ) {
                sampleDB.execSQL("INSERT INTO " + tableName
                        + " (name, message)  Values ('" + name[i] + "', '" + message[i]+"');");
            }

            sampleDB.close();

        } catch (SQLiteException se) {
            Toast.makeText(getApplicationContext(),  se.getMessage(), Toast.LENGTH_LONG).show();
            Log.e("", se.getMessage());

        }

        showList();

    }

    protected void showList(){

        try {

            SQLiteDatabase ReadDB = this.openOrCreateDatabase(dbName, MODE_PRIVATE, null);

            Cursor c = ReadDB.rawQuery("SELECT * FROM " + tableName, null);

            if (c != null) {

                if (c.moveToFirst()) {
                    do {

                        String Name = c.getString(c.getColumnIndex("name"));
                        String Message = c.getString(c.getColumnIndex("message"));

                        HashMap<String,String> persons = new HashMap<String,String>();

                        persons.put(TAG_NAME,Name);
                        persons.put(TAG_MESSAGE,Message);

                        personList.add(persons);

                    } while (c.moveToNext());
                }
            }

            ReadDB.close();

            adapter = new SimpleAdapter(
                    this, personList, R.layout.friends_list,
                    new String[]{TAG_NAME,TAG_MESSAGE},
                    new int[]{ R.id.list_name, R.id.list_message}
            );

            list.setAdapter(adapter);

        } catch (SQLiteException se) {
            Toast.makeText(getApplicationContext(),  se.getMessage(), Toast.LENGTH_LONG).show();
            Log.e("",  se.getMessage());
        }
    }
}