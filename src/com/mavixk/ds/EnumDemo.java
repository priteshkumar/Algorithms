package com.mavixk.ds;

enum DevopsTools{
    JENKINS,DOCKER,ANSIBLE,CHEF
}

enum ErrorCode{
    SUCCESS(0),INFO(1),WARNING(2),CRITICAL(3),ERROR(4);
    private int errCode;
    ErrorCode(int errCode){this.errCode = errCode;}
    public int getErrCode(){return this.errCode;}
}


public class EnumDemo {
    public static void main(String[] args){
        DevopsTools d = DevopsTools.JENKINS;
        System.out.println(d);
        checkTool(d);
        d = DevopsTools.DOCKER;
        checkTool(d);
        if(d == DevopsTools.DOCKER){
            System.out.println("Docker tool matched");
        }
        iterateDevopsTools();
        DevopsTools tool = DevopsTools.valueOf("JENKINS");
        System.out.println("value is : " + tool);
        checkError();
    }

    public static void checkError(){
            ErrorCode err = ErrorCode.INFO;
            System.out.println("INFO codenum is : " + err.getErrCode());
    }

    public static void iterateDevopsTools(){
        for(DevopsTools tool:DevopsTools.values()){
            System.out.println("This is : " + tool);
        }
    }

    public static void checkTool(DevopsTools d){
        switch(d){
            case JENKINS:
                System.out.println("This is Jenkins");
                break;
            case DOCKER:
                System.out.println("This is docker");
                break;
            case CHEF:
                System.out.println("This is ansible");
                break;
            default:
                System.out.println("Tool not defined");
        }
    }
}
