package muhammad.saad.n01366618;
// Muhammad Saad , n01366618, Section RNA

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SaSrv#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SaSrv extends Fragment {
    View view;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SaSrv() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SaSrv.
     */
    // TODO: Rename and change types and number of parameters
    public static SaSrv newInstance(String param1, String param2) {
        SaSrv fragment = new SaSrv();
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
        view =  inflater.inflate(R.layout.sa_srv, container, false);
        Spinner spinner = view.findViewById(R.id.muhammad_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),R.array.cities, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String a = adapterView.getItemAtPosition(i).toString();
                if(a == getString(R.string.name_karachi)) {
                    Toast.makeText(getContext(),getString(R.string.name_karachi),Toast.LENGTH_SHORT).show();
                }

                else if(a == getString(R.string.name_dubai)) {
                    Toast.makeText(getContext(),getString(R.string.name_dubai),Toast.LENGTH_SHORT).show();
                }

                else if(a == getString(R.string.name_paris)) {
                    Toast.makeText(getContext(),getString(R.string.name_paris),Toast.LENGTH_SHORT).show();
                }

                else if(a == getString(R.string.name_new_york)) {
                    Toast.makeText(getContext(),getString(R.string.name_new_york),Toast.LENGTH_SHORT).show();
                }

                else if(a == getString(R.string.name_madrid)) {
                    Toast.makeText(getContext(),getString(R.string.name_madrid),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return view;
    }
}