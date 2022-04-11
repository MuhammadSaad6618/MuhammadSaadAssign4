package muhammad.saad.n01366618;

import android.graphics.Color;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingsFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingsFrag extends Fragment {
    View view;
    RadioGroup radioGroup;
    ConstraintLayout constraintLayout;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SettingsFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingsFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static SettingsFrag newInstance(String param1, String param2) {
        SettingsFrag fragment = new SettingsFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.settings_frag, container, false);
        radioGroup = view.findViewById(R.id.muhammad_radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton1 = (RadioButton) view.findViewById(R.id.muhammad_yellow);
                RadioButton radioButton2 = (RadioButton) view.findViewById(R.id.muhammad_red);
                RadioButton radioButton3 = (RadioButton) view.findViewById(R.id.muhammad_violet);
                //HomeFrag homeFrag = new HomeFrag();
               // homeFrag.getView().setBackgroundColor(Color.YELLOW);
                //homeFrag = (HomeFrag) getFragmentManager().findFragmentById(R.id.muhammad_homelayout);
                if (radioButton1.isChecked()) {
                    Toast.makeText(getContext(), "yellow", Toast.LENGTH_SHORT).show();
                  //  homeFrag.getView().setBackgroundColor(Color.YELLOW);

                } else if (radioButton2.isChecked()) {
                    Toast.makeText(getContext(), "red", Toast.LENGTH_SHORT).show();

                } else if (radioButton3.isChecked()) {
                    Toast.makeText(getContext(), "violet", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }


}