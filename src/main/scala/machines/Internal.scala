package machines

import regex._
import dfa._

// TODO: Add your code below

given Conversion[Char, RegularLanguage] = n => Character(n)

// given Conversion[String, RegularLanguage] = n => Concat(Character(n(0)), Character(n.slice(1, n.length)))
given Conversion[String, RegularLanguage] = n => if (n.length == 1) Character(n(0)) else (Concat(Character(n(0)), (n.slice(1, n.length))))
