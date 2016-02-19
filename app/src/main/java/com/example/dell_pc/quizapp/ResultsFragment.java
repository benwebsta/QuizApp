package com.example.dell_pc.quizapp;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ResultsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button results;
    String resultString;
    private Button reset;


    public ResultsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ResultsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ResultsFragment newInstance(String param1, String param2) {
        ResultsFragment fragment = new ResultsFragment();
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
        View view = null;
        view = inflater.inflate(R.layout.results, container, false);
        results = (Button)view.findViewById(R.id.resultsButton);
        resultString = PlayActivity.numCorrect + "/2";
        reset = (Button) view.findViewById(R.id.resetButton);
        return view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        results.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TextView) getActivity().findViewById(R.id.totalRight)).setText(resultString);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               PlayActivity.numCorrect = 0;
               getActivity().finish();
            }
        });
    }
}
