package com.guan.dialogfragment;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyDialogFragment extends DialogFragment {

    public static MyDialogFragment newInstance(int type) {
        MyDialogFragment frag = new MyDialogFragment();
        Bundle args = new Bundle();
        args.putInt("DIALOG_TYPE", type);
        frag.setArguments(args);
        return frag;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog dialog = null;
        int dialog_type = getArguments().getInt("DIALOG_TYPE");

        switch (dialog_type) {

            case MainActivity.DIALOG_TYPR_ALERT:
                // Fragment 可以通过getActivity()获取他说附着的Activity引用
                return new AlertDialog.Builder(getActivity())
                        .setIcon(R.mipmap.ic_launcher)
                        .setTitle(getTag())
                        .setPositiveButton(R.string.alert_dialog_ok,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {

                                        Toast.makeText(getActivity(), "确定", Toast.LENGTH_SHORT).show();
                                    }
                                }
                        )
                        .setNegativeButton(R.string.alert_dialog_cancel,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        dismiss();
                                    }
                                }
                        )
                        .create();

            case MainActivity.DIALOG_TYPR_DATE:
                break;

            case MainActivity.DIALOG_TYPR_TIME:
                break;

            default:
                break;
        }

        return dialog;
    }
}
