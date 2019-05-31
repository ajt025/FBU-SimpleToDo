package com.example.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import static com.example.simpletodo.MainActivity.ITEM_POSITION;
import static com.example.simpletodo.MainActivity.ITEM_TEXT;

public class EditItemActivity extends AppCompatActivity {

    // text field containing updated item description
    EditText etItemText;
    // need to track item's pos in the list
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        // resolve the text field from the layout
        etItemText = (EditText) findViewById((R.id.etItemText));
        // set the text field's content from the intent
        etItemText.setText(getIntent().getStringExtra(ITEM_TEXT));
        // track the pos of the item in the list
        position = getIntent().getIntExtra(ITEM_POSITION, 0);
        // set the title bar to reflect the purpose of the view
        getSupportActionBar().setTitle("Edit Item");
    }

    public void onSaveItem(View v) {
        // prepare intent to pass back to MainActivity
        Intent data = new Intent();
        // pass updated item text and original position
        data.putExtra(ITEM_TEXT, etItemText.getText().toString());
        data.putExtra(ITEM_POSITION, position);
        setResult(RESULT_OK, data);
        finish();
    }
}
