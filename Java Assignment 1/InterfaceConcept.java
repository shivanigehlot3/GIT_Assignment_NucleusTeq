public class InterfaceConcept {
    public static void main(String args[]){
        Queen q = new Queen();
        q.moves();

        Rook r = new Rook();
        r.moves();

        King k = new King();
        k.moves();

        //Multiple inheritance-->
        Bear b = new Bear();
        b.eat(); 
    }
}

interface ChessPlayer{
    void moves();
}
class Queen implements ChessPlayer{
    public void moves(){
        System.out.println("up, down, left, right, diagonal(in all 4 directions)");
    }
}
class Rook implements ChessPlayer{
    public void moves(){
        System.out.println("Up, down, left, right");
    }
}
class King implements ChessPlayer{
    public void moves(){
        System.out.println("up , down, left, right ,diagonal --> By 1 step");
    }
}

//Multiple Inheritance -->
interface Herbivores{
    void eat();
}
interface Carnivores{
    void eat();
}

class Bear implements Herbivores,Carnivores{
    public void eat(){
        System.out.println("Eat meat");
    }
    //  public void eat(){
    //     System.out.println("Eat grass");
    // }
}
