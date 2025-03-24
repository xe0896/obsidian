
**Proof that the set (0,1] in the reals is uncountable

Before we start let's establish some steps to get our desired result:

1) (0,1] $\cong \{0,1\}^{\mathbb{N}}$ 
2) $\{0,1\}^{\mathbb{N}} \cong \mathcal{P}(\mathbb{N})$ 
3) Conclude that (0,1] is uncountable as it is equinumerous to $\mathcal{P}(\mathbb{N})$ by using Cantor's theorem

Reminder that $Y^{X}$ (where both $X$ and $Y$ are sets) is the set of all functions from $X \rightarrow Y$

Proof of 1): Let's create a function $\beta$ such that $\beta: \{0,1\}^{\mathbb{N}} \rightarrow (0,1]$ and we can just deduce that this is bijective (IDK)

Proof of 2): $\alpha : \{0,1\}^{\mathbb{N}} \rightarrow \mathcal{P}(S)$ the conditions of $\alpha$ will be $(f : \mathbb{N} \rightarrow \{0,1\}) \rightarrow \{n \in \mathbb{N} \mid f(n) = 1\}$, by doing if we want to include a number from $\mathbb{N}$ we make the binary sequence include a 1 in that index, otherwise we add 0. An example of this: $\alpha(01010101...) = \{1,3,5,7,9,11,13...\}$  

Now since we create an implication between the two, then that means (0,1] is uncountable

**What is a graph?**

A graph is a pair $G = (V,E)$ where $V$ are a set of vertexes and $E$ are a set of edges 

**What is an edge?** 

There are two different types of edges, undirected and directed,

Directed edges are defined as $e = (v,w) \in E$ 
Undirected edges are defined as $e = \{v,w\} \in E$

There can also be loops as well which are seen as edges

Loops are defined as $e = v$ $w$

There are no brackets for loops as they can be confused for directed/undirected edges

The edges discussed above are given to edges that are not parallel but with edges that are parallel for example vertex $A \rightarrow B$ and $B \rightarrow A$ where the edges in this graph will be directed, they will have a multiplicity (multiple edges) of $2$ since there are two parallel edges

**What is a simple graph**

A graph is simple if it has no self loops and no multiplicity (no multiple edges) 

We can view a simple undirected graph as relations i.e $E \subseteq V \times V$, this graph is irreflexive as there are no self loops and is symmetric since it is undirected and we can go both ways with two vertexes.


