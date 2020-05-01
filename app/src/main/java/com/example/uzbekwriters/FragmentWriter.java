package com.example.uzbekwriters;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class FragmentWriter extends Fragment {
    private String[] mGroupsArray = new String[] { "Писатели средневековья", "Писатели Советской эпохи", "Писатели независимого Узбекистана"};

    private String[] medival = new String[] { "Махмуд Пахлаван", "Бабарахим Машраб", "Алишер Навои", "Захриддин Бабур", "Надира" };
    private String[] ussr = new String[] { "Абдулла Кадыри", "Абдурауф Фитрат", "Гафур Гулям", "Зульфия"};
    private String[] independence = new String[] { "Саид Ахмад", "Абдулла Арипов", "Эркин Вахидов" };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_writers, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Map<String, String> map;
        // коллекция для групп
        ArrayList<Map<String, String>> groupDataList = new ArrayList<>();
        // заполняем коллекцию групп из массива с названиями групп

        for (String group : mGroupsArray) {
            // заполняем список атрибутов для каждой группы
            map = new HashMap<>();
            map.put("groupName", group); // время года
            groupDataList.add(map);
        }

        // список атрибутов групп для чтения
        String groupFrom[] = new String[] { "groupName" };
        // список ID view-элементов, в которые будет помещены атрибуты групп
        int groupTo[] = new int[] { android.R.id.text1 };

        // создаем общую коллекцию для коллекций элементов
        ArrayList<ArrayList<Map<String, String>>> сhildDataList = new ArrayList<>();

        // в итоге получится сhildDataList = ArrayList<childDataItemList>

        // создаем коллекцию элементов для первой группы
        ArrayList<Map<String, String>> childDataItemList = new ArrayList<>();
        // заполняем список атрибутов для каждого элемента
        for (String month : medival) {
            map = new HashMap<>();
            map.put("writerName", month); // название месяца
            childDataItemList.add(map);
        }
        // добавляем в коллекцию коллекций
        сhildDataList.add(childDataItemList);

        // создаем коллекцию элементов для второй группы
        childDataItemList = new ArrayList<>();
        for (String month : ussr) {
            map = new HashMap<>();
            map.put("writerName", month);
            childDataItemList.add(map);
        }
        сhildDataList.add(childDataItemList);

        // создаем коллекцию элементов для третьей группы
        childDataItemList = new ArrayList<>();
        for (String month : independence) {
            map = new HashMap<>();
            map.put("writerName", month);
            childDataItemList.add(map);
        }
        сhildDataList.add(childDataItemList);


        сhildDataList.add(childDataItemList);

        // список атрибутов элементов для чтения
        String childFrom[] = new String[] { "writerName" };
        // список ID view-элементов, в которые будет помещены атрибуты
        // элементов
        int childTo[] = new int[] { android.R.id.text1 };

        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                getActivity(), groupDataList,
                android.R.layout.simple_expandable_list_item_1, groupFrom,
                groupTo, сhildDataList, android.R.layout.simple_list_item_1,
                childFrom, childTo);

        ExpandableListView expandableListView = view.findViewById(R.id.exp_listview);
        expandableListView.setAdapter(adapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                final Bundle bundle = new Bundle();
//                bundle.putInt("position", i1);
                bundle.putInt("name", passResult(i, i1));
                Fragment pager = new PagerFragment();
                pager.setArguments(bundle);
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, pager)
                        .addToBackStack(null)
                        .commit();
                return false;
            }
        });
    }

    public int passResult(int i, int i1){
        if (i == 2)
            return i1 + 9;
        return i1 + i * 5;
    }

}
