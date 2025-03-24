**What is a relation**

	A relation between A and B is a subset of A x B, which means every relation is a pair, i.e a relation is a set of pairs

**Example of a relation**

The empty relation: $R_{1} \subseteq A \times B$ where $R_{1} = \emptyset$

The total relation: $R_{2} \subseteq A \times B$ where $R_{2} = A \times B$

An example of these being used:

Let $x = \{1,2\}$, let $y = \{a,b\}$ 

$R_{1} = \emptyset$
$R_{2} = \{1,a\}, \{1.b\}, \{2,a\}, \{2,b\}$

The two above are valid relations

The equality relation: $R_{=} = \{(a,b) \vert a \in A, b \in B, a = b\}$

**What does it mean if we have a relation on A**

	If A = B, meaning if we have a subset of A x A, we call this a relation on A

**Predicates with relation

	For every predicate P we can construct a relation between sets X and Y

$$R_{P} = \{(x,y) \vert x \in X , y \in Y , P(x,y) \} $$
**Tilde relation**

	~ is seen as a notation for any operator such as <, >, =

	Let ~ = . due to latex being a RETARD

$$R_{.} =  a .b \iff (a,b) \in R_{.}$$
**Example of tilde relation being used**

$$R_{<}  \subseteq \mathbb{N}^{2}$$
$$0 < 1$$
$$(0,1) \in \mathbb{R}_{<}$$

	The order matters a = 0 and b = 1

**Composition

	Composition is when we find a relation of the output of another relation and this can be on different sets or the same set

Let $P$ = parent
Let $G$ = grandparent

$P = \{(x,y)\} \vert x$ is a parent of $y \}$

(Dave's dad, Dave) $\in P$

We can use composition to find the grandparent of Dave by using the following set builder notation

$G = \{(x,z) \vert \exists y (x,y) \in P \land (y,z) \in P \}$

x = grandparent and z = grandchild of x

(Dave's grandad/grandmother, Dave)

	The G set builder notation came from the composition set builder notation which comes from

$$S \circ R = {\{x,z} \vert  \exists y ,(x,y) \in R \land (y,z) \in S\}$$

	Composition basically has a middle ground that causes a connection in this case the connection was from the parent 

**Another example of composition

$R_{1} \subseteq A \times B$ , $R_{1} = {\ (1,T), (1,F)}$

$R_{2} \subseteq B \times C$ , $R_{2} = (T,2), (F,3)$

The $R_{2}$ relation above just picked 2 arbitrary pairs

$R_{2} \circ R_{1} = \{(1,2), (1,3)\}$

This gave us $A \times C$ and B was used as a middle ground, the connection.




