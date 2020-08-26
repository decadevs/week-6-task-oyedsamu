package com.byoedele.regobar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        validate()
    }

    fun validate() {
        /** On the Registration button, an onclick listener is set to perform necessary validations first.
        * All fields are checked if they are not empty
        * the phone number is validated to be nigerian
         * The email address is validated to be of correct format
        */
        reg_button.setOnClickListener {
            val nameField = findViewById<EditText>(R.id.name).text.toString().trim()
            val emailField = findViewById<EditText>(R.id.emailad).text.toString().trim()
            val phoneNumField = findViewById<EditText>(R.id.phoneNum).text.toString().trim()
            val sex = findViewById<Spinner>(R.id.spinner).selectedItem.toString()

            if (checkEmpty(nameField) ||
                checkEmpty(emailField) ||
                checkEmpty(phoneNumField)
            ) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else if (!checkEmailField(emailField) && !checkPhoneNumField(phoneNumField)) {
                Toast.makeText(this, "Phone number and Email Address incorrect", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            } else if (checkEmailField(emailField) && !checkPhoneNumField(phoneNumField)) {
                Toast.makeText(this, "Phone number format incorrect", Toast.LENGTH_SHORT).show()

                return@setOnClickListener
            } else if (!checkEmailField(emailField) && checkPhoneNumField(phoneNumField)) {
                Toast.makeText(this, "Email address format incorrect", Toast.LENGTH_SHORT).show()

                return@setOnClickListener
            } else {

                /** If Validation passes all conditions, then  is true then send the bundle to the profile Fragment
                */
                val intent = Intent(this, Profile::class.java)
                intent.putExtra("name", nameField)
                intent.putExtra("email", emailField)
                intent.putExtra("phoneNum", phoneNumField)
                intent.putExtra("sex", sex)
                startActivity(intent)
            }
        }

    }

    //    This is the function to check if a field is empty or not
    fun checkEmpty(enteredValue: String): Boolean {
        return enteredValue.trim().isEmpty()
    }

    // The email address entered is validated using regex.
    fun checkEmailField(enteredEmail: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex()
        return enteredEmail.matches(emailPattern)
    }

    // The Phone Number entered is validated to check for the length and the starting values.
    // The starting value is 234 or +234 or 0 for a valid Nigerian phone number. The length is checked for each instance.

    fun checkPhoneNumField(enteredPhoneNum: String): Boolean {
        return if (!Pattern.matches("[a-zA-Z]+", enteredPhoneNum)) {
            if (enteredPhoneNum.length < 11) {
                false
            } else if (enteredPhoneNum.length > 11 && enteredPhoneNum.substring(0, 4) == "+234") {
                enteredPhoneNum.length == 14 && (enteredPhoneNum[4] == '8' || enteredPhoneNum[4] == '7' || enteredPhoneNum[4] == '9')
            } else if (enteredPhoneNum.length > 11 && enteredPhoneNum.substring(0, 3) == "234") {
                enteredPhoneNum.length == 13 && (enteredPhoneNum[3] == '7' || enteredPhoneNum[3] == '8' || enteredPhoneNum[3] == '9')
            } else enteredPhoneNum.first() == '0'
        } else false
    }
}