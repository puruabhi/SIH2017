package com.example.abhisheikh.sihapp.activity;

/**
 * Created by kmlkant3497 on 28/3/17.
 */

        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.database.Cursor;
        import android.os.AsyncTask;
        import android.os.Bundle;
        import android.support.annotation.NonNull;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.text.TextUtils;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ProgressBar;
        import android.widget.Toast;

        import com.example.abhisheikh.sihapp.R;
        import com.example.abhisheikh.sihapp.database.DatabaseHandler;
        import com.example.abhisheikh.sihapp.database.TableData;
        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;

        import org.json.JSONException;
        import org.json.JSONObject;

        import java.io.BufferedReader;
        import java.io.BufferedWriter;
        import java.io.InputStreamReader;
        import java.io.OutputStream;
        import java.io.OutputStreamWriter;
        import java.net.HttpURLConnection;
        import java.net.URL;
        import java.net.URLEncoder;
        import java.util.Iterator;

        import javax.net.ssl.HttpsURLConnection;

public class LoginActivity extends AppCompatActivity {

    private EditText inputEmail, inputPassword;
    private ProgressBar progressBar;
    private Button btnLogin;
    private Toolbar toolbar;
    String username,password,memberStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set the view now
        setContentView(R.layout.activity_login);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        DatabaseHandler dh = new DatabaseHandler(getBaseContext(), TableData.LoginStatus.DATABASE_NAME);
        Cursor cr = dh.getLoginInfo(dh);
        if (cr.moveToFirst()) {
            memberStatus = cr.getString(0);
            Toast.makeText(this,memberStatus,Toast.LENGTH_SHORT).show();
            nextActivity();
        } else {
            inputEmail = (EditText) findViewById(R.id.email);
            inputPassword = (EditText) findViewById(R.id.password);
            progressBar = (ProgressBar) findViewById(R.id.progressBar);
            btnLogin = (Button) findViewById(R.id.btn_login);
            toolbar = (Toolbar) findViewById(R.id.login_toolbar);
            inputEmail.setText(null);
            inputPassword.setText(null);
            setSupportActionBar(toolbar);
            setTitle(R.string.login_toolbar_title);

            setOnClickListeners();
        }
    }

    private void setOnClickListeners(){
        //Get Firebase auth instance
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = inputEmail.getText().toString();
                password = inputPassword.getText().toString();

                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(getApplicationContext(), "Enter Member ID!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

                //authenticate user
                new SendRequest().execute();
            }
        });
    }

    public void nextActivity(){
        Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        intent.putExtra("status",memberStatus);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public class SendRequest extends AsyncTask<String, Void, String> {

        private ProgressDialog Dialog = new ProgressDialog(LoginActivity.this);

        protected void onPreExecute(){
            Dialog.setMessage("Logging in..");
            Dialog.show();
        }

        protected String doInBackground(String... arg0) {

            try{

                URL url = new URL("http://prabhupriya.in/login.php");

                JSONObject postDataParams = new JSONObject();


                postDataParams.put("user", username);
                postDataParams.put("pass", password);

                Log.e("params",postDataParams.toString());

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(15000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);

                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(getPostDataString(postDataParams));

                writer.flush();
                writer.close();
                os.close();

                int responseCode=conn.getResponseCode();

                if (responseCode == HttpsURLConnection.HTTP_OK) {

                    BufferedReader in=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuffer sb = new StringBuffer("");
                    String line="";

                    while((line = in.readLine()) != null) {

                        sb.append(line);
                        break;
                    }

                    in.close();
                    return sb.toString();

                }
                else {
                    return new String("false : "+responseCode);
                }
            }
            catch(Exception e){
                return new String("Exception: " + e.getMessage());
            }
        }

        @Override
        protected void onPostExecute(String result) {

            Dialog.dismiss();
            try {
                JSONObject baseObject=new JSONObject(result);
                String status = baseObject.getString("status");
                memberStatus = status;
                if(status.equals("1")||status.equals("2")){
                    DatabaseHandler dh = new DatabaseHandler(getBaseContext(), TableData.LoginStatus.DATABASE_NAME);
                    Cursor cr = dh.getLoginInfo(dh);
                    if(!cr.moveToFirst()){
                        dh.addLoginInfo(dh,status,"M101");
                    }
                    else{
                        Log.d("Login Activity","Already logged in");
                    }
                    nextActivity();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Wrong username or password",Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Toast.makeText(getApplicationContext(), result,
                    Toast.LENGTH_LONG).show();

        }
    }

    public String getPostDataString(JSONObject params) throws Exception {

        StringBuilder result = new StringBuilder();
        boolean first = true;

        Iterator<String> itr = params.keys();

        while(itr.hasNext()){

            String key= itr.next();
            Object value = params.get(key);

            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(key, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(value.toString(), "UTF-8"));

        }
        return result.toString();
    }
    @Override
    protected void onResume(){
        super.onResume();
        if(inputEmail!=null && inputPassword!=null) {
            inputEmail.setText(null);
            inputPassword.setText(null);
        }
        setOnClickListeners();
    }
}

