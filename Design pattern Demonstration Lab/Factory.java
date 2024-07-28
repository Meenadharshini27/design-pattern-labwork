
interface Chair {

    void style();
}

class ModernChair implements Chair {

    public void style() {
        System.out.println("Modern chair");
    }
}

class TraditionalChair implements Chair {

    public void style() {
        System.out.println("Traditional chair");
    }
}

interface Table {

    void style();
}

class ModernTable implements Table {

    public void style() {
        System.out.println("Modern table");
    }
}

class TraditionalTable implements Table {

    public void style() {
        System.out.println("Traditional table");
    }
}

interface FurnitureFactory {

    Chair createChair();

    Table createTable();
}

class ModernFurnitureFactory implements FurnitureFactory {

    public Chair createChair() {
        return new ModernChair();
    }

    public Table createTable() {
        return new ModernTable();
    }
}

class TraditionalFurnitureFactory implements FurnitureFactory {

    public Chair createChair() {
        return new TraditionalChair();
    }

    public Table createTable() {
        return new TraditionalTable();
    }
}

public class Factory {

    public static void main(String[] args) {
        FurnitureFactory modernFactory = new ModernFurnitureFactory();
        Chair modernChair = modernFactory.createChair();
        Table modernTable = modernFactory.createTable();
        modernChair.style();
        modernTable.style();

        FurnitureFactory traditionalFactory = new TraditionalFurnitureFactory();
        Chair traditionalChair = traditionalFactory.createChair();
        Table traditionalTable = traditionalFactory.createTable();
        traditionalChair.style();
        traditionalTable.style();
    }
}
