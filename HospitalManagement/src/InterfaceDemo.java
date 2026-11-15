interface Payment{
    void pay(double amount);
}

class UpiPayment implements Payment{
    @Override
    public void pay(double amount){
        System.out.println("Paid $ "+amount+"using UPI");
    }
}

class CardPayment implements Payment{
    @Override
    public void pay(double amount){
        System.out.println("Paid $ "+amount+"usind Card");
    }
}

class NetBankingPayment implements Payment{
    @Override
    public void pay(double amount){
        System.out.println("Paid $"+amount+"using Net Banking");
    }
}

public class InterfaceDemo{
    public static void main(String[] args){
        Payment payment;

        payment=new UpiPayment();
        payment.pay(2000);
        payment=new CardPayment();
        payment.pay(3000);
        payment=new NetBankingPayment();
        payment.pay(5000);
    }
}