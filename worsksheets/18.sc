import play.api.libs.json.JsObject

sealed trait MyList[+T]
case class Cons[T](head: T, tail: MyList[T]) extends MyList[T]
case object MyNil extends MyList[Nothing]


val xs = Cons(1, Cons(2, Cons(3, MyNil)))

def length[T](xs: MyList[T]): Int = xs match {
  case MyNil            => 0
  case Cons(head, tail) => 1 + length(tail)
}

def reverse[T](xs: MyList[T]): MyList[T] = {
  def inner(remaining: MyList[T], acc: MyList[T]): MyList[T] = remaining match {
    case MyNil            => acc
    case Cons(head, tail) => inner(tail, Cons(head, acc))
  }

  JsObject
  inner(xs, MyNil)
}

length(xs)

reverse(xs)

