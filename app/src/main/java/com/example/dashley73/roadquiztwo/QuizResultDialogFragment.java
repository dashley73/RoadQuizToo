package com.example.dashley73.roadquiztwo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class QuizResultDialogFragment extends DialogFragment {
    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final MainActivityFragment quizFragment = getQuizFragment();

        builder.setMessage(getString(R.string.results,
                                    quizFragment.totalGuesses,
                                    (900 / (double) quizFragment.totalGuesses)));

        builder.setPositiveButton(R.string.reset_quiz,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int id) {
                        quizFragment.resetQuiz();
                    }
                }
        );

        return builder.create();
    }

    private MainActivityFragment getQuizFragment() {
        return (MainActivityFragment) getFragmentManager().findFragmentById(R.id.quizFragment);
    }
}
