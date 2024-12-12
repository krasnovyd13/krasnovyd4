package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddNoteActivity extends AppCompatActivity {

    EditText editTextNoteName, editTextNoteContent;
    Button buttonSaveNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editTextNoteName = findViewById(R.id.editTextNoteName);
        editTextNoteContent = findViewById(R.id.editTextNoteContent);
        buttonSaveNote = findViewById(R.id.buttonSaveNote);

        buttonSaveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextNoteName.getText().toString().trim();
                String content = editTextNoteContent.getText().toString().trim();

                if (name.isEmpty()) {
                    Toast.makeText(AddNoteActivity.this, getString(R.string.empty_name_warning), Toast.LENGTH_SHORT).show();
                } else if (content.isEmpty()) {
                    Toast.makeText(AddNoteActivity.this, getString(R.string.empty_content_warning), Toast.LENGTH_SHORT).show();
                } else {
                    MainActivity.notesList.add(name + ": " + content);
                    finish();
                }
            }
        });
    }
}
