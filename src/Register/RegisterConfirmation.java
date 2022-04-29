package Register;

import java.util.HashMap;

public class RegisterConfirmation {

    public static boolean checkRegister(HashMap<String, String> smsMap, RegisterReference  sms) {
        boolean result = false;

        String message = smsMap.get("Message").toLowerCase().trim();


        if (message.equals("register")) {
            sms.setRegisterCode(message);
            result = true;
            sms.setSuccess(true);

        }else {
            sms.setSuccess(false);
        }
        return result;

    }
}
