import java.util.Scanner;

public class Menu {
    Scanner scan = new Scanner(System.in);
    String s = "";
    int x = 0;
    String name;
    HashTable ht = new  HashTable(10);
    public void mainMenu() {

        while (!"6".equals(s)) {
            System.out.println("\n Дейсствия \n");
            System.out.println("1. Добавить элемент");
            System.out.println("2. Удалить элемент");
            System.out.println("3. Поиск элемента");
            System.out.println("4. Очистить таблицу");
            System.out.println("5. Вывести хеш-таблицу");
            System.out.println("6. Выход");
            s = scan.next();
            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод");
            }
            switch (x) {
                case 1:
                    System.out.println("Введите строку:");
                    name = scan.next();
                    ht.insert(name);
                    break;
                case 2:
                    System.out.println("Введите строку для удаления:");
                    name = scan.next();
                    ht.remove(name);
                    break;
                case 3:
                    System.out.println("Введите строку для поиска:");
                    name = scan.next();
                    ht.find(name);
                    break;
                case 4:
                    ht.makeEmpty();
                    System.out.println("Хеш-таблица очищена");
                    break;
                case 5:
                    ht.printHashTable();
                    break;

            }
        }}}