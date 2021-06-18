public class HashTable {
    private Hash[] table;
    private int size ;
public HashTable(int tableSize){
    table = new Hash[ tableSize ];
size = 0;
}

    public void insert(String val) {
    size++;
        String pos = myhash(val);
        Hash nptr = new Hash(val);

        if (table[Integer.parseInt(pos)] == null) {
            table[Integer.parseInt(pos)] = nptr;
        } else {
            nptr.next = table[Integer.parseInt(pos)];
            table[Integer.parseInt(pos)] = nptr;
        }
    }

    public void remove(String val) {

        String pos = myhash(val);
        Hash start = table[Integer.parseInt(pos)];
        Hash end = start;

        if (start.data.equals(val)) {
            size--;
            table[Integer.parseInt(pos)] = start.next;
            return;
        }

        while (end.next != null && !end.next.data.equals(val)) {
            end = end.next;
        }

        if (end.next == null) {
            System.out.println("\nЭлемент не найден\n");
            return;
        }

        size--;

        if (end.next.next == null) {
            end.next = null;
            return;
        }

        end.next = end.next.next;

        table[Integer.parseInt(pos)] = start;

    }
    public void find(String val) {

        String pos = myhash(val);
        Hash start = table[Integer.parseInt(pos)];
        Hash end = start;

        if (start.data.equals(val)) {
            System.out.println("\nЭлемент найден в ячейке: " + pos);
        }
        while (end.next != null && !end.next.data.equals(val)) {
            end = end.next;
        }
        if (end.next == null) {
            System.out.println("\nЭлемент не найден");
        }
         if(end.next.next == null){
        System.out.println("\nЭлемент найден в ячейке: " + pos);
         }
}

    private String myhash(String x ) {

        int hashVal = x.hashCode( );
        hashVal %= table.length;

        if (hashVal < 0) {
            hashVal += table.length;
        }

        return String.valueOf(hashVal);



    }


    public void makeEmpty() {
        int l = table.length;
        table = new Hash[l];
        size = 0;
    }


    public void printHashTable () {

        System.out.println();

        for (int i = 0; i < table.length; i++) {

            System.out.print ("Ячейка " + i + ":  ");
            Hash start = table[i];

            while(start != null) {
                System.out.print(start.data +" ");
                start = start.next;
            }

            System.out.println();
        }
    }
   }