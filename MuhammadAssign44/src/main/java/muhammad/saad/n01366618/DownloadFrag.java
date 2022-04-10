package muhammad.saad.n01366618;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DownloadFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DownloadFrag extends Fragment {

    View view;
    ListView listView;
    ImageView imageView;
    ProgressBar progressBar;


    // Progress dialog type (0 - for Horizontal progress bar)
    public static final int progress_bar_type = 0;

    // File url to download
    private static String file_url = "https://api.androidhive.info/progressdialog/hive.jpg";


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DownloadFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DownloadFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static DownloadFrag newInstance(String param1, String param2) {
        DownloadFrag fragment = new DownloadFrag();
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
        view = inflater.inflate(R.layout.fragment_download, container, false);
        listView = view.findViewById(R.id.muhammad_listView);
        progressBar = view.findViewById(R.id.muhammad_progressBar);
        imageView = view.findViewById(R.id.muhammad_my_image);
        progressBar.setVisibility(view.INVISIBLE);
        List<String> list = new ArrayList<>();
        list.add("Pakistan Flag");
        list.add("Canada Flag");
        list.add("Australia Flag");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String n = list.get(i);
                if (n == "Pakistan Flag") {
                    // Toast.makeText(getContext(),"this is it",Toast.LENGTH_SHORT).show();
                    new Downloader().execute("https://i.pinimg.com/originals/dd/b0/fa/ddb0fa82fd09bd1bbc3654b652836714.png");


                } else if(n == "Canada Flag") {
                    new Downloader().execute("https://cdn.imgbin.com/25/9/8/imgbin-flag-of-canada-maple-leaf-national-flag-canada-flag-zrp0KhJpzGJEPxR8zDqhTKxH4.jpg");
                }

                else if(n == "Australia Flag") {
                    new Downloader().execute("https://cdn3.iconfinder.com/data/icons/world-flags-square-vol-1/48/Australia-512.png");
                }

            }
        });
        return view;
    }


    private class Downloader extends AsyncTask<String, Void, Bitmap> {
        HttpURLConnection httpURLConnection;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }


        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                Thread.sleep(6000);
                URL url = new URL(strings[0]);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                Bitmap temp = BitmapFactory.decodeStream(inputStream);
                return temp;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                httpURLConnection.disconnect();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if(imageView!= null) {
                progressBar.setVisibility(View.INVISIBLE);
                imageView.setImageBitmap(bitmap);
            }

            else {
                progressBar.setVisibility(View.VISIBLE);
            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }




}