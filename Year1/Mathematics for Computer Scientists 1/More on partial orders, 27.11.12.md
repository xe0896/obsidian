
**More examples of POSET's**

1) $(\mathbb{N}, \geq )$ - this is pretty self-explanatory
2) $(\mathbb{N} \setminus \{0\}$ $, \mid)$ - the expression "$\mid$" denotes the divides operation such that $x \mid y$ iff $x$ divides $y$ or such that $\exists k \in \mathbb{Z}$, $y = k \cdot x$. In the ground set we do not include $0$ since we cannot divide by $0$, and to prove that this is going to be a partial order we check for reflexivity so $x \mid x$ is possible, for anti-symmetric if $x \mid y \land y \mid x \implies x = y$ and for transitivity if $x \mid y \land y \mid z \implies x \mid z$ 

    A visual representation of this set will be like $1 \rightarrow 1, 1 \rightarrow 2, 1 \rightarrow 3 \dots 3 \rightarrow 6, 3 \rightarrow 12$ but $3 \nrightarrow 8$ meaning $3$ and $8$ are incomparable

**The least element in a POSET**

In a POSET $(P, \leq)$, $x \in P$ is the least element if $\forall y \in P, x \leq y$, then $x$ is unique

**The greatest element in a POSET**

Similar to the least element but the values are switched: if $\forall y \in P, y \leq  x$ 

**A minimal element in a POSET**

if $\nexists y \in P, y \leq x \land y \neq x$, we can simplify this further by using De-Morgan's Law $¬(p \land q) = ¬p \lor ¬q$ so then the expression now becomes $\forall y \in P, (¬y \leq x) \lor y = x$  then by using the implication identity $(¬p \lor q) = (p \implies q)$ so then now the expression becomes $\forall y \in P, (y \leq x) \implies y = x$ 

**A maximized element in a POSET**

if $\nexists y \in P, x \leq y \land y \neq x$  

**Hasse diagram**

Consider the POSET $(P, \leq)$ such that:

$x < y \iff x \leq y \land y \neq x$ - this is standard 

But with Hasse diagram we interpret this a little differently

$x \lessdot y \iff x < y \land \nexists z \in P, x < z \land z \land y$ - in other words there is nothing between the elements $x$ and $y$ i.e $z$ doesn't exist. 

To fully establish what Hasse diagrams are, the Hasse diagram of POSET $(P, \leq)$ is the di-graph (directed graph) with $P$ as vertices and $\{(x,y) \mid x \lessdot y\}$ as edges

![[Pasted image 20231218183847.png]]

**Why sometimes Hasse diagrams are not useful**

For finite orders Hasse diagram work fine but when working with infinite orders then things start to crumble for example with our $\leq$ partial order if we were to work with the $\mathbb{R}$ instead then the set will be empty since we can always find something in between two real numbers by doing $\frac{a+b}{2}$ 

**What is product ordering?**

When we have a set in the form $(\{0,1\}^{2}, \leq_{pr})$ we can compare their $\leq$ using the two pairs for example $(x_{1}, x_{2}) \leq_{pr} (y_{1}, y_{2}) \iff x_{1} \leq_{pr} y_{1} \land x_{2} \leq_{pr} y_{2}$. This can also for any $\{0,1\}^{n}$ where $n \in \mathbb{N}$ 
