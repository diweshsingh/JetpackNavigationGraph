package info.spreadcode.jetpacknavigationgraph.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import info.spreadcode.jetpacknavigationgraph.NavigationGraphExampleActivity
import info.spreadcode.jetpacknavigationgraph.R

/**
*
* SettingFragment - Demonstrate the simple setting screen.
*/
class SettingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }




}
