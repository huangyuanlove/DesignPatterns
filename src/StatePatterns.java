import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 状态模式
 */
public class StatePatterns {

    public static void main(String[] args) {
        SafeFrame frame = new SafeFrame("State Sample");
        while (true){
            for (int i = 0; i < 24; i++) {
                frame.setClock(i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


 interface State{
    void doClock(Context context,int hour);
    void doUse(Context context);
    void doAlarm(Context context);
    void doPhone(Context context);
 }

 class DayState implements State{
    private static DayState singleton = new DayState();
    private DayState(){}
    public static State getInstance(){
        return singleton;
    }


     @Override
     public void doClock(Context context, int hour) {
         if(hour < 9 || hour >=17){
             context.changeState(NightState.getInstance());
         }
     }

     @Override
     public void doUse(Context context) {
            context.recordLog("使用金库(白天)");
     }

     @Override
     public void doAlarm(Context context) {
        context.callSecurityCenter("按下警铃(白天)");
     }

     @Override
     public void doPhone(Context context) {
            context.callSecurityCenter("正常通话(白天)");
     }

     @Override
     public String toString() {
         return "[白天]";
     }
 }


 class NightState implements State{

     private static NightState singleton = new NightState();
     private NightState(){}
     public static State getInstance(){
         return singleton;
     }



     @Override
     public void doClock(Context context, int hour) {
         if(hour>=9 && hour<17){
             context.changeState(DayState.getInstance());
         }
     }

     @Override
     public void doUse(Context context) {
        context.callSecurityCenter("紧急：晚上使用金库");
     }

     @Override
     public void doAlarm(Context context) {
        context.callSecurityCenter("按下警铃(晚上)");
     }

     @Override
     public void doPhone(Context context) {
        context.recordLog("晚上通话录音");
     }

     @Override
     public String toString() {
         return "[晚上]";
     }
 }



 interface Context{
    void setClock(int hour);
    void changeState(State state);
    void callSecurityCenter(String msg);
    void recordLog(String msg);
 }

 class SafeFrame extends Frame implements ActionListener,Context{

    private TextField textClock = new TextField(60);
    private TextArea textScreen = new TextArea(10,50);
    private Button buttonUse = new Button("使用金库");
    private Button buttonAlarm = new Button("按下警铃");
    private Button buttonPhone = new Button("正常通话");
    private Button buttonExit = new Button("结束");
    private State state = DayState.getInstance();


    public SafeFrame(String title){
        super(title);

        setBackground(Color.lightGray);
        setLayout(new BorderLayout());
        add(textClock,BorderLayout.NORTH);
        textClock.setEditable(false);

        add(textScreen,BorderLayout.CENTER);
        textScreen.setEditable(false);

        Panel panel = new Panel();
        panel.add(buttonUse);
        panel.add(buttonAlarm);
        panel.add(buttonPhone);
        panel.add(buttonExit);

        add(panel,BorderLayout.SOUTH);

        pack();
        setVisible(true);


        buttonUse.addActionListener(this);
        buttonAlarm.addActionListener(this);
        buttonPhone.addActionListener(this);
        buttonExit.addActionListener(this);




    }


     @Override
     public void setClock(int hour) {
         String clockString = "现在的时间是 ";
         if(hour < 10){
             clockString += "0" +hour +":00";
         }else{
             clockString += hour +":00";
         }

         System.out.println(clockString);
         textClock.setText(clockString);
         state.doClock(this,hour);
     }

     @Override
     public void changeState(State state) {
         System.out.println("从" + this.state +"状态变为了" + state +"状态");
         this.state = state;
     }

     @Override
     public void callSecurityCenter(String msg) {
            textScreen.append("call!" + msg  +"\n");
     }

     @Override
     public void recordLog(String msg) {
            textScreen.append("record.." + msg +"\n");
     }

     @Override
     public void actionPerformed(ActionEvent e) {
         System.out.println(e.toString());
         if(e.getSource() == buttonUse){
             state.doUse(this);
         }else if (e.getSource() == buttonAlarm){
             state.doAlarm(this);
         }else  if(e.getSource() == buttonPhone){
             state.doPhone(this);
         }else if(e.getSource() == buttonExit){
             System.exit(0);
         }else {
             System.out.println("?");
         }
     }
 }
