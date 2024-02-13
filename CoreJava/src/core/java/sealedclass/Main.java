package core.java.sealedclass;

/**
 * The sealed class should have  at least one permits subclass
 *
 * The sealed interface should have at least one permits subclass or non-aealed interface or se
 *
 *  The permited subclass should have one of type, sealed or non-sealed or final
 *
 */
public class Main {
    public static void main(String[] args) {

        var animal = new Animal();

        animal = new Birds();

    }
}

sealed class Animal permits Mammals, Birds, Fish{

}


non-sealed class Mammals  extends Animal {

}

final class Birds   extends  Animal {

}

sealed  class Fish extends Animal  permits  FlyFish {

}

final class FlyFish extends Fish {

}

sealed interface PenAnimal permits Dog, Cat {

}

sealed class Dog implements PenAnimal permits Hybrid{

}

sealed interface  Cat extends  PenAnimal permits Hybrid{

}
final class Hybrid extends Dog implements Cat{

}








