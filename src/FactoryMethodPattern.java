import java.util.ArrayList;
import java.util.List;

/**
 * 工厂模式
 */
public class FactoryMethodPattern {

    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product p1 = factory.create("A");
        Product p2 = factory.create("B");
        Product p3 = factory.create("C");
        p1.use();
        p1.use();
        p1.use();
    }

}


abstract class Product {
    public abstract void use();
}


class IDCard extends Product {

    private String owner;

    public IDCard(String owner) {
        System.out.println("制作" + owner + "的ID卡");
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println("使用" + owner + "的ID卡");

    }

    public String getOwner() {
        return owner;
    }
}


abstract class Factory {
    public final Product create(String owner) {
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    abstract Product createProduct(String owner);

    abstract void registerProduct(Product product);

}



class IDCardFactory extends Factory {

    private ArrayList<Product> owners = new ArrayList<>();

    @Override
    Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    void registerProduct(Product product) {
        owners.add(product);
    }

    public List getOwners() {
        return owners;
    }
}
