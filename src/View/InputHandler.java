package View;


public class InputHandler{

    public static String inputAmount(String amountInput){
        String regex = "^[+-]?\\d*(\\.\\d+)?$";
        boolean validAmountFlag = true;
        double amount = 0;
        String result;
        if (amountInput.isEmpty()) {
        result= "EMPTY INPUT";
        validAmountFlag = false;
    } else if (!amountInput.matches(regex)) {
        result= "NOT A NUMBER";
        validAmountFlag = false;
    } else {
        try {
            amount = Double.parseDouble(amountInput);
            if (amount < 0) {
                result = "NEGATIVE AMOUNT";
                validAmountFlag = false;
                return result;
            } else {
                result=String.format("%.2f", amount);
            }
        } catch (NumberFormatException e) {
            result= "NOT A NUMBER";
            validAmountFlag = false;
            return result;
        } catch (Exception e) {
            result = "ERROR: " + e.getMessage();
            validAmountFlag = false;
            return result;
        }
    }
        if (!validAmountFlag) {
        return "INVALID INPUT";
    }
    return result;
    }

}



