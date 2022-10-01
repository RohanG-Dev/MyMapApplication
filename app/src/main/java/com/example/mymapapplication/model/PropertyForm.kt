package com.example.mymapapplication.model

import android.content.Context
import android.location.Location
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import com.example.mymapapplication.MapsActivity
import com.example.mymapapplication.R
import com.example.mymapapplication.databinding.ActivityMapsBinding
import com.example.mymapapplication.viewModel.PropertyViewModel
import com.google.android.gms.maps.model.Marker


/**
 * This class is Responsible
 * - Functionality related to Property Form
 * - Saving the Property details to DB
 */
class PropertyForm {


    /**
     * Display Form with Details
     */
    fun showFormDetails(

        context: MapsActivity,
        binding: ActivityMapsBinding,
        currentLocation: Location,
        viewModel: PropertyViewModel?,
        mMarker: Marker
    ) {

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popView = inflater.inflate(R.layout.form_details, null)

        val width = LinearLayout.LayoutParams.MATCH_PARENT
        val height = LinearLayout.LayoutParams.WRAP_CONTENT

        val popupWindow = PopupWindow(popView, width, height, true)
        popupWindow.showAtLocation(binding.root, Gravity.TOP, 0, 0)
        popView.setBackgroundColor(context.resources.getColor(R.color.white))


        val selectedLocation: String =
            " ${currentLocation.latitude}  ,  ${currentLocation.longitude} "
        popView.findViewById<TextView>(R.id.propertyCoordinateDetails).text = selectedLocation

        clearLocationAndMarker(mMarker, popView)

        submitSavePropertyDetails(mMarker, popupWindow, viewModel, context, popView)


    }

    /**
     *  Submit the Form and Save the Property Details to DB
     */
    private fun submitSavePropertyDetails(
        mMarker: Marker,
        popupWindow: PopupWindow,
        viewModel: PropertyViewModel?,
        context: MapsActivity,
        popView: View
    ) {

        val submitBtn = popView.findViewById<Button>(R.id.submit)
        submitBtn.setOnClickListener(View.OnClickListener { view ->

            var name = popView.findViewById<EditText>(R.id.propertyNameDetails).text.toString()
            var loc = popView.findViewById<EditText>(R.id.propertyCoordinateDetails).text.toString()


            if (name.isNotEmpty() && loc.isNotEmpty()) {

                mMarker.title = name
                popupWindow.dismiss()
                var prepertyEntity = PropertyEntity(0, name, loc)
                viewModel?.insertPropertyInfoVM(prepertyEntity)
            } else {
                Toast.makeText(context, "Please Enter Property Details", Toast.LENGTH_SHORT).show()
            }

        })
    }


    private fun clearLocationAndMarker(mMarker: Marker, popView: View) {

        val closePopup = popView.findViewById<ImageButton>(R.id.popClose)
        closePopup.setOnClickListener(View.OnClickListener { view ->

            popView.findViewById<EditText>(R.id.propertyNameDetails).text.clear()
            popView.findViewById<EditText>(R.id.propertyCoordinateDetails).text.clear()
            mMarker.remove()
        })
    }
}