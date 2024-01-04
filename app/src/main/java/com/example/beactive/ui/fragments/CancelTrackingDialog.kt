package com.example.beactive.ui.fragments

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.beactive.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class CancelTrackingDialog: DialogFragment(){

    private var yesListener: (() -> Unit)? = null

    fun setYesListener(listener: () -> Unit){
        yesListener = listener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return MaterialAlertDialogBuilder(requireContext(), R.style.AlertDialogTheme)
            .setTitle("Anulować aktywność?")
            .setMessage("Czy na pewno chcesz anulować aktywność? Wszystkie dane zostaną usunięte!")
            .setIcon(R.drawable.ic_delete)
            .setPositiveButton("Tak"){ _, _ ->
                yesListener?.let { yes ->
                    yes()
                }

            }
            .setNegativeButton("Nie") {dialogInterface, _ ->
                dialogInterface.cancel()
            }
            .create()
    }
}