package mimiz.week6;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FirstFragment extends Fragment
{
    private final String dbName = "kakao";
    private final String tableName = "person";

    private final String[] name = new String[]{"이보영", "정연주", "김진경", "차학연","안소희", "최진리", "배수지", "주우재", "서예지", "남윤수"};

    private final String[] phone = new String[]{"instagram", "#", "model", "N", "actor", "설리가 진리", "숮", "라디오 들어주세요!", "^^", "♬"};

    public FirstFragment()
    {
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        ListView listView = view.findViewById(R.id.friends);

        View profile = getLayoutInflater().inflate(R.layout.my_profile, null, false) ;
        listView.addHeaderView(profile);

        View header2 = getLayoutInflater().inflate(R.layout.list_header, null, false) ;
        TextView headerText2 = header2.findViewById(R.id.header_title);
        headerText2.setText("friends");

        listView.addHeaderView(header2);

        ArrayList<ListViewItem> friendsList = new ArrayList<>();

        listView.setAdapter(new ListViewAdapter(getContext(), R.layout.friends_list, friendsList));

        friendsList.add(new ListViewItem(R.drawable.boyeong, "이보영","왜"));
        friendsList.add(new ListViewItem(R.drawable.jeongyeonju, "정연주","넣지를 못하니!"));
        friendsList.add(new ListViewItem(R.drawable.jinkyoung, "김진경","ㅠㅠ"));
        friendsList.add(new ListViewItem(R.drawable.sohee, "안소희","Help me!"));
        friendsList.add(new ListViewItem(R.drawable.sulli, "최진리","정미는"));
        friendsList.add(new ListViewItem(R.drawable.suzy, "배수지","노력했다.."));
        friendsList.add(new ListViewItem(R.drawable.woojae, "주우재","살려줘.."));
        friendsList.add(new ListViewItem(R.drawable.yeji, "미미짱","제발,,"));
        friendsList.add(new ListViewItem(R.drawable.yoonsu, "미미짱","흐규"));

        listView.setAdapter(new ListViewAdapter(getContext(), R.layout.friends_list, friendsList));

        return view;
    }
}