# Reflection on implementing regular expressions of a DSL

## Which operators were easiest to implement and why?
The easiest operators to implement were Union, Concat, and Star because you just had to plug in the variables to the correct function. 

## Which operators were most difficult to implement and why?
The most difficult was <+> because I misunderstood what the operator was supposed to do at first, so I had to go back and redo the whole thing. 

## Comment on the design of this internal DSL

Write a few brief paragraphs that discuss:

- What works about this design? (For example, what things seem easy and
  natural to say, using the DSL?)
- What doesn't work about this design? (For example, what things seem
  cumbersome to say?)
- Think of a syntactic change that might make the language better. How would
  you implement it _or_ what features of Scala would prevent you from
  implementing it? (You don't have to write code for this part. You could say
  "I would use extension to..." or "Scala's rules for valid
  identifiers prevent...")

This DSL is definitely better than the alternative of typing out all those functions. This makes it easier for the programmer becasue it is much faster to type, but it is also much easier to read and understand for people looking at the code. At least for the most part. There are some things like the concat symbol that would be a pretty confusing to me. The word concast makes it more clear what the code is, but it isn't as nice to look at. At the end of the day, I would choose organization over understanding since the DSL is so small and easy to memorize. The pros definitely outweigh the cons. 

It is annoying to have to list out the '||' between each character in a union. It would be easier to have a function that creates a union from a list, so that you don't have to type out the symbol so many times. The same can be said for concat. I would probably create a method that takes a list as a parameter and unions that regex with all the other regex's in that list. 
