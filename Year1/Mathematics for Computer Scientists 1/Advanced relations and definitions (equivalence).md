/**Another example of composition

$R = \{(x,x+1) \mid x \in \mathbb{N} \}$

What is $R \circ R$?

First we can work out what R is easily

$R = \{(0,1), (1,2), (2,3)\dots\}$

Then we apply the same relation to the set above

$R \circ R = \{(0, 1 + 1), (1, 2 + 1), (2, 3 + 1)...\}$

$R \circ R = \{(0,2), (1,3), (2,4)...\}$

**Russel paradox**

Let $A$ = the set of all sets

$$X = \{A \mid A \notin A \}$$
Let's assume that $X \notin X$ then $X \in X$ must be true as A contains every set Right !? 

Let's assume that $X \in X$ then $X \notin X$ must be true as A doesn't include every set Right !? as $A \notin A$

**Inverse relation**

Let $R \subseteq A \times B$  then $R^{-1} = \{(b,a) \mid (a,b) \in R \}$ 
$R^{-1} \subseteq B \times A$

For the relation at the start of this note $R = \{(x,x+1) \mid x \in \mathbb{N} \}$ the inverse would be:

$R^{-1} = \{(x+1,x) \mid x \in \mathbb{N} \}$ 

**Additional notation**

$$aRb = (a,b) \in R$$
For the relations below this applies when

$$R \subseteq S \times S$$

**Reflexive relation**

$\forall \in S,$  $xRx$

**Symmetric relation**

$\forall a,b \in S$ . $aRb \iff bRa$ 

**Transitive relation**

$\forall a,b,c \in S$ . $aRb \land bRc \rightarrow aRc$

**Anti symmetric**

$\forall a,b \in S$ . $aRb \land bRa \rightarrow a = b$

	a,b,c are not distinct meaning we can also have a,b,b

**Combination of relations

	Equivalence relation is when it is symmetrical, reflexive and transitive
	Partial order is when it is anti-symmetric, reflexive and transitive

**Equivalence classes**

	Equivalence class is the name given to a subset of some equivalence relation R which includes all elements that are equivalent to each other.

	R must have an equivalence relation, the notation is seen below for an equivalence class

$$[a_{r}] = \{x \mid aRx\}$$
**Example of an equivalence class question**

Give the equivalence classes of:

$R \subseteq \mathbb{Z}^{2}$,  $R = \{(x,y) \mid (x-y)$ $MOD$ $3 = 0  \}$

First we must check that this relation is an equivalence relation, for a relation to be an equivalence relation it must be symmetrical, reflexive and transitive

Reflexive is when $xRx$ which is the same thing as $(x,x) \in R$, so now if we make $y = x$ we get $(x-x)$ $MOD$ $3 = 0$ which leads to $0$ $MOD$ $3 = 0$ which is always true meaning that the relation is reflexive

Symmetrical is when we can swap the values of $x$ and $y$ and still get $MOD$ $3 = 0$, due to modular arithmetic $x-y$ $MOD$ $3$ is the same as $y-x$ $MOD$ $3$ so this relation is symmetrical

Transitive is when $xRy \land yRz \rightarrow xRz$ , to prove this is by doing: $x-z = (y-z) + (x-y)$ which $y-z$ gives us 0 when we apply $MOD$ $3$ and $x-y$ gives us 0 when we apply $MOD$ $3$ which means that these two expressions will be a multiple of 3 or 0 which means that $x-z$ is a multiple of 3 or 0 which will mean that $x-z$ $MOD$ $3$ is always 0. 

Now that we have proved that this relation is an equivalence relation we can identify the equivalence classes, this can be done by putting in values of $x$ and $y$ that satisfies its domain and see what values are outputted. Since that this is an equivalence relation it means that it is symmetric meaning that we can put any value of $x$ or $y$ as we want so we will input y as 0,1,2 as the $MOD$ function repeats itself

$[0]_{r} = \{x \mid (0-x)$ $MOD$ $3 = 0 \}$

This will output the set: $\{0,3,-3,6,-6.. \}$ 

$[1]_{r} = \{x \mid (1-x)$ $MOD$ $3 = 0 \}$

This will output the set: $\{1,-2,4,-5,7..\}$

$[2]_{r} = \{x \mid (2-x)$ $MOD$ $3 = 0 \}$

This will output the set: $\{2,-1,5,-4...\}$

Then we make a set containing all these sets: $\{\{0,3,-3,6,-6.. \},\{1,-2,4,-5,7..\},\{2,-1,5,-4...\}\}$

We can see that this set's set's elements contains the $\mathbb{Z}$ so we can do $\mathbb{Z} / R$ which is known as the quotient set.

**Help with equivalence classes**

if $aRx$ then $x \in [a]$
