package ru.netology.lists;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.StyleableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView list = findViewById(R.id.list);

        String[] arrayContent = getString(R.string.large_text).split("\n\n");
        int numOfSymbolsPre = arrayContent.length;
        String numOfSymbols = String.valueOf(numOfSymbolsPre);

        List<Map<String,String>> data = new ArrayList<>();
        Map<String, String> listMap = new HashMap<>();
        listMap.put("headline", arrayContent.toString());
        listMap.put("subtitle", numOfSymbols);
        data.add(listMap);

        BaseAdapter listContentAdapter = createAdapter(data);
        list.setAdapter(listContentAdapter);
    }

    @NonNull
    private BaseAdapter createAdapter(List<Map<String,String>> data) {
        return new SimpleAdapter(this, data,
                R.layout.my_list_view,
                new String[] {"headline", "subtitle"},
                new int[] {R.id.tView_first, R.id.tView_second});
    }

    @NonNull
    private List<Map<String,String>> prepareContent() {
        return data;
    }
}
