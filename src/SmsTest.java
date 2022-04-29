import Register.RegisterConfirmation;
import Register.RegisterReference;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

    public class SmsTest {


    @Test  //Testing Valid format (Register,REGISTER,register) without leading and trailing spaces

    public void validateRegister1() {

        RegisterReference sms = new RegisterReference();


        HashMap<String, String> entry1 = new HashMap<>();
        entry1.put("Message", "Register");

        HashMap<String, String> entry2 = new HashMap<>();
        entry2.put("Message", "REGISTER");

        HashMap<String, String> entry3 = new HashMap<>();
        entry3.put("Message", "register");

        assertTrue(RegisterConfirmation.checkRegister(entry1, sms));
        assertTrue(RegisterConfirmation.checkRegister(entry2, sms));
        assertTrue(RegisterConfirmation.checkRegister(entry3, sms));
    }


    @Test //Testing Valid format (Register,REGISTER,register) with leading and trailing spaces

    public void validateRegister2() {

            RegisterReference sms = new RegisterReference();

            HashMap<String, String> entry4 = new HashMap<>();
            entry4.put("Message", " Register ");

            HashMap<String, String> entry5 = new HashMap<>();
            entry5.put("Message", " REGISTER ");

            HashMap<String, String> entry6 = new HashMap<>();
            entry6.put("Message", " register ");

            assertTrue(RegisterConfirmation.checkRegister(entry4,sms));
            assertTrue(RegisterConfirmation.checkRegister(entry5,sms));
            assertTrue(RegisterConfirmation.checkRegister(entry6,sms));

        }


    @Test   //Testing inValid format (regi ster,r egister,r3g1$T3R)
        public void validateRegister3() {
            RegisterReference sms = new RegisterReference();

            HashMap<String , String> entry7 = new HashMap<>();
            entry7.put("Message","regi ster");

            HashMap<String , String> entry8 = new HashMap<>();
            entry8.put("Message","r egister");

            HashMap<String , String> entry9 = new HashMap<>();
            entry9.put("Message","r3g1$T3R");

            assertFalse(RegisterConfirmation.checkRegister(entry7,sms));
            assertFalse(RegisterConfirmation.checkRegister(entry8,sms));
            assertFalse(RegisterConfirmation.checkRegister(entry9,sms));

        }

}
