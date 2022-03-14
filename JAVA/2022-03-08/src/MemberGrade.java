public class MemberGrade {
    public static void main(String[] args) {
        int memberGrade = 3;

        switch (memberGrade){
            case 3:
                grantVIP();
            case 2:
                grantGold();
            case 1:
                grantSilver();
                break;
            default:
                noBenefit();
        }
    }

    private static void grantVIP(){
        System.out.println("Issue VIP coupons");
    }

    private static void grantGold(){
        System.out.println("Issue Gold coupons");
    }

    private static void grantSilver(){
        System.out.println("Issue Silver coupons");
    }

    private static void noBenefit(){
        System.out.println("noBenefit");
    }
}
