package conjuntos

object Conjuntos {
  // Dados los conjuntos A y B determina A X B
  def AXB[Ta, Tb](A: Set[Ta], B: Set[Tb]): Set[(Ta, Tb)] = {
    if (A.isEmpty || B.isEmpty)
      Set()
    else
      AXB(A.tail, B) ++ AXB(A, B.tail) + ((A.head, B.head))
  }

  // Determina todas las particiones de un conjunto S
  def P[T](S: Set[T]): Set[Set[T]] = {
    if (S.isEmpty)
      Set(Set())
    else {
      val tailSubsets = P(S.tail)
      tailSubsets ++ tailSubsets.map(subset => subset + S.head)
    }
  }

  // Determina las relaciones de equivalencia de cada una de
  // las particiones de un conjunto A
  def RPdeA[T](A: Set[T]): Set[Set[(T, T)]] =
    P(A).map(p => AXB(p, p))

  // Determina un conjunto P a partir de su relación de equivalencia R
  def PdeR[Ta](R: Set[(Ta, Ta)]): Set[Ta] = {
    if (R.isEmpty)
      Set()
    else
      Set(R.head._1, R.head._2) ++ PdeR(R.tail)
  }

  def main(args: Array[String]) {
    // A
    val A = Set('a', 'b', 'c')
    println(s"A = ${A}")
    println(s"|A| = ${A.size}")

    // AxA
    val AXA = AXB(A, A)
    println(s"AxA = ${AXA}")
    println(s"|AxA| = ${AXA.size}")

    // Particiones de AxA
    val PAXA = P(AXA)
    println("P(AxA):"); PAXA foreach println
    println(s"|P(AxA)| = ${PAXA.size}")

    // Particiones de A
    val PA = P(A)
    println("P(A):"); PA foreach println
    println(s"|P(A)| = ${PA.size}")

    // Relaciones de equivalencia para cada partición de A
    val RS = RPdeA(A)
    println("Relaciones de equivalencia para cada partición de A:"); RS foreach println

    // Partición Px generada por una relación de equivalencia R dada
    val R = Set(('c', 'b'), ('a', 'c'), ('a', 'a'), ('c', 'a'), ('b', 'a'), ('c', 'c'), ('a', 'b'), ('b', 'b'), ('b' ,'c'))
    val Px = PdeR(R)
    println(s"Relación de equivalencia R: ${R}")
    println(s"Partición Px generada por R: ${Px}")
  }
}