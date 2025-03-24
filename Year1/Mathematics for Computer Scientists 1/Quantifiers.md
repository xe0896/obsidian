	
**How would we re-write with quantifiers that every integer is even OR odd

	Every integer is even or odd can be simplified into mathematical notation:

$$\forall x \in \mathbb{Z} , even(x) \lor odd(x) $$

	However using an OR gate can also mean that if they are both true then it will output true which we know an integer cannot be even or odd, this means that we can use an XOR gate instead as it can be both 0 1 or 1 0 but it cannot be 0 0 or 1 1

$$\forall x \in \mathbb{Z} , even(x) \oplus odd(x) $$

	If required we can define the functions even(x) or odd(x)

$$even(x) = x MOD 2 = 0$$

**More notations

	There exists exactly one:

$$\exists ! $$

	Not every:

$$¬\forall$$

**Using Boolean laws to interpret statements differently

	De Morgan's Law is closely related to the reason why the statement below holds:

$$¬\forall x P(x) = \exists x ¬P(x) $$

	Not every x causes P(x) to be true meaning there exists and x where P(x) is false.



