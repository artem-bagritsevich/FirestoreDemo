package com.example.firestoretest

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firestore = Firebase.firestore

        button.setOnClickListener {
            val comment = editText.text?.toString()
            if (comment.isNullOrBlank()) {
                return@setOnClickListener
            }

            firestore.collection("feedback")
                .add(
                    hashMapOf(
                        "comment" to comment
                    )
                )
                .addOnSuccessListener {
                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Failure", Toast.LENGTH_SHORT).show()
                }
        }
    }
}