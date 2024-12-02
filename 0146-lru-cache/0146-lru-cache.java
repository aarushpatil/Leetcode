class LRUCache {
    HashMap<Integer, Node> map;
    int cap;
    int listSize;
    Node first;
    Node last;

    public LRUCache(int capacity) {
        cap = capacity;
        listSize = 0;
        map = new HashMap<>();
        first = new Node(-1);
        last = new Node(-1);
        last.prev = first;
        first.next = last;
    }
    
    public int get(int key) {
        System.out.println("get: " + key);
        
        if(!map.containsKey(key))
        {
            return -1;
        }

        //remove node from list
        Node rem = removeNodeFromList(map.get(key));

        //move to front of cache
        addNodeFrontList(rem);
        return map.get(key).data;
    }
    
    public void put(int key, int value) {
        System.out.println("put: " + key + " " + value);
        if(map.containsKey(key))
        {
            map.get(key).data = value;
            return;
        }
        if(listSize == cap)
        {
            //remove
            Node rem = removeNodeFromList(last.prev);
            map.remove(rem.key);
            listSize--;
        }

        //add
        Node toAdd = new Node(value);
        toAdd.key = key;
        addNodeFrontList(toAdd);
        map.put(key, toAdd);
        listSize++;
    }

    Node removeNodeFromList(Node rem)
    {
        // if(rem == first || rem == last) return null;

        Node bef = rem.prev;
        Node aft = rem.next;

        bef.next = aft;
        aft.prev = bef;

        return rem;
    }

    void addNodeFrontList(Node rem)
    {
        Node aft = first.next;
        first.next = rem;
        rem.prev = first;
        
        aft.prev = rem;
        rem.next = aft;
    }

    class Node
    {
        int key;
        int data;
        Node next;
        Node prev;

        public Node(int data)
        {
            this.data = data;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */