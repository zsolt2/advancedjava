package hu.meiit.haladojava.calculator;

public class Validator {
    String task;

    public Validator( String input){
        this.task = getTask(input);
    }

    private Integer getInt(String str){
        Integer rv = null;
        try{
            rv = Integer.valueOf(str);
        } catch (NumberFormatException e ){
            System.err.println(str + " not an Integer!");
        }
        return rv;
    }



    private String getTask(String input){
        if (input == null)
            return null;
        input = input.replaceAll("\\s", "");

        if(input.matches("^[0-9]+[-+\\/\\*][0-9]+$")){
            return input;
        }

        return null;
    }

    public Operands getOperands(){
        if(task == null) {
            return null;
        }
        String operandsStr[]=task.split("[-+\\/\\*]");
        if(operandsStr.length != 2){
            return null;
        }

        Operands operands = new Operands().setA(getInt(operandsStr[0])).setB(getInt(operandsStr[1]));
        return operands;
    }

    public Character getOperatorType(){
        if(task == null) {
            return null;
        }
        for (char c: "+-/*".toCharArray() ){
            if (task.indexOf(c) >= 0){
                return c;
            }
        }
        return null;
    }
}
