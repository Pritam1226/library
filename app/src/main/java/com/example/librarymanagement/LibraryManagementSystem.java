package com.example.librarymanagement;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class LibraryManagementSystem extends AppCompatActivity {

    private EditText etBookTitle, etAuthor, etISBN;
    private Button btnAddBook, btnViewBooks, btnGoToNewActivity;
    private ListView lvBooks;
    private ArrayList<Book> bookList;
    private BookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_management_system);

        etBookTitle = findViewById(R.id.et_book_title);
        etAuthor = findViewById(R.id.et_author);
        etISBN = findViewById(R.id.et_isbn);
        btnAddBook = findViewById(R.id.btn_add_book);
        btnViewBooks = findViewById(R.id.btn_view_books);
        lvBooks = findViewById(R.id.lv_books);
        btnGoToNewActivity = findViewById(R.id.btn_go_to_new_activity);

        bookList = new ArrayList<>();
        bookAdapter = new BookAdapter(this, bookList);

        lvBooks.setAdapter(bookAdapter);

        btnAddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBook();
            }
        });

        btnViewBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewBooks();
            }
        });

        btnGoToNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LibraryManagementSystem.this,findlocalfile.class);
                startActivity(intent);
            }
        });
    }

    private void addBook() {
        String title = etBookTitle.getText().toString();
        String author = etAuthor.getText().toString();
        String isbn = etISBN.getText().toString();

        if (title.isEmpty() || author.isEmpty() || isbn.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        Book book = new Book(title, author, isbn);
        bookList.add(book);
        bookAdapter.notifyDataSetChanged();

        etBookTitle.setText("");
        etAuthor.setText("");
        etISBN.setText("");
    }

    private void viewBooks() {
        bookAdapter.notifyDataSetChanged();
    }
}
