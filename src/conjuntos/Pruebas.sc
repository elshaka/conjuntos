package conjuntos

import Conjuntos._

object Pruebas {

  val a = Set(1, 2, 3)                            //> a  : scala.collection.immutable.Set[Int] = Set(1, 2, 3)

  P(a) foreach println                            //> Set()
                                                  //| Set(3, 1)
                                                  //| Set(2)
                                                  //| Set(2, 1)
                                                  //| Set(3, 2)
                                                  //| Set(3)
                                                  //| Set(3, 2, 1)
                                                  //| Set(1)
  P(a).map(s => AXB(s, s)) foreach println        //> Set((2,2))
                                                  //| Set()
                                                  //| Set((1,1))
                                                  //| Set((1,1), (1,2), (2,1), (2,2))
                                                  //| Set((1,1), (1,3), (3,1), (3,3))
                                                  //| Set((3,1), (1,1), (3,2), (1,3), (2,2), (3,3), (2,3), (1,2), (2,1))
                                                  //| Set((2,2), (2,3), (3,2), (3,3))
                                                  //| Set((3,3))
  val r = Set((3,1), (1,1), (3,2), (1,3), (2,2), (3,3), (2,3), (1,2), (2,1))
                                                  //> r  : scala.collection.immutable.Set[(Int, Int)] = Set((3,1), (1,1), (3,2), (
                                                  //| 1,3), (2,2), (3,3), (2,3), (1,2), (2,1))
  
  PfromR(r)                                       //> res0: Set[Int] = Set(3, 1, 2)
}