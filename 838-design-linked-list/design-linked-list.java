class MyLinkedList {
    List<Integer>li;

    public MyLinkedList() {
        li=new ArrayList<>();
        
    }
    
    public int get(int index) {
        if(index<li.size())
        {
            return li.get(index);
        }
        return -1;
        
    }
    
    public void addAtHead(int val) {
        li.add(0,val);
        
    }
    
    public void addAtTail(int val) {
        li.add(val);
        
    }
    
    public void addAtIndex(int index, int val) {
        if(index==li.size())
        {
            li.add(val);
            return;
        }
        if(index>li.size()-1)
        {
            return;
        }
        li.add(index,val);
        
    }
    
    public void deleteAtIndex(int index) {
        if(index<li.size())
        {
            li.remove(index);
            return;
        }
        
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */