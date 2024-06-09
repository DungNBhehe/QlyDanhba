package com.example.qlydanhba;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Button btnSelectEmployee, btnSelectDepartment;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Adjust insets for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        listView = findViewById(R.id.listView);
        btnSelectEmployee = findViewById(R.id.btnSelectEmployee);
        btnSelectDepartment = findViewById(R.id.btnSelectDepartment);

        // Initial data for the ListView
        String[] initialData = {"Item 1", "Item 2", "Item 3"};
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, initialData);
        listView.setAdapter(adapter);

        // Set up button click listeners
        btnSelectEmployee.setOnClickListener(v -> {
            // Data for employee selection
            String[] employeeData = {"Employee 1", "Employee 2", "Employee 3"};
            updateListViewData(employeeData);
        });

        btnSelectDepartment.setOnClickListener(v -> {
            // Data for department selection
            String[] departmentData = {"Department 1", "Department 2", "Department 3"};
            updateListViewData(departmentData);
        });
    }

    // Method to update ListView data
    private void updateListViewData(String[] data) {
        adapter.clear();
        adapter.addAll(data);
        adapter.notifyDataSetChanged();
    }
}