package com.byoedele.regobar

import org.junit.Assert.*
import org.junit.Test

class ValidationTests{

    val newOne = MainActivity()

    // The checkEmptyTest_False function is meant to check if the
    // checkEmpty function in MainActivity returns False for various cases
    @Test
    fun checkEmptyTest_False(){
        assertFalse(newOne.checkEmpty("hahahah"))
        assertFalse(newOne.checkEmpty("."))
        assertFalse(newOne.checkEmpty("11"))
        assertFalse(newOne.checkEmpty("0"))
        assertFalse(newOne.checkEmpty("h"))
    }

    // The checkEmptyTest_True function is meant to check if the
    // checkEmpty function in MainActivity returns true for various cases
    @Test
    fun checkEmptyTest_True(){
        assert(newOne.checkEmpty("")).equals(true)
        assert(newOne.checkEmpty(" ")).equals(true)
        assert(newOne.checkEmpty("\n")).equals(true)
        assert(newOne.checkEmpty("  ")).equals(true)
    }

   // The checkEmail_False function is meant to check if the
    // checkEmailField function in MainActivity returns false for various cases
    @Test
    fun checkEmail_False(){
        assertFalse(newOne.checkEmailField("hahhatgmaildotcom"))
        assertFalse(newOne.checkEmailField("hahha==@gmail.com"))
        assertFalse(newOne.checkEmailField("linger11gmail.com"))
        assertFalse(newOne.checkEmailField("ha@rocketmailcom"))
        assertFalse(newOne.checkEmailField("oyedele.com"))
        assertFalse(newOne.checkEmailField("oy@.com"))
    }

    // The checkEmailTrue_True function is meant to check if the
    // checkEmailField function in MainActivity returns true for various cases

    @Test
    fun checkEmailTrue_True(){
        assert(newOne.checkEmailField("oyedsamu@gmail.com")).equals(true)
        assert(newOne.checkEmailField("goodguysrock@rocketmail.com")).equals(true)
        assert(newOne.checkEmailField("cheratowoods@gmail.com")).equals(true)
        assert(newOne.checkEmailField("oyedele.s@yahoo.com")).equals(true)
        assert(newOne.checkEmailField("oyedele.samuel@decagon.dev")).equals(true)
        assert(newOne.checkEmailField("abc@xyz.de")).equals(true)
    }

   // The checkPhoneNumber_False function is meant to check if the
    // checkPhoneNumField function in MainActivity returns false for various cases
    @Test
    fun checkPhoneNumber_False(){
        assertFalse(newOne.checkPhoneNumField("00000000")).equals(false)
        assertFalse(newOne.checkPhoneNumField("18145508029")).equals(false)
        assertFalse(newOne.checkPhoneNumField("234815522345")).equals(false)
        assertFalse(newOne.checkPhoneNumField("+234706890092134")).equals(false)
        assertFalse(newOne.checkPhoneNumField("+23470689009")).equals(false)
        assertFalse(newOne.checkPhoneNumField("+2346068900990")).equals(false)
        assertFalse(newOne.checkPhoneNumField("2345068970990")).equals(false)
    }

    // The checkPhoneNumber_True function is meant to check if the
    // checkPhoneNumField function in MainActivity returns true for various cases
    @Test
    fun checkPhoneNumber_True(){
        assert(newOne.checkPhoneNumField("08145508029")).equals(true)
        assert(newOne.checkPhoneNumField("2348145508029")).equals(true)
        assert(newOne.checkPhoneNumField("+2348145508029")).equals(true)
        assert(newOne.checkPhoneNumField("+2347045508029")).equals(true)
        assert(newOne.checkPhoneNumField("+2348045508029")).equals(true)
        assert(newOne.checkPhoneNumField("+2349045508029")).equals(true)
        assert(newOne.checkPhoneNumField("08162339425")).equals(true)
    }


}