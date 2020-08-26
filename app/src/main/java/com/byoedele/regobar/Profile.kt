package com.byoedele.regobar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profile.*

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val bundle = intent.extras
        val name = bundle!!.getString("name")
        val email = bundle!!.getString("email")
        val phoneNo = bundle!!.getString("phoneNum")
        val sex = bundle!!.getString("sex")

        // This part sets the text of the
        n1name.text = "Name: $name"
        emailnew.text = "Email: $email"
        phoneNumNew.text = "Phone Number: $phoneNo"
        sexNew.text = "Sex: $sex"
    }
}