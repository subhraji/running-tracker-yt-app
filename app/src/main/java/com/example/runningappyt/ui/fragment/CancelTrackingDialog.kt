package com.example.runningappyt.ui.fragment

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.runningappyt.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class CancelTrackingDialog: DialogFragment() {

    private var yesListener: (() -> Unit)? = null

    fun setYesListener(listener: () -> Unit){
        yesListener = listener
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return MaterialAlertDialogBuilder(requireContext(), R.style.AlertDialogTheme)
            .setTitle("Cancel the run?")
            .setMessage("Are you sure to cancel the run and delete all the data?")
            .setIcon(R.drawable.baseline_delete_24)
            .setPositiveButton("Yes"){ _, _ ->
                yesListener?.let { yes ->
                    yes
                }
            }
            .setNegativeButton("No"){ dialogInterface, _ ->
                dialogInterface.cancel()
            }
            .create()

    }
}