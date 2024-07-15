import scala.io.StdIn._;
import scala.collection.mutable.ListBuffer

val products = ListBuffer[String]();

def getProductList() : Unit = {
    println("Enter product name or type 'done' to finish:");
    val input = readLine();
    input match{
        case "done" => {
            printProductList(products.toList);
            getTotalProducts(products.toList);
        }
        case _ => {
            products += input;
            getProductList();
        }
    }   
} 

def printProductList(products : List[String]) : Unit = {
    products.zipWithIndex.foreach{
        case (product, index) => println(s"${index+1}.$product")
    }
}

def getTotalProducts(products : List[String]) : Unit = {
    println(s"Total number of products: ${products.length}");
}

@main def main() = {
    getProductList();
}