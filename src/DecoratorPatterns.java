/**
 * 装饰模式
 */
public class DecoratorPatterns {

    public static void main(String[] args) {
        DecoratorDisplay b1 = new CharacterDisplay("Hello world");
        DecoratorDisplay b2 = new SideBorder(b1, '#');
        DecoratorDisplay b3 = new FullBorder(b2);
        b1.show();
        b2.show();
        b3.show();
        DecoratorDisplay b4 =
                new SideBorder(new FullBorder(new FullBorder(new SideBorder(new FullBorder(new CharacterDisplay("你好，世界")),'#'))),'/');
        b4.show();
    }

}


abstract class DecoratorDisplay {
    abstract int getColumns();

    abstract int getRows();

    abstract String getRowText(int row);

    final void show() {
        for (int i = 0; i < getRows(); i++) {
            System.out.println(getRowText(i));
        }
    }
}

class CharacterDisplay extends DecoratorDisplay {


    private String string;


    public CharacterDisplay(String string) {
        this.string = string;
    }

    @Override
    int getColumns() {
        return string.getBytes().length;
    }

    @Override
    int getRows() {
        return 1;
    }

    @Override
    String getRowText(int row) {
        if (row == 0) {
            return string;
        } else {
            return null;
        }
    }
}


abstract class Border extends DecoratorDisplay {
    DecoratorDisplay decoratorDisplay;

    Border(DecoratorDisplay decoratorDisplay) {
        this.decoratorDisplay = decoratorDisplay;
    }
}


class SideBorder extends Border {
    char borderChar;

    public SideBorder(DecoratorDisplay decoratorDisplay, char borderChar) {
        super(decoratorDisplay);
        this.borderChar = borderChar;
    }

    @Override
    int getColumns() {
        return 1 + decoratorDisplay.getColumns() + 1;
    }

    @Override
    int getRows() {
        return decoratorDisplay.getRows();
    }

    @Override
    String getRowText(int row) {
        return borderChar + decoratorDisplay.getRowText(row) + borderChar;
    }
}

class FullBorder extends Border {
    public FullBorder(DecoratorDisplay decoratorDisplay) {
        super(decoratorDisplay);
    }

    @Override
    int getColumns() {
        return 1 + decoratorDisplay.getColumns() + 1;
    }

    @Override
    int getRows() {
        return 1 + decoratorDisplay.getRows() + 1;
    }

    @Override
    String getRowText(int row) {
        if (row == 0) {
            return "+" + makeLine('-', decoratorDisplay.getColumns()) + "+";
        } else if (row == decoratorDisplay.getRows() + 1) {
            return "+" + makeLine('-', decoratorDisplay.getColumns()) + "+";
        } else {
            return "|" + decoratorDisplay.getRowText(row - 1) + "|";
        }

    }


    private String makeLine(char ch, int count) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < count; i++) {
            buffer.append(ch);
        }
        return buffer.toString();
    }

}