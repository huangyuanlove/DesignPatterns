import java.awt.*;
import java.awt.event.*;

/**
 * 仲裁者模式
 */
public class MediatorPatterns {

    public static void main(String[] args) {
        new LoginFrame("Mediator Sample");
    }
}

interface Mediator {
    void createColleagues();

    void colleagueChange();
}

interface Colleague {
    void setMediator(Mediator mediator);

    void setColleagueEnable(boolean enable);
}


class ColleagueButton extends Button implements Colleague {
    private Mediator mediator;

    public ColleagueButton(String caption) {
        super(caption);
    }


    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void setColleagueEnable(boolean enable) {
        setEnabled(enable);
    }
}

class ColleagueTextField extends TextField implements Colleague, TextListener {
    private Mediator mediator;


    public ColleagueTextField(String text, int columns) {
        super(text, columns);
    }


    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void setColleagueEnable(boolean enable) {
        setEnabled(enable);
        setBackground(enable ? Color.white : Color.lightGray);
    }

    public void textValueChanged(TextEvent e) {
        mediator.colleagueChange();
    }

}

class ColleagueCheckbox extends Checkbox implements ItemListener, Colleague {

    private Mediator mediator;

    public ColleagueCheckbox(String caption, CheckboxGroup group, boolean state) {
        super(caption, group, state);
    }


    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void setColleagueEnable(boolean enable) {
        setEnabled(enable);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        mediator.colleagueChange();
    }
}

class LoginFrame extends Frame implements ActionListener, Mediator {
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueTextField textUser;
    private ColleagueTextField textPwd;
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;

    public LoginFrame(String title) {
        super(title);

        setBackground(Color.lightGray);

        setLayout(new GridLayout(4, 2));

        createColleagues();
        add(checkGuest);
        add(checkLogin);
        add(new Label("UserName"));
        add(textUser);
        add(new Label("Password"));
        add(textPwd);
        add(buttonOk);
        add(buttonCancel);
        colleagueChange();
        pack();
        setVisible(true);


    }


    @Override
    public void createColleagues() {
        CheckboxGroup g = new CheckboxGroup();
        checkGuest = new ColleagueCheckbox("Guest", g, true);
        checkLogin = new ColleagueCheckbox("Login", g, false);
        textUser = new ColleagueTextField("", 10);
        textPwd = new ColleagueTextField("", 10);
        textPwd.setEchoChar('*');

        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");

        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textPwd.setMediator(this);
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);

        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textPwd.addTextListener(textPwd);
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);


    }

    @Override
    public void colleagueChange() {
        if (checkGuest.getState()) {
            textUser.setColleagueEnable(false);
            textPwd.setColleagueEnable(false);
            buttonOk.setColleagueEnable(true);
        }else{
            textUser.setColleagueEnable(true);
            userPassChanged();
        }
    }

    private void userPassChanged(){
        if(textUser.getText().length()>0){
            textPwd.setColleagueEnable(true);
            if(textPwd.getText().length()>0){
                buttonOk.setColleagueEnable(true);
            }else{
                buttonOk.setColleagueEnable(false);
            }


        }else{
            textPwd.setColleagueEnable(false);
            buttonOk.setColleagueEnable(false);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }
}

