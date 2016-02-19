package com.example.dell_pc.quizapp;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuestionTwo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionTwo extends Fragment {
    String correctAnswer = "Pikachu";
    String userAnswer;
    EditText answer2Text;
    private Button submit2;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public QuestionTwo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuestionTwo.
     */
    // TODO: Rename and change types and number of parameters
    public static QuestionTwo newInstance(String param1, String param2) {
        QuestionTwo fragment = new QuestionTwo();
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
        view = inflater.inflate(R.layout.question2, container, false);

        submit2 = (Button)view.findViewById(R.id.submitButton2);
        return view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        submit2 = (Button)view.findViewById(R.id.submitButton2);
        submit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer;
                answer2Text = (EditText) getActivity().findViewById(R.id.answer2);
                userAnswer = answer2Text.getText().toString();
                answer = userAnswer.trim();
                if (answer.equalsIgnoreCase(correctAnswer)) {
                    PlayActivity.numCorrect++;
                }
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_fragment_container, new ResultsFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}
