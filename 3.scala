import scala.io.StdIn._;

def fibonacci(n : Int) : Unit = {
    def recursion(n : Int) : Int = n match {
        case 0 => 0;
        case 1 => 1;
        case _ => recursion(n-1) + recursion(n-2);
    }

    for (i <- 0 until n){
        println(recursion(i) + " ");
    }
    
}

@main def main() = {
    println("Enter a number:")
    val n = readInt();
    fibonacci(n);
}