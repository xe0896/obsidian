**What is implication

	Implication goes by the natural language "if this then that", or "if p then q". This means that if p is true then q must also be true, however p doesn't have to be true to output true in this case so whenever p is false the output will be true regardless of the value q.

| p   | q   | p->q |
| --- | --- | ---- |
| 0   | 0   | 1    |
| 0   | 1   | 1    |
| 1   | 0   | 0    |
| 1   | 1   | 1    |

	The last row is easy to see that since p if true q must also be true which is the case which leads to p implying q, the second last row shows p being true which for the final output to be true q must also be true which is not the case which leads to the output to be false. The first two we can see that p is not true which is fine which leads them to be both true.

**Worked example of a more complex implication

$$A = ((x\rightarrow y) \land x) \rightarrow y $$

| x   | y   | x->y | (x->y)^x | A   |
| --- | --- | ---- | -------- | --- |
| 0   | 0   | 1    | 0        | 1   |
| 0   | 1   | 1    | 0        | 1   |
| 1   | 0   | 0    | 0        | 1   |
| 1   | 1   | 1    | 1        | 1    |

**How a function implication question

$$f(x) = x < 5$$
$$g(x) = x^{2} < 25 $$
$$x \in \mathbb{N} $$

	We can relate these two functions using implication as they both use the same x value and x squared is 25 therefore:

$$f(x) \rightarrow g(x)$$

**What is a tautology

	A tautology can be seen in the truth table above which shows that A is true regardless of what happens meaning it is a tautology

**What is double implication or equivalence

	Double implication or equivalence is the expression below:

$$p \iff q$$

	If we wanted to express this with using implication we can do the following:

$$p \iff q = (p \rightarrow q) \land (q \rightarrow p) $$

	The truth table is seen below:
	
| p   | q   | p<->q |
| --- | --- | ---- |
| 0   | 0   | 1    |
| 0   | 1   | 0    |
| 1   | 0   | 0    |
| 1   | 1   | 1    |

**Boolean laws

	Assocative law, we can re-arrange the brackets like this and have the same outputs.

$$(x \lor y) \lor z = x \lor (y \lor z)$$
$$(x \land y) \land z = x \land (y \land z)$$

	Commutative law, we can re-arrange the letters and have the same outputs.

$$x\lor y = y\lor x$$
$$x\land y=y\land x$$

	Identites, able to see what the output due to it being depended on x or y.

$$x\lor 0 = x$$
$$x\land 1=x$$

	Idempotence, able to simplify.

$$x\land x = x $$

	De Morgan's Law

$$\neg(x\land y)= \neg x \lor \neg y$$
$$\neg(x\lor y) = \neg x\land \neg y $$

	Absorption law, when looking at the bracketed expression then OR x we can see that this expression depends on x since regardless of what x AND y is we have an OR x which means that x has more power in this case meaning the expression is equal to x.

	Similar explaination for the 2nd expression since x AND y will be true if x is true and causes TRUE AND TRUE.

$$(x\land y)\lor x= x$$
$$(x\lor y) \land x = x $$

	Distributive law

$$x\lor (y\land z) = (x\lor y) \land ( x\lor r)$$
$$x\land (y\lor z) = (x\land y) \lor ( x\land r)$$

	Implication law, the implication can be represented into a different sets of logic gates by looking at its truth table

$$x \rightarrow y = \neg x \lor y $$
