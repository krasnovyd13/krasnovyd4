package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView;
import androidx.appcompat.app.AppCompatActivity;

public class DeleteNoteActivity extends AppCompatActivity {

    ListView listViewNotesToDelete;
    Button buttonDeleteSelectedNote;
    int selectedIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_note);

        listViewNotesToDelete = findViewById(R.id.listViewNotesToDelete);
        buttonDeleteSelectedNote = findViewById(R.id.buttonDeleteSelectedNote);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, MainActivity.notesList);
        listViewNotesToDelete.setAdapter(adapter);
        listViewNotesToDelete.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        listViewNotesToDelete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedIndex = position;
            }
        });

        buttonDeleteSelectedNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedIndex >= 0) {
                    MainActivity.notesList.remove(selectedIndex);
                    adapter.notifyDataSetChanged();
                    selectedIndex = -1;
                }
            }
        });
    }
}
