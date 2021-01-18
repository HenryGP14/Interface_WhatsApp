package com.example.interfas_whatsapp.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;

import com.example.interfas_whatsapp.Adapter.EstadoAdapter;
import com.example.interfas_whatsapp.Adapter.UserAdapter;
import com.example.interfas_whatsapp.Models.user;
import com.example.interfas_whatsapp.R;
import com.example.interfas_whatsapp.WebService.Asynchtask;
import com.example.interfas_whatsapp.WebService.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link tabEstado#newInstance} factory method to
 * create an instance of this fragment.
 */
public class tabEstado extends Fragment implements Asynchtask {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public tabEstado() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment tabEstado.
     */
    // TODO: Rename and change types and number of parameters
    public static tabEstado newInstance(String param1, String param2) {
        tabEstado fragment = new tabEstado();
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

    private String URL = "https://reqres.in/api/users";
    public ArrayList<user> usuarios;
    private RecyclerView recyclerView;
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_tab_estado, container, false);
        recyclerView = v.findViewById(R.id.estado_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        Map<String, String> datos = new HashMap<String, String>();
        WebService webService = new WebService(URL, datos,getContext(), tabEstado.this);
        webService.execute("GET");

        return v;
    }

    @Override
    public void processFinish(String result) throws JSONException {
        usuarios = new ArrayList<user> ();

        try {

            JSONObject JSONlista =  new JSONObject(result);
            JSONArray JSONlistaUsuarios=  JSONlista.getJSONArray("data");

            usuarios = user.JsonObjectsBuild(JSONlistaUsuarios);

            EstadoAdapter adapatorEstado = new EstadoAdapter(getContext(), usuarios);

            int resId = R.anim.layout_animation_down_to_up;
            LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getContext(), resId);
            recyclerView.setLayoutAnimation(animation);

            recyclerView.setAdapter(adapatorEstado);
        }catch (JSONException e)
        {
            Toast.makeText(this.getContext(),e.getMessage(),Toast.LENGTH_LONG);
        }
    }
}