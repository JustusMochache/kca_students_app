package com.example.kca_student_app.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.kca_student_app.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class NewsActivity extends AppCompatActivity {

    FirebaseDatabase mDatabase;
    DatabaseReference mRef;
    FirebaseStorage mStorage;
    ImageButton imageButton;
    EditText edtfirst,edtlast;
    Button btninsert;
    private  static final int Gallery_Code=1;
    Uri imageUrl = null;
     ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

      imageButton = this.findViewById(R.id.imageButton);
        edtfirst = findViewById(R.id.editfirstname);
        edtlast = findViewById(R.id.editlastname);
        btninsert = findViewById(R.id.btnInset);

        mDatabase = FirebaseDatabase.getInstance();
        mRef = mDatabase.getReference().child("Student");
        mStorage = FirebaseStorage.getInstance();

      //  progressDialog = new ProgressDialog(this);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("Image/*");
                startActivityForResult(intent, Gallery_Code);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Gallery_Code && resultCode==RESULT_OK)
        {
            imageUrl = data.getData();
            imageButton.setImageURI(imageUrl);
        }
        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 final String fn = edtfirst.getText().toString().trim();
                 final String ln = edtlast.getText().toString().trim();

                if (!(fn.isEmpty() && ln.isEmpty() && imageUrl !=null))
                {
                    Toast.makeText(getApplicationContext(),"Uploading Image...",Toast.LENGTH_LONG).show();
                    //add uri path instead of putfile which gets http request 404 error
                

                    StorageReference filepath = mStorage.getReference().child("imagePost").child(imageUrl.getLastPathSegment());
                    filepath.putFile(imageUrl).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Task<Uri> downloadUrl = taskSnapshot.getStorage().getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    String t = task.getResult().toString();


                                    DatabaseReference newPost = mRef.push();


                                    newPost.child("FirstName").setValue(fn);
                                    newPost.child("LastName").setValue(ln);
                                    newPost.child("image").setValue(task.getResult().toString());
                                   // progressDialog.dismiss();
                                }
                            });
                        }
                    });
                }
            }
        });
    }

}