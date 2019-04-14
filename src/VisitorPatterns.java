import java.util.ArrayList;
import java.util.List;

/**
 * 访问者模式
 */
public class VisitorPatterns {

    public static void main(String[] args) {
        Bill consumerBill = new ConsumerBill("消费", 3000);
        Bill incomeBill = new IncomeBill("收入", 5000);
        Bill consumerBill2 = new ConsumerBill("消费", 4000);
        Bill incomeBill2 = new IncomeBill("收入", 8000);
        // 添加单子
        AccountBook accountBook = new AccountBook();
        accountBook.add(consumerBill);
        accountBook.add(incomeBill);
        accountBook.add(consumerBill2);
        accountBook.add(incomeBill2);
        // 创建访问者
        Boss boss = new Boss();
        CPA cpa = new CPA();

        // 接受访问者
        accountBook.show(boss);
        accountBook.show(cpa);
        // boss查看总收入和总消费
        boss.showTotalConsumer();
        boss.showTotalIncome();
    }

}


interface Bill{
    void accept(AccountBookView viewer);
}

class ConsumerBill implements Bill{
    private String item;
    private double amount;

    public ConsumerBill(String item, double amount) {
        this.item = item;
        this.amount = amount;
    }

    public String getItem() {
        return item;
    }

    public double getAmount() {
        return amount;
    }


    @Override
    public void accept(AccountBookView viewer) {
        viewer.view(this);
    }
}

class IncomeBill implements Bill{

    private String item;
    private double amount;

    public IncomeBill(String item, double amount) {
        this.item = item;
        this.amount = amount;
    }

    public String getItem() {
        return item;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public void accept(AccountBookView viewer) {
        viewer.view(this);
    }
}



interface AccountBookView{
    void view(ConsumerBill consumerBill);
    void view(IncomeBill incomeBill);
}

class Boss implements AccountBookView{
    private double totalConsumer;
    private double totalIncome;


    @Override
    public void view(ConsumerBill consumerBill) {
        totalConsumer = totalConsumer + consumerBill.getAmount();
    }

    @Override
    public void view(IncomeBill incomeBill) {
        totalIncome = totalIncome + incomeBill.getAmount();
    }

    public void showTotalConsumer() {
        System.out.println("老板消费了" + totalConsumer);
    }

    public void showTotalIncome() {
        System.out.println("老板收入了" + totalIncome);
    }
}
class CPA implements  AccountBookView{

    int count =0;


    @Override
    public void view(ConsumerBill consumerBill) {
        count++;
        if(consumerBill.getItem().equals("消费")){
            System.out.println("第" + count +"个单子消费了"  + consumerBill.getAmount()) ;
        }
    }

    @Override
    public void view(IncomeBill incomeBill) {
        if(incomeBill.getItem().equals("收入")){
            System.out.println("第" + count +"个单子收入了"  + incomeBill.getAmount()) ;
        }
    }
}
class AccountBook {

    private List<Bill> listBill = new ArrayList<Bill>();

    // 添加单子
    public void add(Bill bill) {
        listBill.add(bill);
    }

    // 为每个账单添加访问者
    public void show(AccountBookView viewer) {
        for (Bill b : listBill) {
            b.accept(viewer);
        }
    }
}
