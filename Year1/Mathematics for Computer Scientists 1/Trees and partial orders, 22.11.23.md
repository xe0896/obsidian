	 
**What is a tree?**

A simple and undirected graph, that satisfies the two properties of it being connected and the other being a cyclic and being a cyclic means that the graph doesn't contain any cycles

**What is a forest?** 

A forest is a collection of trees meaning it is not connected but each individual tree without considering the other trees is a tree

**What is a root?**

A root is the starting vertex of a tree where the trees resembles some hierarchical tree for example a company or a folder within a folder.

**What is a leaf?**

A leaf in a tree is a vertex where the $deg(v) = 1$ i.e the last vertex of a tree as all other vertices will have $deg(u) > 1$

**Formula related to trees**

$|E| = |V| - 1$ 

**What is a k-colored graph**

A $G = (V,E)$ is a function $f: V \rightarrow \{1,2,3... k\}$ such that if $u$ $w \in E$ then $f(u) \neq f(w)$. In other words $G$ is an assignment of colors to the vertices of $G$ such that adjacent vertices are colored differently. 

**What are bipartite graphs?**

Bipartite graphs are graphs that are 2-colorable

**What is a complete bipartite graph?**

$K_{m,n}$ - a complete bipartite graph, with parts of sizes $m,n$ (left, right) and $(L \cup R$, $E$) where $L = \{v_{1}, v_{2}, v_{3} ... v_{m}\}$, $R = \{w_{1}, w_{2}, w_{3}... w_{n}\}$, $E = \{v_{i}w_{j} \mid 1 \leq i \leq m \land 1 \leq j \leq n\}$. In other words this shows us how many vertices that satisfy complete bipartite on the left side and the right side.

**What are partial orders?**

Partial orders are relations that are usually in the form $R_{\leq} \subseteq P \times P$ and this relation $R_{\leq}$ most satisfy these 3 properties to be considered a partial order:

If the relation is reflexive meaning: $\forall x \in P$, $x\leq x$ 
If the relation is anti-symmetric meaning: $\forall x,y \in P$, $x \leq y \land y \leq x \implies x = y$ 
If the relation is transitive meaning: $\forall x,y \in P$, $x \leq y \land y \leq z \implies x \leq z$ 

Remember that $x \leq y = (x,y) \in R_{\leq}$ 

**What is a POSET?**

A POSET is a set that is partially ordered

**What is a total order (or linear order)?**

If it is a partial order in which $\forall x,y \in P$, $x R_{\leq} y \lor y R_{\leq} x$ 

**When are elements incomparable**

if $x R_{\nleq} y \land y R_{\nleq} x$ 