package com.example.assign2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*



class MyFrag : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var decimalSpinner: Spinner
    private lateinit var convertButton: Button
    private lateinit var binaryResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_my, container, false)
        decimalSpinner = view.findViewById(R.id.decimal_spinner)
        convertButton = view.findViewById(R.id.convert_button)
        binaryResult = view.findViewById(R.id.binary_result)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        convertButton.setOnClickListener {
            val decimalNumber = decimalSpinner.selectedItem.toString().toInt()
            val binaryString = Integer.toBinaryString(decimalNumber)
            binaryResult.text = binaryString
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MyFrag().apply {
                arguments = Bundle().apply {

                }
            }
    }
}