package machines

import regex._
import dfa._

// TODO: Add your code below

given Conversion[Char, RegularLanguage] = n => Character(n)

// given Conversion[String, RegularLanguage] = n => if (n.length == 1) Character(n(0)) else (Concat(Character(n(0)), (n.slice(1, n.length))))
given Conversion[String, RegularLanguage] = n => n.toList.foldRight(Concat(Epsilon, Epsilon))(Concat(_,_))


extension (rl: RegularLanguage)
    def || (rl2: RegularLanguage) = Union(rl, rl2)
    def ~ (rl2: RegularLanguage) = Concat(rl, rl2)
    def <*> = Star(rl)
    def <+> = Concat(rl, Star(rl))
    def apply (reps: Int) : RegularLanguage = if (reps == 1) rl else (Concat(rl, rl apply (reps-1)))

    def toDFA (using alphabet: Set[Char]) : DFA = regexToDFA(rl, alphabet)


given Conversion[RegularLanguage, DFA] = n => regexToDFA(n, extractChars(n))

def extractChars (rl: RegularLanguage): Set[Char] = rl match
    case Empty => Set[Char]()
    case Epsilon => Set[Char]()
    case Character(c) => Set[Char](c)
    case Union(r1, r2) => extractChars(r1) ++ extractChars(r2)
    case Concat(r1,r2) => extractChars(r1) ++ extractChars(r2)
    case Star(r) => extractChars(r)




