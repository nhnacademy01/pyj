class Variables{
    String instanceVariable = "instance";
    static String CLASS_VARIABLE = "class";

    public static void main(String[] args){
        System.out.println(Variables.CLASS_VARIABLE); // 인스턴스에 접근해서 사용하는 법
        Variables vars = new Variables();
        System.out.println(vars.instanceVariable); // 객체를 통해서 접근 -> 인스턴스 변수
        vars.someMethod("parameter");
        System.out.println(vars.CLASS_VARIABLE);
    }

    public void someMethod(String parameter){
        String localVariable = "local"; // 지역 변수에 접근해서 사용하는 법
        System.out.println("parameter: " + parameter);
        System.out.println("localVariable: "+ localVariable);
    }
}