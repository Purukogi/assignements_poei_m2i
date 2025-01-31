public class ListeChainee {

    int element;
    ListeChainee nextElement;

    public ListeChainee(int element){
        this.element = element;
        this.nextElement = null;
    }

    public void addElement(int element){
        if(this.nextElement == null){
            this.nextElement = new ListeChainee(element);
        }else{
            this.nextElement.addElement(element);
        }

    }

    public void removeLastElement(){
        if(this.nextElement == null){
            System.out.println("List only has one element, you can't remove it!");
        }else{
            if(this.nextElement.nextElement == null){
                this.nextElement = null;
            }else{
                this.nextElement.removeLastElement();
            }
        }
    }

    public void printList(){
        System.out.println(this.element);
        if(this.nextElement != null){
            this.nextElement.printList();
        }
    }

    public boolean searchList(int search){

        if (this.element == search){
           return true;
        }else if(this.nextElement != null){
           return this.nextElement.searchList(search);
        }

        return false;

    }

    //this gives the index assuming the first index is 0
    //if you want the actual position in the list, return 1 at the exit condition
    public int getPosition(int search){
        if(this.element == search){
            return 0;
        }else if (this.nextElement != null){
            if(this.nextElement.getPosition(search) == -1){
                return -1;
            }else{
                return 1 + this.nextElement.getPosition(search);
            }
        }
        return -1;
    }

    public void sortList() {
        boolean sorted = false;
        int tmp;
        while (!sorted) {
            sorted = true;
            if (this.nextElement != null) {
                if (this.element > this.nextElement.element) {
                    tmp = this.element;
                    this.element = this.nextElement.element;
                    this.nextElement.element = tmp;
                    sorted = false;
                }
                this.nextElement.sortList();
            }
        }
    }

    //DOES NOT WORK TO REMOVE THE FIRST ELEMENT
    //APPEARS TO WORK TO REMOVE THE OTHERS
    public void removeElement(int search){

        if(this.nextElement == null) {
            System.out.println("element not in the list");
        }else{
            if(this.nextElement.element == search){
                this.nextElement = this.nextElement.nextElement;
            }else{
                this.nextElement.removeElement(search);
            }
        }


    }


}
