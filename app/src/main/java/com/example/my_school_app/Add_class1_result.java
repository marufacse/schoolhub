 package com.example.my_school_app;

 import android.app.ProgressDialog;
import android.content.DialogInterface;
 import android.content.Intent;
 import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
 import com.example.my_school_app.View.Class1_result_teacher_site;

 import java.util.HashMap;
import java.util.Map;

 public class Add_class1_result extends AppCompatActivity {

     //private String insertDataURL = "http://192.168.56.1/android/crudmysql/volleycrud/addProduct.php";


//     private String insertDataURL = "http://10.0.2.2:8081/Software_project/addCustomer.php";
     //  private String insertDataURL = "http://stamasoft.com/android/stu_master_details/Registration.php";



     private static String TAG = Add_class1_result.class.getSimpleName();
     private Button insertData,previous;
     double gpa,point;
     private EditText editIname, editroll,editgpa,editpoint;

     // Progress dialogs
     private ProgressDialog pDialog;
 String GPA,total;


     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.add_class1_result);
         insertData = (Button) findViewById(R.id.btnaddcustomer);
         previous=findViewById(R.id.btnaddcustomer1);


        /* editIname = (EditText) findViewById(R.id.c_name_1);
         editroll = (EditText) findViewById(R.id.c_roll_1);
         editgpa = (EditText) findViewById(R.id.c_gpa_1);
         editpoint = (EditText) findViewById(R.id.c_point_1);*/


         editIname = findViewById(R.id.c_name);
         editroll = findViewById(R.id.c_roll);
         editgpa = findViewById(R.id.c_gpa);
         editpoint =findViewById(R.id.c_point);


         pDialog = new ProgressDialog(this);
         pDialog.setMessage("Please wait...");
         pDialog.setCancelable(false);




         insertData.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 // insertDataOnline();

                 // insertdatanewway2();
                 confirmadddata();
             }
         });

         previous.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent ee=new Intent(getApplicationContext(), Class1_result_teacher_site.class);
                 startActivity(ee);
             }
         });



     }//slb


     private void confirmadddata(){
         androidx.appcompat.app.AlertDialog.Builder alertDialogBuilde  = new androidx.appcompat.app.AlertDialog.Builder (this);
         alertDialogBuilde.setMessage("Are you sure you want to Add Data?");

         alertDialogBuilde.setPositiveButton("Yes",
                 new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface arg0, int arg1) {
                         insertdatanewway2();
                         //  startActivity(new Intent(Insert_new.this,ViewproductList_2.class));
                     }
                 });

         alertDialogBuilde.setNegativeButton("No",
                 new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface arg0, int arg1) {

                     }
                 });

         androidx.appcompat.app.AlertDialog alertDialog = alertDialogBuilde.create();
         alertDialog.show();
     }



 //--------------------------

     private void showpDialog() {
         if (!pDialog.isShowing()) pDialog.show();
     }

     private void hidepDialog() {
         if (pDialog.isShowing()) pDialog.dismiss();
     }


     //------------------
     //---------insert rnd----
     public void insertdatanewway2() {

         showpDialog();

         StringRequest stringRequest = new StringRequest(Request.Method.POST, Config_url.insertclass1result, new Response.Listener<String>() {
             @Override
             public void onResponse(String response) {
                 //progressBar.setVisibility(View.GONE);
                 editroll.setText("");
                 editIname.setText("");
                 editgpa.setText("");
                 editpoint.setText("");


                 Toast.makeText(getApplicationContext(), "Data Inserted Successfully", Toast.LENGTH_SHORT).show();


             }
         }, new Response.ErrorListener() {
             @Override
             public void onErrorResponse(VolleyError error) {
                 Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
             }
         }) {
             @Override
             protected Map<String, String> getParams() throws AuthFailureError {

                 Map<String, String> parameters = new HashMap<String, String>();
                // gpa=Double.parseDouble(editgpa.getText().toString());
              //point=Double.parseDouble(editpoint.getText().toString());

                           // GPA=String.valueOf(gpa);
                 //total=String.valueOf(point);
                 parameters.put("c_roll", editroll.getText().toString().trim());
                 parameters.put("c_name", editIname.getText().toString().trim());
                 parameters.put("c_gpa", editgpa.getText().toString());
                 parameters.put("c_point", editpoint.getText().toString());

                 hidepDialog();
                 return parameters;
             }
         };

         AppSingleton1.getInstance(this).addToRequestQueue(stringRequest,TAG);
     }
     //---------------------
 }//mlb
